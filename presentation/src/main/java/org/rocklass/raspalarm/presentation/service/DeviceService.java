package org.rocklass.raspalarm.presentation.service;

import android.widget.Toast;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

import org.rocklass.raspalarm.presentation.RaspAlarmRemoteApplication;
import org.rocklass.raspalarm.presentation.callback.MessageCallback;
import org.rocklass.raspalarm.presentation.internal.di.components.ApplicationComponent;

import javax.inject.Inject;

/**
 * Created by rocklass on 19/05/2017.
 */

public class DeviceService extends FirebaseInstanceIdService implements MessageCallback {
    @Inject
    DeviceServiceController deviceServiceController;

    @Override
    public void onCreate() {
        super.onCreate();
        this.getApplicationComponent().inject(this);
        deviceServiceController.setMessageCallback(this);
    }

    @Override
    public void onTokenRefresh() {
        super.onTokenRefresh();
        final String refreshedToken = FirebaseInstanceId.getInstance().getToken();
        deviceServiceController.putDevice(refreshedToken);
    }

    public void showMessage(final String message) {
        Toast.makeText(DeviceService.this, message, Toast.LENGTH_LONG).show();
    }

    protected ApplicationComponent getApplicationComponent() {
        return ((RaspAlarmRemoteApplication) getApplication()).getApplicationComponent();
    }
}
