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

import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

//TODO 4. Create Event Data Access Object (DAO)

/**
 * A data access object acts as a middle man for communication between your ui layer and the database.
 * Bringing about the concept of separation of concerns,by encapsulating the queries you'll be using
 * for each request.
 * That also makes testing easier.
 */
interface EventDao {

    /**
     * The insert annotation handles insertion database transactions ,it will insert the event
     * field values in their respective columns and result in a new row being created.
     *
     * @param event event being inserted to event table.
     */
    @Insert
    void insertEvent(Event event);

    /**
     * The update annotation handles updating an entries values by matching the primary key of
     * given entity to be updated against all entities in the table.
     *
     * If a match is found then that row will be updated.
     *
     * @param event event with updated values
     */
    @Update
    void updateEvent(Event event);

    /**
     * The Delete annotation  handles deleting entries in a table,it also uses the primary key
     * to delete the right entry.
     *
     * @param event event to be removed from the table
     */
    @Delete
    void deleteEvent(Event event);

    /**
     * The Query annotation takes in an SQL statement to execute against your table.
     * It is verified at compile time,meaning it has support for autocompletion of things like
     * generated table name and all errors made in the query will throw a compile time error,that is
     * before you even run the app ,during project builds.You can read more on other benefits this brings.
     *
     * @return a list of all events in the event table
     */
    @Query("SELECT * FROM event")
    List<Event> getAllEvents();

    /**
     * This Query annotation deals with query parameters.The id of the event will change with
     * for different events.Using query parameters can be helpful for scenarios such as filtering
     * or getting a specific entity from a table.
     *
     * @param id id of interest,identifies the entry we are interested in
     * @return a matching event with the given id
     */
    @Query("SELECT * FROM event WHERE id=:id")
    Event getEvent(int id);

}
