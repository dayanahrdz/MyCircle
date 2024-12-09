package com.example.mycircle;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import com.google.android.material.navigation.NavigationView;

public class DashboardActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        // Set the default fragment
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new ScheduleFragment()).commit();
            navigationView.setCheckedItem(R.id.nav_schedule);
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();

        if (itemId == R.id.nav_schedule) {
            loadFragment(new ScheduleFragment());
        } else if (itemId == R.id.nav_day) {
            loadFragment(new DayViewFragment());
        } else if (itemId == R.id.nav_week) {
            loadFragment(new WeekViewFragment());
        } else if (itemId == R.id.nav_month) {
            loadFragment(new MonthViewFragment());
        } else if (itemId == R.id.nav_location) {
            Log.d("DashboardActivity", "Location menu item clicked");
            Intent locationIntent = new Intent(this, LocationActivity.class);
            Log.d("DashboardActivity", "Created Intent for LocationActivity");
            startActivity(locationIntent);
            Log.d("DashboardActivity", "Started LocationActivity");
            return true;
        } else if (itemId == R.id.nav_add_friends) {
            loadFragment(new AddFriendsFragment());
        } else if (itemId == R.id.nav_groups) {
            loadFragment(new GroupsFragment());
        } else if (itemId == R.id.nav_contacts) {
            loadFragment(new ContactsFragment());
        } else if (itemId == R.id.nav_settings) {
            loadFragment(new SettingsFragment());
        }

        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void loadFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                .commit();
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
}



