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

public class Vchp3 extends AppCompatActivity
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
                Toast.makeText(Vchp3.this, "You Clicked: " + thisItem.getTitle(), Toast.LENGTH_SHORT).show();
            }
            if(position == 1) {
                Toast.makeText(Vchp3.this, "You Clicked: " + thisItem.getTitle(), Toast.LENGTH_SHORT).show();
            }
            if(position == 2) {
                Toast.makeText(Vchp3.this, "You Clicked: " + thisItem.getTitle(), Toast.LENGTH_SHORT).show();
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
        mData.add(new NewsItem("","","arjuna uvācha\n" + "jyāyasī chet karmaṇas te matā buddhir janārdana\n" + "tat kiṁ karmaṇi ghore māṁ niyojayasi keśhava\n" + "vyāmiśhreṇeva vākyena buddhiṁ mohayasīva me\n" + "tad ekaṁ vada niśhchitya yena śhreyo ’ham āpnuyām",R.color.trans));
        mData.add(new NewsItem("","","śhrī bhagavān uvācha\n" + "loke ’smin dvi-vidhā niṣhṭhā purā proktā mayānagha\n" + "jñāna-yogena sāṅkhyānāṁ karma-yogena yoginām",R.color.trans));
        mData.add(new NewsItem("","","na karmaṇām anārambhān naiṣhkarmyaṁ puruṣho ’śhnute\n" + "na cha sannyasanād eva siddhiṁ samadhigachchhati",R.color.trans));
        mData.add(new NewsItem("","","na hi kaśhchit kṣhaṇam api jātu tiṣhṭhatyakarma-kṛit\n" + "kāryate hyavaśhaḥ karma sarvaḥ prakṛiti-jair guṇaiḥ",R.color.trans));
        mData.add(new NewsItem("","","karmendriyāṇi sanyamya ya āste manasā smaran\n" + "indriyārthān vimūḍhātmā mithyāchāraḥ sa uchyate",R.color.trans));
        mData.add(new NewsItem("","","yas tvindriyāṇi manasā niyamyārabhate ’rjuna\n" + "karmendriyaiḥ karma-yogam asaktaḥ sa viśhiṣhyate",R.color.trans));
        mData.add(new NewsItem("","","niyataṁ kuru karma tvaṁ karma jyāyo hyakarmaṇaḥ\n" + "śharīra-yātrāpi cha te na prasiddhyed akarmaṇaḥ",R.color.trans));
        mData.add(new NewsItem("","","yajñārthāt karmaṇo ’nyatra loko ’yaṁ karma-bandhanaḥ\n" + "tad-arthaṁ karma kaunteya mukta-saṅgaḥ samāchara",R.color.trans));
        mData.add(new NewsItem("","","saha-yajñāḥ prajāḥ sṛiṣhṭvā purovācha prajāpatiḥ\n" + "anena prasaviṣhyadhvam eṣha vo ’stviṣhṭa-kāma-dhuk",R.color.trans));
        mData.add(new NewsItem("","","devān bhāvayatānena te devā bhāvayantu vaḥ\n" + "parasparaṁ bhāvayantaḥ śhreyaḥ param avāpsyatha",R.color.trans));
        mData.add(new NewsItem("","","iṣhṭān bhogān hi vo devā dāsyante yajña-bhāvitāḥ\n" + "tair dattān apradāyaibhyo yo bhuṅkte stena eva saḥ",R.color.trans));
        mData.add(new NewsItem("","","yajña-śhiṣhṭāśhinaḥ santo muchyante sarva-kilbiṣhaiḥ\n" + "bhuñjate te tvaghaṁ pāpā ye pachantyātma-kāraṇāt",R.color.trans));
        mData.add(new NewsItem("","","annād bhavanti bhūtāni parjanyād anna-sambhavaḥ\n" + "yajñād bhavati parjanyo yajñaḥ karma-samudbhavaḥ",R.color.trans));
        mData.add(new NewsItem("","","karma brahmodbhavaṁ viddhi brahmākṣhara-samudbhavam\n" + "tasmāt sarva-gataṁ brahma nityaṁ yajñe pratiṣhṭhitam",R.color.trans));
        mData.add(new NewsItem("","","evaṁ pravartitaṁ chakraṁ nānuvartayatīha yaḥ\n" + "aghāyur indriyārāmo moghaṁ pārtha sa jīvati",R.color.trans));
        mData.add(new NewsItem("","","yas tvātma-ratir eva syād ātma-tṛiptaśh cha mānavaḥ\n" + "ātmanyeva cha santuṣhṭas tasya kāryaṁ na vidyate",R.color.trans));
        mData.add(new NewsItem("","","naiva tasya kṛitenārtho nākṛiteneha kaśhchana\n" + "na chāsya sarva-bhūteṣhu kaśhchid artha-vyapāśhrayaḥ",R.color.trans));
        mData.add(new NewsItem("","","tasmād asaktaḥ satataṁ kāryaṁ karma samāchara\n" + "asakto hyācharan karma param āpnoti pūruṣhaḥ",R.color.trans));
        mData.add(new NewsItem("","","karmaṇaiva hi sansiddhim āsthitā janakādayaḥ\n" + "loka-saṅgraham evāpi sampaśhyan kartum arhasi\n" + "yad yad ācharati śhreṣhṭhas tat tad evetaro janaḥ\n" + "sa yat pramāṇaṁ kurute lokas tad anuvartate",R.color.trans));
        mData.add(new NewsItem("","","na me pārthāsti kartavyaṁ triṣhu lokeṣhu kiñchana\n" + "nānavāptam avāptavyaṁ varta eva cha karmaṇi",R.color.trans));
        mData.add(new NewsItem("","","\n" + "\n" + "yadi hyahaṁ na varteyaṁ jātu karmaṇyatandritaḥ\n" + "mama vartmānuvartante manuṣhyāḥ pārtha sarvaśhaḥ\n",R.color.trans));
        mData.add(new NewsItem("","","utsīdeyur ime lokā na kuryāṁ karma ched aham\n" + "sankarasya cha kartā syām upahanyām imāḥ prajāḥ",R.color.trans));
        mData.add(new NewsItem("","","saktāḥ karmaṇyavidvānso yathā kurvanti bhārata\n" + "kuryād vidvāns tathāsaktaśh chikīrṣhur loka-saṅgraham",R.color.trans));
        mData.add(new NewsItem("","","\n" + "\n" + "na buddhi-bhedaṁ janayed ajñānāṁ karma-saṅginām\n" + "joṣhayet sarva-karmāṇi vidvān yuktaḥ samācharan\n",R.color.trans));
        mData.add(new NewsItem("","","prakṛiteḥ kriyamāṇāni guṇaiḥ karmāṇi sarvaśhaḥ\n" + "ahankāra-vimūḍhātmā kartāham iti manyate",R.color.trans));
        mData.add(new NewsItem("","","tattva-vit tu mahā-bāho guṇa-karma-vibhāgayoḥ\n" + "guṇā guṇeṣhu vartanta iti matvā na sajjate",R.color.trans));
        mData.add(new NewsItem("","","prakṛiter guṇa-sammūḍhāḥ sajjante guṇa-karmasu\n" + "tān akṛitsna-vido mandān kṛitsna-vin na vichālayet",R.color.trans));
        mData.add(new NewsItem("","","mayi sarvāṇi karmāṇi sannyasyādhyātma-chetasā\n" + "nirāśhīr nirmamo bhūtvā yudhyasva vigata-jvaraḥ",R.color.trans));
        mData.add(new NewsItem("","","ye me matam idaṁ nityam anutiṣhṭhanti mānavāḥ\n" + "śhraddhāvanto ’nasūyanto muchyante te ’pi karmabhiḥ",R.color.trans));
        mData.add(new NewsItem("","","ye tvetad abhyasūyanto nānutiṣhṭhanti me matam\n" + "sarva-jñāna-vimūḍhāns tān viddhi naṣhṭān achetasaḥ",R.color.trans));
        mData.add(new NewsItem("","","sadṛiśhaṁ cheṣhṭate svasyāḥ prakṛiter jñānavān api\n" + "prakṛitiṁ yānti bhūtāni nigrahaḥ kiṁ kariṣhyati",R.color.trans));
        mData.add(new NewsItem("","","indriyasyendriyasyārthe rāga-dveṣhau vyavasthitau\n" + "tayor na vaśham āgachchhet tau hyasya paripanthinau",R.color.trans));
        mData.add(new NewsItem("","","\n" + "\n" + "śhreyān swa-dharmo viguṇaḥ para-dharmāt sv-anuṣhṭhitāt\n" + "swa-dharme nidhanaṁ śhreyaḥ para-dharmo bhayāvahaḥ\n",R.color.trans));
        mData.add(new NewsItem("","","arjuna uvācha\n" + "atha kena prayukto ’yaṁ pāpaṁ charati pūruṣhaḥ\n" + "anichchhann api vārṣhṇeya balād iva niyojitaḥ",R.color.trans));
        mData.add(new NewsItem("","","śhrī bhagavān uvācha\n" + "kāma eṣha krodha eṣha rajo-guṇa-samudbhavaḥ\n" + "mahāśhano mahā-pāpmā viddhyenam iha vairiṇam",R.color.trans));
        mData.add(new NewsItem("","","dhūmenāvriyate vahnir yathādarśho malena cha\n" + "yatholbenāvṛito garbhas tathā tenedam āvṛitam",R.color.trans));
        mData.add(new NewsItem("","","āvṛitaṁ jñānam etena jñānino nitya-vairiṇā\n" + "kāma-rūpeṇa kaunteya duṣhpūreṇānalena cha",R.color.trans));
        mData.add(new NewsItem("","","indriyāṇi mano buddhir asyādhiṣhṭhānam uchyate\n" + "etair vimohayatyeṣha jñānam āvṛitya dehinam",R.color.trans));
        mData.add(new NewsItem("","","tasmāt tvam indriyāṇyādau niyamya bharatarṣhabha\n" + "pāpmānaṁ prajahi hyenaṁ jñāna-vijñāna-nāśhanam",R.color.trans));
        mData.add(new NewsItem("","","indriyāṇi parāṇyāhur indriyebhyaḥ paraṁ manaḥ\n" + "manasas tu parā buddhir yo buddheḥ paratas tu saḥ",R.color.trans));
        mData.add(new NewsItem("","","\n" + "\n" + "evaṁ buddheḥ paraṁ buddhvā sanstabhyātmānam ātmanā\n" + "jahi śhatruṁ mahā-bāho kāma-rūpaṁ durāsadam\n",R.color.trans));


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