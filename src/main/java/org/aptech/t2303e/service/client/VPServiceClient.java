package org.aptech.t2303e.service.client;

import org.aptech.t2303e.entity.client.VPLoginRes;

import java.io.IOException;

public interface VPServiceClient {
    VPLoginRes login(String username, String password) ;
}
