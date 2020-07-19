package com.github.odaridavid.diary;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.google.android.material.snackbar.Snackbar;

import java.util.Date;

public final class AddEventActivity extends AppCompatActivity {

    private EditText titleEditText, contentEditText;
    private ConstraintLayout addEventLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_event);
        titleEditText = findViewById(R.id.title_edit_text);
        contentEditText = findViewById(R.id.content_edit_text);
        addEventLayout = findViewById(R.id.add_event_layout);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.add_event_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.action_update) {

            String title = titleEditText.getText().toString();
            String content = contentEditText.getText().toString();

            if (title.isEmpty() || content.isEmpty()) {

                Snackbar.make(addEventLayout, R.string.error_empty_fields, Snackbar.LENGTH_SHORT).show();

            } else {
                //TODO 11. Save Items
                final Event event = new Event(title, content, new Date().toString());
                EventDao dao = InjectorUtil.provideEventDao(getApplicationContext());
                IOExecutor.getInstance().execute(() -> dao.insertEvent(event));
                Snackbar.make(addEventLayout, R.string.info_saved, Snackbar.LENGTH_SHORT).show();
                NavigationUtils.navigateToMainActivity(this);

            }
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }
}