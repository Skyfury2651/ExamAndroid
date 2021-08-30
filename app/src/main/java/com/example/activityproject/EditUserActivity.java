package com.example.activityproject;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EditUserActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btDone;
    private EditText edUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_user);
        edUser = (EditText) findViewById(R.id.edUser);
        btDone = (Button) findViewById(R.id.btDone);
        btDone.setOnClickListener(this);

        Intent intent = getIntent();
        String username = intent.getStringExtra("USER_NAME");
        edUser.setText(username);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btDone:
                onDone();
                break;
            default:
                break;
        }
    }

    private void onDone() {
        Intent returnIntent = new Intent();
        returnIntent.putExtra("RESULT", edUser.getText().toString());
        setResult(Activity.RESULT_OK, returnIntent);
        finish();
    }
}