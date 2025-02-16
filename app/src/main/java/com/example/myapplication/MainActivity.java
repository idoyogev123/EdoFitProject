package com.example.myapplication;

import android.app.Dialog;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
TextView tvSignUp;
Button btnLog;
Dialog d;
FirebaseAuth MyAuth;
FirebaseDatabase myData;
DatabaseReference myRef;
EditText etmail, etpass;
EditText  etemail,etpassword, etheight, etweight, etage , etfname;//dialog
    Spinner spGoal;
    SharedPreferences sp;
    String strmail;
    String strpass;
    Button etbtnclick;
   ArrayList<String>goalList;
   ArrayAdapter adapter;
   wifiReceiver wifi_reciever;
   boolean isReciever= false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            MyAuth=FirebaseAuth.getInstance();
            myData=FirebaseDatabase.getInstance();
            myRef=myData.getReference("Users");
            etmail=findViewById(R.id.etmail);
            etpass=findViewById(R.id.etpass);
            tvSignUp=findViewById(R.id.tvSignUp);
            tvSignUp.setOnClickListener(this);
            btnLog=findViewById(R.id.btnLog);
            btnLog.setOnClickListener(this);
            goalList=new ArrayList<>();
            goalList.add("Bulking");
            goalList.add("Cutting");
            goalList.add("Maintance");
            sp=getSharedPreferences("details",0);
            strmail=sp.getString("Email",null);
            strpass=sp.getString("Password",null);
            if(strmail!=null&&strpass!=null)
            {
                etmail.setText(strmail);
                etpass.setText(strpass);
            }
            return insets;
        });
    }

    @Override
    public void onClick(View v) {
        if (v==tvSignUp)
        {
            register();
        }
        if(v==etbtnclick)
        {
            createAndSaveUser();
            d.dismiss();

        }
        if(v==btnLog)
        {
            enter();
        }


    }

    private void enter() {
        MyAuth.signInWithEmailAndPassword(etmail.getText().toString(), etpass.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful())
                {
                    SharedPreferences.Editor editor=sp.edit();
                    editor.putString("Email", etmail.getText().toString());
                    editor.putString("Password",etpass.getText().toString());
                    editor.commit();
                    Intent intent=new Intent(MainActivity.this, HomePage.class);
                    startActivity(intent);
                    finish();


                }
                else
                {
                    Toast.makeText(MainActivity.this, "Authentication failed, please try again", Toast.LENGTH_LONG).show();
                }
            }
        });

    }

    private void createAndSaveUser() {//create new user and save details
        MyAuth.createUserWithEmailAndPassword(etemail.getText().toString(), etpassword.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override



            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful())
                {

                    Users users=new Users(etemail.getText().toString(), etpassword.getText().toString(),etfname.getText().toString(),etheight.getText().toString(),etweight.getText().toString(),etage.getText().toString(),spGoal.getSelectedItem().toString());
                    myRef.child(MyAuth.getCurrentUser().getUid()).setValue(users);



                }
                else
                {
                    Toast.makeText(MainActivity.this, "Authentication failed, please try again", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    private void register() {
        d=new Dialog(this);
        d.setContentView(R.layout.register);
        d.setCancelable(true);
        d.setTitle("Register");
         etfname=d.findViewById(R.id.etfname);
         etemail=d.findViewById(R.id.etemail);
         etpassword=d.findViewById(R.id.etpassword);
         etheight=d.findViewById(R.id.etheight);
         etweight=d.findViewById(R.id.etweight);
         etage=d.findViewById(R.id.etage);
         spGoal=d.findViewById(R.id.spGoal);
        adapter=new ArrayAdapter( d.getContext(), com.google.android.material.R.layout.support_simple_spinner_dropdown_item,goalList);
        spGoal.setAdapter(adapter);

        etbtnclick=d.findViewById(R.id.etbtnclick);
        etbtnclick.setOnClickListener(this);
        d.show();



    }

    @Override
    protected void onStart() {



        super.onStart();
        if(wifi_reciever==null)
        {
            wifi_reciever=new wifiReceiver();
        }

        IntentFilter filter = new IntentFilter();
        filter.addAction(WifiManager.WIFI_STATE_CHANGED_ACTION);
        filter.addAction(ConnectivityManager.CONNECTIVITY_ACTION);
        registerReceiver(wifi_reciever,filter);
        isReciever=true;
    }

    @Override
    protected void onStop() {
        super.onStop();
        unregisterReceiver();
    }

    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver();
    }


    public void unregisterReceiver()
    {
        if(isReciever)
        {
            unregisterReceiver(wifi_reciever);
            isReciever=false;
        }

    }

}