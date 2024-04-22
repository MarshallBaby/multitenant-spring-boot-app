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