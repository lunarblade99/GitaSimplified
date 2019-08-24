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

import com.github.gitasimplified.Aboutus;
import com.github.gitasimplified.CloseActivity;
import com.github.gitasimplified.Main2Activity;
import com.github.gitasimplified.NewsAdapter2;
import com.github.gitasimplified.NewsItem;
import com.github.gitasimplified.R;
import com.github.gitasimplified.chp.Chp5;
import com.shashank.sony.fancygifdialoglib.FancyGifDialog;
import com.shashank.sony.fancygifdialoglib.FancyGifDialogListener;

import java.util.ArrayList;
import java.util.List;

public class Vchp5 extends AppCompatActivity
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
        navigationView.getMenu().getItem(4).setChecked(true);

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
        mData.add(new NewsItem("अर्जुन उवाच |\n" + "संन्यासं कर्मणां कृष्ण पुनर्योगं च शंससि |\n" + "यच्छ्रेय एतयोरेकं तन्मे ब्रूहि सुनिश्चितम् || 1||"," arjunaḥ uvācha—Arjun said; sanyāsam—renunciation; karmaṇām—of actions; kṛiṣhṇa—Shree Krishna; punaḥ—again; yogam—about karm yog; cha—also; śhansasi—You praise; yat—which; śhreyaḥ—more beneficial; etayoḥ—of the two; ekam—one; tat—that; me—unto me; brūhi—please tell; su-niśhchitam—conclusively ","arjuna uvācha\n" + "sannyāsaṁ karmaṇāṁ kṛiṣhṇa punar yogaṁ cha śhansasi\n" + "yach chhreya etayor ekaṁ tan me brūhi su-niśhchitam",R.color.trans));
        mData.add(new NewsItem("श्रीभगवानुवाच |\n" + "संन्यास: कर्मयोगश्च नि:श्रेयसकरावुभौ |\n" + "तयोस्तु कर्मसंन्यासात्कर्मयोगो विशिष्यते || 2||"," śhrī-bhagavān uvācha—the Supreme Lord said; sanyāsaḥ—renunciation; karma-yogaḥ—working in devotion; cha—and; niḥśhreyasa-karau—lead to the supreme goal; ubhau—both; tayoḥ—of the two; tu—but; karma-sanyāsāt—renunciation of actions; karma-yogaḥ—working in devotion; viśhiṣhyate—is superior\n","śhrī bhagavān uvācha\n" + "sannyāsaḥ karma-yogaśh cha niḥśhreyasa-karāvubhau\n" + "tayos tu karma-sannyāsāt karma-yogo viśhiṣhyate",R.color.trans));
        mData.add(new NewsItem("ज्ञेय: स नित्यसंन्यासी यो न द्वेष्टि न काङ् क्षति |\n" + "निर्द्वन्द्वो हि महाबाहो सुखं बन्धात्प्रमुच्यते || 3||"," jñeyaḥ—should be considered; saḥ—that person; nitya—always; sanyāsī—practising renunciation; yaḥ—who; na—never; dveṣhṭi—hate; na—nor; kāṅkṣhati—desire; nirdvandvaḥ—free from all dualities; hi—certainly; mahā-bāho—mighty-armed one; sukham—easily; bandhāt—from bondage; pramuchyate—is liberated ","jñeyaḥ sa nitya-sannyāsī yo na dveṣhṭi na kāṅkṣhati\n" + "nirdvandvo hi mahā-bāho sukhaṁ bandhāt pramuchyate",R.color.trans));
        mData.add(new NewsItem("साङ्ख्ययोगौ पृथग्बाला: प्रवदन्ति न पण्डिता: |\n" + "एकमप्यास्थित: सम्यगुभयोर्विन्दते फलम् || 4||"," sānkhya—renunciation of actions; yogau—karm yog; pṛithak—different; bālāḥ—the ignorant; pravadanti—say; na—never; paṇḍitāḥ—the learned; ekam—in one; api—even; āsthitaḥ—being situated; samyak—completely; ubhayoḥ—of both; vindate—achieve; phalam—the result ","sānkhya-yogau pṛithag bālāḥ pravadanti na paṇḍitāḥ\n" + "ekamapyāsthitaḥ samyag ubhayor vindate phalam",R.color.trans));
        mData.add(new NewsItem("यत्साङ्ख्यै: प्राप्यते स्थानं तद्योगैरपि गम्यते |\n" + "एकं साङ्ख्यं च योगं च य: पश्यति स पश्यति || 5||"," yat—what; sānkhyaiḥ—by means of karm sanyās; prāpyate—is attained; sthānam—place; tat—that; yogaiḥ—by working in devotion; api—also; gamyate—is attained; ekam—one; sānkhyam—renunciation of actions; cha—and; yogam—karm yog; cha—and; yaḥ—who; paśhyati—sees; saḥ—that person; paśhyati—actually sees ","yat sānkhyaiḥ prāpyate sthānaṁ tad yogair api gamyate\n" + "ekaṁ sānkhyaṁ cha yogaṁ cha yaḥ paśhyati sa paśhyati",R.color.trans));
        mData.add(new NewsItem("संन्यासस्तु महाबाहो दु:खमाप्तुमयोगत: |\n" + "योगयुक्तो मुनिर्ब्रह्म नचिरेणाधिगच्छति || 6||"," sanyāsaḥ—renunciation; tu—but; mahā-bāho—mighty-armed one; duḥkham—distress; āptum—attains; ayogataḥ—without karm-yog; yoga-yuktaḥ—one who is adept in karm-yog; muniḥ—a sage; brahma—Brahman; na chireṇa—quickly; adhigachchhati—goes ","sannyāsas tu mahā-bāho duḥkham āptum ayogataḥ\n" + "yoga-yukto munir brahma na chireṇādhigachchhati",R.color.trans));
        mData.add(new NewsItem("योगयुक्तो विशुद्धात्मा विजितात्मा जितेन्द्रिय: |\n" + "सर्वभूतात्मभूतात्मा कुर्वन्नपि न लिप्यते || 7||"," yoga-yuktaḥ—united in consciousness with God; viśhuddha-ātmā—one with purified intellect; vijita-ātmā—one who has conquered the mind; jita-indriyaḥ—having conquered the senses; sarva-bhūta-ātma-bhūta-ātmā—one who sees the Soul of all souls in every living being; kurvan—performing; api—although; na—never; lipyate—entangled ","yoga-yukto viśhuddhātmā vijitātmā jitendriyaḥ\n" + "sarva-bhūtātma-bhūtātmā kurvann api na lipyate",R.color.trans));
        mData.add(new NewsItem("नैव किञ्चित्करोमीति युक्तो मन्येत तत्ववित् |\n" + "पश्यञ्शृण्वन्स्पृशञ्जिघ्रन्नश्नन्गच्छन्स्वपञ्श्वसन् || 8||\n" + "प्रलपन्विसृजन्गृह्ण्न्नुन्मिषन्निमिषन्नपि |\n" + "इन्द्रियाणीन्द्रियार्थेषु वर्तन्त इति धारयन् || 9||"," na—not; eva—certainly; kiñchit—anything; karomi—I do; iti—thus; yuktaḥ—steadfast in karm yog; manyeta—thinks; tattva-vit—one who knows the truth; paśhyan—seeing; śhṛiṇvan—hearing; spṛiśhan—touching; jighran—smelling; aśhnan—eating; gachchhan—moving; svapan—sleeping; śhvasan—breathing; pralapan—talking; visṛijan—giving up; gṛihṇan—accepting; unmiṣhan—opening (the eyes); nimiṣhan—closing (the eyes); api—although; indriyāṇi—the senses; indriya-artheṣhu—in sense-objects; vartante—moving; iti—thus; dhārayan—convinced ","naiva kiñchit karomīti yukto manyeta tattva-vit\n" + "paśhyañ śhṛiṇvan spṛiśhañjighrann aśhnangachchhan svapañśhvasan\n" + "pralapan visṛijan gṛihṇann unmiṣhan nimiṣhann api\n" + "indriyāṇīndriyārtheṣhu vartanta iti dhārayan",R.color.trans));
        mData.add(new NewsItem("ब्रह्मण्याधाय कर्माणि सङ्गं त्यक्त्वा करोति य: |\n" + "लिप्यते न स पापेन पद्मपत्रमिवाम्भसा || 10||"," brahmaṇi—to God; ādhāya—dedicating; karmāṇi—all actions; saṅgam—attachment; tyaktvā—abandoning; karoti—performs; yaḥ—who; lipyate—is affected; na—never; saḥ—that person; pāpena—by sin; padma-patram—a lotus leaf; iva—like; ambhasā—by water ","\n" + "\n" + "brahmaṇyādhāya karmāṇi saṅgaṁ tyaktvā karoti yaḥ\n" + "lipyate na sa pāpena padma-patram ivāmbhasā\n",R.color.trans));
        mData.add(new NewsItem("कायेन मनसा बुद्ध्या केवलैरिन्द्रियैरपि |\n" + "योगिन: कर्म कुर्वन्ति सङ्गं त्यक्त्वात्मशुद्धये || 11||"," kāyena—with the body; manasā—with the mind; buddhyā—with the intellect; kevalaiḥ—only; indriyaiḥ—with the senses; api—even; yoginaḥ—the yogis; karma—actions; kurvanti—perform; saṅgam—attachment; tyaktvā—giving up; ātma—of the self; śhuddhaye—for the purification ","kāyena manasā buddhyā kevalair indriyair api\n" + "yoginaḥ karma kurvanti saṅgaṁ tyaktvātma-śhuddhaye",R.color.trans));
        mData.add(new NewsItem("युक्त: कर्मफलं त्यक्त्वा शान्तिमाप्नोति नैष्ठिकीम् |\n" + "अयुक्त: कामकारेण फले सक्तो निबध्यते || 12||"," yuktaḥ—one who is united in consciousness with God; karma-phalam—the results of all activities; tyaktvā—giving up; śhāntim—peace; āpnoti—attains; naiṣhṭhikīm—everlasting; ayuktaḥ—one who is not united with God in consciousness; kāma-kāreṇa—impelled by desires; phale—in the result; saktaḥ—attached; nibadhyate—becomes entangled ","yuktaḥ karma-phalaṁ tyaktvā śhāntim āpnoti naiṣhṭhikīm\n" + "ayuktaḥ kāma-kāreṇa phale sakto nibadhyate",R.color.trans));
        mData.add(new NewsItem("सर्वकर्माणि मनसा संन्यस्यास्ते सुखं वशी |\n" + "नवद्वारे पुरे देही नैव कुर्वन्न कारयन् || 13||"," sarva—all; karmāṇi—activities; manasā—by the mind; sannyasya—having renounced; āste—remains; sukham—happily; vaśhī—the self-controlled; nava-dvāre—of nine gates; pure—in the city; dehī—the embodied being; na—never; eva—certainly; kurvan—doing anything; na—not; kārayan—causing to be done ","sarva-karmāṇi manasā sannyasyāste sukhaṁ vaśhī\n" + "nava-dvāre pure dehī naiva kurvan na kārayan",R.color.trans));
        mData.add(new NewsItem("न कर्तृत्वं न कर्माणि लोकस्य सृजति प्रभु: |\n" + "न कर्मफलसंयोगं स्वभावस्तु प्रवर्तते || 14||"," na—neither; kartṛitvam—sense of doership; na—nor; karmāṇi—actions; lokasya—of the people; sṛijati—creates; prabhuḥ—God; na—nor; karma-phala—fruits of actions; sanyogam—connection; svabhāvaḥ—one’s nature; tu—but; pravartate—is enacted ","na kartṛitvaṁ na karmāṇi lokasya sṛijati prabhuḥ\n" + "na karma-phala-saṅyogaṁ svabhāvas tu pravartate",R.color.trans));
        mData.add(new NewsItem("नादत्ते कस्यचित्पापं न चैव सुकृतं विभु: |\n" + "अज्ञानेनावृतं ज्ञानं तेन मुह्यन्ति जन्तव: || 15||"," na—not; ādatte—accepts; kasyachit—anyone’s; pāpam—sin; na—not; cha—and; eva—certainly; su-kṛitam—virtuous deeds; vibhuḥ—the omnipresent God; ajñānena—by ignorance; āvṛitam—covered; jñānam—knowledge; tena—by that; muhyanti—are deluded; jantavaḥ—the living entities ","nādatte kasyachit pāpaṁ na chaiva sukṛitaṁ vibhuḥ\n" + "ajñānenāvṛitaṁ jñānaṁ tena muhyanti jantavaḥ",R.color.trans));
        mData.add(new NewsItem("ज्ञानेन तु तदज्ञानं येषां नाशितमात्मन: |\n" + "तेषामादित्यवज्ज्ञानं प्रकाशयति तत्परम् || 16||"," jñānena—by divine knowledge; tu—but; tat—that; ajñānam—ignorance; yeṣhām—whose; nāśhitam—has been destroyed; ātmanaḥ—of the self; teṣhām—their; āditya-vat—like the sun; jñānam—knowledge; prakāśhayati—illumines; tat—that; param—Supreme Entity ","jñānena tu tad ajñānaṁ yeṣhāṁ nāśhitam ātmanaḥ\n" + "teṣhām āditya-vaj jñānaṁ prakāśhayati tat param",R.color.trans));
        mData.add(new NewsItem("तद्बुद्धयस्तदात्मानस्तन्निष्ठास्तत्परायणा: |\n" + "गच्छन्त्यपुनरावृत्तिं ज्ञाननिर्धूतकल्मषा: || 17||"," tat-buddhayaḥ—those whose intellect is directed toward God; tat-ātmānaḥ—those whose heart (mind and intellect) is solely absorbed in God; tat-niṣhṭhāḥ—those whose intellect has firm faith in God; tat-parāyaṇāḥ—those who strive after God as the supreme goal and refuge; gachchhanti—go; apunaḥ-āvṛittim—not returning; jñāna—by knowledge; nirdhūta—dispelled; kalmaṣhāḥ—sins ","tad-buddhayas tad-ātmānas tan-niṣhṭhās tat-parāyaṇāḥ\n" + "gachchhantyapunar-āvṛittiṁ jñāna-nirdhūta-kalmaṣhāḥ",R.color.trans));
        mData.add(new NewsItem("विद्याविनयसम्पन्ने ब्राह्मणे गवि हस्तिनि |\n" + "शुनि चैव श्वपाके च पण्डिता: समदर्शिन: || 18||"," vidyā—divine knowledge; vinaya—humbleness; sampanne—equipped with; brāhmaṇe—a Brahmin; gavi—a cow; hastini—an elephant; śhuni—a dog; cha—and; eva—certainly; śhva-pāke—a dog-eater; cha—and; paṇḍitāḥ—the learned; sama-darśhinaḥ—see with equal vision ","vidyā-vinaya-sampanne brāhmaṇe gavi hastini\n" + "śhuni chaiva śhva-pāke cha paṇḍitāḥ sama-darśhinaḥ",R.color.trans));
        mData.add(new NewsItem("इहैव तैर्जित: सर्गो येषां साम्ये स्थितं मन: |\n" + "निर्दोषं हि समं ब्रह्म तस्माद् ब्रह्मणि ते स्थिता: || 19||"," iha eva—in this very life; taiḥ—by them; jitaḥ—conquer; sargaḥ—the creation; yeṣhām—whose; sāmye—in equanimity; sthitam—situated; manaḥ—mind; nirdoṣham—flawless; hi—certainly; samam—in equality; brahma—God; tasmāt—therefore; brahmaṇi—in the Absolute Truth; te—they; sthitāḥ—are seated ","ihaiva tair jitaḥ sargo yeṣhāṁ sāmye sthitaṁ manaḥ\n" + "nirdoṣhaṁ hi samaṁ brahma tasmād brahmaṇi te sthitāḥ",R.color.trans));
        mData.add(new NewsItem("न प्रहृष्येत्प्रियं प्राप्य नोद्विजेत्प्राप्य चाप्रियम् |\n" + "स्थिरबुद्धिरसम्मूढो ब्रह्मविद् ब्रह्मणि स्थित: || 20||"," na—neither; prahṛiṣhyet—rejoice; priyam—the pleasant; prāpya—obtaining; na—nor; udvijet—become disturbed; prāpya—attaining; cha—also; apriyam—the unpleasant; sthira-buddhiḥ—steady intellect; asammūḍhaḥ—firmly situated; brahma-vit—having a firm understanding of divine knowledge; brahmaṇi—established in God; sthitaḥ—situated ","na prahṛiṣhyet priyaṁ prāpya nodvijet prāpya chāpriyam\n" + "sthira-buddhir asammūḍho brahma-vid brahmaṇi sthitaḥ",R.color.trans));
        mData.add(new NewsItem("बाह्यस्पर्शेष्वसक्तात्मा विन्दत्यात्मनि यत्सुखम् |\n" + "स ब्रह्मयोगयुक्तात्मा सुखमक्षयमश्नुते || 21||"," bāhya-sparśheṣhu—external sense pleasure; asakta-ātmā—those who are unattached; vindati—find; ātmani—in the self; yat—which; sukham—bliss; saḥ—that person; brahma-yoga yukta-ātmā—those who are united with God through yog; sukham—happiness; akṣhayam—unlimited; aśhnute—experiences ","bāhya-sparśheṣhvasaktātmā vindatyātmani yat sukham\n" + "sa brahma-yoga-yuktātmā sukham akṣhayam aśhnute",R.color.trans));
        mData.add(new NewsItem("ये हि संस्पर्शजा भोगा दु:खयोनय एव ते |\n" + "आद्यन्तवन्त: कौन्तेय न तेषु रमते बुध: || 22||"," ye—which; hi—verily; sansparśha-jāḥ—born of contact with the sense objects; bhogāḥ—pleasures; duḥkha—misery; yonayaḥ—source of; eva—verily; te—they are; ādya-antavantaḥ—having beginning and end; kaunteya—Arjun, the son of Kunti; na—never; teṣhu—in those; ramate—takes delight; budhaḥ—the wise ","ye hi sansparśha-jā bhogā duḥkha-yonaya eva te\n" + "ādyantavantaḥ kaunteya na teṣhu ramate budhaḥ",R.color.trans));
        mData.add(new NewsItem("शक्नोतीहैव य: सोढुं प्राक्शरीरविमोक्षणात् |\n" + "कामक्रोधोद्भवं वेगं स युक्त: स सुखी नर: || 23||"," śhaknoti—is able; iha eva—in the present body; yaḥ—who; soḍhum—to withstand; prāk—before; śharīra—the body; vimokṣhaṇāt—giving up; kāma—desire; krodha—anger; udbhavam—generated from; vegam—forces; saḥ—that person; yuktaḥ—yogi; saḥ—that person; sukhī—happy; naraḥ—person ","śhaknotīhaiva yaḥ soḍhuṁ prāk śharīra-vimokṣhaṇāt\n" + "kāma-krodhodbhavaṁ vegaṁ sa yuktaḥ sa sukhī naraḥ",R.color.trans));
        mData.add(new NewsItem("योऽन्त:सुखोऽन्तरारामस्तथान्तज्र्योतिरेव य: ।\n" + "स योगी ब्रह्मनिर्वाणं ब्रह्मभूतोऽधिगच्छति ।। 24।।"," yaḥ—who; antaḥ-sukhaḥ—happy within the self; antaḥ-ārāmaḥ—enjoying within the self; ; tathā—as well as; antaḥ-jyotiḥ—illumined by the inner light; eva—certainly; yaḥ—who; ; saḥ—he; yogī—yogi; brahma-nirvāṇam—liberation from material existence; brahmabhūtaḥ— united with the Lord; adhigachchhati—attains ","yo 'ntaḥ-sukho 'ntar-ārāmas tathāntar-jyotir eva yaḥ\n" + "sa yogī brahma-nirvāṇaṁ brahma-bhūto 'dhigachchhati",R.color.trans));
        mData.add(new NewsItem("लभन्ते ब्रह्मनिर्वाणमृषय: क्षीणकल्मषा: |\n" + "छिन्नद्वैधा यतात्मान: सर्वभूतहिते रता: || 25||"," labhante—achieve; brahma-nirvāṇam—liberation from material existence; ṛiṣhayaḥ—holy persons; kṣhīṇa-kalmaṣhāḥ—whose sins have been purged; chhinna—annihilated; dvaidhāḥ—doubts; yata-ātmānaḥ—whose minds are disciplined; sarva-bhūta—for all living entities; hite—in welfare work; ratāḥ—rejoice ","labhante brahma-nirvāṇam ṛiṣhayaḥ kṣhīṇa-kalmaṣhāḥ\n" + "chhinna-dvaidhā yatātmānaḥ sarva-bhūta-hite ratāḥ",R.color.trans));
        mData.add(new NewsItem("कामक्रोधवियुक्तानां यतीनां यतचेतसाम् |\n" + "अभितो ब्रह्मनिर्वाणं वर्तते विदितात्मनाम् || 26||"," kāma—desires; krodha—anger; viyuktānām—of those who are liberated; yatīnām—of the saintly persons; yata-chetasām—those self-realized persons who have subdued their mind; abhitaḥ—from every side; brahma—spiritual; nirvāṇam—liberation from material existence; vartate—exists; vidita-ātmanām—of those who are self-realized ","kāma-krodha-viyuktānāṁ yatīnāṁ yata-chetasām\n" + "abhito brahma-nirvāṇaṁ vartate viditātmanām",R.color.trans));
        mData.add(new NewsItem("स्पर्शान्कृत्वा बहिर्बाह्यांश्चक्षुश्चैवान्तरे भ्रुवो: |\n" + "प्राणापानौ समौ कृत्वा नासाभ्यन्तरचारिणौ || 27||\n" + "यतेन्द्रियमनोबुद्धिर्मुनिर्मोक्षपरायण: |\n" + "विगतेच्छाभयक्रोधो य: सदा मुक्त एव स: || 28||"," sparśhān—contacts (through senses); kṛitvā—keeping; bahiḥ—outside; bāhyān—external; chakṣhuḥ—eyes; cha—and; eva—certainly; antare—between; bhruvoḥ—of the eyebrows; prāṇa-apānau—the outgoing and incoming breaths; samau—equal; kṛitvā—keeping; nāsa-abhyantara—within the nostrils; chāriṇau—moving; yata—controlled; indriya—senses; manaḥ—mind; buddhiḥ—intellect; muniḥ—the sage; mokṣha—liberation; parāyaṇaḥ—dedicated; vigata—free; ichchhā—desires; bhaya—fear; krodhaḥ—anger; yaḥ—who; sadā—always; muktaḥ—liberated; eva—certainly; saḥ—that person ","sparśhān kṛitvā bahir bāhyānśh chakṣhuśh chaivāntare bhruvoḥ\n" + "prāṇāpānau samau kṛitvā nāsābhyantara-chāriṇau\n" + "yatendriya-mano-buddhir munir mokṣha-parāyaṇaḥ\n" + "vigatechchhā-bhaya-krodho yaḥ sadā mukta eva saḥ",R.color.trans));
        mData.add(new NewsItem("भोक्तारं यज्ञतपसां सर्वलोकमहेश्वरम् |\n" + "सुहृदं सर्वभूतानां ज्ञात्वा मां शान्तिमृच्छति || 29||"," bhoktāram—the enjoyer; yajña—sacrifices; tapasām—austerities; sarva-loka—of all worlds; mahā-īśhvaram—the Supreme Lord; su-hṛidam—the selfless Friend; sarva—of all; bhūtānām—the living beings; jñātvā—having realized; mām—Me (Lord Krishna); śhāntim—peace; ṛichchhati—attains ","bhoktāraṁ yajña-tapasāṁ sarva-loka-maheśhvaram\n" + "suhṛidaṁ sarva-bhūtānāṁ jñātvā māṁ śhāntim ṛichchhati",R.color.trans));
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
                            Intent intent = new Intent(Vchp5.this, CloseActivity.class);
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

            Intent myIntent = new Intent(this, Chp5.class);
            this.startActivity(myIntent);

        }

        if (id == R.id.verses){

        //    Intent myIntent = new Intent(this, Main2Activity.class);
         //   this.startActivity(myIntent);

        }

        if (id == R.id.explain){

            //   Intent myIntent = new Intent(this, Explaination.class);
            //   this.startActivity(myIntent);

            new FancyGifDialog.Builder(Vchp5.this)
                    .setTitle("REMEMBER THIS ALWAYS!")
                    .setMessage("\uD83D\uDCA5️ This is just a side note but a very important one:\n\uD83D\uDC49️ This translation of gita by Swami Mukundananda is one of the many translations available on this planet. Everyone interprets gita from there own school of thought and so when one switch from Dwaita to Adwaita school of thought the whole meaning flips upside down.\n\uD83D\uDE4F️ So it's my humble request to read different interpretations for a much clearer view!")
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