package com.github.marshallbaby.mspa.service;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import static java.lang.String.format;

@Slf4j
@Service
@RequiredArgsConstructor
public class TenantProvisioningService {

    private static final String URL_PATTERN = "https://%s-mspa.cfapps.us10-001.hana.ondemand.com";

    public String onSubscription(JsonNode requestBody) {

        return format(URL_PATTERN, requestBody.get("subscribedSubdomain").asText());
    }


}
