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

public class Vchp4 extends AppCompatActivity
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
                Toast.makeText(Vchp4.this, "You Clicked: " + thisItem.getTitle(), Toast.LENGTH_SHORT).show();
            }
            if(position == 1) {
                Toast.makeText(Vchp4.this, "You Clicked: " + thisItem.getTitle(), Toast.LENGTH_SHORT).show();
            }
            if(position == 2) {
                Toast.makeText(Vchp4.this, "You Clicked: " + thisItem.getTitle(), Toast.LENGTH_SHORT).show();
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
        mData.add(new NewsItem("","","śhrī bhagavān uvācha\n" + "imaṁ vivasvate yogaṁ proktavān aham avyayam\n" + "vivasvān manave prāha manur ikṣhvākave ’bravīt",R.color.trans));
        mData.add(new NewsItem("","","evaṁ paramparā-prāptam imaṁ rājarṣhayo viduḥ\n" + "sa kāleneha mahatā yogo naṣhṭaḥ parantapa",R.color.trans));
        mData.add(new NewsItem("","","sa evāyaṁ mayā te ’dya yogaḥ proktaḥ purātanaḥ\n" + "bhakto ’si me sakhā cheti rahasyaṁ hyetad uttamam",R.color.trans));
        mData.add(new NewsItem("","","arjuna uvācha\n" + "aparaṁ bhavato janma paraṁ janma vivasvataḥ\n" + "katham etad vijānīyāṁ tvam ādau proktavān iti",R.color.trans));
        mData.add(new NewsItem("","","śhrī bhagavān uvācha\n" + "bahūni me vyatītāni janmāni tava chārjuna\n" + "tānyahaṁ veda sarvāṇi na tvaṁ vettha parantapa",R.color.trans));
        mData.add(new NewsItem("","","ajo ’pi sannavyayātmā bhūtānām īśhvaro ’pi san\n" + "prakṛitiṁ svām adhiṣhṭhāya sambhavāmyātma-māyayā",R.color.trans));
        mData.add(new NewsItem("","","yadā yadā hi dharmasya glānir bhavati bhārata\n" + "abhyutthānam adharmasya tadātmānaṁ sṛijāmyaham",R.color.trans));
        mData.add(new NewsItem("","","paritrāṇāya sādhūnāṁ vināśhāya cha duṣhkṛitām\n" + "dharma-sansthāpanārthāya sambhavāmi yuge yuge",R.color.trans));
        mData.add(new NewsItem("","","janma karma cha me divyam evaṁ yo vetti tattvataḥ\n" + "tyaktvā dehaṁ punar janma naiti mām eti so arjuna",R.color.trans));
        mData.add(new NewsItem("","","vīta-rāga-bhaya-krodhā man-mayā mām upāśhritāḥ\n" + "bahavo jñāna-tapasā pūtā mad-bhāvam āgatāḥ",R.color.trans));
        mData.add(new NewsItem("","","\n" + "\n" + "ye yathā māṁ prapadyante tāns tathaiva bhajāmyaham\n" + "mama vartmānuvartante manuṣhyāḥ pārtha sarvaśhaḥ\n",R.color.trans));
        mData.add(new NewsItem("","","kāṅkṣhantaḥ karmaṇāṁ siddhiṁ yajanta iha devatāḥ\n" + "kṣhipraṁ hi mānuṣhe loke siddhir bhavati karmajā",R.color.trans));
        mData.add(new NewsItem("","","chātur-varṇyaṁ mayā sṛiṣhṭaṁ guṇa-karma-vibhāgaśhaḥ\n" + "tasya kartāram api māṁ viddhyakartāram avyayam",R.color.trans));
        mData.add(new NewsItem("","","na māṁ karmāṇi limpanti na me karma-phale spṛihā\n" + "iti māṁ yo ’bhijānāti karmabhir na sa badhyate",R.color.trans));
        mData.add(new NewsItem("","","\n" + "\n" + "evaṁ jñātvā kṛitaṁ karma pūrvair api mumukṣhubhiḥ\n" + "kuru karmaiva tasmāttvaṁ pūrvaiḥ pūrvataraṁ kṛitam\n",R.color.trans));
        mData.add(new NewsItem("","","kiṁ karma kim akarmeti kavayo ’pyatra mohitāḥ\n" + "tat te karma pravakṣhyāmi yaj jñātvā mokṣhyase ’śhubhāt",R.color.trans));
        mData.add(new NewsItem("","","karmaṇo hyapi boddhavyaṁ boddhavyaṁ cha vikarmaṇaḥ\n" + "akarmaṇaśh cha boddhavyaṁ gahanā karmaṇo gatiḥ",R.color.trans));
        mData.add(new NewsItem("","","karmaṇyakarma yaḥ paśhyed akarmaṇi cha karma yaḥ\n" + "sa buddhimān manuṣhyeṣhu sa yuktaḥ kṛitsna-karma-kṛit",R.color.trans));
        mData.add(new NewsItem("","","yasya sarve samārambhāḥ kāma-saṅkalpa-varjitāḥ\n" + "jñānāgni-dagdha-karmāṇaṁ tam āhuḥ paṇḍitaṁ budhāḥ",R.color.trans));
        mData.add(new NewsItem("","","tyaktvā karma-phalāsaṅgaṁ nitya-tṛipto nirāśhrayaḥ\n" + "karmaṇyabhipravṛitto ’pi naiva kiñchit karoti saḥ",R.color.trans));
        mData.add(new NewsItem("","","nirāśhīr yata-chittātmā tyakta-sarva-parigrahaḥ\n" + "śhārīraṁ kevalaṁ karma kurvan nāpnoti kilbiṣham",R.color.trans));
        mData.add(new NewsItem("","","yadṛichchhā-lābha-santuṣhṭo dvandvātīto vimatsaraḥ\n" + "samaḥ siddhāvasiddhau cha kṛitvāpi na nibadhyate",R.color.trans));
        mData.add(new NewsItem("","","gata-saṅgasya muktasya jñānāvasthita-chetasaḥ\n" + "yajñāyācharataḥ karma samagraṁ pravilīyate",R.color.trans));
        mData.add(new NewsItem("","","brahmārpaṇaṁ brahma havir brahmāgnau brahmaṇā hutam\n" + "brahmaiva tena gantavyaṁ brahma-karma-samādhinā",R.color.trans));
        mData.add(new NewsItem("","","daivam evāpare yajñaṁ yoginaḥ paryupāsate\n" + "brahmāgnāvapare yajñaṁ yajñenaivopajuhvati",R.color.trans));
        mData.add(new NewsItem("","","śhrotrādīnīndriyāṇyanye sanyamāgniṣhu juhvati\n" + "śhabdādīn viṣhayānanya indriyāgniṣhu juhvati",R.color.trans));
        mData.add(new NewsItem("","","sarvāṇīndriya-karmāṇi prāṇa-karmāṇi chāpare\n" + "ātma-sanyama-yogāgnau juhvati jñāna-dīpite",R.color.trans));
        mData.add(new NewsItem("","","dravya-yajñās tapo-yajñā yoga-yajñās tathāpare\n" + "swādhyāya-jñāna-yajñāśh cha yatayaḥ sanśhita-vratāḥ",R.color.trans));
        mData.add(new NewsItem("","","apāne juhvati prāṇaṁ prāṇe ’pānaṁ tathāpare\n" + "prāṇāpāna-gatī ruddhvā prāṇāyāma-parāyaṇāḥ\n" + "apare niyatāhārāḥ prāṇān prāṇeṣhu juhvati\n" + "sarve ’pyete yajña-vido yajña-kṣhapita-kalmaṣhāḥ",R.color.trans));
        mData.add(new NewsItem("","","yajña-śhiṣhṭāmṛita-bhujo yānti brahma sanātanam\n" + "nāyaṁ loko ’styayajñasya kuto ’nyaḥ kuru-sattama",R.color.trans));
        mData.add(new NewsItem("","","evaṁ bahu-vidhā yajñā vitatā brahmaṇo mukhe\n" + "karma-jān viddhi tān sarvān evaṁ jñātvā vimokṣhyase",R.color.trans));
        mData.add(new NewsItem("","","śhreyān dravya-mayād yajñāj jñāna-yajñaḥ parantapa\n" + "sarvaṁ karmākhilaṁ pārtha jñāne parisamāpyate",R.color.trans));
        mData.add(new NewsItem("","","tad viddhi praṇipātena paripraśhnena sevayā\n" + "upadekṣhyanti te jñānaṁ jñāninas tattva-darśhinaḥ",R.color.trans));
        mData.add(new NewsItem("","","yaj jñātvā na punar moham evaṁ yāsyasi pāṇḍava\n" + "yena bhūtānyaśheṣheṇa drakṣhyasyātmanyatho mayi",R.color.trans));
        mData.add(new NewsItem("","","api ched asi pāpebhyaḥ sarvebhyaḥ pāpa-kṛit-tamaḥ\n" + "sarvaṁ jñāna-plavenaiva vṛijinaṁ santariṣhyasi",R.color.trans));
        mData.add(new NewsItem("","","yathaidhānsi samiddho ’gnir bhasma-sāt kurute ’rjuna\n" + "jñānāgniḥ sarva-karmāṇi bhasma-sāt kurute tathā",R.color.trans));
        mData.add(new NewsItem("","","na hi jñānena sadṛiśhaṁ pavitramiha vidyate\n" + "tatsvayaṁ yogasansiddhaḥ kālenātmani vindati",R.color.trans));
        mData.add(new NewsItem("","","śhraddhāvān labhate jñānaṁ tat-paraḥ sanyatendriyaḥ\n" + "jñānaṁ labdhvā parāṁ śhāntim achireṇādhigachchhati",R.color.trans));
        mData.add(new NewsItem("","","ajñaśh chāśhraddadhānaśh cha sanśhayātmā vinaśhyati\n" + "nāyaṁ loko ’sti na paro na sukhaṁ sanśhayātmanaḥ",R.color.trans));
        mData.add(new NewsItem("","","yoga-sannyasta-karmāṇaṁ jñāna-sañchhinna-sanśhayam\n" + "ātmavantaṁ na karmāṇi nibadhnanti dhanañjaya",R.color.trans));
        mData.add(new NewsItem("","","tasmād ajñāna-sambhūtaṁ hṛit-sthaṁ jñānāsinātmanaḥ\n" + "chhittvainaṁ sanśhayaṁ yogam ātiṣhṭhottiṣhṭha bhārata",R.color.trans));



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