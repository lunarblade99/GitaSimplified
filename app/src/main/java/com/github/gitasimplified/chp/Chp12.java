package com.github.gitasimplified.chp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.github.gitasimplified.Aboutus;
import com.github.gitasimplified.Explaination;
import com.github.gitasimplified.Main2Activity;
import com.github.gitasimplified.MainActivity;
import com.github.gitasimplified.NewsAdapter;
import com.github.gitasimplified.NewsItem;
import com.github.gitasimplified.R;

import java.util.ArrayList;
import java.util.List;

public class Chp12 extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    RecyclerView NewsRecyclerview;
    NewsAdapter newsAdapter;
    List<NewsItem> mData;
    FloatingActionButton fabSwitcher;
    boolean isDark = false;
    ConstraintLayout rootLayout;
    EditText searchInput ;
    CharSequence search="";

    private View.OnClickListener onItemClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            //TODO: Step 4 of 4: Finally call getTag() on the view.
            // This viewHolder will have all required values.
            RecyclerView.ViewHolder viewHolder = (RecyclerView.ViewHolder) view.getTag();
            int position = viewHolder.getAdapterPosition();
            // viewHolder.getItemId();
            // viewHolder.getItemViewType();
            // viewHolder.itemView;
            NewsItem thisItem = mData.get(position);

            if(position == 0) {
                Toast.makeText(Chp12.this, "You Clicked: " + thisItem.getTitle(), Toast.LENGTH_SHORT).show();
            }


        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // requestWindowFeature(Window.FEATURE_NO_TITLE);
        // getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
        //       WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.getMenu().getItem(11).setChecked(true);

        /////////////////////////////////////////////////////////////////////////////////////////////////////////

        // let's make this activity on full screen




        // hide the action bar




        // ini view

        fabSwitcher = findViewById(R.id.fab_switcher);
        rootLayout = findViewById(R.id.root_layout);
        searchInput = findViewById(R.id.search_input);
        NewsRecyclerview = findViewById(R.id.news_rv);
        mData = new ArrayList<>();

        // load theme state

        isDark = getThemeStatePref();
        if(isDark) {
            // dark theme is on

            searchInput.setBackgroundResource(R.drawable.search_input_dark_style);
            rootLayout.setBackgroundColor(getResources().getColor(R.color.black));

        }
        else
        {
            // light theme is on
            searchInput.setBackgroundResource(R.drawable.search_input_style);
            rootLayout.setBackgroundColor(getResources().getColor(R.color.colorPrimaryt));

        }



        // fill list news with data
        // just for testing purpose i will fill the news list with random data
        // you may get your data from an api / firebase or sqlite database ...
        mData.add(new NewsItem("Sanjay uvācha :-","Sanjay said: Seeing Arjun overwhelmed with pity, his mind grief-stricken, and his eyes full of tears, Shree Krishna spoke the following words.","||1||",R.drawable.chariot));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-","The Supreme Lord said: My dear Arjun, how has this delusion overcome you in this hour of peril? It is not befitting an honorable person. It leads not to the higher abodes, but to disgrace.","||2||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-","","||3||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-","","||4||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-","","||5||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-","","||6||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-","","||7||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-","","||8||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-","","||9||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-","","||10||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-","","||11||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-","","||12||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-","","||13||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-","","||14||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-","","||15||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-","","||16||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-","","||17||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-","","||18||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-","","||19||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-","","||20||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-","","||21||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-","","||22||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-","","||23||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-","","||24||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-","","||25||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-","","||26||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-","","||27||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-","","||28||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-","","||29||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-","","||30||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-","","||31||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-","","||32||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-","","||33||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-","","||34||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-","","||35||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-","","||36||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-","","||37||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-","","||38||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-","","||39||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-","","||40||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-","","||41||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-","","||42||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-","","||43||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-","","||44||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-","","||45||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-","","||46||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-","","||47||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-","","||48||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-","","||49||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-","","||50||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-","","||51||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-","","||52||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-","","||53||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-","","||54||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-","","||55||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-","","||56||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-","","||57||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-","","||58||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-","","||59||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-","","||60||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-","","||61||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-","","||62||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-","","||63||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-","","||64||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-","","||65||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-","","||66||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-","","||67||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-","","||68||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-","","||69||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-","","||70||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-","","||71||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-","","||72||",R.drawable.krishna_c));


        // adapter ini and setup

        newsAdapter = new NewsAdapter(this,mData,isDark);
        NewsRecyclerview.setAdapter(newsAdapter);
        NewsRecyclerview.setLayoutManager(new LinearLayoutManager(this));
        NewsAdapter.setOnItemClickListener(onItemClickListener);

        fabSwitcher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isDark = !isDark ;
                if (isDark) {

                    rootLayout.setBackgroundColor(getResources().getColor(R.color.black));
                    searchInput.setBackgroundResource(R.drawable.search_input_dark_style);

                }
                else {
                    rootLayout.setBackgroundColor(getResources().getColor(R.color.colorPrimaryt));
                    searchInput.setBackgroundResource(R.drawable.search_input_style);
                }

                newsAdapter = new NewsAdapter(getApplicationContext(),mData,isDark);
                if (!search.toString().isEmpty()){

                    newsAdapter.getFilter().filter(search);

                }
                NewsRecyclerview.setAdapter(newsAdapter);
                saveThemeStatePref(isDark);



            }
        });



        searchInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {


                newsAdapter.getFilter().filter(s);
                search = s;


            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


    }

    private void saveThemeStatePref(boolean isDark) {

        SharedPreferences pref = getApplicationContext().getSharedPreferences("myPref",MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putBoolean("isDark",isDark);
        editor.commit();
    }

    private boolean getThemeStatePref () {

        SharedPreferences pref = getApplicationContext().getSharedPreferences("myPref",MODE_PRIVATE);
        boolean isDark = pref.getBoolean("isDark",false) ;
        return isDark;

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
        if (id == R.id.meaning){

            Intent myIntent = new Intent(this, MainActivity.class);
            this.startActivity(myIntent);

        }

        if (id == R.id.verses){

            Intent myIntent = new Intent(this, Main2Activity.class);
            this.startActivity(myIntent);

        }

        if (id == R.id.explain){

            Intent myIntent = new Intent(this, Explaination.class);
            this.startActivity(myIntent);

        }

        if (id == R.id.Aboutus){
            {
                Intent myIntent = new Intent(this, Aboutus.class);
                this.startActivity(myIntent);            }}

        return super.onOptionsItemSelected(item);
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id2 = item.getItemId();

        if (id2 == R.id.one) {
            Intent myIntent = new Intent(this, com.github.gitasimplified.MainActivity.class);
            this.startActivity(myIntent);

        }
        if (id2 == R.id.two) {
            Intent myIntent = new Intent(this, Chp2.class);
            this.startActivity(myIntent);

        }
        if (id2 == R.id.three) {
            Intent myIntent = new Intent(this, Chp3.class);
            this.startActivity(myIntent);

        }
        if (id2 == R.id.four) {
            Intent myIntent = new Intent(this, Chp4.class);
            this.startActivity(myIntent);

        }if (id2 == R.id.five) {
            Intent myIntent = new Intent(this, Chp5.class);
            this.startActivity(myIntent);

        }
        if (id2 == R.id.six) {
            Intent myIntent = new Intent(this, Chp6.class);
            this.startActivity(myIntent);

        }if (id2 == R.id.seven) {
            Intent myIntent = new Intent(this, Chp7.class);
            this.startActivity(myIntent);

        }
        if (id2 == R.id.eight) {
            Intent myIntent = new Intent(this, Chp8.class);
            this.startActivity(myIntent);

        }if (id2 == R.id.nine) {
            Intent myIntent = new Intent(this, Chp9.class);
            this.startActivity(myIntent);

        }
        if (id2 == R.id.ten) {
            Intent myIntent = new Intent(this, Chp10.class);
            this.startActivity(myIntent);

        }if (id2 == R.id.eleven) {
            Intent myIntent = new Intent(this, Chp11.class);
            this.startActivity(myIntent);

        }
        if (id2 == R.id.twelve) {
            Intent myIntent = new Intent(this, Chp12.class);
            this.startActivity(myIntent);

        }if (id2 == R.id.thirteen) {
            Intent myIntent = new Intent(this, Chp13.class);
            this.startActivity(myIntent);

        }
        if (id2 == R.id.fourteen) {
            Intent myIntent = new Intent(this, Chp14.class);
            this.startActivity(myIntent);

        }if (id2 == R.id.fifteen) {
            Intent myIntent = new Intent(this, Chp15.class);
            this.startActivity(myIntent);

        }
        if (id2 == R.id.sixteen) {
            Intent myIntent = new Intent(this, Chp16.class);
            this.startActivity(myIntent);

        }if (id2 == R.id.seventeen) {
            Intent myIntent = new Intent(this, Chp17.class);
            this.startActivity(myIntent);

        }
        if (id2 == R.id.eighteen) {
            Intent myIntent = new Intent(this, Chp18.class);
            this.startActivity(myIntent);

        }
     //   else{Intent myIntent = new Intent(this, com.github.gitasimplified.MainActivity.class);
      //      this.startActivity(myIntent);}

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;

    }
}
