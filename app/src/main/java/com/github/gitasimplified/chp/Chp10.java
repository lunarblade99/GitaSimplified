package com.github.gitasimplified.chp;

import android.content.Intent;
import android.content.SharedPreferences;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.appcompat.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import com.github.gitasimplified.Aboutus;
import com.github.gitasimplified.CloseActivity;
import com.github.gitasimplified.NewsAdapter;
import com.github.gitasimplified.NewsItem;
import com.github.gitasimplified.R;
import com.github.gitasimplified.vchp.Vchp10;
import com.shashank.sony.fancygifdialoglib.FancyGifDialog;
import com.shashank.sony.fancygifdialoglib.FancyGifDialogListener;

import java.util.ArrayList;
import java.util.List;

public class Chp10 extends AppCompatActivity
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
        navigationView.getMenu().getItem(9).setChecked(true);

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
        mData.add(new NewsItem("Shrī Bhagavān uvācha :- 『 10.1 』 ","The Blessed Lord said: Listen again to my divine teachings, O mighty armed one. Desiring your welfare because you are my beloved friend, I shall reveal them to you. ","||1||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :- 『 10.2 』 ","Neither celestial gods nor the great sages know my origin. I am the source from which the gods and great seers come. ","||2||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :- 『 10.3 』 ","Those who know me as unborn and beginningless, and as the Supreme Lord of the universe, they among mortals are free from illusion and released from all evils. ","||3||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :- 『 10.4/5 』 ","From me alone arise the varieties in the qualities amongst humans, such as intellect, knowledge, clarity of thought, forgiveness, truthfulness, control over the senses and mind, joy and sorrow, birth and death, fear and courage, non-violence, equanimity, contentment, austerity, charity, fame, and infamy. ","||4,5||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :- 『 10.6 』 ","The seven great Sages, the four great Saints before them, and the fourteen Manus, are all born from my mind. From them, all the people in the world have descended. " ,"||6||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :- 『 10.7 』 ","Those who know in truth my glories and divine powers become united with me through unwavering bhakti yog. Of this there is no doubt. ","||7||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :- 『 10.8 』 ","I am the origin of all creation. Everything proceeds from me. The wise who know this perfectly worship me with great faith and devotion. ","||8||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :- 『 10.9 』 ","With their minds fixed on me and their lives surrendered to me, my devotees remain ever contented in me. They derive great satisfaction and bliss in enlightening one another about me, and conversing about my glories. ","||9||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :- 『 10.10 』 ","To those whose minds are always united with me in loving devotion, I give the divine knowledge by which they can attain me. ","||10||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :- 『 10.11 』 "," Out of compassion for them, I, who dwell within their hearts, destroy the darkness born of ignorance, with the luminous lamp of knowledge. ","||11||",R.drawable.krishna_c));
        mData.add(new NewsItem("Arjuna uvācha :- 『 10.12/13 』 ","Arjun said: You are the Supreme Divine Personality, the Supreme Abode, the Supreme Purifier, the Eternal God, the Primal Being, the Unborn, and the Greatest. The great sages, like Narad, Asit, Deval, and Vyas, proclaimed this, and now you are declaring it to me yourself. ","||12,13||",R.drawable.target));
        mData.add(new NewsItem("Arjuna uvācha :- 『 10.14 』 ","O Krishna, I totally accept everything you have told me as the truth. O Lord, neither gods nor the demons can understand your true personality. ","||14||",R.drawable.target));
        mData.add(new NewsItem("Arjuna uvācha :- 『 10.15 』 ","Indeed, you alone know yourself by your inconceivable energy, O Supreme Personality, the Creator and Lord of all beings, the God of gods, and the Lord of the universe! ","||15||",R.drawable.target));
        mData.add(new NewsItem("Arjuna uvācha :- 『 10.16/17 』 ","Please describe to me your divine opulences, by which you pervade all the worlds and reside in them. O Supreme Master of Yog, how may I know you and think of you. And while meditating, in what forms can I think of you, O Supreme Divine Personality? ","||16,17||",R.drawable.target));
        mData.add(new NewsItem("Arjuna uvācha :- 『 10.18 』 ","Tell me again in detail your divine glories and manifestations, O Janardan. I can never tire of hearing your nectar. ","||18||",R.drawable.target));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :- 『 10.19 』 ","The Blessed Lord spoke: I shall now briefly describe my divine glories to you, O best of the Kurus, for there is no end to their detail. ","||19||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :- 『 10.20 』 ","O Arjun, I am seated in the heart of all living entities. I am the beginning, middle, and end of all beings. ","||20||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :- 『 10.21 』 ","Amongst the twelve sons of Aditi I am Vishnu; amongst luminous objects I am the sun. Know me to be Marichi amongst the Maruts, and the moon amongst the stars in the night sky. ","||21||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :- 『 10.22 』 ","I am the Sāma Veda amongst the Vedas, and Indra amongst the celestial gods. Amongst the senses I am the mind; amongst the living beings I am consciousness. ","||22||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :- 『 10.23 』 ","Amongst the Rudras know me to be Shankar; amongst the demons I am Kuber. I am Agni amongst the Vasus and Meru amongst the mountains. ","||23||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :- 『 10.24 』 ","O Arjun, amongst priests I am Brihaspati; amongst warrior chiefs I am Kartikeya; and amongst reservoirs of water know me to be the ocean. ","||24||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :- 『 10.25 』 ","I am Bhrigu amongst the great seers and the transcendental Om amongst sounds. Amongst chants know me to be the repetition of the Holy Name; amongst immovable things I am the Himalayas. ","||25||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :- 『 10.26 』 ","Amongst trees I am the banyan tree; of the celestial sages I am Narad. Amongst the Gandharvas I am Chitrath, and amongst the siddhas I am the sage Kapil. ","||26||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :- 『 10.27 』 ","Amongst horses know me to be Ucchaihshrava, begotten from the churning of the ocean of nectar. I am Airavata amongst all lordly elephants, and the king amongst humans. ","||27||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :- 『 10.28 』 ","I am the Vajra (thunderbolt) amongst weapons and Kamadhenu amongst the cows. I am Kaamdev, the god of love, amongst all causes for procreation; amongst serpents I am Vasuki. ","||28||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :- 『 10.29 』 ","Amongst the snakes I am Anant; amongst aquatics I am Varun. Amongst the departed ancestors I am Aryama; amongst dispensers of law I am Yamraj, the lord of death. ","||29||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :- 『 10.30 』 "," I am Prahlad amongst the demons; amongst all that controls I am time. Know me to be the lion amongst animals, and Garud amongst the birds. ","||30||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :- 『 10.31 』 ","Amongst purifiers I am the wind, and amongst wielders of weapons I am Lord Ram. Of water creatures I am the crocodile, and of flowing rivers I am the Ganges. ","||31||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :- 『 10.32 』 ","O Arjun, know me to be the beginning, middle, and end of all creation. Amongst sciences I am the science of spirituality, and in debates I am the logical conclusion. ","||32||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :- 『 10.33 』 ","I am the beginning “A” amongst all letters; I am the dual word in grammatical compounds. I am the endless Time, and amongst creators I am Brahma. ","||33||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :- 『 10.34 』 "," I am the all-devouring Death, and I am the origin of those things that are yet to be. Amongst feminine qualities I am fame, prosperity, fine speech, memory, intelligence, courage, and forgiveness. ","||34||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :- 『 10.35 』 ","Amongst the hymns in the Sāma Veda know me to be the Brihatsama; amongst poetic meters I am the Gayatri. Of the twelve months of the Hindu calendar I am Margsheersh, and of seasons I am spring, which brings forth flowers. ","||35||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :- 『 10.36 』 ","I am the gambling of the cheats and the splendor of the splendid. I am the victory of the victorious, the resolve of the resolute, and the virtue of the virtuous. ","||36||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :- 『 10.37 』 ","Amongst the descendants of Vrishni, I am Krishna, and amongst the Pandavas I am Arjun. Know me to be Ved Vyas amongst the sages, and Shukracharya amongst the great thinkers. ","||37||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :- 『 10.38 』 ","I am just punishment amongst means of preventing lawlessness, and proper conduct amongst those who seek victory. Amongst secrets I am silence, and in the wise I am their wisdom. ","||38||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :- 『 10.39 』 ","I am the generating seed of all living beings, O Arjun. No creature moving or non-moving can exist without me. ","||39||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :- 『 10.40 』 ","There is no end to my divine manifestations, O conqueror of enemies. What I have declared to you is a mere sample of my infinite glories. ","||40||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :- 『 10.41 』 ","Whatever you see as beautiful, glorious, or powerful, know it to spring from but a spark of my splendor. ","||41||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :- 『 10.42 』 ","What need is there for all this detailed knowledge, O Arjun? Simply know that by one fraction of my being, I pervade and support this entire creation. ","||42||",R.drawable.krishna_c));
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
            // super.onBackPressed();

            new FancyGifDialog.Builder(this)
                    .setTitle("Are you sure you want to exit?")
                    .setMessage("Great is the art of beginning, but greater is the art of ending.")
                    .setNegativeBtnText("No")
                    .setPositiveBtnBackground("#1ec1f2")
                    .setPositiveBtnText("Yes")
                    .setNegativeBtnBackground("#D60621")
                    .setGifResource(R.drawable.exit_sign_gif)
                    .isCancellable(true)
                    .OnPositiveClicked(new FancyGifDialogListener() {
                        @Override
                        public void OnClick() {
                            Intent intent = new Intent(Chp10.this, CloseActivity.class);
                            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                            startActivity(intent);                     }
                    })
                    .OnNegativeClicked(new FancyGifDialogListener() {
                        @Override
                        public void OnClick() {
                        }
                    })
                    .build(); }
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

         //   Intent myIntent = new Intent(this, MainActivity.class);
         //   this.startActivity(myIntent);

        }

        if (id == R.id.verses){

            Intent myIntent = new Intent(this, Vchp10.class);
            this.startActivity(myIntent);

        }

        if (id == R.id.explain){

            //   Intent myIntent = new Intent(this, Explaination.class);
            //   this.startActivity(myIntent);

            new FancyGifDialog.Builder(Chp10.this)
                    .setTitle("REMEMBER THIS ALWAYS!")
                    .setMessage("\uD83D\uDCA5️ This is just a side note but a very important one:\n\uD83D\uDC49️ This translation of gita is by Swami Mukundananda & i choose to use this translation because it's one of the best and easy to understand english translation available.But it is one of the many translations available on this planet. Everyone interprets gita from there own school of thought and so when one switch from Dwaita to Adwaita philosophy the whole meaning flips upside down.\n\uD83D\uDE4F️ So it's my humble request to read different interpretations for a much clearer view!")
                    .setNegativeBtnText("Ofcourse!")
                    //  .setPositiveBtnBackground("#1ec1f2")
                    //  .setPositiveBtnText("Yes")
                    .setNegativeBtnBackground("#D60621")
                    .setGifResource(R.drawable.explain)
                    .isCancellable(true)
                    // .OnPositiveClicked(new FancyGifDialogListener() {
                    //     @Override
                    //    public void OnClick() {
                    //        Intent intent = new Intent(Aboutus.this, CloseActivity.class);
                    //        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                    //       startActivity(intent);                      }
                    //  })
                    .OnNegativeClicked(new FancyGifDialogListener() {
                        @Override
                        public void OnClick() {
                        }
                    })
                    .build();

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
       // else{Intent myIntent = new Intent(this, com.github.gitasimplified.MainActivity.class);
         //   this.startActivity(myIntent);}

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;

    }
}
