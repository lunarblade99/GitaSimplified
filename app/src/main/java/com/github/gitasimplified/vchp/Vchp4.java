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
import com.github.gitasimplified.chp.Chp4;
import com.shashank.sony.fancygifdialoglib.FancyGifDialog;
import com.shashank.sony.fancygifdialoglib.FancyGifDialogListener;

import java.util.ArrayList;
import java.util.List;

public class Vchp4 extends AppCompatActivity
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
        navigationView.getMenu().getItem(3).setChecked(true);

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
        mData.add(new NewsItem("श्रीभगवानुवाच |\n" + "इमं विवस्वते योगं प्रोक्तवानहमव्ययम् |\n" + "विवस्वान्मनवे प्राह मनुरिक्ष्वाकवेऽब्रवीत् || 1||"," śhrī-bhagavān uvācha—the Supreme Lord Shree Krishna said; imam—this; vivasvate—to the Sun-god; yogam—the science of Yog; proktavān—taught; aham—I; avyayam—eternal; vivasvān—Sun-god; manave—to Manu, the original progenitor of humankind; prāha—told; manuḥ—Manu; ikṣhvākave—to Ikshvaku, first king of the Solar dynasty; abravīt—instructed ","śhrī bhagavān uvācha\n" + "imaṁ vivasvate yogaṁ proktavān aham avyayam\n" + "vivasvān manave prāha manur ikṣhvākave ’bravīt",R.color.trans));
        mData.add(new NewsItem("एवं परम्पराप्राप्तमिमं राजर्षयो विदु: |\n" + "स कालेनेह महता योगो नष्ट: परन्तप || 2||"," evam—thus; paramparā—in a continuous tradition; prāptam—received; imam—this (science); rāja-ṛiṣhayaḥ—the saintly kings; viduḥ—understood; saḥ—that; kālena—with the long passage of time; iha—in this world; mahatā—great; yogaḥ—the science of Yog; naṣhṭaḥ—lost; parantapa—Arjun, the scorcher of foes ","evaṁ paramparā-prāptam imaṁ rājarṣhayo viduḥ\n" + "sa kāleneha mahatā yogo naṣhṭaḥ parantapa",R.color.trans));
        mData.add(new NewsItem("स एवायं मया तेऽद्य योग: प्रोक्त: पुरातन: |\n" + "भक्तोऽसि मे सखा चेति रहस्यं ह्येतदुत्तमम् || 3||"," saḥ—that; eva—certainly; ayam—this; mayā—by me; te—unto you; adya—today; yogaḥ—the science of Yog; proktaḥ—reveal; purātanaḥ—ancient; bhaktaḥ—devotee; asi—you are; me—my; sakhā—friend; cha—and; iti—therefore; rahasyam—secret; hi—certainly; etat—this; uttamam—supreme ","sa evāyaṁ mayā te ’dya yogaḥ proktaḥ purātanaḥ\n" + "bhakto ’si me sakhā cheti rahasyaṁ hyetad uttamam",R.color.trans));
        mData.add(new NewsItem("अर्जुन उवाच |\n" + "अपरं भवतो जन्म परं जन्म विवस्वत: |\n" + "कथमेतद्विजानीयां त्वमादौ प्रोक्तवानिति || 4||"," arjunaḥ uvācha—Arjun said; aparam—later; bhavataḥ—your; janma—birth; param—prior; janma—birth; vivasvataḥ—Vivasvan, the sun-god; katham—how; etat—this; vijānīyām—am I to understand; tvam—you; ādau—in the beginning; proktavān—taught; iti—thus ","arjuna uvācha\n" + "aparaṁ bhavato janma paraṁ janma vivasvataḥ\n" + "katham etad vijānīyāṁ tvam ādau proktavān iti",R.color.trans));
        mData.add(new NewsItem("श्रीभगवानुवाच |\n" + "बहूनि मे व्यतीतानि जन्मानि तव चार्जुन |\n" + "तान्यहं वेद सर्वाणि न त्वं वेत्थ परन्तप || 5||"," śhrī-bhagavān uvācha—the Supreme Lord said; bahūni—many; me—of mine; vyatītāni—have passed; janmāni—births; tava—of yours; cha—and; arjuna—Arjun; tāni—them; aham—I; veda—know; sarvāṇi—all; na—not; tvam—you; vettha—know; parantapa—Arjun, the scorcher of foes ","śhrī bhagavān uvācha\n" + "bahūni me vyatītāni janmāni tava chārjuna\n" + "tānyahaṁ veda sarvāṇi na tvaṁ vettha parantapa",R.color.trans));
        mData.add(new NewsItem("अजोऽपि सन्नव्ययात्मा भूतानामीश्वरोऽपि सन् |\n" + "प्रकृतिं स्वामधिष्ठाय सम्भवाम्यात्ममायया || 6||"," ajaḥ—unborn; api—although; san—being so; avyaya ātmā—Imperishable nature; bhūtānām—of (all) beings; īśhvaraḥ—the Lord; api—although; san—being; prakṛitim—nature; svām—of myself; adhiṣhṭhāya—situated; sambhavāmi—I manifest; ātma-māyayā—by my Yogmaya power ","ajo ’pi sannavyayātmā bhūtānām īśhvaro ’pi san\n" + "prakṛitiṁ svām adhiṣhṭhāya sambhavāmyātma-māyayā",R.color.trans));
        mData.add(new NewsItem("यदा यदा हि धर्मस्य ग्लानिर्भवति भारत |\n" + "अभ्युत्थानमधर्मस्य तदात्मानं सृजाम्यहम् || 7||"," yadā yadā—whenever; hi—certainly; dharmasya—of righteousness; glāniḥ—decline; bhavati—is; bhārata—Arjun, descendant of Bharat; abhyutthānam—increase; adharmasya—of unrighteousness; tadā—at that time; ātmānam—self; sṛijāmi—manifest; aham—I ","yadā yadā hi dharmasya glānir bhavati bhārata\n" + "abhyutthānam adharmasya tadātmānaṁ sṛijāmyaham",R.color.trans));
        mData.add(new NewsItem("परित्राणाय साधूनां विनाशाय च दुष्कृताम् |\n" + "धर्मसंस्थापनार्थाय सम्भवामि युगे युगे || 8||"," paritrāṇāya—to protect; sādhūnām—the righteous; vināśhāya—to annihilate; cha—and; duṣhkṛitām—the wicked; dharma—the eternal religion; sansthāpana-arthāya—to reestablish; sambhavāmi—I appear; yuge yuge—age after age ","paritrāṇāya sādhūnāṁ vināśhāya cha duṣhkṛitām\n" + "dharma-sansthāpanārthāya sambhavāmi yuge yuge",R.color.trans));
        mData.add(new NewsItem("जन्म कर्म च मे दिव्यमेवं यो वेत्ति तत्त्वत: |\n" + "त्यक्त्वा देहं पुनर्जन्म नैति मामेति सोऽर्जुन || 9||"," janma—birth; karma—activities; cha—and; me—of mine; divyam—divine; evam—thus; yaḥ—who; vetti—know; tattvataḥ—in truth; tyaktvā—having abandoned; deham—the body; punaḥ—again; janma—birth; na—never; eti—takes; mām—to me; eti—comes; saḥ—he; arjuna—Arjun ","janma karma cha me divyam evaṁ yo vetti tattvataḥ\n" + "tyaktvā dehaṁ punar janma naiti mām eti so arjuna",R.color.trans));
        mData.add(new NewsItem("वीतरागभयक्रोधा मन्मया मामुपाश्रिता: |\n" + "बहवो ज्ञानतपसा पूता मद्भावमागता: || 10||"," vīta—freed from; rāga—attachment; bhaya—fear; krodhāḥ—and anger; mat-mayā—completely absorbed in me; mām—in me; upāśhritāḥ—taking refuge (of); bahavaḥ—many (persons); jñāna—of knowledge; tapasā—by the fire of knowledge; pūtāḥ—purified; mat-bhāvam—my divine love; āgatāḥ—attained ","vīta-rāga-bhaya-krodhā man-mayā mām upāśhritāḥ\n" + "bahavo jñāna-tapasā pūtā mad-bhāvam āgatāḥ",R.color.trans));
        mData.add(new NewsItem("ये यथा मां प्रपद्यन्ते तांस्तथैव भजाम्यहम् |\n" + "मम वर्त्मानुवर्तन्ते मनुष्या: पार्थ सर्वश: || 11||"," ye—who; yathā—in whatever way; mām—unto me; prapadyante—surrender; tān—them; tathā—so; eva—certainly; bhajāmi—reciprocate; aham—I; mama—my; vartma—path; anuvartante—follow; manuṣhyāḥ—men; pārtha—Arjun, the son of Pritha; sarvaśhaḥ—in all respects ","\n" + "\n" + "ye yathā māṁ prapadyante tāns tathaiva bhajāmyaham\n" + "mama vartmānuvartante manuṣhyāḥ pārtha sarvaśhaḥ\n",R.color.trans));
        mData.add(new NewsItem("काङ् क्षन्त: कर्मणां सिद्धिं यजन्त इह देवता: |\n" + "क्षिप्रं हि मानुषे लोके सिद्धिर्भवति कर्मजा || 12||"," kāṅkṣhantaḥ—desiring; karmaṇām—material activities; siddhim—success; yajante—worship; iha—in this world; devatāḥ—the celestial gods; kṣhipram—quickly; hi—certainly; mānuṣhe—in human society; loke—within this world; siddhiḥ—rewarding; bhavati—manifest; karma-jā—from material activities ","kāṅkṣhantaḥ karmaṇāṁ siddhiṁ yajanta iha devatāḥ\n" + "kṣhipraṁ hi mānuṣhe loke siddhir bhavati karmajā",R.color.trans));
        mData.add(new NewsItem("चातुर्वर्ण्यं मया सृष्टं गुणकर्मविभागश: |\n" + "तस्य कर्तारमपि मां विद्ध्यकर्तारमव्ययम् || 13||"," chātuḥ-varṇyam—the four categories of occupations; mayā—by me; sṛiṣhṭam—were created; guṇa—of quality; karma—and activities; vibhāgaśhaḥ—according to divisions; tasya—of that; kartāram—the creator; api—although; mām—me; viddhi—know; akartāram—non-doer; avyayam—unchangeable ","chātur-varṇyaṁ mayā sṛiṣhṭaṁ guṇa-karma-vibhāgaśhaḥ\n" + "tasya kartāram api māṁ viddhyakartāram avyayam",R.color.trans));
        mData.add(new NewsItem("न मां कर्माणि लिम्पन्ति न मे कर्मफले स्पृहा |\n" + "इति मां योऽभिजानाति कर्मभिर्न स बध्यते || 14||"," na—not; mām—me; karmāṇi—activities; limpanti—taint; na—nor; me—my; karma-phale—the fruits of action; spṛihā—desire; iti—thus; mām—me; yaḥ—who; abhijānāti—knows; karmabhiḥ—result of action; na—never; saḥ—that person; badhyate—is bound ","na māṁ karmāṇi limpanti na me karma-phale spṛihā\n" + "iti māṁ yo ’bhijānāti karmabhir na sa badhyate",R.color.trans));
        mData.add(new NewsItem("एवं ज्ञात्वा कृतं कर्म पूर्वैरपि मुमुक्षुभि: |\n" + "कुरु कर्मैव तस्मात्त्वं पूर्वै: पूर्वतरं कृतम् || 15||"," evam—thus; jñātvā—knowing; kṛitam—performed; karma—actions; pūrvaiḥ—of ancient times; api—indeed; mumukṣhubhiḥ—seekers of liberation; kuru—should perform; karma—duty; eva—certainly; tasmāt—therefore; tvam—you; pūrvaiḥ—of those ancient sages; pūrva-taram—in ancient times; kṛitam—performed ","\n" + "\n" + "evaṁ jñātvā kṛitaṁ karma pūrvair api mumukṣhubhiḥ\n" + "kuru karmaiva tasmāttvaṁ pūrvaiḥ pūrvataraṁ kṛitam\n",R.color.trans));
        mData.add(new NewsItem("किं कर्म किमकर्मेति कवयोऽप्यत्र मोहिता: |\n" + "तत्ते कर्म प्रवक्ष्यामि यज्ज्ञात्वा मोक्ष्यसेऽशुभात् || 16||"," kim—what; karma—action; kim—what; akarma—inaction; iti—thus; kavayaḥ—the wise; api—even; atra—in this; mohitāḥ—are confused; tat—that; te—to you; karma—action; pravakṣhyāmi—I shall explain; yat—which; jñātvā—knowing; mokṣhyase—you may free yourself; aśhubhāt—from inauspiciousness ","kiṁ karma kim akarmeti kavayo ’pyatra mohitāḥ\n" + "tat te karma pravakṣhyāmi yaj jñātvā mokṣhyase ’śhubhāt",R.color.trans));
        mData.add(new NewsItem("कर्मणो ह्यपि बोद्धव्यं बोद्धव्यं च विकर्मण: |\n" + "अकर्मणश्च बोद्धव्यं गहना कर्मणो गति: || 17||"," karmaṇaḥ—recommended action; hi—certainly; api—also; boddhavyam—should be known; boddhavyam—must understand; cha—and; vikarmaṇaḥ—forbidden action; akarmaṇaḥ—inaction; cha—and; boddhavyam—must understand; gahanā—profound; karmaṇaḥ—of action; gatiḥ—the true path ","karmaṇo hyapi boddhavyaṁ boddhavyaṁ cha vikarmaṇaḥ\n" + "akarmaṇaśh cha boddhavyaṁ gahanā karmaṇo gatiḥ",R.color.trans));
        mData.add(new NewsItem("कर्मण्यकर्म य: पश्येदकर्मणि च कर्म य: |\n" + "स बुद्धिमान्मनुष्येषु स युक्त: कृत्स्नकर्मकृत् || 18||"," karmaṇi—action; akarma—in inaction; yaḥ—who; paśhyet—see; akarmaṇi—inaction; cha—also; karma—action; yaḥ—who; saḥ—they; buddhi-mān—wise; manuṣhyeṣhu—amongst humans; saḥ—they; yuktaḥ—yogis; kṛitsna-karma-kṛit—performers all kinds of actions ","karmaṇyakarma yaḥ paśhyed akarmaṇi cha karma yaḥ\n" + "sa buddhimān manuṣhyeṣhu sa yuktaḥ kṛitsna-karma-kṛit",R.color.trans));
        mData.add(new NewsItem("यस्य सर्वे समारम्भा: कामसङ्कल्पवर्जिता: |\n" + "ज्ञानाग्निदग्धकर्माणं तमाहु: पण्डितं बुधा: || 19||"," yasya—whose; sarve—every; samārambhāḥ—undertakings; kāma—desire for material pleasures; saṅkalpa—resolve; varjitāḥ—devoid of; jñāna—divine knowledge; agni—in the fire; dagdha—burnt; karmāṇam—actions; tam—him; āhuḥ—address; paṇḍitam—a sage; budhāḥ—the wise ","yasya sarve samārambhāḥ kāma-saṅkalpa-varjitāḥ\n" + "jñānāgni-dagdha-karmāṇaṁ tam āhuḥ paṇḍitaṁ budhāḥ",R.color.trans));
        mData.add(new NewsItem("त्यक्त्वा कर्मफलासङ्गं नित्यतृप्तो निराश्रय: |\n" + "कर्मण्यभिप्रवृत्तोऽपि नैव किञ्चित्करोति स: || 20||"," tyaktvā—having given up; karma-phala-āsaṅgam—attachment to the fruits of action; nitya—always; tṛiptaḥ—satisfied; nirāśhrayaḥ—without dependence; karmaṇi—in activities; abhipravṛittaḥ—engaged; api—despite; na—not; eva—certainly; kiñchit—anything; karoti—do; saḥ—that person ","tyaktvā karma-phalāsaṅgaṁ nitya-tṛipto nirāśhrayaḥ\n" + "karmaṇyabhipravṛitto ’pi naiva kiñchit karoti saḥ",R.color.trans));
        mData.add(new NewsItem("निराशीर्यतचित्तात्मा त्यक्तसर्वपरिग्रह: |\n" + "शारीरं केवलं कर्म कुर्वन्नाप्नोति किल्बिषम् || 21||"," nirāśhīḥ—free from expectations; yata—controlled; chitta-ātmā—mind and intellect; tyakta—having abandoned; sarva—all; parigrahaḥ—the sense of ownership; śhārīram—bodily; kevalam—only; karma—actions; kurvan—performing; na—never; āpnoti—incurs; kilbiṣham—sin ","nirāśhīr yata-chittātmā tyakta-sarva-parigrahaḥ\n" + "śhārīraṁ kevalaṁ karma kurvan nāpnoti kilbiṣham",R.color.trans));
        mData.add(new NewsItem("यदृच्छालाभसन्तुष्टो द्वन्द्वातीतो विमत्सर: |\n" + "सम: सिद्धावसिद्धौ च कृत्वापि न निबध्यते || 22||"," yadṛichchhā—which comes of its own accord; lābha—gain; santuṣhṭaḥ—contented; dvandva—duality; atītaḥ—surpassed; vimatsaraḥ—free from envy; samaḥ—equipoised; siddhau—in success; asiddhau—failure; cha—and; kṛitvā—performing; api—even; na—never; nibadhyate—is bound ","yadṛichchhā-lābha-santuṣhṭo dvandvātīto vimatsaraḥ\n" + "samaḥ siddhāvasiddhau cha kṛitvāpi na nibadhyate",R.color.trans));
        mData.add(new NewsItem("गतसङ्गस्य मुक्तस्य ज्ञानावस्थितचेतस: |\n" + "यज्ञायाचरत: कर्म समग्रं प्रविलीयते || 23||"," gata-saṅgasya—free from material attachments; muktasya—of the liberated; jñāna-avasthita—established in divine knowledge; chetasaḥ—whose intellect; yajñāya—as a sacrifice (to God); ācharataḥ—performing; karma—action; samagram—completely; pravilīyate—are freed ","gata-saṅgasya muktasya jñānāvasthita-chetasaḥ\n" + "yajñāyācharataḥ karma samagraṁ pravilīyate",R.color.trans));
        mData.add(new NewsItem("ब्रह्मार्पणं ब्रह्म हविर्ब्रह्माग्नौ ब्रह्मणा हुतम् |\n" + "ब्रह्मैव तेन गन्तव्यं ब्रह्मकर्मसमाधिना || 24||"," brahma—Brahman; arpaṇam—the ladle and other offerings; brahma—Brahman; haviḥ—the oblation; brahma—Brahman; agnau—in the sacrificial fire; brahmaṇā—by that person; hutam—offered; brahma—Brahman; eva—certainly; tena—by that; gantavyam—to be attained; brahma—Brahman; karma—offering; samādhinā—those completely absorbed in God-consciousness ","brahmārpaṇaṁ brahma havir brahmāgnau brahmaṇā hutam\n" + "brahmaiva tena gantavyaṁ brahma-karma-samādhinā",R.color.trans));
        mData.add(new NewsItem("दैवमेवापरे यज्ञं योगिन: पर्युपासते |\n" + "ब्रह्माग्नावपरे यज्ञं यज्ञेनैवोपजुह्वति || 25||"," daivam—the celestial gods; eva—indeed; apare—others; yajñam—sacrifice; yoginaḥ—spiritual practioners; paryupāsate—worship; brahma—of the Supreme Truth; agnau—in the fire; apare—others; yajñam—sacrifice; yajñena—by sacrifice; eva—indeed; upajuhvati—offer ","daivam evāpare yajñaṁ yoginaḥ paryupāsate\n" + "brahmāgnāvapare yajñaṁ yajñenaivopajuhvati",R.color.trans));
        mData.add(new NewsItem("श्रोत्रादीनीन्द्रियाण्यन्ये संयमाग्निषु जुह्वति |\n" + "शब्दादीन्विषयानन्य इन्द्रियाग्निषु जुह्वति || 26||"," śhrotra-ādīni—such as the hearing process; indriyāṇi—senses; anye—others; sanyama—restraint; agniṣhu—in the sacrficial fire; juhvati—sacrifice; śhabda-ādīn—sound vibration, etc; viṣhayān—objects of sense-gratification; anye—others; indriya—of the senses; agniṣhu—in the fire; juhvati—sacrifice ","śhrotrādīnīndriyāṇyanye sanyamāgniṣhu juhvati\n" + "śhabdādīn viṣhayānanya indriyāgniṣhu juhvati",R.color.trans));
        mData.add(new NewsItem("सर्वाणीन्द्रियकर्माणि प्राणकर्माणि चापरे |\n" + "आत्मसंयमयोगाग्नौ जुह्वति ज्ञानदीपिते || 27||"," sarvāṇi—all; indriya—the senses; karmāṇi—functions; prāṇa-karmāṇi—functions of the life breath; cha—and; apare—others; ātma-sanyama yogāgnau—in the fire of the controlled mind; juhvati—sacrifice; jñāna-dīpite—kindled by knowledge ","sarvāṇīndriya-karmāṇi prāṇa-karmāṇi chāpare\n" + "ātma-sanyama-yogāgnau juhvati jñāna-dīpite",R.color.trans));
        mData.add(new NewsItem("द्रव्ययज्ञास्तपोयज्ञा योगयज्ञास्तथापरे |\n" + "स्वाध्यायज्ञानयज्ञाश्च यतय: संशितव्रता: || 28||"," dravya-yajñāḥ—offering one’s own wealth as sacrifice; tapaḥ-yajñāḥ—offering severe austerities as sacrifice; yoga-yajñāḥ—performance of eight-fold path of yogic practices as sacrifice; tathā—thus; apare—others; swādhyāya—cultivating knowledge by studying the scriptures; jñāna-yajñāḥ—those offer cultivation of transcendental knowledge as sacrifice; cha—also; yatayaḥ—these ascetics; sanśhita-vratāḥ—observing strict vows ","dravya-yajñās tapo-yajñā yoga-yajñās tathāpare\n" + "swādhyāya-jñāna-yajñāśh cha yatayaḥ sanśhita-vratāḥ",R.color.trans));
        mData.add(new NewsItem("अपाने जुह्वति प्राणं प्राणेऽपानं तथापरे |\n" + "प्राणापानगती रुद्ध्वा प्राणायामपरायणा: || 29||\n" + "अपरे नियताहारा: प्राणान्प्राणेषु जुह्वति |\n" + "सर्वेऽप्येते यज्ञविदो यज्ञक्षपितकल्मषा: || 30||"," apāne—the incoming breath; juhvati—offer; prāṇam—the outgoing breath; prāṇe—in the outgoing breath; apānam—incoming breath; tathā—also; apare—others; prāṇa—of the outgoing breath; apāna—and the incoming breath; gatī—movement; ruddhvā—blocking; prāṇa-āyāma—control of breath; parāyaṇāḥ—wholly devoted; apare—others; niyata—having controlled; āhārāḥ—food intake; prāṇān—life-breaths; prāṇeṣhu—life-energy; juhvati—sacrifice; sarve—all; api—also; ete—these; yajña-vidaḥ—knowers of sacrifices; yajña-kṣhapita—being cleansed by performances of sacrifices; kalmaṣhāḥ—of impurities ","apāne juhvati prāṇaṁ prāṇe ’pānaṁ tathāpare\n" + "prāṇāpāna-gatī ruddhvā prāṇāyāma-parāyaṇāḥ\n" + "apare niyatāhārāḥ prāṇān prāṇeṣhu juhvati\n" + "sarve ’pyete yajña-vido yajña-kṣhapita-kalmaṣhāḥ",R.color.trans));
        mData.add(new NewsItem("यज्ञशिष्टामृतभुजो यान्ति ब्रह्म सनातनम् |\n" + "नायं लोकोऽस्त्ययज्ञस्य कुतोऽन्य: कुरुसत्तम || 31||"," yajña-śhiṣhṭa amṛita-bhujaḥ—they partake of the nectarean remnants of sacrifice; yānti—go; brahma—the Absolute Truth; sanātanam—eternal; na—never; ayam—this; lokaḥ—planet; asti—is; ayajñasya—for one who performs no sacrifice; kutaḥ—how; anyaḥ—other (world); kuru-sat-tama—best of the Kurus, Arjun ","yajña-śhiṣhṭāmṛita-bhujo yānti brahma sanātanam\n" + "nāyaṁ loko ’styayajñasya kuto ’nyaḥ kuru-sattama",R.color.trans));
        mData.add(new NewsItem("एवं बहुविधा यज्ञा वितता ब्रह्मणो मुखे |\n" + "कर्मजान्विद्धि तान्सर्वानेवं ज्ञात्वा विमोक्ष्यसे || 32||"," evam—thus; bahu-vidhāḥ—various kinds of; yajñāḥ—sacrifices; vitatāḥ—have been described; brahmaṇaḥ—of the Vedas; mukhe—through the mouth; karma-jān—originating from works; viddhi—know; tān—them; sarvān—all; evam—thus; jñātvā—having known; vimokṣhyase—you shall be liberated ","evaṁ bahu-vidhā yajñā vitatā brahmaṇo mukhe\n" + "karma-jān viddhi tān sarvān evaṁ jñātvā vimokṣhyase",R.color.trans));
        mData.add(new NewsItem("श्रेयान्द्रव्यमयाद्यज्ञाज्ज्ञानयज्ञ: परन्तप |\n" + "सर्वं कर्माखिलं पार्थ ज्ञाने परिसमाप्यते || 33||"," śhreyān—superior; dravya-mayāt—of material possessions; yajñāt—than the sacrifice; jñāna-yajñaḥ—sacrifice performed in knowledge; parantapa—subduer of enemies, Arjun; sarvam—all; karma—works; akhilam—all; pārtha—Arjun, the son of Pritha; jñāne—in knowledge; parisamāpyate—culminate ","śhreyān dravya-mayād yajñāj jñāna-yajñaḥ parantapa\n" + "sarvaṁ karmākhilaṁ pārtha jñāne parisamāpyate",R.color.trans));
        mData.add(new NewsItem("तद्विद्धि प्रणिपातेन परिप्रश्नेन सेवया |\n" + "उपदेक्ष्यन्ति ते ज्ञानं ज्ञानिनस्तत्त्वदर्शिन: || 34||"," tat—the Truth; viddhi—try to learn; praṇipātena—by approaching a spiritual master; paripraśhnena—by humble inquiries; sevayā—by rendering service; upadekṣhyanti—can impart; te—unto you; jñānam—knowledge; jñāninaḥ—the enlightened; tattva-darśhinaḥ—those who have realized the Truth ","tad viddhi praṇipātena paripraśhnena sevayā\n" + "upadekṣhyanti te jñānaṁ jñāninas tattva-darśhinaḥ",R.color.trans));
        mData.add(new NewsItem("यज्ज्ञात्वा न पुनर्मोहमेवं यास्यसि पाण्डव |\n" + "येन भूतान्यशेषेण द्रक्ष्यस्यात्मन्यथो मयि || 35||"," yat—which; jñātvā—having known; na—never; punaḥ—again; moham—delusion; evam—like this; yāsyasi—you shall get; pāṇḍava—Arjun, the son of Pandu; yena—by this; bhūtāni—living beings; aśheṣhāṇi—all; drakṣhyasi—you will see; ātmani—within me (Shree Krishna); atho—that is to say; mayi—in me ","yaj jñātvā na punar moham evaṁ yāsyasi pāṇḍava\n" + "yena bhūtānyaśheṣheṇa drakṣhyasyātmanyatho mayi",R.color.trans));
        mData.add(new NewsItem("अपि चेदसि पापेभ्य: सर्वेभ्य: पापकृत्तम: |\n" + "सर्वं ज्ञानप्लवेनैव वृजिनं सन्तरिष्यसि || 36||"," api—even; chet—if; asi—you are; pāpebhyaḥ—sinners; sarvebhyaḥ—of all; pāpa-kṛit-tamaḥ—most sinful; sarvam—all; jñāna-plavena—by the boat of divine knowledge; eva—certainly; vṛijinam—sin; santariṣhyasi—you shall cross over ","api ched asi pāpebhyaḥ sarvebhyaḥ pāpa-kṛit-tamaḥ\n" + "sarvaṁ jñāna-plavenaiva vṛijinaṁ santariṣhyasi",R.color.trans));
        mData.add(new NewsItem("यथैधांसि समिद्धोऽग्निर्भस्मसात्कुरुतेऽर्जुन |\n" + "ज्ञानाग्नि: सर्वकर्माणि भस्मसात्कुरुते तथा || 37||"," yathā—as; edhānsi—firewood; samiddhaḥ—blazing; agniḥ—fire; bhasma-sāt—to ashes; kurute—turns; arjuna—Arjun; jñāna-agniḥ—the fire of knowledge; sarva-karmāṇi—all reactions from material activities; bhasma-sāt—to ashes; kurute—it turns; tathā—similarly ","yathaidhānsi samiddho ’gnir bhasma-sāt kurute ’rjuna\n" + "jñānāgniḥ sarva-karmāṇi bhasma-sāt kurute tathā",R.color.trans));
        mData.add(new NewsItem("न हि ज्ञानेन सदृशं पवित्रमिह विद्यते |\n" + "तत्स्वयं योगसंसिद्ध: कालेनात्मनि विन्दति || 38||"," na—not; hi—certainly; jñānena—with divine knowledge; sadṛiśham—like; pavitram—pure; iha—in this world; vidyate—exists; tat—that; svayam—oneself; yoga—practice of yog; sansiddhaḥ—he who has attained perfection; kālena—in course of time; ātmani—wihtin the heart; vindati—finds ","na hi jñānena sadṛiśhaṁ pavitramiha vidyate\n" + "tatsvayaṁ yogasansiddhaḥ kālenātmani vindati",R.color.trans));
        mData.add(new NewsItem("श्रद्धावान् लभते ज्ञानं तत्पर: संयतेन्द्रिय: |\n" + "ज्ञानं लब्ध्वा परां शान्तिमचिरेणाधिगच्छति || 39||"," śhraddhā-vān—a faithful person; labhate—achieves; jñānam—divine knowledge; tat-paraḥ—devoted (to that); sanyata—controlled; indriyaḥ—senses; jñānam—transcendental knowledge; labdhvā—having achieved; parām—supreme; śhāntim—peace; achireṇa—without delay; adhigachchhati—attains ","śhraddhāvān labhate jñānaṁ tat-paraḥ sanyatendriyaḥ\n" + "jñānaṁ labdhvā parāṁ śhāntim achireṇādhigachchhati",R.color.trans));
        mData.add(new NewsItem("अज्ञश्चाश्रद्दधानश्च संशयात्मा विनश्यति |\n" + "नायं लोकोऽस्ति न परो न सुखं संशयात्मन: || 40||"," ajñaḥ—the ignorant; cha—and; aśhraddadhānaḥ—without faith; cha—and; sanśhaya—skeptical; ātmā—a person; vinaśhyati—falls down; na—never; ayam—in this; lokaḥ—world; asti—is; na—not; paraḥ—in the next; na—not; sukham—happiness; sanśhaya-ātmanaḥ—for the skeptical soul ","ajñaśh chāśhraddadhānaśh cha sanśhayātmā vinaśhyati\n" + "nāyaṁ loko ’sti na paro na sukhaṁ sanśhayātmanaḥ",R.color.trans));
        mData.add(new NewsItem("योगसंन्यस्तकर्माणं ज्ञानसञ्छिन्नसंशयम् |\n" + "आत्मवन्तं न कर्माणि निबध्नन्ति धनञ्जय || 41||"," yoga-sannyasta-karmāṇam—those who renounce ritualistic karm, dedicating their body, mind, and soul to God; jñāna—by knowledge; sañchhinna—dispelled; sanśhayam—doubts; ātma-vantam—situated in knowledge of the self; na—not; karmāṇi—actions; nibadhnanti—bind; dhanañjaya—Arjun, the conqueror of wealth ","yoga-sannyasta-karmāṇaṁ jñāna-sañchhinna-sanśhayam\n" + "ātmavantaṁ na karmāṇi nibadhnanti dhanañjaya",R.color.trans));
        mData.add(new NewsItem("तस्मादज्ञानसम्भूतं हृत्स्थं ज्ञानासिनात्मन: |\n" + "छित्त्वैनं संशयं योगमातिष्ठोत्तिष्ठ भारत || 42||"," tasmāt—therefore; ajñāna-sambhūtam—born of ignorance; hṛit-stham—situated in the heart; jñāna—of knowledge; asinā—with the sword; ātmanaḥ—of the self; chhittvā—cut asunder; enam—this; sanśhayam—doubt; yogam—in karm yog; ātiṣhṭha—take shelter; uttiṣhṭha—arise; bhārata—Arjun, descendant of Bharat ","tasmād ajñāna-sambhūtaṁ hṛit-sthaṁ jñānāsinātmanaḥ\n" + "chhittvainaṁ sanśhayaṁ yogam ātiṣhṭhottiṣhṭha bhārata",R.color.trans));



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
                            Intent intent = new Intent(Vchp4.this, CloseActivity.class);
                            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                            startActivity(intent);                         }
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

            Intent myIntent = new Intent(this, Chp4.class);
            this.startActivity(myIntent);

        }

        if (id == R.id.verses){

        //    Intent myIntent = new Intent(this, Main2Activity.class);
         //   this.startActivity(myIntent);

        }

        if (id == R.id.explain){

            //   Intent myIntent = new Intent(this, Explaination.class);
            //   this.startActivity(myIntent);

            new FancyGifDialog.Builder(Vchp4.this)
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