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
 * This provides us with the database dependency,this tries to emulate what a
 * Dependency Injection Pattern or framework would achieve.
 * <p>
 * If you are not familiar with the Dependency Injection Pattern ,links to extra resources are in the readme.
 */
final class InjectorUtil {

    private InjectorUtil() {
    }

    /**
     * Builds an instance of the database for the application.
     */
    public static DiaryDatabase provideDiaryDatabase(Context context) {
        String DIARY_DATABASE_NAME = "diary_db";
        return Room
                .databaseBuilder(
                        context,
                        DiaryDatabase.class,
                        DIARY_DATABASE_NAME
                )
                .build();
    }
}
