package org.aptech.t2303e.config.properties;

import lombok.Data;
import org.aptech.t2303e.annotations.ConfigurationProperties;
import org.aptech.t2303e.annotations.Value;

@ConfigurationProperties
@Data
public class VietelPostApiProperties {
    @Value("api.path.viettel-post.base-url")
    private String baseUrl;
    @Value("api.path.viettel-post.login")
    private String loginUrl;
    @Value("api.path.viettel-post.get-list-post-office")
    private String getPostOfficeUrl;
    @Value("api.path.viettel-post.username")
    private String username;
    @Value("api.path.viettel-post.password")
    private String password;
}
