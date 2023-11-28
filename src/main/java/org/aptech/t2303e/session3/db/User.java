package org.aptech.t2303e.session3.db;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.aptech.t2303e.json.CustomDateSerializer;
import org.aptech.t2303e.json.CustomDeserializer;
import org.aptech.t2303e.json.Profile;

import java.util.Date;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class User {
    private int id;
    private String username;
    @JsonIgnore
    private String password;
    private int status;
    private int loginFail;
    @JsonSerialize(using = CustomDateSerializer.class)
    @JsonDeserialize(using = CustomDeserializer.class)
    private Date createdAt;
    private Date updatedAt;
    private String createdBy;
    private String updatedBy;
    List<Profile> profiles;
}
