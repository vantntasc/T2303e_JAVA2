package org.aptech.t2303e.service.client.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aptech.t2303e.config.properties.VietelPostApiProperties;
import org.aptech.t2303e.entity.VPExpServiceWrapper;
import org.aptech.t2303e.entity.VpExServiceReq;
import org.aptech.t2303e.entity.client.*;
import org.aptech.t2303e.service.client.VPServiceClient;
import org.aptech.t2303e.utils.ConfigurationUtils;
import org.aptech.t2303e.utils.RestUtils;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import java.io.IOException;
import java.util.List;

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
    public VPLoginRes login() {
        try {
            String url = apiProps.getBaseUrl() + apiProps.getLoginUrl();
            VPLoginReq resquest = VPLoginReq.builder()
                    .username(apiProps.getUsername())
                    .password(apiProps.getPassword())
                    .build();
            ResponseEntity<?> response = restUtils.send(url, HttpMethod.POST, resquest, VPLoginRes.class);
            return (VPLoginRes) response.getBody();
        } catch (Exception e) {
            logger.error("Error : ",e.getMessage(),e);
            return null;
        }
    }

    @Override
    public List<PostOffice> getPostOffice(String token) {
        String url = apiProps.getBaseUrl() + apiProps.getGetPostOfficeUrl();
        ResponseEntity<?> response = restUtils.send(token, url, HttpMethod.GET, PostOfficeResWrapper.class);
        PostOfficeResWrapper postOfficeResWrapper = (PostOfficeResWrapper) response.getBody();
        if (postOfficeResWrapper != null) {
            return postOfficeResWrapper.getPostOffices();
        }
        return null;
    }

    @Override
    public List<VPExpService> getListService(int type) {
        String url  = apiProps.getBaseUrl() + apiProps.getGetListServiceUrl();
        // set body
        VpExServiceReq request = VpExServiceReq.builder()
                .type(type)
                .build();
        ResponseEntity<?> response = restUtils.send(url, HttpMethod.POST, request,VPExpServiceWrapper.class);
        VPExpServiceWrapper vpExpServiceWrapper = (VPExpServiceWrapper) response.getBody();
        if (vpExpServiceWrapper != null) {
            return vpExpServiceWrapper.getVpExpServices();
        }
        return null;
    }
}
