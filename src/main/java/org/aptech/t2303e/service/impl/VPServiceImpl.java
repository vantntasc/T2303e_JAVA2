package org.aptech.t2303e.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.aptech.t2303e.entity.client.PostOffice;
import org.aptech.t2303e.entity.client.VPExpService;
import org.aptech.t2303e.entity.client.VPLoginRes;
import org.aptech.t2303e.entity.consts.VPServiceType;
import org.aptech.t2303e.service.VPService;
import org.aptech.t2303e.service.client.VPServiceClient;
import org.aptech.t2303e.service.client.impl.VPServiceClientImpl;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.stream.Collectors;

public class VPServiceImpl implements VPService {
    VPServiceClient serviceClient;
    public VPServiceImpl() {
        serviceClient = new VPServiceClientImpl();
    }
    @Override
    public List<PostOffice>  getVPPostOffice() {
        // login
        VPLoginRes loginRes = serviceClient.login();
        if(loginRes != null && loginRes.getStatus().equalsIgnoreCase("200")){
            // login success -> load data
            List<PostOffice> postOfficeList = serviceClient.getPostOffice(loginRes.getData().getToken());
//            List<PostOffice> hanoiPostOffice = postOfficeList.stream().filter(item  -> checkInHanoi(item)).collect(Collectors.toList());
            return postOfficeList;
        }
        return null;
    }

    public static void main(String[] args) {
        VPService obj  = new VPServiceImpl();
        obj.getListVPExpService();
    }
    @Override
    public List<VPExpService> getListVPExpService() {
        // call api follow to service
        EnumSet.allOf(VPServiceType.class).stream().forEach(item  -> {

        });
        return null;
    }
    // getListService
    // type : 1,2,3,4,5

    boolean checkInHanoi(PostOffice item ){
        return !StringUtils.isEmpty(item.getProvince()) && item.getProvince().equalsIgnoreCase("Hà Nội");
    }
}
