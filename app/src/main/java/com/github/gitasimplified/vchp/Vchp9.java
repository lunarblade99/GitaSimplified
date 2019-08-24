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
import com.github.gitasimplified.chp.Chp9;

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
        mData.add(new NewsItem("श्रीभगवानुवाच |\n" + "इदं तु ते गुह्यतमं प्रवक्ष्याम्यनसूयवे |\n" + "ज्ञानं विज्ञानसहितं यज्ज्ञात्वा मोक्ष्यसेऽशुभात् || 1||"," śhrī-bhagavān uvācha—the Supreme Lord said; idam—this; tu—but; te—to you; guhya-tamam—the most confidential; pravakṣhyāmi—I shall impart; anasūyave—nonenvious; jñānam—knowledge; vijñāna—realized knowledge; sahitam—with; yat—which; jñātvā—knowing; mokṣhyase—you will be released; aśhubhāt—miseries of material existence ","\n" + "\n" + "śhrī bhagavān uvācha\n" + "idaṁ tu te guhyatamaṁ pravakṣhyāmyanasūyave\n" + "jñānaṁ vijñāna-sahitaṁ yaj jñātvā mokṣhyase ’śhubhāt\n",R.color.trans));
        mData.add(new NewsItem("राजविद्या राजगुह्यं पवित्रमिदमुत्तमम् |\n" + "प्रत्यक्षावगमं धर्म्यं सुसुखं कर्तुमव्ययम् || 2||"," rāja-vidyā—the king of sciences; rāja-guhyam—the most profound secret; pavitram—pure; idam—this; uttamam—highest; pratyakṣha—directly perceptible; avagamam—directly realizable; dharmyam—virtuous; su-sukham—easy; kartum—to practice; avyayam—everlasting ","rāja-vidyā rāja-guhyaṁ pavitram idam uttamam\n" + "pratyakṣhāvagamaṁ dharmyaṁ su-sukhaṁ kartum avyayam",R.color.trans));
        mData.add(new NewsItem("अश्रद्दधाना: पुरुषा धर्मस्यास्य परन्तप |\n" + "अप्राप्य मां निवर्तन्ते मृत्युसंसारवर्त्मनि || 3||"," aśhraddadhānāḥ—people without faith; puruṣhāḥ—(such) persons; dharmasya—of dharma; asya—this; parantapa—Arjun, conqueror the enemies; aprāpya—without attaining; mām—Me; nivartante—come back; mṛityu—death; samsāra—material existence; vartmani—in the path ","aśhraddadhānāḥ puruṣhā dharmasyāsya parantapa\n" + "aprāpya māṁ nivartante mṛityu-samsāra-vartmani",R.color.trans));
        mData.add(new NewsItem("मया ततमिदं सर्वं जगदव्यक्तमूर्तिना |\n" + "मत्स्थानि सर्वभूतानि न चाहं तेष्ववस्थित: || 4||"," mayā—by Me; tatam—pervaded; idam—this; sarvam—entire; jagat—cosmic manifestation; avyakta-mūrtinā—the unmanifested form; mat-sthāni—in Me; sarva-bhūtāni—all living beings; na—not; cha—and; aham—I; teṣhu—in them; avasthitaḥ—dwell ","mayā tatam idaṁ sarvaṁ jagad avyakta-mūrtinā\n" + "mat-sthāni sarva-bhūtāni na chāhaṁ teṣhvavasthitaḥ",R.color.trans));
        mData.add(new NewsItem("न च मत्स्थानि भूतानि पश्य मे योगमैश्वरम् |\n" + "भूतभृन्न च भूतस्थो ममात्मा भूतभावन: || 5||"," na—never; cha—and; mat-sthāni—abide in Me; bhūtāni—all living beings; paśhya—behold; me—My; yogam aiśhwaram—divine energy; bhūta-bhṛit—the sustainer of all living beings; na—never; cha—yet; bhūta-sthaḥ—dwelling in; mama—My; ātmā—Self; bhūta-bhāvanaḥ—the Creator of all beings ","na cha mat-sthāni bhūtāni paśhya me yogam aiśhwaram\n" + "bhūta-bhṛin na cha bhūta-stho mamātmā bhūta-bhāvanaḥ",R.color.trans));
        mData.add(new NewsItem("यथाकाशस्थितो नित्यं वायु: सर्वत्रगो महान् |\n" + "तथा सर्वाणि भूतानि मत्स्थानीत्युपधारय || 6||"," yathā—as; ākāśha-sthitaḥ—rests in the sky; nityam—always; vāyuḥ—the wind; sarvatra-gaḥ—blowing everywhere; mahān—mighty; tathā—likewise; sarvāṇi bhūtāni—all living beings; mat-sthāni—rest in Me; iti—thus; upadhāraya—know ","yathākāśha-sthito nityaṁ vāyuḥ sarvatra-go mahān\n" + "tathā sarvāṇi bhūtāni mat-sthānītyupadhāraya",R.color.trans));
        mData.add(new NewsItem("सर्वभूतानि कौन्तेय प्रकृतिं यान्ति मामिकाम् |\n" + "कल्पक्षये पुनस्तानि कल्पादौ विसृजाम्यहम् || 7||\n" + "प्रकृतिं स्वामवष्टभ्य विसृजामि पुन: पुन: |\n" + "भूतग्राममिमं कृत्स्नमवशं प्रकृतेर्वशात् || 8||"," sarva-bhūtāni—all living beings; kaunteya—Arjun, the son of Kunti; prakṛitim—primordial material energy; yānti—merge; māmikām—My; kalpa-kṣhaye—at the end of a kalpa; punaḥ—again; tāni—them; kalpa-ādau—at the beginning of a kalpa; visṛijāmi—manifest; aham—I; prakṛitim—the material energy; svām—My own; avaṣhṭabhya—presiding over; visṛijāmi—generate; punaḥ punaḥ—again and again; bhūta-grāmam—myriad forms; imam—these; kṛitsnam—all; avaśham—beyond their control; prakṛiteḥ—nature; vaśhāt—force ","sarva-bhūtāni kaunteya prakṛitiṁ yānti māmikām\n" + "kalpa-kṣhaye punas tāni kalpādau visṛijāmyaham\n" + "prakṛitiṁ svām avaṣhṭabhya visṛijāmi punaḥ punaḥ\n" + "bhūta-grāmam imaṁ kṛitsnam avaśhaṁ prakṛiter vaśhāt",R.color.trans));
        mData.add(new NewsItem("न च मां तानि कर्माणि निबध्नन्ति धनञ्जय |\n" + "उदासीनवदासीनमसक्तं तेषु कर्मसु || 9||"," na—none; cha—as; mām—Me; tāni—those; karmāṇi—actions; nibadhnanti—bind; dhanañjaya—Arjun, conqueror of wealth; udāsīna-vat—as neutral; āsīnam—situated; asaktam—detached; teṣhu—those; karmasu—actions ","na cha māṁ tāni karmāṇi nibadhnanti dhanañjaya\n" + "udāsīna-vad āsīnam asaktaṁ teṣhu karmasu",R.color.trans));
        mData.add(new NewsItem("मयाध्यक्षेण प्रकृति: सूयते सचराचरम् |\n" + "हेतुनानेन कौन्तेय जगद्विपरिवर्तते || 10||"," mayā—by Me; adhyakṣheṇa—direction; prakṛitiḥ—material energy; sūyate—brings into being; sa—both; chara-acharam—the animate and the inanimate; hetunā—reason; anena—this; kaunteya—Arjun, the son of Kunti; jagat—the material world; viparivartate—undergoes the changes ","mayādhyakṣheṇa prakṛitiḥ sūyate sa-charācharam\n" + "hetunānena kaunteya jagad viparivartate",R.color.trans));
        mData.add(new NewsItem("अवजानन्ति मां मूढा मानुषीं तनुमाश्रितम् |\n" + "परं भावमजानन्तो मम भूतमहेश्वरम् || 11||"," avajānanti—disregard; mām—Me; mūḍhāḥ—dim-witted; mānuṣhīm—human; tanum—form; āśhritam—take on; param—divine; bhāvam—personality; ajānantaḥ—not knowing; mama—My; bhūta—all beings; mahā-īśhvaram—the Supreme Lord ","mayādhyakṣheṇa prakṛitiḥ sūyate sa-charācharam\n" + "hetunānena kaunteya jagad viparivartate",R.color.trans));
        mData.add(new NewsItem("मोघाशा मोघकर्माणो मोघज्ञाना विचेतस: |\n" + "राक्षसीमासुरीं चैव प्रकृतिं मोहिनीं श्रिता: || 12||"," mogha-āśhāḥ—of vain hopes; mogha-karmāṇaḥ—of vain actions; mogha-jñānāḥ—of baffled knowledge; vichetasaḥ—deluded; rākṣhasīm—demoniac; āsurīm—atheistic; cha—and; eva—certainly; prakṛitim—material energy; mohinīm—bewildered; śhritāḥ—take shelter ","moghāśhā mogha-karmāṇo mogha-jñānā vichetasaḥ\n" + "rākṣhasīm āsurīṁ chaiva prakṛitiṁ mohinīṁ śhritāḥ",R.color.trans));
        mData.add(new NewsItem("महात्मानस्तु मां पार्थ दैवीं प्रकृतिमाश्रिता: |\n" + "भजन्त्यनन्यमनसो ज्ञात्वा भूतादिमव्ययम् || 13||"," mahā-ātmānaḥ—the great souls; tu—but; mām—Me; pārtha—Arjun, the son of Pritha; daivīm prakṛitim—divine energy; āśhritāḥ—take shelter of; bhajanti—engage in devotion; ananya-manasaḥ—with mind fixed exclusively; jñātvā—knowing; bhūta—all creation; ādim—the origin; avyayam—imperishable ","mahātmānas tu māṁ pārtha daivīṁ prakṛitim āśhritāḥ\n" + "bhajantyananya-manaso jñātvā bhūtādim avyayam",R.color.trans));
        mData.add(new NewsItem("सततं कीर्तयन्तो मां यतन्तश्च दृढव्रता: |\n" + "नमस्यन्तश्च मां भक्त्या नित्ययुक्ता उपासते || 14||"," satatam—always; kīrtayantaḥ—singing divine glories; mām—Me; yatantaḥ—striving; cha—and; dṛiḍha-vratāḥ—with great determination; namasyantaḥ—humbly bowing down; cha—and; mām—Me; bhaktyā—loving devotion; nitya-yuktāḥ—constantly united; upāsate—worship ","satataṁ kīrtayanto māṁ yatantaśh cha dṛiḍha-vratāḥ\n" + "namasyantaśh cha māṁ bhaktyā nitya-yuktā upāsate",R.color.trans));
        mData.add(new NewsItem("ज्ञानयज्ञेन चाप्यन्ये यजन्तो मामुपासते |\n" + "एकत्वेन पृथक्त्वेन बहुधा विश्वतोमुखम् || 15||"," jñāna-yajñena—yajña of cultivating knowledge; cha—and; api—also; anye—others; yajantaḥ—worship; mām—Me; upāsate—worship; ekatvena—undifferentiated oneness; pṛithaktvena—separately; bahudhā—various; viśhwataḥ-mukham—the cosmic form ","jñāna-yajñena chāpyanye yajanto mām upāsate\n" + "ekatvena pṛithaktvena bahudhā viśhvato-mukham",R.color.trans));
        mData.add(new NewsItem("अहं क्रतुरहं यज्ञ: स्वधाहमहमौषधम् |\n" + "मन्त्रोऽहमहमेवाज्यमहमग्निरहं हुतम् || 16||\n" + "पिताहमस्य जगतो माता धाता पितामह: |\n" + "वेद्यं पवित्रमोङ्कार ऋक्साम यजुरेव च || 17||"," aham—I; kratuḥ—Vedic ritual; aham—I; yajñaḥ—sacrifice; svadhā—oblation; aham—I; aham—I; auṣhadham—medicinal herb; mantraḥ—Vedic mantra; aham—I; aham—I; eva—also; ājyam—clarified butter; aham—I; agniḥ—fire; aham—I; hutam—the act offering; pitā—Father; aham—I; asya—of this; jagataḥ—universe; mātā—Mother; dhātā—Sustainer; pitāmahaḥ—Grandsire; vedyam—the goal of knowledge; pavitram—the purifier; om-kāra—the sacred syllable Om; ṛik—the Rig Veda; sāma—the Sama Veda; yajuḥ—the Yajur Veda; eva—also; cha—and ","ahaṁ kratur ahaṁ yajñaḥ svadhāham aham auṣhadham\n" + "mantro ’ham aham evājyam aham agnir ahaṁ hutam\n" + "pitāham asya jagato mātā dhātā pitāmahaḥ\n" + "vedyaṁ pavitram oṁkāra ṛik sāma yajur eva cha",R.color.trans));
        mData.add(new NewsItem("गतिर्भर्ता प्रभु: साक्षी निवास: शरणं सुहृत् |\n" + "प्रभव: प्रलय: स्थानं निधानं बीजमव्ययम् || 18||"," gatiḥ—the Supreme Goal; bhartā—Sustainer; prabhuḥ—Master; sākṣhī—Witness; nivāsaḥ—Abode; śharaṇam—Shelter; su-hṛit—Friend; prabhavaḥ—the Origin; pralayaḥ—Dissolution; sthānam—Store House; nidhānam—Resting Place; bījam—Seed; avyayam—Imperishable ","gatir bhartā prabhuḥ sākṣhī nivāsaḥ śharaṇaṁ suhṛit\n" + "prabhavaḥ pralayaḥ sthānaṁ nidhānaṁ bījam avyayam",R.color.trans));
        mData.add(new NewsItem("तपाम्यहमहं वर्षं निगृह्णम्युत्सृजामि च |\n" + "अमृतं चैव मृत्युश्च सदसच्चाहमर्जुन || 19||"," tapāmi—radiate heat; aham—I; aham—I; varṣham—rain; nigṛihṇāmi—withhold; utsṛijāmi—send forth; cha—and; amṛitam—immortality; cha—and; eva—also; mṛityuḥ—death; cha—and; sat—eternal spirit; asat—temporary matter; cha—and; aham—I; arjuna—Arjun ","tapāmyaham ahaṁ varṣhaṁ nigṛihṇāmyutsṛijāmi cha\n" + "amṛitaṁ chaiva mṛityuśh cha sad asach chāham arjuna",R.color.trans));
        mData.add(new NewsItem("त्रैविद्या मां सोमपा: पूतपापा\n" + "यज्ञैरिष्ट्वा स्वर्गतिं प्रार्थयन्ते |\n" + "ते पुण्यमासाद्य सुरेन्द्रलोक\n" + "मश्नन्ति दिव्यान्दिवि देवभोगान् || 20||"," trai-vidyāḥ—the science of karm kāṇḍ (Vedic Rituals); mām—Me; soma-pāḥ—drinkers of the Soma juice; pūta—purified; pāpāḥ—sins; yajñaiḥ—through sacrifices; iṣhṭvā—worship; svaḥ-gatim—way to the abode of the king of heaven; prārthayante—seek; te—they; puṇyam—pious; āsādya—attain; sura-indra—of Indra; lokam—abode; aśhnanti—enjoy; divyān—celestial; divi—in heaven; deva-bhogān—the pleasures of the celestial gods ","trai-vidyā māṁ soma-pāḥ pūta-pāpā\n" + "yajñair iṣhṭvā svar-gatiṁ prārthayante\n" + "te puṇyam āsādya surendra-lokam\n" + "aśhnanti divyān divi deva-bhogān",R.color.trans));
        mData.add(new NewsItem("ते तं भुक्त्वा स्वर्गलोकं विशालं\n" + "क्षीणे पुण्ये मर्त्यलोकं विशन्ति |\n" + "एवं त्रयीधर्ममनुप्रपन्ना\n" + "गतागतं कामकामा लभन्ते || 21||"," te—they; tam—that; bhuktvā—having enjoyed; swarga-lokam—heaven; viśhālam—vast; kṣhīṇe—at the exhaustion of; puṇye—stock of merits; martya-lokam—to the earthly plane; viśhanti—return; evam—thus; trayī dharmam—the karm-kāṇḍ portion of the three Vedas; anuprapannāḥ—follow; gata-āgatam—repeated coming and going; kāma-kāmāḥ—desiring objects of enjoyments; labhante—attain ","te taṁ bhuktvā swarga-lokaṁ viśhālaṁ\n" + "kṣhīṇe puṇye martya-lokaṁ viśhanti\n" + "evaṁ trayī-dharmam anuprapannā\n" + "gatāgataṁ kāma-kāmā labhante",R.color.trans));
        mData.add(new NewsItem("अनन्याश्चिन्तयन्तो मां ये जना: पर्युपासते |\n" + "तेषां नित्याभियुक्तानां योगक्षेमं वहाम्यहम् || 22||"," ananyāḥ—always; chintayantaḥ—think of; mām—Me; ye—those who; janāḥ—persons; paryupāsate—worship exclusively; teṣhām—of them; nitya abhiyuktānām—who are always absorbed; yoga—supply spiritual assets; kṣhemam—protect spiritual assets; vahāmi—carry; aham—I ","ananyāśh chintayanto māṁ ye janāḥ paryupāsate\n" + "teṣhāṁ nityābhiyuktānāṁ yoga-kṣhemaṁ vahāmyaham",R.color.trans));
        mData.add(new NewsItem("येऽप्यन्यदेवता भक्ता यजन्ते श्रद्धयान्विता: |\n" + "तेऽपि मामेव कौन्तेय यजन्त्यविधिपूर्वकम् || 23||"," ye—those who; api—although; anya—other; devatā—celestial gods; bhaktāḥ—devotees; yajante—worship; śhraddhayā anvitāḥ—faithfully; te—they; api—also; mām—Me; eva—only; kaunteya—Arjun, the son of Kunti; yajanti—worship; avidhi-pūrvakam—by the wrong method ","ye ’pyanya-devatā-bhaktā yajante śhraddhayānvitāḥ\n" + "te ’pi mām eva kaunteya yajantyavidhi-pūrvakam",R.color.trans));
        mData.add(new NewsItem("अहं हि सर्वयज्ञानां भोक्ता च प्रभुरेव च |\n" + "न तु मामभिजानन्ति तत्वेनातश्च्यवन्ति ते || 24||"," aham—I; hi—verily; sarva—of all; yajñānām—sacrifices; bhoktā—the enjoyer; cha—and; prabhuḥ—the Lord; eva—only; cha—and; na—not; tu—but; mām—Me; abhijānanti—realize; tattvena—divine nature; ataḥ—therefore; chyavanti—fall down (wander in samsara); te—they ","ahaṁ hi sarva-yajñānāṁ bhoktā cha prabhureva cha\n" + "na tu mām abhijānanti tattvenātaśh chyavanti te",R.color.trans));
        mData.add(new NewsItem("यान्ति देवव्रता देवान्पितॄ न्यान्ति पितृव्रता: |\n" + "भूतानि यान्ति भूतेज्या यान्ति मद्याजिनोऽपि माम् ||25||"," yānti—go; deva-vratāḥ—worshipers of celestial gods; devān—amongst the celestial gods; pitṝīn—to the ancestors; yānti—go; pitṛi-vratā—worshippers of ancestors; bhūtāni—to the ghosts; yānti—go; bhūta-ijyāḥ—worshippers of ghosts; yānti—go; mat—my; yājinaḥ—devotees; api—and; mām—to Me ","yānti deva-vratā devān pitṝīn yānti pitṛi-vratāḥ\n" + "bhūtāni yānti bhūtejyā yānti mad-yājino ’pi mām",R.color.trans));
        mData.add(new NewsItem("पत्रं पुष्पं फलं तोयं यो मे भक्त्या प्रयच्छति |\n" + "तदहं भक्त्युपहृतमश्नामि प्रयतात्मन: || 26||"," patram—a leaf; puṣhpam—a flower; phalam—a fruit; toyam—water; yaḥ—who; me—to Me; bhaktyā—with devotion; prayachchhati—offers; tat—that; aham—I; bhakti-upahṛitam—offered with devotion; aśhnāmi—partake; prayata-ātmanaḥ—one in pure consciousness ","patraṁ puṣhpaṁ phalaṁ toyaṁ yo me bhaktyā prayachchhati\n" + "tadahaṁ bhaktyupahṛitam aśhnāmi prayatātmanaḥ",R.color.trans));
        mData.add(new NewsItem("यत्करोषि यदश्नासि यज्जुहोषि ददासि यत् |\n" + "यत्तपस्यसि कौन्तेय तत्कुरुष्व मदर्पणम् || 27||"," yat—whatever; karoṣhi—you do; yat—whatever; aśhnāsi—you eat; yat—whatever; juhoṣhi—offer to the sacred fire; dadāsi—bestow as a gift; yat—whatever; yat—whatever; tapasyasi—austerities you perform; kaunteya—Arjun, the son of Kunti; tat—them; kuruṣhva—do; mad arpaṇam—as an offering to Me ","\n" + "\n" + "yat karoṣhi yad aśhnāsi yaj juhoṣhi dadāsi yat\n" + "yat tapasyasi kaunteya tat kuruṣhva mad-arpaṇam\n",R.color.trans));
        mData.add(new NewsItem("शुभाशुभफलैरेवं मोक्ष्यसे कर्मबन्धनै: |\n" + "संन्यासयोगयुक्तात्मा विमुक्तो मामुपैष्यसि || 28||"," śhubha aśhubha phalaiḥ—from good and bad results; evam—thus; mokṣhyase—you shall be freed; karma—work; bandhanaiḥ—from the bondage; sanyāsa-yoga—renunciation of selfishness; yukta-ātmā—having the mind attached to Me; vimuktaḥ—liberated; mām—to Me; upaiṣhyasi—you shall reach ","śhubhāśhubha-phalair evaṁ mokṣhyase karma-bandhanaiḥ\n" + "sannyāsa-yoga-yuktātmā vimukto mām upaiṣhyasi",R.color.trans));
        mData.add(new NewsItem("समोऽहं सर्वभूतेषु न मे द्वेष्योऽस्ति न प्रिय: |\n" + "ये भजन्ति तु मां भक्त्या मयि ते तेषु चाप्यहम् || 29||"," samaḥ—equally disposed; aham—I; sarva-bhūteṣhu—to all living beings; na—no one; me—to Me; dveṣhyaḥ—inimical; asti—is; na—not; priyaḥ—dear; ye—who; bhajanti—worship with love; tu—but; mām—Me; bhaktyā—with devotion; mayi—reside in Me; te—such persons; teṣhu—in them; cha—and; api—also; aham—I ","samo ’haṁ sarva-bhūteṣhu na me dveṣhyo ’sti na priyaḥ\n" + "ye bhajanti tu māṁ bhaktyā mayi te teṣhu chāpyaham",R.color.trans));
        mData.add(new NewsItem("अपि चेत्सुदुराचारो भजते मामनन्यभाक् |\n" + "साधुरेव स मन्तव्य: सम्यग्व्यवसितो हि स: || 30||"," api—even; chet—if; su-durāchāraḥ—the vilest sinners; bhajate—worship; mām—Me; ananya-bhāk—exclusive devotion; sādhuḥ—righteous; eva—certainly; saḥ—that person; mantavyaḥ—is to be considered; samyak—properly; vyavasitaḥ—resolve; hi—certainly; saḥ—that person ","api chet su-durāchāro bhajate mām ananya-bhāk\n" + "sādhur eva sa mantavyaḥ samyag vyavasito hi saḥ",R.color.trans));
        mData.add(new NewsItem("क्षिप्रं भवति धर्मात्मा शश्वच्छान्तिं निगच्छति |\n" + "कौन्तेय प्रतिजानीहि न मे भक्त: प्रणश्यति || 31||"," kṣhipram—quickly; bhavati—become; dharma-ātmā—virtuous; śhaśhvat-śhāntim—lasting peace; nigachchhati—attain; kaunteya—Arjun, the son of Kunti; pratijānīhi—declare; na—never; me—My; bhaktaḥ—devotee; praṇaśhyati—perishes ","kṣhipraṁ bhavati dharmātmā śhaśhvach-chhāntiṁ nigachchhati\n" + "kaunteya pratijānīhi na me bhaktaḥ praṇaśhyati",R.color.trans));
        mData.add(new NewsItem("मां हि पार्थ व्यपाश्रित्य येऽपि स्यु: पापयोनय: |\n" + "स्त्रियो वैश्यास्तथा शूद्रास्तेऽपि यान्ति परां गतिम् || 32||"," mām—in Me; hi—certainly; pārtha—Arjun, the son of Pritha; vyapāśhritya—take refuge; ye—who; api—even; syuḥ—may be; pāpa yonayaḥ—of low birth; striyaḥ—women; vaiśhyāḥ—mercantile people; tathā—and; śhūdrāḥ—manual workers; te api—even they; yānti—go; parām—the supreme; gatim—destination ","māṁ hi pārtha vyapāśhritya ye ’pi syuḥ pāpa-yonayaḥ\n" + "striyo vaiśhyās tathā śhūdrās te ’pi yānti parāṁ gatim",R.color.trans));
        mData.add(new NewsItem("किं पुनर्ब्राह्मणा: पुण्या भक्ता राजर्षयस्तथा |"," kim—what; punaḥ—then; brāhmaṇāḥ—sages; puṇyāḥ—meritorius; bhaktāḥ—devotees; rāja-ṛiṣhayaḥ—saintly kings; tathā—and; anityam—transient; asukham—joyless; lokam—world; imam—this; prāpya—having achieved; bhajasva—engage in devotion; mām—unto Me ","kiṁ punar brāhmaṇāḥ puṇyā bhaktā rājarṣhayas tathā\n" + "anityam asukhaṁ lokam imaṁ prāpya bhajasva mām",R.color.trans));
        mData.add(new NewsItem("मन्मना भव मद्भक्तो मद्याजी मां नमस्कुरु |\n" + "मामेवैष्यसि युक्त्वैवमात्मानं मत्परायण: || 34||"," mat-manāḥ—always think of Me; bhava—be; mat—My; bhaktaḥ—devotee; mat—My; yājī—worshipper; mām—to Me; namaskuru—offer obeisances; mām—to Me; eva—certainly; eṣhyasi—you will come; yuktvā—united with Me; evam—thus; ātmānam—your mind and body; mat-parāyaṇaḥ—having dedicated to Me ","man-manā bhava mad-bhakto mad-yājī māṁ namaskuru\n" + "mām evaiṣhyasi yuktvaivam ātmānaṁ mat-parāyaṇaḥ",R.color.trans));

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

            Intent myIntent = new Intent(this, Chp9.class);
            this.startActivity(myIntent);

        }

        if (id == R.id.verses){

         //   Intent myIntent = new Intent(this, Main2Activity.class);
          //  this.startActivity(myIntent);

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