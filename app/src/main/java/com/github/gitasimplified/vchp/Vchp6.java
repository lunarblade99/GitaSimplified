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

public class Vchp6 extends AppCompatActivity
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
                Toast.makeText(Vchp6.this, "You Clicked: " + thisItem.getTitle(), Toast.LENGTH_SHORT).show();
            }
            if(position == 1) {
                Toast.makeText(Vchp6.this, "You Clicked: " + thisItem.getTitle(), Toast.LENGTH_SHORT).show();
            }
            if(position == 2) {
                Toast.makeText(Vchp6.this, "You Clicked: " + thisItem.getTitle(), Toast.LENGTH_SHORT).show();
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
        mData.add(new NewsItem("","","śhrī bhagavān uvācha\n" + "anāśhritaḥ karma-phalaṁ kāryaṁ karma karoti yaḥ\n" + "sa sannyāsī cha yogī cha na niragnir na chākriyaḥ",R.color.trans));
        mData.add(new NewsItem("","","yaṁ sannyāsam iti prāhur yogaṁ taṁ viddhi pāṇḍava\n" + "na hyasannyasta-saṅkalpo yogī bhavati kaśhchana",R.color.trans));
        mData.add(new NewsItem("","","ārurukṣhor muner yogaṁ karma kāraṇam uchyate\n" + "yogārūḍhasya tasyaiva śhamaḥ kāraṇam uchyate",R.color.trans));
        mData.add(new NewsItem("","","\n" + "\n" + "yadā hi nendriyārtheṣhu na karmasv-anuṣhajjate\n" + "sarva-saṅkalpa-sannyāsī yogārūḍhas tadochyate\n",R.color.trans));
        mData.add(new NewsItem("","","uddhared ātmanātmānaṁ nātmānam avasādayet\n" + "ātmaiva hyātmano bandhur ātmaiva ripur ātmanaḥ",R.color.trans));
        mData.add(new NewsItem("","","bandhur ātmātmanas tasya yenātmaivātmanā jitaḥ\n" + "anātmanas tu śhatrutve vartetātmaiva śhatru-vat",R.color.trans));
        mData.add(new NewsItem("","","jitātmanaḥ praśhāntasya paramātmā samāhitaḥ\n" + "śhītoṣhṇa-sukha-duḥkheṣhu tathā mānāpamānayoḥ",R.color.trans));
        mData.add(new NewsItem("","","jñāna-vijñāna-tṛiptātmā kūṭa-stho vijitendriyaḥ\n" + "yukta ityuchyate yogī sama-loṣhṭāśhma-kāñchanaḥ",R.color.trans));
        mData.add(new NewsItem("","","suhṛin-mitrāryudāsīna-madhyastha-dveṣhya-bandhuṣhu\n" + "sādhuṣhvapi cha pāpeṣhu sama-buddhir viśhiṣhyate",R.color.trans));
        mData.add(new NewsItem("","","yogī yuñjīta satatam ātmānaṁ rahasi sthitaḥ\n" + "ekākī yata-chittātmā nirāśhīr aparigrahaḥ",R.color.trans));
        mData.add(new NewsItem("","","śhuchau deśhe pratiṣhṭhāpya sthiram āsanam ātmanaḥ\n" + "nātyuchchhritaṁ nāti-nīchaṁ chailājina-kuśhottaram",R.color.trans));
        mData.add(new NewsItem("","","tatraikāgraṁ manaḥ kṛitvā yata-chittendriya-kriyaḥ\n" + "upaviśhyāsane yuñjyād yogam ātma-viśhuddhaye\n" + "samaṁ kāya-śhiro-grīvaṁ dhārayann achalaṁ sthiraḥ\n" + "samprekṣhya nāsikāgraṁ svaṁ diśhaśh chānavalokayan",R.color.trans));
        mData.add(new NewsItem("","","praśhāntātmā vigata-bhīr brahmachāri-vrate sthitaḥ\n" + "manaḥ sanyamya mach-chitto yukta āsīta mat-paraḥ",R.color.trans));
        mData.add(new NewsItem("","","yuñjann evaṁ sadātmānaṁ yogī niyata-mānasaḥ\n" + "śhantiṁ nirvāṇa-paramāṁ mat-sansthām adhigachchhati",R.color.trans));
        mData.add(new NewsItem("","","nātyaśhnatastu yogo ’sti na chaikāntam anaśhnataḥ\n" + "na chāti-svapna-śhīlasya jāgrato naiva chārjuna",R.color.trans));
        mData.add(new NewsItem("","","yuktāhāra-vihārasya yukta-cheṣhṭasya karmasu\n" + "yukta-svapnāvabodhasya yogo bhavati duḥkha-hā",R.color.trans));
        mData.add(new NewsItem("","","yadā viniyataṁ chittam ātmanyevāvatiṣhṭhate\n" + "niḥspṛihaḥ sarva-kāmebhyo yukta ityuchyate tadā",R.color.trans));
        mData.add(new NewsItem("","","yathā dīpo nivāta-stho neṅgate sopamā smṛitā\n" + "yogino yata-chittasya yuñjato yogam ātmanaḥ",R.color.trans));
        mData.add(new NewsItem("","","yatroparamate chittaṁ niruddhaṁ yoga-sevayā\n" + "yatra chaivātmanātmānaṁ paśhyann ātmani tuṣhyati",R.color.trans));
        mData.add(new NewsItem("","","sukham ātyantikaṁ yat tad buddhi-grāhyam atīndriyam\n" + "vetti yatra na chaivāyaṁ sthitaśh chalati tattvataḥ",R.color.trans));
        mData.add(new NewsItem("","","yaṁ labdhvā chāparaṁ lābhaṁ manyate nādhikaṁ tataḥ\n" + "yasmin sthito na duḥkhena guruṇāpi vichālyate",R.color.trans));
        mData.add(new NewsItem("","","taṁ vidyād duḥkha-sanyoga-viyogaṁ yogasaṅjñitam\n" + "sa niśhchayena yoktavyo yogo ’nirviṇṇa-chetasā",R.color.trans));
        mData.add(new NewsItem("","","saṅkalpa-prabhavān kāmāns tyaktvā sarvān aśheṣhataḥ\n" + "manasaivendriya-grāmaṁ viniyamya samantataḥ\n" + "śhanaiḥ śhanair uparamed buddhyā dhṛiti-gṛihītayā\n" + "ātma-sansthaṁ manaḥ kṛitvā na kiñchid api chintayet",R.color.trans));
        mData.add(new NewsItem("","","yato yato niśhcharati manaśh chañchalam asthiram\n" + "tatas tato niyamyaitad ātmanyeva vaśhaṁ nayet",R.color.trans));
        mData.add(new NewsItem("","","praśhānta-manasaṁ hyenaṁ yoginaṁ sukham uttamam\n" + "upaiti śhānta-rajasaṁ brahma-bhūtam akalmaṣham",R.color.trans));
        mData.add(new NewsItem("","","yuñjann evaṁ sadātmānaṁ yogī vigata-kalmaṣhaḥ\n" + "sukhena brahma-sansparśham atyantaṁ sukham aśhnute",R.color.trans));
        mData.add(new NewsItem("","","sarva-bhūta-stham ātmānaṁ sarva-bhūtāni chātmani\n" + "īkṣhate yoga-yuktātmā sarvatra sama-darśhanaḥ",R.color.trans));
        mData.add(new NewsItem("","","yo māṁ paśhyati sarvatra sarvaṁ cha mayi paśhyati\n" + "tasyāhaṁ na praṇaśhyāmi sa cha me na praṇaśhyati",R.color.trans));
        mData.add(new NewsItem("","","sarva-bhūta-sthitaṁ yo māṁ bhajatyekatvam āsthitaḥ\n" + "sarvathā vartamāno ’pi sa yogī mayi vartate",R.color.trans));
        mData.add(new NewsItem("","","ātmaupamyena sarvatra samaṁ paśhyati yo ’rjuna\n" + "sukhaṁ vā yadi vā duḥkhaṁ sa yogī paramo mataḥ",R.color.trans));
        mData.add(new NewsItem("","","arjuna uvācha\n" + "yo ’yaṁ yogas tvayā proktaḥ sāmyena madhusūdana\n" + "etasyāhaṁ na paśhyāmi chañchalatvāt sthitiṁ sthirām",R.color.trans));
        mData.add(new NewsItem("","","chañchalaṁ hi manaḥ kṛiṣhṇa pramāthi balavad dṛiḍham\n" + "tasyāhaṁ nigrahaṁ manye vāyor iva su-duṣhkaram",R.color.trans));
        mData.add(new NewsItem("","","śhrī bhagavān uvācha\n" + "asanśhayaṁ mahā-bāho mano durnigrahaṁ chalam\n" + "abhyāsena tu kaunteya vairāgyeṇa cha gṛihyate",R.color.trans));
        mData.add(new NewsItem("","","asaṅyatātmanā yogo duṣhprāpa iti me matiḥ\n" + "vaśhyātmanā tu yatatā śhakyo ’vāptum upāyataḥ",R.color.trans));
        mData.add(new NewsItem("","","arjuna uvācha\n" + "ayatiḥ śhraddhayopeto yogāch chalita-mānasaḥ\n" + "aprāpya yoga-sansiddhiṁ kāṅ gatiṁ kṛiṣhṇa gachchhati",R.color.trans));
        mData.add(new NewsItem("","","kachchin nobhaya-vibhraṣhṭaśh chhinnābhram iva naśhyati\n" + "apratiṣhṭho mahā-bāho vimūḍho brahmaṇaḥ pathi",R.color.trans));
        mData.add(new NewsItem("","","etan me sanśhayaṁ kṛiṣhṇa chhettum arhasyaśheṣhataḥ\n" + "tvad-anyaḥ sanśhayasyāsya chhettā na hyupapadyate",R.color.trans));
        mData.add(new NewsItem("","","śhrī bhagavān uvācha\n" + "pārtha naiveha nāmutra vināśhas tasya vidyate\n" + "na hi kalyāṇa-kṛit kaśhchid durgatiṁ tāta gachchhati",R.color.trans));
        mData.add(new NewsItem("","","prāpya puṇya-kṛitāṁ lokān uṣhitvā śhāśhvatīḥ samāḥ\n" + "śhuchīnāṁ śhrīmatāṁ gehe yoga-bhraṣhṭo ’bhijāyate\n" + "atha vā yoginām eva kule bhavati dhīmatām\n" + "etad dhi durlabhataraṁ loke janma yad īdṛiśham",R.color.trans));
        mData.add(new NewsItem("","","tatra taṁ buddhi-sanyogaṁ labhate paurva-dehikam\n" + "yatate cha tato bhūyaḥ sansiddhau kuru-nandana",R.color.trans));
        mData.add(new NewsItem("","","pūrvābhyāsena tenaiva hriyate hyavaśho ’pi saḥ\n" + "jijñāsur api yogasya śhabda-brahmātivartate",R.color.trans));
        mData.add(new NewsItem("","","prayatnād yatamānas tu yogī sanśhuddha-kilbiṣhaḥ\n" + "aneka-janma-sansiddhas tato yāti parāṁ gatim",R.color.trans));
        mData.add(new NewsItem("","","tapasvibhyo ’dhiko yogī\n" + "jñānibhyo ’pi mato ’dhikaḥ\n" + "karmibhyaśh chādhiko yogī\n" + "tasmād yogī bhavārjuna",R.color.trans));
        mData.add(new NewsItem("","","yoginām api sarveṣhāṁ mad-gatenāntar-ātmanā\n" + "śhraddhāvān bhajate yo māṁ sa me yuktatamo mataḥ",R.color.trans));



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