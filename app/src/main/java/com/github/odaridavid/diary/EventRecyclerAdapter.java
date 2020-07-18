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

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

/**
 * Recycler view adapter class used to bind data to the recycler view.
 */
final class EventRecyclerAdapter extends RecyclerView.Adapter<EventViewHolder> {

    private List<Event> events;
    private OnEventClickedListener onEventClickedListener;

    public EventRecyclerAdapter(OnEventClickedListener onEventClickedListener) {
        this.onEventClickedListener = onEventClickedListener;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public EventViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.item_event, parent, false);
        return new EventViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull EventViewHolder holder, int position) {
        holder.bind(events.get(position));
        holder.itemView.setOnClickListener(view -> {
            int eventId = events.get(position).getId();
            onEventClickedListener.onClick(eventId);
        });
    }

    @Override
    public int getItemCount() {
        return events.size();
    }
}
