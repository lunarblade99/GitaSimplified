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
import com.github.gitasimplified.vchp.Vchp4;

import java.util.ArrayList;
import java.util.List;

public class Chp4 extends AppCompatActivity
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
        navigationView.getMenu().getItem(3).setChecked(true);

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
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-","The Supreme Lord Shree Krishna said: I taught this eternal science of Yog to the Sun-god, Vivasvan, who passed it on to Manu; and Manu in turn instructed it to Ikshvaku. ","||1||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-","O subduer of enemies, the saintly kings thus received this science of Yog in a continuous tradition. But with the long passage of time, it was lost to the world. ","||2||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-","The same ancient knowledge of Yog, which is the supreme secret, I am today revealing unto you, because you are my friend as well as my devotee, who can understand this transcendental wisdom. ","||3||",R.drawable.krishna_c));
        mData.add(new NewsItem("Arjuna uvācha :-","Arjun said: You were born much after Vivasvan. How am I to understand that in the beginning you instructed this science to him? ","||4||",R.drawable.target));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-","The Supreme Lord said: Both you and I have had many births, O Arjun. You have forgotten them, while I remember them all, O Parantapa. ","||5||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-","Although I am unborn, the Lord of all living entities, and have an imperishable nature, yet I appear in this world by virtue of Yogmaya, my divine power. ","||6||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-","Whenever there is a decline in righteousness and an increase in unrighteousness, O Arjun, at that time I manifest myself on earth. ","||7||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-","To protect the righteous, to annihilate the wicked, and to reestablish the principles of dharma I appear on this earth, age after age. ","||8||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-","Those who understand the divine nature of my birth and activities, O Arjun, upon leaving the body, do not have to take birth again, but come to my eternal abode. ","||9||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-","Being freed from attachment, fear, and anger, becoming fully absorbed in me, and taking refuge in me, many persons in the past became purified by knowledge of me, and thus they attained my divine love. ","||10||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-","In whatever way people surrender unto me, I reciprocate with them accordingly. Everyone follows my path, knowingly or unknowingly, O son of Pritha. ","||11||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-","In this world, those desiring success in material activities worship the celestial gods, since material rewards manifest quickly. ","||12||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-","The four categories of occupations were created by me according to people’s qualities and activities. Although I am the creator of this system, know me to be the non-doer and eternal. ","||13||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-","Activities do not taint me, nor do I desire the fruits of action. One who knows me in this way is never bound by the karmic reactions of work. ","||14||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-","Knowing this truth, even seekers of liberation in ancient times performed actions. Therefore, following the footsteps of those ancient sages, you too should perform your duty.","||15||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-","What is action and what is inaction? Even the wise are confused in determining this. Now I shall explain to you the secret of action, by knowing which, you may free yourself from material bondage. ","||16||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-","You must understand the nature of all three—recommended action, wrong action, and inaction. The truth about these is profound and difficult to understand. ","||17||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-","Those who see action in inaction and inaction in action are truly wise amongst humans. Although performing all kinds of actions, they are yogis and masters of all their actions. ","||18||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-","The enlightened sages call those persons wise, whose every action is free from the desire for material pleasures and who have burnt the reactions of work in the fire of divine knowledge. ","||19||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-","Such people, having given up attachment to the fruits of their actions, are always satisfied and not dependent on external things. Despite engaging in activities, they do not do anything at all. ","||20||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-","Free from expectations and the sense of ownership, with mind and intellect fully controlled, they incur no sin, even though performing actions by one’s body. ","||21||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-","Content with whatever gain comes of its own accord, and free from envy, they are beyond the dualities of life. Being equipoised in success and failure, they are not bound by their actions, even while performing all kinds of activities. ","||22||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-","They are released from the bondage of material attachments and their intellect is established in divine knowledge. Since they perform all actions as a sacrifice (to God), they are freed from all karmic reactions. ","||23||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-","For those who are completely absorbed in God-consciousness, the oblation is Brahman, the ladle with which it is offered is Brahman, the act of offering is Brahman, and the sacrificial fire is also Brahman. Such persons, who view everything as God, easily attain him. ","||24||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-","Some yogis worship the celestial gods with material offerings unto them. Others worship perfectly who offer the self as sacrifice in the fire of the Supreme Truth.\n","||25||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-"," Others offer hearing and other senses in the sacrificial fire of restraint. Still others offer sound and other objects of the senses as sacrifice in the fire of the senses. ","||26||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-","Some, inspired by knowledge, offer the functions of all their senses and their life energy in the fire of the controlled mind. ","||27||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-","Some offer their wealth as sacrifice, while others offer severe austerities as sacrifice. Some practice the eight-fold path of yogic practices, and yet others study the scriptures and cultivate knowledge as sacrifice, while observing strict vows. ","||28||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-","Still others offer as sacrifice the outgoing breath in the incoming breath, while some offer the incoming breath into the outgoing breath. Some arduously practice prāṇāyām and restrain the incoming and outgoing breaths, purely absorbed in the regulation of the life-energy. Yet others curtail their food intake and offer the breath into the life-energy as sacrifice. All these knowers of sacrifice are cleansed of their impurities as a result of such performances. ","||29,30||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-","Those who know the secret of sacrifice, and engaging in it, partake of its remnants that are like nectar, advance toward the Absolute Truth. O best of the Kurus, those who perform no sacrifice find no happiness either in this world or the next. ","||31||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-","All these different kinds of sacrifice have been described in the Vedas. Know them as originating from different types of work; this understanding cuts the knots of material bondage. ","||32||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-","O subduer of enemies, sacrifice performed in knowledge is superior to any mechanical material sacrifice. After all, O Parth, all sacrifices of work culminate in knowledge. ","||33||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-","Learn the Truth by approaching a spiritual master. Inquire from him with reverence and render service unto him. Such an enlightened Saint can impart knowledge unto you because he has seen the Truth. ","||34||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-","Following this path and having achieved enlightenment from a Guru, O Arjun, you will no longer fall into delusion. In the light of that knowledge, you will see that all living beings are but parts of the Supreme, and are within me. ","||35||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-","Even those who are considered the most immoral of all sinners can cross over this ocean of material existence by seating themselves in the boat of divine knowledge. ","||36||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-","As a kindled fire reduces wood to ashes, O Arjun, so does the fire of knowledge burn to ashes all reactions from material activities. ","||37||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-","In this world, there is nothing as purifying as divine knowledge. One who has attained purity of mind through prolonged practice of Yog, receives such knowledge within the heart, in due course of time. ","||38||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-","Those whose faith is deep and who have practiced controlling their mind and senses attain divine knowledge. Through such transcendental knowledge, they quickly attain everlasting supreme peace. ","||39||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-","But persons who possess neither faith nor knowledge, and who are of a doubting nature, suffer a downfall. For the skeptical souls, there is no happiness either in this world or the next. ","||40||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-","O Arjun, actions do not bind those who have renounced karm in the fire of Yog, whose doubts have been dispelled by knowledge, and who are situated in knowledge of the self. ","||41||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-","Therefore, with the sword of knowledge, cut asunder the doubts that have arisen in your heart. O scion of Bharat, establish yourself in karm yog. Arise, stand up, and take action! ","||42||",R.drawable.krishna_c));


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

            Intent myIntent = new Intent(this, Vchp4.class);
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
