package org.rocklass.raspalarm.data.entity;

import com.google.gson.annotations.SerializedName;

/**
 * Device Entity used in the data layer.
 */
public class DeviceEntity {

    @SerializedName ("token")
    private String token;

    public DeviceEntity() {
        //empty
    }

    public DeviceEntity(final String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }
}
