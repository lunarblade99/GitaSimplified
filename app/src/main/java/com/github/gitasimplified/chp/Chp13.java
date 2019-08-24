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
import com.github.gitasimplified.vchp.Vchp13;

import java.util.ArrayList;
import java.util.List;

public class Chp13 extends AppCompatActivity
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
        navigationView.getMenu().getItem(12).setChecked(true);

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
        mData.add(new NewsItem("Arjuna uvācha :-","Arjun said, “O Keshav, I wish to understand what are prakṛiti and puruṣh, and what are kṣhetra and kṣhetrajña? I also wish to know what is true knowledge, and what is the goal of this knowledge? ","||1||",R.drawable.target));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-","The Supreme Divine Lord said: O Arjun, this body is termed as kṣhetra (the field of activities), and the one who knows this body is called kṣhetrajña (the knower of the field) by the sages who discern the truth about both. ","||2||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-","O scion of Bharat, I am also the knower of all the individual fields of activity. The understanding of the body as the field of activities, and the soul and God as the knowers of the field, this I hold to be true knowledge. ","||3||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-","Listen and I will explain to you what that field is and what its nature is. I will also explain how change takes place within it, from what it was created, who the knower of the field of activities is, and what his powers are. ","||4||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-","Great sages have sung the truth about the field and the knower of the field in manifold ways. It has been stated in various Vedic hymns, and especially revealed in the Brahma Sūtra, with sound logic and conclusive evidence. ","||5||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-","The field of activities is composed of the five great elements, the ego, the intellect, the unmanifest primordial matter, the eleven senses (five knowledge senses, five working senses, and mind), and the five objects of the senses. ","||6||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-","Desire and aversion, happiness and misery, the body, consciousness, and the will—all these comprise the field and its modifications. ","||7||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-","Humbleness; freedom from hypocrisy; non-violence; forgiveness; simplicity; service of the Guru; cleanliness of body and mind; steadfastness; and self-control; dispassion toward the objects of the senses; absence of egotism; keeping in mind the evils of birth, disease, old age, and death; non-attachment; absence of clinging to spouse, children, home, and so on; even-mindedness amidst desired and undesired events in life; constant and exclusive devotion toward Me; an inclination for solitary places and an aversion for mundane society; constancy in spiritual knowledge; and philosophical pursuit of the Absolute Truth—all these I declare to be knowledge, and what is contrary to it, I call ignorance. ","||8,9,10,11,12||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-","I shall now reveal to you that which ought to be known, and by knowing which, one attains immortality. It is the beginningless Brahman, which lies beyond existence and non-existence. ","||13||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-","Everywhere are His hands and feet, eyes, heads, and faces. His ears too are in all places, for He pervades everything in the universe. ","||14||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-","Though He perceives all sense-objects, yet He is devoid of the senses. He is unattached to anything, and yet He is the sustainer of all. Although He is without attributes, yet He is the enjoyer of the three modes of material nature. ","||15||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-","He exists outside and inside all living beings, those that are moving and not moving. He is subtle, and hence, He is incomprehensible. He is very far, but He is also very near. ","||16||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-"," He is indivisible, yet He appears to be divided amongst living beings. Know the Supreme Entity to be the Sustainer, Annihilator, and Creator of all beings. ","||17||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-","He is the source of light in all luminaries, and is entirely beyond the darkness of ignorance. He is knowledge, the object of knowledge, and the goal of knowledge. He dwells within the hearts of all living beings. ","||18||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-"," I have thus revealed to you the nature of the field, the meaning of knowledge, and the object of knowledge. Only My devotees can understand this in reality, and by doing so, they attain My divine nature. ","||19||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-","Know that prakṛiti (material nature) and puruṣh (the individual souls) are both beginningless. Also know that all transformations of the body and the three modes of nature are produced by material energy. ","||20||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-","In the matter of creation, the material energy is responsible for cause and effect; in the matter of experiencing happiness and distress, the individual soul is declared responsible. ","||21||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-","When the puruṣh (individual soul) seated in prakṛiti (the material energy) desires to enjoy the three guṇas, attachment to them becomes the cause of its birth in superior and inferior wombs. ","||22||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-"," Within the body also resides the Supreme Lord. He is said to be the Witness, the Permitter, the Supporter, Transcendental Enjoyer, the ultimate Controller, and the Paramātmā (Supreme Soul). ","||23||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-","Those who understand the truth about Supreme Soul, the individual soul, material nature, and the interaction of the three modes of nature will not take birth here again. They will be liberated regardless of their present condition. ","||24||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-","Some try to perceive the Supreme Soul within their hearts through meditation, and others try to do so through the cultivation of knowledge, while still others strive to attain that realization by the path of action. ","||25||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-","There are still others who are unaware of these spiritual paths, but they hear from others and begin worshipping the Supreme Lord. By such devotion to hearing from saints, they too can gradually cross over the ocean of birth and death. ","||26||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-","O best of the Bharatas, whatever moving or unmoving being you see in existence, know it to be a combination of the field of activities and the knower of the field. ","||27||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-","They alone truly see, who perceive the Paramātmā (Supreme Soul) accompanying the soul in all beings, and who understand both to be imperishable in this perishable body. ","||28||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-","Those, who see God as the Supreme Soul equally present everywhere and in all living beings, do not degrade themselves by their mind. Thereby, they reach the supreme destination. ","||29||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-","They alone truly see who understand that all actions (of the body) are performed by material nature, while the embodied soul actually does nothing. ","||30||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-","When they see the diverse variety of living beings situated in the same material nature, and understand all of them to be born from it, they attain the realization of Brahman. ","||31||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-","The Supreme Soul is imperishable, without beginning, and devoid of any material qualities, O son of Kunti. Although situated within the body, It neither acts, nor is It tainted by material energy.\n","||32||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-","Space holds everything within it, but being subtle, does not get contaminated by what it holds. Similarly, though its consciousness pervades the body, the soul is not affected by the attributes of the body. ","||33||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-"," Just as one sun illumines the entire solar system, so does the individual soul illumine the entire body (with consciousness). ","||34||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-","Those who perceive with the eyes of knowledge the difference between the body and the knower of the body, and the process of release from material nature, attain the supreme destination. ","||35||",R.drawable.krishna_c));
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

        //    Intent myIntent = new Intent(this, MainActivity.class);
         //   this.startActivity(myIntent);

        }

        if (id == R.id.verses){

            Intent myIntent = new Intent(this, Vchp13.class);
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
        //    this.startActivity(myIntent);}

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;

    }
}
