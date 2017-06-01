package org.rocklass.raspalarm.data.repository.datasource;

import org.rocklass.raspalarm.data.entity.DeviceEntity;
import org.rocklass.raspalarm.data.net.DeviceRestApi;

import io.reactivex.Observable;

/**
 * {@link DeviceDataStore} implementation based on connections to the api (Cloud).
 */
class CloudDeviceDataStore implements DeviceDataStore {

    private final DeviceRestApi deviceRestApi;

    /**
     * Construct a {@link DeviceDataStore} based on connections to the api (Cloud).
     *
     * @param deviceRestApi   The {@link DeviceRestApi} implementation to use.
     */
    CloudDeviceDataStore(final DeviceRestApi deviceRestApi) {
        this.deviceRestApi = deviceRestApi;
    }

    @Override
    public Observable<DeviceEntity> deviceEntity(final String token) {
        return this.deviceRestApi.putDevice(new DeviceEntity(token));
    }
}
