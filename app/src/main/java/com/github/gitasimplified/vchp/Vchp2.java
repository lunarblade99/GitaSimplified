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
import com.github.gitasimplified.chp.Chp2;
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
        mData.add(new NewsItem("सञ्जय उवाच |\n" + "तं तथा कृपयाविष्टमश्रुपूर्णाकुलेक्षणम् |\n" + "विषीदन्तमिदं वाक्यमुवाच मधुसूदन: || 1||"," sañjayaḥ uvācha—Sanjay said; tam—to him (Arjun); tathā—thus; kṛipayā—with pity; āviṣhṭam—overwhelmed; aśhru-pūrṇa—full of tears; ākula—distressed; īkṣhaṇam—eyes; viṣhīdantam—grief-stricken; idam—these; vākyam—words; uvācha—said; madhusūdanaḥ—Shree Krishn, slayer of the Madhu demon ","\n" + "\n" + "sañjaya uvācha\n" + "taṁ tathā kṛipayāviṣhṭamaśhru pūrṇākulekṣhaṇam\n" + "viṣhīdantamidaṁ vākyam uvācha madhusūdanaḥ\n",R.color.trans));
        mData.add(new NewsItem("श्रीभगवानुवाच |\n" + "कुतस्त्वा कश्मलमिदं विषमे समुपस्थितम् |\n" + "अनार्यजुष्टमस्वर्ग्यमकीर्तिकरमर्जुन || 2||"," śhrī-bhagavān uvācha—the Supreme Lord said; kutaḥ—wherefrom; tvā—to you; kaśhmalam—delusion; idam—this; viṣhame—in this hour of peril; samupasthitam—overcome; anārya—crude person; juṣhṭam—practiced; aswargyam—which does not lead to the higher abodes; akīrti-karam—leading to disgrace; arjuna—Arjun ","śhrī bhagavān uvācha\n" + "kutastvā kaśhmalamidaṁ viṣhame samupasthitam\n" + "anārya-juṣhṭamaswargyam akīrti-karam arjuna",R.color.trans));
        mData.add(new NewsItem("क्लैब्यं मा स्म गम: पार्थ नैतत्तवय्युपपद्यते |\n" + "क्षुद्रं हृदयदौर्बल्यं त्यक्त्वोत्तिष्ठ परन्तप || 3||"," klaibyam—unmanliness; mā sma—do not; gamaḥ—yield to; pārtha—Arjun, the son of Pritha; na—not; etat—this; tvayi—to you; upapadyate—befitting; kṣhudram—petty; hṛidaya—heart; daurbalyam—weakness; tyaktvā—giving up; uttiṣhṭha—arise; param-tapa—conqueror of enemies ","klaibyaṁ mā sma gamaḥ pārtha naitat tvayyupapadyate\n" + "kṣhudraṁ hṛidaya-daurbalyaṁ tyaktvottiṣhṭha parantapa",R.color.trans));
        mData.add(new NewsItem("अर्जुन उवाच |\n" + "कथं भीष्ममहं सङ्ख्ये द्रोणं च मधुसूदन |\n" + "इषुभि: प्रतियोत्स्यामि पूजार्हावरिसूदन || 4||"," arjunaḥ uvācha—Arjun said; katham—how; bhīṣhmam—Bheeshma; aham—I; sankhye—in battle; droṇam—Dronacharya; cha—and; madhu-sūdana—Shree Krishn, slayer of the Madhu demon; iṣhubhiḥ—with arrows; pratiyotsyāmi—shall I shoot; pūjā-arhau—worthy of worship; ari-sūdana—destroyer of enemies ","arjuna uvācha\n" + "kathaṁ bhīṣhmam ahaṁ sankhye droṇaṁ cha madhusūdana\n" + "iṣhubhiḥ pratiyotsyāmi pūjārhāvari-sūdana",R.color.trans));
        mData.add(new NewsItem("गुरूनहत्वा हि महानुभावान्\n" + "श्रेयो भोक्तुं भैक्ष्यमपीह लोके |\n" + "हत्वार्थकामांस्तु गुरूनिहैव\n" + "भुञ्जीय भोगान् रुधिरप्रदिग्धान् || 5||"," gurūn—teachers; ahatvā—not killing; hi—certainly; mahā-anubhāvān—noble elders; śhreyaḥ—better; bhoktum—to enjoy life; bhaikṣhyam—by begging; api—even; iha loke—in this world; hatvā—killing; artha—gain; kāmān—desiring; tu—but; gurūn—noble elders; iha—in this world; eva—certainly; bhuñjīya—enjoy; bhogān—pleasures; rudhira—blood; pradigdhān—tainted with ","gurūnahatvā hi mahānubhāvān\n" + "śhreyo bhoktuṁ bhaikṣhyamapīha loke\n" + "hatvārtha-kāmāṁstu gurūnihaiva\n" + "bhuñjīya bhogān rudhira-pradigdhān",R.color.trans));
        mData.add(new NewsItem("न चैतद्विद्म: कतरन्नो गरीयो\n" + "यद्वा जयेम यदि वा नो जयेयु: |\n" + "यानेव हत्वा न जिजीविषाम\n" + "स्तेऽवस्थिता: प्रमुखे धार्तराष्ट्रा: || 6||"," na—not; cha—and; etat—this; vidmaḥ—we know; katarat—which; naḥ—for us; garīyaḥ—is preferable; yat vā—whether; jayema—we may conquer; yadi—if; vā—or; naḥ—us; jayeyuḥ—they may conquer; yān—whom; eva—certainly; hatvā—after killing; na—not; jijīviṣhāmaḥ—we desire to live; te—they; avasthitāḥ—are standing; pramukhe—before us; dhārtarāṣhṭrāḥ—the sons of Dhritarashtra ","na chaitadvidmaḥ kataranno garīyo\n" + "yadvā jayema yadi vā no jayeyuḥ\n" + "yāneva hatvā na jijīviṣhāmas\n" + "te ’vasthitāḥ pramukhe dhārtarāṣhṭrāḥ",R.color.trans));
        mData.add(new NewsItem("कार्पण्यदोषोपहतस्वभाव:\n" + "पृच्छामि त्वां धर्मसम्मूढचेता: |\n" + "यच्छ्रेय: स्यान्निश्चितं ब्रूहि तन्मे\n" + "शिष्यस्तेऽहं शाधि मां त्वां प्रपन्नम् || 7||"," kārpaṇya-doṣha—the flaw of cowardice; upahata—besieged; sva-bhāvaḥ—nature; pṛichchhāmi—I am asking; tvām—to you; dharma—duty; sammūḍha—confused; chetāḥ—in heart; yat—what; śhreyaḥ—best; syāt—may be; niśhchitam—decisively; brūhi—tell; tat—that; me—to me; śhiṣhyaḥ—disciple; te—your; aham—I; śhādhi—please instruct; mām—me; tvām—unto you; prapannam—surrendered ","kārpaṇya-doṣhopahata-svabhāvaḥ\n" + "pṛichchhāmi tvāṁ dharma-sammūḍha-chetāḥ\n" + "yach-chhreyaḥ syānniśhchitaṁ brūhi tanme\n" + "śhiṣhyaste ’haṁ śhādhi māṁ tvāṁ prapannam",R.color.trans));
        mData.add(new NewsItem("न हि प्रपश्यामि ममापनुद्याद्\n" + "यच्छोकमुच्छोषणमिन्द्रियाणाम् |\n" + "अवाप्य भूमावसपत्नमृद्धं\n" + "राज्यं सुराणामपि चाधिपत्यम् || 8||"," na—not; hi—certainly; prapaśhyāmi—I see; mama—my; apanudyāt—drive away; yat—which; śhokam—anguish; uchchhoṣhaṇam—is drying up; indriyāṇām—of the senses; avāpya—after achieving; bhūmau—on the earth; asapatnam—unrivalled; ṛiddham—prosperous; rājyam—kingdom; surāṇām—like the celestial gods; api—even; cha—also; ādhipatyam—sovereignty ","na hi prapaśhyāmi mamāpanudyād\n" + "yach-chhokam uchchhoṣhaṇam-indriyāṇām\n" + "avāpya bhūmāv-asapatnamṛiddhaṁ\n" + "rājyaṁ surāṇāmapi chādhipatyam",R.color.trans));
        mData.add(new NewsItem("सञ्जय उवाच |\n" + "एवमुक्त्वा हृषीकेशं गुडाकेश: परन्तप |\n" + "न योत्स्य इति गोविन्दमुक्त्वा तूष्णीं बभूव ह || 9||"," sañjayaḥ uvācha—Sanjay said; evam—thus; uktvā—having spoken; hṛiṣhīkeśham—to Shree Krishna, the master of the mind and senses; guḍākeśhaḥ—Arjun, the conquerer of sleep; parantapaḥ—Arjun, the chastiser of the enemies; na yotsye—I shall not fight; iti—thus; govindam—Krishna, the giver of pleasure to the senses; uktvā—having addressed; tūṣhṇīm—silent; babhūva—became ha ","\n" + "\n" + "sañjaya uvācha\n" + "evam-uktvā hṛiṣhīkeśhaṁ guḍākeśhaḥ parantapa\n" + "na yotsya iti govindam uktvā tūṣhṇīṁ babhūva ha\n",R.color.trans));
        mData.add(new NewsItem("तमुवाच हृषीकेश: प्रहसन्निव भारत |\n" + "सेनयोरुभयोर्मध्ये विषीदन्तमिदं वच: || 10||"," tam—to him; uvācha—said; hṛiṣhīkeśhaḥ—Shree Krishna, the master of mind and senses; prahasan—smilingly; iva—as if; bhārata—Dhritarashtra, descendant of Bharat; senayoḥ—of the armies; ubhayoḥ—of both; madhye—in the midst of; viṣhīdantam—to the grief-stricken; idam—this; vachaḥ—words ","tam-uvācha hṛiṣhīkeśhaḥ prahasanniva bhārata\n" + "senayorubhayor-madhye viṣhīdantam-idaṁ vachaḥ",R.color.trans));
        mData.add(new NewsItem("श्रीभगवानुवाच |\n" + "अशोच्यानन्वशोचस्त्वं प्रज्ञावादांश्च भाषसे |\n" + "गतासूनगतासूंश्च नानुशोचन्ति पण्डिता: || 11||"," śhrī-bhagavān uvācha—the Supreme Lord said; aśhochyān—not worthy of grief; anvaśhochaḥ—are mourning; tvam—you; prajñā-vādān—words of wisdom; cha—and; bhāṣhase—speaking; gata āsūn—the dead; agata asūn—the living; cha—and; na—never; anuśhochanti—lament; paṇḍitāḥ—the wise ","śhrī bhagavān uvācha\n" + "aśhochyān-anvaśhochas-tvaṁ prajñā-vādānśh cha bhāṣhase\n" + "gatāsūn-agatāsūnśh-cha nānuśhochanti paṇḍitāḥ",R.color.trans));
        mData.add(new NewsItem("न त्वेवाहं जातु नासं न त्वं नेमे जनाधिपा |\n" + "न चैव न भविष्याम: सर्वे वयमत: परम् || 12||"," na—never; tu—however; eva—certainly; aham—I; jātu—at any time; na—nor; āsam—exist; na—nor; tvam—you; na—nor; ime—these; jana-adhipāḥ—kings; na—never; cha—also; eva—indeed; na bhaviṣhyāmaḥ—shall not exist; sarve vayam—all of us; ataḥ—from now; param—after ","na tvevāhaṁ jātu nāsaṁ na tvaṁ neme janādhipāḥ\n" + "na chaiva na bhaviṣhyāmaḥ sarve vayamataḥ param",R.color.trans));
        mData.add(new NewsItem("देहिनोऽस्मिन्यथा देहे कौमारं यौवनं जरा |\n" + "तथा देहान्तरप्राप्तिर्धीरस्तत्र न मुह्यति || 13||"," dehinaḥ—of the embodied; asmin—in this; yathā—as; dehe—in the body; kaumāram—childhood; yauvanam—youth; jarā—old age; tathā—similarly; deha-antara—another body; prāptiḥ—achieves; dhīraḥ—the wise; tatra—thereupon; na muhyati—are not deluded ","dehino ’smin yathā dehe kaumāraṁ yauvanaṁ jarā\n" + "tathā dehāntara-prāptir dhīras tatra na muhyati",R.color.trans));
        mData.add(new NewsItem("मात्रास्पर्शास्तु कौन्तेय शीतोष्णसुखदु: खदा: |\n" + "आगमापायिनोऽनित्यास्तांस्तितिक्षस्व भारत || 14||"," mātrā-sparśhāḥ—contact of the senses with the sense objects; tu—indeed; kaunteya—Arjun, the son of Kunti; śhīta—winter; uṣhṇa—summer; sukha—happiness; duḥkha—distress; dāḥ—give; āgama—come; apāyinaḥ—go; anityāḥ—non-permanent; tān—them; titikṣhasva—tolerate; bhārata—descendant of the Bharat ","mātrā-sparśhās tu kaunteya śhītoṣhṇa-sukha-duḥkha-dāḥ\n" + "āgamāpāyino ’nityās tans-titikṣhasva bhārata",R.color.trans));
        mData.add(new NewsItem("यं हि न व्यथयन्त्येते पुरुषं पुरुषर्षभ |\n" + "समदु:खसुखं धीरं सोऽमृतत्वाय कल्पते || 15||"," yam—whom; hi—verily; na—not; vyathayanti—distressed; ete—these; puruṣham—person; puruṣha-ṛiṣhabha—the noblest amongst men, Arjun; sama—equipoised; duḥkha—distress; sukham—happiness; dhīram—steady; saḥ—that person; amṛitatvāya—for liberation; kalpate—becomes eligible ","yaṁ hi na vyathayantyete puruṣhaṁ puruṣharṣhabha\n" + "sama-duḥkha-sukhaṁ dhīraṁ so ’mṛitatvāya kalpate",R.color.trans));
        mData.add(new NewsItem("नासतो विद्यते भावो नाभावो विद्यते सत: |\n" + "उभयोरपि दृष्टोऽन्तस्त्वनयोस्तत्वदर्शिभि: || 16||"," na—no; asataḥ—of the temporary; vidyate—there is; bhāvaḥ—is; na—no; abhāvaḥ—cessation; vidyate—is; sataḥ—of the eternal; ubhayoḥ—of the two; api—also; dṛiṣhṭaḥ—observed; antaḥ—conclusion; tu—verily; anayoḥ—of these; tattva—of the truth; darśhibhiḥ—by the seers ","nāsato vidyate bhāvo nābhāvo vidyate sataḥ\n" + "ubhayorapi dṛiṣhṭo ’nta stvanayos tattva-darśhibhiḥ",R.color.trans));
        mData.add(new NewsItem("अविनाशि तु तद्विद्धि येन सर्वमिदं ततम् |\n" + "विनाशमव्ययस्यास्य न कश्चित्कर्तुमर्हति || 17||"," avināśhi—indestructible; tu—indeed; tat—that; viddhi—know; yena—by whom; sarvam—entire; idam—this; tatam—pervaded; vināśham—destruction; avyayasya—of the imperishable; asya—of it; na kaśhchit—no one; kartum—to cause; arhati—is able ","avināśhi tu tadviddhi yena sarvam idaṁ tatam\n" + "vināśham avyayasyāsya na kaśhchit kartum arhati",R.color.trans));
        mData.add(new NewsItem("अन्तवन्त इमे देहा नित्यस्योक्ता: शरीरिण: |\n" + "अनाशिनोऽप्रमेयस्य तस्माद्युध्यस्व भारत || 18||"," anta-vantaḥ—having an end; ime—these; dehāḥ—material bodies; nityasya—eternally; uktāḥ—are said; śharīriṇaḥ—of the embodied soul; anāśhinaḥ—indestructible; aprameyasya—immeasurable; tasmāt—therefore; yudhyasva—fight; bhārata—descendant of Bharat, Arjun ","antavanta ime dehā nityasyoktāḥ śharīriṇaḥ\n" + "anāśhino ’prameyasya tasmād yudhyasva bhārata",R.color.trans));
        mData.add(new NewsItem("य एनं वेत्ति हन्तारं यश्चैनं मन्यते हतम् |\n" + "उभौ तौ न विजानीतो नायं हन्ति न हन्यते || 19||"," yaḥ—one who; enam—this; vetti—knows; hantāram—the slayer; yaḥ—one who; cha—and; enam—this; manyate—thinks; hatam—slain; ubhau—both; tau—they; na—not; vijānītaḥ—in knowledge; na—neither; ayam—this; hanti—slays; na—nor; hanyate—is killed ","ya enaṁ vetti hantāraṁ yaśh chainaṁ manyate hatam\n" + "ubhau tau na vijānīto nāyaṁ hanti na hanyate",R.color.trans));
        mData.add(new NewsItem("न जायते म्रियते वा कदाचि\n" + "नायं भूत्वा भविता वा न भूय: |\n" + "अजो नित्य: शाश्वतोऽयं पुराणो\n" + "न हन्यते हन्यमाने शरीरे || 20||"," na jāyate—is not born; mriyate—dies; vā—or; kadāchit—at any time; na—not; ayam—this; bhūtvā—having once existed; bhavitā—will be; vā—or; na—not; bhūyaḥ—further; ajaḥ—unborn; nityaḥ—eternal; śhāśhvataḥ—immortal; ayam—this; purāṇaḥ—the ancient; na hanyate—is not destroyed; hanyamāne—is destroyed; śharīre—when the body ","na jāyate mriyate vā kadāchin\n" + "nāyaṁ bhūtvā bhavitā vā na bhūyaḥ\n" + "ajo nityaḥ śhāśhvato ’yaṁ purāṇo\n" + "na hanyate hanyamāne śharīre",R.color.trans));
        mData.add(new NewsItem("वेदाविनाशिनं नित्यं य एनमजमव्ययम् |\n" + "कथं स पुरुष: पार्थ कं घातयति हन्ति कम् || 21||"," veda—knows; avināśhinam—imperishable; nityam—eternal; yaḥ—who; enam—this; ajam—unborn; avyayam—immutable; katham—how; saḥ—that; puruṣhaḥ—person; pārtha—Parth; kam—whom; ghātayati—causes to be killed; hanti—kills; kam—whom ","vedāvināśhinaṁ nityaṁ ya enam ajam avyayam\n" + "kathaṁ sa puruṣhaḥ pārtha kaṁ ghātayati hanti kam",R.color.trans));
        mData.add(new NewsItem("वासांसि जीर्णानि यथा विहाय\n" + "नवानि गृह्णाति नरोऽपराणि |\n" + "तथा शरीराणि विहाय जीर्णा\n" + "न्यन्यानि संयाति नवानि देही || 22||"," vāsānsi—garments; jīrṇāni—worn-out; yathā—as; vihāya—sheds; navāni—new; gṛihṇāti—accepts; naraḥ—a person; aparāṇi—others; tathā—likewise; śharīrāṇi—bodies; vihāya—casting off; jirṇāni—worn-out; anyāni—other; sanyāti—enters; navāni—new; dehī—the embodied soul ","vāsānsi jīrṇāni yathā vihāya\n" + "navāni gṛihṇāti naro ’parāṇi\n" + "tathā śharīrāṇi vihāya jīrṇānya\n" + "nyāni sanyāti navāni dehī",R.color.trans));
        mData.add(new NewsItem("नैनं छिन्दन्ति शस्त्राणि नैनं दहति पावक: |\n" + "न चैनं क्लेदयन्त्यापो न शोषयति मारुत: || 23||"," na—not; enam—this soul; chhindanti—shred; śhastrāṇi—weapons; na—nor; enam—this soul; dahati—burns; pāvakaḥ—fire; na—not; cha—and; enam—this soul; kledayanti—moisten; āpaḥ—water; na—nor; śhoṣhayati—dry; mārutaḥ—wind ","nainaṁ chhindanti śhastrāṇi nainaṁ dahati pāvakaḥ\n" + "na chainaṁ kledayantyāpo na śhoṣhayati mārutaḥ",R.color.trans));
        mData.add(new NewsItem("अच्छेद्योऽयमदाह्योऽयमक्लेद्योऽशोष्य एव च |\n" + "नित्य: सर्वगत: स्थाणुरचलोऽयं सनातन: || 24||"," achchhedyaḥ—unbreakable; ayam—this soul; adāhyaḥ—incombustible; ayam—this soul; akledyaḥ—cannot be dampened; aśhoṣhyaḥ—cannot be dried; eva—indeed; cha—and; nityaḥ—everlasting; sarva-gataḥ—all-pervading; sthāṇuḥ—unalterable; achalaḥ—immutable; ayam—this soul; sanātanaḥ—primordial ","achchhedyo ’yam adāhyo ’yam akledyo ’śhoṣhya eva cha\n" + "nityaḥ sarva-gataḥ sthāṇur achalo ’yaṁ sanātanaḥ",R.color.trans));
        mData.add(new NewsItem("अव्यक्तोऽयमचिन्त्योऽयमविकार्योऽयमुच्यते |\n" + "तस्मादेवं विदित्वैनं नानुशोचितुमर्हसि || 25||"," avyaktaḥ—unmanifested; ayam—this soul; achintyaḥ—inconceivable; ayam—this soul; avikāryaḥ—unchangeable; ayam—this soul; uchyate—is said; tasmāt—therefore; evam—thus; viditvā—having known; enam—this soul; na—not; anuśhochitum—to grieve; arhasi—befitting ","avyakto ’yam achintyo ’yam avikāryo ’yam uchyate\n" + "tasmādevaṁ viditvainaṁ nānuśhochitum arhasi",R.color.trans));
        mData.add(new NewsItem("अथ चैनं नित्यजातं नित्यं वा मन्यसे मृतम् |\n" + "तथापि त्वं महाबाहो नैवं शोचितुमर्हसि || 26||"," atha—if, however; cha—and; enam—this soul; nitya-jātam—taking constant birth; nityam—always; vā—or; manyase—you think; mṛitam—dead; tathā api—even then; tvam—you; mahā-bāho—mighty-armed one, Arjun; na—not; evam—like this; śhochitum—grieve; arhasi—befitting ","atha chainaṁ nitya-jātaṁ nityaṁ vā manyase mṛitam\n" + "tathāpi tvaṁ mahā-bāho naivaṁ śhochitum arhasi",R.color.trans));
        mData.add(new NewsItem("जातस्य हि ध्रुवो मृत्युर्ध्रुवं जन्म मृतस्य च |\n" + "तस्मादपरिहार्येऽर्थे न त्वं शोचितुमर्हसि || 27||"," jātasya—for one who has been born; hi—for; dhruvaḥ—certain; mṛityuḥ—death; dhruvam—certain; janma—birth; mṛitasya—for the dead; cha—and; tasmāt—therefore; aparihārye arthe—in this inevitable situation; na—not; tvam—you; śhochitum—lament; arhasi—befitting ","jātasya hi dhruvo mṛityur dhruvaṁ janma mṛitasya cha\n" + "tasmād aparihārye ’rthe na tvaṁ śhochitum arhasi",R.color.trans));
        mData.add(new NewsItem("अव्यक्तादीनि भूतानि व्यक्तमध्यानि भारत |\n" + "अव्यक्तनिधनान्येव तत्र का परिदेवना || 28||"," avyakta-ādīni—unmanifest before birth; bhūtāni—created beings; vyakta—manifest; madhyāni—in the middle; bhārata—Arjun, scion of Bharat; avyakta—unmanifest; nidhanāni—on death; eva—indeed; tatra—therefore; kā—why; paridevanā—grieve ","avyaktādīni bhūtāni vyakta-madhyāni bhārata\n" + "avyakta-nidhanānyeva tatra kā paridevanā",R.color.trans));
        mData.add(new NewsItem("आश्चर्यवत्पश्यति कश्चिदेन\n" + "माश्चर्यवद्वदति तथैव चान्य: |\n" + "आश्चर्यवच्चैनमन्य: शृ्णोति\n" + "श्रुत्वाप्येनं वेद न चैव कश्चित् || 29||"," āśhcharya-vat—as amazing; paśhyati—see; kaśhchit—someone; enam—this soul; āśhcharya-vat—as amazing; vadati—speak of; tathā—thus; eva—indeed; cha—and; anyaḥ—other; āśhcharya-vat—similarly amazing; cha—also; enam—this soul; anyaḥ—others; śhṛiṇoti—hear; śhrutvā—having heard; api—even; enam—this soul; veda—understand; na—not; cha—and; eva—even; kaśhchit—some ","āśhcharya-vat paśhyati kaśhchid enan\n" + "āśhcharya-vad vadati tathaiva chānyaḥ\n" + "āśhcharya-vach chainam anyaḥ śhṛiṇoti\n" + "śhrutvāpyenaṁ veda na chaiva kaśhchit",R.color.trans));
        mData.add(new NewsItem("देही नित्यमवध्योऽयं देहे सर्वस्य भारत |\n" + "तस्मात्सर्वाणि भूतानि न त्वं शोचितुमर्हसि || 30||"," dehī—the soul that dwells within the body; nityam—always; avadhyaḥ—immortal; ayam—this soul; dehe—in the body; sarvasya—of everyone; bhārata—descendant of Bharat, Arjun; tasmāt—therefore; sarvāṇi—for all; bhūtāni—living entities; na—not; tvam—you; śhochitum—mourn; arhasi—should ","dehī nityam avadhyo ’yaṁ dehe sarvasya bhārata\n" + "tasmāt sarvāṇi bhūtāni na tvaṁ śhochitum arhasi",R.color.trans));
        mData.add(new NewsItem("स्वधर्ममपि चावेक्ष्य न विकम्पितुमर्हसि |\n" + "धर्म्याद्धि युद्धाच्छ्रेयोऽन्यत्क्षत्रियस्य न विद्यते || 31||"," swa-dharmam—one’s duty in accordance with the Vedas; api—also; cha—and; avekṣhya—considering; na—not; vikampitum—to waver; arhasi—should; dharmyāt—for righteousness; hi—indeed; yuddhāt—than fighting; śhreyaḥ—better; anyat—another; kṣhatriyasya—of a warrior; na—not; vidyate—exists ","swa-dharmam api chāvekṣhya na vikampitum arhasi\n" + "dharmyāddhi yuddhāch chhreyo ’nyat kṣhatriyasya na vidyate",R.color.trans));
        mData.add(new NewsItem("यदृच्छया चोपपन्नं स्वर्गद्वारमपावृतम् |\n" + "सुखिन: क्षत्रिया: पार्थ लभन्ते युद्धमीदृशम् || 32||"," yadṛichchhayā—unsought; cha—and; upapannam—come; swarga—celestial abodes; dvāram—door; apāvṛitam—wide open; sukhinaḥ—happy; kṣhatriyāḥ—warriors; pārtha—Arjun, the son of Pritha; labhante—obtain; yuddham—war; īdṛiśham—such ","yadṛichchhayā chopapannaṁ swarga-dvāram apāvṛitam\n" + "sukhinaḥ kṣhatriyāḥ pārtha labhante yuddham īdṛiśham",R.color.trans));
        mData.add(new NewsItem("अथ चेतत्वमिमं धर्म्यं संग्रामं न करिष्यसि |\n" + "तत: स्वधर्मं कीर्तिं च हित्वा पापमवाप्स्यसि || 33||"," atha chet—if, however; tvam—you; imam—this; dharmyam saṅgrāmam—righteous war; na—not; kariṣhyasi—act; tataḥ—then; sva-dharmam—one’s duty in accordance with the Vedas; kīrtim—reputation; cha—and; hitvā—abandoning; pāpam—sin; avāpsyasi—will incur ","atha chet tvam imaṁ dharmyaṁ saṅgrāmaṁ na kariṣhyasi\n" + "tataḥ sva-dharmaṁ kīrtiṁ cha hitvā pāpam avāpsyasi",R.color.trans));
        mData.add(new NewsItem("अकीर्तिं चापि भूतानि\n" + "कथयिष्यन्ति तेऽव्ययाम् |\n" + "सम्भावितस्य चाकीर्ति\n" + "र्मरणादतिरिच्यते || 34||"," akīrtim—infamy; cha—and; api—also; bhūtāni—people; kathayiṣhyanti—will speak; te—of your; avyayām—everlasting; sambhāvitasya—of a respectable person; cha—and; akīrtiḥ—infamy; maraṇāt—than death; atirichyate—is greater ","akīrtiṁ chāpi bhūtāni\n" + "kathayiṣhyanti te ’vyayām\n" + "sambhāvitasya chākīrtir\n" + "maraṇād atirichyate",R.color.trans));
        mData.add(new NewsItem("भयाद्रणादुपरतं मंस्यन्ते त्वां महारथा: |\n" + "येषां च त्वं बहुमतो भूत्वा यास्यसि लाघवम् || 35||"," bhayāt—out of fear; raṇāt—from the battlefield; uparatam—have fled; maṁsyante—will think; tvām—you; mahā-rathāḥ—warriors who could single handedly match the strength of ten thousand ordinary warriors; yeṣhām—for whom; cha—and; tvam—you; bahu-mataḥ—high esteemed; bhūtvā—having been; yāsyasi—you will loose; lāghavam—decreased in value ","bhayād raṇād uparataṁ mansyante tvāṁ mahā-rathāḥ\n" + "yeṣhāṁ cha tvaṁ bahu-mato bhūtvā yāsyasi lāghavam",R.color.trans));
        mData.add(new NewsItem("अवाच्यवादांश्च बहून्वदिष्यन्ति तवाहिता: |\n" + "निन्दन्तस्तव सामर्थ्यं ततो दु:खतरं नु किम् || 36||"," avāchya-vādān—using harsh words; cha—and; bahūn—many; vadiṣhyanti—will say; tava—your; ahitāḥ—enemies; nindantaḥ—defame; tava—your; sāmarthyam—might; tataḥ—than that; duḥkha-taram—more painful; nu—indeed; kim—what ","avāchya-vādānśh cha bahūn vadiṣhyanti tavāhitāḥ\n" + "nindantastava sāmarthyaṁ tato duḥkhataraṁ nu kim",R.color.trans));
        mData.add(new NewsItem("हतो वा प्राप्स्यसि स्वर्गं जित्वा वा भोक्ष्यसे महीम् |\n" + "तस्मादुत्तिष्ठ कौन्तेय युद्धाय कृतनिश्चय: || 37||"," hataḥ—slain; vā—or; prāpsyasi—you will attain; swargam—celestial abodes; jitvā—by achieving victory; vā—or; bhokṣhyase—you shall enjoy; mahīm—the kingdom on earth; tasmāt—therefore; uttiṣhṭha—arise; kaunteya—Arjun, the son of Kunti; yuddhāya—for fight; kṛita-niśhchayaḥ—with determination ","hato vā prāpsyasi swargaṁ jitvā vā bhokṣhyase mahīm\n" + "tasmād uttiṣhṭha kaunteya yuddhāya kṛita-niśhchayaḥ",R.color.trans));
        mData.add(new NewsItem("सुखदु:खे समे कृत्वा लाभालाभौ जयाजयौ |\n" + "ततो युद्धाय युज्यस्व नैवं पापमवाप्स्यसि || 38||"," sukha—happiness; duḥkhe—in distress; same kṛitvā—treating alike; lābha-alābhau—gain and loss; jaya-ajayau—victory and defeat; tataḥ—thereafter; yuddhāya—for fighting; yujyasva—engage; na—never; evam—thus; pāpam—sin; avāpsyasi—shall incur ","sukha-duḥkhe same kṛitvā lābhālābhau jayājayau\n" + "tato yuddhāya yujyasva naivaṁ pāpam avāpsyasi",R.color.trans));
        mData.add(new NewsItem("एषा तेऽभिहिता साङ्ख्ये\n" + "बुद्धिर्योगे त्विमां शृणु |\n" + "बुद्ध्या युक्तो यया पार्थ\n" + "कर्मबन्धं प्रहास्यसि || 39||"," eṣhā—hitherto; te—to you; abhihitā—explained; sānkhye—by analytical knowledge; buddhiḥ yoge—by the yog of intellect; tu—indeed; imām—this; śhṛiṇu—listen; buddhyā—by understanding; yuktaḥ—united; yayā—by which; pārtha—Arjun, the son of Pritha; karma-bandham—bondage of karma; prahāsyasi—you shall be released from ","eṣhā te ’bhihitā sānkhye\n" + "buddhir yoge tvimāṁ śhṛiṇu\n" + "buddhyā yukto yayā pārtha\n" + "karma-bandhaṁ prahāsyasi",R.color.trans));
        mData.add(new NewsItem("नेहाभिक्रमनाशोऽस्ति प्रत्यवायो न विद्यते |\n" + "स्वल्पमप्यस्य धर्मस्य त्रायते महतो भयात् || 40||"," na—not; iha—in this; abhikrama—efforts; nāśhaḥ—loss; asti—there is; pratyavāyaḥ—adverse result; na—not; vidyate—is; su-alpam—a little; api—even; asya—of this; dharmasya—occupation; trāyate—saves; mahataḥ—from great; bhayāt—danger ","nehābhikrama-nāśho ’sti pratyavāyo na vidyate\n" + "svalpam apyasya dharmasya trāyate mahato bhayāt",R.color.trans));
        mData.add(new NewsItem("व्यवसायात्मिका बुद्धिरेकेह कुरुनन्दन |\n" + "बहुशाखा ह्यनन्ताश्च बुद्धयोऽव्यवसायिनाम् || 41||"," vyavasāya-ātmikā—resolute; buddhiḥ—intellect; ekā—single; iha—on this path; kuru-nandana—descendent of the Kurus; bahu-śhākhāḥ—many-branched; hi—indeed; anantāḥ—endless; cha—also; buddhayaḥ—intellect; avyavasāyinām—of the irresolute ","vyavasāyātmikā buddhir ekeha kuru-nandana\n" + "bahu-śhākhā hyanantāśh cha buddhayo ’vyavasāyinām",R.color.trans));
        mData.add(new NewsItem("यामिमां पुष्पितां वाचं प्रवदन्त्यविपश्चित: |\n" + "वेदवादरता: पार्थ नान्यदस्तीति वादिन: || 42||\n" + "कामात्मान: स्वर्गपरा जन्मकर्मफलप्रदाम् |\n" + "क्रियाविशेषबहुलां भोगैश्वर्यगतिं प्रति || 43||"," yām imām—all these; puṣhpitām—flowery; vācham—words; pravadanti—speak; avipaśhchitaḥ—those with limited understanding; veda-vāda-ratāḥ—attached to the flowery words of the Vedas; pārtha—Arjun, the son of Pritha; na anyat—no other; asti—is; iti—thus; vādinaḥ—advocate; kāma-ātmānaḥ—desirous of sensual pleasure; swarga-parāḥ—aiming to achieve the heavenly planets; janma-karma-phala—high birth and fruitive results; pradāṁ—awarding; kriyā-viśheṣha—pompous ritualistic ceremonies; bahulām—various; bhoga—gratification; aiśhwarya—luxury; gatim—progress; prati—toward ","yāmimāṁ puṣhpitāṁ vāchaṁ pravadanty-avipaśhchitaḥ\n" + "veda-vāda-ratāḥ pārtha nānyad astīti vādinaḥ\n" + "kāmātmānaḥ swarga-parā janma-karma-phala-pradām\n" + "kriyā-viśheṣha-bahulāṁ bhogaiśhwarya-gatiṁ prati",R.color.trans));
        mData.add(new NewsItem("भोगैश्वर्यप्रसक्तानां तयापहृतचेतसाम् |\n" + "व्यवसायात्मिका बुद्धि: समाधौ न विधीयते || 44||"," bhoga—gratification; aiśhwarya—luxury; prasaktānām—whose minds are deeply attached; tayā—by that; apahṛita-chetasām—bewildered in intellect; vyavasāya-ātmikā—resolute; buddhiḥ—intellect; samādhau—fulfilment; na—never; vidhīyate—occurs ","bhogaiśwvarya-prasaktānāṁ tayāpahṛita-chetasām\n" + "vyavasāyātmikā buddhiḥ samādhau na vidhīyate",R.color.trans));
        mData.add(new NewsItem("त्रैगुण्यविषया वेदा निस्त्रैगुण्यो भवार्जुन |\n" + "निर्द्वन्द्वो नित्यसत्वस्थो निर्योगक्षेम आत्मवान् || 45||"," trai-guṇya—of the three modes of material nature; viṣhayāḥ—subject matter; vedāḥ—Vedic scriptures; nistrai-guṇyaḥ—above the three modes of material nature, transcendental; bhava—be; arjuna—Arjun; nirdvandvaḥ—free from dualities; nitya-sattva-sthaḥ—eternally fixed in truth; niryoga-kṣhemaḥ—unconcerned about gain and preservation; ātma-vān—situated in the self ","trai-guṇya-viṣhayā vedā nistrai-guṇyo bhavārjuna\n" + "nirdvandvo nitya-sattva-stho niryoga-kṣhema ātmavān",R.color.trans));
        mData.add(new NewsItem("यावानर्थ उदपाने सर्वत: सम्प्लुतोदके |\n" + "तावान्सर्वेषु वेदेषु ब्राह्मणस्य विजानत: || 46||"," yāvān—whatever; arthaḥ—purpose; uda-pāne—a well of water; sarvataḥ—in all respects; sampluta-udake—by a large lake; tāvān—that many; sarveṣhu—in all; vedeṣhu—Vedas; brāhmaṇasya—one who realizes the Absolute Truth; vijānataḥ—who is in complete knowledge ","yāvān artha udapāne sarvataḥ samplutodake\n" + "tāvānsarveṣhu vedeṣhu brāhmaṇasya vijānataḥ",R.color.trans));
        mData.add(new NewsItem("कर्मण्येवाधिकारस्ते मा फलेषु कदाचन |\n" + "मा कर्मफलहेतुर्भूर्मा ते सङ्गोऽस्त्वकर्मणि || 47 ||"," karmaṇi—in prescribed duties; eva—only; adhikāraḥ—right; te—your; mā—not; phaleṣhu—in the fruits; kadāchana—at any time; mā—never; karma-phala—results of the activities; hetuḥ—cause; bhūḥ—be; mā—not; te—your; saṅgaḥ—attachment; astu—must be; akarmaṇi—in inaction ","karmaṇy-evādhikāras te mā phaleṣhu kadāchana\n" + "mā karma-phala-hetur bhūr mā te saṅgo ’stvakarmaṇi",R.color.trans));
        mData.add(new NewsItem("योगस्थ: कुरु कर्माणि सङ्गं त्यक्त्वा धनञ्जय |\n" + "सिद्ध्यसिद्ध्यो: समो भूत्वा समत्वं योग उच्यते || 48||"," yoga-sthaḥ—being steadfast in yog; kuru—perform; karmāṇi—duties; saṅgam—attachment; tyaktvā—having abandoned; dhanañjaya—Arjun; siddhi-asiddhyoḥ—in success and failure; samaḥ—equipoised; bhūtvā—becoming; samatvam—equanimity; yogaḥ—Yog; uchyate—is called ","yoga-sthaḥ kuru karmāṇi saṅgaṁ tyaktvā dhanañjaya\n" + "siddhy-asiddhyoḥ samo bhūtvā samatvaṁ yoga uchyate",R.color.trans));
        mData.add(new NewsItem("दूरेण ह्यवरं कर्म बुद्धियोगाद्धनञ्जय |\n" + "बुद्धौ शरणमन्विच्छ कृपणा: फलहेतव: || 49||"," dūreṇa—(discrad) from far away; hi—certainly; avaram—inferior; karma—reward-seeking actions; buddhi-yogāt—with the intellect established in Divine knowledge; dhanañjaya—Arjun; buddhau—divine knowledge and insight; śharaṇam—refuge; anvichchha—seek; kṛipaṇāḥ—miserly; phala-hetavaḥ—those seeking fruits of their work ","dūreṇa hy-avaraṁ karma buddhi-yogād dhanañjaya\n" + "buddhau śharaṇam anvichchha kṛipaṇāḥ phala-hetavaḥ",R.color.trans));
        mData.add(new NewsItem("बुद्धियुक्तो जहातीह उभे सुकृतदुष्कृते |\n" + "तस्माद्योगाय युज्यस्व योग: कर्मसु कौशलम् || 50||"," buddhi-yuktaḥ—endowed with wisdom; jahāti—get rid of; iha—in this life; ubhe—both; sukṛita-duṣhkṛite—good and bad deeds; tasmāt—therefore; yogāya—for Yog; yujyasva—strive for; yogaḥ—yog is; karmasu kauśhalam—the art of working skillfully ","buddhi-yukto jahātīha ubhe sukṛita-duṣhkṛite\n" + "tasmād yogāya yujyasva yogaḥ karmasu kauśhalam",R.color.trans));
        mData.add(new NewsItem("कर्मजं बुद्धियुक्ता हि फलं त्यक्त्वा मनीषिण: |\n" + "जन्मबन्धविनिर्मुक्ता: पदं गच्छन्त्यनामयम् || 51||"," karma-jam—born of fruitive actions; buddhi-yuktāḥ—endowed with equanimity of intellect; hi—as; phalam—fruits; tyaktvā—abandoning; manīṣhiṇaḥ—the wise; janma-bandha-vinirmuktāḥ—freedom from the bondage of life and death; padam—state; gachchhanti—attain; anāmayam—devoid of sufferings ","karma-jaṁ buddhi-yuktā hi phalaṁ tyaktvā manīṣhiṇaḥ\n" + "janma-bandha-vinirmuktāḥ padaṁ gachchhanty-anāmayam",R.color.trans));
        mData.add(new NewsItem("यदा ते मोहकलिलं बुद्धिर्व्यतितरिष्यति |\n" + "तदा गन्तासि निर्वेदं श्रोतव्यस्य श्रुतस्य च || 52||"," yadā—when; te—your; moha—delusion; kalilam—quagmire; buddhiḥ—intellect; vyatitariṣhyati—crosses; tadā—then; gantāsi—you shall acquire; nirvedam—indifferent; śhrotavyasya—to what is yet to be heard; śhrutasya—to what has been heard; cha—and ","yadā te moha-kalilaṁ buddhir vyatitariṣhyati\n" + "tadā gantāsi nirvedaṁ śhrotavyasya śhrutasya cha",R.color.trans));
        mData.add(new NewsItem("श्रुतिविप्रतिपन्ना ते यदा स्थास्यति निश्चला |\n" + "समाधावचला बुद्धिस्तदा योगमवाप्स्यसि || 53||"," śhruti-vipratipannā—not allured by the fruitive sections of the Vedas; te—your; yadā—when; sthāsyati—remains; niśhchalā—steadfast; samādhau—in divine consciousness; achalā—steadfast; buddhiḥ—intellect; tadā—at that time; yogam—Yog; avāpsyasi—you will attain ","śhruti-vipratipannā te yadā sthāsyati niśhchalā\n" + "samādhāv-achalā buddhis tadā yogam avāpsyasi",R.color.trans));
        mData.add(new NewsItem("अर्जुन उवाच |\n" + "स्थितप्रज्ञस्य का भाषा समाधिस्थस्य केशव |\n" + "स्थितधी: किं प्रभाषेत किमासीत व्रजेत किम् || 54||"," arjunaḥ uvācha—Arjun said; sthita-prajñasya—one with steady intellect; kā—what; bhāṣhā—talk; samādhi-sthasya—situated in divine consciousness; keśhava—Shree Krishna, killer of the Keshi Demon; sthita-dhīḥ—enlightened person; kim—what; prabhāṣheta—talks; kim—how; āsīta—sits; vrajeta—walks; kim—how ","arjuna uvācha\n" + "sthita-prajñasya kā bhāṣhā samādhi-sthasya keśhava\n" + "sthita-dhīḥ kiṁ prabhāṣheta kim āsīta vrajeta kim",R.color.trans));
        mData.add(new NewsItem("श्रीभगवानुवाच |\n" + "प्रजहाति यदा कामान्सर्वान्पार्थ मनोगतान् |\n" + "आत्मन्येवात्मना तुष्ट: स्थितप्रज्ञस्तदोच्यते || 55||"," śhrī-bhagavān uvācha—The Supreme Lord said; prajahāti—discards; yadā—when; kāmān—selfish desires; sarvān—all; pārtha—Arjun, the son of Pritha; manaḥ-gatān—of the mind; ātmani—of the self; eva—only; ātmanā—by the purified mind; tuṣhṭaḥ—satisfied; sthita-prajñaḥ—one with steady intellect; tadā—at that time; uchyate—is said ","śhrī bhagavān uvācha\n" + "prajahāti yadā kāmān sarvān pārtha mano-gatān\n" + "ātmany-evātmanā tuṣhṭaḥ sthita-prajñas tadochyate",R.color.trans));
        mData.add(new NewsItem("दु:खेष्वनुद्विग्नमना: सुखेषु विगतस्पृह: |\n" + "वीतरागभयक्रोध: स्थितधीर्मुनिरुच्यते || 56||"," duḥkheṣhu—amidst miseries; anudvigna-manāḥ—one whose mind is undisturbed; sukheṣhu—in pleasure; vigata-spṛihaḥ—without craving; vīta—free from; rāga—attachment; bhaya—fear; krodhaḥ—anger; sthita-dhīḥ—enlightened person; muniḥ—a sage; uchyate—is called ","duḥkheṣhv-anudvigna-manāḥ sukheṣhu vigata-spṛihaḥ\n" + "vīta-rāga-bhaya-krodhaḥ sthita-dhīr munir uchyate",R.color.trans));
        mData.add(new NewsItem("य: सर्वत्रानभिस्नेहस्तत्तत्प्राप्य शुभाशुभम् |\n" + "नाभिनन्दति न द्वेष्टि तस्य प्रज्ञा प्रतिष्ठिता || 57||"," yaḥ—who; sarvatra—in all conditions; anabhisnehaḥ—unattached; tat—that; tat—that; prāpya—attaining; śhubha—good; aśhubham—evil; na—neither; abhinandati—delight in; na—nor; dveṣhṭi—dejected by; tasya—his; prajñā—knowledge; pratiṣhṭhitā—is fixed ","yaḥ sarvatrānabhisnehas tat tat prāpya śhubhāśhubham\n" + "nābhinandati na dveṣhṭi tasya prajñā pratiṣhṭhitā",R.color.trans));
        mData.add(new NewsItem("यदा संहरते चायं कूर्मोऽङ्गानीव सर्वश: |\n" + "इन्द्रियाणीन्द्रियार्थेभ्यस्तस्य प्रज्ञा प्रतिष्ठिता || 58||"," yadā—when; sanharate—withdraw; cha—and; ayam—this; kūrmaḥ—tortoise; aṅgāni—limbs; iva—as; sarvaśhaḥ—fully; indriyāṇi—senses; indriya-arthebhyaḥ—from the sense objects; tasya—his; prajñā—divine wisdom; pratiṣhṭhitā—fixed in ","yadā sanharate chāyaṁ kūrmo ’ṅgānīva sarvaśhaḥ\n" + "indriyāṇīndriyārthebhyas tasya prajñā pratiṣhṭhitā",R.color.trans));
        mData.add(new NewsItem("विषया विनिवर्तन्ते निराहारस्य देहिन: |\n" + "रसवर्जं रसोऽप्यस्य परं दृष्ट्वा निवर्तते || 59||"," viṣhayāḥ—objects for senses; vinivartante—restrain; nirāhārasya—practicing self restraint; dehinaḥ—for the embodied; rasa-varjam—cessation of taste; rasaḥ—taste; api—however; asya—person’s; param—the Supreme; dṛiṣhṭvā—on realization; nivartate—ceases to be ","viṣhayā vinivartante nirāhārasya dehinaḥ\n" + "rasa-varjaṁ raso ’pyasya paraṁ dṛiṣhṭvā nivartate",R.color.trans));
        mData.add(new NewsItem("यततो ह्यपि कौन्तेय पुरुषस्य विपश्चित: |\n" + "इन्द्रियाणि प्रमाथीनि हरन्ति प्रसभं मन: || 60||"," yatataḥ—while practicing self-control; hi—for; api—even; kaunteya—Arjun, the son of Kunti; puruṣhasya—of a person; vipaśhchitaḥ—one endowed with discrimination; indriyāṇi—the senses; pramāthīni—turbulent; haranti—carry away; prasabham—forcibly; manaḥ—the mind ","yatato hyapi kaunteya puruṣhasya vipaśhchitaḥ\n" + "indriyāṇi pramāthīni haranti prasabhaṁ manaḥ",R.color.trans));
        mData.add(new NewsItem("तानि सर्वाणि संयम्य युक्त आसीत मत्पर: |\n" + "वशे हि यस्येन्द्रियाणि तस्य प्रज्ञा प्रतिष्ठिता || 61||","tāni—them; sarvāṇi—all; sanyamya—subduing; yuktaḥ—united; āsīta—seated; mat-paraḥ—toward me (Shree Krishna); vaśhe—control; hi—certainly; yasya—whose; indriyāṇi—senses; tasya—their; prajñā—perfect knowledge; pratiṣhṭhitā—is fixed;","tāni sarvāṇi sanyamya yukta āsīta mat-paraḥ\n" + "vaśhe hi yasyendriyāṇi tasya prajñā pratiṣhṭhitā",R.color.trans));
        mData.add(new NewsItem("ध्यायतो विषयान्पुंस: सङ्गस्तेषूपजायते |\n" + "सङ्गात्सञ्जायते काम: कामात्क्रोधोऽभिजायते || 62||"," dhyāyataḥ—contemplating; viṣhayān—sense objects; puṁsaḥ—of a person; saṅgaḥ—attachment; teṣhu—to them (sense objects); upajāyate—arises; saṅgāt—from attachment; sañjāyate—develops; kāmaḥ—desire; kāmāt—from desire; krodhaḥ—anger; abhijāyate—arises ","dhyāyato viṣhayān puṁsaḥ saṅgas teṣhūpajāyate\n" + "saṅgāt sañjāyate kāmaḥ kāmāt krodho ’bhijāyate",R.color.trans));
        mData.add(new NewsItem("क्रोधाद्भवति सम्मोह: सम्मोहात्स्मृतिविभ्रम: |\n" + "स्मृतिभ्रंशाद् बुद्धिनाशो बुद्धिनाशात्प्रणश्यति || 63||"," krodhāt—from anger; bhavati—comes; sammohaḥ—clouding of judgement; sammohāt—from clouding of judgement; smṛiti—memory; vibhramaḥ—bewilderment; smṛiti-bhranśhāt—from bewilderment of memory; buddhi-nāśhaḥ—destruction of intellect; buddhi-nāśhāt—from destruction of intellect; praṇaśhyati—one is ruined ","krodhād bhavati sammohaḥ sammohāt smṛiti-vibhramaḥ\n" + "smṛiti-bhranśhād buddhi-nāśho buddhi-nāśhāt praṇaśhyati",R.color.trans));
        mData.add(new NewsItem("रागद्वेषवियुक्तैस्तु विषयानिन्द्रियैश्चरन् |\n" + "आत्मवश्यैर्विधेयात्मा प्रसादमधिगच्छति || 64||"," rāga—attachment; dveṣha—aversion; viyuktaiḥ—free; tu—but; viṣhayān—objects of the senses; indriyaiḥ—by the senses; charan—while using; ātma-vaśhyaiḥ—controlling one’s mind; vidheya-ātmā—one who controls the mind; prasādam—the Grace of God; adhigachchhati—attains ","rāga-dveṣha-viyuktais tu viṣhayān indriyaiśh charan\n" + "ātma-vaśhyair-vidheyātmā prasādam adhigachchhati",R.color.trans));
        mData.add(new NewsItem("प्रसादे सर्वदु:खानां हानिरस्योपजायते |\n" + "प्रसन्नचेतसो ह्याशु बुद्धि: पर्यवतिष्ठते || 65||"," prasāde—by divine grace; sarva—all; duḥkhānām—of sorrows; hāniḥ—destruction; asya—his; upajāyate—comes; prasanna-chetasaḥ—with a tranquil mind; hi—indeed; āśhu—soon; buddhiḥ—intellect; paryavatiṣhṭhate—becomes firmly established ","prasāde sarva-duḥkhānāṁ hānir asyopajāyate\n" + "prasanna-chetaso hyāśhu buddhiḥ paryavatiṣhṭhate",R.color.trans));
        mData.add(new NewsItem("नास्ति बुद्धिरयुक्तस्य न चायुक्तस्य भावना |\n" + "न चाभावयत: शान्तिरशान्तस्य कुत: सुखम् || 66||"," na—not; asti—is; buddhiḥ—intellect; ayuktasya—not united; na—not; cha—and; ayuktasya—not united; bhāvanā—contemplation; na—nor; cha—and; abhāvayataḥ—for those not united; śhāntiḥ—peace; aśhāntasya—of the unpeaceful; kutaḥ—where; sukham—happiness ","nāsti buddhir-ayuktasya na chāyuktasya bhāvanā\n" + "na chābhāvayataḥ śhāntir aśhāntasya kutaḥ sukham",R.color.trans));
        mData.add(new NewsItem("इन्द्रियाणां हि चरतां यन्मनोऽनुविधीयते |\n" + "तदस्य हरति प्रज्ञां वायुर्नावमिवाम्भसि || 67||"," indriyāṇām—of the senses; hi—indeed; charatām—roaming; yat—which; manaḥ—the mind; anuvidhīyate—becomes constantly engaged; tat—that; asya—of that; harati—carries away; prajñām—intellect; vāyuḥ—wind; nāvam—boat; iva—as; ambhasi—on the water ","indriyāṇāṁ hi charatāṁ yan mano ’nuvidhīyate\n" + "tadasya harati prajñāṁ vāyur nāvam ivāmbhasi",R.color.trans));
        mData.add(new NewsItem("तस्माद्यस्य महाबाहो निगृहीतानि सर्वश: |\n" + "इन्द्रियाणीन्द्रियार्थेभ्यस्तस्य प्रज्ञा प्रतिष्ठिता || 68||"," tasmāt—therefore; yasya—whose; mahā-bāho—mighty-armed one; nigṛihītāni—restrained; sarvaśhaḥ—completely; indriyāṇi—senses; indriya-arthebhyaḥ—from sense objects; tasya—of that person; prajñā—transcendental knowledge; pratiṣhṭhitā—remains fixed ","tasmād yasya mahā-bāho nigṛihītāni sarvaśhaḥ\n" + "indriyāṇīndriyārthebhyas tasya prajñā pratiṣhṭhitā",R.color.trans));
        mData.add(new NewsItem("या निशा सर्वभूतानां तस्यां जागर्ति संयमी |\n" + "यस्यां जाग्रति भूतानि सा निशा पश्यतो मुने: || 69||"," yā—which; niśhā—night; sarva-bhūtānām—of all living beings; tasyām—in that; jāgarti—is awake; sanyamī—self-controlled; yasyām—in which; jāgrati—are awake; bhūtāni—creatures; sā—that; niśhā—night; paśhyataḥ—see; muneḥ—sage ","yā niśhā sarva-bhūtānāṁ tasyāṁ jāgarti sanyamī\n" + "yasyāṁ jāgrati bhūtāni sā niśhā paśhyato muneḥ",R.color.trans));
        mData.add(new NewsItem("आपूर्यमाणमचलप्रतिष्ठं\n" + "समुद्रमाप: प्रविशन्ति यद्वत् |\n" + "तद्वत्कामा यं प्रविशन्ति सर्वे\n" + "स शान्तिमाप्नोति न कामकामी || 70||"," āpūryamāṇam—filled from all sides; achala-pratiṣhṭham—undisturbed; samudram—ocean; āpaḥ—waters; praviśhanti—enter; yadvat—as; tadvat—likewise; kāmāḥ—desires; yam—whom; praviśhanti—enter; sarve—all; saḥ—that person; śhāntim—peace; āpnoti—attains; na—not; kāma-kāmī—one who strives to satisfy desires ","āpūryamāṇam achala-pratiṣhṭhaṁ\n" + "samudram āpaḥ praviśhanti yadvat\n" + "tadvat kāmā yaṁ praviśhanti sarve\n" + "sa śhāntim āpnoti na kāma-kāmī",R.color.trans));
        mData.add(new NewsItem("विहाय कामान्य: सर्वान्पुमांश्चरति नि:स्पृह: |\n" + "निर्ममो निरहङ्कार: स शान्तिमधिगच्छति || 71||"," vihāya—giving up; kāmān—material desires; yaḥ—who; sarvān—all; pumān—a person; charati—lives; niḥspṛihaḥ—free from hankering; nirmamaḥ—without a sense of proprietorship; nirahankāraḥ—without egoism; saḥ—that person; śhāntim—perfect peace; adhigachchhati—attains ","vihāya kāmān yaḥ sarvān pumānśh charati niḥspṛihaḥ\n" + "nirmamo nirahankāraḥ sa śhāntim adhigachchhati",R.color.trans));
        mData.add(new NewsItem("एषा ब्राह्मी स्थिति: पार्थ नैनां प्राप्य विमुह्यति |\n" + "स्थित्वास्यामन्तकालेऽपि ब्रह्मनिर्वाणमृच्छति || 72||"," eṣhā—such; brāhmī sthitiḥ—state of God-realization; pārtha—Arjun, the son of Pritha; na—never; enām—this; prāpya—having attained; vimuhyati—is deluded; sthitvā—being established; asyām—in this; anta-kāle—at the hour of death; api—even; brahma-nirvāṇam—liberation from Maya; ṛichchhati—attains ","eṣhā brāhmī sthitiḥ pārtha naināṁ prāpya vimuhyati\n" + "sthitvāsyām anta-kāle ’pi brahma-nirvāṇam ṛichchhati",R.color.trans));





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

            Intent myIntent = new Intent(this, Chp2.class);
            this.startActivity(myIntent);

        }

        if (id == R.id.verses){

        //    Intent myIntent = new Intent(this, Main2Activity.class);
         //   this.startActivity(myIntent);

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