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

public class Vchp18 extends AppCompatActivity
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
                Toast.makeText(Vchp18.this, "You Clicked: " + thisItem.getTitle(), Toast.LENGTH_SHORT).show();
            }
            if(position == 1) {
                Toast.makeText(Vchp18.this, "You Clicked: " + thisItem.getTitle(), Toast.LENGTH_SHORT).show();
            }
            if(position == 2) {
                Toast.makeText(Vchp18.this, "You Clicked: " + thisItem.getTitle(), Toast.LENGTH_SHORT).show();
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
        navigationView.getMenu().getItem(17).setChecked(true);

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
        mData.add(new NewsItem("","","arjuna uvācha\n" + "sannyāsasya mahā-bāho tattvam ichchhāmi veditum\n" + "tyāgasya cha hṛiṣhīkeśha pṛithak keśhi-niṣhūdana",R.color.trans));
        mData.add(new NewsItem("","","śhrī-bhagavān uvācha\n" + "kāmyānāṁ karmaṇāṁ nyāsaṁ sannyāsaṁ kavayo viduḥ\n" + "sarva-karma-phala-tyāgaṁ prāhus tyāgaṁ vichakṣhaṇāḥ",R.color.trans));
        mData.add(new NewsItem("","","tyājyaṁ doṣha-vad ity eke karma prāhur manīṣhiṇaḥ\n" + "yajña-dāna-tapaḥ-karma na tyājyam iti chāpare",R.color.trans));
        mData.add(new NewsItem("","","niśhchayaṁ śhṛiṇu me tatra tyāge bharata-sattama\n" + "tyāgo hi puruṣha-vyāghra tri-vidhaḥ samprakīrtitaḥ",R.color.trans));
        mData.add(new NewsItem("","","yajña-dāna-tapaḥ-karma na tyājyaṁ kāryam eva tat\n" + "yajño dānaṁ tapaśh chaiva pāvanāni manīṣhiṇām",R.color.trans));
        mData.add(new NewsItem("","","etāny api tu karmāṇi saṅgaṁ tyaktvā phalāni cha\n" + "kartavyānīti me pārtha niśhchitaṁ matam uttamam",R.color.trans));
        mData.add(new NewsItem("","","niyatasya tu sannyāsaḥ karmaṇo nopapadyate\n" + "mohāt tasya parityāgas tāmasaḥ parikīrtitaḥ",R.color.trans));
        mData.add(new NewsItem("","","duḥkham ity eva yat karma kāya-kleśha-bhayāt tyajet\n" + "sa kṛitvā rājasaṁ tyāgaṁ naiva tyāga-phalaṁ labhet",R.color.trans));
        mData.add(new NewsItem("","","kāryam ity eva yat karma niyataṁ kriyate ‘rjuna\n" + "saṅgaṁ tyaktvā phalaṁ chaiva sa tyāgaḥ sāttviko mataḥ",R.color.trans));
        mData.add(new NewsItem("","","na dveṣhṭy akuśhalaṁ karma kuśhale nānuṣhajjate\n" + "tyāgī sattva-samāviṣhṭo medhāvī chhinna-sanśhayaḥ",R.color.trans));
        mData.add(new NewsItem("","","na hi deha-bhṛitā śhakyaṁ tyaktuṁ karmāṇy aśheṣhataḥ\n" + "yas tu karma-phala-tyāgī sa tyāgīty abhidhīyate",R.color.trans));
        mData.add(new NewsItem("","","aniṣhṭam iṣhṭaṁ miśhraṁ cha tri-vidhaṁ karmaṇaḥ phalam\n" + "bhavaty atyāgināṁ pretya na tu sannyāsināṁ kvachit",R.color.trans));
        mData.add(new NewsItem("","","pañchaitāni mahā-bāho kāraṇāni nibodha me\n" + "sānkhye kṛitānte proktāni siddhaye sarva-karmaṇām",R.color.trans));
        mData.add(new NewsItem("","","adhiṣhṭhānaṁ tathā kartā karaṇaṁ cha pṛithag-vidham\n" + "vividhāśh cha pṛithak cheṣhṭā daivaṁ chaivātra pañchamam",R.color.trans));
        mData.add(new NewsItem("","","śharīra-vāṅ-manobhir yat karma prārabhate naraḥ\n" + "nyāyyaṁ vā viparītaṁ vā pañchaite tasya hetavaḥ\n" + "tatraivaṁ sati kartāram ātmānaṁ kevalaṁ tu yaḥ\n" + "paśhyaty akṛita-buddhitvān na sa paśhyati durmatiḥ",R.color.trans));
        mData.add(new NewsItem("","","yasya nāhankṛito bhāvo buddhir yasya na lipyate\n" + "hatvā ‘pi sa imāl lokān na hanti na nibadhyate",R.color.trans));
        mData.add(new NewsItem("","","jñānaṁ jñeyaṁ parijñātā tri-vidhā karma-chodanā\n" + "karaṇaṁ karma karteti tri-vidhaḥ karma-saṅgrahaḥ",R.color.trans));
        mData.add(new NewsItem("","","jñānaṁ karma cha kartā cha tridhaiva guṇa-bhedataḥ\n" + "prochyate guṇa-saṅkhyāne yathāvach chhṛiṇu tāny api",R.color.trans));
        mData.add(new NewsItem("","","sarva-bhūteṣhu yenaikaṁ bhāvam avyayam īkṣhate\n" + "avibhaktaṁ vibhakteṣhu taj jñānaṁ viddhi sāttvikam",R.color.trans));
        mData.add(new NewsItem("","","pṛithaktvena tu yaj jñānaṁ nānā-bhāvān pṛithag-vidhān\n" + "vetti sarveṣhu bhūteṣhu taj jñānaṁ viddhi rājasam",R.color.trans));
        mData.add(new NewsItem("","","yat tu kṛitsna-vad ekasmin kārye saktam ahaitukam\n" + "atattvārtha-vad alpaṁ cha tat tāmasam udāhṛitam",R.color.trans));
        mData.add(new NewsItem("","","niyataṁ saṅga-rahitam arāga-dveṣhataḥ kṛitam\n" + "aphala-prepsunā karma yat tat sāttvikam uchyate",R.color.trans));
        mData.add(new NewsItem("","","yat tu kāmepsunā karma sāhankāreṇa vā punaḥ\n" + "kriyate bahulāyāsaṁ tad rājasam udāhṛitam",R.color.trans));
        mData.add(new NewsItem("","","anubandhaṁ kṣhayaṁ hinsām anapekṣhya cha pauruṣham\n" + "mohād ārabhyate karma yat tat tāmasam uchyate",R.color.trans));
        mData.add(new NewsItem("","","mukta-saṅgo ‘nahaṁ-vādī dhṛity-utsāha-samanvitaḥ\n" + "siddhy-asiddhyor nirvikāraḥ kartā sāttvika uchyate",R.color.trans));
        mData.add(new NewsItem("","","rāgī karma-phala-prepsur lubdho hinsātmako ‘śhuchiḥ\n" + "harṣha-śhokānvitaḥ kartā rājasaḥ parikīrtitaḥ",R.color.trans));
        mData.add(new NewsItem("","","ayuktaḥ prākṛitaḥ stabdhaḥ śhaṭho naiṣhkṛitiko ‘lasaḥ\n" + "viṣhādī dīrgha-sūtrī cha kartā tāmasa uchyate",R.color.trans));
        mData.add(new NewsItem("","","buddher bhedaṁ dhṛiteśh chaiva guṇatas tri-vidhaṁ śhṛiṇu\n" + "prochyamānam aśheṣheṇa pṛithaktvena dhanañjaya",R.color.trans));
        mData.add(new NewsItem("","","pravṛittiṁ cha nivṛittiṁ cha kāryākārye bhayābhaye\n" + "bandhaṁ mokṣhaṁ cha yā vetti buddhiḥ sā pārtha sāttvikī",R.color.trans));
        mData.add(new NewsItem("","","yayā dharmam adharmaṁ cha kāryaṁ chākāryam eva cha\n" + "ayathāvat prajānāti buddhiḥ sā pārtha rājasī",R.color.trans));
        mData.add(new NewsItem("","","adharmaṁ dharmam iti yā manyate tamasāvṛitā\n" + "sarvārthān viparītānśh cha buddhiḥ sā pārtha tāmasī",R.color.trans));
        mData.add(new NewsItem("","","dhṛityā yayā dhārayate manaḥ-prāṇendriya-kriyāḥ\n" + "yogenāvyabhichāriṇyā dhṛitiḥ sā pārtha sāttvikī",R.color.trans));
        mData.add(new NewsItem("","","yayā tu dharma-kāmārthān dhṛityā dhārayate ‘rjuna\n" + "prasaṅgena phalākāṅkṣhī dhṛitiḥ sā pārtha rājasī",R.color.trans));
        mData.add(new NewsItem("","","yayā svapnaṁ bhayaṁ śhokaṁ viṣhādaṁ madam eva cha\n" + "na vimuñchati durmedhā dhṛitiḥ sā pārtha tāmasī",R.color.trans));
        mData.add(new NewsItem("","","sukhaṁ tv idānīṁ tri-vidhaṁ śhṛiṇu me bharatarṣhabha\n" + "abhyāsād ramate yatra duḥkhāntaṁ cha nigachchhati",R.color.trans));
        mData.add(new NewsItem("","","yat tad agre viṣham iva pariṇāme ‘mṛitopamam\n" + "tat sukhaṁ sāttvikaṁ proktam ātma-buddhi-prasāda-jam",R.color.trans));
        mData.add(new NewsItem("","","viṣhayendriya-sanyogād yat tad agre ’mṛitopamam\n" + "pariṇāme viṣham iva tat sukhaṁ rājasaṁ smṛitam",R.color.trans));
        mData.add(new NewsItem("","","yad agre chānubandhe cha sukhaṁ mohanam ātmanaḥ\n" + "nidrālasya-pramādotthaṁ tat tāmasam udāhṛitam",R.color.trans));
        mData.add(new NewsItem("","","na tad asti pṛithivyāṁ vā divi deveṣhu vā punaḥ\n" + "sattvaṁ prakṛiti-jair muktaṁ yad ebhiḥ syāt tribhir guṇaiḥ",R.color.trans));
        mData.add(new NewsItem("","","brāhmaṇa-kṣhatriya-viśhāṁ śhūdrāṇāṁ cha parantapa\n" + "karmāṇi pravibhaktāni svabhāva-prabhavair guṇaiḥ",R.color.trans));
        mData.add(new NewsItem("","","śhamo damas tapaḥ śhauchaṁ kṣhāntir ārjavam eva cha\n" + "jñānaṁ vijñānam āstikyaṁ brahma-karma svabhāva-jam",R.color.trans));
        mData.add(new NewsItem("","","śhauryaṁ tejo dhṛitir dākṣhyaṁ yuddhe chāpy apalāyanam\n" + "dānam īśhvara-bhāvaśh cha kṣhātraṁ karma svabhāva-jam",R.color.trans));
        mData.add(new NewsItem("","","kṛiṣhi-gau-rakṣhya-vāṇijyaṁ vaiśhya-karma svabhāva-jam\n" + "paricharyātmakaṁ karma śhūdrasyāpi svabhāva-jam",R.color.trans));
        mData.add(new NewsItem("","","sve sve karmaṇy abhirataḥ sansiddhiṁ labhate naraḥ\n" + "sva-karma-nirataḥ siddhiṁ yathā vindati tach chhṛiṇu",R.color.trans));
        mData.add(new NewsItem("","","yataḥ pravṛittir bhūtānāṁ yena sarvam idaṁ tatam\n" + "sva-karmaṇā tam abhyarchya siddhiṁ vindati mānavaḥ",R.color.trans));
        mData.add(new NewsItem("","","śhreyān swa-dharmo viguṇaḥ para-dharmāt sv-anuṣhṭhitāt\n" + "svabhāva-niyataṁ karma kurvan nāpnoti kilbiṣham",R.color.trans));
        mData.add(new NewsItem("","","saha-jaṁ karma kaunteya sa-doṣham api na tyajet\n" + "sarvārambhā hi doṣheṇa dhūmenāgnir ivāvṛitāḥ",R.color.trans));
        mData.add(new NewsItem("","","asakta-buddhiḥ sarvatra jitātmā vigata-spṛihaḥ\n" + "naiṣhkarmya-siddhiṁ paramāṁ sannyāsenādhigachchhati",R.color.trans));
        mData.add(new NewsItem("","","siddhiṁ prāpto yathā brahma tathāpnoti nibodha me\n" + "samāsenaiva kaunteya niṣhṭhā jñānasya yā parā",R.color.trans));
        mData.add(new NewsItem("","","buddhyā viśhuddhayā yukto dhṛityātmānaṁ niyamya cha\n" + "śhabdādīn viṣhayāns tyaktvā rāga-dveṣhau vyudasya cha\n" + "vivikta-sevī laghv-āśhī yata-vāk-kāya-mānasaḥ\n" + "dhyāna-yoga-paro nityaṁ vairāgyaṁ samupāśhritaḥ\n" + "ahankāraṁ balaṁ darpaṁ kāmaṁ krodhaṁ parigraham\n" + "vimuchya nirmamaḥ śhānto brahma-bhūyāya kalpate",R.color.trans));
        mData.add(new NewsItem("","","brahma-bhūtaḥ prasannātmā na śhochati na kāṅkṣhati\n" + "samaḥ sarveṣhu bhūteṣhu mad-bhaktiṁ labhate parām",R.color.trans));
        mData.add(new NewsItem("","","bhaktyā mām abhijānāti yāvān yaśh chāsmi tattvataḥ\n" + "tato māṁ tattvato jñātvā viśhate tad-anantaram",R.color.trans));
        mData.add(new NewsItem("","","sarva-karmāṇy api sadā kurvāṇo mad-vyapāśhrayaḥ\n" + "mat-prasādād avāpnoti śhāśhvataṁ padam avyayam",R.color.trans));
        mData.add(new NewsItem("","","chetasā sarva-karmāṇi mayi sannyasya mat-paraḥ\n" + "buddhi-yogam upāśhritya mach-chittaḥ satataṁ bhava",R.color.trans));
        mData.add(new NewsItem("","","mach-chittaḥ sarva-durgāṇi mat-prasādāt tariṣhyasi\n" + "atha chet tvam ahankārān na śhroṣhyasi vinaṅkṣhyasi",R.color.trans));
        mData.add(new NewsItem("","","yad ahankāram āśhritya na yotsya iti manyase\n" + "mithyaiṣha vyavasāyas te prakṛitis tvāṁ niyokṣhyati",R.color.trans));
        mData.add(new NewsItem("","","swbhāva-jena kaunteya nibaddhaḥ svena karmaṇā\n" + "kartuṁ nechchhasi yan mohāt kariṣhyasy avaśho ’pi tat",R.color.trans));
        mData.add(new NewsItem("","","īśhvaraḥ sarva-bhūtānāṁ hṛid-deśhe ‘rjuna tiṣhṭhati\n" + "bhrāmayan sarva-bhūtāni yantrārūḍhāni māyayā",R.color.trans));
        mData.add(new NewsItem("","","tam eva śharaṇaṁ gachchha sarva-bhāvena bhārata\n" + "tat-prasādāt parāṁ śhāntiṁ sthānaṁ prāpsyasi śhāśhvatam",R.color.trans));
        mData.add(new NewsItem("","","iti te jñānam ākhyātaṁ guhyād guhyataraṁ mayā\n" + "vimṛiśhyaitad aśheṣheṇa yathechchhasi tathā kuru",R.color.trans));
        mData.add(new NewsItem("","","sarva-guhyatamaṁ bhūyaḥ śhṛiṇu me paramaṁ vachaḥ\n" + "iṣhṭo ‘si me dṛiḍham iti tato vakṣhyāmi te hitam",R.color.trans));
        mData.add(new NewsItem("","","man-manā bhava mad-bhakto mad-yājī māṁ namaskuru\n" + "mām evaiṣhyasi satyaṁ te pratijāne priyo ‘si me",R.color.trans));
        mData.add(new NewsItem("","","sarva-dharmān parityajya mām ekaṁ śharaṇaṁ vraja\n" + "ahaṁ tvāṁ sarva-pāpebhyo mokṣhayiṣhyāmi mā śhuchaḥ",R.color.trans));
        mData.add(new NewsItem("","","idaṁ te nātapaskyāya nābhaktāya kadāchana\n" + "na chāśhuśhruṣhave vāchyaṁ na cha māṁ yo ‘bhyasūtayi",R.color.trans));
        mData.add(new NewsItem("","","ya idaṁ paramaṁ guhyaṁ mad-bhakteṣhv abhidhāsyati\n" + "bhaktiṁ mayi parāṁ kṛitvā mām evaiṣhyaty asanśhayaḥ",R.color.trans));
        mData.add(new NewsItem("","","na cha tasmān manuṣhyeṣhu kaśhchin me priya-kṛittamaḥ\n" + "bhavitā na cha me tasmād anyaḥ priyataro bhuvi",R.color.trans));
        mData.add(new NewsItem("","","adhyeṣhyate cha ya imaṁ dharmyaṁ saṁvādam āvayoḥ\n" + "jñāna-yajñena tenāham iṣhṭaḥ syām iti me matiḥ",R.color.trans));
        mData.add(new NewsItem("","","śhraddhāvān anasūyaśh cha śhṛiṇuyād api yo naraḥ\n" + "so ‘pi muktaḥ śhubhāl lokān prāpnuyāt puṇya-karmaṇām",R.color.trans));
        mData.add(new NewsItem("","","kachchid etach chhrutaṁ pārtha tvayaikāgreṇa chetasā\n" + "kachchid ajñāna-sammohaḥ pranaṣhṭas te dhanañjaya",R.color.trans));
        mData.add(new NewsItem("","","arjuna uvācha\n" + "naṣhṭo mohaḥ smṛitir labdhā tvat-prasādān mayāchyuta\n" + "sthito ‘smi gata-sandehaḥ kariṣhye vachanaṁ tava",R.color.trans));
        mData.add(new NewsItem("","","sañjaya uvācha\n" + "ity ahaṁ vāsudevasya pārthasya cha mahātmanaḥ\n" + "saṁvādam imam aśhrauṣham adbhutaṁ roma-harṣhaṇam",R.color.trans));
        mData.add(new NewsItem("","","vyāsa-prasādāch chhrutavān etad guhyam ahaṁ param\n" + "yogaṁ yogeśhvarāt kṛiṣhṇāt sākṣhāt kathayataḥ svayam",R.color.trans));
        mData.add(new NewsItem("","","rājan sansmṛitya sansmṛitya saṁvādam imam adbhutam\n" + "keśhavārjunayoḥ puṇyaṁ hṛiṣhyāmi cha muhur muhuḥ",R.color.trans));
        mData.add(new NewsItem("","","tach cha sansmṛitya saṁsmṛitya rūpam aty-adbhutaṁ hareḥ\n" + "vismayo ye mahān rājan hṛiṣhyāmi cha punaḥ punaḥ",R.color.trans));
        mData.add(new NewsItem("","","yatra yogeśhvaraḥ kṛiṣhṇo yatra pārtho dhanur-dharaḥ\n" + "tatra śhrīr vijayo bhūtir dhruvā nītir matir mama",R.color.trans));
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