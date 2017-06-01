package org.rocklass.raspalarm.data.repository;

import org.rocklass.raspalarm.data.entity.mapper.DeviceEntityDataMapper;
import org.rocklass.raspalarm.data.entity.mapper.UserEntityDataMapper;
import org.rocklass.raspalarm.data.repository.datasource.DeviceDataStore;
import org.rocklass.raspalarm.data.repository.datasource.DeviceDataStoreFactory;
import org.rocklass.raspalarm.domain.Device;
import org.rocklass.raspalarm.domain.repository.DeviceRepository;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;

/**
 * {@link DeviceRepository} for retrieving device data.
 */
@Singleton
public class DeviceDataRepository implements DeviceRepository {

    private final DeviceDataStoreFactory deviceDataStoreFactory;
    private final DeviceEntityDataMapper deviceEntityDataMapper;

    /**
     * Constructs a {@link DeviceRepository}.
     *
     * @param deviceDataStoreFactory A factory to construct different data source implementations.
     * @param deviceEntityDataMapper {@link UserEntityDataMapper}.
     */
    @Inject
    DeviceDataRepository(final DeviceDataStoreFactory deviceDataStoreFactory,
                         final DeviceEntityDataMapper deviceEntityDataMapper) {
        this.deviceDataStoreFactory = deviceDataStoreFactory;
        this.deviceEntityDataMapper = deviceEntityDataMapper;
    }

    @Override
    public Observable<Device> device(final String token) {
        final DeviceDataStore deviceDataStore = this.deviceDataStoreFactory.create();
        return deviceDataStore.deviceEntity(token).map(this.deviceEntityDataMapper::transform);
    }
}
