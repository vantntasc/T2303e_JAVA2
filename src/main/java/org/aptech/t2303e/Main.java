package org.aptech.t2303e;

import org.aptech.t2303e.lombok.Student;
import org.aptech.t2303e.process.VPProcess;
import org.aptech.t2303e.service.VPService;
import org.aptech.t2303e.service.impl.VPServiceImpl;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        VPService vpService = new VPServiceImpl();
        VPProcess vpThread = new VPProcess("ViettelPost-Process",vpService);
        vpThread.start();
    }
}