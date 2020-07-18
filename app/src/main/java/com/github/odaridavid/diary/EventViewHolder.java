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

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/**
 * Viewholder that handles binding of data for each item to the view.
 */
final class EventViewHolder extends RecyclerView.ViewHolder {

    private TextView eventTitleTextView, eventContentOverviewTextView;

    public EventViewHolder(@NonNull View itemView) {
        super(itemView);
        eventTitleTextView = itemView.findViewById(R.id.event_title_text_view);
        eventContentOverviewTextView = itemView.findViewById(R.id.event_content_overview_text_view);
    }

    public void bind(Event event) {
        eventTitleTextView.setText(event.getTitle());
        eventContentOverviewTextView.setText(event.getContent());
    }

}
