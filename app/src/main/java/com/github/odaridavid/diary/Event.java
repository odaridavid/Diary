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

import java.util.Date;
import java.util.Objects;

//TODO 2. Create model class for an Event containing the event information
final class Event {

    private String title;
    private String content;
    private String timestamp;
    private int id;

    //Default Constructor
    Event() {
        this.title = null;
        this.content = null;
        this.timestamp = new Date().toString();
        this.id = -1;
    }

    Event(String title, String content, String timestamp, int id) {
        this.title = title;
        this.content = content;
        this.timestamp = timestamp;
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Event{" +
                "title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", timestamp='" + timestamp + '\'' +
                ", id=" + id +
                '}';
    }

    @Override
    public boolean equals(Object that) {

        if (this == that) return true;

        if (that == null || getClass() != that.getClass()) return false;

        Event vThatEvent = (Event) that;

        return this.getId() == vThatEvent.getId() &&
                this.getTitle().equals(vThatEvent.getTitle()) &&
                Objects.equals(this.getContent(), vThatEvent.getContent()) &&
                this.getTimestamp().equals(vThatEvent.getTimestamp());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTitle(), getContent(), getTimestamp(), getId());
    }
}
