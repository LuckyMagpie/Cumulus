package com.ecaresoft.cumulus;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.ecaresoft.cumulus.fragments.FAllergy;
import com.ecaresoft.cumulus.fragments.FAppointment;
import com.ecaresoft.cumulus.fragments.FClinicHistory;
import com.ecaresoft.cumulus.fragments.FDiagnostic;
import com.ecaresoft.cumulus.fragments.FHome;
import com.ecaresoft.cumulus.fragments.FHomeMeds;
import com.ecaresoft.cumulus.fragments.FPrescription;

public class MainActivity extends AppCompatActivity {

    //Defining Variables
    private Toolbar toolbar;
    private NavigationView navigationView;
    private DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int[][] states = new int[][] {
                new int[] {android.R.attr.state_checked},
                new int[] {-android.R.attr.state_checked},

        };
        int[] colors = new int[] {
                Color.rgb(0, 164, 147   ),
                Color.rgb(112,121,122)
        };
        ColorStateList colorStateList=new ColorStateList(states,colors);

        // Initializing Toolbar and setting it as the actionbar
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Initializing NavigationView
        navigationView = (NavigationView) findViewById(R.id.navigation_view);
        navigationView.setItemTextColor(colorStateList);
        navigationView.setItemIconTintList(colorStateList);
        //Setting Navigation View Item Selected Listener to handle the item click of the navigation menu
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {

            // This method will trigger on item Click of navigation menu
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                //Checking if the item is in checked state or not, if not make it in checked state
                if(menuItem.isChecked()) menuItem.setChecked(false);
                else menuItem.setChecked(true);

                //Closing drawer on item click
                drawerLayout.closeDrawers();
                android.support.v4.app.Fragment fragment= null;
                //Check to see which item was being clicked and perform appropriate action
                switch (menuItem.getItemId()){

                     //Replacing the main content with ContentFragment Which is our Inbox View;
                    case R.id.home:
                        fragment= new FHome();
                        return true;
                    case R.id.citas:
                        fragment= new FAppointment();
                        return true;
                    case R.id.recetas:
                        fragment= new FPrescription();
                        return true;
                    case R.id.historia:
                        fragment= new FClinicHistory();
                        return true;
                    case R.id.alergias:
                        fragment= new FAllergy();
                        return true;
                    case R.id.diagnos:
                        fragment= new FDiagnostic();
                        return true;
                    case R.id.medica:
                        fragment= new FHomeMeds();
                        return true;
                }
                android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.frame, fragment);
                fragmentTransaction.commit();
                return true;
            }
        });

        // Initializing Drawer Layout and ActionBarToggle
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer);
        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.drawer_open, R.string.drawer_close){

            @Override
            public void onDrawerClosed(View drawerView) {
                // Code here will be triggered once the drawer closes as we dont want anything to happen so we leave this blank
                super.onDrawerClosed(drawerView);
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                // Code here will be triggered once the drawer open as we dont want anything to happen so we leave this blank

                super.onDrawerOpened(drawerView);
            }
        };

        //Setting the actionbarToggle to drawer layout
        drawerLayout.setDrawerListener(actionBarDrawerToggle);

        //calling sync state is necessay or else your hamburger icon wont show up
        actionBarDrawerToggle.syncState();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
}
