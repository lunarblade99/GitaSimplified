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

import java.util.ArrayList;
import java.util.List;

public class Vchp10 extends AppCompatActivity
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
        navigationView.getMenu().getItem(9).setChecked(true);

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
        mData.add(new NewsItem("श्रीभगवानुवाच |\n" + "भूय एव महाबाहो शृणु मे परमं वच: |\n" + "यत्तेऽहं प्रीयमाणाय वक्ष्यामि हितकाम्यया || 1||"," śhrī-bhagavān uvācha—the Blessed Lord said; bhūyaḥ—again; eva—verily; mahā-bāho—mighty armed one; śhṛiṇu—hear; me—my; paramam—divine; vachaḥ—teachings; yat—which; te—to you; aham—I; prīyamāṇāya—you are my beloved confidant; vakṣhyāmi—say; hita-kāmyayā—for desiring your welfare ","śhrī bhagavān uvācha\n" + "bhūya eva mahā-bāho śhṛiṇu me paramaṁ vachaḥ\n" + "yatte ’haṁ prīyamāṇāya vakṣhyāmi hita-kāmyayā",R.color.trans));
        mData.add(new NewsItem("न मे विदु: सुरगणा: प्रभवं न महर्षय: |\n" + "अहमादिर्हि देवानां महर्षीणां च सर्वश: || 2||"," na—neither; me—my; viduḥ—know; sura-gaṇāḥ—the celestial gods; prabhavam—origin; na—nor; mahā-ṛiṣhayaḥ—the great sages; aham—I; ādiḥ—the source; hi—certainly; devānām—of the celestial gods; mahā-ṛiṣhīṇām—of the great seers; cha—also; sarvaśhaḥ—in every way ","na me viduḥ sura-gaṇāḥ prabhavaṁ na maharṣhayaḥ\n" + "aham ādir hi devānāṁ maharṣhīṇāṁ cha sarvaśhaḥ",R.color.trans));
        mData.add(new NewsItem("यो मामजमनादिं च वेत्ति लोकमहेश्वरम् |\n" + "असम्मूढ: स मर्त्येषु सर्वपापै: प्रमुच्यते || 3||"," yaḥ—who; mām—me; ajam—unborn; anādim—beginningless; cha—and; vetti—know; loka—of the universe; mahā-īśhvaram—the Supreme Lord; asammūḍhaḥ—undeluded; saḥ—they; martyeṣhu—among mortals; sarva-pāpaiḥ—from all evils; pramuchyate—are freed from ","yo māmajam anādiṁ cha vetti loka-maheśhvaram\n" + "asammūḍhaḥ sa martyeṣhu sarva-pāpaiḥ pramuchyate",R.color.trans));
        mData.add(new NewsItem("बुद्धिर्ज्ञानमसम्मोह: क्षमा सत्यं दम: शम: |\n" + "सुखं दु:खं भवोऽभावो भयं चाभयमेव च || 4||\n" + "अहिंसा समता तुष्टिस्तपो दानं यशोऽयश: |\n" + "भवन्ति भावा भूतानां मत्त एव पृथग्विधा: || 5||"," buddhiḥ—intellect; jñānam—knowledge; asammohaḥ—clarity of thought; kṣhamā—forgiveness; satyam—truthfulness; damaḥ—control over the senses; śhamaḥ—control of the mind; sukham—joy; duḥkham—sorrow; bhavaḥ—birth; abhāvaḥ—death; bhayam—fear; cha—and; abhayam—courage; eva—certainly; cha—and; ahinsā—nonviolence; samatā—equanimity; tuṣhṭiḥ—contentment; tapaḥ—austerity; dānam—charity; yaśhaḥ—fame; ayaśhaḥ—infamy; bhavanti—arise; bhāvāḥ—qualities; bhūtānām—amongst humans; mattaḥ—from me; eva—alone; pṛithak-vidhāḥ—varieties of ","buddhir jñānam asammohaḥ kṣhamā satyaṁ damaḥ śhamaḥ\n" + "sukhaṁ duḥkhaṁ bhavo ’bhāvo bhayaṁ chābhayameva cha\n" + "ahinsā samatā tuṣhṭis tapo dānaṁ yaśho ’yaśhaḥ\n" + "bhavanti bhāvā bhūtānāṁ matta eva pṛithag-vidhāḥ",R.color.trans));
        mData.add(new NewsItem("महर्षय: सप्त पूर्वे चत्वारो मनवस्तथा |\n" + "मद्भावा मानसा जाता येषां लोक इमा: प्रजा: || 6||"," mahā-ṛiṣhayaḥ—the great Sages; sapta—seven; pūrve—before; chatvāraḥ—four; manavaḥ—Manus; tathā—also; mat bhāvāḥ—are born from me; mānasāḥ—mind; jātāḥ—born; yeṣhām—from them; loke—in the world; imāḥ—all these; prajāḥ—people ","maharṣhayaḥ sapta pūrve chatvāro manavas tathā\n" + "mad-bhāvā mānasā jātā yeṣhāṁ loka imāḥ prajāḥ",R.color.trans));
        mData.add(new NewsItem("एतां विभूतिं योगं च मम यो वेत्ति तत्वत: |\n" + "सोऽविकम्पेन योगेन युज्यते नात्र संशय: || 7||"," etām—these; vibhūtim—glories; yogam—divine powers; cha—and; mama—my; yaḥ—those who; vetti—know; tattvataḥ—in truth; saḥ—they; avikalpena—unwavering; yogena—in bhakti yog; yujyate—becomes united; na—never; atra—here; sanśhayaḥ—doubt ","etāṁ vibhūtiṁ yogaṁ cha mama yo vetti tattvataḥ\n" + "so ’vikampena yogena yujyate nātra sanśhayaḥ",R.color.trans));
        mData.add(new NewsItem("अहं सर्वस्य प्रभवो मत्त: सर्वं प्रवर्तते |\n" + "इति मत्वा भजन्ते मां बुधा भावसमन्विता: || 8||"," aham—I; sarvasya—of all creation; prabhavaḥ—the origin of; mattaḥ—from me; sarvam—everything; pravartate—proceeds; iti—thus; matvā—having known; bhajante—worship; mām—me; budhāḥ—the wise; bhāva-samanvitāḥ—endowed with great faith and devotion ","ahaṁ sarvasya prabhavo mattaḥ sarvaṁ pravartate\n" + "iti matvā bhajante māṁ budhā bhāva-samanvitāḥ",R.color.trans));
        mData.add(new NewsItem("मच्चित्ता मद्गतप्राणा बोधयन्त: परस्परम् |\n" + "कथयन्तश्च मां नित्यं तुष्यन्ति च रमन्ति च || 9||"," mat-chittāḥ—those with minds fixed on me; mat-gata-prāṇāḥ—those who have surrendered their lives to me; bodhayantaḥ—enlightening (with divine knowledge of God); parasparam—one another; kathayantaḥ—speaking; cha—and; mām—about me; nityam—continously; tuṣhyanti—satisfaction; cha—and; ramanti—(they) delight; cha—also ","mach-chittā mad-gata-prāṇā bodhayantaḥ parasparam\n" + "kathayantaśh cha māṁ nityaṁ tuṣhyanti cha ramanti cha",R.color.trans));
        mData.add(new NewsItem("तेषां सततयुक्तानां भजतां प्रीतिपूर्वकम् |\n" + "ददामि बुद्धियोगं तं येन मामुपयान्ति ते || 10||"," teṣhām—to them; satata-yuktānām—ever steadfast; bhajatām—who engage in devotion; prīti-pūrvakam—with love; dadāmi—I give; buddhi-yogam—divine knowledge; tam—that; yena—by which; mām—to me; upayānti—come; te—they ","teṣhāṁ satata-yuktānāṁ bhajatāṁ prīti-pūrvakam\n" + "dadāmi buddhi-yogaṁ taṁ yena mām upayānti te",R.color.trans));
        mData.add(new NewsItem("तेषामेवानुकम्पार्थमहमज्ञानजं तम: |\n" + "नाशयाम्यात्मभावस्थो ज्ञानदीपेन भास्वता || 11||"," teṣhām—for them; eva—only; anukampā-artham—out of compassion; aham—I; ajñāna-jam—born of ignorance; tamaḥ—darkness; nāśhayāmi—destroy; ātma-bhāva—within their hearts; sthaḥ—dwelling; jñāna—of knowledge; dīpena—with the lamp; bhāsvatā—luminous ","teṣhām evānukampārtham aham ajñāna-jaṁ tamaḥ\n" + "nāśhayāmyātma-bhāva-stho jñāna-dīpena bhāsvatā",R.color.trans));
        mData.add(new NewsItem("अर्जुन उवाच |\n" + "परं ब्रह्म परं धाम पवित्रं परमं भवान् |\n" + "पुरुषं शाश्वतं दिव्यमादिदेवमजं विभुम् || 12||\n" + "आहुस्त्वामृषय: सर्वे देवर्षिर्नारदस्तथा |\n" + "असितो देवलो व्यास: स्वयं चैव ब्रवीषि मे || 13||"," arjunaḥ uvācha—Arjun said; param—Supreme; brahma—Brahman; param—Supreme; dhāma—Abode; pavitram—purifier; paramam—Supreme; bhavān—you; puruṣham—personality; śhāśhvatam—Eternal; divyam—Divine; ādi-devam—the Primal Being; ajam—the Unborn; vibhum—the Great; āhuḥ—(they) declare; tvām—you; ṛiṣhayaḥ—sages; sarve—all; deva-ṛiṣhiḥ-nāradaḥ—devarṣhi Narad; tathā—also; asitaḥ—Asit; devalaḥ—Deval; vyāsaḥ—Vyās; svayam—personally; cha—and; eva—even; bravīṣhī—you are declaring; me—to me ","arjuna uvācha\n" + "paraṁ brahma paraṁ dhāma pavitraṁ paramaṁ bhavān\n" + "puruṣhaṁ śhāśhvataṁ divyam ādi-devam ajaṁ vibhum\n" + "āhus tvām ṛiṣhayaḥ sarve devarṣhir nāradas tathā\n" + "asito devalo vyāsaḥ svayaṁ chaiva bravīṣhi me",R.color.trans));
        mData.add(new NewsItem("सर्वमेतदृतं मन्ये यन्मां वदसि केशव |\n" + "न हि ते भगवन्व्यक्तिं विदुर्देवा न दानवा: || 14||"," sarvam—everything; etat—this; ṛitam—truth; manye—I accept; yat—which; mām—me; vadasi—you tell; keśhava—Shree Krishna, the killer of the demon named Keshi; na—neither; hi—verily; te—your; bhagavan—the Supreme Lord; vyaktim—personality; viduḥ—can understand; devāḥ—the celestial gods; na—nor; dānavāḥ—the demons ","sarvam etad ṛitaṁ manye yan māṁ vadasi keśhava\n" + "na hi te bhagavan vyaktiṁ vidur devā na dānavāḥ",R.color.trans));
        mData.add(new NewsItem("स्वयमेवात्मनात्मानं वेत्थ त्वं पुरुषोत्तम |\n" + "भूतभावन भूतेश देवदेव जगत्पते || 15||"," swayam—yourself; eva—indeed; ātmanā—by yourself; ātmānam—yourself; vettha—know; tvam—you; puruṣha-uttama—the Supreme Personality; bhūta-bhāvana—the Creator of all beings; bhūta-īśha—the Lord of everything; deva-deva—the God of gods; jagat-pate—the Lord of the universe ","swayam evātmanātmānaṁ vettha tvaṁ puruṣhottama\n" + "bhūta-bhāvana bhūteśha deva-deva jagat-pate",R.color.trans));
        mData.add(new NewsItem("वक्तुमर्हस्यशेषेण दिव्या ह्यात्मविभूतय: |\n" + "याभिर्विभूतिभिर्लोकानिमांस्त्वं व्याप्य तिष्ठसि || 16||\n" + "कथं विद्यामहं योगिंस्त्वां सदा परिचिन्तयन् |\n" + "केषु केषु च भावेषु चिन्त्योऽसि भगवन्मया || 17||"," vaktum—to describe; arhasi—please do; aśheṣheṇa—completely; divyāḥ—divine; hi—indeed; ātma—your own; vibhūtayaḥ—opulences; yābhiḥ—by which; vibhūtibhiḥ—opulences; lokān—all worlds; imān—these; tvam—you; vyāpya—pervade; tiṣhṭhasi—reside; katham—how; vidyām aham—shall I know; yogin—the Supreme Master of Yogmaya; tvām—you; sadā—always; parichintayan—meditating; keṣhu—in what; keṣhu—in what; cha—and; bhāveṣhu—forms; chintyaḥ asi—to be thought of; bhagavan—the Supreme Divine Personality; mayā—by me ","vaktum arhasyaśheṣheṇa divyā hyātma-vibhūtayaḥ\n" + "yābhir vibhūtibhir lokān imāṁs tvaṁ vyāpya tiṣhṭhasi\n" + "kathaṁ vidyām ahaṁ yogins tvāṁ sadā parichintayan\n" + "keṣhu keṣhu cha bhāveṣhu chintyo ’si bhagavan mayā",R.color.trans));
        mData.add(new NewsItem("विस्तरेणात्मनो योगं विभूतिं च जनार्दन |\n" + "भूय: कथय तृप्तिर्हि शृण्वतो नास्ति मेऽमृतम् || 18||"," vistareṇa—in detail; ātmanaḥ—your; yogam—divine glories; vibhūtim—opulences; cha—also; janaārdana—Shree Krishna, he who looks after the public; bhūyaḥ—again; kathaya—describe; tṛiptiḥ—satisfaction; hi—because; śhṛiṇvataḥ—hearing; na—not; asti—is; me—my; amṛitam—nectar ","vistareṇātmano yogaṁ vibhūtiṁ cha janārdana\n" + "bhūyaḥ kathaya tṛiptir hi śhṛiṇvato nāsti me ’mṛitam",R.color.trans));
        mData.add(new NewsItem("श्रीभगवानुवाच |\n" + "हन्त ते कथयिष्यामि दिव्या ह्यात्मविभूतय: |\n" + "प्राधान्यत: कुरुश्रेष्ठ नास्त्यन्तो विस्तरस्य मे ||19||"," śhrī-bhagavān uvācha—the Blessed Lord spoke; hanta—yes; te—to you; kathayiṣhyāmi—I shall describe; divyāḥ—divine; hi—certainly; ātma-vibhūtayaḥ—my divine glories; prādhānyataḥ—salient; kuru-śhreṣhṭha—best of the Kurus; na—not; asti—is; antaḥ—limit; vistarasya—extensive glories; me—my ","śhrī bhagavān uvācha\n" + "hanta te kathayiṣhyāmi divyā hyātma-vibhūtayaḥ\n" + "prādhānyataḥ kuru-śhreṣhṭha nāstyanto vistarasya me",R.color.trans));
        mData.add(new NewsItem("अहमात्मा गुडाकेश सर्वभूताशयस्थित: |\n" + "अहमादिश्च मध्यं च भूतानामन्त एव च || 20||"," aham—I; ātmā—soul; guḍākeśha—Arjun, the conqueror of sleep; sarva-bhūta—of all living entities; āśhaya-sthitaḥ—seated in the heart; aham—I; ādiḥ—the beginning; cha—and; madhyam—middle; cha—and; bhūtānām—of all beings; antaḥ—end; eva—even; cha—also ","aham ātmā guḍākeśha sarva-bhūtāśhaya-sthitaḥ\n" + "aham ādiśh cha madhyaṁ cha bhūtānām anta eva cha",R.color.trans));
        mData.add(new NewsItem("आदित्यानामहं विष्णुर्ज्योतिषां रविरंशुमान् |\n" + "मरीचिर्मरुतामस्मि नक्षत्राणामहं शशी || 21||"," ādityānām—amongst the twelve sons of Aditi; aham—I; viṣhṇuḥ—Lord Vishnu; jyotiṣhām—amongst luminous objects; raviḥ—the sun; anśhu-mān—radiant; marīchiḥ—Marichi; marutām—of the Maruts; asmi—(I) am; nakṣhatrāṇām—amongst the stars; aham—I; śhaśhī—the moon ","ādityānām ahaṁ viṣhṇur jyotiṣhāṁ ravir anśhumān\n" + "marīchir marutām asmi nakṣhatrāṇām ahaṁ śhaśhī",R.color.trans));
        mData.add(new NewsItem("वेदानां सामवेदोऽस्मि देवानामस्मि वासव: |\n" + "इन्द्रियाणां मनश्चास्मि भूतानामस्मि चेतना || 22||"," vedānām—amongst the Vedas; sāma-vedaḥ—the Sāma Veda; asmi—I am; devānām—of all the celestial gods; asmi—I am; vāsavaḥ̣—Indra; indriyāṇām—of amongst the senses; manaḥ—the mind; ca—and; asmi—I am; bhūtānām—amongst the living beings; asmi—I am; chetanā—consciousness ","vedānāṁ sāma-vedo ’smi devānām asmi vāsavaḥ\n" + "indriyāṇāṁ manaśh chāsmi bhūtānām asmi chetanā",R.color.trans));
        mData.add(new NewsItem("रुद्राणां शङ्करश्चास्मि वित्तेशो यक्षरक्षसाम् |\n" + "वसूनां पावकश्चास्मि मेरु: शिखरिणामहम् || 23||"," rudrāṇām—amongst the Rudras; śhaṅkaraḥ—Lord Shiv; cha—and; asmi—I am; vitta-īśhaḥ—the god of wealth and the treasurer of the celestial gods; yakṣha—amongst the semi-divine demons; rakṣhasām—amongst the demons; vasūnām—amongst the Vasus; pāvakaḥ—Agni (fire); cha—and; asmi—I am; meruḥ—Mount Meru; śhikhariṇām—amongst the mountains; aham—I am ","rudrāṇāṁ śhaṅkaraśh chāsmi vitteśho yakṣha-rakṣhasām\n" + "vasūnāṁ pāvakaśh chāsmi meruḥ śhikhariṇām aham",R.color.trans));
        mData.add(new NewsItem("पुरोधसां च मुख्यं मां विद्धि पार्थ बृहस्पतिम् |\n" + "सेनानीनामहं स्कन्द: सरसामस्मि सागर: || 24||"," purodhasām—amongst priests; cha—and; mukhyam—the chiefs; mām—me; viddhi—know; pārtha—Arjun, the son of Pritha; bṛihaspatim—Brihaspati; senānīnām—warrior chief; aham—I; skandaḥ—Kartikeya; sarasām—amongst reservoirs of water; asmi—I am; sāgaraḥ—the ocean ","purodhasāṁ cha mukhyaṁ māṁ viddhi pārtha bṛihaspatim\n" + "senānīnām ahaṁ skandaḥ sarasām asmi sāgaraḥ",R.color.trans));
        mData.add(new NewsItem("महर्षीणां भृगुरहं गिरामस्म्येकमक्षरम् |\n" + "यज्ञानां जपयज्ञोऽस्मि स्थावराणां हिमालय: || 25||"," mahā-ṛiṣhīṇām—among the great seers; bhṛiguḥ—Bhrigu; aham—I; girām—amongst chants; asmi—I am; ekam akṣharam—the syllable Om; yajñānām—of sacrifices; japa-yajñaḥ—sacrifice of the devotional repetition of the divine names of God; asmi—I am; sthāvarāṇām—amongst immovable things; himālayaḥ—the Himalayas ","maharṣhīṇāṁ bhṛigur ahaṁ girām asmyekam akṣharam\n" + "yajñānāṁ japa-yajño ’smi sthāvarāṇāṁ himālayaḥ",R.color.trans));
        mData.add(new NewsItem("अश्वत्थ: सर्ववृक्षाणां देवर्षीणां च नारद: |\n" + "गन्धर्वाणां चित्ररथ: सिद्धानां कपिलो मुनि: || 26||"," aśhvatthaḥ—the banyan tree; sarva-vṛikṣhāṇām—amongst all trees; deva-ṛiṣhīṇām—amongst celestial sages; cha—and; nāradaḥ—Narad; gandharvāṇām—amongst the gandharvas; chitrarathaḥ—Chitrarath; siddhānām—of all those who are perfected; kapilaḥ muniḥ—sage Kapil ","aśhvatthaḥ sarva-vṛikṣhāṇāṁ devarṣhīṇāṁ cha nāradaḥ\n" + "gandharvāṇāṁ chitrarathaḥ siddhānāṁ kapilo muniḥ",R.color.trans));
        mData.add(new NewsItem("उच्चै:श्रवसमश्वानां विद्धि माममृतोद्भवम् |\n" + "ऐरावतं गजेन्द्राणां नराणां च नराधिपम् || 27||"," uchchaiḥśhravasam—Uchchaihshrava; aśhvānām—amongst horses; viddhi—know; mām—me; amṛita-udbhavam—begotten from the churning of the ocean of nectar; airāvatam—Airavata; gaja-indrāṇām—amongst all lordly elephants; narāṇām—amongst humans; cha—and; nara-adhipam—the king ","uchchaiḥśhravasam aśhvānāṁ viddhi mām amṛitodbhavam\n" + "airāvataṁ gajendrāṇāṁ narāṇāṁ cha narādhipam",R.color.trans));
        mData.add(new NewsItem("आयुधानामहं वज्रं धेनूनामस्मि कामधुक् |\n" + "प्रजनश्चास्मि कन्दर्प: सर्पाणामस्मि वासुकि: || 28||"," āyudhānām—amongst weapons; aham—I; vajram—the Vajra (thunderbolt); dhenūnām—amongst cows; asmi—I am; kāma-dhuk—Kamdhenu; prajanaḥ—amongst causes for procreation; cha—and; asmi—I am; kandarpaḥ—Kaamdev, the god of love; sarpāṇām—amongst serpents; asmi—I am; vāsukiḥ—serpent Vasuki ","āyudhānām ahaṁ vajraṁ dhenūnām asmi kāmadhuk\n" + "prajanaśh chāsmi kandarpaḥ sarpāṇām asmi vāsukiḥ",R.color.trans));
        mData.add(new NewsItem("अनन्तश्चास्मि नागानां वरुणो यादसामहम् |\n" + "पितृणामर्यमा चास्मि यम: संयमतामहम् || 29||"," anantaḥ—Anant; cha—and; asmi—I am; nāgānām—amongst snakes; varuṇaḥ—the celestial god of the ocean; yādasām—amongst aquatics; aham—I; pitṝīṇām—amongst the departed ancestors; aryamā—Aryama; cha—and; asmi—am; yamaḥ—the celestial god of death; sanyamatām—amongst dispensers of law; aham—I ","anantaśh chāsmi nāgānāṁ varuṇo yādasām aham\n" + "pitṝīṇām aryamā chāsmi yamaḥ sanyamatām aham",R.color.trans));
        mData.add(new NewsItem("प्रह्लादश्चास्मि दैत्यानां काल: कलयतामहम् |\n" + "मृगाणां च मृगेन्द्रोऽहं वैनतेयश्च पक्षिणाम् || 30||"," prahlādaḥ—Prahlad; cha—and; asmi—I am; daityānām—of the demons; kālaḥ—time; kalayatām—of all that controls; aham—I; mṛigāṇām—amongst animals; cha—and; mṛiga-indraḥ—the lion; aham—I; vainateyaḥ—Garud; cha—and; pakṣhiṇām—amongst birds ","prahlādaśh chāsmi daityānāṁ kālaḥ kalayatām aham\n" + "mṛigāṇāṁ cha mṛigendro ’haṁ vainateyaśh cha pakṣhiṇām",R.color.trans));
        mData.add(new NewsItem("पवन: पवतामस्मि राम: शस्त्रभृतामहम् |\n" + "झषाणां मकरश्चास्मि स्रोतसामस्मि जाह्नवी || 31||"," pavanaḥ—the wind; pavatām—of all that purifies; asmi—I am; rāmaḥ—Ram; śhastra-bhṛitām—of the carriers of weapons; aham—I am; jhaṣhāṇām—of all acquatics; makaraḥ—crocodile; cha—also; asmi—I am; srotasām—of flowing rivers; asmi—I am; jāhnavī—the Ganges ","pavanaḥ pavatām asmi rāmaḥ śhastra-bhṛitām aham\n" + "jhaṣhāṇāṁ makaraśh chāsmi srotasām asmi jāhnavī",R.color.trans));
        mData.add(new NewsItem("सर्गाणामादिरन्तश्च मध्यं चैवाहमर्जुन |\n" + "अध्यात्मविद्या विद्यानां वाद: प्रवदतामहम् || 32||"," sargāṇām—of all creations; ādiḥ—the beginning; antaḥ—end; cha—and; madhyam—middle; cha—and; eva—indeed; aham—I; arjuna—Arjun; adhyātma-vidyā—science of spirituality; vidyānām—amongst sciences; vādaḥ—the logical conclusion; pravadatām—of debates; aham—I ","sargāṇām ādir antaśh cha madhyaṁ chaivāham arjuna\n" + "adhyātma-vidyā vidyānāṁ vādaḥ pravadatām aham",R.color.trans));
        mData.add(new NewsItem("अक्षराणामकारोऽस्मि द्वन्द्व: सामासिकस्य च |\n" + "अहमेवाक्षय: कालो धाताहं विश्वतोमुख: || 33||"," akṣharāṇām—amongst all letters; a-kāraḥ—the beginning letter “A”; asmi—I am; dvandvaḥ—the dual; sāmāsikasya—amongst grammatical compounds; cha—and; aham—I; eva—only; akṣhayaḥ—endless; kālaḥ—time; dhātā—amongst the creators; aham—I; viśhwataḥ-mukhaḥ—Brahma ","akṣharāṇām a-kāro ’smi dvandvaḥ sāmāsikasya cha\n" + "aham evākṣhayaḥ kālo dhātāhaṁ viśhvato-mukhaḥ",R.color.trans));
        mData.add(new NewsItem("मृत्यु: सर्वहरश्चाहमुद्भवश्च भविष्यताम् |\n" + "कीर्ति: श्रीर्वाक्च नारीणां स्मृतिर्मेधा धृति: क्षमा || 34||"," mṛityuḥ—death; sarva-haraḥ—all-devouring; cha—and; aham—I; udbhavaḥ—the origin; cha—and; bhaviṣhyatām—those things that are yet to be; kīrtiḥ—fame; śhrīḥ—prospective; vāk—fine speech; cha—and; nārīṇām—amongst feminine qualities; smṛitiḥ—memory; medhā—intelligence; dhṛitiḥ—courage; kṣhamā—forgiveness ","mṛityuḥ sarva-haraśh chāham udbhavaśh cha bhaviṣhyatām\n" + "kīrtiḥ śhrīr vāk cha nārīṇāṁ smṛitir medhā dhṛitiḥ kṣhamā",R.color.trans));
        mData.add(new NewsItem("बृहत्साम तथा साम्नां गायत्री छन्दसामहम् |\n" + "मासानां मार्गशीर्षोऽहमृतूनां कुसुमाकर: || 35||"," bṛihat-sāma—the Brihatsama; tathā—also; sāmnām—amongst the hymns in the Sama Veda; gāyatrī—the Gayatri mantra; chhandasām—amongst poetic meters; aham—I; māsānām—of the twelve months; mārga-śhīrṣhaḥ—the month of November-December; aham—I; ṛitūnām—of all seasons; kusuma-ākaraḥ—spring ","bṛihat-sāma tathā sāmnāṁ gāyatrī chhandasām aham\n" + "māsānāṁ mārga-śhīrṣho ’ham ṛitūnāṁ kusumākaraḥ",R.color.trans));
        mData.add(new NewsItem("द्यूतं छलयतामस्मि तेजस्तेजस्विनामहम् |\n" + "जयोऽस्मि व्यवसायोऽस्मि सत्वं सत्ववतामहम् || 36||"," dyūtam—gambling; chhalayatām—of all cheats; asmi—I am; tejaḥ—the splendor; tejasvinām—of the splendid; aham—I; jayaḥ—victory; asmi—I am; vyavasāyaḥ—firm resolve; asmi—I am; sattvam—virtue; sattva-vatām—of the virtuous; aham—I ","dyūtaṁ chhalayatām asmi tejas tejasvinām aham\n" + "jayo ’smi vyavasāyo ’smi sattvaṁ sattvavatām aham",R.color.trans));
        mData.add(new NewsItem("वृष्णीनां वासुदेवोऽस्मि पाण्डवानां धनञ्जय: |\n" + "मुनीनामप्यहं व्यास: कवीनामुशना कवि: || 37||"," vṛiṣhṇīnām—amongst the descendants of Vrishni; vāsudevaḥ—Krishna, the son of Vasudev; asmi—I am; pāṇḍavānām—amongst the Pandavas; dhanañjayaḥ—Arjun, the conqueror of wealth; munīnām—amongst the sages; api—also; aham—I; vyāsaḥ—Ved Vyas; kavīnām—amongst the great thinkers; uśhanā—Shukracharya; kaviḥ—the thinker ","vṛiṣhṇīnāṁ vāsudevo ’smi pāṇḍavānāṁ dhanañjayaḥ\n" + "munīnām apyahaṁ vyāsaḥ kavīnām uśhanā kaviḥ",R.color.trans));
        mData.add(new NewsItem("दण्डो दमयतामस्मि नीतिरस्मि जिगीषताम् |\n" + "मौनं चैवास्मि गुह्यानां ज्ञानं ज्ञानवतामहम् || 38||"," daṇḍaḥ—punishment; damayatām—amongst means of preventing lawlessness; asmi—I am; nītiḥ—proper conduct; asmi—I am; jigīṣhatām—amongst those who seek victory; maunam—silence; cha—and; eva—also; asmi—I am; guhyānām—amongst secrets; jñānam—wisdom; jñāna-vatām—in the wise; aham—I ","daṇḍo damayatām asmi nītir asmi jigīṣhatām\n" + "maunaṁ chaivāsmi guhyānāṁ jñānaṁ jñānavatām aham",R.color.trans));
        mData.add(new NewsItem("यच्चापि सर्वभूतानां बीजं तदहमर्जुन |\n" + "न तदस्ति विना यत्स्यान्मया भूतं चराचरम् || 39||"," yat—which; cha—and; api—also; sarva-bhūtānām—of all living beings; bījam—generating seed; tat—that; aham—I; arjuna—Arjun; na—not; tat—that; asti—is; vinā—without; yat—which; syāt—may exist; mayā—me; bhūtam—creature; chara-acharam—moving and nonmoving ","yach chāpi sarva-bhūtānāṁ bījaṁ tad aham arjuna\n" + "na tad asti vinā yat syān mayā bhūtaṁ charācharam",R.color.trans));
        mData.add(new NewsItem("नान्तोऽस्ति मम दिव्यानां विभूतीनां परन्तप |\n" + "एष तूद्देशत: प्रोक्तो विभूतेर्विस्तरो मया || 40||"," na—not; antaḥ—end; asti—is; mama—my; divyānām—divine; vibhūtīnām—manifestations; parantapa—Arjun, the conqueror of the enemies; eṣhaḥ—this; tu—but; uddeśhataḥ—just one portion; proktaḥ—declared; vibhūteḥ—of (my) glories; vistaraḥ—the breath of the topic; mayā—by me ","nānto ’sti mama divyānāṁ vibhūtīnāṁ parantapa\n" + "eṣha tūddeśhataḥ prokto vibhūter vistaro mayā",R.color.trans));
        mData.add(new NewsItem("यद्यद्विभूतिमत्सत्वं श्रीमदूर्जितमेव वा |\n" + "तत्देवावगच्छ त्वं मम तेजोंऽशसम्भवम् || 41||"," yat yat—whatever; vibhūtimat—opulent; sattvam—being; śhrī-mat—beautiful; ūrjitam—glorious; eva—also; vā—or; tat tat—all that; eva—only; avagachchha—know; tvam—you; mama—my; tejaḥ-anśha-sambhavam—splendor; anśha—a part; sambhavam—born of ","yad yad vibhūtimat sattvaṁ śhrīmad ūrjitam eva vā\n" + "tat tad evāvagachchha tvaṁ mama tejo ’nśha-sambhavam",R.color.trans));
        mData.add(new NewsItem("अथवा बहुनैतेन किं ज्ञातेन तवार्जुन |\n" + "विष्टभ्याहमिदं कृत्स्नमेकांशेन स्थितो जगत् || 42||"," athavā—or; bahunā—detailed; etena—by this; kim—what; jñātena tava—can be known by you; arjuna—Arjun; viṣhṭabhya—pervade and support; aham—I; idam—this; kṛitsnam—entire; eka—by one; anśhena—fraction; sthitaḥ—am situated; jagat—creation ","atha vā bahunaitena kiṁ jñātena tavārjuna\n" + "viṣhṭabhyāham idaṁ kṛitsnam ekānśhena sthito jagat",R.color.trans));





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

            Intent myIntent = new Intent(this, Chp10.class);
            this.startActivity(myIntent);

        }

        if (id == R.id.verses){

       //     Intent myIntent = new Intent(this, Main2Activity.class);
        //    this.startActivity(myIntent);

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