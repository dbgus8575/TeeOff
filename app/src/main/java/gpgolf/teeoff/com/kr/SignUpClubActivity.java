package gpgolf.teeoff.com.kr;

import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CursorAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

/**
 * Created by T on 2015-12-02.
 */
public class SignUpClubActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    ListView list;
    String keyword;
    EditText KeyWordEdit;
    ClubCursorAdapter myAdapter;

    public static class ClubViewHolder{
        TextView itemName;
        TextView itemAddress;
        TextView itemHole;
        TextView itemType;
    }


    private class ClubCursorAdapter extends CursorAdapter{
        public ClubCursorAdapter(Context context, Cursor c, boolean autoRequery){
            super(context, c, autoRequery);
        }

        @Override
        public View newView(Context context, Cursor cursor, ViewGroup parent) {
            View itemRoot = LayoutInflater.from(SignUpClubActivity.this).inflate(R.layout.item, null);
            ClubViewHolder holder = new ClubViewHolder();
            holder.itemName = (TextView) itemRoot.findViewById(R.id.txt_clubname);
            holder.itemAddress = (TextView) itemRoot.findViewById(R.id.txt_address);
            holder.itemHole = (TextView) itemRoot.findViewById(R.id.txt_hole);
            holder.itemType = (TextView) itemRoot.findViewById(R.id.txt_type);
            itemRoot.setTag(holder);
            return null;
        }

        @Override
        public void bindView(View view, Context context, Cursor cursor) {
            ClubViewHolder holder = (ClubViewHolder)view.getTag();
            holder.itemName.setText(cursor.getString(0));
            holder.itemAddress.setText(cursor.getString(1));
            holder.itemHole.setText(cursor.getString(2));
            holder.itemType.setText(cursor.getString(3));
        }
    }
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if (savedInstanceState != null) {
            keyword = savedInstanceState.getString("keyword");
        }
    }


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scorecard);

        KeyWordEdit = (EditText) findViewById(R.id.edit_clubSearch);
        list = (ListView)findViewById(R.id.list);
        Button searchB = (Button)findViewById(R.id.btn_clubSearch);

        String [] fromColumns = {"golfclub_name_col", "golfclub_address_col", "golfclub_hole_col", "golfclub_type_col"};
        int    [] itemWidget = {R.id.txt_clubname, R.id.txt_address, R.id.txt_hole, R.id.txt_type};
        myAdapter = new ClubCursorAdapter(this, null, true);
        list.setAdapter(myAdapter);
        searchB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                keyword = KeyWordEdit.getText().toString();
                showList();
            }
        });

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle(null);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_socrecard);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

    }


    public void showList() {
        Cursor c = TeeOffDBHelper.getInstance().searchClub(keyword);
    }



    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("keyword",keyword);

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_socrecard);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
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
            finish();

        } else if (id == R.id.nav_scorecard) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_socrecard);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

}
