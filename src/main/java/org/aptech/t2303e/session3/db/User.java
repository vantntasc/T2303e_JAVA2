package org.aptech.t2303e.session3.db;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class User {
    private int id;
    private String username;
    private String password;
    private int status;
    private int loginFail;
    private Date createdAt;
    private Date updatedAt;
    private String createdBy;
    private String updatedBy;
}
