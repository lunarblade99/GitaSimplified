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
import com.github.gitasimplified.chp.Chp14;
import com.shashank.sony.fancygifdialoglib.FancyGifDialog;
import com.shashank.sony.fancygifdialoglib.FancyGifDialogListener;

import java.util.ArrayList;
import java.util.List;

public class Vchp14 extends AppCompatActivity
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
        navigationView.getMenu().getItem(13).setChecked(true);

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
        mData.add(new NewsItem("श्रीभगवानुवाच |\n" + "परं भूय: प्रवक्ष्यामि ज्ञानानां ज्ञानमुत्तमम् |\n" + "यज्ज्ञात्वा मुनय: सर्वे परां सिद्धिमितो गता: || 1||"," śhrī-bhagavān uvācha—the Divine Lord said; param—supreme; bhūyaḥ—again; pravakṣhyāmi—I shall explain; jñānānām—of all knowledge; jñānam uttamam—the supreme wisdom; yat—which; jñātvā—knowing; munayaḥ—saints; sarve—all; parām—highest; siddhim—perfection; itaḥ—through this; gatāḥ—attained ","śhrī-bhagavān uvācha\n" + "paraṁ bhūyaḥ pravakṣhyāmi jñānānāṁ jñānam uttamam\n" + "yaj jñātvā munayaḥ sarve parāṁ siddhim ito gatāḥ",R.color.trans));
        mData.add(new NewsItem("इदं ज्ञानमुपाश्रित्य मम साधर्म्यमागता: |\n" + "सर्गेऽपि नोपजायन्ते प्रलये न व्यथन्ति च || 2||"," idam—this; jñānam—wisdom; upāśhritya—take refuge in; mama—mine; sādharmyam—of similar nature; āgatāḥ—having attained; sarge—at the time of creation; api—even; na—not; upajāyante—are born; pralaye—at the time of dissolution; na-vyathanti—they will not experience misery; cha—and ","idaṁ jñānam upāśhritya mama sādharmyam āgatāḥ\n" + "sarge ’pi nopajāyante pralaye na vyathanti cha",R.color.trans));
        mData.add(new NewsItem("मम योनिर्महद् ब्रह्म तस्मिन्गर्भं दधाम्यहम् |\n" + "सम्भव: सर्वभूतानां ततो भवति भारत || 3||\n" + "सर्वयोनिषु कौन्तेय मूर्तय: सम्भवन्ति या: |\n" + "तासां ब्रह्म महद्योनिरहं बीजप्रद: पिता || 4||"," mama—my; yoniḥ—womb; mahat brahma—the total material substance, prakṛiti; tasmin—in that; garbham—womb; dadhāmi—impregnate; aham—I; sambhavaḥ—birth; sarva-bhūtānām—of all living beings; tataḥ—thereby; bhavati—becomes; bhārata—Arjun, the son of Bharat; sarva—all; yoniṣhu—species of life; kaunteya—Arjun, the son of Kunti; mūrtayaḥ—forms; sambhavanti—are produced; yāḥ—which; tāsām—of all of them; brahma-mahat—great material nature; yoniḥ—womb; aham—I; bīja-pradaḥ—seed-giving; pitā—Father ","mama yonir mahad brahma tasmin garbhaṁ dadhāmy aham\n" + "sambhavaḥ sarva-bhūtānāṁ tato bhavati bhārata\n" + "sarva-yoniṣhu kaunteya mūrtayaḥ sambhavanti yāḥ\n" + "tāsāṁ brahma mahad yonir ahaṁ bīja-pradaḥ pitā",R.color.trans));
        mData.add(new NewsItem("सत्वं रजस्तम इति गुणा: प्रकृतिसम्भवा: |\n" + "निबध्नन्ति महाबाहो देहे देहिनमव्ययम् || 5||"," sattvam—mode of goodness; rajaḥ—mode of passion; tamaḥ—mode of ignorance; iti—thus; guṇāḥ—modes; prakṛiti—material nature; sambhavāḥ—consists of; nibadhnanti—bind; mahā-bāho—mighty-armed one; dehe—in the body; dehinam—the embodied soul; avyayam—eternal ","sattvaṁ rajas tama iti guṇāḥ prakṛiti-sambhavāḥ\n" + "nibadhnanti mahā-bāho dehe dehinam avyayam",R.color.trans));
        mData.add(new NewsItem("तत्र सत्वं निर्मलत्वात्प्रकाशकमनामयम् |\n" + "सुखसङ्गेन बध्नाति ज्ञानसङ्गेन चानघ || 6||"," tatra—amongst these; sattvam—mode of goodness; nirmalatvāt—being purest; prakāśhakam—illuminating; anāmayam—healthy and full of well-being; sukha—happiness; saṅgena—attachment; badhnāti—binds; jñāna—knowledge; saṅgena—attachment; cha—also; anagha—Arjun, the sinless one ","tatra sattvaṁ nirmalatvāt prakāśhakam anāmayam\n" + "sukha-saṅgena badhnāti jñāna-saṅgena chānagha",R.color.trans));
        mData.add(new NewsItem("रजो रागात्मकं विद्धि तृष्णासङ्गसमुद्भवम् |\n" + "तन्निबध्नाति कौन्तेय कर्मसङ्गेन देहिनम् || 7||"," rajaḥ—mode of passion; rāga-ātmakam—of the nature of passion; viddhi—know; tṛiṣhṇā—desires; saṅga—association; samudbhavam—arises from; tat—that; nibadhnāti—binds; kaunteya—Arjun, the son of Kunti; karma-saṅgena—through attachment to fruitive actions; dehinam—the embodied soul ","rajo rāgātmakaṁ viddhi tṛiṣhṇā-saṅga-samudbhavam\n" + "tan nibadhnāti kaunteya karma-saṅgena dehinam",R.color.trans));
        mData.add(new NewsItem("तमस्त्वज्ञानजं विद्धि मोहनं सर्वदेहिनाम् |\n" + "प्रमादालस्यनिद्राभिस्तन्निबध्नाति भारत || 8||"," tamaḥ—mode of ignorance; tu—but; ajñāna-jam—born of ignorance; viddhi—know; mohanam—illusion; sarva-dehinām—for all the embodied souls; pramāda—negligence; ālasya—laziness; nidrābhiḥ—and sleep; tat—that; nibadhnāti—binds; bhārata—Arjun, the son of Bharat ","tamas tv ajñāna-jaṁ viddhi mohanaṁ sarva-dehinām\n" + "pramādālasya-nidrābhis tan nibadhnāti bhārata",R.color.trans));
        mData.add(new NewsItem("सत्वं सुखे सञ्जयति रज: कर्मणि भारत |\n" + "ज्ञानमावृत्य तु तम: प्रमादे सञ्जयत्युत || 9||"," sattvam—mode of goodness; sukhe—to happiness; sañjayati—binds; rajaḥ—mode of passion; karmaṇi—toward actions; bhārata—Arjun, the son of Bharat; jñānam—wisdom; āvṛitya—clouds; tu—but; tamaḥ—mode of ignorance; pramāde—to delusion; sañjayati—binds; uta—indeed ","sattvaṁ sukhe sañjayati rajaḥ karmaṇi bhārata\n" + "jñānam āvṛitya tu tamaḥ pramāde sañjayaty uta",R.color.trans));
        mData.add(new NewsItem("रजस्तमश्चाभिभूय सत्वं भवति भारत |\n" + "रज: सत्वं तमश्चैव तम: सत्वं रजस्तथा || 10||"," rajaḥ—mode of passion; tamaḥ—mode of ignorance; cha—and; abhibhūya—prevails; sattvam—mode of goodness; bhavati—becomes; bhārata—Arjun, the son of Bharat; rajaḥ—mode of passion; sattvam—mode of goodness; tamaḥ—mode of ignorance; cha—and; eva—indeed; tamaḥ—mode of ignorance; sattvam—mode of goodness; rajaḥ—mode of passion; tathā—also ","rajas tamaśh chābhibhūya sattvaṁ bhavati bhārata\n" + "rajaḥ sattvaṁ tamaśh chaiva tamaḥ sattvaṁ rajas tathā",R.color.trans));
        mData.add(new NewsItem("सर्वद्वारेषु देहेऽस्मिन्प्रकाश उपजायते |\n" + "ज्ञानं यदा तदा विद्याद्विवृद्धं सत्वमित्युत || 11||\n" + "लोभ: प्रवृत्तिरारम्भ: कर्मणामशम: स्पृहा |\n" + "रजस्येतानि जायन्ते विवृद्धे भरतर्षभ || 12||\n" + "अप्रकाशोऽप्रवृत्तिश्च प्रमादो मोह एव च |\n" + "तमस्येतानि जायन्ते विवृद्धे कुरुनन्दन || 13||"," sarva—all; dvāreṣhu—through the gates; dehe—body; asmin—in this; prakāśhaḥ—illumination; upajāyate—manifest; jñānam—knowledge; yadā—when; tadā—then; vidyāt—know; vivṛiddham—predominates; sattvam—mode of goodness; iti—thus; uta—certainly; lobhaḥ—greed; pravṛittiḥ—activity; ārambhaḥ—exertion; karmaṇām—for fruitive actions; aśhamaḥ—restlessness; spṛihā—craving; rajasi—of the mode of passion; etāni—these; jāyante—develop; vivṛiddhe—when predominates; bharata-ṛiṣhabha—the best of the Bharatas, Arjun; aprakāśhaḥ—nescience; apravṛittiḥ—inertia; cha—and; pramādaḥ—negligence; mohaḥ—delusion; eva—indeed; cha—also; tamasi—mode of ignorance; etāni—these; jāyante—manifest; vivṛiddhe—when dominates; kuru-nandana—the joy of the Kurus, Arjun ","sarva-dvāreṣhu dehe ’smin prakāśha upajāyate\n" + "jñānaṁ yadā tadā vidyād vivṛiddhaṁ sattvam ity uta\n" + "lobhaḥ pravṛittir ārambhaḥ karmaṇām aśhamaḥ spṛihā\n" + "rajasy etāni jāyante vivṛiddhe bharatarṣhabha\n" + "aprakāśho ’pravṛittiśh cha pramādo moha eva cha\n" + "tamasy etāni jāyante vivṛiddhe kuru-nandana",R.color.trans));
        mData.add(new NewsItem("यदा सत्वे प्रवृद्धे तु प्रलयं याति देहभृत् |\n" + "तदोत्तमविदां लोकानमलान्प्रतिपद्यते || 14||\n" + "रजसि प्रलयं गत्वा कर्मसङ्गिषु जायते |\n" + "तथा प्रलीनस्तमसि मूढयोनिषु जायते || 15||"," yadā—when; sattve—in the mode of goodness; pravṛiddhe—when premodinates; tu—indeed; pralayam—death; yāti—reach; deha-bhṛit—the embodied; tadā—then; uttama-vidām—of the learned; lokān—abodes; amalān—pure; pratipadyate—attains; rajasi—in the mode of passion; pralayam—death; gatvā—attaining; karma-saṅgiṣhu—among people driven by work; jāyate—are born; tathā—likewise; pralīnaḥ—dying; tamasi—in the mode of ignorance; mūḍha-yoniṣhu—in the animal kingdom; jāyate—takes birth ","yadā sattve pravṛiddhe tu pralayaṁ yāti deha-bhṛit\n" + "tadottama-vidāṁ lokān amalān pratipadyate\n" + "rajasi pralayaṁ gatvā karma-saṅgiṣhu jāyate\n" + "tathā pralīnas tamasi mūḍha-yoniṣhu jāyate",R.color.trans));
        mData.add(new NewsItem("कर्मण: सुकृतस्याहु: सात्विकं निर्मलं फलम् |\n" + "रजसस्तु फलं दु:खमज्ञानं तमस: फलम् || 16||"," karmaṇaḥ—of action; su-kṛitasya—pure; āhuḥ—is said; sāttvikam—mode of goodness; nirmalam—pure; phalam—result; rajasaḥ—mode of passion; tu—indeed; phalam—result; duḥkham—pain; ajñānam—ignorance; tamasaḥ—mode of ignorance; phalam—result ","karmaṇaḥ sukṛitasyāhuḥ sāttvikaṁ nirmalaṁ phalam\n" + "rajasas tu phalaṁ duḥkham ajñānaṁ tamasaḥ phalam",R.color.trans));
        mData.add(new NewsItem("सत्वात्सञ्जायते ज्ञानं रजसो लोभ एव च |\n" + "प्रमादमोहौ तमसो भवतोऽज्ञानमेव च || 17||"," sattvāt—from the mode of goodness; sañjāyate—arises; jñānam—knowledge; rajasaḥ—from the mode of passion; lobhaḥ—greed; eva—indeed; cha—and; pramāda—negligence; mohau—delusion; tamasaḥ—from the mode of ignorance; bhavataḥ—arise; ajñānam—ignorance; eva—indeed; cha—and ","\n" + "sattvāt sañjāyate jñānaṁ rajaso lobha eva cha\n" + "pramāda-mohau tamaso bhavato ’jñānam eva cha\n",R.color.trans));
        mData.add(new NewsItem("ऊर्ध्वं गच्छन्ति सत्वस्था मध्ये तिष्ठन्ति राजसा: |\n" + "जघन्यगुणवृत्तिस्था अधो गच्छन्ति तामसा: || 18||"," ūrdhvam—upward; gachchhanti—rise; sattva-sthāḥ—those situated in the mode of goodness; madhye—in the middle; tiṣhṭhanti—stay; rājasāḥ—those in the mode of passion; jaghanya—abominable; guṇa—quality; vṛitti-sthāḥ—engaged in activities; adhaḥ—down; gachchhanti—go; tāmasāḥ—those in the mode of ignorance ","ūrdhvaṁ gachchhanti sattva-sthā madhye tiṣhṭhanti rājasāḥ\n" + "jaghanya-guṇa-vṛitti-sthā adho gachchhanti tāmasāḥ",R.color.trans));
        mData.add(new NewsItem("नान्यं गुणेभ्य: कर्तारं यदा द्रष्टानुपश्यति |\n" + "गुणेभ्यश्च परं वेत्ति मद्भावं सोऽधिगच्छति || 19||"," na—no; anyam—other; guṇebhyaḥ—of the guṇas; kartāram—agents of action; yadā—when; draṣhṭā—the seer; anupaśhyati—see; guṇebhyaḥ—to the modes of nature; cha—and; param—transcendental; vetti—know; mat-bhāvam—my divine nature; saḥ—they; adhigachchhati—attain ","nānyaṁ guṇebhyaḥ kartāraṁ yadā draṣhṭānupaśhyati\n" + "guṇebhyaśh cha paraṁ vetti mad-bhāvaṁ so ’dhigachchhati",R.color.trans));
        mData.add(new NewsItem("गुणानेतानतीत्य त्रीन्देही देहसमुद्भवान् |\n" + "जन्ममृत्युजरादु:खैर्विमुक्तोऽमृतमश्रुते || 20||"," guṇān—the three modes of material nature; etān—these; atītya—transcending; trīn—three; dehī—the embodied; deha—body; samudbhavān—produced of; janma—birth; mṛityu—death; jarā—old age; duḥkhaiḥ—misery; vimuktaḥ—freed from; amṛitam—immortality; aśhnute—attains ","guṇān etān atītya trīn dehī deha-samudbhavān\n" + "janma-mṛityu-jarā-duḥkhair vimukto ’mṛitam aśhnute",R.color.trans));
        mData.add(new NewsItem("अर्जुन उवाच |\n" + "कैर्लिङ्गैस्त्रीन्गुणानेतानतीतो भवति प्रभो |\n" + "किमाचार: कथं चैतांस्त्रीन्गुणानतिवर्तते || 21||"," arjunaḥ uvācha—Arjun inquired; kaiḥ—by what; liṅgaiḥ—symptoms; trīn—three; guṇān—modes of material nature; etān—these; atītaḥ—having transcended; bhavati—is; prabho—Lord; kim—what; āchāraḥ—conduct; katham—how; cha—and; etān—these; trīn—three; guṇān—modes of material nature; ativartate—transcend ","arjuna uvācha\n" + "kair liṅgais trīn guṇān etān atīto bhavati prabho\n" + "kim āchāraḥ kathaṁ chaitāns trīn guṇān ativartate",R.color.trans));
        mData.add(new NewsItem("श्रीभगवानुवाच |\n" + "प्रकाशं च प्रवृत्तिं च मोहमेव च पाण्डव |\n" + "न द्वेष्टि सम्प्रवृत्तानि न निवृत्तानि काङ् क्षति || 22||\n" + "उदासीनवदासीनो गुणैर्यो न विचाल्यते |\n" + "गुणा वर्तन्त इत्येवं योऽवतिष्ठति नेङ्गते || 23||"," śhrī-bhagavān uvācha—the Supreme Divine Personality said; prakāśham—illumination; cha—and; pravṛittim—activity; cha—and; moham—delusion; eva—even; cha—and; pāṇḍava—Arjun, the son of Pandu; na dveṣhṭi—do not hate; sampravṛittāni—when present; na—nor; nivṛittāni—when absent; kāṅkṣhati—longs; udāsīna-vat—neutral; āsīnaḥ—situated; guṇaiḥ—to the modes of material nature; yaḥ—who; na—not; vichālyate—are disturbed; guṇāḥ—modes of material nature; vartante—act; iti-evam—knowing it in this way; yaḥ—who; avatiṣhṭhati—established in the self; na—not; iṅgate—wavering ","śhrī-bhagavān uvācha\n" + "prakāśhaṁ cha pravṛittiṁ cha moham eva cha pāṇḍava\n" + "na dveṣhṭi sampravṛittāni na nivṛittāni kāṅkṣhati\n" + "udāsīna-vad āsīno guṇair yo na vichālyate\n" + "guṇā vartanta ity evaṁ yo ’vatiṣhṭhati neṅgate",R.color.trans));
        mData.add(new NewsItem("समदु:खसुख: स्वस्थ: समलोष्टाश्मकाञ्चन: |\n" + "तुल्यप्रियाप्रियो धीरस्तुल्यनिन्दात्मसंस्तुति: || 24||\n" + "मानापमानयोस्तुल्यस्तुल्यो मित्रारिपक्षयो: |\n" + "सर्वारम्भपरित्यागी गुणातीत: स उच्यते || 25||"," sama—alike; duḥkha—distress; sukhaḥ—happiness; sva-sthaḥ—established in the self; sama—equally; loṣhṭa—a clod; aśhma—stone; kāñchanaḥ—gold; tulya—of equal value; priya—pleasant; apriyaḥ—unpleasant; dhīraḥ—steady; tulya—the same; nindā—blame; ātma-sanstutiḥ—praise; māna—honor; apamānayoḥ—dishonor; tulyaḥ—equal; tulyaḥ—equal; mitra—friend; ari—foe; pakṣhayoḥ—to the parties; sarva—all; ārambha—enterprises; parityāgī—renouncer; guṇa-atītaḥ—risen above the three modes of material nature; saḥ—they; uchyate—are said to have ","\n" + "sama-duḥkha-sukhaḥ sva-sthaḥ sama-loṣhṭāśhma-kāñchanaḥ\n" + "tulya-priyāpriyo dhīras tulya-nindātma-sanstutiḥ\n" + "mānāpamānayos tulyas tulyo mitrāri-pakṣhayoḥ\n" + "sarvārambha-parityāgī guṇātītaḥ sa uchyate\n",R.color.trans));
        mData.add(new NewsItem("मां च योऽव्यभिचारेण भक्तियोगेन सेवते |\n" + "स गुणान्समतीत्यैतान्ब्रह्मभूयाय कल्पते || 26||"," mām—me; cha—only; yaḥ—who; avyabhichāreṇa—unalloyed; bhakti-yogena—through devotion; sevate—serve; saḥ—they; guṇān—the three modes of material nature; samatītya—rise above; etān—these; brahma-bhūyāya—level of Brahman; kalpate—comes to ","māṁ cha yo ’vyabhichāreṇa bhakti-yogena sevate\n" + "sa guṇān samatītyaitān brahma-bhūyāya kalpate",R.color.trans));
        mData.add(new NewsItem("ब्रह्मणो हि प्रतिष्ठाहममृतस्याव्ययस्य च |\n" + "शाश्वतस्य च धर्मस्य सुखस्यैकान्तिकस्य च || 27||"," brahmaṇaḥ—of Brahman; hi—only; pratiṣhṭhā—the basis; aham—I; amṛitasya—of the immortal; avyayasya—of the imperishable; cha—and; śhāśhvatasya—of the eternal; cha—and; dharmasya—of the dharma; sukhasya—of bliss; aikāntikasya—unending; cha—and ","brahmaṇo hi pratiṣhṭhāham amṛitasyāvyayasya cha\n" + "śhāśhvatasya cha dharmasya sukhasyaikāntikasya cha",R.color.trans));
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
                            Intent intent = new Intent(Vchp14.this, CloseActivity.class);
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

            Intent myIntent = new Intent(this, Chp14.class);
            this.startActivity(myIntent);

        }

        if (id == R.id.verses){

        //    Intent myIntent = new Intent(this, Main2Activity.class);
         //   this.startActivity(myIntent);

        }

        if (id == R.id.explain){

            //   Intent myIntent = new Intent(this, Explaination.class);
            //   this.startActivity(myIntent);

            new FancyGifDialog.Builder(Vchp14.this)
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