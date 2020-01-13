package com.example.sms_email;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private String message;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button Preview=findViewById(R.id.button);
        EditText editText = findViewById(R.id.editText);
        message=editText.getText().toString();
        Preview.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                EditText editText = findViewById(R.id.editText);
                message=editText.getText().toString();
                openSecondActivity();


            }

        });
    }
    public void openSecondActivity(){

        Intent secondActivityIntent=new Intent(this,SecondActivity.class);
        secondActivityIntent.putExtra("SMS",message);
        startActivity(secondActivityIntent);
        }
        }
