package com.github.gitasimplified;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import androidx.core.view.GravityCompat;
import androidx.appcompat.app.ActionBarDrawerToggle;
import android.view.MenuItem;
import com.google.android.material.navigation.NavigationView;
import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.Menu;
import android.widget.EditText;

import com.github.gitasimplified.chp.Chp10;
import com.github.gitasimplified.chp.Chp11;
import com.github.gitasimplified.chp.Chp12;
import com.github.gitasimplified.chp.Chp13;
import com.github.gitasimplified.chp.Chp14;
import com.github.gitasimplified.chp.Chp15;
import com.github.gitasimplified.chp.Chp16;
import com.github.gitasimplified.chp.Chp17;
import com.github.gitasimplified.chp.Chp18;
import com.github.gitasimplified.chp.Chp2;
import com.github.gitasimplified.chp.Chp3;
import com.github.gitasimplified.chp.Chp4;
import com.github.gitasimplified.chp.Chp5;
import com.github.gitasimplified.chp.Chp6;
import com.github.gitasimplified.chp.Chp7;
import com.github.gitasimplified.chp.Chp8;
import com.github.gitasimplified.chp.Chp9;
import com.shashank.sony.fancygifdialoglib.FancyGifDialog;
import com.shashank.sony.fancygifdialoglib.FancyGifDialogListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
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

            if(position == 0) {}

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
        navigationView.getMenu().getItem(0).setChecked(true);

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
        mData.add(new NewsItem("Dhritarashtra uvācha :-"," Dhritarashtra said: O Sanjay, after gathering on the holy field of Kurukshetra, and desiring to fight, what did my sons and the sons of Pandu do?","|| 1 ||",R.drawable.chariot));
        mData.add(new NewsItem("Sanjay uvācha :-","Sanjay said: On observing the Pandava army standing in military formation, King Duryodhan approached his teacher Dronacharya, and said the following words. ","|| 2 ||",R.drawable.chariot));
        mData.add(new NewsItem("Sanjay uvācha :-","Duryodhan said: Respected teacher! Behold the mighty army of the sons of Pandu, so expertly arrayed for battle by your own gifted disciple, the son of Drupad.","|| 3 ||",R.drawable.chariot));
        mData.add(new NewsItem("Sanjay uvācha :-","Behold in their ranks are many powerful warriors, like Yuyudhan, Virat, and Drupad, wielding mighty bows and equal in military prowess to Bheem and Arjun. There are also accomplished heroes like Dhrishtaketu, Chekitan, the gallant King of Kashi, Purujit, Kuntibhoj, and Shaibya—all the best of men. In their ranks, they also have the courageous Yudhamanyu, the gallant Uttamauja, the son of Subhadra, and the sons of Draupadi, who are all great warrior chiefs. ","|| 4,5,6 ||",R.drawable.chariot));
        mData.add(new NewsItem("Sanjay uvācha :-","O best of Brahmins, hear too about the principal generals on our side, who are especially qualified to lead. These I now recount unto you. ","|| 7 ||",R.drawable.chariot));
        mData.add(new NewsItem("Sanjay uvācha :-","There are personalities like yourself, Bheeshma, Karna, Kripa, Ashwatthama, Vikarn, and Bhurishrava, who are ever victorious in battle. ","|| 8 ||",R.drawable.chariot));
        mData.add(new NewsItem("Sanjay uvācha :-","Also, there are many other heroic warriors, who are prepared to lay down their lives for my sake. They are all skilled in the art of warfare, and equipped with various kinds of weapons.","|| 9 ||",R.drawable.chariot));
        mData.add(new NewsItem("Sanjay uvācha :-","The strength of our army is unlimited and we are safely marshalled by Grandsire Bheeshma, while the strength of the Pandava army, carefully marshalled by Bheem, is limited.","|| 10 ||",R.drawable.chariot));
        mData.add(new NewsItem("Sanjay uvācha :-","Therefore, I call upon all the generals of the Kaurava army now to give full support to Grandsire Bheeshma, even as you defend your respective strategic points. ","|| 11 ||",R.drawable.chariot));
        mData.add(new NewsItem("Sanjay uvācha :-","Then, the grand old man of the Kuru dynasty, the glorious patriarch Bheeshma, roared like a lion, and blew his conch shell very loudly, giving joy to Duryodhan.","|| 12 ||",R.drawable.chariot));
        mData.add(new NewsItem("Sanjay uvācha :-","Thereafter, conches, kettledrums, bugles, trumpets, and horns suddenly blared forth, and their combined sound was overwhelming.","|| 13 ||",R.drawable.chariot));
        mData.add(new NewsItem("Sanjay uvācha :-","Then, from amidst the Pandava army, seated in a glorious chariot drawn by white horses, Madhav and Arjun blew their Divine conch shells. ","|| 14 ||",R.drawable.chariot));
        mData.add(new NewsItem("Sanjay uvācha :-","Hrishikesh blew his conch shell, called Panchajanya, and Arjun blew the Devadutta. Bheem, the voracious eater and performer of herculean tasks, blew his mighty conch, called Paundra. ","|| 15 ||",R.drawable.chariot));
        mData.add(new NewsItem("Sanjay uvācha :-"," King Yudhishthir, blew the Anantavijay, while Nakul and Sahadev blew the Sughosh and Manipushpak. The excellent archer and king of Kashi, the great warrior Shikhandi, Dhrishtadyumna, Virat, and the invincible Satyaki, Drupad, the five sons of Draupadi, and the mighty-armed Abhimanyu, son of Subhadra, all blew their respective conch shells, O Ruler of the earth. ","|| 16 ||",R.drawable.chariot));
        mData.add(new NewsItem("Sanjay uvācha :-","The terrific sound thundered across the sky and the earth, and shattered the hearts of your sons, O Dhritarasthra. ","|| 19 ||",R.drawable.chariot));
        mData.add(new NewsItem("Sanjay uvācha :-","At that time, the son of Pandu, Arjun, who had the insignia of Hanuman on the flag of his chariot, took up his bow. Seeing your sons arrayed against him, O King, Arjun then spoke the following words to Shree Krishna. ","|| 20 ||",R.drawable.chariot));
        mData.add(new NewsItem("Arjuna uvācha :-","Arjun said: O Infallible One, please take my chariot to the middle of both armies, so that I may look at the warriors arrayed for battle, whom I must fight in this great combat. ","|| 21,22 ||",R.drawable.target));
        mData.add(new NewsItem("Arjuna uvācha :-"," I desire to see those who have come here to fight on the side of the evil-minded son of Dhritarasthra, wishing to please him. ","|| 23 ||",R.drawable.target));
        mData.add(new NewsItem("Sanjay uvācha :-"," Sanjay said: O Dhritarasthra, having thus been addressed by Arjun, the conqueror of sleep, Shree Krishna then drew the magnificent chariot between the two armies. ","|| 24 ||",R.drawable.chariot));
        mData.add(new NewsItem("Sanjay uvācha :-","In the presence of Bheeshma, Dronacharya, and all the other kings, Shree Krishna said: O Parth, behold these Kurus gathered here. ","|| 25 ||",R.drawable.chariot));
        mData.add(new NewsItem("Sanjay uvācha :-","There, Arjun could see stationed in both armies, his fathers, grandfathers, teachers, maternal uncles, brothers, cousins, sons, nephews, grand-nephews, friends, fathers-in-law, and well-wishers. ","|| 26 ||",R.drawable.chariot));
        mData.add(new NewsItem("Sanjay uvācha :-"," Seeing all his relatives present there, Arjun, the son of Kunti, was overwhelmed with compassion, and with deep sorrow, spoke the following words. ","|| 27 ||",R.drawable.chariot));
        mData.add(new NewsItem("Arjuna uvācha :-","Arjun said: O Krishna, seeing my own kinsmen arrayed for battle here and intent on killing each other, my limbs are giving way and my mouth is drying up. ","|| 28 ||",R.drawable.target));
        mData.add(new NewsItem("Arjuna uvācha :-","My whole body shudders; my hair is standing on end. My bow, the Gāṇḍīv, is slipping from my hand, and my skin is burning all over. My mind is in quandary and whirling in confusion; I am unable to hold myself steady any longer. O Krishna, killer of the Keshi demon, I only see omens of misfortune. I do not foresee how any good can come from killing my own kinsmen in this battle. ","|| 29,30,31 ||",R.drawable.target));
        mData.add(new NewsItem("Arjuna uvācha :-","O Krishna, I do not desire the victory, kingdom, or the happiness accruing it. Of what avail will be a kingdom, pleasures, or even life itself, when the very persons for whom we covet them, are standing before us for battle?","|| 32,33 ||",R.drawable.target));
        mData.add(new NewsItem("Arjuna uvācha :-","Teachers, fathers, sons, grandfathers, maternal uncles, grandsons, fathers-in-law, grand-nephews, brothers-in-law, and other kinsmen are present here, staking their lives and riches. O Madhusudan, I do not wish to slay them, even if they attack me. If we kill the sons of Dhritarashtra, what satisfaction will we derive from the dominion over the three worlds, what to speak of this Earth?","|| 34,35 ||",R.drawable.target));
        mData.add(new NewsItem("Arjuna uvācha :-","O Maintainer of all living entities, what pleasure will we derive from killing the sons of Dhritarasthra? Even though they may be aggressors, sin will certainly come upon us if we slay them. Hence, it does not behoove us to kill our own cousins, the sons of Dhritarashtra, and friends. O Madhav (Krishna), how can we hope to be happy by killing our own kinsmen?","|| 36,37 ||",R.drawable.target));
        mData.add(new NewsItem("Arjuna uvācha :-","Their thoughts are overpowered by greed and they see no wrong in annihilating their relatives or wreaking treachery upon friends. Yet, O Janardan (Krishna), why should we, who can clearly see the crime in killing our kindred, not turn away from this sin?","|| 38,39 ||",R.drawable.target));
        mData.add(new NewsItem("Arjuna uvācha :-","When a dynasty is destroyed, its traditions get vanquished, and the rest of the family becomes involved in irreligion. ","|| 40 ||",R.drawable.target));
        mData.add(new NewsItem("Arjuna uvācha :-","With the preponderance of vice, O Krishna, the women of the family become immoral; and from the immorality of women, O descendent of Vrishni, unwanted progeny are born.","|| 41 ||",R.drawable.target));
        mData.add(new NewsItem("Arjuna uvācha :-","An increase in unwanted children results in hellish life both for the family and for those who destroy the family. Deprived of the sacrificial offerings, the ancestors of such corrupt families also fall. ","|| 42 ||",R.drawable.target));
        mData.add(new NewsItem("Arjuna uvācha :-","Through the evil deeds of those who destroy the family tradition and thus give rise to unwanted progeny, a variety of social and family welfare activities are ruined. ","|| 43 ||",R.drawable.target));
        mData.add(new NewsItem("Arjuna uvācha :-","O Janardan (Krishna), I have heard from the learned that those who destroy family traditions dwell in hell for an indefinite period of time. ","|| 44 ||",R.drawable.target));
        mData.add(new NewsItem("Arjuna uvācha :-","Alas! How strange it is that we have set our mind to perform this great sin. Driven by the desire for kingly pleasures, we are intent on killing our own kinsmen. It will be better if, with weapons in hand, the sons of Dhritarashtra kill me unarmed and unresisting on the battlefield. ","|| 45,46 ||",R.drawable.target));
        mData.add(new NewsItem("Sanjay uvācha :-","Sanjay said: Speaking thus, Arjun cast aside his bow and arrows, and sank into the seat of his chariot, his mind in distress and overwhelmed with grief. ","|| 47 ||",R.drawable.chariot));

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
                            finish();
                            System.exit(0);                        }
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

            Intent myIntent = new Intent(this, Main2Activity.class);
            this.startActivity(myIntent);

        }

        if (id == R.id.explain){

         //   Intent myIntent = new Intent(this, Explaination.class);
         //   this.startActivity(myIntent);

            new FancyGifDialog.Builder(MainActivity.this)
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
            Intent myIntent = new Intent(this, MainActivity.class);
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
        //else{Toast.makeText(MainActivity.this, "You Clicked: ", Toast.LENGTH_SHORT).show(); }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;

    }

}
