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
import com.github.gitasimplified.vchp.Vchp6;
import com.shashank.sony.fancygifdialoglib.FancyGifDialog;
import com.shashank.sony.fancygifdialoglib.FancyGifDialogListener;

import java.util.ArrayList;
import java.util.List;

public class Chp6 extends AppCompatActivity
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
        navigationView.getMenu().getItem(5).setChecked(true);

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
        mData.add(new NewsItem("Shrī Bhagavān uvācha :- 『 6.1 』 ","The Supreme Lord said: Those who perform prescribed duties without desiring the results of their actions are actual sanyāsīs (renunciates) and yogis, not those who have merely ceased performing sacrifices such as agni-hotra yajña or abandoned bodily activities. ","||1||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :- 『 6.2 』 "," What is known as sanyās is non-different from Yog, for none become yogis without renouncing worldly desires. ","||2||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :- 『 6.3 』 ","To the soul who is aspiring for perfection in Yog, work without attachment is said to be the means; to the sage who is already elevated in Yog, tranquility in meditation is said to be the means. ","||3||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :- 『 6.4 』 ","When one is neither attached to sense objects nor to actions, that person is said to be elevated in the science of Yog, for having renounced all desires for the fruits of actions. ","||4||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :- 『 6.5 』 "," Elevate yourself through the power of your mind, and not degrade yourself, for the mind can be the friend and also the enemy of the self. ","||5||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :- 『 6.6 』 ","For those who have conquered the mind, it is their friend. For those who have failed to do so, the mind works like an enemy. ","||6||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :- 『 6.7 』 ","The yogis who have conquered the mind rise above the dualities of cold and heat, joy and sorrow, honor and dishonor. Such yogis remain peaceful and steadfast in their devotion to God. ","||7||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :- 『 6.8 』 ","The yogi who are satisfied by knowledge and discrimination, and have conquered their senses, remain undisturbed in all circumstances. They see everything—dirt, stones, and gold—as the same. ","||8||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :- 『 6.9 』 ","The yogis look upon all—well-wishers, friends, foes, the pious, and the sinners—with an impartial intellect. The yogi who is of equal intellect toward friend, companion, and foe, neutral among enemies and relatives, and impartial between the righteous and sinful, is considered to be distinguished among humans. ","||9||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :- 『 6.10 』 ","Those who seek the state of Yog should reside in seclusion, constantly engaged in meditation with a controlled mind and body, getting rid of desires and possessions for enjoyment. ","||10||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :- 『 6.11 』 ","To practice Yog, one should make an āsan (seat) in a sanctified place, by placing kuśh grass, deer skin, and a cloth, one over the other. The āsan should be neither too high nor too low. ","||11||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :- 『 6.12/13 』 ","Seated firmly on it, the yogi should strive to purify the mind by focusing it in meditation with one pointed concentration, controlling all thoughts and activities. He must hold the body, neck, and head firmly in a straight line, and gaze at the tip of the nose, without allowing the eyes to wander. ","||12,13||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :- 『 6.14 』 ","Thus, with a serene, fearless, and unwavering mind, and staunch in the vow of celibacy, the vigilant yogi should meditate on me, having me alone as the supreme goal. ","||14||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :- 『 6.15 』 ","Thus, constantly keeping the mind absorbed in me, the yogi of disciplined mind attains nirvāṇ, and abides in me in supreme peace. ","||15||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :- 『 6.16 』 "," O Arjun, those who eat too much or eat too little, sleep too much or too little, cannot attain success in Yog. ","||16||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :- 『 6.17 』 ","But those who are temperate in eating and recreation, balanced in work, and regulated in sleep, can mitigate all sorrows by practicing Yog.","||17||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :- 『 6.18 』 ","With thorough discipline, they learn to withdraw the mind from selfish cravings and rivet it on the unsurpassable good of the self. Such persons are said to be in Yog, and are free from all yearning of the senses. ","||18||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :- 『 6.19 』 ","Just as a lamp in a windless place does not flicker, so the disciplined mind of a yogi remains steady in meditation on the self. ","||19||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :- 『 6.20 』 ","When the mind, restrained from material activities, becomes still by the practice of Yog, then the yogi is able to behold the soul through the purified mind, and he rejoices in the inner joy.","||20||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :- 『 6.21 』 "," In that joyous state of Yog, called samādhi, one experiences supreme boundless divine bliss, and thus situated, one never deviates from the Eternal Truth. ","||21||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :- 『 6.22 』 ","Having gained that state, one does not consider any attainment to be greater. Being thus established, one is not shaken even in the midst of the greatest calamity. ","||22||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :- 『 6.23 』 ","That state of severance from union with misery is known as Yog. This Yog should be resolutely practiced with determination free from pessimism. ","||23||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :- 『 6.24/25 』 ","Completely renouncing all desires arising from thoughts of the world, one should restrain the senses from all sides with the mind. Slowly and steadily, with conviction in the intellect, the mind will become fixed in God alone, and will think of nothing else. ","||24,25||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :- 『 6.26 』 ","Whenever and wherever the restless and unsteady mind wanders, one should bring it back and continually focus it on God. ","||26||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :- 『 6.27 』 ","Great transcendental happiness comes to the yogi whose mind is calm, whose passions are subdued, who is without sin, and who sees everything in connection with God. ","||27||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :- 『 6.28 』 ","The self-controlled yogi, thus uniting the self with God, becomes free from material contamination, and being in constant touch with the Supreme, achieves the highest state of perfect happiness. ","||28||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :- 『 6.29 』 ","The true yogis, uniting their consciousness with God, see with equal eye, all living beings in God and God in all living beings. ","||29||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :- 『 6.30 』 ","For those who see me everywhere and see all things in me, I am never lost, nor are they ever lost to me. ","||30||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :- 『 6.31 』 ","The yogi who is established in union with me, and worships me as the Supreme Soul residing in all beings, dwells only in me, though engaged in all kinds of activities. ","||31||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :- 『 6.32 』 ","I regard them to be perfect yogis who see the true equality of all living beings and respond to the joys and sorrows of others as if they were their own. ","||32||",R.drawable.krishna_c));
        mData.add(new NewsItem("Arjuna uvācha :- 『 6.33 』 ","Arjun said: The system of Yog that you have described, O Madhusudan, appears impractical and unattainable to me, due to the restless mind. ","||33||",R.drawable.target));
        mData.add(new NewsItem("Arjuna uvācha :- 『 6.34 』 ","The mind is very restless, turbulent, strong and obstinate, O Krishna. It appears to me that it is more difficult to control than the wind. ","||34||",R.drawable.target));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :- 『 6.35 』 ","Lord Krishna said: O mighty-armed son of Kunti, what you say is correct; the mind is indeed very difficult to restrain. But by practice and detachment, it can be controlled. ","||35||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :- 『 6.36 』 ","Yog is difficult to attain for one whose mind is unbridled. However, those who have learnt to control the mind, and who strive earnestly by the proper means, can attain perfection in Yog. This is my opinion. ","||36||",R.drawable.krishna_c));
        mData.add(new NewsItem("Arjuna uvācha :- 『 6.37 』 ","Arjun said: What is the fate of the unsuccessful yogi who begins the path with faith, but who does not endeavor sufficiently, due to unsteady mind, and is unable to reach the goal of Yog in this life? ","||37||",R.drawable.target));
        mData.add(new NewsItem("Arjuna uvācha :- 『 6.38 』 ","Does not such a person who deviates from Yog get deprived of both material and spiritual success, O mighty-armed Krishna, and perish like a broken cloud with no position in either sphere? ","||38||",R.drawable.target));
        mData.add(new NewsItem("Arjuna uvācha :- 『 6.39 』 "," O Krishna, please dispel this doubt of mine completely, for who other than you can do so? ","||39||",R.drawable.target));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :- 『 6.40 』 "," The Supreme Lord said: O Parth, One who engages on the spiritual path does not meet with destruction either in this world or the world to come. My dear friend, one who strives for God-realization is never overcome by evil. ","||40||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :- 『 6.41/42 』 ","The unsuccessful yogis, upon death, go to the abodes of the virtuous. After dwelling there for many ages, they are again reborn in the earth plane, into a family of pious and prosperous people. Else, if they had developed dispassion due to long practice of Yog, they are born into a family endowed with divine wisdom. Such a birth is very difficult to attain in this world. ","||41,42||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :- 『 6.43 』 ","On taking such a birth, O descendant of Kurus, they reawaken the wisdom of their previous lives, and strive even harder toward perfection in Yog. ","||43||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :- 『 6.44 』 ","Indeed, they feel drawn toward God, even against their will, on the strength of their past discipline. Such seekers naturally rise above the ritualistic principles of the scriptures. ","||44||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :- 『 6.45 』 ","With the accumulated merits of many past births, when these yogis engage in sincere endeavor in making further progress, they become purified from material desires and attain perfection in this life itself. ","||45||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :- 『 6.46 』 ","A yogi is superior to the tapasvī (ascetic), superior to the jñānī (a person of learning), and even superior to the karmī (ritualistic performer). Therefore, O Arjun, strive to be a yogi. ","||46||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :- 『 6.47 』 ","Of all yogis, those whose minds are always absorbed in me, and who engage in devotion to me with great faith, them I consider to be the highest of all. ","||47||",R.drawable.krishna_c));
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
                            Intent intent = new Intent(Chp6.this, CloseActivity.class);
                            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                            startActivity(intent);                      }
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

          //  Intent myIntent = new Intent(this, MainActivity.class);
          //  this.startActivity(myIntent);

        }

        if (id == R.id.verses){

            Intent myIntent = new Intent(this, Vchp6.class);
            this.startActivity(myIntent);

        }

        if (id == R.id.explain){

            //   Intent myIntent = new Intent(this, Explaination.class);
            //   this.startActivity(myIntent);

            new FancyGifDialog.Builder(Chp6.this)
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
     //   else{Intent myIntent = new Intent(this, com.github.gitasimplified.MainActivity.class);
      //      this.startActivity(myIntent);}

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;

    }
}
