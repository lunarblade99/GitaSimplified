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

public class Vchp13 extends AppCompatActivity
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
                Toast.makeText(Vchp13.this, "You Clicked: " + thisItem.getTitle(), Toast.LENGTH_SHORT).show();
            }
            if(position == 1) {
                Toast.makeText(Vchp13.this, "You Clicked: " + thisItem.getTitle(), Toast.LENGTH_SHORT).show();
            }
            if(position == 2) {
                Toast.makeText(Vchp13.this, "You Clicked: " + thisItem.getTitle(), Toast.LENGTH_SHORT).show();
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
        navigationView.getMenu().getItem(12).setChecked(true);

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
        mData.add(new NewsItem("","","arjuna uvācha\n" + "prakṛitiṁ puruṣhaṁ chaiva kṣhetraṁ kṣhetra-jñam eva cha\n" + "etad veditum ichchhāmi jñānaṁ jñeyaṁ cha keśhava",R.color.trans));
        mData.add(new NewsItem("","","śhrī-bhagavān uvācha\n" + "idaṁ śharīraṁ kaunteya kṣhetram ity abhidhīyate\n" + "etad yo vetti taṁ prāhuḥ kṣhetra-jña iti tad-vidaḥ",R.color.trans));
        mData.add(new NewsItem("","","kṣhetra-jñaṁ chāpi māṁ viddhi sarva-kṣhetreṣhu bhārata\n" + "kṣhetra-kṣhetrajñayor jñānaṁ yat taj jñānaṁ mataṁ mama",R.color.trans));
        mData.add(new NewsItem("","","tat kṣhetraṁ yach cha yādṛik cha yad-vikāri yataśh cha yat\n" + "sa cha yo yat-prabhāvaśh cha tat samāsena me śhṛiṇu",R.color.trans));
        mData.add(new NewsItem("","","ṛiṣhibhir bahudhā gītaṁ chhandobhir vividhaiḥ pṛithak\n" + "brahma-sūtra-padaiśh chaiva hetumadbhir viniśhchitaiḥ",R.color.trans));
        mData.add(new NewsItem("","","mahā-bhūtāny ahankāro buddhir avyaktam eva cha\n" + "indriyāṇi daśhaikaṁ cha pañcha chendriya-gocharāḥ",R.color.trans));
        mData.add(new NewsItem("","","ichchhā dveṣhaḥ sukhaṁ duḥkhaṁ saṅghātaśh chetanā dhṛitiḥ\n" + "etat kṣhetraṁ samāsena sa-vikāram udāhṛitam",R.color.trans));
        mData.add(new NewsItem("","","amānitvam adambhitvam ahinsā kṣhāntir ārjavam\n" + "āchāryopāsanaṁ śhauchaṁ sthairyam ātma-vinigrahaḥ\n" + "indriyārtheṣhu vairāgyam anahankāra eva cha\n" + "janma-mṛityu-jarā-vyādhi-duḥkha-doṣhānudarśhanam\n" + "asaktir anabhiṣhvaṅgaḥ putra-dāra-gṛihādiṣhu\n" + "nityaṁ cha sama-chittatvam iṣhṭāniṣhṭopapattiṣhu\n" + "mayi chānanya-yogena bhaktir avyabhichāriṇī\n" + "vivikta-deśha-sevitvam aratir jana-sansadi\n" + "adhyātma-jñāna-nityatvaṁ tattva-jñānārtha-darśhanam\n" + "etaj jñānam iti proktam ajñānaṁ yad ato ’nyathā",R.color.trans));
        mData.add(new NewsItem("","","jñeyaṁ yat tat pravakṣhyāmi yaj jñātvāmṛitam aśhnute\n" + "anādi mat-paraṁ brahma na sat tan nāsad uchyate",R.color.trans));
        mData.add(new NewsItem("","","sarvataḥ pāṇi-pādaṁ tat sarvato ’kṣhi-śhiro-mukham\n" + "sarvataḥ śhrutimal loke sarvam āvṛitya tiṣhṭhati",R.color.trans));
        mData.add(new NewsItem("","","sarvendriya-guṇābhāsaṁ sarvendriya-vivarjitam\n" + "asaktaṁ sarva-bhṛich chaiva nirguṇaṁ guṇa-bhoktṛi cha",R.color.trans));
        mData.add(new NewsItem("","","bahir antaśh cha bhūtānām acharaṁ charam eva cha\n" + "sūkṣhmatvāt tad avijñeyaṁ dūra-sthaṁ chāntike cha tat",R.color.trans));
        mData.add(new NewsItem("","","avibhaktaṁ cha bhūteṣhu vibhaktam iva cha sthitam\n" + "bhūta-bhartṛi cha taj jñeyaṁ grasiṣhṇu prabhaviṣhṇu cha",R.color.trans));
        mData.add(new NewsItem("","","jyotiṣhām api taj jyotis tamasaḥ param uchyate\n" + "jñānaṁ jñeyaṁ jñāna-gamyaṁ hṛidi sarvasya viṣhṭhitam",R.color.trans));
        mData.add(new NewsItem("","","iti kṣhetraṁ tathā jñānaṁ jñeyaṁ choktaṁ samāsataḥ\n" + "mad-bhakta etad vijñāya mad-bhāvāyopapadyate",R.color.trans));
        mData.add(new NewsItem("","","prakṛitiṁ puruṣhaṁ chaiva viddhy anādī ubhāv api\n" + "vikārānśh cha guṇānśh chaiva viddhi prakṛiti-sambhavān",R.color.trans));
        mData.add(new NewsItem("","","kārya-kāraṇa-kartṛitve hetuḥ prakṛitir uchyate\n" + "puruṣhaḥ sukha-duḥkhānāṁ bhoktṛitve hetur uchyate",R.color.trans));
        mData.add(new NewsItem("","","puruṣhaḥ prakṛiti-stho hi bhuṅkte prakṛiti-jān guṇān\n" + "kāraṇaṁ guṇa-saṅgo ’sya sad-asad-yoni-janmasu",R.color.trans));
        mData.add(new NewsItem("","","upadraṣhṭānumantā cha bhartā bhoktā maheśhvaraḥ\n" + "paramātmeti chāpy ukto dehe ’smin puruṣhaḥ paraḥ",R.color.trans));
        mData.add(new NewsItem("","","ya evaṁ vetti puruṣhaṁ prakṛitiṁ cha guṇaiḥ saha\n" + "sarvathā vartamāno ’pi na sa bhūyo ’bhijāyate",R.color.trans));
        mData.add(new NewsItem("","","dhyānenātmani paśhyanti kechid ātmānam ātmanā\n" + "anye sānkhyena yogena karma-yogena chāpare",R.color.trans));
        mData.add(new NewsItem("","","anye tv evam ajānantaḥ śhrutvānyebhya upāsate\n" + "te ’pi chātitaranty eva mṛityuṁ śhruti-parāyaṇāḥ",R.color.trans));
        mData.add(new NewsItem("","","yāvat sañjāyate kiñchit sattvaṁ sthāvara-jaṅgamam\n" + "kṣhetra-kṣhetrajña-sanyogāt tad viddhi bharatarṣhabha",R.color.trans));
        mData.add(new NewsItem("","","samaṁ sarveṣhu bhūteṣhu tiṣhṭhantaṁ parameśhvaram\n" + "vinaśhyatsv avinaśhyantaṁ yaḥ paśhyati sa paśhyati",R.color.trans));
        mData.add(new NewsItem("","","samaṁ paśhyan hi sarvatra samavasthitam īśhvaram\n" + "na hinasty ātmanātmānaṁ tato yāti parāṁ gatim",R.color.trans));
        mData.add(new NewsItem("","","prakṛityaiva cha karmāṇi kriyamāṇāni sarvaśhaḥ\n" + "yaḥ paśhyati tathātmānam akartāraṁ sa paśhyati",R.color.trans));
        mData.add(new NewsItem("","","yadā bhūta-pṛithag-bhāvam eka-stham anupaśhyati\n" + "tata eva cha vistāraṁ brahma sampadyate tadā",R.color.trans));
        mData.add(new NewsItem("","","anāditvān nirguṇatvāt paramātmāyam avyayaḥ\n" + "śharīra-stho ’pi kaunteya na karoti na lipyate",R.color.trans));
        mData.add(new NewsItem("","","yathā sarva-gataṁ saukṣhmyād ākāśhaṁ nopalipyate\n" + "sarvatrāvasthito dehe tathātmā nopalipyate",R.color.trans));
        mData.add(new NewsItem("","","yathā prakāśhayaty ekaḥ kṛitsnaṁ lokam imaṁ raviḥ\n" + "kṣhetraṁ kṣhetrī tathā kṛitsnaṁ prakāśhayati bhārata",R.color.trans));
        mData.add(new NewsItem("","","kṣhetra-kṣhetrajñayor evam antaraṁ jñāna-chakṣhuṣhā\n" + "bhūta-prakṛiti-mokṣhaṁ cha ye vidur yānti te param",R.color.trans));


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