package org.rocklass.raspalarm.domain.interactor;

import com.fernandocejas.arrow.checks.Preconditions;

import org.rocklass.raspalarm.domain.Device;
import org.rocklass.raspalarm.domain.executor.PostExecutionThread;
import org.rocklass.raspalarm.domain.executor.ThreadExecutor;
import org.rocklass.raspalarm.domain.repository.DeviceRepository;

import javax.inject.Inject;

import io.reactivex.Observable;

/**
 * This class is an implementation of {@link UseCase} that represents a use case for
 * retrieving data related to an specific {@link Device}.
 */
public class PutDevice extends UseCase<Device, PutDevice.Params> {

    private final DeviceRepository deviceRepository;

    @Inject
    PutDevice(DeviceRepository deviceRepository, ThreadExecutor threadExecutor,
              PostExecutionThread postExecutionThread) {
        super(threadExecutor, postExecutionThread);
        this.deviceRepository = deviceRepository;
    }

    @Override
    Observable<Device> buildUseCaseObservable(Params params) {
        Preconditions.checkNotNull(params);
        return this.deviceRepository.device(params.token);
    }

    public static final class Params {

        private final String token;

        private Params(final String token) {
            this.token = token;
        }

        public static Params forDevice(final String token) {
            return new Params(token);
        }
    }
}
