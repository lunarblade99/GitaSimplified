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

public class Vchp10 extends AppCompatActivity
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
                Toast.makeText(Vchp10.this, "You Clicked: " + thisItem.getTitle(), Toast.LENGTH_SHORT).show();
            }
            if(position == 1) {
                Toast.makeText(Vchp10.this, "You Clicked: " + thisItem.getTitle(), Toast.LENGTH_SHORT).show();
            }
            if(position == 2) {
                Toast.makeText(Vchp10.this, "You Clicked: " + thisItem.getTitle(), Toast.LENGTH_SHORT).show();
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
        mData.add(new NewsItem("","","śhrī bhagavān uvācha\n" + "bhūya eva mahā-bāho śhṛiṇu me paramaṁ vachaḥ\n" + "yatte ’haṁ prīyamāṇāya vakṣhyāmi hita-kāmyayā",R.color.trans));
        mData.add(new NewsItem("","","na me viduḥ sura-gaṇāḥ prabhavaṁ na maharṣhayaḥ\n" + "aham ādir hi devānāṁ maharṣhīṇāṁ cha sarvaśhaḥ",R.color.trans));
        mData.add(new NewsItem("","","yo māmajam anādiṁ cha vetti loka-maheśhvaram\n" + "asammūḍhaḥ sa martyeṣhu sarva-pāpaiḥ pramuchyate",R.color.trans));
        mData.add(new NewsItem("","","buddhir jñānam asammohaḥ kṣhamā satyaṁ damaḥ śhamaḥ\n" + "sukhaṁ duḥkhaṁ bhavo ’bhāvo bhayaṁ chābhayameva cha\n" + "ahinsā samatā tuṣhṭis tapo dānaṁ yaśho ’yaśhaḥ\n" + "bhavanti bhāvā bhūtānāṁ matta eva pṛithag-vidhāḥ",R.color.trans));
        mData.add(new NewsItem("","","maharṣhayaḥ sapta pūrve chatvāro manavas tathā\n" + "mad-bhāvā mānasā jātā yeṣhāṁ loka imāḥ prajāḥ",R.color.trans));
        mData.add(new NewsItem("","","etāṁ vibhūtiṁ yogaṁ cha mama yo vetti tattvataḥ\n" + "so ’vikampena yogena yujyate nātra sanśhayaḥ",R.color.trans));
        mData.add(new NewsItem("","","ahaṁ sarvasya prabhavo mattaḥ sarvaṁ pravartate\n" + "iti matvā bhajante māṁ budhā bhāva-samanvitāḥ",R.color.trans));
        mData.add(new NewsItem("","","mach-chittā mad-gata-prāṇā bodhayantaḥ parasparam\n" + "kathayantaśh cha māṁ nityaṁ tuṣhyanti cha ramanti cha",R.color.trans));
        mData.add(new NewsItem("","","teṣhāṁ satata-yuktānāṁ bhajatāṁ prīti-pūrvakam\n" + "dadāmi buddhi-yogaṁ taṁ yena mām upayānti te",R.color.trans));
        mData.add(new NewsItem("","","teṣhām evānukampārtham aham ajñāna-jaṁ tamaḥ\n" + "nāśhayāmyātma-bhāva-stho jñāna-dīpena bhāsvatā",R.color.trans));
        mData.add(new NewsItem("","","arjuna uvācha\n" + "paraṁ brahma paraṁ dhāma pavitraṁ paramaṁ bhavān\n" + "puruṣhaṁ śhāśhvataṁ divyam ādi-devam ajaṁ vibhum\n" + "āhus tvām ṛiṣhayaḥ sarve devarṣhir nāradas tathā\n" + "asito devalo vyāsaḥ svayaṁ chaiva bravīṣhi me",R.color.trans));
        mData.add(new NewsItem("","","sarvam etad ṛitaṁ manye yan māṁ vadasi keśhava\n" + "na hi te bhagavan vyaktiṁ vidur devā na dānavāḥ",R.color.trans));
        mData.add(new NewsItem("","","swayam evātmanātmānaṁ vettha tvaṁ puruṣhottama\n" + "bhūta-bhāvana bhūteśha deva-deva jagat-pate",R.color.trans));
        mData.add(new NewsItem("","","vaktum arhasyaśheṣheṇa divyā hyātma-vibhūtayaḥ\n" + "yābhir vibhūtibhir lokān imāṁs tvaṁ vyāpya tiṣhṭhasi\n" + "kathaṁ vidyām ahaṁ yogins tvāṁ sadā parichintayan\n" + "keṣhu keṣhu cha bhāveṣhu chintyo ’si bhagavan mayā",R.color.trans));
        mData.add(new NewsItem("","","vistareṇātmano yogaṁ vibhūtiṁ cha janārdana\n" + "bhūyaḥ kathaya tṛiptir hi śhṛiṇvato nāsti me ’mṛitam",R.color.trans));
        mData.add(new NewsItem("","","śhrī bhagavān uvācha\n" + "hanta te kathayiṣhyāmi divyā hyātma-vibhūtayaḥ\n" + "prādhānyataḥ kuru-śhreṣhṭha nāstyanto vistarasya me",R.color.trans));
        mData.add(new NewsItem("","","aham ātmā guḍākeśha sarva-bhūtāśhaya-sthitaḥ\n" + "aham ādiśh cha madhyaṁ cha bhūtānām anta eva cha",R.color.trans));
        mData.add(new NewsItem("","","ādityānām ahaṁ viṣhṇur jyotiṣhāṁ ravir anśhumān\n" + "marīchir marutām asmi nakṣhatrāṇām ahaṁ śhaśhī",R.color.trans));
        mData.add(new NewsItem("","","vedānāṁ sāma-vedo ’smi devānām asmi vāsavaḥ\n" + "indriyāṇāṁ manaśh chāsmi bhūtānām asmi chetanā",R.color.trans));
        mData.add(new NewsItem("","","rudrāṇāṁ śhaṅkaraśh chāsmi vitteśho yakṣha-rakṣhasām\n" + "vasūnāṁ pāvakaśh chāsmi meruḥ śhikhariṇām aham",R.color.trans));
        mData.add(new NewsItem("","","purodhasāṁ cha mukhyaṁ māṁ viddhi pārtha bṛihaspatim\n" + "senānīnām ahaṁ skandaḥ sarasām asmi sāgaraḥ",R.color.trans));
        mData.add(new NewsItem("","","maharṣhīṇāṁ bhṛigur ahaṁ girām asmyekam akṣharam\n" + "yajñānāṁ japa-yajño ’smi sthāvarāṇāṁ himālayaḥ",R.color.trans));
        mData.add(new NewsItem("","","aśhvatthaḥ sarva-vṛikṣhāṇāṁ devarṣhīṇāṁ cha nāradaḥ\n" + "gandharvāṇāṁ chitrarathaḥ siddhānāṁ kapilo muniḥ",R.color.trans));
        mData.add(new NewsItem("","","uchchaiḥśhravasam aśhvānāṁ viddhi mām amṛitodbhavam\n" + "airāvataṁ gajendrāṇāṁ narāṇāṁ cha narādhipam",R.color.trans));
        mData.add(new NewsItem("","","āyudhānām ahaṁ vajraṁ dhenūnām asmi kāmadhuk\n" + "prajanaśh chāsmi kandarpaḥ sarpāṇām asmi vāsukiḥ",R.color.trans));
        mData.add(new NewsItem("","","anantaśh chāsmi nāgānāṁ varuṇo yādasām aham\n" + "pitṝīṇām aryamā chāsmi yamaḥ sanyamatām aham",R.color.trans));
        mData.add(new NewsItem("","","prahlādaśh chāsmi daityānāṁ kālaḥ kalayatām aham\n" + "mṛigāṇāṁ cha mṛigendro ’haṁ vainateyaśh cha pakṣhiṇām",R.color.trans));
        mData.add(new NewsItem("","","pavanaḥ pavatām asmi rāmaḥ śhastra-bhṛitām aham\n" + "jhaṣhāṇāṁ makaraśh chāsmi srotasām asmi jāhnavī",R.color.trans));
        mData.add(new NewsItem("","","sargāṇām ādir antaśh cha madhyaṁ chaivāham arjuna\n" + "adhyātma-vidyā vidyānāṁ vādaḥ pravadatām aham",R.color.trans));
        mData.add(new NewsItem("","","akṣharāṇām a-kāro ’smi dvandvaḥ sāmāsikasya cha\n" + "aham evākṣhayaḥ kālo dhātāhaṁ viśhvato-mukhaḥ",R.color.trans));
        mData.add(new NewsItem("","","mṛityuḥ sarva-haraśh chāham udbhavaśh cha bhaviṣhyatām\n" + "kīrtiḥ śhrīr vāk cha nārīṇāṁ smṛitir medhā dhṛitiḥ kṣhamā",R.color.trans));
        mData.add(new NewsItem("","","bṛihat-sāma tathā sāmnāṁ gāyatrī chhandasām aham\n" + "māsānāṁ mārga-śhīrṣho ’ham ṛitūnāṁ kusumākaraḥ",R.color.trans));
        mData.add(new NewsItem("","","dyūtaṁ chhalayatām asmi tejas tejasvinām aham\n" + "jayo ’smi vyavasāyo ’smi sattvaṁ sattvavatām aham",R.color.trans));
        mData.add(new NewsItem("","","vṛiṣhṇīnāṁ vāsudevo ’smi pāṇḍavānāṁ dhanañjayaḥ\n" + "munīnām apyahaṁ vyāsaḥ kavīnām uśhanā kaviḥ",R.color.trans));
        mData.add(new NewsItem("","","daṇḍo damayatām asmi nītir asmi jigīṣhatām\n" + "maunaṁ chaivāsmi guhyānāṁ jñānaṁ jñānavatām aham",R.color.trans));
        mData.add(new NewsItem("","","yach chāpi sarva-bhūtānāṁ bījaṁ tad aham arjuna\n" + "na tad asti vinā yat syān mayā bhūtaṁ charācharam",R.color.trans));
        mData.add(new NewsItem("","","nānto ’sti mama divyānāṁ vibhūtīnāṁ parantapa\n" + "eṣha tūddeśhataḥ prokto vibhūter vistaro mayā",R.color.trans));
        mData.add(new NewsItem("","","yad yad vibhūtimat sattvaṁ śhrīmad ūrjitam eva vā\n" + "tat tad evāvagachchha tvaṁ mama tejo ’nśha-sambhavam",R.color.trans));
        mData.add(new NewsItem("","","atha vā bahunaitena kiṁ jñātena tavārjuna\n" + "viṣhṭabhyāham idaṁ kṛitsnam ekānśhena sthito jagat",R.color.trans));





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