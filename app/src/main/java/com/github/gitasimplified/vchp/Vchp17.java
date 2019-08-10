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

public class Vchp17 extends AppCompatActivity
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
                Toast.makeText(Vchp17.this, "You Clicked: " + thisItem.getTitle(), Toast.LENGTH_SHORT).show();
            }
            if(position == 1) {
                Toast.makeText(Vchp17.this, "You Clicked: " + thisItem.getTitle(), Toast.LENGTH_SHORT).show();
            }
            if(position == 2) {
                Toast.makeText(Vchp17.this, "You Clicked: " + thisItem.getTitle(), Toast.LENGTH_SHORT).show();
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

        mData.add(new NewsItem("","","arjuna uvācha\n" + "ye śhāstra-vidhim utsṛijya yajante śhraddhayānvitāḥ\n" + "teṣhāṁ niṣhṭhā tu kā kṛiṣhṇa sattvam āho rajas tamaḥ",R.color.trans));
        mData.add(new NewsItem("","","śhrī-bhagavān uvācha\n" + "tri-vidhā bhavati śhraddhā dehināṁ sā svabhāva-jā\n" + "sāttvikī rājasī chaiva tāmasī cheti tāṁ śhṛiṇu",R.color.trans));
        mData.add(new NewsItem("","","sattvānurūpā sarvasya śhraddhā bhavati bhārata\n" + "śhraddhā-mayo ‘yaṁ puruṣho yo yach-chhraddhaḥ sa eva saḥ",R.color.trans));
        mData.add(new NewsItem("","","yajante sāttvikā devān yakṣha-rakṣhānsi rājasāḥ\n" + "pretān bhūta-gaṇānśh chānye yajante tāmasā janāḥ",R.color.trans));
        mData.add(new NewsItem("","","aśhāstra-vihitaṁ ghoraṁ tapyante ye tapo janāḥ\n" + "dambhāhankāra-sanyuktāḥ kāma-rāga-balānvitāḥ\n" + "karṣhayantaḥ śharīra-sthaṁ bhūta-grāmam achetasaḥ\n" + "māṁ chaivāntaḥ śharīra-sthaṁ tān viddhy āsura-niśhchayān",R.color.trans));
        mData.add(new NewsItem("","","āhāras tv api sarvasya tri-vidho bhavati priyaḥ\n" + "yajñas tapas tathā dānaṁ teṣhāṁ bhedam imaṁ śhṛiṇu",R.color.trans));
        mData.add(new NewsItem("","","āyuḥ-sattva-balārogya-sukha-prīti-vivardhanāḥ\n" + "rasyāḥ snigdhāḥ sthirā hṛidyā āhārāḥ sāttvika-priyāḥ",R.color.trans));
        mData.add(new NewsItem("","","kaṭv-amla-lavaṇāty-uṣhṇa- tīkṣhṇa-rūkṣha-vidāhinaḥ\n" + "āhārā rājasasyeṣhṭā duḥkha-śhokāmaya-pradāḥ",R.color.trans));
        mData.add(new NewsItem("","","yāta-yāmaṁ gata-rasaṁ pūti paryuṣhitaṁ cha yat\n" + "uchchhiṣhṭam api chāmedhyaṁ bhojanaṁ tāmasa-priyam",R.color.trans));
        mData.add(new NewsItem("","","aphalākāṅkṣhibhir yajño vidhi-driṣhṭo ya ijyate\n" + "yaṣhṭavyam eveti manaḥ samādhāya sa sāttvikaḥ",R.color.trans));
        mData.add(new NewsItem("","","abhisandhāya tu phalaṁ dambhārtham api chaiva yat\n" + "ijyate bharata-śhreṣhṭha taṁ yajñaṁ viddhi rājasam",R.color.trans));
        mData.add(new NewsItem("","","vidhi-hīnam asṛiṣhṭānnaṁ mantra-hīnam adakṣhiṇam\n" + "śhraddhā-virahitaṁ yajñaṁ tāmasaṁ parichakṣhate",R.color.trans));
        mData.add(new NewsItem("","","deva-dwija-guru-prājña- pūjanaṁ śhaucham ārjavam\n" + "brahmacharyam ahinsā cha śhārīraṁ tapa uchyate",R.color.trans));
        mData.add(new NewsItem("","","anudvega-karaṁ vākyaṁ satyaṁ priya-hitaṁ cha yat\n" + "svādhyāyābhyasanaṁ chaiva vāṅ-mayaṁ tapa uchyate",R.color.trans));
        mData.add(new NewsItem("","","manaḥ-prasādaḥ saumyatvaṁ maunam ātma-vinigrahaḥ\n" + "bhāva-sanśhuddhir ity etat tapo mānasam uchyate",R.color.trans));
        mData.add(new NewsItem("","","śhraddhayā parayā taptaṁ tapas tat tri-vidhaṁ naraiḥ\n" + "aphalākāṅkṣhibhir yuktaiḥ sāttvikaṁ parichakṣhate",R.color.trans));
        mData.add(new NewsItem("","","satkāra-māna-pūjārthaṁ tapo dambhena chaiva yat\n" + "kriyate tad iha proktaṁ rājasaṁ chalam adhruvam",R.color.trans));
        mData.add(new NewsItem("","","mūḍha-grāheṇātmano yat pīḍayā kriyate tapaḥ\n" + "parasyotsādanārthaṁ vā tat tāmasam udāhṛitam",R.color.trans));
        mData.add(new NewsItem("","","dātavyam iti yad dānaṁ dīyate ‘nupakāriṇe\n" + "deśhe kāle cha pātre cha tad dānaṁ sāttvikaṁ smṛitam",R.color.trans));
        mData.add(new NewsItem("","","yat tu pratyupakārārthaṁ phalam uddiśhya vā punaḥ\n" + "dīyate cha parikliṣhṭaṁ tad dānaṁ rājasaṁ smṛitam",R.color.trans));
        mData.add(new NewsItem("","","adeśha-kāle yad dānam apātrebhyaśh cha dīyate\n" + "asat-kṛitam avajñātaṁ tat tāmasam udāhṛitam",R.color.trans));
        mData.add(new NewsItem("","","oṁ tat sad iti nirdeśho brahmaṇas tri-vidhaḥ smṛitaḥ\n" + "brāhmaṇās tena vedāśh cha yajñāśh cha vihitāḥ purā",R.color.trans));
        mData.add(new NewsItem("","","tasmād oṁ ity udāhṛitya yajña-dāna-tapaḥ-kriyāḥ\n" + "pravartante vidhānoktāḥ satataṁ brahma-vādinām",R.color.trans));
        mData.add(new NewsItem("","","tad ity anabhisandhāya phalaṁ yajña-tapaḥ-kriyāḥ\n" + "dāna-kriyāśh cha vividhāḥ kriyante mokṣha-kāṅkṣhibhiḥ",R.color.trans));
        mData.add(new NewsItem("","","sad-bhāve sādhu-bhāve cha sad ity etat prayujyate\n" + "praśhaste karmaṇi tathā sach-chhabdaḥ pārtha yujyate\n" + "yajñe tapasi dāne cha sthitiḥ sad iti chochyate\n" + "karma chaiva tad-arthīyaṁ sad ity evābhidhīyate",R.color.trans));
        mData.add(new NewsItem("","","aśhraddhayā hutaṁ dattaṁ tapas taptaṁ kṛitaṁ cha yat\n" + "asad ity uchyate pārtha na cha tat pretya no iha",R.color.trans));


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