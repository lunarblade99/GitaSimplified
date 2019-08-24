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
import com.github.gitasimplified.vchp.Vchp9;

import java.util.ArrayList;
import java.util.List;

public class Chp9 extends AppCompatActivity
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
        navigationView.getMenu().getItem(8).setChecked(true);

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
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-","The Supreme Lord said: O Arjun, because you are not envious of Me, I shall now impart to you this very confidential knowledge and wisdom, upon knowing which you will be released from the miseries of material existence. ","||1||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-","This knowledge is the king of sciences and the most profound of all secrets. It purifies those who hear it. It is directly realizable, in accordance with dharma, easy to practice, and everlasting in effect. ","||2||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-","People who have no faith in this dharma are unable to attain Me, O conqueror of enemies. They repeatedly come back to this world in the cycle of birth and death. ","||3||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-","This entire cosmic manifestation is pervaded by Me in My unmanifest form. All living beings dwell in Me, but I do not dwell in them. ","||4||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-","And yet, the living beings do not abide in Me. Behold the mystery of My divine energy! Although I am the Creator and Sustainer of all living beings, I am not influenced by them or by material nature. ","||5||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-","Know that as the mighty wind blowing everywhere rests always in the sky, likewise all living beings rest always in Me. ","||6||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-","At the end of one kalp, all living beings merge into My primordial material energy. At the beginning of the next creation, O son of Kunti, I manifest them again. Presiding over My material energy, I generate these myriad forms again and again, in accordance with the force of their natures. ","||7,8||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-","O conqueror of wealth, none of these actions bind Me. I remain like a neutral observer, ever detached from these actions. ","||9||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-","Working under My direction, this material energy brings into being all animate and inanimate forms, O son of Kunti. For this reason, the material world undergoes the changes (of creation, maintenance, and dissolution). ","||10||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-","When I descend in My personal form deluded persons are unable to recognize Me. They do not know the divinity of My personality, as the Supreme Lord of all beings. ","||11||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-","Bewildered by the material energy, such persons embrace demoniac and atheistic views. In that deluded state, their hopes for welfare are in vain, their fruitive actions are wasted, and their culture of knowledge is baffled. ","||12||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-","But the great souls, who take shelter of My divine energy, O Parth, know Me, Lord Krishna, as the origin of all creation. They engage in My devotion with their minds fixed exclusively on Me. ","||13||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-","Always singing My divine glories, striving with great determination, and humbly bowing down before Me, they constantly worship Me in loving devotion. ","||14||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-","Others, engaging in the yajña of cultivating knowledge, worship Me by many methods. Some see Me as undifferentiated oneness that is non-different from them, while others see Me as separate from them. Still others worship Me in the infinite manifestations of My cosmic form. ","||15||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-","It is I who am the Vedic ritual, I am the sacrifice, and I am the oblation offered to the ancestors. I am the medicinal herb, and I am the Vedic mantra. I am the clarified butter, I am the fire and the act of offering. Of this universe, I am the Father; I am also the Mother, the Sustainer, and the Grandsire. I am the purifier, the goal of knowledge, the sacred syllable Om. I am the Ṛig Veda, Sāma Veda, and the Yajur Veda. ","||16,17||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-","I am the Supreme Goal of all living beings, and I am also their Sustainer, Master, Witness, Abode, Shelter, and Friend. I am the Origin, End, and Resting Place of creation; I am the Storehouse and Eternal Seed. ","||18||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-"," I radiate heat as the sun, and I withhold, as well as send forth rain. I am immortality as well as death personified, O Arjun. I am the spirit as well as matter. ","||19||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-","Those who are inclined to the fruitive activity described in the Vedas worship Me through ritualistic sacrifices. Being purified from sin by drinking the Soma juice, which is the remnant of the yajñas, they seek to go to heaven. By virtue of their pious deeds, they go to the abode of Indra, the king of heaven, and enjoy the pleasures of the celestial gods. ","||20||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-","When they have enjoyed the vast pleasures of heaven, the stock of their merits being exhausted, they return to the earthly plane. Thus, those who follow the Vedic rituals, desiring objects of enjoyment, repeatedly come and go in this world. ","||21||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-","There are those who always think of Me and engage in exclusive devotion to Me. To them, whose minds are always absorbed in Me, I provide what they lack and preserve what they already possess. ","||22||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-","O son of Kunti, even those devotees who faithfully worship other gods also worship Me. But they do so by the wrong method. ","||23||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-","I am the enjoyer and the only Lord of all sacrifices. But those who fail to realize My divine nature must be reborn. ","||24||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-","Worshippers of the celestial gods take birth amongst the celestial gods, worshippers of the ancestors go to the ancestors, worshippers of ghosts take birth amongst such beings, and My devotees come to Me alone. ","||25||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-","If one offers to Me with devotion a leaf, a flower, a fruit, or even water, I delightfully partake of that article offered with love by My devotee in pure consciousness. ","||26||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-","Whatever you do, whatever you eat, whatever you offer as oblation to the sacred fire, whatever you bestow as a gift, and whatever austerities you perform, O son of Kunti, do them as an offering to Me. ","||27||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-","By dedicating all your works to Me, you will be freed from the bondage of good and bad results. With your mind attached to Me through renunciation, you will be liberated and will reach Me. ","||28||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-","I am equally disposed to all living beings; I am neither inimical nor partial to anyone. But the devotees who worship Me with love reside in Me and I reside in them. ","||29||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-"," Even if the vilest sinners worship Me with exclusive devotion, they are to be considered righteous, for they have made the proper resolve. ","||30||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-"," Quickly they become virtuous, and attain lasting peace. O son of Kunti, declare it boldly that no devotee of Mine is ever lost. ","||31||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-","All those who take refuge in Me, whatever their birth, race, sex, or caste, even those whom society scorns, will attain the supreme destination. ","||32||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-","What then to speak about kings and sages with meritorious deeds? Therefore, having come to this transient and joyless world, engage in devotion unto Me. ","||33||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-","Always think of Me, be devoted to Me, worship Me, and offer obeisance to Me. Having dedicated your mind and body to Me, you will certainly come to Me. ","||34||",R.drawable.krishna_c));
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

          //  Intent myIntent = new Intent(this, MainActivity.class);
          //  this.startActivity(myIntent);

        }

        if (id == R.id.verses){

            Intent myIntent = new Intent(this, Vchp9.class);
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
      //  else{Intent myIntent = new Intent(this, com.github.gitasimplified.MainActivity.class);
       //     this.startActivity(myIntent);}

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;

    }
}
