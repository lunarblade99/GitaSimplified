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

public class Vchp11 extends AppCompatActivity
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
                Toast.makeText(Vchp11.this, "You Clicked: " + thisItem.getTitle(), Toast.LENGTH_SHORT).show();
            }
            if(position == 1) {
                Toast.makeText(Vchp11.this, "You Clicked: " + thisItem.getTitle(), Toast.LENGTH_SHORT).show();
            }
            if(position == 2) {
                Toast.makeText(Vchp11.this, "You Clicked: " + thisItem.getTitle(), Toast.LENGTH_SHORT).show();
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
        navigationView.getMenu().getItem(10).setChecked(true);

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
        mData.add(new NewsItem("","","arjuna uvācha\n" + "mad-anugrahāya paramaṁ guhyam adhyātma-sanjñitam\n" + "yat tvayoktaṁ vachas tena moho ’yaṁ vigato mama",R.color.trans));
        mData.add(new NewsItem("","","bhavāpyayau hi bhūtānāṁ śhrutau vistaraśho mayā\n" + "tvattaḥ kamala-patrākṣha māhātmyam api chāvyayam",R.color.trans));
        mData.add(new NewsItem("","","evam etad yathāttha tvam ātmānaṁ parameśhvara\n" + "draṣhṭum ichchhāmi te rūpam aiśhwaraṁ puruṣhottama",R.color.trans));
        mData.add(new NewsItem("","","manyase yadi tach chhakyaṁ mayā draṣhṭum iti prabho\n" + "yogeśhvara tato me tvaṁ darśhayātmānam avyayam",R.color.trans));
        mData.add(new NewsItem("","","śhrī-bhagavān uvācha\n" + "paśhya me pārtha rūpāṇi śhataśho ’tha sahasraśhaḥ\n" + "nānā-vidhāni divyāni nānā-varṇākṛitīni cha",R.color.trans));
        mData.add(new NewsItem("","","paśhyādityān vasūn rudrān aśhvinau marutas tathā\n" + "bahūny adṛiṣhṭa-pūrvāṇi paśhyāśhcharyāṇi bhārata",R.color.trans));
        mData.add(new NewsItem("","","ihaika-sthaṁ jagat kṛitsnaṁ paśhyādya sa-charācharam\n" + "mama dehe guḍākeśha yach chānyad draṣhṭum ichchhasi",R.color.trans));
        mData.add(new NewsItem("","","na tu māṁ śhakyase draṣhṭum anenaiva sva-chakṣhuṣhā\n" + "divyaṁ dadāmi te chakṣhuḥ paśhya me yogam aiśhwaram",R.color.trans));
        mData.add(new NewsItem("","","sañjaya uvācha\n" + "evam uktvā tato rājan mahā-yogeśhvaro hariḥ\n" + "darśhayām āsa pārthāya paramaṁ rūpam aiśhwaram",R.color.trans));
        mData.add(new NewsItem("","","aneka-vaktra-nayanam anekādbhuta-darśhanam\n" + "aneka-divyābharaṇaṁ divyānekodyatāyudham\n" + "divya-mālyāmbara-dharaṁ divya-gandhānulepanam\n" + "sarvāśhcharya-mayaṁ devam anantaṁ viśhvato-mukham",R.color.trans));
        mData.add(new NewsItem("","","divi sūrya-sahasrasya bhaved yugapad utthitā\n" + "yadi bhāḥ sadṛiśhī sā syād bhāsas tasya mahātmanaḥ",R.color.trans));
        mData.add(new NewsItem("","","tatraika-sthaṁ jagat kṛitsnaṁ pravibhaktam anekadhā\n" + "apaśhyad deva-devasya śharīre pāṇḍavas tadā",R.color.trans));
        mData.add(new NewsItem("","","tataḥ sa vismayāviṣhṭo hṛiṣhṭa-romā dhanañjayaḥ\n" + "praṇamya śhirasā devaṁ kṛitāñjalir abhāṣhata",R.color.trans));
        mData.add(new NewsItem("","","arjuna uvācha\n" + "paśhyāmi devāns tava deva dehe\n" + "sarvāns tathā bhūta-viśheṣha-saṅghān\n" + "brahmāṇam īśhaṁ kamalāsana-stham\n" + "ṛiṣhīnśh cha sarvān uragānśh cha divyān",R.color.trans));
        mData.add(new NewsItem("","","aneka-bāhūdara-vaktra-netraṁ\n" + "paśhyāmi tvāṁ sarvato ’nanta-rūpam\n" + "nāntaṁ na madhyaṁ na punas tavādiṁ\n" + "paśhyāmi viśhveśhvara viśhva-rūpa",R.color.trans));
        mData.add(new NewsItem("","","kirīṭinaṁ gadinaṁ chakriṇaṁ cha\n" + "tejo-rāśhiṁ sarvato dīptimantam\n" + "paśhyāmi tvāṁ durnirīkṣhyaṁ samantād\n" + "dīptānalārka-dyutim aprameyam",R.color.trans));
        mData.add(new NewsItem("","","tvam akṣharaṁ paramaṁ veditavyaṁ\n" + "tvam asya viśhvasya paraṁ nidhānam\n" + "tvam avyayaḥ śhāśhvata-dharma-goptā\n" + "sanātanas tvaṁ puruṣho mato me",R.color.trans));
        mData.add(new NewsItem("","","anādi-madhyāntam ananta-vīryam\n" + "ananta-bāhuṁ śhaśhi-sūrya-netram\n" + "paśhyāmi tvāṁ dīpta-hutāśha-vaktraṁ\n" + "sva-tejasā viśhvam idaṁ tapantam",R.color.trans));
        mData.add(new NewsItem("","","dyāv ā-pṛithivyor idam antaraṁ hi\n" + "vyāptaṁ tvayaikena diśhaśh cha sarvāḥ\n" + "dṛiṣhṭvādbhutaṁ rūpam ugraṁ tavedaṁ\n" + "loka-trayaṁ pravyathitaṁ mahātman",R.color.trans));
        mData.add(new NewsItem("","","amī hi tvāṁ sura-saṅghā viśhanti\n" + "kechid bhītāḥ prāñjalayo gṛiṇanti\n" + "svastīty uktvā maharṣhi-siddha-saṅghāḥ\n" + "stuvanti tvāṁ stutibhiḥ puṣhkalābhiḥ",R.color.trans));
        mData.add(new NewsItem("","","rudrādityā vasavo ye cha sādhyā\n" + "viśhve ’śhvinau marutaśh choṣhmapāśh cha\n" + "gandharva-yakṣhāsura-siddha-saṅghā\n" + "vīkṣhante tvāṁ vismitāśh chaiva sarve",R.color.trans));
        mData.add(new NewsItem("","","rūpaṁ mahat te bahu-vaktra-netraṁ\n" + "mahā-bāho bahu-bāhūru-pādam\n" + "bahūdaraṁ bahu-danṣhṭrā-karālaṁ\n" + "dṛiṣhṭvā lokāḥ pravyathitās tathāham",R.color.trans));
        mData.add(new NewsItem("","","nabhaḥ-spṛiśhaṁ dīptam aneka-varṇaṁ\n" + "vyāttānanaṁ dīpta-viśhāla-netram\n" + "dṛiṣhṭvā hi tvāṁ pravyathitāntar-ātmā\n" + "dhṛitiṁ na vindāmi śhamaṁ cha viṣhṇo",R.color.trans));
        mData.add(new NewsItem("","","danṣhṭrā-karālāni cha te mukhāni\n" + "dṛiṣhṭvaiva kālānala-sannibhāni\n" + "diśho na jāne na labhe cha śharma\n" + "prasīda deveśha jagan-nivāsa",R.color.trans));
        mData.add(new NewsItem("","","amī cha tvāṁ dhṛitarāśhtrasya putrāḥ\n" + "sarve sahaivāvani-pāla-saṅghaiḥ\n" + "bhīṣhmo droṇaḥ sūta-putras tathāsau\n" + "sahāsmadīyair api yodha-mukhyaiḥ\n" + "vaktrāṇi te tvaramāṇā viśhanti\n" + "danṣhṭrā-karālāni bhayānakāni\n" + "kechid vilagnā daśhanāntareṣhu\n" + "sandṛiśhyante chūrṇitair uttamāṅgaiḥ",R.color.trans));
        mData.add(new NewsItem("","","yathā nadīnāṁ bahavo ’mbu-vegāḥ\n" + "samudram evābhimukhā dravanti\n" + "tathā tavāmī nara-loka-vīrā\n" + "viśhanti vaktrāṇy abhivijvalanti\n" + "yathā pradīptaṁ jvalanaṁ pataṅgā\n" + "viśhanti nāśhāya samṛiddha-vegāḥ\n" + "tathaiva nāśhāya viśhanti lokās\n" + "tavāpi vaktrāṇi samṛiddha-vegāḥ",R.color.trans));
        mData.add(new NewsItem("","","lelihyase grasamānaḥ samantāl\n" + "lokān samagrān vadanair jvaladbhiḥ\n" + "tejobhir āpūrya jagat samagraṁ\n" + "bhāsas tavogrāḥ pratapanti viṣhṇo",R.color.trans));
        mData.add(new NewsItem("","","ākhyāhi me ko bhavān ugra-rūpo\n" + "namo ’stu te deva-vara prasīda\n" + "vijñātum ichchhāmi bhavantam ādyaṁ\n" + "na hi prajānāmi tava pravṛittim",R.color.trans));
        mData.add(new NewsItem("","","śhrī-bhagavān uvācha\n" + "kālo ’smi loka-kṣhaya-kṛit pravṛiddho\n" + "lokān samāhartum iha pravṛittaḥ\n" + "ṛite ’pi tvāṁ na bhaviṣhyanti sarve\n" + "ye ’vasthitāḥ pratyanīkeṣhu yodhāḥ",R.color.trans));
        mData.add(new NewsItem("","","tasmāt tvam uttiṣhṭha yaśho labhasva\n" + "jitvā śhatrūn bhuṅkṣhva rājyaṁ samṛiddham\n" + "mayaivaite nihatāḥ pūrvam eva\n" + "nimitta-mātraṁ bhava savya-sāchin",R.color.trans));
        mData.add(new NewsItem("","","droṇaṁ cha bhīṣhmaṁ cha jayadrathaṁ cha\n" + "karṇaṁ tathānyān api yodha-vīrān\n" + "mayā hatāṁs tvaṁ jahi mā vyathiṣhṭhā\n" + "yudhyasva jetāsi raṇe sapatnān",R.color.trans));
        mData.add(new NewsItem("","","sañjaya uvācha\n" + "etach chhrutvā vachanaṁ keśhavasya\n" + "kṛitāñjalir vepamānaḥ kirīṭī\n" + "namaskṛitvā bhūya evāha kṛiṣhṇaṁ\n" + "sa-gadgadaṁ bhīta-bhītaḥ praṇamya",R.color.trans));
        mData.add(new NewsItem("","","arjuna uvācha\n" + "sthāne hṛiṣhīkeśha tava prakīrtyā\n" + "jagat prahṛiṣhyaty anurajyate cha\n" + "rakṣhānsi bhītāni diśho dravanti\n" + "sarve namasyanti cha siddha-saṅghāḥ",R.color.trans));
        mData.add(new NewsItem("","","kasmāch cha te na nameran mahātman\n" + "garīyase brahmaṇo ’py ādi-kartre\n" + "ananta deveśha jagan-nivāsa\n" + "tvam akṣharaṁ sad-asat tat paraṁ yat",R.color.trans));
        mData.add(new NewsItem("","","tvam ādi-devaḥ puruṣhaḥ purāṇas\n" + "tvam asya viśhvasya paraṁ nidhānam\n" + "vettāsi vedyaṁ cha paraṁ cha dhāma\n" + "tvayā tataṁ viśhvam ananta-rūpa",R.color.trans));
        mData.add(new NewsItem("","","vāyur yamo ’gnir varuṇaḥ śhaśhāṅkaḥ\n" + "prajāpatis tvaṁ prapitāmahaśh cha\n" + "namo namas te ’stu sahasra-kṛitvaḥ\n" + "punaśh cha bhūyo ’pi namo namas te",R.color.trans));
        mData.add(new NewsItem("","","namaḥ purastād atha pṛiṣhṭhatas te\n" + "namo ’stu te sarvata eva sarva\n" + "ananta-vīryāmita-vikramas tvaṁ\n" + "sarvaṁ samāpnoṣhi tato ’si sarvaḥ",R.color.trans));
        mData.add(new NewsItem("","","sakheti matvā prasabhaṁ yad uktaṁ\n" + "he kṛiṣhṇa he yādava he sakheti\n" + "ajānatā mahimānaṁ tavedaṁ\n" + "mayā pramādāt praṇayena vāpi\n" + "yach chāvahāsārtham asat-kṛito ’si\n" + "vihāra-śhayyāsana-bhojaneṣhu\n" + "eko ’tha vāpy achyuta tat-samakṣhaṁ\n" + "tat kṣhāmaye tvām aham aprameyam",R.color.trans));
        mData.add(new NewsItem("","","pitāsi lokasya charācharasya\n" + "tvam asya pūjyaśh cha gurur garīyān\n" + "na tvat-samo ’sty abhyadhikaḥ kuto ’nyo\n" + "loka-traye ’py apratima-prabhāva",R.color.trans));
        mData.add(new NewsItem("","","\n" + "\n" + "tasmāt praṇamya praṇidhāya kāyaṁ\n" + "prasādaye tvām aham īśham īḍyam\n" + "piteva putrasya sakheva sakhyuḥ\n" + "priyaḥ priyāyārhasi deva soḍhum\n",R.color.trans));
        mData.add(new NewsItem("","","adṛiṣhṭa-pūrvaṁ hṛiṣhito ’smi dṛiṣhṭvā\n" + "bhayena cha pravyathitaṁ mano me\n" + "tad eva me darśhaya deva rūpaṁ\n" + "prasīda deveśha jagan-nivāsa",R.color.trans));
        mData.add(new NewsItem("","","kirīṭinaṁ gadinaṁ chakra-hastam\n" + "ichchhāmi tvāṁ draṣhṭum ahaṁ tathaiva\n" + "tenaiva rūpeṇa chatur-bhujena\n" + "sahasra-bāho bhava viśhva-mūrte",R.color.trans));
        mData.add(new NewsItem("","","\n" + "\n" + "śhrī-bhagavān uvācha\n" + "mayā prasannena tavārjunedaṁ\n" + "rūpaṁ paraṁ darśhitam ātma-yogāt\n" + "tejo-mayaṁ viśhvam anantam ādyaṁ\n" + "yan me tvad anyena na dṛiṣhṭa-pūrvam\n",R.color.trans));
        mData.add(new NewsItem("","","na veda-yajñādhyayanair na dānair\n" + "na cha kriyābhir na tapobhir ugraiḥ\n" + "evaṁ-rūpaḥ śhakya ahaṁ nṛi-loke\n" + "draṣhṭuṁ tvad anyena kuru-pravīra",R.color.trans));
        mData.add(new NewsItem("","","mā te vyathā mā cha vimūḍha-bhāvo\n" + "dṛiṣhṭvā rūpaṁ ghoram īdṛiṅ mamedam\n" + "vyapeta-bhīḥ prīta-manāḥ punas tvaṁ\n" + "tad eva me rūpam idaṁ prapaśhya",R.color.trans));
        mData.add(new NewsItem("","","\n" + "\n" + "sañjaya uvācha\n" + "ity arjunaṁ vāsudevas tathoktvā\n" + "svakaṁ rūpaṁ darśhayām āsa bhūyaḥ\n" + "āśhvāsayām āsa cha bhītam enaṁ\n" + "bhūtvā punaḥ saumya-vapur mahātmā\n",R.color.trans));
        mData.add(new NewsItem("","","arjuna uvācha\n" + "dṛiṣhṭvedaṁ mānuṣhaṁ rūpaṁ tava saumyaṁ janārdana\n" + "idānīm asmi saṁvṛittaḥ sa-chetāḥ prakṛitiṁ gataḥ",R.color.trans));
        mData.add(new NewsItem("","","śhrī-bhagavān uvācha\n" + "su-durdarśham idaṁ rūpaṁ dṛiṣhṭavān asi yan mama\n" + "devā apy asya rūpasya nityaṁ darśhana-kāṅkṣhiṇaḥ\n" + "nāhaṁ vedair na tapasā na dānena na chejyayā\n" + "śhakya evaṁ-vidho draṣhṭuṁ dṛiṣhṭavān asi māṁ yathā",R.color.trans));
        mData.add(new NewsItem("","","bhaktyā tv ananyayā śhakya aham evaṁ-vidho ’rjuna\n" + "jñātuṁ draṣhṭuṁ cha tattvena praveṣhṭuṁ cha parantapa",R.color.trans));
        mData.add(new NewsItem("","","\n" + "\n" + "mat-karma-kṛin mat-paramo mad-bhaktaḥ saṅga-varjitaḥ\n" + "nirvairaḥ sarva-bhūteṣhu yaḥ sa mām eti pāṇḍava\n",R.color.trans));


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