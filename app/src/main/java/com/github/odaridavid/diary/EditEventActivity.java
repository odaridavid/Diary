package com.github.odaridavid.diary;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.google.android.material.snackbar.Snackbar;

import java.util.Date;

public final class EditEventActivity extends AppCompatActivity {

    private int eventId;
    private EditText editTitleEditText, editContentEditText;
    private ConstraintLayout editEventLayout;
    private EventDao dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_event);

        Intent editIntent = getIntent();
        Bundle extras = editIntent.getExtras();
        if (extras == null) return;

        eventId = extras.getInt(Keys.EVENT_ID.toString());

        dao = InjectorUtil.provideEventDao(getApplicationContext());

        editTitleEditText = findViewById(R.id.edit_title_edit_text);
        editContentEditText = findViewById(R.id.edit_content_edit_text);
        editEventLayout = findViewById(R.id.edit_event_layout);

        IOExecutor.getInstance().execute(() -> {
            Event event = dao.getEvent(eventId);
            runOnUiThread(() -> {
                editContentEditText.setText(event.getContent());
                editTitleEditText.setText(event.getTitle());
            });
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.edit_event_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.action_update) {

            String title = editTitleEditText.getText().toString();
            String content = editContentEditText.getText().toString();

            if (title.isEmpty() || content.isEmpty()) {

                Snackbar.make(editEventLayout, R.string.error_empty_fields, Snackbar.LENGTH_SHORT).show();

            } else {
                //TODO 17. Edit event details
                final Event event = new Event(title, content, new Date().toString());
                event.setId(eventId);
                IOExecutor.getInstance().execute(() -> dao.updateEvent(event));
                Snackbar.make(editEventLayout, R.string.info_saved, Snackbar.LENGTH_SHORT).show();
                NavigationUtils.navigateToMainActivity(this);
            }
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }
}