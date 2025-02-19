package com.example.myapplication;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class DietProgram extends AppCompatActivity {
    TextView CalorieBalance;
    TextView Calorieintake;
    TextView DailyProtein;
    ListView LvDiet;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_diet_program);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            CalorieBalance=findViewById(R.id.CalorieBalance);
            Calorieintake=findViewById(R.id.Calorieintake);
            DailyProtein=findViewById(R.id.DailyProtein);
            LvDiet=findViewById(R.id.LvDiet);
            return insets;
        });
    }
}