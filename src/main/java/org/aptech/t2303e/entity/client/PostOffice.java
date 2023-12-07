package org.aptech.t2303e.entity.client;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class PostOffice {
    @JsonProperty("TEN_TINH")
    private String province;
    @JsonProperty("TEN_QUANHUYEN")
    private String district;
    @JsonProperty("TEN_PHUONGXA")
    private String ward;
    @JsonProperty("MA_BUUCUC")
    private String postOfficeCode;
    @JsonProperty("TEN_BUUCUC")
    private String postOfficeName;
    @JsonProperty("DIA_CHI")
    private String address;
    @JsonProperty("LATITUDE")
    private String latitude;
    @JsonProperty("LONGITUDE")
    private String longtitude;
    @JsonProperty("DIEN_THOAI")
    private String phone;
    @JsonProperty("PHUTRACH")
    private String personInCharge;
    @JsonProperty("PHUTRACHPHONE")
    private String privatePhone;
}
