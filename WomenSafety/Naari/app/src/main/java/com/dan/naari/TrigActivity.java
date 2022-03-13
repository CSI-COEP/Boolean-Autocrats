package com.dan.naari;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.dan.naari.MainActivity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class TrigActivity extends AppCompatActivity {
    int count = 0;
    private static final int MY_PERMISSIONS_REQUEST_SEND_SMS = 0;
    String phoneNo;
    String message ="SOS ALERT\nI AM IN TROUBLE. PLEASE HELP ME NOW";
    EditText phoneNoEditText;
    EditText messageEditText;
    private static final String TAG = "MainActivity";
    Button button;
    EditText contact;
    Button submit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trig);
        button  = (Button) findViewById(R.id.button);
        submit = findViewById(R.id.submit2);



        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                contact = (EditText) findViewById(R.id.contact2);
                phoneNo = contact.getText().toString();
                System.out.println("The phone number is: " + phoneNo);
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendSMSMessage();
            }
        });

    }
    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Bundle extras = getIntent().getExtras();
        String V1 = extras.getString(Intent.EXTRA_TEXT);
        Log.d("NumberMainActivity", V1);
    }

    protected void sendSMSMessage(){

//        phoneNo = phoneNoEditText.getText().toString();
//        message = messageEditText.getText().toString();
//        System.out.println(message + ": THIS IS THE MESSAGE SENT");

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.SEND_SMS) != PackageManager.PERMISSION_GRANTED) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.SEND_SMS)) {
            } else {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.SEND_SMS}, MY_PERMISSIONS_REQUEST_SEND_SMS);
            }
        }

        try{
            SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage(phoneNo, null, message, null, null);
            Toast.makeText(getApplicationContext(), "SMS Sent Successfully!", Toast.LENGTH_LONG).show();
        } catch(Exception e){
            Log.e(TAG, "sendSMSMessage: error in SmsManager");
            e.printStackTrace();
        }
    }

}

