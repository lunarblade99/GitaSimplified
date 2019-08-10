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
import com.github.gitasimplified.chp.Chp10;
import com.github.gitasimplified.chp.Chp11;
import com.github.gitasimplified.chp.Chp12;
import com.github.gitasimplified.chp.Chp13;
import com.github.gitasimplified.chp.Chp14;
import com.github.gitasimplified.chp.Chp15;
import com.github.gitasimplified.chp.Chp16;
import com.github.gitasimplified.chp.Chp17;
import com.github.gitasimplified.chp.Chp18;
import com.github.gitasimplified.chp.Chp3;
import com.github.gitasimplified.chp.Chp4;
import com.github.gitasimplified.chp.Chp5;
import com.github.gitasimplified.chp.Chp6;
import com.github.gitasimplified.chp.Chp7;
import com.github.gitasimplified.chp.Chp8;
import com.github.gitasimplified.chp.Chp9;

import java.util.ArrayList;
import java.util.List;

public class Vchp2 extends AppCompatActivity
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
                Toast.makeText(Vchp2.this, "You Clicked: " + thisItem.getTitle(), Toast.LENGTH_SHORT).show();
            }
            if(position == 1) {
                Toast.makeText(Vchp2.this, "You Clicked: " + thisItem.getTitle(), Toast.LENGTH_SHORT).show();
            }
            if(position == 2) {
                Toast.makeText(Vchp2.this, "You Clicked: " + thisItem.getTitle(), Toast.LENGTH_SHORT).show();
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
        navigationView.getMenu().getItem(1).setChecked(true);

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
        mData.add(new NewsItem("","","\n" + "\n" + "sañjaya uvācha\n" + "taṁ tathā kṛipayāviṣhṭamaśhru pūrṇākulekṣhaṇam\n" + "viṣhīdantamidaṁ vākyam uvācha madhusūdanaḥ\n",R.color.trans));
        mData.add(new NewsItem("","","śhrī bhagavān uvācha\n" + "kutastvā kaśhmalamidaṁ viṣhame samupasthitam\n" + "anārya-juṣhṭamaswargyam akīrti-karam arjuna",R.color.trans));
        mData.add(new NewsItem("","","klaibyaṁ mā sma gamaḥ pārtha naitat tvayyupapadyate\n" + "kṣhudraṁ hṛidaya-daurbalyaṁ tyaktvottiṣhṭha parantapa",R.color.trans));
        mData.add(new NewsItem("","","arjuna uvācha\n" + "kathaṁ bhīṣhmam ahaṁ sankhye droṇaṁ cha madhusūdana\n" + "iṣhubhiḥ pratiyotsyāmi pūjārhāvari-sūdana",R.color.trans));
        mData.add(new NewsItem("","","gurūnahatvā hi mahānubhāvān\n" + "śhreyo bhoktuṁ bhaikṣhyamapīha loke\n" + "hatvārtha-kāmāṁstu gurūnihaiva\n" + "bhuñjīya bhogān rudhira-pradigdhān",R.color.trans));
        mData.add(new NewsItem("","","na chaitadvidmaḥ kataranno garīyo\n" + "yadvā jayema yadi vā no jayeyuḥ\n" + "yāneva hatvā na jijīviṣhāmas\n" + "te ’vasthitāḥ pramukhe dhārtarāṣhṭrāḥ",R.color.trans));
        mData.add(new NewsItem("","","kārpaṇya-doṣhopahata-svabhāvaḥ\n" + "pṛichchhāmi tvāṁ dharma-sammūḍha-chetāḥ\n" + "yach-chhreyaḥ syānniśhchitaṁ brūhi tanme\n" + "śhiṣhyaste ’haṁ śhādhi māṁ tvāṁ prapannam",R.color.trans));
        mData.add(new NewsItem("","","na hi prapaśhyāmi mamāpanudyād\n" + "yach-chhokam uchchhoṣhaṇam-indriyāṇām\n" + "avāpya bhūmāv-asapatnamṛiddhaṁ\n" + "rājyaṁ surāṇāmapi chādhipatyam",R.color.trans));
        mData.add(new NewsItem("","","\n" + "\n" + "sañjaya uvācha\n" + "evam-uktvā hṛiṣhīkeśhaṁ guḍākeśhaḥ parantapa\n" + "na yotsya iti govindam uktvā tūṣhṇīṁ babhūva ha\n",R.color.trans));
        mData.add(new NewsItem("","","tam-uvācha hṛiṣhīkeśhaḥ prahasanniva bhārata\n" + "senayorubhayor-madhye viṣhīdantam-idaṁ vachaḥ",R.color.trans));
        mData.add(new NewsItem("","","śhrī bhagavān uvācha\n" + "aśhochyān-anvaśhochas-tvaṁ prajñā-vādānśh cha bhāṣhase\n" + "gatāsūn-agatāsūnśh-cha nānuśhochanti paṇḍitāḥ",R.color.trans));
        mData.add(new NewsItem("","","na tvevāhaṁ jātu nāsaṁ na tvaṁ neme janādhipāḥ\n" + "na chaiva na bhaviṣhyāmaḥ sarve vayamataḥ param",R.color.trans));
        mData.add(new NewsItem("","","dehino ’smin yathā dehe kaumāraṁ yauvanaṁ jarā\n" + "tathā dehāntara-prāptir dhīras tatra na muhyati",R.color.trans));
        mData.add(new NewsItem("","","mātrā-sparśhās tu kaunteya śhītoṣhṇa-sukha-duḥkha-dāḥ\n" + "āgamāpāyino ’nityās tans-titikṣhasva bhārata",R.color.trans));
        mData.add(new NewsItem("","","yaṁ hi na vyathayantyete puruṣhaṁ puruṣharṣhabha\n" + "sama-duḥkha-sukhaṁ dhīraṁ so ’mṛitatvāya kalpate",R.color.trans));
        mData.add(new NewsItem("","","nāsato vidyate bhāvo nābhāvo vidyate sataḥ\n" + "ubhayorapi dṛiṣhṭo ’nta stvanayos tattva-darśhibhiḥ",R.color.trans));
        mData.add(new NewsItem("","","avināśhi tu tadviddhi yena sarvam idaṁ tatam\n" + "vināśham avyayasyāsya na kaśhchit kartum arhati",R.color.trans));
        mData.add(new NewsItem("","","antavanta ime dehā nityasyoktāḥ śharīriṇaḥ\n" + "anāśhino ’prameyasya tasmād yudhyasva bhārata",R.color.trans));
        mData.add(new NewsItem("","","ya enaṁ vetti hantāraṁ yaśh chainaṁ manyate hatam\n" + "ubhau tau na vijānīto nāyaṁ hanti na hanyate",R.color.trans));
        mData.add(new NewsItem("","","na jāyate mriyate vā kadāchin\n" + "nāyaṁ bhūtvā bhavitā vā na bhūyaḥ\n" + "ajo nityaḥ śhāśhvato ’yaṁ purāṇo\n" + "na hanyate hanyamāne śharīre",R.color.trans));
        mData.add(new NewsItem("","","vedāvināśhinaṁ nityaṁ ya enam ajam avyayam\n" + "kathaṁ sa puruṣhaḥ pārtha kaṁ ghātayati hanti kam",R.color.trans));
        mData.add(new NewsItem("","","vāsānsi jīrṇāni yathā vihāya\n" + "navāni gṛihṇāti naro ’parāṇi\n" + "tathā śharīrāṇi vihāya jīrṇānya\n" + "nyāni sanyāti navāni dehī",R.color.trans));
        mData.add(new NewsItem("","","nainaṁ chhindanti śhastrāṇi nainaṁ dahati pāvakaḥ\n" + "na chainaṁ kledayantyāpo na śhoṣhayati mārutaḥ",R.color.trans));
        mData.add(new NewsItem("","","achchhedyo ’yam adāhyo ’yam akledyo ’śhoṣhya eva cha\n" + "nityaḥ sarva-gataḥ sthāṇur achalo ’yaṁ sanātanaḥ",R.color.trans));
        mData.add(new NewsItem("","","avyakto ’yam achintyo ’yam avikāryo ’yam uchyate\n" + "tasmādevaṁ viditvainaṁ nānuśhochitum arhasi",R.color.trans));
        mData.add(new NewsItem("","","atha chainaṁ nitya-jātaṁ nityaṁ vā manyase mṛitam\n" + "tathāpi tvaṁ mahā-bāho naivaṁ śhochitum arhasi",R.color.trans));
        mData.add(new NewsItem("","","jātasya hi dhruvo mṛityur dhruvaṁ janma mṛitasya cha\n" + "tasmād aparihārye ’rthe na tvaṁ śhochitum arhasi",R.color.trans));
        mData.add(new NewsItem("","","avyaktādīni bhūtāni vyakta-madhyāni bhārata\n" + "avyakta-nidhanānyeva tatra kā paridevanā",R.color.trans));
        mData.add(new NewsItem("","","āśhcharya-vat paśhyati kaśhchid enan\n" + "āśhcharya-vad vadati tathaiva chānyaḥ\n" + "āśhcharya-vach chainam anyaḥ śhṛiṇoti\n" + "śhrutvāpyenaṁ veda na chaiva kaśhchit",R.color.trans));
        mData.add(new NewsItem("","","dehī nityam avadhyo ’yaṁ dehe sarvasya bhārata\n" + "tasmāt sarvāṇi bhūtāni na tvaṁ śhochitum arhasi",R.color.trans));
        mData.add(new NewsItem("","","swa-dharmam api chāvekṣhya na vikampitum arhasi\n" + "dharmyāddhi yuddhāch chhreyo ’nyat kṣhatriyasya na vidyate",R.color.trans));
        mData.add(new NewsItem("","","yadṛichchhayā chopapannaṁ swarga-dvāram apāvṛitam\n" + "sukhinaḥ kṣhatriyāḥ pārtha labhante yuddham īdṛiśham",R.color.trans));
        mData.add(new NewsItem("","","atha chet tvam imaṁ dharmyaṁ saṅgrāmaṁ na kariṣhyasi\n" + "tataḥ sva-dharmaṁ kīrtiṁ cha hitvā pāpam avāpsyasi",R.color.trans));
        mData.add(new NewsItem("","","akīrtiṁ chāpi bhūtāni\n" + "kathayiṣhyanti te ’vyayām\n" + "sambhāvitasya chākīrtir\n" + "maraṇād atirichyate",R.color.trans));
        mData.add(new NewsItem("","","bhayād raṇād uparataṁ mansyante tvāṁ mahā-rathāḥ\n" + "yeṣhāṁ cha tvaṁ bahu-mato bhūtvā yāsyasi lāghavam",R.color.trans));
        mData.add(new NewsItem("","","avāchya-vādānśh cha bahūn vadiṣhyanti tavāhitāḥ\n" + "nindantastava sāmarthyaṁ tato duḥkhataraṁ nu kim",R.color.trans));
        mData.add(new NewsItem("","","hato vā prāpsyasi swargaṁ jitvā vā bhokṣhyase mahīm\n" + "tasmād uttiṣhṭha kaunteya yuddhāya kṛita-niśhchayaḥ",R.color.trans));
        mData.add(new NewsItem("","","sukha-duḥkhe same kṛitvā lābhālābhau jayājayau\n" + "tato yuddhāya yujyasva naivaṁ pāpam avāpsyasi",R.color.trans));
        mData.add(new NewsItem("","","eṣhā te ’bhihitā sānkhye\n" + "buddhir yoge tvimāṁ śhṛiṇu\n" + "buddhyā yukto yayā pārtha\n" + "karma-bandhaṁ prahāsyasi",R.color.trans));
        mData.add(new NewsItem("","","nehābhikrama-nāśho ’sti pratyavāyo na vidyate\n" + "svalpam apyasya dharmasya trāyate mahato bhayāt",R.color.trans));
        mData.add(new NewsItem("","","vyavasāyātmikā buddhir ekeha kuru-nandana\n" + "bahu-śhākhā hyanantāśh cha buddhayo ’vyavasāyinām",R.color.trans));
        mData.add(new NewsItem("","","yāmimāṁ puṣhpitāṁ vāchaṁ pravadanty-avipaśhchitaḥ\n" + "veda-vāda-ratāḥ pārtha nānyad astīti vādinaḥ\n" + "kāmātmānaḥ swarga-parā janma-karma-phala-pradām\n" + "kriyā-viśheṣha-bahulāṁ bhogaiśhwarya-gatiṁ prati",R.color.trans));
        mData.add(new NewsItem("","","bhogaiśwvarya-prasaktānāṁ tayāpahṛita-chetasām\n" + "vyavasāyātmikā buddhiḥ samādhau na vidhīyate",R.color.trans));
        mData.add(new NewsItem("","","trai-guṇya-viṣhayā vedā nistrai-guṇyo bhavārjuna\n" + "nirdvandvo nitya-sattva-stho niryoga-kṣhema ātmavān",R.color.trans));
        mData.add(new NewsItem("","","yāvān artha udapāne sarvataḥ samplutodake\n" + "tāvānsarveṣhu vedeṣhu brāhmaṇasya vijānataḥ",R.color.trans));
        mData.add(new NewsItem("","","karmaṇy-evādhikāras te mā phaleṣhu kadāchana\n" + "mā karma-phala-hetur bhūr mā te saṅgo ’stvakarmaṇi",R.color.trans));
        mData.add(new NewsItem("","","yoga-sthaḥ kuru karmāṇi saṅgaṁ tyaktvā dhanañjaya\n" + "siddhy-asiddhyoḥ samo bhūtvā samatvaṁ yoga uchyate",R.color.trans));
        mData.add(new NewsItem("","","dūreṇa hy-avaraṁ karma buddhi-yogād dhanañjaya\n" + "buddhau śharaṇam anvichchha kṛipaṇāḥ phala-hetavaḥ",R.color.trans));
        mData.add(new NewsItem("","","buddhi-yukto jahātīha ubhe sukṛita-duṣhkṛite\n" + "tasmād yogāya yujyasva yogaḥ karmasu kauśhalam",R.color.trans));
        mData.add(new NewsItem("","","karma-jaṁ buddhi-yuktā hi phalaṁ tyaktvā manīṣhiṇaḥ\n" + "janma-bandha-vinirmuktāḥ padaṁ gachchhanty-anāmayam",R.color.trans));
        mData.add(new NewsItem("","","yadā te moha-kalilaṁ buddhir vyatitariṣhyati\n" + "tadā gantāsi nirvedaṁ śhrotavyasya śhrutasya cha",R.color.trans));
        mData.add(new NewsItem("","","śhruti-vipratipannā te yadā sthāsyati niśhchalā\n" + "samādhāv-achalā buddhis tadā yogam avāpsyasi",R.color.trans));
        mData.add(new NewsItem("","","arjuna uvācha\n" + "sthita-prajñasya kā bhāṣhā samādhi-sthasya keśhava\n" + "sthita-dhīḥ kiṁ prabhāṣheta kim āsīta vrajeta kim",R.color.trans));
        mData.add(new NewsItem("","","śhrī bhagavān uvācha\n" + "prajahāti yadā kāmān sarvān pārtha mano-gatān\n" + "ātmany-evātmanā tuṣhṭaḥ sthita-prajñas tadochyate",R.color.trans));
        mData.add(new NewsItem("","","duḥkheṣhv-anudvigna-manāḥ sukheṣhu vigata-spṛihaḥ\n" + "vīta-rāga-bhaya-krodhaḥ sthita-dhīr munir uchyate",R.color.trans));
        mData.add(new NewsItem("","","yaḥ sarvatrānabhisnehas tat tat prāpya śhubhāśhubham\n" + "nābhinandati na dveṣhṭi tasya prajñā pratiṣhṭhitā",R.color.trans));
        mData.add(new NewsItem("","","yadā sanharate chāyaṁ kūrmo ’ṅgānīva sarvaśhaḥ\n" + "indriyāṇīndriyārthebhyas tasya prajñā pratiṣhṭhitā",R.color.trans));
        mData.add(new NewsItem("","","viṣhayā vinivartante nirāhārasya dehinaḥ\n" + "rasa-varjaṁ raso ’pyasya paraṁ dṛiṣhṭvā nivartate",R.color.trans));
        mData.add(new NewsItem("","","yatato hyapi kaunteya puruṣhasya vipaśhchitaḥ\n" + "indriyāṇi pramāthīni haranti prasabhaṁ manaḥ",R.color.trans));
        mData.add(new NewsItem("","","tāni sarvāṇi sanyamya yukta āsīta mat-paraḥ\n" + "vaśhe hi yasyendriyāṇi tasya prajñā pratiṣhṭhitā",R.color.trans));
        mData.add(new NewsItem("","","dhyāyato viṣhayān puṁsaḥ saṅgas teṣhūpajāyate\n" + "saṅgāt sañjāyate kāmaḥ kāmāt krodho ’bhijāyate",R.color.trans));
        mData.add(new NewsItem("","","krodhād bhavati sammohaḥ sammohāt smṛiti-vibhramaḥ\n" + "smṛiti-bhranśhād buddhi-nāśho buddhi-nāśhāt praṇaśhyati",R.color.trans));
        mData.add(new NewsItem("","","rāga-dveṣha-viyuktais tu viṣhayān indriyaiśh charan\n" + "ātma-vaśhyair-vidheyātmā prasādam adhigachchhati",R.color.trans));
        mData.add(new NewsItem("","","prasāde sarva-duḥkhānāṁ hānir asyopajāyate\n" + "prasanna-chetaso hyāśhu buddhiḥ paryavatiṣhṭhate",R.color.trans));
        mData.add(new NewsItem("","","nāsti buddhir-ayuktasya na chāyuktasya bhāvanā\n" + "na chābhāvayataḥ śhāntir aśhāntasya kutaḥ sukham",R.color.trans));
        mData.add(new NewsItem("","","indriyāṇāṁ hi charatāṁ yan mano ’nuvidhīyate\n" + "tadasya harati prajñāṁ vāyur nāvam ivāmbhasi",R.color.trans));
        mData.add(new NewsItem("","","tasmād yasya mahā-bāho nigṛihītāni sarvaśhaḥ\n" + "indriyāṇīndriyārthebhyas tasya prajñā pratiṣhṭhitā",R.color.trans));
        mData.add(new NewsItem("","","yā niśhā sarva-bhūtānāṁ tasyāṁ jāgarti sanyamī\n" + "yasyāṁ jāgrati bhūtāni sā niśhā paśhyato muneḥ",R.color.trans));
        mData.add(new NewsItem("","","āpūryamāṇam achala-pratiṣhṭhaṁ\n" + "samudram āpaḥ praviśhanti yadvat\n" + "tadvat kāmā yaṁ praviśhanti sarve\n" + "sa śhāntim āpnoti na kāma-kāmī",R.color.trans));
        mData.add(new NewsItem("","","vihāya kāmān yaḥ sarvān pumānśh charati niḥspṛihaḥ\n" + "nirmamo nirahankāraḥ sa śhāntim adhigachchhati",R.color.trans));
        mData.add(new NewsItem("","","eṣhā brāhmī sthitiḥ pārtha naināṁ prāpya vimuhyati\n" + "sthitvāsyām anta-kāle ’pi brahma-nirvāṇam ṛichchhati",R.color.trans));





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