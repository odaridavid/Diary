package com.github.odaridavid.diary;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public final class MainActivity extends AppCompatActivity {

    // For simplicity purposes we will use the Dao in the activity and won't dive into
    // other architecture components and libraries that abstract this.
    private EventDao dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //TODO 8. Get EventDao Instance to have access to db
        dao = InjectorUtil.provideEventDao(getApplicationContext());
    }
}