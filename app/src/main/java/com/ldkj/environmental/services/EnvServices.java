package com.ldkj.environmental.services;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class EnvServices extends Service {
    public EnvServices() {
    }

    @Override
    public IBinder onBind(Intent intent) {

        throw new UnsupportedOperationException("Not yet implemented");
    }
}
