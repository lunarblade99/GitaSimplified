package com.github.gitasimplified.vchp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
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
import com.github.gitasimplified.NewsAdapter2;
import com.github.gitasimplified.NewsItem;
import com.github.gitasimplified.R;

import java.util.ArrayList;
import java.util.List;

public class Vchp5 extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    RecyclerView NewsRecyclerview;
    NewsAdapter2 newsAdapter;
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
                Toast.makeText(Vchp5.this, "You Clicked: " + thisItem.getTitle(), Toast.LENGTH_SHORT).show();
            }
            if(position == 1) {
                Toast.makeText(Vchp5.this, "You Clicked: " + thisItem.getTitle(), Toast.LENGTH_SHORT).show();
            }
            if(position == 2) {
                Toast.makeText(Vchp5.this, "You Clicked: " + thisItem.getTitle(), Toast.LENGTH_SHORT).show();
            }

        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //requestWindowFeature(Window.FEATURE_NO_TITLE);
       // getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
        //        WindowManager.LayoutParams.FLAG_FULLSCREEN);
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
        navigationView.getMenu().getItem(4).setChecked(true);

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
        mData.add(new NewsItem("","","arjuna uvācha\n" + "sannyāsaṁ karmaṇāṁ kṛiṣhṇa punar yogaṁ cha śhansasi\n" + "yach chhreya etayor ekaṁ tan me brūhi su-niśhchitam",R.color.trans));
        mData.add(new NewsItem("","","śhrī bhagavān uvācha\n" + "sannyāsaḥ karma-yogaśh cha niḥśhreyasa-karāvubhau\n" + "tayos tu karma-sannyāsāt karma-yogo viśhiṣhyate",R.color.trans));
        mData.add(new NewsItem("","","jñeyaḥ sa nitya-sannyāsī yo na dveṣhṭi na kāṅkṣhati\n" + "nirdvandvo hi mahā-bāho sukhaṁ bandhāt pramuchyate",R.color.trans));
        mData.add(new NewsItem("","","sānkhya-yogau pṛithag bālāḥ pravadanti na paṇḍitāḥ\n" + "ekamapyāsthitaḥ samyag ubhayor vindate phalam",R.color.trans));
        mData.add(new NewsItem("","","yat sānkhyaiḥ prāpyate sthānaṁ tad yogair api gamyate\n" + "ekaṁ sānkhyaṁ cha yogaṁ cha yaḥ paśhyati sa paśhyati",R.color.trans));
        mData.add(new NewsItem("","","sannyāsas tu mahā-bāho duḥkham āptum ayogataḥ\n" + "yoga-yukto munir brahma na chireṇādhigachchhati",R.color.trans));
        mData.add(new NewsItem("","","yoga-yukto viśhuddhātmā vijitātmā jitendriyaḥ\n" + "sarva-bhūtātma-bhūtātmā kurvann api na lipyate",R.color.trans));
        mData.add(new NewsItem("","","naiva kiñchit karomīti yukto manyeta tattva-vit\n" + "paśhyañ śhṛiṇvan spṛiśhañjighrann aśhnangachchhan svapañśhvasan\n" + "pralapan visṛijan gṛihṇann unmiṣhan nimiṣhann api\n" + "indriyāṇīndriyārtheṣhu vartanta iti dhārayan",R.color.trans));
        mData.add(new NewsItem("","","\n" + "\n" + "brahmaṇyādhāya karmāṇi saṅgaṁ tyaktvā karoti yaḥ\n" + "lipyate na sa pāpena padma-patram ivāmbhasā\n",R.color.trans));
        mData.add(new NewsItem("","","kāyena manasā buddhyā kevalair indriyair api\n" + "yoginaḥ karma kurvanti saṅgaṁ tyaktvātma-śhuddhaye",R.color.trans));
        mData.add(new NewsItem("","","yuktaḥ karma-phalaṁ tyaktvā śhāntim āpnoti naiṣhṭhikīm\n" + "ayuktaḥ kāma-kāreṇa phale sakto nibadhyate",R.color.trans));
        mData.add(new NewsItem("","","sarva-karmāṇi manasā sannyasyāste sukhaṁ vaśhī\n" + "nava-dvāre pure dehī naiva kurvan na kārayan",R.color.trans));
        mData.add(new NewsItem("","","na kartṛitvaṁ na karmāṇi lokasya sṛijati prabhuḥ\n" + "na karma-phala-saṅyogaṁ svabhāvas tu pravartate",R.color.trans));
        mData.add(new NewsItem("","","nādatte kasyachit pāpaṁ na chaiva sukṛitaṁ vibhuḥ\n" + "ajñānenāvṛitaṁ jñānaṁ tena muhyanti jantavaḥ",R.color.trans));
        mData.add(new NewsItem("","","jñānena tu tad ajñānaṁ yeṣhāṁ nāśhitam ātmanaḥ\n" + "teṣhām āditya-vaj jñānaṁ prakāśhayati tat param",R.color.trans));
        mData.add(new NewsItem("","","tad-buddhayas tad-ātmānas tan-niṣhṭhās tat-parāyaṇāḥ\n" + "gachchhantyapunar-āvṛittiṁ jñāna-nirdhūta-kalmaṣhāḥ",R.color.trans));
        mData.add(new NewsItem("","","vidyā-vinaya-sampanne brāhmaṇe gavi hastini\n" + "śhuni chaiva śhva-pāke cha paṇḍitāḥ sama-darśhinaḥ",R.color.trans));
        mData.add(new NewsItem("","","ihaiva tair jitaḥ sargo yeṣhāṁ sāmye sthitaṁ manaḥ\n" + "nirdoṣhaṁ hi samaṁ brahma tasmād brahmaṇi te sthitāḥ",R.color.trans));
        mData.add(new NewsItem("","","na prahṛiṣhyet priyaṁ prāpya nodvijet prāpya chāpriyam\n" + "sthira-buddhir asammūḍho brahma-vid brahmaṇi sthitaḥ",R.color.trans));
        mData.add(new NewsItem("","","bāhya-sparśheṣhvasaktātmā vindatyātmani yat sukham\n" + "sa brahma-yoga-yuktātmā sukham akṣhayam aśhnute",R.color.trans));
        mData.add(new NewsItem("","","ye hi sansparśha-jā bhogā duḥkha-yonaya eva te\n" + "ādyantavantaḥ kaunteya na teṣhu ramate budhaḥ",R.color.trans));
        mData.add(new NewsItem("","","śhaknotīhaiva yaḥ soḍhuṁ prāk śharīra-vimokṣhaṇāt\n" + "kāma-krodhodbhavaṁ vegaṁ sa yuktaḥ sa sukhī naraḥ",R.color.trans));
        mData.add(new NewsItem("","","yo 'ntaḥ-sukho 'ntar-ārāmas tathāntar-jyotir eva yaḥ\n" + "sa yogī brahma-nirvāṇaṁ brahma-bhūto 'dhigachchhati",R.color.trans));
        mData.add(new NewsItem("","","labhante brahma-nirvāṇam ṛiṣhayaḥ kṣhīṇa-kalmaṣhāḥ\n" + "chhinna-dvaidhā yatātmānaḥ sarva-bhūta-hite ratāḥ",R.color.trans));
        mData.add(new NewsItem("","","kāma-krodha-viyuktānāṁ yatīnāṁ yata-chetasām\n" + "abhito brahma-nirvāṇaṁ vartate viditātmanām",R.color.trans));
        mData.add(new NewsItem("","","sparśhān kṛitvā bahir bāhyānśh chakṣhuśh chaivāntare bhruvoḥ\n" + "prāṇāpānau samau kṛitvā nāsābhyantara-chāriṇau\n" + "yatendriya-mano-buddhir munir mokṣha-parāyaṇaḥ\n" + "vigatechchhā-bhaya-krodho yaḥ sadā mukta eva saḥ",R.color.trans));
        mData.add(new NewsItem("","","bhoktāraṁ yajña-tapasāṁ sarva-loka-maheśhvaram\n" + "suhṛidaṁ sarva-bhūtānāṁ jñātvā māṁ śhāntim ṛichchhati",R.color.trans));
        // adapter ini and setup

        newsAdapter = new NewsAdapter2(this,mData,isDark);
        NewsRecyclerview.setAdapter(newsAdapter);
        NewsRecyclerview.setLayoutManager(new LinearLayoutManager(this));
        NewsAdapter2.setOnItemClickListener(onItemClickListener);

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

                newsAdapter = new NewsAdapter2(getApplicationContext(),mData,isDark);
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
        getMenuInflater().inflate(R.menu.main2, menu);
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
            Intent myIntent = new Intent(this, Main2Activity.class);
            this.startActivity(myIntent);

        }
        if (id2 == R.id.two) {
            Intent myIntent = new Intent(this, Vchp2.class);
            this.startActivity(myIntent);

        }
        if (id2 == R.id.three) {
            Intent myIntent = new Intent(this, Vchp3.class);
            this.startActivity(myIntent);

        }
        if (id2 == R.id.four) {
            Intent myIntent = new Intent(this, Vchp4.class);
            this.startActivity(myIntent);

        }if (id2 == R.id.five) {
            Intent myIntent = new Intent(this, Vchp5.class);
            this.startActivity(myIntent);

        }
        if (id2 == R.id.six) {
            Intent myIntent = new Intent(this, Vchp6.class);
            this.startActivity(myIntent);

        }if (id2 == R.id.seven) {
            Intent myIntent = new Intent(this, Vchp7.class);
            this.startActivity(myIntent);

        }
        if (id2 == R.id.eight) {
            Intent myIntent = new Intent(this, Vchp8.class);
            this.startActivity(myIntent);

        }if (id2 == R.id.nine) {
            Intent myIntent = new Intent(this, Vchp9.class);
            this.startActivity(myIntent);

        }
        if (id2 == R.id.ten) {
            Intent myIntent = new Intent(this, Vchp10.class);
            this.startActivity(myIntent);

        }if (id2 == R.id.eleven) {
            Intent myIntent = new Intent(this, Vchp11.class);
            this.startActivity(myIntent);

        }
        if (id2 == R.id.twelve) {
            Intent myIntent = new Intent(this, Vchp12.class);
            this.startActivity(myIntent);

        }if (id2 == R.id.thirteen) {
            Intent myIntent = new Intent(this, Vchp13.class);
            this.startActivity(myIntent);

        }
        if (id2 == R.id.fourteen) {
            Intent myIntent = new Intent(this, Vchp14.class);
            this.startActivity(myIntent);

        }if (id2 == R.id.fifteen) {
            Intent myIntent = new Intent(this, Vchp15.class);
            this.startActivity(myIntent);

        }
        if (id2 == R.id.sixteen) {
            Intent myIntent = new Intent(this, Vchp16.class);
            this.startActivity(myIntent);

        }if (id2 == R.id.seventeen) {
            Intent myIntent = new Intent(this, Vchp17.class);
            this.startActivity(myIntent);

        }
        if (id2 == R.id.eighteen) {
            Intent myIntent = new Intent(this, Vchp18.class);
            this.startActivity(myIntent);

        }
        //else{Toast.makeText(MainActivity.this, "You Clicked: ", Toast.LENGTH_SHORT).show(); }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;

    }
}