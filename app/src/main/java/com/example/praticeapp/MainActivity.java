package com.example.praticeapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.praticeapp.databinding.ActivityMainBinding;
import com.example.praticeapp.ui.busmap.BusMapFragment;
import com.example.praticeapp.ui.complain.ComplainFragment;
import com.example.praticeapp.ui.contact.ContactFragment;
import com.example.praticeapp.ui.home.HomeFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    DatabaseReference databaseReference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());



        BottomNavigationView navigationView = findViewById(R.id.nav_view);


        navigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch(item.getItemId()){
                    case R.id.home:
                        replaceFragment(new HomeFragment());
                        break;

                    case R.id.busmap:
                        replaceFragment(new BusMapFragment());
                        break;

                    case R.id.complain:
                        replaceFragment(new ComplainFragment());
                        break;

                    case R.id.contact:
                        replaceFragment(new ContactFragment());
                        break;
                }
                return true;
            }
        });
        replaceFragment(new HomeFragment());
    }



    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.layout_main,fragment);
        fragmentTransaction.commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater inflater = getMenuInflater();

        inflater.inflate(R.menu.menu_bar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId())
        {
            case R.id.developer:
                Intent i = new Intent(MainActivity.this,DeveloperInfoActivity.class);
                startActivity(i);
                break;

            case R.id.logout:
                FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
                break;
        }
        return true;
    }


}

