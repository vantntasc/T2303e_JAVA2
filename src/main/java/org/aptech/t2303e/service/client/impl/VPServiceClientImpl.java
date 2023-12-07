package org.aptech.t2303e.service.client.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aptech.t2303e.config.properties.VietelPostApiProperties;
import org.aptech.t2303e.entity.client.VPLoginReq;
import org.aptech.t2303e.entity.client.VPLoginRes;
import org.aptech.t2303e.service.client.VPServiceClient;
import org.aptech.t2303e.utils.ConfigurationUtils;
import org.aptech.t2303e.utils.RestUtils;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import java.io.IOException;

public class VPServiceClientImpl  implements VPServiceClient {
    private static Logger logger = LogManager.getLogger(VPServiceClientImpl.class);
    RestUtils restUtils;
    VietelPostApiProperties apiProps;

    public VPServiceClientImpl() {
        this.restUtils = new RestUtils();
        apiProps = new VietelPostApiProperties();
        try {
            apiProps = (VietelPostApiProperties) ConfigurationUtils.readConfig(apiProps);
        } catch (Exception e) {
            logger.error("Error : ",e.getMessage(),e);
        }
    }
    @Override
    public VPLoginRes login(String username, String password) {
        try {
            String url = apiProps.getBaseUrl() + apiProps.getLoginUrl();
            VPLoginReq resquest = VPLoginReq.builder()
                    .username(username)
                    .password(password)
                    .build();
            ResponseEntity<?> response = restUtils.send(url, HttpMethod.POST, resquest, VPLoginRes.class);
            return (VPLoginRes) response.getBody();
        } catch (Exception e) {
            logger.error("Error : ",e.getMessage(),e);
            return null;
        }
    }
}
