package com.dan.naari;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class DeveloperByActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_developer_by);
    }

    public void Aag(View v){
        Intent implicit = new Intent(Intent.ACTION_VIEW, Uri.parse("https://aagamb.github.io/"));
        startActivity(implicit);
    }

    public void Sid(View v){
        Intent implicit = new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/siddharth-57"));
        startActivity(implicit);

    }

    public void Shub(View v){
        Intent implicit = new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/gandhi-shubh02"));
        startActivity(implicit);

    }
    public void Shlok(View v){
        Intent implicit = new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/Shlok-D"));
        startActivity(implicit);
    }
}
