package org.aptech.t2303e.service.client;

import org.aptech.t2303e.entity.client.PostOffice;
import org.aptech.t2303e.entity.client.VPLoginRes;

import java.io.IOException;
import java.util.List;

public interface VPServiceClient {
    VPLoginRes login() ;
    List<PostOffice> getPostOffice(String token);
}
