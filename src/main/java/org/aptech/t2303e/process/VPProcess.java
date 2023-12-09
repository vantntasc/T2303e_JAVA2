package org.aptech.t2303e.process;

import org.aptech.t2303e.service.VPService;

public class VPProcess  extends Thread{
    // get data from vp after 5 minutes
    long lastVpSyncTime;
    VPService vpService;
    public VPProcess(String threadName,VPService vpService) {
        this.setName(threadName);
        this.lastVpSyncTime = System.currentTimeMillis();
        this.vpService = vpService;
    }

    @Override
    public void run() {
        try {
            while (true){
                System.err.println("Process "+ this.getName()+" is running");
                if(System.currentTimeMillis() - lastVpSyncTime > 300000){
                    // sync data from vp here
                    lastVpSyncTime = System.currentTimeMillis();
                }
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
