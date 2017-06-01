package org.rocklass.raspalarm.data.net;

import org.rocklass.raspalarm.data.entity.DeviceEntity;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.PUT;

import static org.rocklass.raspalarm.data.net.RestApi.ACCEPT_APPLICATION_JSON;
import static org.rocklass.raspalarm.data.net.RestApi.CONTENT_TYPE_JSON;

/**
 * RestApi for retrieving data from the network.
 */
public interface DeviceRestApi {
    /**
     * Api url for getting all devices
     */
    String API_URL_DEVICE = "/device/";

    @Headers ({ACCEPT_APPLICATION_JSON, CONTENT_TYPE_JSON})
    @PUT (API_URL_DEVICE)
    Observable<DeviceEntity> putDevice(final @Body DeviceEntity device);
}
