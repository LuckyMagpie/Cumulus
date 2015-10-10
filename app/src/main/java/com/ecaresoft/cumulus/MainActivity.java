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
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.RelativeLayout;
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
import com.ecaresoft.cumulus.models.MEMR;
import com.ecaresoft.cumulus.request.JSONRequest;
import com.google.gson.Gson;

import org.json.JSONException;

public class MainActivity extends ActionBarActivity {
    private ListView drawerList;
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle drawerToggle;
    private String[] tagTitles;
    private RelativeLayout layout;

    MEMR emr;

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
        //header.setLayoutParams(new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 250));
        header.setLayoutParams(new AbsListView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 250));
        drawerList.addHeaderView(header);
        addDrawerItems();

        setupDrawer();
        if (savedInstanceState == null) {
            ShowFragment(0);
        }

        try {
            String json = JSONRequest.GET("http://192.168.11.190:8000/pacientes/1/");
            Gson gson = new Gson();
            emr = gson.fromJson(json, MEMR.class);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        return ;
    }

    private void addDrawerItems() {
        ArrayList<Item> items = new ArrayList<>();
        items.add(new Item(tagTitles[1], R.drawable.home));
        items.add(new Item(tagTitles[2], R.drawable.eventos));
        items.add(new Item(tagTitles[3], R.drawable.receta));
        items.add(new Item(tagTitles[4], R.drawable.historial));
        items.add(new Item(tagTitles[5], R.drawable.alergias));
        items.add(new Item(tagTitles[6], R.drawable.diagnostico));
        items.add(new Item(tagTitles[7], R.drawable.medica));

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
            case 1:
                fragment= new FHome();
                break;
            case 2:
                fragment= new FAppointment(emr.getEventos());
                break;
            case 3:
                fragment= new FPrescription(emr.getMedicamentos());
                break;
            case 4:
                fragment= new FClinicHistory(emr.getHistoria());
                break;
            case 5:
                fragment= new FAllergy(emr.getAlergias());
                break;
            case 6:
                fragment= new FDiagnostic(emr.getDiagnosticos());
                break;
            case 7:
                fragment= new FHomeMeds(emr.getMedicamentos());
                break;
            default:
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