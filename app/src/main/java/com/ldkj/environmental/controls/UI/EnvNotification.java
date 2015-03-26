package com.ldkj.environmental.controls.UI;

import android.app.Notification;

/**
 * Created by john on 15-3-26.
 */
public class EnvNotification extends Notification{
    private String message;


    public EnvNotification(String message){
        this.message = message;
    }

}
