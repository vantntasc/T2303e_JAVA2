package org.aptech.t2303e.process;

import org.aptech.t2303e.entity.client.VPExpService;
import org.aptech.t2303e.service.client.VPServiceClient;

import java.util.List;
import java.util.concurrent.Callable;

public class CallableWorker implements Callable<List<VPExpService>> {
    private final int serviceType;
    private VPServiceClient vpServiceClient;

    public CallableWorker(int serviceType, VPServiceClient vpServiceClient) {
        this.serviceType = serviceType;
        this.vpServiceClient = vpServiceClient;
    }

    @Override
    public List<VPExpService> call() throws Exception {
        return vpServiceClient.getListService(serviceType);
    }
}
