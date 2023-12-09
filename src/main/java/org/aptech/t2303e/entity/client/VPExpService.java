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
public class VPExpService {
    private int type;
    @JsonProperty("SERVICE_CODE")
    private String serviceCode;
    @JsonProperty("SERVICE_NAME")
    private String serviceName;
    @JsonProperty("DESCRIPTION")
    private String description;
}
