/*
 *
 * Copyright 2020 David Odari
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 *          http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 *
 */
package com.github.odaridavid.diary;

import android.content.Context;

import androidx.room.Room;

//TODO 6. Create Injector Class for Database

/**
 * This provides us with the database and dao dependency,this tries to emulate what a
 * Dependency Injection Pattern or framework would achieve.
 * <p>
 */
final class InjectorUtil {

    private InjectorUtil() {
    }

    /**
     * Builds an instance of the database for the application.
     */
    private static DiaryDatabase provideDiaryDatabase(Context context) {
        String DIARY_DATABASE_NAME = "diary_db";
        return Room
                .databaseBuilder(
                        context,
                        DiaryDatabase.class,
                        DIARY_DATABASE_NAME
                )
                .build();
    }

    /**
     *Convenience method for getting an instance of the dao from the activity.
     */
    public static EventDao provideEventDao(Context context) {
        //TODO 7.Create Database Instance
        DiaryDatabase db = provideDiaryDatabase(context);
        return db.provideEventDao();
    }
}
