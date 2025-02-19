package com.example.myapplication;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.widget.Toast;

public class wifiReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();

        if (WifiManager.WIFI_STATE_CHANGED_ACTION.equals(action)) {
            int wifiState = intent.getIntExtra(WifiManager.EXTRA_WIFI_STATE, WifiManager.WIFI_STATE_UNKNOWN);
            switch (wifiState) {
                case WifiManager.WIFI_STATE_ENABLED:
                    Toast.makeText(context, "WiFi Enabled", Toast.LENGTH_SHORT).show();
                    break;
                case WifiManager.WIFI_STATE_DISABLED:
                    Toast.makeText(context, "WiFi Disabled", Toast.LENGTH_SHORT).show();
                    break;
            }
        } else if (ConnectivityManager.CONNECTIVITY_ACTION.equals(action)) {
            NetworkInfo networkInfo = intent.getParcelableExtra(ConnectivityManager.EXTRA_NETWORK_INFO);
            if (networkInfo != null && networkInfo.getType() == ConnectivityManager.TYPE_WIFI) {
                if (networkInfo.isConnected()) {
                    Toast.makeText(context, "Connected to WiFi", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(context, "Disconnected from WiFi", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }
}
