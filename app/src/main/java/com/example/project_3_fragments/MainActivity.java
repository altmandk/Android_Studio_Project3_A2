package com.example.project_3_fragments;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {
    Project3BroadcastReceiver project3BroadcastReceiver = new Project3BroadcastReceiver();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        IntentFilter filter = new IntentFilter("edu.uic.cs478.sp2020.project3.ACTION");
        registerReceiver(project3BroadcastReceiver, filter, "edu.uic.cs478.sp2020.project3", null);
}
//comment out before turn in
    /*
@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.project3_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }
     */

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.attractionsItem) {
            Intent attractionsIntent = new Intent(MainActivity.this, AttractionsActivity.class);
            startActivity(attractionsIntent);
        }
        else if (item.getItemId() == R.id.restaurantsItem) {
            Intent restaurantsIntent = new Intent(MainActivity.this, RestaurantsActivity.class);
            startActivity(restaurantsIntent);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(project3BroadcastReceiver);
    }
}