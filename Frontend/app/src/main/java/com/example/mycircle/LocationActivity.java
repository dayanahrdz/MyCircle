package com.example.mycircle;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;
import com.google.android.material.appbar.MaterialToolbar;
import java.util.ArrayList;
import java.util.List;

public class LocationActivity extends AppCompatActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private RecyclerView familyMembersList;
    private FamilyMemberAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location);

        // Setup toolbar
        MaterialToolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Johnson Family");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(v -> finish());

        // Initialize map
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        // Setup RecyclerView
        familyMembersList = findViewById(R.id.family_members_list);
        familyMembersList.setLayoutManager(new LinearLayoutManager(this));

        // Create mock data
        List<FamilyMember> familyMembers = new ArrayList<>();
        familyMembers.add(new FamilyMember("Peggy", "At Work", "1:14 am Sunday", "1hr 10",
                new LatLng(37.7897, -122.4185)));
        familyMembers.add(new FamilyMember("Mark", "At St. Francis Memorial Hospital", "1:14 am", "5 min",
                new LatLng(37.7879, -122.4156)));
        familyMembers.add(new FamilyMember("Sarah", "Driving near 143 Washington St", "1:14 am", "2 min",
                new LatLng(37.7951, -122.4053)));

        adapter = new FamilyMemberAdapter(familyMembers);
        familyMembersList.setAdapter(adapter);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);

        // Set initial camera position to San Francisco
        LatLng sanFrancisco = new LatLng(37.7749, -122.4194);
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(sanFrancisco, 14));

        // Add markers for family members
        for (FamilyMember member : adapter.getFamilyMembers()) {
            MarkerOptions markerOptions = new MarkerOptions()
                    .position(member.getLocation())
                    .title(member.getName());

            // TODO: Add custom marker with profile picture
            mMap.addMarker(markerOptions);
        }
    }
}
