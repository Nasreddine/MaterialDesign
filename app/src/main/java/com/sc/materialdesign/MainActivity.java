package com.sc.materialdesign;

import android.graphics.Color;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private FrameLayout frameLayout;
    private DrawerLayout mDrawer;
    private NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

        // Pour afficher l'icône du drawer

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        // Lier le Drawer

        mDrawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        navigationView = (NavigationView) findViewById(R.id.nvView);
        navigationView.setNavigationItemSelectedListener(this);

        // Lier le FloatingButton

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);


        frameLayout = (FrameLayout) findViewById(R.id.frameLayout);

        // Ajouter l'événement de clic
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Snackbar snackbar = Snackbar.make(view,
                        "Message à afficher", Snackbar.LENGTH_LONG);

                snackbar.setActionTextColor(Color.RED);

                View sbView = snackbar.getView();
                TextView textView = (TextView) sbView.findViewById(R.id.snackbar_text);
                textView.setTextColor(Color.YELLOW);

                snackbar.show();

                mDrawer.openDrawer(GravityCompat.START);


            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_1:
                // User chose the "Settings" item, show the app settings UI...
                Snackbar snackbar = Snackbar
                        .make(frameLayout, "action 1 cliqué", Snackbar.LENGTH_LONG)
                        .setAction("Annuler", new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Snackbar snackbar1 = Snackbar.make(view,
                                        "Action 1 annulée !", Snackbar.LENGTH_SHORT);
                                snackbar1.show();
                            }
                        });
                snackbar.show();
                return true;

            case R.id.action_2:
                // User chose the "Favorite" action, mark the current item
                // as a favorite...
                Snackbar snackbar2 = Snackbar
                        .make(frameLayout, "action 2 cliqué", Snackbar.LENGTH_LONG)
                        .setAction("Annuler", new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Snackbar snackbar1 = Snackbar.make(view,
                                        "Action 2 annulée !", Snackbar.LENGTH_SHORT);
                                snackbar1.show();
                            }
                        });
                snackbar2.show();
                return true;

            case android.R.id.home:

                mDrawer.openDrawer(GravityCompat.START);


                return true;

            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);

        }
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        int id = menuItem.getItemId();

        if (id == R.id.nav_camera) {
            Toast.makeText(this, "boutton cam clicked", Toast.LENGTH_SHORT).show();

        } else if (id == R.id.nav_gallery) {
            Toast.makeText(this, "boutton gallery clicked", Toast.LENGTH_SHORT).show();

        } else if (id == R.id.nav_slideshow) {
            // instructions pour le diaporama
        } else if (id == R.id.nav_manage) {
            // instructions pour la gestion
        } else if (id == R.id.nav_share) {
            // instructions pour le partage
        } else if (id == R.id.nav_send) {
            // instructions pour l’envoi
        }


        mDrawer.closeDrawer(GravityCompat.START);
        return true;
    }


}
