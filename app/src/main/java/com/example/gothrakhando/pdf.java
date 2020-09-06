package com.example.gothrakhando;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.github.barteksc.pdfviewer.PDFView;

public class pdf extends AppCompatActivity {

    PDFView pdf;
    int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdf);

        pdf = findViewById(R.id.pdf);

        Intent intent = getIntent();

        position = intent.getIntExtra("name", 0);

        pdf.fromAsset("g" + Integer.toString(position + 1) + ".pdf").load();

    }
}