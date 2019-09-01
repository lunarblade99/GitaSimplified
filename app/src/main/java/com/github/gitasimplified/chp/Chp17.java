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
import com.github.gitasimplified.vchp.Vchp17;
import com.shashank.sony.fancygifdialoglib.FancyGifDialog;
import com.shashank.sony.fancygifdialoglib.FancyGifDialogListener;

import java.util.ArrayList;
import java.util.List;

public class Chp17 extends AppCompatActivity
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
        navigationView.getMenu().getItem(16).setChecked(true);

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
        mData.add(new NewsItem("Arjuna uvācha :-"," Arjun said: O Krishna, where do they stand who disregard the injunctions of the scriptures, but still worship with faith? Is their faith in the mode of goodness, passion, or ignorance?","||1||",R.drawable.target));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-","The Supreme Divine Personality said: Every human being is born with innate faith, which can be of three kinds—sāttvic, rājasic, or tāmasic. Now hear about this from me. ","||2||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-","The faith of all humans conforms to the nature of their mind. All people possess faith, and whatever the nature of their faith, that is verily what they are. ","||3||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-","Those in the mode of goodness worship the celestial gods; those in the mode of passion worship the yakṣhas and rākṣhasas; those in the mode of ignorance worship ghosts and spirits. ","||4||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-","Some people perform stern austerities that are not enjoined by the scriptures, but rather motivated by hypocrisy and egotism. Impelled by desire and attachment, they torment not only the elements of their body, but also I who dwell within them as the Supreme Soul. Know these senseless people to be of demoniacal resolves. ","||5,6||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-","The food persons prefer is according to their dispositions. The same is true for the sacrifice, austerity, and charity they incline toward. Now hear of the distinctions from me. ","||7||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-","Persons in the mode of goodness prefer foods that promote the life span, and increase virtue, strength, health, happiness, and satisfaction. Such foods are juicy, succulent, nourishing, and naturally tasteful. ","||8||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-","Foods that are too bitter, too sour, salty, very hot, pungent, dry, and chiliful, are dear to persons in the mode of passion. Such foods produce pain, grief, and disease. ","||9||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-","Foods that are overcooked, stale, putrid, polluted, and impure are dear to persons in the mode of ignorance. ","||10||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-","Sacrifice that is performed according to the scriptural injunctions without expectation of rewards, with the firm conviction of the mind that it is a matter of duty is of the nature of goodness. ","||11||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-","O best of the Bharatas, know that sacrifice, which is performed for material benefit, or with hypocritical aim, to be in the mode of passion. ","||12||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-","Sacrifice devoid of faith and contrary to the injunctions of the scriptures, in which no food is offered, no mantras chanted, and no donation made, is to be considered in the mode of ignorance. ","||13||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-","Worship of the Supreme Lord, the Brahmins, the spiritual master, the wise, and the elders—when this is done with the observance of cleanliness, simplicity, celibacy, and non-violence—is declared as the austerity of the body. ","||14||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-","Words that do not cause distress, are truthful, inoffensive, and beneficial, as well as the regular recitation of the Vedic scriptures—these are declared as the austerity of speech. ","||15||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-","Serenity of thought, gentleness, silence, self-control, and purity of purpose—all these are declared as the austerity of the mind. ","||16||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-","When devout persons with ardent faith practice these three-fold austerities without yearning for material rewards, they are designated as austerities in the mode of goodness. ","||17||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-","Austerity that is performed with ostentation for the sake of gaining honor, respect, and adoration is in the mode of passion. Its benefits are unstable and transitory. ","||18||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-","Austerity that is performed by those with confused notions, and which involves torturing the self or harming others, is described to be in the mode of ignorance. ","||19||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-","Charity given to a worthy person simply because it is right to give, without consideration of anything in return, at the proper time and in the proper place, is stated to be in the mode of goodness. ","||20||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-","But charity given with reluctance, with the hope of a return or in expectation of a reward, is said to be in the mode of passion. ","||21||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-","And that charity, which is given at the wrong place and wrong time to unworthy persons, without showing respect, or with contempt, is held to be of the nature of nescience. ","||22||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-"," The words “Om Tat Sat” have been declared as symbolic representations of the Supreme Absolute Truth, from the beginning of creation. From them came the priests, scriptures, and sacrifice. ","||23||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-","Therefore, when performing acts of sacrifice, offering charity, or undertaking penance, expounders of the Vedas always begin by uttering “Om” according to the prescriptions of Vedic injunctions. ","||24||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-"," Persons who do not desire fruitive rewards, but seek to be free from material entanglements, utter the word “Tat” along with acts of austerity, sacrifice, and charity. ","||25||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-","The word “Sat” means eternal existence and goodness. O Arjun, it is also used to describe an auspicious action. Being established in the performance of sacrifice, penance, and charity, is also described by the word “Sat.” And so any act for such purposes is named “Sat.” ","||26,27||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-","O son of Pritha, whatever acts of sacrifice or penance are done without faith, are termed as “Asat.” They are useless both in this world and the next. ","||28||",R.drawable.krishna_c));
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
                            Intent intent = new Intent(Chp17.this, CloseActivity.class);
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

        //    Intent myIntent = new Intent(this, MainActivity.class);
         //   this.startActivity(myIntent);

        }

        if (id == R.id.verses){

            Intent myIntent = new Intent(this, Vchp17.class);
            this.startActivity(myIntent);

        }

        if (id == R.id.explain){

            //   Intent myIntent = new Intent(this, Explaination.class);
            //   this.startActivity(myIntent);

            new FancyGifDialog.Builder(Chp17.this)
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
      //  else{Intent myIntent = new Intent(this, com.github.gitasimplified.MainActivity.class);
       //     this.startActivity(myIntent);}

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;

    }
}
