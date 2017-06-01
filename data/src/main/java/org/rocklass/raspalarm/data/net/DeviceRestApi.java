package org.rocklass.raspalarm.data.net;

import org.rocklass.raspalarm.data.entity.DeviceEntity;
import org.rocklass.raspalarm.data.entity.UserEntity;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.PUT;
import retrofit2.http.Path;

/**
 * RestApi for retrieving data from the network.
 */
public interface DeviceRestApi {
    /**
     * Api url for getting all users
     */
    String API_URL_DEVICE = "/device/";

    @PUT(API_URL_DEVICE)
    Observable<DeviceEntity> putDevice(final @Field("token") String token);
}
