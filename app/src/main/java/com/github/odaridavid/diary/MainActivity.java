package com.github.odaridavid.diary;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public final class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // For simplicity purposes we will create the database in the activity and won't dive into
        // other architecture components and libraries such as coroutines,rxjava ,viewmodel and
        // livedata or any DI framework.
        setContentView(R.layout.activity_main);

        //TODO 7.Create Database Instance
        DiaryDatabase db = InjectorUtil.provideDiaryDatabase(getApplicationContext());
    }
}