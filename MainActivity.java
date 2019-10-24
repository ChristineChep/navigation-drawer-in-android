package com.example.user.sikika4;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.user.sikika4.R;

public class MainActivity extends AppCompatActivity  implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout mDrawerlayout;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mDrawerlayout = (DrawerLayout) findViewById(R.id.drawer);

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, mDrawerlayout, toolbar
                R.string.open, R.string.close);


        mDrawerlayout.addDrawerListener(toggle);
        toggle.syncState();

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new dashboardFragment()).commit();
            navigationView.setCheckedItem(R.id.db);
        }
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        setNavigationViewListener();
    }


//    public boolean onOptionsItemSelected(MenuItem item) {
//        if (mToggle.onOptionsItemSelected(item)) {
//            return true;
//        }
//        return super.onOptionsItemSelected(item);
//    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        // Handle navigation view item clicks here.
        switch (item.getItemId()) {

            case R.id.db:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new dashboardFragment()).commit();
                break;

//            case R.id.about:
//                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container ,
//                        new aboutFragment()).commit();
//                break;

            case R.id.news:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new newsFragment()).commit();
                break;

            case R.id.report:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new reportFragment()).commit();
                break;

            case R.id.search:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new searchFragment()).commit();
                break;


            mDrawerlayout.closeDrawer(GravityCompat.START);
            return true;
        }



        public void onBackPressed () {
            if (mDrawerlayout.isDrawerOpen(GravityCompat.START)) {
                mDrawerlayout.closeDrawer(GravityCompat.START);
            }
            else {
                super.onBackPressed();
            }
                    }
