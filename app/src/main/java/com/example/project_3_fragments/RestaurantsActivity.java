package com.example.project_3_fragments;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

public class RestaurantsActivity extends AppCompatActivity implements RestListFragment.ListSelectionListener {
    public static String[] mListArray;
    public static String[] mWebArray;
    private final RestWebFragment mRestWebFragment = new RestWebFragment();
    private FragmentManager manager;
    private FrameLayout mListFrameLayout, mWebFrameLayout;
    private static final int MATCH_PARENT = LinearLayout.LayoutParams.MATCH_PARENT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mListArray = getResources().getStringArray(R.array.Restaurants);
        mWebArray = getResources().getStringArray(R.array.RestaurantsWeb);

        setContentView(R.layout.activity_rerstaurants);

        mListFrameLayout = (FrameLayout) findViewById(R.id.rest_list_fragment_container);
        mWebFrameLayout = (FrameLayout) findViewById(R.id.rest_web_fragment_container);

        manager = getSupportFragmentManager();

        FragmentTransaction fragmentTransaction = manager
                .beginTransaction();

        fragmentTransaction.add(
                R.id.rest_list_fragment_container,
                new RestListFragment());
        fragmentTransaction.commit();

        manager.addOnBackStackChangedListener(
                new FragmentManager.OnBackStackChangedListener() {
                    public void onBackStackChanged() {
                        setLayout();
                    }
                });
        setLayout();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("index", mRestWebFragment.getShownIndex());
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        //currIndex = savedInstanceState.getInt("index", -1);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.project3_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.attractionsItem) {
            Intent attractionsIntent = new Intent(RestaurantsActivity.this, AttractionsActivity.class);
            startActivity(attractionsIntent);
        } else if (item.getItemId() == R.id.restaurantsItem) {
            Intent restaurantsIntent = new Intent(RestaurantsActivity.this, RestaurantsActivity.class);
            startActivity(restaurantsIntent);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onListSelection(int index) {
        if (!mRestWebFragment.isAdded()) {
            FragmentTransaction fragmentTransaction = manager.beginTransaction();
            fragmentTransaction.add(R.id.rest_web_fragment_container, mRestWebFragment);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
            manager.executePendingTransactions();
        }
        if (mRestWebFragment.getShownIndex() != index) {
            mRestWebFragment.showQuoteAtIndex(index);
        }
    }

    private void setLayout() {
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            if (!mRestWebFragment.isAdded()) {
                mListFrameLayout.setLayoutParams(new LinearLayout.LayoutParams(
                        MATCH_PARENT, MATCH_PARENT));
                mWebFrameLayout.setLayoutParams(new LinearLayout.LayoutParams(0,
                        MATCH_PARENT));
            } else {
                mListFrameLayout.setLayoutParams(new LinearLayout.LayoutParams(0,
                        MATCH_PARENT, 1f));

                mWebFrameLayout.setLayoutParams(new LinearLayout.LayoutParams(0,
                        MATCH_PARENT, 2f));
            }
        } else {
            if (!mRestWebFragment.isAdded()) {
                mListFrameLayout.setLayoutParams(new LinearLayout.LayoutParams(
                        MATCH_PARENT, MATCH_PARENT));
                mWebFrameLayout.setLayoutParams(new LinearLayout.LayoutParams(0,
                        MATCH_PARENT));
            } else {
                mListFrameLayout.setLayoutParams(new LinearLayout.LayoutParams(
                        0, MATCH_PARENT));
                mWebFrameLayout.setLayoutParams(new LinearLayout.LayoutParams(MATCH_PARENT,
                        MATCH_PARENT));
            }
        }
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        setLayout();
    }
}


