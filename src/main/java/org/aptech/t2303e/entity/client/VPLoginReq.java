package org.aptech.t2303e.entity.client;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class VPLoginReq {
    @JsonProperty("USERNAME")
    private String username;
    @JsonProperty("PASSWORD")
    private String password;
}
