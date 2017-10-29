package com.hafiizh.checkbatterycharging;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        registerReceiver(new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                int status = intent.getIntExtra(BatteryManager.EXTRA_STATUS, -1);
                boolean isCharging = status == BatteryManager.BATTERY_STATUS_CHARGING;

                if (isCharging)
                    Toast.makeText(context, "Device status is charging ...", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(context, "Device status is not charging ...", Toast.LENGTH_SHORT).show();
            }
        }, new IntentFilter(Intent.ACTION_BATTERY_CHANGED));
    }
}
