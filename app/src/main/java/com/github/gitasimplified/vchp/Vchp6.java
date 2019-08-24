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
import com.github.gitasimplified.chp.Chp6;

import java.util.ArrayList;
import java.util.List;

public class Vchp6 extends AppCompatActivity
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
        navigationView.getMenu().getItem(5).setChecked(true);

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
        mData.add(new NewsItem("श्रीभगवानुवाच |\n" + "अनाश्रित: कर्मफलं कार्यं कर्म करोति य: |\n" + "स संन्यासी च योगी च न निरग्निर्न चाक्रिय: || 1||"," śhrī-bhagavān uvācha—the Supreme Lord said; anāśhritaḥ—not desiring; karma-phalam—results of actions; kāryam—obligatory; karma—work; karoti—perform; yaḥ—one who; saḥ—that person; sanyāsī—in the renounced order; cha—and; yogī—yogi; cha—and; na—not; niḥ—without; agniḥ—fire; na—not; cha—also; akriyaḥ—without activity ","śhrī bhagavān uvācha\n" + "anāśhritaḥ karma-phalaṁ kāryaṁ karma karoti yaḥ\n" + "sa sannyāsī cha yogī cha na niragnir na chākriyaḥ",R.color.trans));
        mData.add(new NewsItem("यं संन्यासमिति प्राहुर्योगं तं विद्धि पाण्डव |\n" + "न ह्यसंन्यस्तसङ्कल्पो योगी भवति कश्चन || 2||"," yam—what; sanyāsam—renunciation; iti—thus; prāhuḥ—they say; yogam—yog; tam—that; viddhi—know; pāṇḍava—Arjun, the son of Pandu; na—not; hi—certainly; asannyasta—without giving up; saṅkalpaḥ—desire; yogī—a yogi; bhavati—becomes; kaśhchana—anyone ","yaṁ sannyāsam iti prāhur yogaṁ taṁ viddhi pāṇḍava\n" + "na hyasannyasta-saṅkalpo yogī bhavati kaśhchana",R.color.trans));
        mData.add(new NewsItem("आरुरुक्षोर्मुनेर्योगं कर्म कारणमुच्यते |\n" + "योगारूढस्य तस्यैव शम: कारणमुच्यते || 3||"," ārurukṣhoḥ—a beginner; muneḥ—of a sage; yogam—Yog; karma—working without attachment; kāraṇam—the cause; uchyate—is said; yoga ārūḍhasya—of those who are elevated in Yog; tasya—their; eva—certainly; śhamaḥ—meditation; kāraṇam—the cause; uchyate—is said ","ārurukṣhor muner yogaṁ karma kāraṇam uchyate\n" + "yogārūḍhasya tasyaiva śhamaḥ kāraṇam uchyate",R.color.trans));
        mData.add(new NewsItem("यदा हि नेन्द्रियार्थेषु न कर्मस्वनुषज्जते |\n" + "सर्वसङ्कल्पसंन्यासी योगारूढस्तदोच्यते || 4||"," yadā—when; hi—certainly; na—not; indriya-artheṣhu—for sense-objects; na—not; karmasu—to actions; anuṣhajjate—is attachment; sarva-saṅkalpa—all desires for the fruits of actions; sanyāsī—renouncer; yoga-ārūḍhaḥ—elevated in the science of Yog; tadā—at that time; uchyate—is said ","\n" + "\n" + "yadā hi nendriyārtheṣhu na karmasv-anuṣhajjate\n" + "sarva-saṅkalpa-sannyāsī yogārūḍhas tadochyate\n",R.color.trans));
        mData.add(new NewsItem("उद्धरेदात्मनात्मानं नात्मानमवसादयेत् |\n" + "आत्मैव ह्यात्मनो बन्धुरात्मैव रिपुरात्मन: || 5||"," uddharet—elevate; ātmanā—through the mind; ātmānam—the self; na—not; ātmānam—the self; avasādayet—degrade; ātmā—the mind; eva—certainly; hi—indeed; ātmanaḥ—of the self; bandhuḥ—friend; ātmā—the mind; eva—certainly; ripuḥ—enemy; ātmanaḥ—of the self ","uddhared ātmanātmānaṁ nātmānam avasādayet\n" + "ātmaiva hyātmano bandhur ātmaiva ripur ātmanaḥ",R.color.trans));
        mData.add(new NewsItem("बन्धुरात्मात्मनस्तस्य येनात्मैवात्मना जित: |\n" + "अनात्मनस्तु शत्रुत्वे वर्ते तात्मैव शत्रुवत् || 6||"," bandhuḥ—friend; ātmā—the mind; ātmanaḥ—for the person; tasya—of him; yena—by whom; ātmā—the mind; eva—certainly; ātmanā—for the person; jitaḥ—conquered; anātmanaḥ—of those with unconquered mind; tu—but; śhatrutve—for an enemy; varteta—remains; ātmā—the mind; eva—as; śhatru-vat—like an enemy ","bandhur ātmātmanas tasya yenātmaivātmanā jitaḥ\n" + "anātmanas tu śhatrutve vartetātmaiva śhatru-vat",R.color.trans));
        mData.add(new NewsItem("जितात्मन: प्रशान्तस्य परमात्मा समाहित: |\n" + "शीतोष्णसुखदु:खेषु तथा मानापमानयो: || 7||"," jita-ātmanaḥ—one who has conquered one’s mind; praśhāntasya—of the peaceful; parama-ātmā—God; samāhitaḥ—steadfast; śhīta—in cold; uṣhṇa—heat; sukha—happiness; duḥkheṣhu—and distress; tathā—also; māna—in honor; apamānayoḥ—and dishonor ","jitātmanaḥ praśhāntasya paramātmā samāhitaḥ\n" + "śhītoṣhṇa-sukha-duḥkheṣhu tathā mānāpamānayoḥ",R.color.trans));
        mData.add(new NewsItem("ज्ञानविज्ञानतृप्तात्मा कूटस्थो विजितेन्द्रिय: |\n" + "युक्त इत्युच्यते योगी समलोष्टाश्मकाञ्चन: || 8||"," jñāna—knowledge; vijñāna—realized knowledge, wisdom from within; tṛipta ātmā—one fully satisfied; kūṭa-sthaḥ—undisturbed; vijita-indriyaḥ—one who has conquered the senses; yuktaḥ—one who is in constant communion with the Supreme; iti—thus; uchyate—is said; yogī—a yogi; sama—looks equally; loṣhṭra—pebbles; aśhma—stone; kāñchanaḥ—gold ","jñāna-vijñāna-tṛiptātmā kūṭa-stho vijitendriyaḥ\n" + "yukta ityuchyate yogī sama-loṣhṭāśhma-kāñchanaḥ",R.color.trans));
        mData.add(new NewsItem("सुहृन्मित्रार्युदासीनमध्यस्थद्वेष्यबन्धुषु |\n" + "साधुष्वपि च पापेषु समबुद्धिर्विशिष्यते || 9||"," su-hṛit—toward the well-wishers; mitra—friends; ari—enemies; udāsīna—neutral persons; madhya-stha—mediators; dveṣhya—the envious; bandhuṣhu—relatives; sādhuṣhu—pious; api—as well as; cha—and; pāpeṣhu—the sinners; sama-buddhiḥ—of impartial intellect; viśhiṣhyate—is distinguished ","suhṛin-mitrāryudāsīna-madhyastha-dveṣhya-bandhuṣhu\n" + "sādhuṣhvapi cha pāpeṣhu sama-buddhir viśhiṣhyate",R.color.trans));
        mData.add(new NewsItem("योगी युञ्जीत सततमात्मानं रहसि स्थित: |\n" + "एकाकी यतचित्तात्मा निराशीरपरिग्रह: || 10||"," yogī—a yogi; yuñjīta—should remain engaged in meditation; satatam—constantly; ātmānam—self; rahasi—in seclusion; sthitaḥ—remaining; ekākī—alone; yata-chitta-ātmā—with a controlled mind and body; nirāśhīḥ—free from desires; aparigrahaḥ—free from desires for possessions for enjoyment ","yogī yuñjīta satatam ātmānaṁ rahasi sthitaḥ\n" + "ekākī yata-chittātmā nirāśhīr aparigrahaḥ",R.color.trans));
        mData.add(new NewsItem("शुचौ देशे प्रतिष्ठाप्य स्थिरमासनमात्मन: |\n" + "नात्युच्छ्रितं नातिनीचं चैलाजिनकुशोत्तरम् || 11||"," śhuchau—in a clean; deśhe—place; pratiṣhṭhāpya—having established; sthiram—steadfast; āsanam—seat; ātmanaḥ—his own; na—not; ati—too; uchchhritam—high; na—not; ati—too; nīcham—low; chaila—cloth; ajina—a deerskin; kuśha—kuśh grass; uttaram—one over the other ","śhuchau deśhe pratiṣhṭhāpya sthiram āsanam ātmanaḥ\n" + "nātyuchchhritaṁ nāti-nīchaṁ chailājina-kuśhottaram",R.color.trans));
        mData.add(new NewsItem("तत्रैकाग्रं मन: कृत्वा यतचित्तेन्द्रियक्रिय: |\n" + "उपविश्यासने युञ्ज्याद्योगमात्मविशुद्धये || 12||\n" + "समं कायशिरोग्रीवं धारयन्नचलं स्थिर: |\n" + "सम्प्रेक्ष्य नासिकाग्रं स्वं दिशश्चानवलोकयन् || 13||"," tatra—there; eka-agram—one-pointed; manaḥ—mind; kṛitvā—having made; yata-chitta—controlling the mind; indriya—senses; kriyaḥ—activities; upaviśhya—being seated; āsane—on the seat; yuñjyāt yogam—should strive to practice yog; ātma viśhuddhaye—for purification of the mind; samam—straight; kāya—body; śhiraḥ—head; grīvam—neck; dhārayan—holding; achalam—unmoving; sthiraḥ—still; samprekṣhya—gazing; nāsika-agram—at the tip of the nose; svam—own; diśhaḥ—directions; cha—and; anavalokayan—not looking ","tatraikāgraṁ manaḥ kṛitvā yata-chittendriya-kriyaḥ\n" + "upaviśhyāsane yuñjyād yogam ātma-viśhuddhaye\n" + "samaṁ kāya-śhiro-grīvaṁ dhārayann achalaṁ sthiraḥ\n" + "samprekṣhya nāsikāgraṁ svaṁ diśhaśh chānavalokayan",R.color.trans));
        mData.add(new NewsItem("प्रशान्तात्मा विगतभीर्ब्रह्मचारिव्रते स्थित: |\n" + "मन: संयम्य मच्चित्तो युक्त आसीत मत्पर: || 14||"," praśhānta—serene; ātmā—mind; vigata-bhīḥ—fearless; brahmachāri-vrate—in the vow of celibacy; sthitaḥ—situated; manaḥ—mind; sanyamya—having controlled; mat-chittaḥ—meditate on me (Shree Krishna); yuktaḥ—engaged; āsīta—should sit; mat-paraḥ—having me as the supreme goal ","praśhāntātmā vigata-bhīr brahmachāri-vrate sthitaḥ\n" + "manaḥ sanyamya mach-chitto yukta āsīta mat-paraḥ",R.color.trans));
        mData.add(new NewsItem("युञ्जन्नेवं सदात्मानं योगी नियतमानस: |\n" + "शान्तिं निर्वाणपरमां मत्संस्थामधिगच्छति || 15||"," yuñjan—keeping the mind absorbed in God; evam—thus; sadā—constantly; ātmānam—the mind; yogī—a yogi; niyata-mānasaḥ—one with a disciplined mind; śhāntim—peace; nirvāṇa—liberation from the material bondage; paramām—supreme; mat-sansthām—abides in me; adhigachchhati—attains ","yuñjann evaṁ sadātmānaṁ yogī niyata-mānasaḥ\n" + "śhantiṁ nirvāṇa-paramāṁ mat-sansthām adhigachchhati",R.color.trans));
        mData.add(new NewsItem("नात्यश्नतस्तु योगोऽस्ति न चैकान्तमनश्नत: |\n" + "न चाति स्वप्नशीलस्य जाग्रतो नैव चार्जुन || 16||"," na—not; ati—too much; aśhnataḥ—of one who eats; tu—however; yogaḥ—Yog; asti—there is; na—not; cha—and; ekāntam—at all; anaśhnataḥ—abstaining from eating; na—not; cha—and; ati—too much; svapna-śhīlasya—of one who sleeps; jāgrataḥ—of one who does not sleep enough; na—not; eva—certainly; cha—and; arjuna—Arjun ","nātyaśhnatastu yogo ’sti na chaikāntam anaśhnataḥ\n" + "na chāti-svapna-śhīlasya jāgrato naiva chārjuna",R.color.trans));
        mData.add(new NewsItem("युक्ताहारविहारस्य युक्तचेष्टस्य कर्मसु |\n" + "युक्तस्वप्नावबोधस्य योगो भवति दु:खहा || 17||"," yukta—moderate; āhāra—eating; vihārasya—recreation; yukta cheṣhṭasya karmasu—balanced in work; yukta—regulated; svapna-avabodhasya—sleep and wakefulness; yogaḥ—Yog; bhavati—becomes; duḥkha-hā—the slayer of sorrows ","yuktāhāra-vihārasya yukta-cheṣhṭasya karmasu\n" + "yukta-svapnāvabodhasya yogo bhavati duḥkha-hā",R.color.trans));
        mData.add(new NewsItem("यदा विनियतं चित्तमात्मन्येवावतिष्ठते |\n" + "नि:स्पृह: सर्वकामेभ्यो युक्त इत्युच्यते तदा || 18||"," yadā—when; viniyatam—fully controlled; chittam—the mind; ātmani—of the self; eva—certainly; avatiṣhṭhate—stays; nispṛihaḥ—free from cravings; sarva—all; kāmebhyaḥ—for yearning of the senses; yuktaḥ—situated in perfect Yog; iti—thus; uchyate—is said; tadā—then ","yadā viniyataṁ chittam ātmanyevāvatiṣhṭhate\n" + "niḥspṛihaḥ sarva-kāmebhyo yukta ityuchyate tadā",R.color.trans));
        mData.add(new NewsItem("यथा दीपो निवातस्थो नेङ्गते सोपमा स्मृता |\n" + "योगिनो यतचित्तस्य युञ्जतो योगमात्मन: || 19||"," yathā—as; dīpaḥ—a lamp; nivāta-sthaḥ—in a windless place; na—does not; iṅgate—flickers; sā—this; upamā—analogy; smṛitā—is considered; yoginaḥ—of a yogi; yata-chittasya—whose mind is disciplined; yuñjataḥ—steadily practicing; yogam—in meditation; ātmanaḥ—on the Supreme ","yathā dīpo nivāta-stho neṅgate sopamā smṛitā\n" + "yogino yata-chittasya yuñjato yogam ātmanaḥ",R.color.trans));
        mData.add(new NewsItem("यत्रोपरमते चित्तं निरुद्धं योगसेवया |\n" + "यत्र चैवात्मनात्मानं पश्यन्नात्मनि तुष्यति || 20||"," yatra—when; uparamate—rejoice inner joy; chittam—the mind; niruddham—restrained; yoga-sevayā—by the practice of yog; yatra—when; cha—and; eva—certainly; ātmanā—through the purified mind; ātmānam—the soul; paśhyan—behold; ātmani—in the self; tuṣhyati—is satisfied ","yatroparamate chittaṁ niruddhaṁ yoga-sevayā\n" + "yatra chaivātmanātmānaṁ paśhyann ātmani tuṣhyati",R.color.trans));
        mData.add(new NewsItem("सुखमात्यन्तिकं यत्तद्बुद्धिग्राह्यमतीन्द्रियम् |\n" + "वेत्ति यत्र न चैवायं स्थितश्चलति तत्वत: || 21||"," sukham—happiness; ātyantikam—limitless; yat—which; tat—that; buddhi—by intellect; grāhyam—grasp; atīndriyam—transcending the senses; vetti—knows; yatra—wherein; na—never; cha—and; eva—certainly; ayam—he; sthitaḥ—situated; chalati—deviates; tattvataḥ—from the Eternal Truth ","sukham ātyantikaṁ yat tad buddhi-grāhyam atīndriyam\n" + "vetti yatra na chaivāyaṁ sthitaśh chalati tattvataḥ",R.color.trans));
        mData.add(new NewsItem("यं लब्ध्वा चापरं लाभं मन्यते नाधिकं तत: |\n" + "यस्मिन्स्थितो न दु:खेन गुरुणापि विचाल्यते || 22||"," yam—which; labdhvā—having gained; cha—and; aparam—any other; lābham—gain; manyate—considers; na—not; adhikam—greater; tataḥ—than that; yasmin—in which; sthitaḥ—being situated; na—never; duḥkhena—by sorrow; guruṇā—(by) the greatest; api—even; vichālyate—is shaken ","yaṁ labdhvā chāparaṁ lābhaṁ manyate nādhikaṁ tataḥ\n" + "yasmin sthito na duḥkhena guruṇāpi vichālyate",R.color.trans));
        mData.add(new NewsItem("तं विद्याद् दु:खसंयोगवियोगं योगसञ्ज्ञितम् |\n" + "स निश्चयेन योक्तव्यो योगोऽनिर्विण्णचेतसा || 23||"," tam—that; vidyāt—you should know; duḥkha-sanyoga-viyogam—state of severance from union with misery; yoga-saṁjñitam—is known as yog; saḥ—that; niśhchayena—resolutely; yoktavyaḥ—should be practiced; yogaḥ—yog; anirviṇṇa-chetasā—with an undeviating mind ","taṁ vidyād duḥkha-sanyoga-viyogaṁ yogasaṅjñitam\n" + "sa niśhchayena yoktavyo yogo ’nirviṇṇa-chetasā",R.color.trans));
        mData.add(new NewsItem("सङ्कल्पप्रभवान्कामांस्त्यक्त्वा सर्वानशेषत: |\n" + "मनसैवेन्द्रियग्रामं विनियम्य समन्तत: || 24||\n" + "शनै: शनैरुपरमेद्बुद्ध्या धृतिगृहीतया |\n" + "आत्मसंस्थं मन: कृत्वा न किञ्चिदपि चिन्तयेत् || 25||"," saṅkalpa—a resolve; prabhavān—born of; kāmān—desires; tyaktvā—having abandoned; sarvān—all; aśheṣhataḥ—completely; manasā—through the mind; eva—certainly; indriya-grāmam—the group of senses; viniyamya—restraining; samantataḥ—from all sides; śhanaiḥ—gradually; śhanaiḥ—gradually; uparamet—attain peace; buddhyā—by intellect; dhṛiti-gṛihītayā—achieved through determination of resolve that is in accordance with scriptures; ātma-sanstham—fixed in God; manaḥ—mind; kṛitvā—having made; na—not; kiñchit—anything; api—even; chintayet—should think of ","saṅkalpa-prabhavān kāmāns tyaktvā sarvān aśheṣhataḥ\n" + "manasaivendriya-grāmaṁ viniyamya samantataḥ\n" + "śhanaiḥ śhanair uparamed buddhyā dhṛiti-gṛihītayā\n" + "ātma-sansthaṁ manaḥ kṛitvā na kiñchid api chintayet",R.color.trans));
        mData.add(new NewsItem("यतो यतो निश्चरति मनश्चञ्चलमस्थिरम् |\n" + "ततस्ततो नियम्यैतदात्मन्येव वशं नयेत् || 26||"," yataḥ yataḥ—whenever and wherever; niśhcharati—wanders; manaḥ—the mind; chañchalam—restless; asthiram—unsteady; tataḥ tataḥ—from there; niyamya—having restrained; etat—this; ātmani—on God; eva—certainly; vaśham—control; nayet—should bring ","yato yato niśhcharati manaśh chañchalam asthiram\n" + "tatas tato niyamyaitad ātmanyeva vaśhaṁ nayet",R.color.trans));
        mData.add(new NewsItem("प्रशान्तमनसं ह्येनं योगिनं सुखमुत्तमम् |\n" + "उपैति शान्तरजसं ब्रह्मभूतमकल्मषम् || 27||"," praśhānta—peaceful; manasam—mind; hi—certainly; enam—this; yoginam—yogi; sukham uttamam—the highest bliss; upaiti—attains; śhānta-rajasam—whose passions are subdued; brahma-bhūtam—endowed with God-realization; akalmaṣham—without sin ","praśhānta-manasaṁ hyenaṁ yoginaṁ sukham uttamam\n" + "upaiti śhānta-rajasaṁ brahma-bhūtam akalmaṣham",R.color.trans));
        mData.add(new NewsItem("युञ्जन्नेवं सदात्मानं योगी विगतकल्मष: |\n" + "सुखेन ब्रह्मसंस्पर्शमत्यन्तं सुखमश्नुते || 28||"," yuñjan—uniting (the self with God); evam—thus; sadā—always; ātmānam—the self; yogī—a yogi; vigata—freed from; kalmaṣhaḥ—sins; sukhena—easily; brahma-sansparśham—constantly in touch with the Supreme; atyantam—the highest; sukham—bliss; aśhnute—attains ","yuñjann evaṁ sadātmānaṁ yogī vigata-kalmaṣhaḥ\n" + "sukhena brahma-sansparśham atyantaṁ sukham aśhnute",R.color.trans));
        mData.add(new NewsItem("सर्वभूतस्थमात्मानं सर्वभूतानि चात्मनि |\n" + "ईक्षते योगयुक्तात्मा सर्वत्र समदर्शन: || 29||"," sarva-bhūta-stham—situated in all living beings; ātmānam—Supreme Soul; sarva—all; bhūtāni—living beings; cha—and; ātmani—in God; īkṣhate—sees; yoga-yukta-ātmā—one united in consciousness with God; sarvatra—everywhere; sama-darśhanaḥ—equal vision ","sarva-bhūta-stham ātmānaṁ sarva-bhūtāni chātmani\n" + "īkṣhate yoga-yuktātmā sarvatra sama-darśhanaḥ",R.color.trans));
        mData.add(new NewsItem("यो मां पश्यति सर्वत्र सर्वं च मयि पश्यति |\n" + "तस्याहं न प्रणश्यामि स च मे न प्रणश्यति || 30||"," yaḥ—who; mām—me; paśhyati—see; sarvatra—everywhere; sarvam—everything; cha—and; mayi—in me; paśhyati—see; tasya—for him; aham—I; na—not; praṇaśhyāmi—lost; saḥ—that person; cha—and; me—to me; na—nor; praṇaśhyati—lost ","yo māṁ paśhyati sarvatra sarvaṁ cha mayi paśhyati\n" + "tasyāhaṁ na praṇaśhyāmi sa cha me na praṇaśhyati",R.color.trans));
        mData.add(new NewsItem("सर्वभूतस्थितं यो मां भजत्येकत्वमास्थित: |\n" + "सर्वथा वर्तमानोऽपि स योगी मयि वर्तते || 31||"," sarva-bhūta-sthitam—situated in all beings; yaḥ—who; mām—me; bhajati—worships; ekatvam—in unity; āsthitaḥ—established; sarvathā—in all kinds of; varta-mānaḥ—remain; api—although; saḥ—he; yogī—a yogi; mayi—in me; vartate—dwells ","sarva-bhūta-sthitaṁ yo māṁ bhajatyekatvam āsthitaḥ\n" + "sarvathā vartamāno ’pi sa yogī mayi vartate",R.color.trans));
        mData.add(new NewsItem("आत्मौपम्येन सर्वत्र समं पश्यति योऽर्जुन |\n" + "सुखं वा यदि वा दु:खं स योगी परमो मत: || 32||"," ātma-aupamyena—similar to oneself; sarvatra—everywhere; samam—equally; paśhyati—see; yaḥ—who; arjuna—Arjun; sukham—joy; vā—or; yadi—if; vā—or; duḥkham—sorrow; saḥ—such; yogī—a yogi; paramaḥ—highest; mataḥ—is considered ","ātmaupamyena sarvatra samaṁ paśhyati yo ’rjuna\n" + "sukhaṁ vā yadi vā duḥkhaṁ sa yogī paramo mataḥ",R.color.trans));
        mData.add(new NewsItem("अर्जुन उवाच |\n" + "योऽयं योगस्त्वया प्रोक्त: साम्येन मधुसूदन |\n" + "एतस्याहं न पश्यामि चञ्चलत्वात्स्थितिं स्थिराम् || 33||"," arjunaḥ uvācha—Arjun said; yaḥ—which; ayam—this; yogaḥ—system of Yog; tvayā—by you; proktaḥ—described; sāmyena—by equanimity; madhu-sūdana—Shree Krishna, the killer of the demon named Madhu; etasya—of this; aham—I; na—do not; paśhyāmi—see; chañchalatvāt—due to restlessness; sthitim—situation; sthirām—steady ","arjuna uvācha\n" + "yo ’yaṁ yogas tvayā proktaḥ sāmyena madhusūdana\n" + "etasyāhaṁ na paśhyāmi chañchalatvāt sthitiṁ sthirām",R.color.trans));
        mData.add(new NewsItem("चञ्चलं हि मन: कृष्ण प्रमाथि बलवद्दृढम् |\n" + "तस्याहं निग्रहं मन्ये वायोरिव सुदुष्करम् || 34||"," chañchalam—restless; hi—certainly; manaḥ—mind; kṛiṣhṇa—Shree Krishna; pramāthi—turbulent; bala-vat—strong; dṛiḍham—obstinate; tasya—its; aham—I; nigraham—control; manye—think; vāyoḥ—of the wind; iva—like; su-duṣhkaram—difficult to perform ","chañchalaṁ hi manaḥ kṛiṣhṇa pramāthi balavad dṛiḍham\n" + "tasyāhaṁ nigrahaṁ manye vāyor iva su-duṣhkaram",R.color.trans));
        mData.add(new NewsItem("श्रीभगवानुवाच |\n" + "असंशयं महाबाहो मनो दुर्निग्रहं चलम् |\n" + "अभ्यासेन तु कौन्तेय वैराग्येण च गृह्यते || 35||"," śhrī-bhagavān uvācha—Lord Krishna said; asanśhayam—undoubtedly; mahā-bāho—mighty-armed one; manaḥ—the mind; durnigraham—difficult to restrain; chalam—restless; abhyāsena—by practice; tu—but; kaunteya—Arjun, the son of Kunti; vairāgyeṇa—by detachment; cha—and; gṛihyate—can be controlled ","śhrī bhagavān uvācha\n" + "asanśhayaṁ mahā-bāho mano durnigrahaṁ chalam\n" + "abhyāsena tu kaunteya vairāgyeṇa cha gṛihyate",R.color.trans));
        mData.add(new NewsItem("असंयतात्मना योगो दुष्प्राप इति मे मति: |\n" + "वश्यात्मना तु यतता शक्योऽवाप्तुमुपायत: || 36||"," asanyata-ātmanā—one whose mind is unbridled; yogaḥ—Yog; duṣhprāpaḥ—difficult to attain; iti—thus; me—my; matiḥ—opinion; vaśhya-ātmanā—by one whose mind is controlled; tu—but; yatatā—one who strives; śhakyaḥ—possible; avāptum—to achieve; upāyataḥ—by right means ","asaṅyatātmanā yogo duṣhprāpa iti me matiḥ\n" + "vaśhyātmanā tu yatatā śhakyo ’vāptum upāyataḥ",R.color.trans));
        mData.add(new NewsItem("अर्जुन उवाच |\n" + "अयति: श्रद्धयोपेतो योगाच्चलितमानस: |\n" + "अप्राप्य योगसंसिद्धिं कां गतिं कृष्ण गच्छति || 37||"," arjunaḥ uvācha—Arjun said; ayatiḥ—lax; śhraddhayā—with faith; upetaḥ—possessed; yogāt—from Yog; chalita-mānasaḥ—whose mind becomes deviated; aprāpya—failing to attain; yoga-sansiddhim—the highest perfection in yog; kām—which; gatim—destination; kṛiṣhṇa—Shree Krishna; gachchhati—goes ","arjuna uvācha\n" + "ayatiḥ śhraddhayopeto yogāch chalita-mānasaḥ\n" + "aprāpya yoga-sansiddhiṁ kāṅ gatiṁ kṛiṣhṇa gachchhati",R.color.trans));
        mData.add(new NewsItem("कच्चिन्नोभयविभ्रष्टश्छिन्नाभ्रमिव नश्यति |\n" + "अप्रतिष्ठो महाबाहो विमूढो ब्रह्मण: पथि || 38||"," kachchit—whether; na—not; ubhaya—both; vibhraṣhṭaḥ—deviated from; chhinna—broken; abhram—cloud; iva—like; naśhyati—perishes; apratiṣhṭhaḥ—without any support; mahā-bāho—mighty-armed Krishna; vimūḍhaḥ—bewildered; brahmaṇaḥ—of God-realization; pathi—one on the path ","kachchin nobhaya-vibhraṣhṭaśh chhinnābhram iva naśhyati\n" + "apratiṣhṭho mahā-bāho vimūḍho brahmaṇaḥ pathi",R.color.trans));
        mData.add(new NewsItem("एतन्मे संशयं कृष्ण छेत्तुमर्हस्यशेषत: |\n" + "त्वदन्य: संशयस्यास्य छेत्ता न ह्युपपद्यते || 39||"," etat—this; me—my; sanśhayam—doubt; kṛiṣhṇa—Krishna; chhettum—to dispel; arhasi—you can; aśheṣhataḥ—completely; tvat—than you; anyaḥ—other; sanśhayasya—of doubt; asya—this; chhettā—a dispeller; na—never; hi—certainly; upapadyate—is fit ","etan me sanśhayaṁ kṛiṣhṇa chhettum arhasyaśheṣhataḥ\n" + "tvad-anyaḥ sanśhayasyāsya chhettā na hyupapadyate",R.color.trans));
        mData.add(new NewsItem("श्रीभगवानुवाच |\n" + "पार्थ नैवेह नामुत्र विनाशस्तस्य विद्यते |\n" + "न हि कल्याणकृत्कश्चिद्दुर्गतिं तात गच्छति || 40||"," śhrī-bhagavān uvācha—the Supreme Lord said; pārtha—Arjun, the son of Pritha; na eva—never; iha—in this world; na—never; amutra—in the next world; vināśhaḥ—destruction; tasya—his; vidyate—exists; na—never; hi—certainly; kalyāṇa-kṛit—one who strives for God-realization; kaśhchit—anyone; durgatim—evil destination; tāta—my friend; gachchhati—goes ","śhrī bhagavān uvācha\n" + "pārtha naiveha nāmutra vināśhas tasya vidyate\n" + "na hi kalyāṇa-kṛit kaśhchid durgatiṁ tāta gachchhati",R.color.trans));
        mData.add(new NewsItem("प्राप्य पुण्यकृतां लोकानुषित्वा शाश्वती: समा: |\n" + "शुचीनां श्रीमतां गेहे योगभ्रष्टोऽभिजायते || 41||\n" + "अथवा योगिनामेव कुले भवति धीमताम् |\n" + "एतद्धि दुर्लभतरं लोके जन्म यदीदृशम् || 42||"," prāpya—attain; puṇya-kṛitām—of the virtuous; lokān—abodes; uṣhitvā—after dwelling; śhāśhvatīḥ—many; samāḥ—ages; śhuchīnām—of the pious; śhrī-matām—of the prosperous; gehe—in the house; yoga-bhraṣhṭaḥ—the unsuccessful yogis; abhijāyate—take birth; atha vā—else; yoginām—of those endowed with divine wisdom; eva—certainly; kule—in the family; bhavati—take birth; dhī-matām—of the wise; etat—this; hi—certainly; durlabha-taram—very rare; loke—in this world; janma—birth; yat—which; īdṛiśham—like this ","prāpya puṇya-kṛitāṁ lokān uṣhitvā śhāśhvatīḥ samāḥ\n" + "śhuchīnāṁ śhrīmatāṁ gehe yoga-bhraṣhṭo ’bhijāyate\n" + "atha vā yoginām eva kule bhavati dhīmatām\n" + "etad dhi durlabhataraṁ loke janma yad īdṛiśham",R.color.trans));
        mData.add(new NewsItem("तत्र तं बुद्धिसंयोगं लभते पौर्वदेहिकम् |\n" + "यतते च ततो भूय: संसिद्धौ कुरुनन्दन || 43||"," tatra—there; tam—that; buddhi-sanyogam—reawaken their wisdom; labhate—obtains; paurva-dehikam—from the previous lives; yatate—strives; cha—and; tataḥ—thereafter; bhūyaḥ—again; sansiddhau—for perfection; kuru-nandana—Arjun, descendant of the Kurus ","tatra taṁ buddhi-sanyogaṁ labhate paurva-dehikam\n" + "yatate cha tato bhūyaḥ sansiddhau kuru-nandana",R.color.trans));
        mData.add(new NewsItem("पूर्वाभ्यासेन तेनैव ह्रियते ह्यवशोऽपि स: |\n" + "जिज्ञासुरपि योगस्य शब्दब्रह्मातिवर्तते || 44||"," pūrva—past; abhyāsena—discipline; tena—by that; eva—certainly; hriyate—is attracted; hi—surely; avaśhaḥ—helplessly; api—although; saḥ—that person; jijñāsuḥ—inquisitive; api—even; yogasya—about yog; śhabda-brahma—fruitive portion of the Vedas; ativartate—transcends ","pūrvābhyāsena tenaiva hriyate hyavaśho ’pi saḥ\n" + "jijñāsur api yogasya śhabda-brahmātivartate",R.color.trans));
        mData.add(new NewsItem("प्रयत्नाद्यतमानस्तु योगी संशुद्धकिल्बिष: |\n" + "अनेकजन्मसंसिद्धस्ततो याति परां गतिम् || 45||"," prayatnāt—with great effort; yatamānaḥ—endeavoring; tu—and; yogī—a yogi; sanśhuddha—purified; kilbiṣhaḥ—from material desires; aneka—after many, many; janma—births; sansiddhaḥ—attain perfection; tataḥ—then; yāti—attains; parām—the highest; gatim—path ","prayatnād yatamānas tu yogī sanśhuddha-kilbiṣhaḥ\n" + "aneka-janma-sansiddhas tato yāti parāṁ gatim",R.color.trans));
        mData.add(new NewsItem("तपस्विभ्योऽधिकोयोगी\n" + "ज्ञानिभ्योऽपिमतोऽधिक:|\n" + "कर्मिभ्यश्चाधिकोयोगी\n" + "तस्माद्योगीभवार्जुन|| 46||"," tapasvibhyaḥ—than the ascetics; adhikaḥ—superior; yogī—a yogi; jñānibhyaḥ—than the persons of learning; api—even; mataḥ—considered; adhikaḥ—superior; karmibhyaḥ—than the ritualistic performers; cha—and; adhikaḥ—superior; yogī—a yogi; tasmāt—therefore; yogī—a yogi; bhava—just become; arjuna—Arjun ","tapasvibhyo ’dhiko yogī\n" + "jñānibhyo ’pi mato ’dhikaḥ\n" + "karmibhyaśh chādhiko yogī\n" + "tasmād yogī bhavārjuna",R.color.trans));
        mData.add(new NewsItem("योगिनामपि सर्वेषां मद्गतेनान्तरात्मना |\n" + "श्रद्धावान्भजते यो मां स मे युक्ततमो मत: || 47||"," yoginām—of all yogis; api—however; sarveṣhām—all types of; mat-gatena—absorbed in me (God); antaḥ—inner; ātmanā—with the mind; śhraddhā-vān—with great faith; bhajate—engage in devotion; yaḥ—who; mām—to me; saḥ—he; me—by me; yukta-tamaḥ—the highest yogi; mataḥ—is considered ","yoginām api sarveṣhāṁ mad-gatenāntar-ātmanā\n" + "śhraddhāvān bhajate yo māṁ sa me yuktatamo mataḥ",R.color.trans));



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

            Intent myIntent = new Intent(this, Chp6.class);
            this.startActivity(myIntent);

        }

        if (id == R.id.verses){

         //   Intent myIntent = new Intent(this, Main2Activity.class);
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