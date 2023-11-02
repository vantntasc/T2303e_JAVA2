package org.aptech.t2303e.session3.db;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class User {
    private int id;
    private String username;
    private String password;
}
