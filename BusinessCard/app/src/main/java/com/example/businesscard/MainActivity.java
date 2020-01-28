package com.example.businesscard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private String message;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button sendMessage=findViewById(R.id.button);
        ImageButton Instagram=findViewById(R.id.instagram);
        ImageButton Twitter=findViewById(R.id.twitter);
        EditText editText = findViewById(R.id.editText);
        message=editText.getText().toString();
        Instagram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent=new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.instagram.com/thisisbillgates"));
                startActivity(browserIntent);
            }
        });
        sendMessage.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                EditText editText = findViewById(R.id.editText);
                message=editText.getText().toString();
                sendMail(message);
            }

        });
        Twitter.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent browserIntent=new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.twitter.com/billgates"));
                startActivity(browserIntent);
            }

        });
    }
    private void sendMail(String message){
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_TEXT,message);
        intent.setType("message/rfc822");
        if (intent.resolveActivity(getPackageManager()) != null) {
            Context context = getApplicationContext();
            CharSequence text = "Всё работает";
            int duration = Toast.LENGTH_LONG;
            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
            startActivity(Intent.createChooser(intent, "Choose an email client"));
        }
        else {
            Context context = getApplicationContext();
            CharSequence text = "No Email App found";
            int duration = Toast.LENGTH_LONG;
            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }

    }
}
