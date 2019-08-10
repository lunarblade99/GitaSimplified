package com.github.gitasimplified;

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
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.Toast;

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
import com.github.gitasimplified.vchp.Vchp10;
import com.github.gitasimplified.vchp.Vchp11;
import com.github.gitasimplified.vchp.Vchp12;
import com.github.gitasimplified.vchp.Vchp13;
import com.github.gitasimplified.vchp.Vchp14;
import com.github.gitasimplified.vchp.Vchp15;
import com.github.gitasimplified.vchp.Vchp16;
import com.github.gitasimplified.vchp.Vchp17;
import com.github.gitasimplified.vchp.Vchp18;
import com.github.gitasimplified.vchp.Vchp2;
import com.github.gitasimplified.vchp.Vchp3;
import com.github.gitasimplified.vchp.Vchp4;
import com.github.gitasimplified.vchp.Vchp5;
import com.github.gitasimplified.vchp.Vchp6;
import com.github.gitasimplified.vchp.Vchp7;
import com.github.gitasimplified.vchp.Vchp8;
import com.github.gitasimplified.vchp.Vchp9;

import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends AppCompatActivity
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
                Toast.makeText(Main2Activity.this, "You Clicked: " + thisItem.getTitle(), Toast.LENGTH_SHORT).show();
            }
            if(position == 1) {
                Toast.makeText(Main2Activity.this, "You Clicked: " + thisItem.getTitle(), Toast.LENGTH_SHORT).show();
            }
            if(position == 2) {
                Toast.makeText(Main2Activity.this, "You Clicked: " + thisItem.getTitle(), Toast.LENGTH_SHORT).show();
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
        mData.add(new NewsItem("धृतराष्ट्र उवाच |\n" + "धर्मक्षेत्रे कुरुक्षेत्रे समवेता युयुत्सवः |\n" + "मामकाः पाण्डवाश्चैव किमकुर्वत सञ्जय ||1||","dhṛitarāśhtraḥ uvācha—Dhritarashtra said; dharma-kṣhetre—the land of dharma; kuru-kṣhetre—at Kurukshetra; samavetāḥ—having gathered; yuyutsavaḥ—desiring to fight; māmakāḥ—my sons; pāṇḍavāḥ—the sons of Pandu; cha—and; eva—certainly; kim—what; akurvata—did they do; sañjaya—Sanjay ","dhṛitarāśhtra uvācha\n" + "dharma-kṣhetre kuru-kṣhetre samavetā yuyutsavaḥ\n" + "māmakāḥ pāṇḍavāśhchaiva kimakurvata sañjaya",R.color.trans));
        mData.add(new NewsItem("सञ्जय उवाच ।\n" + "दृष्ट्वा तु पाण्डवानीकं व्यूढं दुर्योधनस्तदा ।\n" + "आचार्यमुपसङ्गम्य राजा वचनमब्रवीत् ।। 2।।"," sanjayaḥ uvācha—Sanjay said; dṛiṣhṭvā—on observing; tu—but; pāṇḍava-anīkam—the Pandava army; vyūḍham—standing in a military formation; duryodhanaḥ—King Duryodhan; tadā—then; āchāryam—teacher; upasaṅgamya—approached; rājā—the king; vachanam—words; abravīt—spoke ","sañjaya uvācha\n" + "dṛiṣhṭvā tu pāṇḍavānīkaṁ vyūḍhaṁ duryodhanastadā\n" + "āchāryamupasaṅgamya rājā vachanamabravīt",R.color.trans));
        mData.add(new NewsItem("पश्यैतां पाण्डुपुत्राणामाचार्य महतीं चमूम् ।\n" + "व्यूढां द्रुपदपुत्रेण तव शिष्येण धीमता ।। 3।।"," paśhya—behold; etām—this; pāṇḍu-putrāṇām—of the sons of Pandu; āchārya—respected teacher; mahatīm—mighty; chamūm—army; vyūḍhām—arrayed in a military formation; drupada-putreṇa—son of Drupad, Dhrishtadyumna; tava—by your; śhiṣhyeṇa—disciple; dhī-matā—intelligent ","sañjaya uvācha\n" + "dṛiṣhṭvā tu pāṇḍavānīkaṁ vyūḍhaṁ duryodhanastadā\n" + "āchāryamupasaṅgamya rājā vachanamabravīt",R.color.trans));
        mData.add(new NewsItem("","","atra śhūrā maheṣhvāsā bhīmārjuna-samā yudhi\n" + "yuyudhāno virāṭaśhcha drupadaśhcha mahā-rathaḥ\n" + "dhṛiṣhṭaketuśhchekitānaḥ kāśhirājaśhcha vīryavān\n" + "purujit kuntibhojaśhcha śhaibyaśhcha nara-puṅgavaḥ\n" + "yudhāmanyuśhcha vikrānta uttamaujāśhcha vīryavān\n" + "saubhadro draupadeyāśhcha sarva eva mahā-rathāḥ",R.color.trans));
        mData.add(new NewsItem("","","asmākaṁ tu viśhiṣhṭā ye tānnibodha dwijottama\n" + "nāyakā mama sainyasya sanjñārthaṁ tānbravīmi te",R.color.trans));
        mData.add(new NewsItem("","","bhavānbhīṣhmaśhcha karṇaśhcha kṛipaśhcha samitiñjayaḥ\n" + "aśhvatthāmā vikarṇaśhcha saumadattis tathaiva cha",R.color.trans));
        mData.add(new NewsItem("","","anye cha bahavaḥ śhūrā madarthe tyaktajīvitāḥ\n" + "nānā-śhastra-praharaṇāḥ sarve yuddha-viśhāradāḥ",R.color.trans));
        mData.add(new NewsItem("","","aparyāptaṁ tadasmākaṁ balaṁ bhīṣhmābhirakṣhitam\n" + "paryāptaṁ tvidameteṣhāṁ balaṁ bhīmābhirakṣhitam",R.color.trans));
        mData.add(new NewsItem("","","ayaneṣhu cha sarveṣhu yathā-bhāgamavasthitāḥ\n" + "bhīṣhmamevābhirakṣhantu bhavantaḥ sarva eva hi",R.color.trans));
        mData.add(new NewsItem("","","tasya sañjanayan harṣhaṁ kuru-vṛiddhaḥ pitāmahaḥ\n" + "siṁha-nādaṁ vinadyochchaiḥ śhaṅkhaṁ dadhmau pratāpavān",R.color.trans));
        mData.add(new NewsItem("","","tataḥ śhaṅkhāśhcha bheryaśhcha paṇavānaka-gomukhāḥ\n" + "sahasaivābhyahanyanta sa śhabdastumulo ’bhavat",R.color.trans));
        mData.add(new NewsItem("","","tataḥ śhvetairhayairyukte mahati syandane sthitau\n" + "mādhavaḥ pāṇḍavaśhchaiva divyau śhaṅkhau pradadhmatuḥ",R.color.trans));
        mData.add(new NewsItem("","","pāñchajanyaṁ hṛiṣhīkeśho devadattaṁ dhanañjayaḥ\n" + "pauṇḍraṁ dadhmau mahā-śhaṅkhaṁ bhīma-karmā vṛikodaraḥ",R.color.trans));
        mData.add(new NewsItem("","","anantavijayaṁ rājā kuntī-putro yudhiṣhṭhiraḥ\n" + "nakulaḥ sahadevaśhcha sughoṣha-maṇipuṣhpakau\n" + "kāśhyaśhcha parameṣhvāsaḥ śhikhaṇḍī cha mahā-rathaḥ\n" + "dhṛiṣhṭadyumno virāṭaśhcha sātyakiśh chāparājitaḥ\n" + "drupado draupadeyāśhcha sarvaśhaḥ pṛithivī-pate\n" + "saubhadraśhcha mahā-bāhuḥ śhaṅkhāndadhmuḥ pṛithak pṛithak",R.color.trans));
        mData.add(new NewsItem("","","sa ghoṣho dhārtarāṣhṭrāṇāṁ hṛidayāni vyadārayat\n" + "nabhaśhcha pṛithivīṁ chaiva tumulo nunādayan",R.color.trans));
        mData.add(new NewsItem("","","atha vyavasthitān dṛiṣhṭvā dhārtarāṣhṭrān kapi-dhwajaḥ\n" + "pravṛitte śhastra-sampāte dhanurudyamya pāṇḍavaḥ\n" + "hṛiṣhīkeśhaṁ tadā vākyam idam āha mahī-pate",R.color.trans));
        mData.add(new NewsItem("","","senayor ubhayor madhye rathaṁ sthāpaya me ’chyuta\n" + "yāvadetān nirīkṣhe ’haṁ yoddhu-kāmān avasthitān\n" + "kairmayā saha yoddhavyam asmin raṇa-samudyame",R.color.trans));
        mData.add(new NewsItem("","","yotsyamānān avekṣhe ’haṁ ya ete ’tra samāgatāḥ\n" + "dhārtarāṣhṭrasya durbuddher yuddhe priya-chikīrṣhavaḥ",R.color.trans));
        mData.add(new NewsItem("","","\n" + "\n" + "sañjaya uvācha\n" + "evam ukto hṛiṣhīkeśho guḍākeśhena bhārata\n" + "senayor ubhayor madhye sthāpayitvā rathottamam\n",R.color.trans));
        mData.add(new NewsItem("","","bhīṣhma-droṇa-pramukhataḥ sarveṣhāṁ cha mahī-kṣhitām\n" + "uvācha pārtha paśhyaitān samavetān kurūn iti",R.color.trans));
        mData.add(new NewsItem("","","tatrāpaśhyat sthitān pārthaḥ pitṝīn atha pitāmahān\n" + "āchāryān mātulān bhrātṝīn putrān pautrān sakhīṁs tathā\n" + "śhvaśhurān suhṛidaśh chaiva senayor ubhayor api",R.color.trans));
        mData.add(new NewsItem("","","tān samīkṣhya sa kaunteyaḥ sarvān bandhūn avasthitān\n" + "kṛipayā parayāviṣhṭo viṣhīdann idam abravīt",R.color.trans));
        mData.add(new NewsItem("","","arjuna uvācha\n" + "dṛiṣhṭvemaṁ sva-janaṁ kṛiṣhṇa yuyutsuṁ samupasthitam\n" + "sīdanti mama gātrāṇi mukhaṁ cha pariśhuṣhyati",R.color.trans));
        mData.add(new NewsItem("","","vepathuśh cha śharīre me roma-harṣhaśh cha jāyate\n" + "gāṇḍīvaṁ sraṁsate hastāt tvak chaiva paridahyate\n" + "na cha śhaknomy avasthātuṁ bhramatīva cha me manaḥ\n" + "nimittāni cha paśhyāmi viparītāni keśhava\n" + "na cha śhreyo ’nupaśhyāmi hatvā sva-janam āhave",R.color.trans));
        mData.add(new NewsItem("","","na kāṅkṣhe vijayaṁ kṛiṣhṇa na cha rājyaṁ sukhāni cha\n" + "kiṁ no rājyena govinda kiṁ bhogair jīvitena vā\n" + "yeṣhām arthe kāṅkṣhitaṁ no rājyaṁ bhogāḥ sukhāni cha\n" + "ta ime ’vasthitā yuddhe prāṇāṁs tyaktvā dhanāni cha",R.color.trans));
        mData.add(new NewsItem("","","\n" + "\n" + "āchāryāḥ pitaraḥ putrās tathaiva cha pitāmahāḥ\n" + "mātulāḥ śhvaśhurāḥ pautrāḥ śhyālāḥ sambandhinas tathā\n" + "\n" + "etān na hantum ichchhāmi ghnato ’pi madhusūdana\n" + "api trailokya-rājyasya hetoḥ kiṁ nu mahī-kṛite\n",R.color.trans));
        mData.add(new NewsItem("","","nihatya dhārtarāṣhṭrān naḥ kā prītiḥ syāj janārdana\n" + "pāpam evāśhrayed asmān hatvaitān ātatāyinaḥ\n" + "tasmān nārhā vayaṁ hantuṁ dhārtarāṣhṭrān sa-bāndhavān\n" + "sva-janaṁ hi kathaṁ hatvā sukhinaḥ syāma mādhava",R.color.trans));
        mData.add(new NewsItem("","","yady apy ete na paśhyanti lobhopahata-chetasaḥ\n" + "kula-kṣhaya-kṛitaṁ doṣhaṁ mitra-drohe cha pātakam\n" + "kathaṁ na jñeyam asmābhiḥ pāpād asmān nivartitum\n" + "kula-kṣhaya-kṛitaṁ doṣhaṁ prapaśhyadbhir janārdana",R.color.trans));
        mData.add(new NewsItem("","","kula-kṣhaye praṇaśhyanti kula-dharmāḥ sanātanāḥ\n" + "dharme naṣhṭe kulaṁ kṛitsnam adharmo ’bhibhavaty uta",R.color.trans));
        mData.add(new NewsItem("","","adharmābhibhavāt kṛiṣhṇa praduṣhyanti kula-striyaḥ\n" + "strīṣhu duṣhṭāsu vārṣhṇeya jāyate varṇa-saṅkaraḥ",R.color.trans));
        mData.add(new NewsItem("","","saṅkaro narakāyaiva kula-ghnānāṁ kulasya cha\n" + "patanti pitaro hy eṣhāṁ lupta-piṇḍodaka-kriyāḥ",R.color.trans));
        mData.add(new NewsItem("","","doṣhair etaiḥ kula-ghnānāṁ varṇa-saṅkara-kārakaiḥ\n" + "utsādyante jāti-dharmāḥ kula-dharmāśh cha śhāśhvatāḥ",R.color.trans));
        mData.add(new NewsItem("","","utsanna-kula-dharmāṇāṁ manuṣhyāṇāṁ janārdana\n" + "narake ‘niyataṁ vāso bhavatītyanuśhuśhruma",R.color.trans));
        mData.add(new NewsItem("","","aho bata mahat pāpaṁ kartuṁ vyavasitā vayam\n" + "yad rājya-sukha-lobhena hantuṁ sva-janam udyatāḥ\n" + "yadi mām apratīkāram aśhastraṁ śhastra-pāṇayaḥ\n" + "dhārtarāṣhṭrā raṇe hanyus tan me kṣhemataraṁ bhavet",R.color.trans));
        mData.add(new NewsItem("","","sañjaya uvācha\n" + "evam uktvārjunaḥ saṅkhye rathopastha upāviśhat\n" + "visṛijya sa-śharaṁ chāpaṁ śhoka-saṁvigna-mānasaḥ",R.color.trans));



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