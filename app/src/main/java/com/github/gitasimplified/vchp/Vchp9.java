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

public class Vchp9 extends AppCompatActivity
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
                Toast.makeText(Vchp9.this, "You Clicked: " + thisItem.getTitle(), Toast.LENGTH_SHORT).show();
            }
            if(position == 1) {
                Toast.makeText(Vchp9.this, "You Clicked: " + thisItem.getTitle(), Toast.LENGTH_SHORT).show();
            }
            if(position == 2) {
                Toast.makeText(Vchp9.this, "You Clicked: " + thisItem.getTitle(), Toast.LENGTH_SHORT).show();
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
        navigationView.getMenu().getItem(8).setChecked(true);

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
        mData.add(new NewsItem("","","\n" + "\n" + "śhrī bhagavān uvācha\n" + "idaṁ tu te guhyatamaṁ pravakṣhyāmyanasūyave\n" + "jñānaṁ vijñāna-sahitaṁ yaj jñātvā mokṣhyase ’śhubhāt\n",R.color.trans));
        mData.add(new NewsItem("","","rāja-vidyā rāja-guhyaṁ pavitram idam uttamam\n" + "pratyakṣhāvagamaṁ dharmyaṁ su-sukhaṁ kartum avyayam",R.color.trans));
        mData.add(new NewsItem("","","aśhraddadhānāḥ puruṣhā dharmasyāsya parantapa\n" + "aprāpya māṁ nivartante mṛityu-samsāra-vartmani",R.color.trans));
        mData.add(new NewsItem("","","mayā tatam idaṁ sarvaṁ jagad avyakta-mūrtinā\n" + "mat-sthāni sarva-bhūtāni na chāhaṁ teṣhvavasthitaḥ",R.color.trans));
        mData.add(new NewsItem("","","na cha mat-sthāni bhūtāni paśhya me yogam aiśhwaram\n" + "bhūta-bhṛin na cha bhūta-stho mamātmā bhūta-bhāvanaḥ",R.color.trans));
        mData.add(new NewsItem("","","yathākāśha-sthito nityaṁ vāyuḥ sarvatra-go mahān\n" + "tathā sarvāṇi bhūtāni mat-sthānītyupadhāraya",R.color.trans));
        mData.add(new NewsItem("","","sarva-bhūtāni kaunteya prakṛitiṁ yānti māmikām\n" + "kalpa-kṣhaye punas tāni kalpādau visṛijāmyaham\n" + "prakṛitiṁ svām avaṣhṭabhya visṛijāmi punaḥ punaḥ\n" + "bhūta-grāmam imaṁ kṛitsnam avaśhaṁ prakṛiter vaśhāt",R.color.trans));
        mData.add(new NewsItem("","","na cha māṁ tāni karmāṇi nibadhnanti dhanañjaya\n" + "udāsīna-vad āsīnam asaktaṁ teṣhu karmasu",R.color.trans));
        mData.add(new NewsItem("","","mayādhyakṣheṇa prakṛitiḥ sūyate sa-charācharam\n" + "hetunānena kaunteya jagad viparivartate",R.color.trans));
        mData.add(new NewsItem("","","mayādhyakṣheṇa prakṛitiḥ sūyate sa-charācharam\n" + "hetunānena kaunteya jagad viparivartate",R.color.trans));
        mData.add(new NewsItem("","","moghāśhā mogha-karmāṇo mogha-jñānā vichetasaḥ\n" + "rākṣhasīm āsurīṁ chaiva prakṛitiṁ mohinīṁ śhritāḥ",R.color.trans));
        mData.add(new NewsItem("","","mahātmānas tu māṁ pārtha daivīṁ prakṛitim āśhritāḥ\n" + "bhajantyananya-manaso jñātvā bhūtādim avyayam",R.color.trans));
        mData.add(new NewsItem("","","satataṁ kīrtayanto māṁ yatantaśh cha dṛiḍha-vratāḥ\n" + "namasyantaśh cha māṁ bhaktyā nitya-yuktā upāsate",R.color.trans));
        mData.add(new NewsItem("","","jñāna-yajñena chāpyanye yajanto mām upāsate\n" + "ekatvena pṛithaktvena bahudhā viśhvato-mukham",R.color.trans));
        mData.add(new NewsItem("","","ahaṁ kratur ahaṁ yajñaḥ svadhāham aham auṣhadham\n" + "mantro ’ham aham evājyam aham agnir ahaṁ hutam\n" + "pitāham asya jagato mātā dhātā pitāmahaḥ\n" + "vedyaṁ pavitram oṁkāra ṛik sāma yajur eva cha",R.color.trans));
        mData.add(new NewsItem("","","gatir bhartā prabhuḥ sākṣhī nivāsaḥ śharaṇaṁ suhṛit\n" + "prabhavaḥ pralayaḥ sthānaṁ nidhānaṁ bījam avyayam",R.color.trans));
        mData.add(new NewsItem("","","tapāmyaham ahaṁ varṣhaṁ nigṛihṇāmyutsṛijāmi cha\n" + "amṛitaṁ chaiva mṛityuśh cha sad asach chāham arjuna",R.color.trans));
        mData.add(new NewsItem("","","trai-vidyā māṁ soma-pāḥ pūta-pāpā\n" + "yajñair iṣhṭvā svar-gatiṁ prārthayante\n" + "te puṇyam āsādya surendra-lokam\n" + "aśhnanti divyān divi deva-bhogān",R.color.trans));
        mData.add(new NewsItem("","","te taṁ bhuktvā swarga-lokaṁ viśhālaṁ\n" + "kṣhīṇe puṇye martya-lokaṁ viśhanti\n" + "evaṁ trayī-dharmam anuprapannā\n" + "gatāgataṁ kāma-kāmā labhante",R.color.trans));
        mData.add(new NewsItem("","","ananyāśh chintayanto māṁ ye janāḥ paryupāsate\n" + "teṣhāṁ nityābhiyuktānāṁ yoga-kṣhemaṁ vahāmyaham",R.color.trans));
        mData.add(new NewsItem("","","ye ’pyanya-devatā-bhaktā yajante śhraddhayānvitāḥ\n" + "te ’pi mām eva kaunteya yajantyavidhi-pūrvakam",R.color.trans));
        mData.add(new NewsItem("","","ahaṁ hi sarva-yajñānāṁ bhoktā cha prabhureva cha\n" + "na tu mām abhijānanti tattvenātaśh chyavanti te",R.color.trans));
        mData.add(new NewsItem("","","yānti deva-vratā devān pitṝīn yānti pitṛi-vratāḥ\n" + "bhūtāni yānti bhūtejyā yānti mad-yājino ’pi mām",R.color.trans));
        mData.add(new NewsItem("","","patraṁ puṣhpaṁ phalaṁ toyaṁ yo me bhaktyā prayachchhati\n" + "tadahaṁ bhaktyupahṛitam aśhnāmi prayatātmanaḥ",R.color.trans));
        mData.add(new NewsItem("","","\n" + "\n" + "yat karoṣhi yad aśhnāsi yaj juhoṣhi dadāsi yat\n" + "yat tapasyasi kaunteya tat kuruṣhva mad-arpaṇam\n",R.color.trans));
        mData.add(new NewsItem("","","śhubhāśhubha-phalair evaṁ mokṣhyase karma-bandhanaiḥ\n" + "sannyāsa-yoga-yuktātmā vimukto mām upaiṣhyasi",R.color.trans));
        mData.add(new NewsItem("","","samo ’haṁ sarva-bhūteṣhu na me dveṣhyo ’sti na priyaḥ\n" + "ye bhajanti tu māṁ bhaktyā mayi te teṣhu chāpyaham",R.color.trans));
        mData.add(new NewsItem("","","api chet su-durāchāro bhajate mām ananya-bhāk\n" + "sādhur eva sa mantavyaḥ samyag vyavasito hi saḥ",R.color.trans));
        mData.add(new NewsItem("","","kṣhipraṁ bhavati dharmātmā śhaśhvach-chhāntiṁ nigachchhati\n" + "kaunteya pratijānīhi na me bhaktaḥ praṇaśhyati",R.color.trans));
        mData.add(new NewsItem("","","māṁ hi pārtha vyapāśhritya ye ’pi syuḥ pāpa-yonayaḥ\n" + "striyo vaiśhyās tathā śhūdrās te ’pi yānti parāṁ gatim",R.color.trans));
        mData.add(new NewsItem("","","kiṁ punar brāhmaṇāḥ puṇyā bhaktā rājarṣhayas tathā\n" + "anityam asukhaṁ lokam imaṁ prāpya bhajasva mām",R.color.trans));
        mData.add(new NewsItem("","","man-manā bhava mad-bhakto mad-yājī māṁ namaskuru\n" + "mām evaiṣhyasi yuktvaivam ātmānaṁ mat-parāyaṇaḥ",R.color.trans));

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