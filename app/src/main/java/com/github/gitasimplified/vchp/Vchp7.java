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
import com.github.gitasimplified.chp.Chp7;

import java.util.ArrayList;
import java.util.List;

public class Vchp7 extends AppCompatActivity
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
        navigationView.getMenu().getItem(6).setChecked(true);

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
        mData.add(new NewsItem("श्रीभगवानुवाच |\n" + "मय्यासक्तमना: पार्थ योगं युञ्जन्मदाश्रय: |\n" + "असंशयं समग्रं मां यथा ज्ञास्यसि तच्छृणु || 1||"," śhrī-bhagavān uvācha—the Supreme Lord said; mayi—to me; āsakta-manāḥ—with the mind attached; pārtha—Arjun, the son of Pritha; yogam—bhakti yog; yuñjan—practicing; mat-āśhrayaḥ—surrendering to me; asanśhayam—free from doubt; samagram—completely; mām—me; yathā—how; jñāsyasi—you shall know; tat—that; śhṛiṇu—listen ","śhrī bhagavān uvācha\n" + "mayyāsakta-manāḥ pārtha yogaṁ yuñjan mad-āśhrayaḥ\n" + "asanśhayaṁ samagraṁ māṁ yathā jñāsyasi tach chhṛiṇu",R.color.trans));
        mData.add(new NewsItem("ज्ञानं तेऽहं सविज्ञानमिदं वक्ष्याम्यशेषत: |\n" + "यज्ज्ञात्वा नेह भूयोऽन्यज्ज्ञातव्यमवशिष्यते || 2||"," jñānam—knowledge; te—unto you; aham—I; sa—with; vijñānam—wisdom; idam—this; vakṣhyāmi—shall reveal; aśheṣhataḥ—in full; yat—which; jñātvā—having known; na—not; iha—in this world; bhūyaḥ—further; anyat—anything else; jñātavyam—to be known; avaśhiṣhyate—remains ","jñānaṁ te ’haṁ sa-vijñānam idaṁ vakṣhyāmyaśheṣhataḥ\n" + "yaj jñātvā neha bhūyo ’nyaj jñātavyam-avaśhiṣhyate",R.color.trans));
        mData.add(new NewsItem("मनुष्याणां सहस्रेषु कश्चिद्यतति सिद्धये |\n" + "यततामपि सिद्धानां कश्चिन्मां वेत्ति तत्वत: || 3||"," manuṣhyāṇām—of men; sahasreṣhu—out of many thousands; kaśhchit—someone; yatati—strives; siddhaye—for perfection; yatatām—of those who strive; api—even; siddhānām—of those who have achieved perfection; kaśhchit—someone; mām—me; vetti—knows; tattvataḥ—in truth ","manuṣhyāṇāṁ sahasreṣhu kaśhchid yatati siddhaye\n" + "yatatām api siddhānāṁ kaśhchin māṁ vetti tattvataḥ",R.color.trans));
        mData.add(new NewsItem("भूमिरापोऽनलो वायु: खं मनो बुद्धिरेव च |\n" + "अहङ्कार इतीयं मे भिन्ना प्रकृतिरष्टधा || 4||"," bhūmiḥ—earth; āpaḥ—water; analaḥ—fire; vāyuḥ—air; kham—space; manaḥ—mind; buddhiḥ—intellect; eva—certainly; cha—and; ahankāraḥ—ego; iti—thus; iyam—all these; me—my; bhinnā—divisions; prakṛitiḥ—material energy; aṣhṭadhā—eightfold ","bhūmir-āpo ’nalo vāyuḥ khaṁ mano buddhir eva cha\n" + "ahankāra itīyaṁ me bhinnā prakṛitir aṣhṭadhā",R.color.trans));
        mData.add(new NewsItem("अपरेयमितस्त्वन्यां प्रकृतिं विद्धि मे पराम् |\n" + "जीवभूतां महाबाहो ययेदं धार्यते जगत् || 5||"," aparā—inferior; iyam—this; itaḥ—besides this; tu—but; anyām—another; prakṛitim—energy; viddhi—know; me—my; parām—superior; jīva-bhūtām—living beings; mahā-bāho—mighty-armed one; yayā—by whom; idam—this; dhāryate—the basis; jagat—the material world ","apareyam itas tvanyāṁ prakṛitiṁ viddhi me parām\n" + "jīva-bhūtāṁ mahā-bāho yayedaṁ dhāryate jagat",R.color.trans));
        mData.add(new NewsItem("एतद्योनीनि भूतानि सर्वाणीत्युपधारय |\n" + "अहं कृत्स्नस्य जगत: प्रभव: प्रलयस्तथा || 6||"," etat yonīni—these two (energies) are the source of; bhūtāni—living beings; sarvāṇi—all; iti—that; upadhāraya—know; aham—I; kṛitsnasya—entire; jagataḥ—creation; prabhavaḥ—the source; pralayaḥ—dissolution; tathā—and ","etad-yonīni bhūtāni sarvāṇītyupadhāraya\n" + "ahaṁ kṛitsnasya jagataḥ prabhavaḥ pralayas tathā",R.color.trans));
        mData.add(new NewsItem("मत्त: परतरं नान्यत्किञ्चिदस्ति धनञ्जय |\n" + "मयि सर्वमिदं प्रोतं सूत्रे मणिगणा इव || 7||"," mattaḥ—than me; para-taram—superior; na—not; anyat kiñchit—anything else; asti—there is; dhanañjaya—Arjun, conqueror of wealth; mayi—in me; sarvam—all; idam—which we see; protam—is strung; sūtre—on a thread; maṇi-gaṇāḥ—beads; iva—like ","mattaḥ parataraṁ nānyat kiñchid asti dhanañjaya\n" + "mayi sarvam idaṁ protaṁ sūtre maṇi-gaṇā iva",R.color.trans));
        mData.add(new NewsItem("रसोऽहमप्सु कौन्तेय प्रभास्मि शशिसूर्ययो: |\n" + "प्रणव: सर्ववेदेषु शब्द: खे पौरुषं नृषु || 8||"," rasaḥ—taste; aham—I; apsu—in water; kaunteya—Arjun, the son of Kunti; prabhā—the radiance; asmi—I am; śhaśhi-sūryayoḥ—of the moon and the sun; praṇavaḥ—the sacred syllable Om; sarva—in all; vedeṣhu—Vedas; śhabdaḥ—sound; khe—in ether; pauruṣham—ability; nṛiṣhu—in humans ","raso ’ham apsu kaunteya prabhāsmi śhaśhi-sūryayoḥ\n" + "praṇavaḥ sarva-vedeṣhu śhabdaḥ khe pauruṣhaṁ nṛiṣhu",R.color.trans));
        mData.add(new NewsItem("पुण्यो गन्ध: पृथिव्यां च तेजश्चास्मि विभावसौ |\n" + "जीवनं सर्वभूतेषु तपश्चास्मि तपस्विषु || 9||"," puṇyaḥ—pure; gandhaḥ—fragrance; pṛithivyām—of the earth; cha—and; tejaḥ—brilliance; cha—and; asmi—I am; vibhāvasau—in the fire; jīvanam—the life-force; sarva—in all; bhūteṣhu—beings; tapaḥ—penance; cha—and; asmi—I am; tapasviṣhu—of the ascetics ","puṇyo gandhaḥ pṛithivyāṁ cha tejaśh chāsmi vibhāvasau\n" + "jīvanaṁ sarva-bhūteṣhu tapaśh chāsmi tapasviṣhu",R.color.trans));
        mData.add(new NewsItem("बीजं मां सर्वभूतानां विद्धि पार्थ सनातनम् |\n" + "बुद्धिर्बुद्धिमतामस्मि तेजस्तेजस्विनामहम् || 10||"," bījam—the seed; mām—me; sarva-bhūtānām—of all beings; viddhi—know; pārtha—Arjun, the son of Pritha; sanātanam—the eternal; buddhiḥ—intellect; buddhi-matām—of the intelligent; asmi—(I) am; tejaḥ—splendor; tejasvinām—of the splendid; aham—I ","bījaṁ māṁ sarva-bhūtānāṁ viddhi pārtha sanātanam\n" + "buddhir buddhimatām asmi tejas tejasvinām aham",R.color.trans));
        mData.add(new NewsItem("बलं बलवतां चाहं कामरागविवर्जितम् |\n" + "धर्माविरुद्धो भूतेषु कामोऽस्मि भरतर्षभ || 11||"," balam—strength; bala-vatām—of the strong; cha—and; aham—I; kāma—desire; rāga—passion; vivarjitam—devoid of; dharma-aviruddhaḥ—not conflicting with dharma; bhūteṣhu—in all beings; kāmaḥ—sexual activity; asmi—(I) am; bharata-ṛiṣhabha—Arjun, the best of the Bharats ","balaṁ balavatāṁ chāhaṁ kāma-rāga-vivarjitam\n" + "dharmāviruddho bhūteṣhu kāmo ’smi bharatarṣhabha",R.color.trans));
        mData.add(new NewsItem("ये चैव सात्विका भावा राजसास्तामसाश्च ये |\n" + "मत्त एवेति तान्विद्धि न त्वहं तेषु ते मयि || 12||"," ye—whatever; cha—and; eva—certainly; sāttvikāḥ—in the mode of goodness; bhāvāḥ—states of material existence; rājasāḥ—in the mode of passion; tāmasāḥ—in the mode of ignorance; cha—and; ye—whatever; mattaḥ—from me; eva—certainly; iti—thus; tān—those; viddhi—know; na—not; tu—but; aham—I; teṣhu—in them; te—they; mayi—in me ","ye chaiva sāttvikā bhāvā rājasās tāmasāśh cha ye\n" + "matta eveti tān viddhi na tvahaṁ teṣhu te mayi",R.color.trans));
        mData.add(new NewsItem("त्रिभिर्गुणमयैर्भावैरेभि: सर्वमिदं जगत् |\n" + "मोहितं नाभिजानाति मामेभ्य: परमव्ययम् || 13||"," tribhiḥ—by three; guṇa-mayaiḥ—consisting of the modes of material nature; bhāvaiḥ—states; ebhiḥ—all these; sarvam—whole; idam—this; jagat—universe; mohitam—deluded; na—not; abhijānāti—know; mām—me; ebhyaḥ—these; param—the supreme; avyayam—imperishable ","tribhir guṇa-mayair bhāvair ebhiḥ sarvam idaṁ jagat\n" + "mohitaṁ nābhijānāti māmebhyaḥ param avyayam",R.color.trans));
        mData.add(new NewsItem("दैवी ह्येषा गुणमयी मम माया दुरत्यया |\n" + "मामेव ये प्रपद्यन्ते मायामेतां तरन्ति ते || 14||"," daivī—divine; hi—certainly; eṣhā—this; guṇa-mayī—consisting of the three modes of nature; mama—my; māyā—one of God’s energies. It that veils God’s true nature from souls who have not yet attained the eligibility for God-realization; duratyayā—very difficult to overcome; mām—unto me; eva—certainly; ye—who; prapadyante—surrender; māyām etām—this Maya; taranti—cross over; te—they ","daivī hyeṣhā guṇa-mayī mama māyā duratyayā\n" + "mām eva ye prapadyante māyām etāṁ taranti te",R.color.trans));
        mData.add(new NewsItem("न मां दुष्कृतिनो मूढा: प्रपद्यन्ते नराधमा: |\n" + "माययापहृतज्ञाना आसुरं भावमाश्रिता: || 15||"," na—not; mām—unto me; duṣhkṛitinaḥ—the evil doers; mūḍhāḥ—the ignorant; prapadyante—surrender; nara-adhamāḥ—one who lazily follows one’s lower nature; māyayā—by God’s material energy; apahṛita jñānāḥ—those with deluded intellect; āsuram—demoniac; bhāvam—nature; āśhritāḥ—surrender ","na māṁ duṣhkṛitino mūḍhāḥ prapadyante narādhamāḥ\n" + "māyayāpahṛita-jñānā āsuraṁ bhāvam āśhritāḥ",R.color.trans));
        mData.add(new NewsItem("चतुर्विधा भजन्ते मां जना: सुकृतिनोऽर्जुन |\n" + "आर्तो जिज्ञासुरर्थार्थी ज्ञानी च भरतर्षभ || 16||"," chatuḥ-vidhāḥ—four kinds; bhajante—worship; mām—me; janāḥ—people; su-kṛitinaḥ—those who are pious; arjuna—Arjun; ārtaḥ—the distressed; jijñāsuḥ—the seekers of knowledge; artha-arthī—the seekers of material gain; jñānī—those who are situated in knowledge; cha—and; bharata-ṛiṣhabha—The best amongst the Bharatas, Arjun ","chatur-vidhā bhajante māṁ janāḥ sukṛitino ’rjuna\n" + "ārto jijñāsur arthārthī jñānī cha bharatarṣhabha",R.color.trans));
        mData.add(new NewsItem("तेषां ज्ञानी नित्ययुक्त एकभक्तिर्विशिष्यते |\n" + "प्रियो हि ज्ञानिनोऽत्यर्थमहं स च मम प्रिय: || 17||"," teṣhām—amongst these; jñānī—those who are situated in knowledge; nitya-yuktaḥ—ever steadfast; eka—exclusively; bhaktiḥ—devotion; viśhiṣhyate—highest; priyaḥ—very dear; hi—certainly; jñāninaḥ—to the person in knowledge; atyartham—highly; aham—I; saḥ—he; cha—and; mama—to me; priyaḥ—dear ","teṣhāṁ jñānī nitya-yukta eka-bhaktir viśhiṣhyate\n" + "priyo hi jñānino ’tyartham ahaṁ sa cha mama priyaḥ",R.color.trans));
        mData.add(new NewsItem("उदारा: सर्व एवैते ज्ञानी त्वात्मैव मे मतम् |\n" + "आस्थित: स हि युक्तात्मा मामेवानुत्तमां गतिम् || 18||"," udārāḥ—noble; sarve—all; eva—indeed; ete—these; jñānī—those in knowledge; tu—but; ātmā eva—my very self; me—my; matam—opinion; āsthitaḥ—situated; saḥ—he; hi—certainly; yukta-ātmā—those who are united; mām—in me; eva—certainly; anuttamām—the supreme; gatim—goal ","udārāḥ sarva evaite jñānī tvātmaiva me matam\n" + "āsthitaḥ sa hi yuktātmā mām evānuttamāṁ gatim",R.color.trans));
        mData.add(new NewsItem("बहूनां जन्मनामन्ते ज्ञानवान्मां प्रपद्यते |\n" + "वासुदेव: सर्वमिति स महात्मा सुदुर्लभ: || 19||"," bahūnām—many; janmanām—births; ante—after; jñāna-vān—one who is endowed with knowledge; mām—unto me; prapadyate—surrenders; vāsudevaḥ—Shree Krishna, the son of Vasudev; sarvam—all; iti—that; saḥ—that; mahā-ātmā—great soul; su-durlabhaḥ—very rare ","bahūnāṁ janmanām ante jñānavān māṁ prapadyate\n" + "vāsudevaḥ sarvam iti sa mahātmā su-durlabhaḥ",R.color.trans));
        mData.add(new NewsItem("कामैस्तैस्तैर्हृतज्ञाना: प्रपद्यन्तेऽन्यदेवता: |\n" + "तं तं नियममास्थाय प्रकृत्या नियता: स्वया || 20||"," kāmaiḥ—by material desires; taiḥ taiḥ—by various; hṛita-jñānāḥ—whose knowledge has been carried away; prapadyante—surrender; anya—to other; devatāḥ—celestial gods; tam tam—the various; niyamam—rules and regulations; āsthāya—following; prakṛityā—by nature; niyatāḥ—controlled; svayā—by their own ","kāmais tais tair hṛita-jñānāḥ prapadyante ’nya-devatāḥ\n" + "taṁ taṁ niyamam āsthāya prakṛityā niyatāḥ svayā",R.color.trans));
        mData.add(new NewsItem("यो यो यां यां तनुं भक्त: श्रद्धयार्चितुमिच्छति |\n" + "तस्य तस्याचलां श्रद्धां तामेव विदधाम्यहम् || 21||"," yaḥ yaḥ—whoever; yām yām—whichever; tanum—form; bhaktaḥ—devotee; śhraddhayā—with faith; architum—to worship; ichchhati—desires; tasya tasya—to him; achalām—steady; śhraddhām—faith; tām—in that; eva—certainly; vidadhāmi—bestow; aham—I ","yo yo yāṁ yāṁ tanuṁ bhaktaḥ śhraddhayārchitum ichchhati\n" + "tasya tasyāchalāṁ śhraddhāṁ tām eva vidadhāmyaham",R.color.trans));
        mData.add(new NewsItem("स तया श्रद्धया युक्तस्तस्याराधनमीहते |\n" + "लभते च तत: कामान्मयैव विहितान्हि तान् || 22||"," saḥ—he; tayā—with that; śhraddhayā—faith; yuktaḥ—endowed with; tasya—of that; ārādhanam—worship; īhate—tries to engange in; labhate—obtains; cha—and; tataḥ—from that; kāmān—desires; mayā—by me; eva—alone; vihitān—granted; hi—certainly; tān—those ","sa tayā śhraddhayā yuktas tasyārādhanam īhate\n" + "labhate cha tataḥ kāmān mayaiva vihitān hi tān",R.color.trans));
        mData.add(new NewsItem("अन्तवत्तु फलं तेषां तद्भवत्यल्पमेधसाम् |\n" + "देवान्देवयजो यान्ति मद्भक्ता यान्ति मामपि || 23||"," anta-vat—perishable; tu—but; phalam—fruit; teṣhām—by them; tat—that; bhavati—is; alpa-medhasām—people of small understanding; devān—to the celestial gods; deva-yajaḥ—the worshipers of the celestial gods; yānti—go; mat—my; bhaktāḥ—devotees; yānti—go; mām—to me; api—whereas ","antavat tu phalaṁ teṣhāṁ tad bhavatyalpa-medhasām\n" + "devān deva-yajo yānti mad-bhaktā yānti mām api",R.color.trans));
        mData.add(new NewsItem("अव्यक्तं व्यक्तिमापन्नं मन्यन्ते मामबुद्धय: |\n" + "परं भावमजानन्तो ममाव्ययमनुत्तमम् || 24||"," avyaktam—formless; vyaktim—possessing a personality; āpannam—to have assumed; manyante—think; mām—me; abuddhayaḥ—less intelligent; param—Supreme; bhāvam—nature; ajānantaḥ—not understanding; mama—my; avyayam—imperishable; anuttamam—excellent ","avyaktaṁ vyaktim āpannaṁ manyante mām abuddhayaḥ\n" + "paraṁ bhāvam ajānanto mamāvyayam anuttamam",R.color.trans));
        mData.add(new NewsItem("नाहं प्रकाश: सर्वस्य योगमायासमावृत: |\n" + "मूढोऽयं नाभिजानाति लोको मामजमव्ययम् || 25||"," na—not; aham—I; prakāśhaḥ—manifest; sarvasya—to everyone; yoga-māyā—God’s supreme (divine) energy; samāvṛitaḥ—veiled; mūḍhaḥ—deluded; ayam—these; na—not; abhijānāti—know; lokaḥ—persons; mām—me; ajam—unborn; avyayam—immutable ","nāhaṁ prakāśhaḥ sarvasya yoga-māyā-samāvṛitaḥ\n" + "mūḍho ’yaṁ nābhijānāti loko mām ajam avyayam",R.color.trans));
        mData.add(new NewsItem("वेदाहं समतीतानि वर्तमानानि चार्जुन |\n" + "भविष्याणि च भूतानि मां तु वेद न कश्चन || 26||"," veda—know; aham—I; samatītāni—the past; vartamānāni—the present; cha—and; arjuna—Arjun; bhaviṣhyāṇi—the future; cha—also; bhūtāni—all living beings; mām—me; tu—but; veda—knows; na kaśhchana—no one ","vedāhaṁ samatītāni vartamānāni chārjuna\n" + "bhaviṣhyāṇi cha bhūtāni māṁ tu veda na kaśhchana",R.color.trans));
        mData.add(new NewsItem("इच्छाद्वेषसमुत्थेन द्वन्द्वमोहेन भारत |\n" + "सर्वभूतानि सम्मोहं सर्गे यान्ति परन्तप || 27||"," ichchhā—desire; dveṣha—aversion; samutthena—arise from; dvandva—of duality; mohena—from the illusion; bhārata—Arjun, descendant of Bharat; sarva—all; bhūtāni—living beings; sammoham—into delusion; sarge—since birth; yānti—enter; parantapa—Arjun, conqueror of enemies ","ichchhā-dveṣha-samutthena dvandva-mohena bhārata\n" + "sarva-bhūtāni sammohaṁ sarge yānti parantapa",R.color.trans));
        mData.add(new NewsItem("येषां त्वन्तगतं पापं जनानां पुण्यकर्मणाम् |\n" + "ते द्वन्द्वमोहनिर्मुक्ता भजन्ते मां दृढव्रता: || 28||"," yeṣhām—whose; tu—but; anta-gatam—completely destroyed; pāpam—sins; janānām—of persons; puṇya—pious; karmaṇām—activities; te—they; dvandva—of dualities; moha—illusion; nirmuktāḥ—free from; bhajante—worship;mām; dṛiḍha-vratāḥ—with determination ","yeṣhāṁ tvanta-gataṁ pāpaṁ janānāṁ puṇya-karmaṇām\n" + "te dvandva-moha-nirmuktā bhajante māṁ dṛiḍha-vratāḥ",R.color.trans));
        mData.add(new NewsItem("जरामरणमोक्षाय मामाश्रित्य यतन्ति ये |\n" + "ते ब्रह्म तद्विदु: कृत्स्नमध्यात्मं कर्म चाखिलम् || 29||"," jarā—from old age; maraṇa—and death; mokṣhāya—for liberation; mām—me; āśhritya—take shelter in; yatanti—strive; ye—who; te—they; brahma—Brahman; tat—that; viduḥ—know; kṛitsnam—everything; adhyātmam—the individual self; karma—karmic action; cha—and; akhilam—entire ","jarā-maraṇa-mokṣhāya mām āśhritya yatanti ye\n" + "te brahma tadviduḥ kṛitsnam adhyātmaṁ karma chākhilam",R.color.trans));
        mData.add(new NewsItem("साधिभूताधिदैवं मां साधियज्ञं च ये विदु: |\n" + "प्रयाणकालेऽपि च मां ते विदुर्युक्तचेतस: || 30||"," sa-adhibhūta—governing principle of the field of matter; adhidaivam—governing principle of the celestial gods; mām—me; sa-adhiyajñam—governing principle of the Lord all sacrificial performances; cha—and; ye—who; viduḥ—know; prayāṇa—of death; kāle—at the time; api—even; cha—and; mām—me; te—they; viduḥ—know; yukta-chetasaḥ—in full consciousness of me ","sādhibhūtādhidaivaṁ māṁ sādhiyajñaṁ cha ye viduḥ\n" + "prayāṇa-kāle ’pi cha māṁ te vidur yukta-chetasaḥ",R.color.trans));

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

            Intent myIntent = new Intent(this, Chp7.class);
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