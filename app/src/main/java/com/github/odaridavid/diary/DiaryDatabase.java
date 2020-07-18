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

import androidx.room.Database;
import androidx.room.RoomDatabase;

//TODO 5.Create Database

/**
 * This is the entry point to your apps persistent layer.
 * <p>
 * It is annotated with {@link Database} where you specify the entities which represent tables,
 * a version number for the current database version and provides the data access objects.
 * <p>
 * The database class is also an abstract class that has to extend the {@link RoomDatabase} class.
 *
 * Note : Any change made to your entities will require a version update so as to migrate the db.
 * We won't be looking at migrations at this point.
 */
@Database(entities = {Event.class}, version = 1)
abstract class DiaryDatabase extends RoomDatabase {

    public abstract EventDao provideEventDao();

}
