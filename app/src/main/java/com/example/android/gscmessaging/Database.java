package com.example.android.gscmessaging;

import com.firebase.client.Firebase;

/**
 * Created by hp on 06-Aug-17.
 */

public class Database extends android.app.Application {
    @Override
    public void onCreate(){
        super.onCreate();
        Firebase.setAndroidContext( this );
    }
}
