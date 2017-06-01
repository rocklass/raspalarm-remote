package org.rocklass.raspalarm.data.repository.datasource;

import android.support.annotation.NonNull;

import org.rocklass.raspalarm.data.net.DeviceRestApi;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Factory that creates different implementations of {@link DeviceDataStore}.
 */
@Singleton
public class DeviceDataStoreFactory {

    private final DeviceRestApi deviceRestApi;

    @Inject
    DeviceDataStoreFactory(@NonNull DeviceRestApi deviceRestApi) {
        this.deviceRestApi = deviceRestApi;
    }

    /**
     * Create {@link DeviceDataStore}.
     */
    public DeviceDataStore create() {
        return createCloudDataStore();
    }

    /**
     * Create {@link DeviceDataStore} to retrieve data from the Cloud.
     */
    public DeviceDataStore createCloudDataStore() {
        return new CloudDeviceDataStore(deviceRestApi);
    }
}
