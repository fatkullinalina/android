package com.example.sms_email;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Bundle arguments = getIntent().getExtras();
        String Message=arguments.get("SMS").toString();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        TextView viewMessage = findViewById(R.id.textView);
        viewMessage.setText(Message);
        Button buttonSend=findViewById(R.id.buttonn);
        buttonSend.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View w){
                sendMail();
            }
        }
        );

    }
    private void sendMail(){
        Bundle arguments = getIntent().getExtras();
        String TxMessage=arguments.get("SMS").toString();
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_TEXT,TxMessage);
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
