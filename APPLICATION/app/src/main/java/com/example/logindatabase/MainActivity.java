package com.example.logindatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText UsernameEt, PasswordEt;
    //ProgressBar progressbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        UsernameEt = (EditText) findViewById(R.id.name);
        PasswordEt = (EditText) findViewById(R.id.password);
        //progressbar = (ProgressBar) findViewById(R.id.my_progressBar);
    }

    public void OnLogin(View view) {
        String username = UsernameEt.getText().toString();
        String password = PasswordEt.getText().toString();
        if(!username.equals("") && !password.equals("")) {
            String type = "login";
            BackgroundWorker backgroundWorker = new BackgroundWorker(this);
            backgroundWorker.execute(type, username, password);
            System.out.print("Main activity: "+backgroundWorker.result);

        }
        else Toast.makeText(this,"Inserire dati", Toast.LENGTH_LONG).show();
    }
}