package org.aptech.t2303e.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.aptech.t2303e.entity.client.PostOffice;
import org.aptech.t2303e.entity.client.VPExpService;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class VPExpServiceWrapper {
    private String status;
    private boolean error;
    private String message;
    @JsonProperty("data")
    private List<VPExpService> vpExpServices;
}
