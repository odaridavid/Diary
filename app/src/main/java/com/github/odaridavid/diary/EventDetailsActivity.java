package com.github.odaridavid.diary;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public final class EventDetailsActivity extends AppCompatActivity {

    private int eventId;
    private TextView contentTextView, titleTextView;
    private DiaryDatabase db;
    private Event event;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_details);

        Intent detailsIntent = getIntent();
        Bundle extras = detailsIntent.getExtras();
        if (extras == null) return;

        eventId = extras.getInt(Keys.EVENT_ID.toString());

        db = InjectorUtil.provideDiaryDatabase(getApplicationContext());

        contentTextView = findViewById(R.id.content_text_view);
        titleTextView = findViewById(R.id.title_text_view);

        //TODO 12. Display specific event details
        IOExecutor.getInstance().execute(() -> {
            event = db.provideEventDao().getEvent(eventId);
            runOnUiThread(() -> {
                contentTextView.setText(event.getContent());
                titleTextView.setText(event.getTitle());
            });
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.event_details_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.action_edit) {
            Intent editIntent = new Intent(this, EditEventActivity.class);
            editIntent.putExtra(Keys.EVENT_ID.toString(), eventId);
            startActivity(editIntent);
            return true;
        } else if (item.getItemId() == R.id.action_delete) {
            //TODO 14. Delete Event Details
            IOExecutor.getInstance().execute(() -> {
                db.provideEventDao().deleteEvent(event);
                runOnUiThread(() -> {
                    Toast.makeText(getBaseContext(), R.string.info_deleted, Toast.LENGTH_LONG).show();
                    NavigationUtils.navigateToMainActivity(this);
                });
            });
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }
}
