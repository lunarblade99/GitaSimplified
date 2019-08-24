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
import com.github.gitasimplified.chp.Chp3;

import java.util.ArrayList;
import java.util.List;

public class Vchp3 extends AppCompatActivity
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
        navigationView.getMenu().getItem(2).setChecked(true);

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
        mData.add(new NewsItem("अर्जुन उवाच |\n" + "ज्यायसी चेत्कर्मणस्ते मता बुद्धिर्जनार्दन |\n" + "तत्किं कर्मणि घोरे मां नियोजयसि केशव || 1||\n" + "व्यामिश्रेणेव वाक्येन बुद्धिं मोहयसीव मे |\n" + "तदेकं वद निश्चित्य येन श्रेयोऽहमाप्नुयाम् || 2||"," arjunaḥ uvācha—Arjun said; jyāyasī—superior; chet—if; karmaṇaḥ—than fruitive action; te—by you; matā—is considered; buddhiḥ—intellect; janārdana—he who looks after the public, Krishna; tat—then; kim—why; karmaṇi—action; ghore—terrible; mām—me; niyojayasi—do you engage; keśhava—Krishna, the killer of the demon named Keshi; vyāmiśhreṇa iva—by your apparently ambiguous; vākyena—words; buddhim—intellect; mohayasi—I am getting bewildered; iva—as it were; me—my; tat—therefore; ekam—one; vada—please tell; niśhchitya—decisively; yena—by which; śhreyaḥ—the highest good; aham—I; āpnuyām—may attain ","arjuna uvācha\n" + "jyāyasī chet karmaṇas te matā buddhir janārdana\n" + "tat kiṁ karmaṇi ghore māṁ niyojayasi keśhava\n" + "vyāmiśhreṇeva vākyena buddhiṁ mohayasīva me\n" + "tad ekaṁ vada niśhchitya yena śhreyo ’ham āpnuyām",R.color.trans));
        mData.add(new NewsItem("श्रीभगवानुवाच |\n" + "लोकेऽस्मिन्द्विविधा निष्ठा पुरा प्रोक्ता मयानघ |\n" + "ज्ञानयोगेन साङ्ख्यानां कर्मयोगेन योगिनाम् || 3||"," śhrī-bhagavān uvācha—the Blessed Lord said; loke—in the world; asmin—this; dvi-vidhā—two kinds of; niṣhṭhā—faith; purā—previously; proktā—explained; mayā—by me (Shree Krishna); anagha—sinless; jñāna-yogena—through the path of knowledge; sānkhyānām—for those inclined toward contemplation; karma-yogena—through the path of action; yoginām—of the yogis ","śhrī bhagavān uvācha\n" + "loke ’smin dvi-vidhā niṣhṭhā purā proktā mayānagha\n" + "jñāna-yogena sāṅkhyānāṁ karma-yogena yoginām",R.color.trans));
        mData.add(new NewsItem("न कर्मणामनारम्भान्नैष्कर्म्यं पुरुषोऽश्नुते |\n" + "न च संन्यसनादेव सिद्धिं समधिगच्छति || 4||"," na—not; karmaṇām—of actions; anārambhāt—by abstaining from; naiṣhkarmyam—freedom from karmic reactions; puruṣhaḥ—a person; aśhnute—attains; na—not; cha—and; sannyasanāt—by renunciation; eva—only; siddhim—perfection; samadhigachchhati—attains ","na karmaṇām anārambhān naiṣhkarmyaṁ puruṣho ’śhnute\n" + "na cha sannyasanād eva siddhiṁ samadhigachchhati",R.color.trans));
        mData.add(new NewsItem("न हि कश्चित्क्षणमपि जातु तिष्ठत्यकर्मकृत् |\n" + "कार्यते ह्यवश: कर्म सर्व: प्रकृतिजैर्गुणै: || 5||"," na—not; hi—certainly; kaśhchit—anyone; kṣhaṇam—a moment; api—even; jātu—ever; tiṣhṭhati—can remain; akarma-kṛit—without action; kāryate—are performed; hi—certainly; avaśhaḥ—helpless; karma—work; sarvaḥ—all; prakṛiti-jaiḥ—born of material nature; guṇaiḥ—by the qualities ","na hi kaśhchit kṣhaṇam api jātu tiṣhṭhatyakarma-kṛit\n" + "kāryate hyavaśhaḥ karma sarvaḥ prakṛiti-jair guṇaiḥ",R.color.trans));
        mData.add(new NewsItem("कर्मेन्द्रियाणि संयम्य य आस्ते मनसा स्मरन् |\n" + "इन्द्रियार्थान्विमूढात्मा मिथ्याचार: स उच्यते || 6||"," karma-indriyāṇi—the organs of action; sanyamya—restrain; yaḥ—who; āste—remain; manasā—in the mind; smaran—to remember; indriya-arthān—sense objects; vimūḍha-ātmā—the deluded; mithyā-āchāraḥ—hypocrite; saḥ—they; uchyate—are called ","karmendriyāṇi sanyamya ya āste manasā smaran\n" + "indriyārthān vimūḍhātmā mithyāchāraḥ sa uchyate",R.color.trans));
        mData.add(new NewsItem("यस्त्विन्द्रियाणि मनसा नियम्यारभतेऽर्जुन |\n" + "कर्मेन्द्रियै: कर्मयोगमसक्त: स विशिष्यते || 7||"," yaḥ—who; tu—but; indriyāṇi—the senses; manasā—by the mind; niyamya—control; ārabhate—begins; arjuna—Arjun; karma-indriyaiḥ—by the working senses; karma-yogam—karm yog; asaktaḥ—without attachment; saḥ—they; viśhiṣhyate—are superior ","yas tvindriyāṇi manasā niyamyārabhate ’rjuna\n" + "karmendriyaiḥ karma-yogam asaktaḥ sa viśhiṣhyate",R.color.trans));
        mData.add(new NewsItem("नियतं कुरु कर्म त्वं कर्म ज्यायो ह्यकर्मण: |\n" + "शरीरयात्रापि च ते न प्रसिद्ध्येदकर्मण: || 8||"," niyatam—constantly; kuru—perform; karma—Vedic duties; tvam—you; karma—action; jyāyaḥ—superior; hi—certainly; akarmaṇaḥ—than inaction; śharīra—bodily; yātrā—maintenance; api—even; cha—and; te—your; na prasiddhyet—would not be possible; akarmaṇaḥ—inaction ","niyataṁ kuru karma tvaṁ karma jyāyo hyakarmaṇaḥ\n" + "śharīra-yātrāpi cha te na prasiddhyed akarmaṇaḥ",R.color.trans));
        mData.add(new NewsItem("यज्ञार्थात्कर्मणोऽन्यत्र लोकोऽयं कर्मबन्धन: |\n" + "तदर्थं कर्म कौन्तेय मुक्तसङ्ग: समाचर || 9||"," yajña-arthāt—for the sake of sacrifice; karmaṇaḥ—than action; anyatra—else; lokaḥ—material world; ayam—this; karma-bandhanaḥ—bondage through one’s work; tat—that; artham—for the sake of; karma—action; kaunteya—Arjun, the son of Kunti; mukta-saṅgaḥ—free from attachment; samāchara—perform properly ","yajñārthāt karmaṇo ’nyatra loko ’yaṁ karma-bandhanaḥ\n" + "tad-arthaṁ karma kaunteya mukta-saṅgaḥ samāchara",R.color.trans));
        mData.add(new NewsItem("सहयज्ञा: प्रजा: सृष्ट्वा पुरोवाच प्रजापति: |\n" + "अनेन प्रसविष्यध्वमेष वोऽस्त्विष्टकामधुक् || 10||"," saha—along with; yajñāḥ—sacrifices; prajāḥ—humankind; sṛiṣhṭvā—created; purā—in beginning; uvācha—said; prajā-patiḥ—Brahma; anena—by this; prasaviṣhyadhvam—increase prosperity; eṣhaḥ—these; vaḥ—your; astu—shall be; iṣhṭa-kāma-dhuk—bestower of all wishes ","saha-yajñāḥ prajāḥ sṛiṣhṭvā purovācha prajāpatiḥ\n" + "anena prasaviṣhyadhvam eṣha vo ’stviṣhṭa-kāma-dhuk",R.color.trans));
        mData.add(new NewsItem("देवान्भावयतानेन ते देवा भावयन्तु व: |\n" + "परस्परं भावयन्त: श्रेय: परमवाप्स्यथ || 11||"," devān—celestial gods; bhāvayatā—will be pleased; anena—by these (sacrifices); te—those; devāḥ—celestial gods; bhāvayantu—will be pleased; vaḥ—you; parasparam—one another; bhāvayantaḥ—pleasing one another; śhreyaḥ—prosperity; param—the supreme; avāpsyatha—shall achieve ","devān bhāvayatānena te devā bhāvayantu vaḥ\n" + "parasparaṁ bhāvayantaḥ śhreyaḥ param avāpsyatha",R.color.trans));
        mData.add(new NewsItem("इष्टान्भोगान्हि वो देवा दास्यन्ते यज्ञभाविता: |\n" + "तैर्दत्तानप्रदायैभ्यो यो भुङ्क्ते स्तेन एव स: || 12||"," iṣhṭān—desired; bhogān—necessities of life; hi—certainly; vaḥ—unto you; devāḥ—the celestial gods; dāsyante—will grant; yajña-bhāvitāḥ—satisfied by sacrifice; taiḥ—by them; dattān—things granted; apradāya—without offering; ebhyaḥ—to them; yaḥ—who; bhuṅkte—enjoys; stenaḥ—thieves; eva—verily; saḥ—they ","iṣhṭān bhogān hi vo devā dāsyante yajña-bhāvitāḥ\n" + "tair dattān apradāyaibhyo yo bhuṅkte stena eva saḥ",R.color.trans));
        mData.add(new NewsItem("यज्ञशिष्टाशिन: सन्तो मुच्यन्ते सर्वकिल्बिषै: |\n" + "भुञ्जते ते त्वघं पापा ये पचन्त्यात्मकारणात् || 13||"," yajña-śhiṣhṭa—of remnants of food offered in sacrifice; aśhinaḥ—eaters; santaḥ—saintly persons; muchyante—are released; sarva—all kinds of; kilbiṣhaiḥ—from sins; bhuñjate—enjoy; te—they; tu—but; agham—sins; pāpāḥ—sinners; ye—who; pachanti—cook (food); ātma-kāraṇāt—for their own sake ","yajña-śhiṣhṭāśhinaḥ santo muchyante sarva-kilbiṣhaiḥ\n" + "bhuñjate te tvaghaṁ pāpā ye pachantyātma-kāraṇāt",R.color.trans));
        mData.add(new NewsItem("अन्नाद्भवन्ति भूतानि पर्जन्यादन्नसम्भव: |\n" + "यज्ञाद्भवति पर्जन्यो यज्ञ: कर्मसमुद्भव: || 14||"," annāt—from food; bhavanti—subsist; bhūtāni—living beings; parjanyāt—from rains; anna—of food grains; sambhavaḥ—production; yajñāt—from the performance of sacrifice; bhavati—becomes possible; parjanyaḥ—rain; yajñaḥ—performance of sacrifice; karma—prescribed duties; samudbhavaḥ—born of ","annād bhavanti bhūtāni parjanyād anna-sambhavaḥ\n" + "yajñād bhavati parjanyo yajñaḥ karma-samudbhavaḥ",R.color.trans));
        mData.add(new NewsItem("कर्म ब्रह्मोद्भवं विद्धि ब्रह्माक्षरसमुद्भवम् |\n" + "तस्मात्सर्वगतं ब्रह्म नित्यं यज्ञे प्रतिष्ठितम् || 15||"," karma—duties; brahma—in the Vedas; udbhavam—manifested; viddhi—you should know; brahma—The Vedas; akṣhara—from the Imperishable (God); samudbhavam—directly manifested; tasmāt—therefore; sarva-gatam—all-pervading; brahma—The Lord; nityam—eternally; yajñe—in sacrifice; pratiṣhṭhitam—established ","karma brahmodbhavaṁ viddhi brahmākṣhara-samudbhavam\n" + "tasmāt sarva-gataṁ brahma nityaṁ yajñe pratiṣhṭhitam",R.color.trans));
        mData.add(new NewsItem("एवं प्रवर्तितं चक्रं नानुवर्तयतीह य: |\n" + "अघायुरिन्द्रियारामो मोघं पार्थ स जीवति || 16||"," evam—thus; pravartitam—set into motion; chakram—cycle; na—not; anuvartayati—follow; iha—in this life; yaḥ—who; agha-āyuḥ—sinful living; indriya-ārāmaḥ—for the delight of their senses; mogham—vainly; pārtha—Arjun, the son of Pritha; saḥ—they; jīvati—live ","evaṁ pravartitaṁ chakraṁ nānuvartayatīha yaḥ\n" + "aghāyur indriyārāmo moghaṁ pārtha sa jīvati",R.color.trans));
        mData.add(new NewsItem("यस्त्वात्मरतिरेव स्यादात्मतृप्तश्च मानव: |\n" + "आत्मन्येव च सन्तुष्टस्तस्य कार्यं न विद्यते || 17||"," yaḥ—who; tu—but; ātma-ratiḥ—rejoice in the self; eva—certainly; syāt—is; ātma-tṛiptaḥ—self-satisfied; cha—and; mānavaḥ—human being; ātmani—in the self; eva—certainly; cha—and; santuṣhṭaḥ—satisfied; tasya—his; kāryam—duty; na—not; vidyate—exist ","yas tvātma-ratir eva syād ātma-tṛiptaśh cha mānavaḥ\n" + "ātmanyeva cha santuṣhṭas tasya kāryaṁ na vidyate",R.color.trans));
        mData.add(new NewsItem("नैव तस्य कृतेनार्थो नाकृतेनेह कश्चन |\n" + "न चास्य सर्वभूतेषु कश्चिदर्थव्यपाश्रय: || 18||"," na—not; eva—indeed; tasya—his; kṛitena—by discharge of duty; arthaḥ—gain; na—not; akṛitena—without discharge of duty; iha—here; kaśhchana—whatsoever; na—never; cha—and; asya—of that person; sarva-bhūteṣhu—among all living beings; kaśhchit—any; artha—necessity; vyapāśhrayaḥ—to depend upon ","naiva tasya kṛitenārtho nākṛiteneha kaśhchana\n" + "na chāsya sarva-bhūteṣhu kaśhchid artha-vyapāśhrayaḥ",R.color.trans));
        mData.add(new NewsItem("तस्मादसक्त: सततं कार्यं कर्म समाचर |\n" + "असक्तो ह्याचरन्कर्म परमाप्नोति पूरुष: || 19||"," tasmāt—therefore; asaktaḥ—without attachment; satatam—constantly; kāryam—duty; karma—action; samāchara—perform; asaktaḥ—unattached; hi—certainly; ācharan—performing; karma—work; param—the Supreme; āpnoti—attains; pūruṣhaḥ—a person ","tasmād asaktaḥ satataṁ kāryaṁ karma samāchara\n" + "asakto hyācharan karma param āpnoti pūruṣhaḥ",R.color.trans));
        mData.add(new NewsItem("कर्मणैव हि संसिद्धिमास्थिता जनकादय: |\n" + "लोकसंग्रहमेवापि सम्पश्यन्कर्तुमर्हसि || 20||\n" + "यद्यदाचरति श्रेष्ठस्तत्तदेवेतरो जन: |\n" + "स यत्प्रमाणं कुरुते लोकस्तदनुवर्तते || 21||"," karmaṇā—by the performance of prescribed duties; eva—only; hi—certainly; sansiddhim—perfection; āsthitāḥ—attained; janaka-ādayaḥ—King Janak and other kings; loka-saṅgraham—for the welfare of the masses; eva api—only; sampaśhyan—considering; kartum—to perform; arhasi—you should; yat yat—whatever; ācharati—does; śhreṣhṭhaḥ—the best; tat tat—that (alone); eva—certainly; itaraḥ—common; janaḥ—people; saḥ—they; yat—whichever; pramāṇam—standard; kurute—perform; lokaḥ—world; tat—that; anuvartate—pursues ","karmaṇaiva hi sansiddhim āsthitā janakādayaḥ\n" + "loka-saṅgraham evāpi sampaśhyan kartum arhasi\n" + "yad yad ācharati śhreṣhṭhas tat tad evetaro janaḥ\n" + "sa yat pramāṇaṁ kurute lokas tad anuvartate",R.color.trans));
        mData.add(new NewsItem("न मे पार्थास्ति कर्तव्यं त्रिषु लोकेषु किञ्चन |\n" + "नानवाप्तमवाप्तव्यं वर्त एव च कर्मणि || 22||"," na—not; me—mine; pārtha—Arjun; asti—is; kartavyam—duty; triṣhu—in the three; lokeṣhu—worlds; kiñchana—any; na—not; anavāptam—to be attained; avāptavyam—to be gained; varte—I am engaged; eva—yet; cha—also; karmaṇi—in prescribed duties ","na me pārthāsti kartavyaṁ triṣhu lokeṣhu kiñchana\n" + "nānavāptam avāptavyaṁ varta eva cha karmaṇi",R.color.trans));
        mData.add(new NewsItem("यदि ह्यहं न वर्तेयं जातु कर्मण्यतन्द्रित: |\n" + "मम वर्त्मानुवर्तन्ते मनुष्या: पार्थ सर्वश: || 23||"," yadi—if; hi—certainly; aham—I; na—not; varteyam—thus engage; jātu—ever; karmaṇi—in the performance of prescribed duties; atandritaḥ—carefully; mama—my; vartma—path; anuvartante—follow; manuṣhyāḥ—all men; pārtha—Arjun, the son of Pritha; sarvaśhaḥ—in all respects ","\n" + "\n" + "yadi hyahaṁ na varteyaṁ jātu karmaṇyatandritaḥ\n" + "mama vartmānuvartante manuṣhyāḥ pārtha sarvaśhaḥ\n",R.color.trans));
        mData.add(new NewsItem("उत्सीदेयुरिमे लोका न कुर्यां कर्म चेदहम् |\n" + "सङ्करस्य च कर्ता स्यामुपहन्यामिमा: प्रजा: || 24||"," utsīdeyuḥ—would perish; ime—all these; lokāḥ—worlds; na—not; kuryām—I perform; karma—prescribed duties; chet—if; aham—I; sankarasya—of uncultured population; cha—and; kartā—responsible; syām—would be; upahanyām—would destroy; imāḥ—all these; prajāḥ—living entities ","utsīdeyur ime lokā na kuryāṁ karma ched aham\n" + "sankarasya cha kartā syām upahanyām imāḥ prajāḥ",R.color.trans));
        mData.add(new NewsItem("सक्ता: कर्मण्यविद्वांसो यथा कुर्वन्ति भारत |\n" + "कुर्याद्विद्वांस्तथासक्तश्चिकीर्षुर्लोकसंग्रहम् || 25||"," saktāḥ—attached; karmaṇi—duties; avidvānsaḥ—the ignorant; yathā—as much as; kurvanti—act; bhārata—scion of Bharat (Arjun); kuryāt—should do; vidvān—the wise; tathā—thus; asaktaḥ—unattached; chikīrṣhuḥ—wishing; loka-saṅgraham—welfare of the world ","saktāḥ karmaṇyavidvānso yathā kurvanti bhārata\n" + "kuryād vidvāns tathāsaktaśh chikīrṣhur loka-saṅgraham",R.color.trans));
        mData.add(new NewsItem("न बुद्धिभेदं जनयेदज्ञानां कर्मसङ्गिनाम् |\n" + "जोषयेत्सर्वकर्माणि विद्वान्युक्त: समाचरन् || 26||"," na—not; buddhi-bhedam—discord in the intellects; janayet—should create; ajñānām—of the ignorant; karma-saṅginām—who are attached to fruitive actions; joṣhayet—should inspire (them) to perform; sarva—all; karmāṇi—prescribed; vidvān—the wise; yuktaḥ—enlightened; samācharan—performing properly ","\n" + "na buddhi-bhedaṁ janayed ajñānāṁ karma-saṅginām\n" + "joṣhayet sarva-karmāṇi vidvān yuktaḥ samācharan\n",R.color.trans));
        mData.add(new NewsItem("प्रकृते: क्रियमाणानि गुणै: कर्माणि सर्वश: |\n" + "अहङ्कारविमूढात्मा कर्ताहमिति मन्यते || 27||"," prakṛiteḥ—of material nature; kriyamāṇāni—carried out; guṇaiḥ—by the three modes; karmāṇi—activities; sarvaśhaḥ—all kinds of; ahankāra-vimūḍha-ātmā—those who are bewildered by the ego and misidentify themselves with the body; kartā—the doer; aham—I; iti—thus; manyate—thinks ","prakṛiteḥ kriyamāṇāni guṇaiḥ karmāṇi sarvaśhaḥ\n" + "ahankāra-vimūḍhātmā kartāham iti manyate",R.color.trans));
        mData.add(new NewsItem("तत्ववित्तु महाबाहो गुणकर्मविभागयो: |\n" + "गुणा गुणेषु वर्तन्त इति मत्वा न सज्जते || 28||"," tattva-vit—the knower of the Truth; tu—but; mahā-bāho—mighty-armed one; guṇa-karma—from guṇas and karma; vibhāgayoḥ—distinguish; guṇāḥ—modes of material nature in the shape of the senses, mind, etc; guṇeṣhu—modes of material nature in the shape of objects of perception; vartante—are engaged; iti—thus; matvā—knowing; na—never; sajjate—becomes attached ","tattva-vit tu mahā-bāho guṇa-karma-vibhāgayoḥ\n" + "guṇā guṇeṣhu vartanta iti matvā na sajjate",R.color.trans));
        mData.add(new NewsItem("प्रकृतेर्गुणसम्मूढा: सज्जन्ते गुणकर्मसु |\n" + "तानकृत्स्नविदो मन्दान्कृत्स्नविन्न विचालयेत् || 29||"," prakṛiteḥ—of material nature; guṇa—by the modes of material nature; sammūḍhāḥ—deluded; sajjante—become attached; guṇa-karmasu—to results of actions; tān—those; akṛitsna-vidaḥ—persons without knowledge; mandān—the ignorant; kṛitsna-vit—persons with knowledge; na vichālayet—should not unsettle ","prakṛiter guṇa-sammūḍhāḥ sajjante guṇa-karmasu\n" + "tān akṛitsna-vido mandān kṛitsna-vin na vichālayet",R.color.trans));
        mData.add(new NewsItem("मयि सर्वाणि कर्माणि संन्यस्याध्यात्मचेतसा |\n" + "निराशीर्निनर्ममो भूत्वा युध्यस्व विगतज्वर: || 30||"," mayi—unto me; sarvāṇi—all; karmāṇi—works; sannyasya—renouncing completely; adhyātma-chetasā—with the thoughts resting on God; nirāśhīḥ—free from hankering for the results of the actions; nirmamaḥ—without ownership; bhūtvā—so being; yudhyasva—fight; vigata-jvaraḥ—without mental fever ","mayi sarvāṇi karmāṇi sannyasyādhyātma-chetasā\n" + "nirāśhīr nirmamo bhūtvā yudhyasva vigata-jvaraḥ",R.color.trans));
        mData.add(new NewsItem("ये मे मतमिदं नित्यमनुतिष्ठन्ति मानवा: |\n" + "श्रद्धावन्तोऽनसूयन्तो मुच्यन्ते तेऽपि कर्मभि: || 31||"," ye—who; me—my; matam—teachings; idam—these; nityam—constantly; anutiṣhṭhanti—abide by; mānavāḥ—human beings; śhraddhā-vantaḥ—with profound faith; anasūyantaḥ—free from cavilling; muchyante—become free; te—those; api—also; karmabhiḥ—from the bondage of karma ","ye me matam idaṁ nityam anutiṣhṭhanti mānavāḥ\n" + "śhraddhāvanto ’nasūyanto muchyante te ’pi karmabhiḥ",R.color.trans));
        mData.add(new NewsItem("ये त्वेतदभ्यसूयन्तो नानुतिष्ठन्ति मे मतम् |\n" + "सर्वज्ञानविमूढांस्तान्विद्धि नष्टानचेतस: || 32||"," ye—those; tu—but; etat—this; abhyasūyantaḥ—cavilling; na—not; anutiṣhṭhanti—follow; me—my; matam—teachings; sarva-jñāna—in all types of knowledge; vimūḍhān—deluded; tān—they are; viddhi—know; naṣhṭān—ruined; achetasaḥ—devoid of discrimination ","ye tvetad abhyasūyanto nānutiṣhṭhanti me matam\n" + "sarva-jñāna-vimūḍhāns tān viddhi naṣhṭān achetasaḥ",R.color.trans));
        mData.add(new NewsItem("सदृशं चेष्टते स्वस्या: प्रकृतेर्ज्ञानवानपि |\n" + "प्रकृतिं यान्ति भूतानि निग्रह: किं करिष्यति || 33||"," sadṛiśham—accordingly; cheṣhṭate—act; svasyāḥ—by their own; prakṛiteḥ—modes of nature; jñāna-vān—the wise; api—even; prakṛitim—nature; yānti—follow; bhūtāni—all living beings; nigrahaḥ—repression; kim—what; kariṣhyati—will do ","sadṛiśhaṁ cheṣhṭate svasyāḥ prakṛiter jñānavān api\n" + "prakṛitiṁ yānti bhūtāni nigrahaḥ kiṁ kariṣhyati",R.color.trans));
        mData.add(new NewsItem("इन्द्रियस्येन्द्रियस्यार्थे रागद्वेषौ व्यवस्थितौ |\n" + "तयोर्न वशमागच्छेत्तौ ह्यस्य परिपन्थिनौ || 34||"," indriyasya—of the senses; indriyasya arthe—in the sense objects; rāga—attachment; dveṣhau—aversion; vyavasthitau—situated; tayoḥ—of them; na—never; vaśham—be controlled; āgachchhet—should become; tau—those; hi—certainly; asya—for him; paripanthinau—foes ","indriyasyendriyasyārthe rāga-dveṣhau vyavasthitau\n" + "tayor na vaśham āgachchhet tau hyasya paripanthinau",R.color.trans));
        mData.add(new NewsItem("श्रेयान्स्वधर्मो विगुण: परधर्मात्स्वनुष्ठितात् |\n" + "स्वधर्मे निधनं श्रेय: परधर्मो भयावह: || 35||"," śhreyān—better; swa-dharmaḥ—personal duty; viguṇaḥ—tinged with faults; para-dharmāt—than another’s prescribed duties; su-anuṣhṭhitāt—perfectly done; swa-dharme—in one’s personal duties; nidhanam—death; śhreyaḥ—better; para-dharmaḥ—duties prescribed for others; bhaya-āvahaḥ—fraught with fear ","\n" + "\n" + "śhreyān swa-dharmo viguṇaḥ para-dharmāt sv-anuṣhṭhitāt\n" + "swa-dharme nidhanaṁ śhreyaḥ para-dharmo bhayāvahaḥ\n",R.color.trans));
        mData.add(new NewsItem("अर्जुन उवाच |\n" + "अथ केन प्रयुक्तोऽयं पापं चरति पूरुष: |\n" + "अनिच्छन्नपि वार्ष्णेय बलादिव नियोजित: || 36||"," arjunaḥ uvācha—Arjun said; atha—then; kena—by what; prayuktaḥ—impelled; ayam—one; pāpam—sins; charati—commit; pūruṣhaḥ—a person; anichchhan—unwillingly; api—even; vārṣhṇeya—he who belongs to the Vrishni clan, Shree Krishna; balāt—by force; iva—as if; niyojitaḥ—engaged ","arjuna uvācha\n" + "atha kena prayukto ’yaṁ pāpaṁ charati pūruṣhaḥ\n" + "anichchhann api vārṣhṇeya balād iva niyojitaḥ",R.color.trans));
        mData.add(new NewsItem("श्रीभगवानुवाच |\n" + "काम एष क्रोध एष रजोगुणसमुद्भव: ||\n" + "महाशनो महापाप्मा विद्ध्येनमिह वैरिणम् || 37||"," śhri-bhagavān uvācha—the Supreme Lord said; kāmaḥ—desire; eṣhaḥ—this; krodhaḥ—wrath; eṣhaḥ—this; rajaḥ-guṇa—the mode of passion; samudbhavaḥ—born of; mahā-aśhanaḥ—all-devouring; mahā-pāpmā—greatly sinful; viddhi—know; enam—this; iha—in the material world; vairiṇam—the enemy ","śhrī bhagavān uvācha\n" + "kāma eṣha krodha eṣha rajo-guṇa-samudbhavaḥ\n" + "mahāśhano mahā-pāpmā viddhyenam iha vairiṇam",R.color.trans));
        mData.add(new NewsItem("धूमेनाव्रियते वह्निर्यथादर्शो मलेन च |\n" + "यथोल्बेनावृतो गर्भस्तथा तेनेदमावृतम् || 38||"," dhūmena—by smoke; āvriyate—is covered; vahniḥ—fire; yathā—just as; ādarśhaḥ—mirror; malena—by dust; cha—also; yathā—just as; ulbena—by the womb; āvṛitaḥ—is covered; garbhaḥ—embryo; tathā—similarly; tena—by that (desire); idam—this; āvṛitam—is covered ","dhūmenāvriyate vahnir yathādarśho malena cha\n" + "yatholbenāvṛito garbhas tathā tenedam āvṛitam",R.color.trans));
        mData.add(new NewsItem("आवृतं ज्ञानमेतेन ज्ञानिनो नित्यवैरिणा |\n" + "कामरूपेण कौन्तेय दुष्पूरेणानलेन च || 39||"," āvṛitam—covered; jñānam—knowledge; etena—by this; jñāninaḥ—of the wise; nitya-vairiṇā—by the perpetual enemy; kāma-rūpeṇa—in the form of desires; kaunteya—Arjun the son of Kunti; duṣhpūreṇa—insatiable; analena—like fire; cha—and ","āvṛitaṁ jñānam etena jñānino nitya-vairiṇā\n" + "kāma-rūpeṇa kaunteya duṣhpūreṇānalena cha",R.color.trans));
        mData.add(new NewsItem("इन्द्रियाणि मनो बुद्धिरस्याधिष्ठानमुच्यते |\n" + "एतैर्विमोहयत्येष ज्ञानमावृत्य देहिनम् || 40||"," indriyāṇi—the senses; manaḥ—the mind; buddhiḥ—the intellect; asya—of this; adhiṣhṭhānam—dwelling place; uchyate—are said to be; etaiḥ—by these; vimohayati—deludes; eṣhaḥ—this; jñānam—knowledge; āvṛitya—clouds; dehinam—the embodied soul ","indriyāṇi mano buddhir asyādhiṣhṭhānam uchyate\n" + "etair vimohayatyeṣha jñānam āvṛitya dehinam",R.color.trans));
        mData.add(new NewsItem("तस्मात्त्वमिन्द्रियाण्यादौ नियम्य भरतर्षभ |\n" + "पाप्मानं प्रजहि ह्येनं ज्ञानविज्ञाननाशनम् || 41||"," tasmāt—therefore; tvam—you; indriyāṇi—senses; ādau—in the very beginning; niyamya—having controlled; bharata-ṛiṣhabha—Arjun, the best of the Bharatas; pāpmānam—the sinful; prajahi—slay; hi—certainly; enam—this; jñāna—knowledge; vijñāna—realization; nāśhanam—the destroyer ","tasmāt tvam indriyāṇyādau niyamya bharatarṣhabha\n" + "pāpmānaṁ prajahi hyenaṁ jñāna-vijñāna-nāśhanam",R.color.trans));
        mData.add(new NewsItem("इन्द्रियाणि पराण्याहुरिन्द्रियेभ्य: परं मन: |\n" + "मनसस्तु परा बुद्धिर्यो बुद्धे: परतस्तु स: || 42||"," indriyāṇi—senses; parāṇi—superior; āhuḥ—are said; indriyebhyaḥ—than the senses; param—superior; manaḥ—the mind; manasaḥ—than the mind; tu—but; parā—superior; buddhiḥ—intellect; yaḥ—who; buddheḥ—than the intellect; parataḥ—more superior; tu—but; saḥ—that (soul) ","indriyāṇi parāṇyāhur indriyebhyaḥ paraṁ manaḥ\n" + "manasas tu parā buddhir yo buddheḥ paratas tu saḥ",R.color.trans));
        mData.add(new NewsItem("एवं बुद्धे: परं बुद्ध्वा संस्तभ्यात्मानमात्मना |\n" + "जहि शत्रुं महाबाहो कामरूपं दुरासदम् || 43||"," evam—thus; buddheḥ—than the intellect; param—superior; buddhvā—knowing; sanstabhya—subdue; ātmānam—the lower self (senses, mind, and intellect); ātmanā—by higher self (soul); jahi—kill; śhatrum—the enemy; mahā-bāho—mighty-armed one; kāma-rūpam—in the form of desire; durāsadam—formidable ","\n" + "\n" + "evaṁ buddheḥ paraṁ buddhvā sanstabhyātmānam ātmanā\n" + "jahi śhatruṁ mahā-bāho kāma-rūpaṁ durāsadam\n",R.color.trans));


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

            Intent myIntent = new Intent(this, Chp3.class);
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