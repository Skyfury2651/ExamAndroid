package com.example.activityproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{
    private EditText edPassword;
    private EditText edUser;
    private Button btLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        edUser = (EditText)findViewById(R.id.edUser);
        edPassword = (EditText)findViewById(R.id.edPassword);
        btLogin = (Button)findViewById(R.id.btLogin);
        btLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btLogin:
                onLogin();
                break;
            default:
                break;
        }
    }

    private void onLogin(){
        if (edUser.getText().toString().isEmpty() || edPassword.getText().toString().isEmpty()) {
            Toast.makeText(this, "Bạn chưa nhập user hoặc password", Toast.LENGTH_SHORT).show();
        }else {
            Intent intent = new Intent(this, ProfileActivity.class);
            intent.putExtra("Username", edUser.getText().toString());
            startActivity(intent);
        }
    }
}