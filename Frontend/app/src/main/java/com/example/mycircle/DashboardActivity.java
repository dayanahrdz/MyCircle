package com.example.mycircle;

import android.content.Intent;
import android.os.Bundle;
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

    // Define final constants for IDs
    private static final int NAV_SCHEDULE = 1;
    private static final int NAV_DAY = 2;
    private static final int NAV_WEEK = 3;
    private static final int NAV_MONTH = 4;
    private static final int NAV_LOCATION = 5;
    private static final int NAV_ADD_FRIENDS = 6;
    private static final int NAV_GROUPS = 7;
    private static final int NAV_CONTACTS = 8;
    private static final int NAV_SETTINGS = 9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        // Set up Toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Set up DrawerLayout and NavigationView
        drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        // Set default fragment
        if (savedInstanceState == null) {
            loadFragment(new ScheduleFragment());
            navigationView.setCheckedItem(R.id.nav_schedule);
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int itemId = getMappedId(item.getItemId());

        switch (itemId) {
            case NAV_SCHEDULE:
                loadFragment(new ScheduleFragment());
                break;
            case NAV_DAY:
                loadFragment(new DayViewFragment());
                break;
            case NAV_WEEK:
                loadFragment(new WeekViewFragment());
                break;
            case NAV_MONTH:
                loadFragment(new MonthViewFragment());
                break;
            case NAV_LOCATION:
                Intent locationIntent = new Intent(this, LocationActivity.class);
                startActivity(locationIntent);
                break;
            case NAV_ADD_FRIENDS:
                loadFragment(new AddFriendsFragment());
                break;
            case NAV_GROUPS:
                loadFragment(new GroupsFragment());
                break;
            case NAV_CONTACTS:
                loadFragment(new ContactsFragment());
                break;
            case NAV_SETTINGS:
                loadFragment(new SettingsFragment());
                break;
            default:
                break;
        }

        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private int getMappedId(int resourceId) {
        // Map R.id values to constants
        if (resourceId == R.id.nav_schedule) return NAV_SCHEDULE;
        if (resourceId == R.id.nav_day) return NAV_DAY;
        if (resourceId == R.id.nav_week) return NAV_WEEK;
        if (resourceId == R.id.nav_month) return NAV_MONTH;
        if (resourceId == R.id.nav_location) return NAV_LOCATION;
        if (resourceId == R.id.nav_add_friends) return NAV_ADD_FRIENDS;
        if (resourceId == R.id.nav_groups) return NAV_GROUPS;
        if (resourceId == R.id.nav_contacts) return NAV_CONTACTS;
        if (resourceId == R.id.nav_settings) return NAV_SETTINGS;
        return -1; // Default case
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



