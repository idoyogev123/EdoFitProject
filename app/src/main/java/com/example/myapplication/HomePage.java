package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.text.style.RelativeSizeSpan;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class HomePage extends AppCompatActivity implements View.OnClickListener {
    TextView bmi;
    Button cardio;
    Button resistance;
    Button diet;
    Button btnStart,btnStop;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_home_page);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            bmi=findViewById(R.id.bmi);
            cardio=findViewById(R.id.cardio);
            resistance=findViewById(R.id.resistance);
            diet = findViewById(R.id.diet);
            cardio.setOnClickListener(this);
            resistance.setOnClickListener(this);
            diet.setOnClickListener(this);
            btnStart=findViewById(R.id.btnStart);
            btnStart.setOnClickListener(this);
            btnStop=findViewById(R.id.btnStop);
            btnStop.setOnClickListener(this);

            return insets;
        });
    }

    @Override
    public void onClick(View v) {
        if(v==btnStart)
        {
            Intent serviceIntent=new Intent(this, BackgroundSoundService.class);
            startService(serviceIntent);
        }
        if(v==btnStop)
        {
            Intent serviceIntent=new Intent(this, BackgroundSoundService.class);
            stopService(serviceIntent);
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.main_menu,menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        super.onOptionsItemSelected(item);
        int id = item.getItemId();
        if (id == R.id.action_Profile)
        {
            Toast.makeText(this,"you selected Profile",Toast.LENGTH_LONG).show();
        }
        else if(id == R.id.action_ShowGoal)
        {
            Toast.makeText(this,"you selected to show your goal",Toast.LENGTH_LONG).show();
        }
        else if (id == R.id.action_logout)
        {
            Toast.makeText(this,"you selected log out",Toast.LENGTH_LONG).show();
        }
        return true;
    }

}