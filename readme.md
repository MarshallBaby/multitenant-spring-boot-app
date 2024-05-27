# Multi-tenant Spring Boot App

This repository contains an example of Spring Boot Application with implementation of:
1. XSUAA security integration
2. Multitenancy: Tenant-onboarding, Schema-Per-Tenant data Isolation
3. SAP HANA Cloud integration
4. MTA-based configuration
5. Liquibase integration

## Deployment process
### 1. Preparation
MTA Applications are delivered to SAP BTP platform as a *.mtar*  archive<br><br>
First of all you need to install ```multiapps``` plugin to CF CLI tool.
```
cf add-plugin-repo CF-Community https://plugins.cloudfoundry.org
cf install-plugin multiapps
```
and install mbt plugin
```
npm install -g mbt
```

### 2. Build .mtar archive
Perform ```mbt build``` in the root folder of repository. Resulting archive should be placed in ```mta_archives``` 
directory.

### 3. Deployment
Perform ```cf deploy <path_to_mtar_file>``` command.

### 4. Following the deployment
The process and result of deployment process will be logged into the console.
If something went wrong, the most convenient way to find an issue is to look into the logs of deployed application.

## Configuring SAP HANA Cloud
To allow application to perform multitenant logic you should provide used of deployed permission to manage schemas.
You can find the user in binding of deployed application.

Perform this query in Database Explorer:
```GRANT CREATE SCHEMA TO <username>```

## Configuring routes
Each application consumer requires route to be configured:<br>
```cf map-route <app-name> cfapps.us10-001.hana.ondemand.com --hostname <subaccount-subdomaint>-<app-name>```<br>
[source](https://developers.sap.com/tutorials/cp-cf-security-xsuaa-multi-tenant.html#3d9c3cb3-78a0-4f51-af31-df3af1dab9ca)


## Troubleshooting

#### Unable to instantiate JwtDecoder bean
JwtDecoder bean requires RestOperations bean to be available in the context.
RestOperations requires *htppclient5* dependency which can be not provided automatically.

```java
@Bean
	@ConditionalOnMissingBean
	@ConditionalOnClass(name = "org.apache.hc.client5.http.impl.classic.CloseableHttpClient")
	@ConditionalOnBean(XsuaaServiceConfiguration.class)
	public RestOperations xsuaaMtlsRestOperations(XsuaaServiceConfiguration xsuaaServiceConfiguration) {
		return SpringHttpClientFactory.createRestTemplate(xsuaaServiceConfiguration.getClientIdentity());
	}
```

To fix this add to pom.xml:
```xml
<dependency>
    <groupId>org.apache.httpcomponents.client5</groupId>
    <artifactId>httpclient5</artifactId>
    <version>5.3.1</version>
</dependency>
```