package r99.developer.id.kowlegesharing2;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.MenuItem;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;

import r99.developer.id.kowlegesharing2.fragment.fr_diskusi;
import r99.developer.id.kowlegesharing2.fragment.fr_dokumen;
import r99.developer.id.kowlegesharing2.fragment.fr_home;
import r99.developer.id.kowlegesharing2.fragment.fr_laporan;
import r99.developer.id.kowlegesharing2.fragment.fr_logout;
import r99.developer.id.kowlegesharing2.fragment.fr_studikasus;

public class NavigationActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Membuka chat menu", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                Intent i = new Intent(NavigationActivity.this,Users.class);
                startActivity(i);
            }
        });
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
        loadFragment(new fr_home());
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.navigation, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            loadFragment(new fr_home());
        }
        else if (id == R.id.nav_laporan) {
            loadFragment(new fr_laporan());
        } else if (id == R.id.nav_dokumen) {
            loadFragment(new fr_dokumen());
        } else if (id == R.id.nav_studikasus) {
            loadFragment(new fr_studikasus());
        } else if (id == R.id.nav_diskusi) {
            loadFragment(new fr_diskusi());
        } else if (id == R.id.nav_pesan) {
                Intent i = new Intent(NavigationActivity.this,MainActivity.class);
                startActivity(i);
        } else if (id == R.id.nav_logout) {
            loadFragment(new fr_logout());
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void loadFragment(Fragment fr){

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.content_fragment, fr);
        ft.commit();
    }

}
