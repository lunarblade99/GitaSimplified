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
import com.github.gitasimplified.vchp.Vchp3;

import java.util.ArrayList;
import java.util.List;

public class Chp3 extends AppCompatActivity
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
        navigationView.getMenu().getItem(2).setChecked(true);

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
        mData.add(new NewsItem("Arjuna uvācha :-","Arjun said: O Janardan, if you consider knowledge superior to action, then why do you ask me to wage this terrible war? My intellect is bewildered by your ambiguous advice. Please tell me decisively the one path by which I may attain the highest good. ","||1,2||",R.drawable.target));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-","The Blessed Lord said: O sinless one, the two paths leading to enlightenment were previously explained by me: the path of knowledge, for those inclined toward contemplation, and the path of work for those inclined toward action. ","||3||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-","One cannot achieve freedom from karmic reactions by merely abstaining from work, nor can one attain perfection of knowledge by mere physical renunciation. ","||4||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-","There is no one who can remain without action even for a moment. Indeed, all beings are compelled to act by their qualities born of material nature (the three guṇas). ","||5||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-","Those who restrain the external organs of action, while continuing to dwell on sense objects in the mind, certainly delude themselves and are to be called hypocrites. ","||6||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-","But those karm yogis who control their knowledge senses with the mind, O Arjun, and engage the working senses in working without attachment, are certainly superior. ","||7||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-","You should thus perform your prescribed Vedic duties, since action is superior to inaction. By ceasing activity, even your bodily maintenance will not be possible. ","||8||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-","Work must be done as a yajña (sacrifice) to the Supreme Lord; otherwise, work causes bondage in this material world. Therefore, O son of Kunti, perform your prescribed duties, without being attached to the results, for the satisfaction of God. ","||9||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-","In the beginning of creation, Brahma created humankind along with duties, and said, “Prosper in the performance of these yajñas (sacrifices), for they shall bestow upon you all you wish to achieve.” ","||10||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-","By your sacrifices the celestial gods will be pleased, and by cooperation between humans and the celestial gods, prosperity will reign for all. ","||11||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-","The celestial gods, being satisfied by the performance of sacrifice, will grant you all the desired necessities of life. But those who enjoy what is given to them, without making offerings in return, are verily thieves. ","||12||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-","The spiritually-minded, who eat food that is first offered in sacrifice, are released from all kinds of sin. Others, who cook food for their own enjoyment, verily eat only sin. ","||13||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-","All living beings subsist on food, and food is produced by rains. Rains come from the performance of sacrifice, and sacrifice is produced by the performance of prescribed duties.","||14||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-","The duties for human beings are described in the Vedas, and the Vedas are manifested by God himself. Therefore, the all-pervading Lord is eternally present in acts of sacrifice. ","||15||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-","O Parth, those who do not accept their responsibility in the cycle of sacrifice established by the Vedas are sinful. They live only for the delight of their senses; indeed their lives are in vain. ","||16||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-","But those who rejoice in the self, who are illumined and fully satisfied in the self, for them, there is no duty. ","||17||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-","Such self-realized souls have nothing to gain or lose either in discharging or renouncing their duties. Nor do they need to depend on other living beings to fulfill their self-interest. ","||18||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-","Therefore, giving up attachment, perform actions as a matter of duty, for by working without being attached to the fruits, one attains the Supreme. ","||19||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-","By performing their prescribed duties, King Janak and others attained perfection. You should also perform your work to set an example for the good of the world. Whatever actions great persons perform, common people follow. Whatever standards they set, all the world pursues. ","||20,21||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-","There is no duty for me to do in all the three worlds, O Parth, nor do I have anything to gain or attain. Yet, I am engaged in prescribed duties. ","||22||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-","For if I did not carefully perform the prescribed duties, O Parth, all men would follow my path in all respects. ","||23||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-","If I ceased to perform prescribed actions, all these worlds would perish. I would be responsible for the pandemonium that would prevail, and would thereby destroy the peace of the human race. ","||24||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-","As ignorant people perform their duties with attachment to the results, O scion of Bharat, so should the wise act without attachment, for the sake of leading people on the right path. ","||25||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-","The wise should not create discord in the intellects of ignorant people, who are attached to fruitive actions, by inducing them to stop work. Rather, by performing their duties in an enlightened manner, they should inspire the ignorant also to do their prescribed duties. ","||26||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-"," All activities are carried out by the three modes of material nature. But in ignorance, the soul, deluded by false identification with the body, thinks itself to be the doer. ","||27||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-","O mighty-armed Arjun, illumined persons distinguish the soul as distinct from guṇas and karmas. They perceive that it is only the guṇas (in the shape of the senses, mind, etc.) that move amongst the guṇas (in the shape of the objects of perception), and thus they do not get entangled in them.","||28||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-","Those who are deluded by the operation of the guṇas become attached to the results of their actions. But the wise who understand these truths should not unsettle such ignorant people who know very little. ","||29||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-","Performing all works as an offering unto me, constantly meditate on me as the Supreme. Become free from desire and selfishness, and with your mental grief departed, fight! ","||30||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-","Those who abide by these teachings of mine, with profound faith and free from cavil, are released from the bondage of karma. ","||31||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-","But those who find faults with my teachings, being bereft of knowledge and devoid of discrimination, they disregard these principles and bring about their own ruin. ","||32||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-","Even wise people act according to their natures, for all living beings are propelled by their natural tendencies. What will one gain by repression? ","||33||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-","The senses naturally experience attachment and aversion to the sense objects, but do not be controlled by them, for they are way-layers and foes. ","||34||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-","It is far better to perform one’s natural prescribed duty, though tinged with faults, than to perform another’s prescribed duty, though perfectly. In fact, it is preferable to die in the discharge of one’s duty, than to follow the path of another, which is fraught with danger. ","||35||",R.drawable.krishna_c));
        mData.add(new NewsItem("Arjuna uvācha :-","Arjun asked: Why is a person impelled to commit sinful acts, even unwillingly, as if by force, O descendent of Vrishni (Krishna)? ","||36||",R.drawable.target));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-","The Supreme Lord said: It is lust alone, which is born of contact with the mode of passion, and later transformed into anger. Know this as the sinful, all-devouring enemy in the world. ","||37||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-","Just as a fire is covered by smoke, a mirror is masked by dust, and an embryo is concealed by the womb, similarly one’s knowledge gets shrouded by desire. ","||38||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-","The knowledge of even the most discerning gets covered by this perpetual enemy in the form of insatiable desire, which is never satisfied and burns like fire, O son of Kunti. ","||39||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-","The senses, mind, and intellect are said to be breeding grounds of desire. Through them, it clouds one’s knowledge and deludes the embodied soul. ","||40||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-","Therefore, O best of the Bharatas, in the very beginning bring the senses under control and slay this enemy called desire, which is the embodiment of sin and destroys knowledge and realization. ","||41||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-","The senses are superior to the gross body, and superior to the senses is the mind. Beyond the mind is the intellect, and even beyond the intellect is the soul. ","||42||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-","Thus knowing the soul to be superior to the material intellect, O mighty armed Arjun, subdue the self (senses, mind, and intellect) by the self (strength of the soul), and kill this formidable enemy called lust. ","||43||",R.drawable.krishna_c));
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

         //   Intent myIntent = new Intent(this, MainActivity.class);
         //   this.startActivity(myIntent);

        }

        if (id == R.id.verses){

            Intent myIntent = new Intent(this, Vchp3.class);
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
      //  else{Toast.makeText(Chp3.this, "3 : ", Toast.LENGTH_SHORT).show(); }


        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;

    }
}
