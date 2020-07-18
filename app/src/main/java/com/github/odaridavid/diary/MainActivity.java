package com.github.odaridavid.diary;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public final class MainActivity extends AppCompatActivity {

    // For simplicity purposes we will create the database in the activity and won't dive into
    // other architecture components and libraries.
    private DiaryDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //TODO 7.Create Database Instance
        db = InjectorUtil.provideDiaryDatabase(getApplicationContext());
    }

    @Override
    protected void onResume() {
        super.onResume();
        //TODO 10. Display Items from database
        //Run database transactions in a background thread so as not to block the main thread
        //If you do so the app will crash and Room will also not allow you to do that.
        IOExecutor
                .getInstance()
                .execute(() -> {
                            List<Event> events = db.provideEventDao().getAllEvents();
                            runOnUiThread(() -> {
                                if (events.size() > 0) {
                                    TextView noEventsTextView = findViewById(R.id.no_events_text_view);
                                    noEventsTextView.setVisibility(View.GONE);

                                    RecyclerView eventsRecyclerView = findViewById(R.id.events_recycler_view);
                                    eventsRecyclerView.setVisibility(View.VISIBLE);

                                    EventRecyclerAdapter eventRecyclerAdapter = new EventRecyclerAdapter(this::navigateToDetailsActivity);
                                    eventRecyclerAdapter.setEvents(events);
                                    eventsRecyclerView.setAdapter(eventRecyclerAdapter);
                                }
                            });
                        }
                );
    }

    private void navigateToDetailsActivity(int eventId) {
        Intent viewEventDetailsIntent = new Intent(this, EventDetailsActivity.class);
        viewEventDetailsIntent.putExtra(Keys.EVENT_ID.toString(), eventId);
        startActivity(viewEventDetailsIntent);
    }

    public void navigateToAddEvent(View view) {
        Intent newEventIntent = new Intent(this, AddEventActivity.class);
        startActivity(newEventIntent);
    }
}