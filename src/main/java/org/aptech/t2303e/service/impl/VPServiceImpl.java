package org.aptech.t2303e.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.aptech.t2303e.entity.client.PostOffice;
import org.aptech.t2303e.entity.client.VPLoginRes;
import org.aptech.t2303e.service.VPService;
import org.aptech.t2303e.service.client.VPServiceClient;
import org.aptech.t2303e.service.client.impl.VPServiceClientImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class VPServiceImpl implements VPService {
    VPServiceClient serviceClient;
    public VPServiceImpl() {
        serviceClient = new VPServiceClientImpl();
    }

    public static void main(String[] args) {
        VPService vpService = new VPServiceImpl();
        vpService.syncVPData();
    }
    @Override
    public void syncVPData() {
        // login
        VPLoginRes loginRes = serviceClient.login();
        if(loginRes != null && loginRes.getStatus().equalsIgnoreCase("200")){
            // login success -> load data
            List<PostOffice> postOfficeList = serviceClient.getPostOffice(loginRes.getData().getToken());
            System.err.println(postOfficeList);
            List<PostOffice> hanoiPostOffice = postOfficeList.stream().filter(item  -> checkInHanoi(item)).collect(Collectors.toList());
//            for (PostOffice postOffice : postOfficeList){
//                if( !StringUtils.isEmpty(postOffice.getProvince()) && postOffice.getProvince().equalsIgnoreCase("Hà Nội")){
//                    hanoiPostOffice.add(postOffice);
//                }
//            }
//            System.err.println(hanoiPostOffice.size());
//            System.err.println(hanoiPostOffice);
        }

    }
    boolean checkInHanoi(PostOffice item ){
        return !StringUtils.isEmpty(item.getProvince()) && item.getProvince().equalsIgnoreCase("Hà Nội");
    }
}
