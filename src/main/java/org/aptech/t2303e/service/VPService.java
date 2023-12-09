package org.aptech.t2303e.service;

import org.aptech.t2303e.entity.client.PostOffice;
import org.aptech.t2303e.entity.client.VPExpService;

import java.util.List;

public interface VPService {
    List<PostOffice> getVPPostOffice();
    List<VPExpService> getListVPExpService();
}
