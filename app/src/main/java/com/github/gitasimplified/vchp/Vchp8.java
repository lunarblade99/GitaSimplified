package com.github.gitasimplified.vchp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.appcompat.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import com.github.gitasimplified.Aboutus;
import com.github.gitasimplified.CloseActivity;
import com.github.gitasimplified.Main2Activity;
import com.github.gitasimplified.NewsAdapter2;
import com.github.gitasimplified.NewsItem;
import com.github.gitasimplified.R;
import com.github.gitasimplified.chp.Chp8;
import com.shashank.sony.fancygifdialoglib.FancyGifDialog;
import com.shashank.sony.fancygifdialoglib.FancyGifDialogListener;

import java.util.ArrayList;
import java.util.List;

public class Vchp8 extends AppCompatActivity
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
        navigationView.getMenu().getItem(7).setChecked(true);

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
        mData.add(new NewsItem("अर्जुन उवाच |\n" + "किं तद्ब्रह्म किमध्यात्मं किं कर्म पुरुषोत्तम |\n" + "अधिभूतं च किं प्रोक्तमधिदैवं किमुच्यते || 1||\n" + "अधियज्ञ: कथं कोऽत्र देहेऽस्मिन्मधुसूदन |\n" + "प्रयाणकाले च कथं ज्ञेयोऽसि नियतात्मभि: || 2||"," arjunaḥ uvācha—Arjun said; kim—what; tat—that; brahma—Brahman; kim—what; adhyātmam—the individual soul; kim—what; karma—the principle of karma; puruṣha-uttama—Shree Krishna, the Supreme Divine Personality; adhibhūtam—the material manifestation; cha—and; kim—what; proktam—is called; adhidaivam—the Lord of the celestial gods; kim—what; uchyate—is called; adhiyajñaḥ—the Lord all sacrificial performances; katham—how; kaḥ—who; atra—here; dehe—in body; asmin—this; madhusūdana—Shree Krishna, the killer of the demon named Madhu; prayāṇa-kāle—at the time of death; cha—and; katham—how; jñeyaḥ—to be known; asi—are (You); niyata-ātmabhiḥ—by those of steadfast mind ","arjuna uvācha\n" + "kiṁ tad brahma kim adhyātmaṁ kiṁ karma puruṣhottama\n" + "adhibhūtaṁ cha kiṁ proktam adhidaivaṁ kim uchyate\n" + "adhiyajñaḥ kathaṁ ko ’tra dehe ’smin madhusūdana\n" + "prayāṇa-kāle cha kathaṁ jñeyo ’si niyatātmabhiḥ",R.color.trans));
        mData.add(new NewsItem("श्रीभगवानुवाच |\n" + "अक्षरं ब्रह्म परमं स्वभावोऽध्यात्ममुच्यते |\n" + "भूतभावोद्भवकरो विसर्ग: कर्मसञ्ज्ञित: || 3||"," śhrī-bhagavān uvācha—the Blessed Lord said; akṣharam—indestructible; brahma—Brahman; paramam—the Supreme; svabhāvaḥ—nature; adhyātmam—one’s own self; uchyate—is called; bhūta-bhāva-udbhava-karaḥ—Actions pertaining to the material personality of living beings, and its development; visargaḥ—creation; karma—fruitive activities; sanjñitaḥ—are called\n","śhrī bhagavān uvācha\n" + "akṣharaṁ brahma paramaṁ svabhāvo ’dhyātmam uchyate\n" + "bhūta-bhāvodbhava-karo visargaḥ karma-sanjñitaḥ",R.color.trans));
        mData.add(new NewsItem("अधिभूतं क्षरो भाव: पुरुषश्चाधिदैवतम् |\n" + "अधियज्ञोऽहमेवात्र देहे देहभृतां वर || 4||"," adhibhūtam—the ever changing physical manifestation; kṣharaḥ—perishable; bhāvaḥ—nature; puruṣhaḥ—the cosmic personality of God, encompassing the material creation; cha—and; adhidaivatam—the Lord of the celestial gods; adhiyajñaḥ—the Lord of all sacrifices; aham—I; eva—certainly; atra—here; dehe—in the body; deha-bhṛitām—of the embodied; vara—O best ","adhibhūtaṁ kṣharo bhāvaḥ puruṣhaśh chādhidaivatam\n" + "adhiyajño ’ham evātra dehe deha-bhṛitāṁ vara",R.color.trans));
        mData.add(new NewsItem("अन्तकाले च मामेव स्मरन्मुक्त्वा कलेवरम् |\n" + "य: प्रयाति स मद्भावं याति नास्त्यत्र संशय: || 5||"," anta-kāle—at the time of death; cha—and; mām—Me; eva—alone; smaran—remembering; muktvā—relinquish; kalevaram—the body; yaḥ—who; prayāti—goes; saḥ—he; mat-bhāvam—Godlike nature; yāti—achieves; na—no; asti—there is; atra—here; sanśhayaḥ—doubt ","anta-kāle cha mām eva smaran muktvā kalevaram\n" + "yaḥ prayāti sa mad-bhāvaṁ yāti nāstyatra sanśhayaḥ",R.color.trans));
        mData.add(new NewsItem("यं यं वापि स्मरन्भावं त्यजत्यन्ते कलेवरम् |\n" + "तं तमेवैति कौन्तेय सदा तद्भावभावित: || 6||"," yam yam—whatever; vā—or; api—even; smaran—remembering; bhāvam—remembrance; tyajati—gives up; ante—in the end; kalevaram—the body; tam—to that; tam—to that; eva—certainly; eti—gets; kaunteya—Arjun, the son of Kunti; sadā—always; tat—that; bhāva-bhāvitaḥ—absorbed in contemplation ","yaṁ yaṁ vāpi smaran bhāvaṁ tyajatyante kalevaram\n" + "taṁ tam evaiti kaunteya sadā tad-bhāva-bhāvitaḥ",R.color.trans));
        mData.add(new NewsItem("तस्मात्सर्वेषु कालेषु मामनुस्मर युध्य च |\n" + "मय्यर्पितमनोबुद्धिर्मामेवैष्यस्यसंशयम् || 7||"," tasmāt—therefore; sarveṣhu—in all; kāleṣhu—times; mām—Me; anusmara—remember; yudhya—fight; cha—and; mayi—to Me; arpita—surrender; manaḥ—mind; buddhiḥ—intellect; mām—to Me; eva—surely; eṣhyasi—you shall attain; asanśhayaḥ—without a doubt ","tasmāt sarveṣhu kāleṣhu mām anusmara yudhya cha\n" + "mayyarpita-mano-buddhir mām evaiṣhyasyasanśhayam",R.color.trans));
        mData.add(new NewsItem("अभ्यासयोगयुक्तेन चेतसा नान्यगामिना |\n" + "परमं पुरुषं दिव्यं याति पार्थानुचिन्तयन् || 8||"," abhyāsa-yoga—by practice of yog; yuktena—being constantly engaged in remembrance; chetasā—by the mind; na anya-gāminā—without deviating; paramam puruṣham—the Supreme Divine Personality; divyam—divine; yāti—one attains; pārtha—Arjun, the son of Pritha; anuchintayan—constant remembrance ","abhyāsa-yoga-yuktena chetasā nānya-gāminā\n" + "paramaṁ puruṣhaṁ divyaṁ yāti pārthānuchintayan",R.color.trans));
        mData.add(new NewsItem("कविं पुराणमनुशासितार\n" + "मणोरणीयांसमनुस्मरेद्य: |\n" + "सर्वस्य धातारमचिन्त्यरूप\n" + "मादित्यवर्णं तमस: परस्तात् || 9||\n" + "प्रयाणकाले मनसाचलेन\n" + "भक्त्या युक्तो योगबलेन चैव |\n" + "भ्रुवोर्मध्ये प्राणमावेश्य सम्यक्\n" + "स तं परं पुरुषमुपैति दिव्यम् || 10||"," kavim—poet; purāṇam—ancient; anuśhāsitāram—the controller; aṇoḥ—than the atom; aṇīyānsam—smaller; anusmaret—always remembers; yaḥ—who; sarvasya—of everything; dhātāram—the support; achintya—inconceivable; rūpam—divine form; āditya-varṇam—effulgent like the sun; tamasaḥ—to the darkness of ignorance; parastāt—beyond; prayāṇa-kāle—at the time of death; manasā—mind; achalena—steadily; bhaktyā—remembering with great devotion; yuktaḥ—united; yoga-balena—through the power of yog; cha—and; eva—certainly; bhruvoḥ—the two eyebrows; madhye—between; prāṇam—life airs; āveśhya—fixing; samyak—completely; saḥ—he; tam—him; param puruṣham—the Supreme Divine Lord; upaiti—attains; divyam—divine ","kaviṁ purāṇam anuśhāsitāram\n" + "aṇor aṇīyānsam anusmared yaḥ\n" + "sarvasya dhātāram achintya-rūpam\n" + "āditya-varṇaṁ tamasaḥ parastāt\n" + "prayāṇa-kāle manasāchalena\n" + "bhaktyā yukto yoga-balena chaiva\n" + "bhruvor madhye prāṇam āveśhya samyak\n" + "sa taṁ paraṁ puruṣham upaiti divyam",R.color.trans));
        mData.add(new NewsItem("यदक्षरं वेदविदो वदन्ति\n" + "विशन्ति यद्यतयो वीतरागा: |\n" + "यदिच्छन्तो ब्रह्मचर्यं चरन्ति\n" + "तत्ते पदं संग्रहेण प्रवक्ष्ये || 11||"," yat—which; akṣharam—Imperishable; veda-vidaḥ—scholars of the Vedas; vadanti—describe; viśhanti—enter; yat—which; yatayaḥ—great ascetics; vīta-rāgāḥ—free from attachment; yat—which; ichchhantaḥ—desiring; brahmacharyam—celibacy; charanti—practice; tat—that; te—to you; padam—goal; saṅgraheṇa—briefly; pravakṣhye—I shall explain ","yad akṣharaṁ veda-vido vadanti\n" + "viśhanti yad yatayo vīta-rāgāḥ\n" + "yad ichchhanto brahmacharyaṁ charanti\n" + "tat te padaṁ saṅgraheṇa pravakṣhye",R.color.trans));
        mData.add(new NewsItem("सर्वद्वाराणि संयम्य मनो हृदि निरुध्य च |\n" + "मूर्ध्न्याधायात्मन: प्राणमास्थितो योगधारणाम् || 12||"," sarva-dvārāṇi—all gates; sanyamya—restraining; manaḥ—the mind; hṛidi—in the heart region; nirudhya—confining; cha—and; mūrdhni—in the head; ādhāya—establish; ātmanaḥ—of the self; prāṇam—the life breath; āsthitaḥ—situated (in); yoga-dhāraṇām—the yogic concentration ","sarva-dvārāṇi sanyamya mano hṛidi nirudhya cha\n" + "mūrdhnyādhāyātmanaḥ prāṇam āsthito yoga-dhāraṇām",R.color.trans));
        mData.add(new NewsItem("ओमित्येकाक्षरं ब्रह्म व्याहरन्मामनुस्मरन् |\n" + "य: प्रयाति त्यजन्देहं स याति परमां गतिम् || 13||"," om—sacred syllable representing the formless aspect of God; iti—thus; eka-akṣharam—one syllabled; brahma—the Absolute Truth; vyāharan—chanting; mām—Me (Shree Krishna); anusmaran—remembering; yaḥ—who; prayāti—departs; tyajan—quitting; deham—the body; saḥ—he; yāti—attains; paramām—the supreme; gatim—goal ","oṁ ityekākṣharaṁ brahma vyāharan mām anusmaran\n" + "yaḥ prayāti tyajan dehaṁ sa yāti paramāṁ gatim",R.color.trans));
        mData.add(new NewsItem("अनन्यचेता: सततं यो मां स्मरति नित्यश: |\n" + "तस्याहं सुलभ: पार्थ नित्ययुक्तस्य योगिन: || 14||"," ananya-chetāḥ—without deviation of the mind; satatam—always; yaḥ—who; mām—Me; smarati—remembers; nityaśhaḥ—regularly; tasya—to him; aham—I; su-labhaḥ—easily attainable; pārtha—Arjun, the son of Pritha; nitya—constantly; yuktasya—engaged; yoginaḥ—of the yogis ","ananya-chetāḥ satataṁ yo māṁ smarati nityaśhaḥ\n" + "tasyāhaṁ sulabhaḥ pārtha nitya-yuktasya yoginaḥ",R.color.trans));
        mData.add(new NewsItem("मामुपेत्य पुनर्जन्म दु:खालयमशाश्वतम् |\n" + "नाप्नुवन्ति महात्मान: संसिद्धिं परमां गता: || 15||"," mām—Me; upetya—having attained; punaḥ—again; janma—birth; duḥkha-ālayam—place full of miseries; aśhāśhvatam—temporary; na—never; āpnuvanti—attain; mahā-ātmānaḥ—the great souls; sansiddhim—perfection; paramām—highest; gatāḥ—having achieved ","mām upetya punar janma duḥkhālayam aśhāśhvatam\n" + "nāpnuvanti mahātmānaḥ sansiddhiṁ paramāṁ gatāḥ",R.color.trans));
        mData.add(new NewsItem("आब्रह्मभुवनाल्लोका: पुनरावर्तिनोऽर्जुन |\n" + "मामुपेत्य तु कौन्तेय पुनर्जन्म न विद्यते || 16||"," ā-brahma-bhuvanāt—up to the abode of Brahma; lokāḥ—worlds; punaḥ āvartinaḥ—subject to rebirth; arjuna—Arjun; mām—Mine; upetya—having attained; tu—but; kaunteya—Arjun, the son of Kunti; punaḥ janma—rebirth; na—never; vidyate—is ","ā-brahma-bhuvanāl lokāḥ punar āvartino ’rjuna\n" + "mām upetya tu kaunteya punar janma na vidyate",R.color.trans));
        mData.add(new NewsItem("सहस्रयुगपर्यन्तमहर्यद्ब्रह्मणो विदु: |\n" + "रात्रिं युगसहस्रान्तां तेऽहोरात्रविदो जना: || 17||"," sahasra—one thousand; yuga—age; paryantam—until; ahaḥ—one day; yat—which; brahmaṇaḥ—of Brahma; viduḥ—know; rātrim—night; yuga-sahasra-antām—lasts one thousand yugas; te—they; ahaḥ-rātra-vidaḥ—those who know his day and night; janāḥ—people ","sahasra-yuga-paryantam ahar yad brahmaṇo viduḥ\n" + "rātriṁ yuga-sahasrāntāṁ te ’ho-rātra-vido janāḥ",R.color.trans));
        mData.add(new NewsItem("अव्यक्ताद्व्यक्तय: सर्वा: प्रभवन्त्यहरागमे |\n" + "रात्र्यागमे प्रलीयन्ते तत्रैवाव्यक्तसञ्ज्ञके || 18||"," avyaktāt—from the unmanifested; vyaktayaḥ—the manifested; sarvāḥ—all; prabhavanti—emanate; ahaḥ-āgame—at the advent of Brahma’s day; rātri-āgame—at the fall of Brahma’s night; pralīyante—they dissolve; tatra—into that; eva—certainly; avyakta-sanjñake—in that which is called the unmanifest ","avyaktād vyaktayaḥ sarvāḥ prabhavantyahar-āgame\n" + "rātryāgame pralīyante tatraivāvyakta-sanjñake",R.color.trans));
        mData.add(new NewsItem("भूतग्राम: स एवायं भूत्वा भूत्वा प्रलीयते |\n" + "रात्र्यागमेऽवश: पार्थ प्रभवत्यहरागमे || 19||"," bhūta-grāmaḥ—the multitude of beings; saḥ—these; eva—certainly; ayam—this; bhūtvā bhūtvā—repeatedly taking birth; pralīyate—dissolves; rātri-āgame—with the advent of night; avaśhaḥ—helpless; pārtha—Arjun, the son of Pritha; prabhavati—become manifest; ahaḥ-āgame—with the advent of day ","bhūta-grāmaḥ sa evāyaṁ bhūtvā bhūtvā pralīyate\n" + "rātryāgame ’vaśhaḥ pārtha prabhavatyahar-āgame",R.color.trans));
        mData.add(new NewsItem("परस्तस्मात्तु भावोऽन्योऽव्यक्तोऽव्यक्तात्सनातन: |\n" + "य: स सर्वेषु भूतेषु नश्यत्सु न विनश्यति || 20||"," paraḥ—transcendental; tasmāt—than that; tu—but; bhāvaḥ—creation; anyaḥ—another; avyaktaḥ—unmanifest; avyaktāt—to the unmanifest; sanātanaḥ—eternal; yaḥ—who; saḥ—that; sarveṣhu—all; bhūteṣhu—in beings; naśhyatsu—cease to exist; na—never; vinaśhyati—is annihilated ","paras tasmāt tu bhāvo ’nyo ’vyakto ’vyaktāt sanātanaḥ\n" + "yaḥ sa sarveṣhu bhūteṣhu naśhyatsu na vinaśhyati",R.color.trans));
        mData.add(new NewsItem("अव्यक्तोऽक्षर इत्युक्तस्तमाहु: परमां गतिम् |\n" + "यं प्राप्य न निवर्तन्ते तद्धाम परमं मम || 21||"," avyaktaḥ—unmanifest; akṣharaḥ—imperishable; iti—thus; uktaḥ—is said; tam—that; āhuḥ—is called; paramām—the supreme; gatim—destination; yam—which; prāpya—having reached; na—never; nivartante—come back; tat—that; dhāma—Abode; paramam—the supreme; mama—My ","avyakto ’kṣhara ityuktas tam āhuḥ paramāṁ gatim\n" + "yaṁ prāpya na nivartante tad dhāma paramaṁ mama",R.color.trans));
        mData.add(new NewsItem("पुरुष: स पर: पार्थ भक्त्या लभ्यस्त्वनन्यया |\n" + "यस्यान्त:स्थानि भूतानि येन सर्वमिदं ततम् || 22||"," puruṣhaḥ—the Supreme Divine Personality; saḥ—he; paraḥ—greatest; pārtha—Arjun, the son of Pritha; bhaktyā—through devotion; labhyaḥ—is attainable; tu—indeed; ananyayā—without another; yasya—of whom; antaḥ-sthāni—situated within; bhūtāni—beings; yena—by whom; sarvam—all; idam—this; tatam—is pervaded ","puruṣhaḥ sa paraḥ pārtha bhaktyā labhyas tvananyayā\n" + "yasyāntaḥ-sthāni bhūtāni yena sarvam idaṁ tatam",R.color.trans));
        mData.add(new NewsItem("यत्र काले त्वनावृत्तिमावृत्तिं चैव योगिन: |\n" + "प्रयाता यान्ति तं कालं वक्ष्यामि भरतर्षभ || 23||\n" + "अग्निर्ज्योतिरह: शुक्ल: षण्मासा उत्तरायणम् |\n" + "तत्र प्रयाता गच्छन्ति ब्रह्म ब्रह्मविदो जना: || 24||\n" + "धूमो रात्रिस्तथा कृष्ण: षण्मासा दक्षिणायनम् |\n" + "तत्र चान्द्रमसं ज्योतिर्योगी प्राप्य निवर्तते || 25||\n" + "शुक्लकृष्णे गती ह्येते जगत: शाश्वते मते |\n" + "एकया यात्यनावृत्तिमन्ययावर्तते पुन: || 26||"," yatra—where; kāle—time; tu—certainly; anāvṛittim—no return; āvṛittim—return; cha—and; eva—certainly; yoginaḥ—a yogi; prayātāḥ—having departed; yānti—attain; tam—that; kālam—time; vakṣhyāmi—I shall describe; bharata-ṛiṣhabha—Arjun, the best of the Bharatas; agniḥ—fire; jyotiḥ—light; ahaḥ—day; śhuklaḥ—the bright fortnight of the moon; ṣhaṭ-māsāḥ—six months; uttara-ayanam—the sun’s northern course; tatra—there; prayātāḥ—departed; gachchhanti—go; brahma—Brahman; brahma-vidaḥ—those who know the Brahman; janāḥ—persons; dhūmaḥ—smoke; rātriḥ—night; tathā—and; kṛiṣhṇaḥ—the dark fortnight of the moon; ṣhaṭ-māsāḥ—six months; dakṣhiṇa-ayanam—the sun’s southern course; tatra—there; chāndra-masam—lunar; jyotiḥ—light; yogī—a yogi; prāpya—attain; nivartate—comes back; śhukla—bright; kṛiṣhṇe—dark; gatī—paths; hi—certainly; ete—these; jagataḥ—of the material world; śhāśhvate—eternal; mate—opinion; ekayā—by one; yāti—goes; anāvṛittim—to non return; anyayā—by the other; āvartate—comes back; punaḥ—again ","yatra kāle tvanāvṛittim āvṛittiṁ chaiva yoginaḥ\n" + "prayātā yānti taṁ kālaṁ vakṣhyāmi bharatarṣhabha\n" + "agnir jyotir ahaḥ śhuklaḥ ṣhaṇ-māsā uttarāyaṇam\n" + "tatra prayātā gachchhanti brahma brahma-vido janāḥ\n" + "dhūmo rātris tathā kṛiṣhṇaḥ ṣhaṇ-māsā dakṣhiṇāyanam\n" + "tatra chāndramasaṁ jyotir yogī prāpya nivartate\n" + "śhukla-kṛiṣhṇe gatī hyete jagataḥ śhāśhvate mate\n" + "ekayā yātyanāvṛittim anyayāvartate punaḥ",R.color.trans));
        mData.add(new NewsItem("नैते सृती पार्थ जानन्योगी मुह्यति कश्चन |\n" + "तस्मात्सर्वेषु कालेषु योगयुक्तो भवार्जुन || 27||"," na—never; ete—these two; sṛitī—paths; pārtha—Arjun, the son of Pritha; jānan—knowing; yogī—a yogi; muhyati—bewildered; kaśhchana—any; tasmāt—therefore; sarveṣhu kāleṣhu—always; yoga-yuktaḥ—situated in Yog; bhava—be; arjuna—Arjun ","naite sṛitī pārtha jānan yogī muhyati kaśhchana\n" + "tasmāt sarveṣhu kāleṣhu yoga-yukto bhavārjuna",R.color.trans));
        mData.add(new NewsItem("वेदेषु यज्ञेषु तप:सु चैव\n" + "दानेषु यत्पुण्यफलं प्रदिष्टम् |\n" + "अत्येति तत्सर्वमिदं विदित्वा\n" + "योगी परं स्थानमुपैति चाद्यम् || 28||"," vedeṣhu—in the study of the Vedas; yajñeṣhu—in performance of sacrifices; tapaḥsu—in austerities; cha—and; eva—certainly; dāneṣhu—in giving charities; yat—which; puṇya-phalam—fruit of merit; pradiṣhṭam—is gained; atyeti—surpasses; tat sarvam—all; idam—this; viditvā—having known; yogī—a yogi; param—Supreme; sthānam—Abode; upaiti—achieves; cha—and; ādyam—original ","vedeṣhu yajñeṣhu tapaḥsu chaiva\n" + "dāneṣhu yat puṇya-phalaṁ pradiṣhṭam\n" + "atyeti tat sarvam idaṁ viditvā\n" + "yogī paraṁ sthānam upaiti chādyam",R.color.trans));

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
                            Intent intent = new Intent(Vchp8.this, CloseActivity.class);
                            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                            startActivity(intent);                        }
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

            Intent myIntent = new Intent(this, Chp8.class);
            this.startActivity(myIntent);

        }

        if (id == R.id.verses){

        //    Intent myIntent = new Intent(this, Main2Activity.class);
          //  this.startActivity(myIntent);

        }

        if (id == R.id.explain){

            //   Intent myIntent = new Intent(this, Explaination.class);
            //   this.startActivity(myIntent);

            new FancyGifDialog.Builder(Vchp8.this)
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