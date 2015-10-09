package com.ecaresoft.cumulus;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.support.v4.widget.DrawerLayout;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Toast;
import java.util.ArrayList;
import adapter.DrawerAdapter;
import com.ecaresoft.cumulus.fragments.FAllergy;
import com.ecaresoft.cumulus.fragments.FAppointment;
import com.ecaresoft.cumulus.fragments.FDiagnostic;
import com.ecaresoft.cumulus.fragments.FClinicHistory;
import com.ecaresoft.cumulus.fragments.FHome;
import com.ecaresoft.cumulus.fragments.FHomeMeds;
import com.ecaresoft.cumulus.fragments.FPrescription;
import com.ecaresoft.cumulus.models.Item;

public class MainActivity extends ActionBarActivity {
    private ListView drawerList;
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle drawerToggle;
    private String[] tagTitles;
    private RelativeLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar=(Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        layout=(RelativeLayout)findViewById(R.id.layout);
        drawerList = (ListView)findViewById(R.id.nav);
        drawerLayout = (DrawerLayout)findViewById(R.id.drawer);
        tagTitles= getResources().getStringArray(R.array.tags);

        View header = getLayoutInflater().inflate(R.layout.header, null);
        drawerList.addHeaderView(header);
        addDrawerItems();
        setupDrawer();

        if (savedInstanceState == null) {
            ShowFragment(0);
        }

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
    }

    private void addDrawerItems() {
        ArrayList<Item> items = new ArrayList<>();
        items.add(new Item(tagTitles[0], R.drawable.hospital));
        items.add(new Item(tagTitles[1], R.drawable.hospital));
        items.add(new Item(tagTitles[2], R.drawable.hospital));
        items.add(new Item(tagTitles[3], R.drawable.hospital));
        items.add(new Item(tagTitles[4], R.drawable.hospital));
        items.add(new Item(tagTitles[5], R.drawable.hospital));
        items.add(new Item(tagTitles[6], R.drawable.hospital));

        drawerList.setAdapter(new DrawerAdapter(this, items));

        drawerList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                ShowFragment(i);
            }
        });
    }

    private void ShowFragment(int position){
        android.support.v4.app.Fragment fragment= null;

        switch (position){
            case 0:
                fragment= new FHome();
                break;
            case 1:
                fragment= new FAppointment();
                break;
            case 2:
                fragment= new FPrescription();
                break;
            case 3:
                fragment= new FClinicHistory();
                break;
            case 4:
                fragment= new FAllergy();
                break;
            case 5:
                fragment= new FDiagnostic();
                break;
            case 6:
                fragment= new FHomeMeds();
                break;

            default:
                //
                Toast.makeText(getApplicationContext(), getResources().getString(R.string.abc_action_bar_home_description),Toast.LENGTH_SHORT).show();
                fragment = new FHome();
                position =1;
                break;
        }

        if (fragment != null) {
            android.support.v4.app.FragmentTransaction t= getSupportFragmentManager().beginTransaction();
            t.replace(R.id.content_frame,fragment);
            t.commit();

            drawerList.setItemChecked(position, true);
            drawerList.setSelection(position);
            setTitle(tagTitles[position]);
            drawerLayout.closeDrawer(layout);
        }
    }

    private void setupDrawer() {
        drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.drawer_open, R.string.drawer_close) {

            /** Called when a drawer has settled in a completely open state. */
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);

            }

            /** Called when a drawer has settled in a completely closed state. */
            public void onDrawerClosed(View view) {
                super.onDrawerClosed(view);

            }
        };

        drawerToggle.setDrawerIndicatorEnabled(true);
        drawerLayout.setDrawerListener(drawerToggle);

    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // Sync the toggle state after onRestoreInstanceState has occurred.
        drawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        drawerToggle.onConfigurationChanged(newConfig);
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
        // automatically handle clicks on the FHome/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        // Activate the navigation drawer toggle
        if (drawerToggle.onOptionsItemSelected(item)) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}