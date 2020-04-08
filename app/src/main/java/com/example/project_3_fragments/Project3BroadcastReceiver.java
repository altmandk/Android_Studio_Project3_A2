package com.example.project_3_fragments;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.widget.Toast;

import androidx.core.content.ContextCompat;

public class Project3BroadcastReceiver extends BroadcastReceiver {
    String attractionString = "Attraction Broadcast Received";
    String restaurantString = "Restaurant Broadcast Received";

    @Override
    public void onReceive(Context context, Intent intent) {
        if ("edu.uic.cs478.sp2020.project3.ACTION".equals(intent.getAction())) {
            String receivedText = intent.getStringExtra("edu.uic.cs478.sp2020.project3.TEXT");

            if (receivedText.equals(attractionString)) {
                Intent attractionIntent = new Intent();
                attractionIntent.setClassName("com.example.project_3_fragments", "com.example.project_3_fragments.AttractionsActivity");
                context.startActivity(attractionIntent);
            }
            else if (receivedText.equals(restaurantString)) {
                Intent restaurantIntent = new Intent();
                restaurantIntent.setClassName("com.example.project_3_fragments", "com.example.project_3_fragments.RestaurantsActivity");
                context.startActivity(restaurantIntent);
            }
        }
    }
}