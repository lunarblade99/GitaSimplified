package com.github.gitasimplified;

import android.content.Intent;
import android.content.SharedPreferences;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.appcompat.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import com.github.gitasimplified.vchp.Vchp10;
import com.github.gitasimplified.vchp.Vchp11;
import com.github.gitasimplified.vchp.Vchp12;
import com.github.gitasimplified.vchp.Vchp13;
import com.github.gitasimplified.vchp.Vchp14;
import com.github.gitasimplified.vchp.Vchp15;
import com.github.gitasimplified.vchp.Vchp16;
import com.github.gitasimplified.vchp.Vchp17;
import com.github.gitasimplified.vchp.Vchp18;
import com.github.gitasimplified.vchp.Vchp2;
import com.github.gitasimplified.vchp.Vchp3;
import com.github.gitasimplified.vchp.Vchp4;
import com.github.gitasimplified.vchp.Vchp5;
import com.github.gitasimplified.vchp.Vchp6;
import com.github.gitasimplified.vchp.Vchp7;
import com.github.gitasimplified.vchp.Vchp8;
import com.github.gitasimplified.vchp.Vchp9;
import com.shashank.sony.fancygifdialoglib.FancyGifDialog;
import com.shashank.sony.fancygifdialoglib.FancyGifDialogListener;

import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends AppCompatActivity
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

            if(position == 0) {}

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
        navigationView.getMenu().getItem(0).setChecked(true);

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
        mData.add(new NewsItem("धृतराष्ट्र उवाच |\n" + "धर्मक्षेत्रे कुरुक्षेत्रे समवेता युयुत्सवः |\n" + "मामकाः पाण्डवाश्चैव किमकुर्वत सञ्जय ||1||","dhṛitarāśhtraḥ uvācha—Dhritarashtra said; dharma-kṣhetre—the land of dharma; kuru-kṣhetre—at Kurukshetra; samavetāḥ—having gathered; yuyutsavaḥ—desiring to fight; māmakāḥ—my sons; pāṇḍavāḥ—the sons of Pandu; cha—and; eva—certainly; kim—what; akurvata—did they do; sañjaya—Sanjay ","dhṛitarāśhtra uvācha\n" + "dharma-kṣhetre kuru-kṣhetre samavetā yuyutsavaḥ\n" + "māmakāḥ pāṇḍavāśhchaiva kimakurvata sañjaya",R.color.trans));
        mData.add(new NewsItem("सञ्जय उवाच ।\n" + "दृष्ट्वा तु पाण्डवानीकं व्यूढं दुर्योधनस्तदा ।\n" + "आचार्यमुपसङ्गम्य राजा वचनमब्रवीत् ।। 2।।"," sanjayaḥ uvācha—Sanjay said; dṛiṣhṭvā—on observing; tu—but; pāṇḍava-anīkam—the Pandava army; vyūḍham—standing in a military formation; duryodhanaḥ—King Duryodhan; tadā—then; āchāryam—teacher; upasaṅgamya—approached; rājā—the king; vachanam—words; abravīt—spoke ","sañjaya uvācha\n" + "dṛiṣhṭvā tu pāṇḍavānīkaṁ vyūḍhaṁ duryodhanastadā\n" + "āchāryamupasaṅgamya rājā vachanamabravīt",R.color.trans));
        mData.add(new NewsItem("पश्यैतां पाण्डुपुत्राणामाचार्य महतीं चमूम् ।\n" + "व्यूढां द्रुपदपुत्रेण तव शिष्येण धीमता ।। 3।।"," paśhya—behold; etām—this; pāṇḍu-putrāṇām—of the sons of Pandu; āchārya—respected teacher; mahatīm—mighty; chamūm—army; vyūḍhām—arrayed in a military formation; drupada-putreṇa—son of Drupad, Dhrishtadyumna; tava—by your; śhiṣhyeṇa—disciple; dhī-matā—intelligent ","sañjaya uvācha\n" + "dṛiṣhṭvā tu pāṇḍavānīkaṁ vyūḍhaṁ duryodhanastadā\n" + "āchāryamupasaṅgamya rājā vachanamabravīt",R.color.trans));
        mData.add(new NewsItem("\n" + "\n" + "अत्र शूरा महेष्वासा भीमार्जुनसमा युधि\n" + "युयुधानो विराटश्च द्रुपदश्च महारथ: || 4||\n" + "\n" + "धृष्टकेतुश्चेकितान: काशिराजश्च वीर्यवान् |\n" + "पुरुजित्कुन्तिभोजश्च शैयश्च नरपुङ्गव: || 5||\n" + "\n" + "युधामन्युश्च विक्रान्त उत्तमौजाश्च वीर्यवान् |\n" + "सौभद्रो द्रौपदेयाश्च सर्व एव महारथा: || 6||\n"," atra—here; śhūrāḥ—powerful warriors; mahā-iṣhu-āsāḥ—great bowmen; bhīma-arjuna-samāḥ—equal to Bheem and Arjun; yudhi—in military prowess; yuyudhānaḥ—Yuyudhan; virāṭaḥ—Virat; cha—and; drupadaḥ—Drupad; cha—also; mahā-rathaḥ—warriors who could single handedly match the strength of ten thousand ordinary warriors; dhṛiṣhṭaketuḥ—Dhrishtaketu; chekitānaḥ—Chekitan; kāśhirājaḥ—Kashiraj; cha—and; vīrya-vān—heroic; purujit—Purujit; kuntibhojaḥ—Kuntibhoj; cha—and; śhaibyaḥ—Shaibya; cha—and; nara-puṅgavaḥ—best of men; yudhāmanyuḥ—Yudhamanyu; cha—and; vikrāntaḥ—courageous; uttamaujāḥ—Uttamauja; cha—and; vīrya-vān—gallant; saubhadraḥ—the son of Subhadra; draupadeyāḥ—the sons of Draupadi; cha—and; sarve—all; eva—indeed; mahā-rathāḥ—warriors who could single handedly match the strength of ten thousand ordinary warriors ","asmākaṁ tu viśhiṣhṭā ye tānnibodha dwijottama\n" + "nāyakā mama sainyasya sanjñārthaṁ tānbravīmi te",R.color.trans));
        mData.add(new NewsItem("अस्माकं तु विशिष्टा ये तान्निबोध द्विजोत्तम |\n" + "नायका मम सैन्यस्य संज्ञार्थं तान्ब्रवीमि ते || 7||"," asmākam—ours; tu—but; viśhiṣhṭāḥ—special; ye—who; tān—them; nibodha—be informed; dwija-uttama—best of Brahmins; nāyakāḥ—principal generals; mama—our; sainyasya—of army; sanjñā-artham—for information; tān—them; bravīmi—I recount; te—unto you ","bhavānbhīṣhmaśhcha karṇaśhcha kṛipaśhcha samitiñjayaḥ\n" + "aśhvatthāmā vikarṇaśhcha saumadattis tathaiva cha",R.color.trans));
        mData.add(new NewsItem("भवान्भीष्मश्च कर्णश्च कृपश्च समितिञ्जय: |\n" + "अश्वत्थामा विकर्णश्च सौमदत्तिस्तथैव च || 8||"," bhavān—yourself; bhīṣhmaḥ—Bheeshma; cha—and; karṇaḥ—Karna; cha—and; kṛipaḥ—Kripa; cha—and; samitim-jayaḥ—victorious in battle; aśhvatthāmā—Ashvatthama; vikarṇaḥ—Vikarna; cha—and; saumadattiḥ—Bhurishrava; tathā—thus; eva—even; cha—also ","anye cha bahavaḥ śhūrā madarthe tyaktajīvitāḥ\n" + "nānā-śhastra-praharaṇāḥ sarve yuddha-viśhāradāḥ",R.color.trans));
        mData.add(new NewsItem("\n" + "अन्ये च बहव: शूरा मदर्थे त्यक्तजीविता: |\n" + "नानाशस्त्रप्रहरणा: सर्वे युद्धविशारदा: || 9||\n"," anye—others; cha—also; bahavaḥ—many; śhūrāḥ—heroic warriors; mat-arthe—for my sake; tyakta-jīvitāḥ—prepared to lay down their lives; nānā-śhastra-praharaṇāḥ—equipped with various kinds of weapons; sarve—all; yuddha-viśhāradāḥ—skilled in the art of warfare ","aparyāptaṁ tadasmākaṁ balaṁ bhīṣhmābhirakṣhitam\n" + "paryāptaṁ tvidameteṣhāṁ balaṁ bhīmābhirakṣhitam",R.color.trans));
        mData.add(new NewsItem("\n" + "\n" + "अपर्याप्तं तदस्माकं बलं भीष्माभिरक्षितम् |\n" + "पर्याप्तं त्विदमेतेषां बलं भीमाभिरक्षितम् || 10||\n"," aparyāptam—unlimited; tat—that; asmākam—ours; balam—strength; bhīṣhma—by Grandsire Bheeshma; abhirakṣhitam—safely marshalled; paryāptam—limited; tu—but; idam—this; eteṣhām—their; balam—strength; bhīma—Bheem; abhirakṣhitam—carefully marshalled ","ayaneṣhu cha sarveṣhu yathā-bhāgamavasthitāḥ\n" + "bhīṣhmamevābhirakṣhantu bhavantaḥ sarva eva hi",R.color.trans));
        mData.add(new NewsItem("अयनेषु च सर्वेषु यथाभागमवस्थिता: |\n" + "भीष्ममेवाभिरक्षन्तु भवन्त: सर्व एव हि || 11||"," ayaneṣhu—at the strategic points; cha—also; sarveṣhu—all; yathā-bhāgam—in respective position; avasthitāḥ—situated; bhīṣhmam—to Grandsire Bheeshma; eva—only; abhirakṣhantu—defend; bhavantaḥ—you; sarve—all; eva hi—even as ","tasya sañjanayan harṣhaṁ kuru-vṛiddhaḥ pitāmahaḥ\n" + "siṁha-nādaṁ vinadyochchaiḥ śhaṅkhaṁ dadhmau pratāpavān",R.color.trans));
        mData.add(new NewsItem("तस्य सञ्जनयन्हर्षं कुरुवृद्ध: पितामह: |\n" + "सिंहनादं विनद्योच्चै: शङ्खं दध्मौ प्रतापवान् || 12||"," tasya—his; sañjanayan—causing; harṣham—joy; kuru-vṛiddhaḥ—the grand old man of the Kuru dynasty (Bheeshma); pitāmahaḥ—grandfather; sinha-nādam—lion’s roar; vinadya—sounding; uchchaiḥ—very loudly; śhaṅkham—conch shell; dadhmau—blew; pratāpa-vān—the glorious ","tataḥ śhaṅkhāśhcha bheryaśhcha paṇavānaka-gomukhāḥ\n" + "sahasaivābhyahanyanta sa śhabdastumulo ’bhavat",R.color.trans));
        mData.add(new NewsItem("तत: शङ्खाश्च भेर्यश्च पणवानकगोमुखा: |\n" + "सहसैवाभ्यहन्यन्त स शब्दस्तुमुलोऽभवत् || 13||"," tataḥ—thereafter; śhaṅkhāḥ—conches; cha—and; bheryaḥ—bugles; cha—and; paṇava-ānaka—drums and kettledrums; go-mukhāḥ—trumpets; sahasā—suddenly; eva—indeed; abhyahanyanta—blared forth; saḥ—that; śhabdaḥ—sound; tumulaḥ—overwhelming; abhavat—was ","tataḥ śhvetairhayairyukte mahati syandane sthitau\n" + "mādhavaḥ pāṇḍavaśhchaiva divyau śhaṅkhau pradadhmatuḥ",R.color.trans));
        mData.add(new NewsItem("तत: श्वेतैर्हयैर्युक्ते महति स्यन्दने स्थितौ |\n" + "माधव: पाण्डवश्चैव दिव्यौ शङ्खौ प्रदध्मतु: || 14||"," tataḥ—then; śhvetaiḥ—by white; hayaiḥ—horses; yukte—yoked; mahati—glorious; syandane—chariot; sthitau—seated; mādhavaḥ—Shree Krishna, the husband of the goddess of fortune, Lakshmi; pāṇḍavaḥ—Arjun; cha—and; eva—also; divyau—Divine; śhaṅkhau—conch shells; pradadhmatuḥ—blew ","pāñchajanyaṁ hṛiṣhīkeśho devadattaṁ dhanañjayaḥ\n" + "pauṇḍraṁ dadhmau mahā-śhaṅkhaṁ bhīma-karmā vṛikodaraḥ",R.color.trans));
        mData.add(new NewsItem("पाञ्चजन्यं हृषीकेशो देवदत्तं धनञ्जय: |\n" + "पौण्ड्रं दध्मौ महाशङ्खं भीमकर्मा वृकोदर: || 15||"," pāñchajanyam—the conch shell named Panchajanya; hṛiṣhīka-īśhaḥ—Shree Krishna, the Lord of the mind and senses; devadattam—the conch shell named Devadutta; dhanam-jayaḥ—Arjun, the winner of wealth; pauṇḍram—the conch named Paundra; dadhmau—blew; mahā-śhaṅkham—mighty conch; bhīma-karmā—one who performs herculean tasks; vṛika-udaraḥ—Bheem, the voracious eater ","anantavijayaṁ rājā kuntī-putro yudhiṣhṭhiraḥ\n" + "nakulaḥ sahadevaśhcha sughoṣha-maṇipuṣhpakau\n" + "kāśhyaśhcha parameṣhvāsaḥ śhikhaṇḍī cha mahā-rathaḥ\n" + "dhṛiṣhṭadyumno virāṭaśhcha sātyakiśh chāparājitaḥ\n" + "drupado draupadeyāśhcha sarvaśhaḥ pṛithivī-pate\n" + "saubhadraśhcha mahā-bāhuḥ śhaṅkhāndadhmuḥ pṛithak pṛithak",R.color.trans));
        mData.add(new NewsItem("अनन्तविजयं राजा कुन्तीपुत्रो युधिष्ठिर: |\n" + "नकुल: सहदेवश्च सुघोषमणिपुष्पकौ || 16||\n" + "काश्यश्च परमेष्वास: शिखण्डी च महारथ: |\n" + "धृष्टद्युम्नो विराटश्च सात्यकिश्चापराजित: || 17||\n" + "द्रुपदो द्रौपदेयाश्च सर्वश: पृथिवीपते |\n" + "सौभद्रश्च महाबाहु: शङ्खान्दध्मु: पृथक् पृथक् || 18||"," ananta-vijayam—the conch named Anantavijay; rājā—king; kuntī-putraḥ—son of Kunti; yudhiṣhṭhiraḥ—Yudhishthir; nakulaḥ—Nakul; sahadevaḥ—Sahadev; cha—and; sughoṣha-maṇipuṣhpakau—the conche shells named Sughosh and Manipushpak; kāśhyaḥ—King of Kashi; cha—and; parama-iṣhu-āsaḥ—the excellent archer; śhikhaṇḍī—Shikhandi; cha—also; mahā-rathaḥ—warriors who could single handedly match the strength of ten thousand ordinary warriors; dhṛiṣhṭadyumnaḥ—Dhrishtadyumna; virāṭaḥ—Virat; cha—and; sātyakiḥ—Satyaki; cha—and; aparājitaḥ—invincible; drupadaḥ—Drupad; draupadeyāḥ—the five sons of Draupadi; cha—and; sarvaśhaḥ—all; pṛithivī-pate—Ruler of the earth; saubhadraḥ—Abhimanyu, the son of Subhadra; cha—also; mahā-bāhuḥ—the mighty-armed; śhaṅkhān—conch shells; dadhmuḥ—blew; pṛithak pṛithak—individually ","sa ghoṣho dhārtarāṣhṭrāṇāṁ hṛidayāni vyadārayat\n" + "nabhaśhcha pṛithivīṁ chaiva tumulo nunādayan",R.color.trans));
        mData.add(new NewsItem("\n" + "\n" + "स घोषो धार्तराष्ट्राणां हृदयानि व्यदारयत् |\n" + "नभश्च पृथिवीं चैव तुमुलो नुनादयन् || 19||\n"," saḥ—that; ghoṣhaḥ—sound; dhārtarāṣhṭrāṇām—of Dhritarashtra’s sons; hṛidayāni—hearts; vyadārayat—shattered; nabhaḥ—the sky; cha—and; pṛithivīm—the earth; cha—and; eva—certainly; tumulaḥ—terrific sound; abhyanunādayan—thundering ","atha vyavasthitān dṛiṣhṭvā dhārtarāṣhṭrān kapi-dhwajaḥ\n" + "pravṛitte śhastra-sampāte dhanurudyamya pāṇḍavaḥ\n" + "hṛiṣhīkeśhaṁ tadā vākyam idam āha mahī-pate",R.color.trans));
        mData.add(new NewsItem("अथ व्यवस्थितान्दृष्ट्वा धार्तराष्ट्रान् कपिध्वज: |\n" + "प्रवृत्ते शस्त्रसम्पाते धनुरुद्यम्य पाण्डव: |\n" + "हृषीकेशं तदा वाक्यमिदमाह महीपते ||20||"," atha—thereupon; vyavasthitān—arrayed; dṛiṣhṭvā—seeing; dhārtarāṣhṭrān—Dhritarashtra’s sons; kapi-dwajaḥ—the Monkey Bannered; pravṛitte—about to commence; śhastra-sampāte—to use the weapons; dhanuḥ—bow; udyamya—taking up; pāṇḍavaḥ—Arjun, the son of Pandu; hṛiṣhīkeśham—to Shree Krishna; tadā—at that time; vākyam—words; idam—these; āha—said; mahī-pate—King ","senayor ubhayor madhye rathaṁ sthāpaya me ’chyuta\n" + "yāvadetān nirīkṣhe ’haṁ yoddhu-kāmān avasthitān\n" + "kairmayā saha yoddhavyam asmin raṇa-samudyame",R.color.trans));
        mData.add(new NewsItem("अर्जुन उवाच |\n" + "सेनयोरुभयोर्मध्ये रथं स्थापय मेऽच्युत || 21||\n" + "यावदेतान्निरीक्षेऽहं योद्धुकामानवस्थितान् |\n" + "कैर्मया सह योद्धव्यमस्मिन् रणसमुद्यमे || 22||"," arjunaḥ uvācha—Arjun said; senayoḥ—armies; ubhayoḥ—both; madhye—in the middle; ratham—chariot; sthāpaya—place; me—my; achyuta—Shree Krishna, the infallible One; yāvat—as many as; etān—these; nirīkṣhe—look; aham—I; yoddhu-kāmān—for the battle; avasthitān—arrayed; kaiḥ—with whom; mayā—by me; saha—together; yoddhavyam—must fight; asmin—in this; raṇa-samudyame—great combat ","yotsyamānān avekṣhe ’haṁ ya ete ’tra samāgatāḥ\n" + "dhārtarāṣhṭrasya durbuddher yuddhe priya-chikīrṣhavaḥ",R.color.trans));
        mData.add(new NewsItem("सञ्जय उवाच |\n" + "एवमुक्तो हृषीकेशो गुडाकेशेन भारत |\n" + "सेनयोरुभयोर्मध्ये स्थापयित्वा रथोत्तमम् || 24||"," sañjayaḥ uvācha—Sanjay said; evam—thus; uktaḥ—addressed; hṛiṣhīkeśhaḥ—Shree Krishna, the Lord of the senses; guḍākeśhena—by Arjun, the conqueror of sleep; bhārata—descendant of Bharat; senayoḥ—armies; ubhayoḥ—the two; madhye—between; sthāpayitvā—having drawn; ratha-uttamam—magnificent chariot ","\n" + "\n" + "sañjaya uvācha\n" + "evam ukto hṛiṣhīkeśho guḍākeśhena bhārata\n" + "senayor ubhayor madhye sthāpayitvā rathottamam\n",R.color.trans));
        mData.add(new NewsItem("भीष्मद्रोणप्रमुखत: सर्वेषां च महीक्षिताम् |\n" + "उवाच पार्थ पश्यैतान्समवेतान्कुरूनिति || 25||"," bhīṣhma—Grandsire Bheeshma; droṇa—Dronacharya; pramukhataḥ—in the presence; sarveṣhām—all; cha—and; mahī-kṣhitām—other kings; uvācha—said; pārtha—Arjun, the son of Pritha; paśhya—behold; etān—these; samavetān—gathered; kurūn—descendants of Kuru; iti—thus ","bhīṣhma-droṇa-pramukhataḥ sarveṣhāṁ cha mahī-kṣhitām\n" + "uvācha pārtha paśhyaitān samavetān kurūn iti",R.color.trans));
        mData.add(new NewsItem("तत्रापश्यत्स्थितान् पार्थ: पितृ नथ पितामहान् |\n" + "आचार्यान्मातुलान्भ्रातृ न्पुत्रान्पौत्रान्सखींस्तथा |\n" + "श्वशुरान्सुहृदश्चैव सेनयोरुभयोरपि || 26||"," tatra—there; apaśhyat—saw; sthitān—stationed; pārthaḥ—Arjun; pitṝīn—fathers; atha—thereafter; pitāmahān—grandfathers; āchāryān—teachers; mātulān—maternal uncles; bhrātṝīn—brothers; putrān—sons; pautrān—grandsons; sakhīn—friends; tathā—also; śhvaśhurān—fathers-in-law; suhṛidaḥ—well-wishers; cha—and; eva—indeed; senayoḥ—armies; ubhayoḥ—in both armies; api—also ","tatrāpaśhyat sthitān pārthaḥ pitṝīn atha pitāmahān\n" + "āchāryān mātulān bhrātṝīn putrān pautrān sakhīṁs tathā\n" + "śhvaśhurān suhṛidaśh chaiva senayor ubhayor api",R.color.trans));
        mData.add(new NewsItem("तान्समीक्ष्य स कौन्तेय: सर्वान्बन्धूनवस्थितान् |\n" + "कृपया परयाविष्टो विषीदन्निदमब्रवीत् || 27||"," tān—these; samīkṣhya—on seeing; saḥ—they; kaunteyaḥ—Arjun, the son of Kunti; sarvān—all; bandhūn—relatives; avasthitān—present; kṛipayā—by compassion; parayā—great; āviṣhṭaḥ—overwhelmed; viṣhīdan—deep sorrow; idam—this; abravīt—spoke ","tān samīkṣhya sa kaunteyaḥ sarvān bandhūn avasthitān\n" + "kṛipayā parayāviṣhṭo viṣhīdann idam abravīt",R.color.trans));
        mData.add(new NewsItem("अर्जुन उवाच |\n" + "दृष्ट्वेमं स्वजनं कृष्ण युयुत्सुं समुपस्थितम् |\n" + "सीदन्ति मम गात्राणि मुखं च परिशुष्यति || 28||"," arjunaḥ uvācha—Arjun said; dṛiṣhṭvā—on seeing; imam—these; sva-janam—kinsmen; kṛiṣhṇa—Krishna; yuyutsum—eager to fight; samupasthitam—present; sīdanti—quivering; mama—my; gātrāṇi—limbs; mukham—mouth; cha—and; pariśhuṣhyati—is drying up ","arjuna uvācha\n" + "dṛiṣhṭvemaṁ sva-janaṁ kṛiṣhṇa yuyutsuṁ samupasthitam\n" + "sīdanti mama gātrāṇi mukhaṁ cha pariśhuṣhyati",R.color.trans));
        mData.add(new NewsItem("वेपथुश्च शरीरे मे रोमहर्षश्च जायते || 29||\n" + "गाण्डीवं स्रंसते हस्तात्वक्चै व परिदह्यते |\n" + "न च शक्नोम्यवस्थातुं भ्रमतीव च मे मन: || 30||\n" + "निमित्तानि च पश्यामि विपरीतानि केशव |\n" + "न च श्रेयोऽनुपश्यामि हत्वा स्वजनमाहवे || 31||"," vepathuḥ—shuddering; cha—and; śharīre—on the body; me—my; roma-harṣhaḥ—standing of bodily hair on end; cha—also; jāyate—is happening; gāṇḍīvam—Arjun’s bow; sraṁsate—is slipping; hastāt—from (my) hand; tvak—skin; cha—and; eva—indeed; paridahyate—is burning all over; na—not; cha—and; śhaknomi—am able; avasthātum—remain steady; bhramati iva—whirling like; cha—and; me—my; manaḥ—mind; nimittāni—omens; cha—and; paśhyāmi—I see; viparītāni—misfortune; keśhava—Shree Krishna, killer of the Keshi demon; na—not; cha—also; śhreyaḥ—good; anupaśhyāmi—I foresee; hatvā—from killing; sva-janam—kinsmen; āhave—in battle ","vepathuśh cha śharīre me roma-harṣhaśh cha jāyate\n" + "gāṇḍīvaṁ sraṁsate hastāt tvak chaiva paridahyate\n" + "na cha śhaknomy avasthātuṁ bhramatīva cha me manaḥ\n" + "nimittāni cha paśhyāmi viparītāni keśhava\n" + "na cha śhreyo ’nupaśhyāmi hatvā sva-janam āhave",R.color.trans));
        mData.add(new NewsItem("न काङ्क्षे विजयं कृष्ण न च राज्यं सुखानि च |\n" + "किं नो राज्येन गोविन्द किं भोगैर्जीवितेन वा || 32||\n" + "येषामर्थे काङ्क्षितं नो राज्यं भोगा: सुखानि च |\n" + "त इमेऽवस्थिता युद्धे प्राणांस्त्यक्त्वा धनानि च || 33||"," na—nor; kāṅkṣhe—do I desire; vijayam—victory; kṛiṣhṇa—Krishna; na—nor; cha—as well; rājyam—kingdom; sukhāni—happiness; cha—also; kim—what; naḥ—to us; rājyena—by kingdom; govinda—Krishna, he who gives pleasure to the senses, he who is fond of cows; kim—what?; bhogaiḥ—pleasures; jīvitena—life; vā—or; yeṣhām—for whose; arthe—sake; kāṅkṣhitam—coveted for; naḥ—by us; rājyam—kingdom; bhogāḥ—pleasures; sukhāni—happiness; cha—also; te—they; ime—these; avasthitāḥ—situated; yuddhe—for battle; prāṇān—lives; tyaktvā—giving up; dhanāni—wealth; cha—also ","na kāṅkṣhe vijayaṁ kṛiṣhṇa na cha rājyaṁ sukhāni cha\n" + "kiṁ no rājyena govinda kiṁ bhogair jīvitena vā\n" + "yeṣhām arthe kāṅkṣhitaṁ no rājyaṁ bhogāḥ sukhāni cha\n" + "ta ime ’vasthitā yuddhe prāṇāṁs tyaktvā dhanāni cha",R.color.trans));
        mData.add(new NewsItem("आचार्या: पितर: पुत्रास्तथैव च पितामहा: |\n" + "मातुला: श्वशुरा: पौत्रा: श्याला: सम्बन्धिनस्तथा || 34||\n" + "एतान्न हन्तुमिच्छामि घ्नतोऽपि मधुसूदन |\n" + "अपि त्रैलोक्यराज्यस्य हेतो: किं नु महीकृते || 35||"," āchāryāḥ—teachers; pitaraḥ—fathers; putrāḥ—sons; tathā—as well; eva—indeed; cha—also; pitāmahāḥ—grandfathers; mātulāḥ—maternal uncles; śhvaśhurāḥ—fathers-in-law; pautrāḥ—grandsons; śhyālāḥ—brothers-in-law; sambandhinaḥ—kinsmen; tathā—as well; etān—these; na—not; hantum—to slay; ichchhāmi—I wish; ghnataḥ—killed; api—even though; madhusūdana—Shree Krishna, killer of the demon Madhu; api—even though; trai-lokya-rājyasya—dominion over three worlds; hetoḥ—for the sake of; kim nu—what to speak of; mahī-kṛite—for the earth ","\n" + "\n" + "āchāryāḥ pitaraḥ putrās tathaiva cha pitāmahāḥ\n" + "mātulāḥ śhvaśhurāḥ pautrāḥ śhyālāḥ sambandhinas tathā\n" + "\n" + "etān na hantum ichchhāmi ghnato ’pi madhusūdana\n" + "api trailokya-rājyasya hetoḥ kiṁ nu mahī-kṛite\n",R.color.trans));
        mData.add(new NewsItem("निहत्य धार्तराष्ट्रान्न: का प्रीति: स्याज्जनार्दन |\n" + "पापमेवाश्रयेदस्मान्हत्वैतानाततायिन: || 36 ||\n" + "तस्मान्नार्हा वयं हन्तुं धार्तराष्ट्रान्स्वबान्धवान् |\n" + "स्वजनं हि कथं हत्वा सुखिन: स्याम माधव || 37||"," nihatya—by killing; dhārtarāṣhṭrān—the sons of Dhritarashtra; naḥ—our; kā—what; prītiḥ—pleasure; syāt—will there be; janārdana—he who looks after the public, Shree Krishna; pāpam—vices; eva—certainly; āśhrayet—must come upon; asmān—us; hatvā—by killing; etān—all these; ātatāyinaḥ—aggressors; tasmāt—hence; na—never; arhāḥ—behoove; vayam—we; hantum—to kill; dhārtarāṣhṭrān—the sons of Dhritarashtra; sva-bāndhavān—along with friends; sva-janam—kinsmen; hi—certainly; katham—how; hatvā—by killing; sukhinaḥ—happy; syāma—will we become; mādhava—Shree Krishna, the husband of Yogmaya ","nihatya dhārtarāṣhṭrān naḥ kā prītiḥ syāj janārdana\n" + "pāpam evāśhrayed asmān hatvaitān ātatāyinaḥ\n" + "tasmān nārhā vayaṁ hantuṁ dhārtarāṣhṭrān sa-bāndhavān\n" + "sva-janaṁ hi kathaṁ hatvā sukhinaḥ syāma mādhava",R.color.trans));
        mData.add(new NewsItem("यद्यप्येते न पश्यन्ति लोभोपहतचेतस: |\n" + "कुलक्षयकृतं दोषं मित्रद्रोहे च पातकम् || 38||\n" + "कथं न ज्ञेयमस्माभि: पापादस्मान्निवर्तितुम् |\n" + "कुलक्षयकृतं दोषं प्रपश्यद्भिर्जनार्दन || 39||"," yadi api—even though; ete—they; na—not; paśhyanti—see; lobha—greed; upahata—overpowered; chetasaḥ—thoughts; kula-kṣhaya-kṛitam—in annihilating their relatives; doṣham—fault; mitra-drohe—to wreak treachery upon friends; cha—and; pātakam—sin; katham—why; na—not; jñeyam—should be known; asmābhiḥ—we; pāpāt—from sin; asmāt—these; nivartitum—to turn away; kula-kṣhaya—killing the kindered; kṛitam—done; doṣham—crime; prapaśhyadbhiḥ—who can see; janārdana—he who looks after the public, Shree Krishna ","yady apy ete na paśhyanti lobhopahata-chetasaḥ\n" + "kula-kṣhaya-kṛitaṁ doṣhaṁ mitra-drohe cha pātakam\n" + "kathaṁ na jñeyam asmābhiḥ pāpād asmān nivartitum\n" + "kula-kṣhaya-kṛitaṁ doṣhaṁ prapaśhyadbhir janārdana",R.color.trans));
        mData.add(new NewsItem("कुलक्षये प्रणश्यन्ति कुलधर्मा: सनातना: |\n" + "धर्मे नष्टे कुलं कृत्स्नमधर्मोऽभिभवत्युत || 40||"," kula-kṣhaye—in the destruction of a dynasty; praṇaśhyanti—are vanquished; kula-dharmāḥ—family traditions; sanātanāḥ—eternal; dharme—religion; naṣhṭe—is destroyed; kulam—family; kṛitsnam—the whole; adharmaḥ—irreligion; abhibhavati—overcome; uta—indeed ","kula-kṣhaye praṇaśhyanti kula-dharmāḥ sanātanāḥ\n" + "dharme naṣhṭe kulaṁ kṛitsnam adharmo ’bhibhavaty uta",R.color.trans));
        mData.add(new NewsItem("अधर्माभिभवात्कृष्ण प्रदुष्यन्ति कुलस्त्रिय: |\n" + "स्त्रीषु दुष्टासु वार्ष्णेय जायते वर्णसङ्कर: || 41||"," adharma—irreligion; abhibhavāt—preponderance; kṛiṣhṇa—Shree Krishna; praduṣhyanti—become immoral; kula-striyaḥ—women of the family; strīṣhu—of women; duṣhṭāsu—become immoral; vārṣhṇeya—descendant of Vrishni; jāyate—are born; varṇa-saṅkaraḥ—unwanted progeny ","adharmābhibhavāt kṛiṣhṇa praduṣhyanti kula-striyaḥ\n" + "strīṣhu duṣhṭāsu vārṣhṇeya jāyate varṇa-saṅkaraḥ",R.color.trans));
        mData.add(new NewsItem("सङ्करो नरकायैव कुलघ्नानां कुलस्य च |\n" + "पतन्ति पितरो ह्येषां लुप्तपिण्डोदकक्रिया: || 42||"," saṅkaraḥ—unwanted children; narakāya—hellish; eva—indeed; kula-ghnānām—for those who destroy the family; kulasya—of the family; cha—also; patanti—fall; pitaraḥ—ancestors; hi—verily; eṣhām—their; lupta—deprived of; piṇḍodaka-kriyāḥ—performances of sacrificial offerings ","saṅkaro narakāyaiva kula-ghnānāṁ kulasya cha\n" + "patanti pitaro hy eṣhāṁ lupta-piṇḍodaka-kriyāḥ",R.color.trans));
        mData.add(new NewsItem("दोषैरेतै: कुलघ्नानां वर्णसङ्करकारकै: |\n" + "उत्साद्यन्ते जातिधर्मा: कुलधर्माश्च शाश्वता: || 43||"," doṣhaiḥ—through evil deeds; etaiḥ—these; kula-ghnānām—of those who destroy the family; varṇa-saṅkara—unwanted progeny; kārakaiḥ—causing; utsādyante—are ruined; jāti-dharmāḥ—social and family welfare activities; kula-dharmāḥ—family traditions; cha—and; śhāśhvatāḥ—eternal ","doṣhair etaiḥ kula-ghnānāṁ varṇa-saṅkara-kārakaiḥ\n" + "utsādyante jāti-dharmāḥ kula-dharmāśh cha śhāśhvatāḥ",R.color.trans));
        mData.add(new NewsItem("उत्सन्नकुलधर्माणां मनुष्याणां जनार्दन |\n" + "नरकेऽनियतं वासो भवतीत्यनुशुश्रुम || 44||"," utsanna—destroyed; kula-dharmāṇām—whose family traditions; manuṣhyāṇām—of such human beings; janārdana—he who looks after the public, Shree Krishna; narake—in hell; aniyatam—indefinite; vāsaḥ—dwell; bhavati—is; iti—thus; anuśhuśhruma—I have heard from the learned ","utsanna-kula-dharmāṇāṁ manuṣhyāṇāṁ janārdana\n" + "narake ‘niyataṁ vāso bhavatītyanuśhuśhruma",R.color.trans));
        mData.add(new NewsItem("अहो बत महत्पापं कर्तुं व्यवसिता वयम् |\n" + "यद्राज्यसुखलोभेन हन्तुं स्वजनमुद्यता: || 45||\n" + "यदि मामप्रतीकारमशस्त्रं शस्त्रपाणय: |\n" + "धार्तराष्ट्रा रणे हन्युस्तन्मे क्षेमतरं भवेत् || 46||"," aho—alas; bata—horrible results; mahat—great; pāpam—sins; kartum—to perform; vyavasitāḥ—have decided; vayam—we; yat—because; rājya-sukha-lobhena—driven by the desire for kingly pleasure; hantum—to kill; sva-janam—kinsmen; udyatāḥ—intending; yadi—if; mām—me; apratīkāram—unresisting; aśhastram—unarmed; śhastra-pāṇayaḥ—those with weapons in hand; dhārtarāṣhṭrāḥ—the sons of Dhritarashtra; raṇe—on the battlefield; hanyuḥ—shall kill; tat—that; me—to me; kṣhema-taram—better; bhavet—would be ","aho bata mahat pāpaṁ kartuṁ vyavasitā vayam\n" + "yad rājya-sukha-lobhena hantuṁ sva-janam udyatāḥ\n" + "yadi mām apratīkāram aśhastraṁ śhastra-pāṇayaḥ\n" + "dhārtarāṣhṭrā raṇe hanyus tan me kṣhemataraṁ bhavet",R.color.trans));
        mData.add(new NewsItem("सञ्जय उवाच |\n" + "एवमुक्त्वार्जुन: सङ्ख्ये रथोपस्थ उपाविशत् |\n" + "विसृज्य सशरं चापं शोकसंविग्नमानस: || 47||"," sañjayaḥ uvācha—Sanjay said; evam uktvā—speaking thus; arjunaḥ—Arjun; saṅkhye—in the battlefield; ratha upasthe—on the chariot; upāviśhat—sat; visṛijya—casting aside; sa-śharam—along with arrows; chāpam—the bow; śhoka—with grief; saṁvigna—distressed; mānasaḥ—mind ","sañjaya uvācha\n" + "evam uktvārjunaḥ saṅkhye rathopastha upāviśhat\n" + "visṛijya sa-śharaṁ chāpaṁ śhoka-saṁvigna-mānasaḥ",R.color.trans));



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
            // super.onBackPressed();

            new FancyGifDialog.Builder(this)
                    .setTitle("Are you sure you want to exit?")
                    .setMessage("Great is the art of beginning, but greater is the art of ending.")
                    .setNegativeBtnText("No")
                    .setPositiveBtnBackground("#1ec1f2")
                    .setPositiveBtnText("Yes")
                    .setNegativeBtnBackground("#D60621")
                    .setGifResource(R.drawable.exit_sign_gif)
                    .isCancellable(true)
                    .OnPositiveClicked(new FancyGifDialogListener() {
                        @Override
                        public void OnClick() {
                            Intent intent = new Intent(Main2Activity.this, CloseActivity.class);
                            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                            startActivity(intent);
                        }
                    })
                    .OnNegativeClicked(new FancyGifDialogListener() {
                        @Override
                        public void OnClick() {
                        }
                    })
                    .build(); }
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

        //    Intent myIntent = new Intent(this, Main2Activity.class);
         //   this.startActivity(myIntent);

        }

        if (id == R.id.explain){

            //   Intent myIntent = new Intent(this, Explaination.class);
            //   this.startActivity(myIntent);

            new FancyGifDialog.Builder(Main2Activity.this)
                    .setTitle("REMEMBER THIS ALWAYS!")
                    .setMessage("\uD83D\uDCA5️ This is just a side note but a very important one:\n\uD83D\uDC49️ This translation of gita is by Swami Mukundananda & i choose to use this translation because it's one of the best and easy to understand english translation available.But it is one of the many translations available on this planet. Everyone interprets gita from there own school of thought and so when one switch from Dwaita to Adwaita philosophy the whole meaning flips upside down.\n\uD83D\uDE4F️ So it's my humble request to read different interpretations for a much clearer view!")
                    .setNegativeBtnText("Ofcourse!")
                    //  .setPositiveBtnBackground("#1ec1f2")
                    //  .setPositiveBtnText("Yes")
                    .setNegativeBtnBackground("#D60621")
                    .setGifResource(R.drawable.explain)
                    .isCancellable(true)
                    // .OnPositiveClicked(new FancyGifDialogListener() {
                    //     @Override
                    //    public void OnClick() {
                    //        Intent intent = new Intent(Aboutus.this, CloseActivity.class);
                    //        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                    //       startActivity(intent);                      }
                    //  })
                    .OnNegativeClicked(new FancyGifDialogListener() {
                        @Override
                        public void OnClick() {
                        }
                    })
                    .build();

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