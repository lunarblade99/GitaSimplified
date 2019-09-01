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
import com.github.gitasimplified.chp.Chp16;
import com.shashank.sony.fancygifdialoglib.FancyGifDialog;
import com.shashank.sony.fancygifdialoglib.FancyGifDialogListener;

import java.util.ArrayList;
import java.util.List;

public class Vchp16 extends AppCompatActivity
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
        navigationView.getMenu().getItem(15).setChecked(true);

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
        mData.add(new NewsItem("श्रीभगवानुवाच |\n" + "अभयं सत्वसंशुद्धिर्ज्ञानयोगव्यवस्थिति: |\n" + "दानं दमश्च यज्ञश्च स्वाध्यायस्तप आर्जवम् || 1||\n" + "अहिंसा सत्यमक्रोधस्त्याग: शान्तिरपैशुनम् |\n" + "दया भूतेष्वलोलुप्त्वं मार्दवं ह्रीरचापलम् || 2||\n" + "तेज: क्षमा धृति: शौचमद्रोहोनातिमानिता |\n" + "भवन्ति सम्पदं दैवीमभिजातस्य भारत || 3||"," śhrī-bhagavān uvācha—the Supreme Divine Personality said; abhayam—fearlessness; sattva-sanśhuddhiḥ—purity of mind; jñāna—knowledge; yoga—spiritual; vyavasthitiḥ—steadfastness; dānam—charity; damaḥ—control of the senses; cha—and; yajñaḥ—performance of sacrifice; cha—and; svādhyāyaḥ—study of sacred books; tapaḥ—austerity; ārjavam—straightforwardness; ahinsā—non-violence; satyam—truthfulness; akrodhaḥ—absence of anger; tyāgaḥ—renunciation; śhāntiḥ—peacefulness; apaiśhunam—restraint from fault-finding; dayā—compassion; bhūteṣhu—toward all living beings; aloluptvam—absence of covetousness; mārdavam—gentleness; hrīḥ—modesty; achāpalam—lack of fickleness; tejaḥ—vigor; kṣhamā—forgiveness; dhṛitiḥ—fortitude; śhaucham—cleanliness; adrohaḥ—bearing enmity toward none; na—not; ati-mānitā—absence of vanity; bhavanti—are; sampadam—qualities; daivīm—godly; abhijātasya—of those endowed with; bhārata—scion of Bharat ","śhrī-bhagavān uvācha\n" + "abhayaṁ sattva-sanśhuddhir jñāna-yoga-vyavasthitiḥ\n" + "dānaṁ damaśh cha yajñaśh cha svādhyāyas tapa ārjavam\n" + "ahinsā satyam akrodhas tyāgaḥ śhāntir apaiśhunam\n" + "dayā bhūteṣhv aloluptvaṁ mārdavaṁ hrīr achāpalam\n" + "tejaḥ kṣhamā dhṛitiḥ śhaucham adroho nāti-mānitā\n" + "bhavanti sampadaṁ daivīm abhijātasya bhārata",R.color.trans));
        mData.add(new NewsItem("दम्भो दर्पोऽभिमानश्च क्रोध: पारुष्यमेव च |\n" + "अज्ञानं चाभिजातस्य पार्थ सम्पदमासुरीम् || 4||"," dambhaḥ—hypocrisy; darpaḥ—arrogance; abhimānaḥ—conceit; cha—and; krodhaḥ—anger; pāruṣhyam—harshness; eva—certainly; cha—and; ajñānam—ignorance; cha—and; abhijātasya—of those who possess; pārtha—Arjun, the son of Pritha; sampadam—qualities; āsurīm—demoniac ","dambho darpo ’bhimānaśh cha krodhaḥ pāruṣhyam eva cha\n" + "ajñānaṁ chābhijātasya pārtha sampadam āsurīm",R.color.trans));
        mData.add(new NewsItem("दैवी सम्पद्विमोक्षाय निबन्धायासुरी मता |\n" + "मा शुच: सम्पदं दैवीमभिजातोऽसि पाण्डव || 5||"," daivī—divine; sampat—qualities; vimokṣhāya—toward liberation; nibandhāya—to bondage; āsurī—demoniac qualities; matā—are considered; mā—do not; śhuchaḥ—grieve; sampadam—virtues; daivīm—saintly; abhijātaḥ—born; asi—you are; pāṇḍava—Arjun, the son of Pandu ","daivī sampad vimokṣhāya nibandhāyāsurī matā\n" + "mā śhuchaḥ sampadaṁ daivīm abhijāto ’si pāṇḍava",R.color.trans));
        mData.add(new NewsItem("द्वौ भूतसर्गौ लोकेऽस्मिन्दैव आसुर एव च |\n" + "दैवो विस्तरश: प्रोक्त आसुरं पार्थ मे शृणु || 6||"," dvau—two; bhūta-sargau—of created living beings; loke—in the world; asmin—this; daivaḥ—divine; āsuraḥ—demoniac; eva—certainly; cha—and; daivaḥ—the divine; vistaraśhaḥ—at great length; proktaḥ—said; āsuram—the demoniac; pārtha—Arjun, the son of Pritha; me—from me; śhṛiṇu—hear ","dvau bhūta-sargau loke ’smin daiva āsura eva cha\n" + "daivo vistaraśhaḥ prokta āsuraṁ pārtha me śhṛiṇu",R.color.trans));
        mData.add(new NewsItem("प्रवृत्तिं च निवृत्तिं च जना न विदुरासुरा: |\n" + "न शौचं नापि चाचारो न सत्यं तेषु विद्यते || 7||"," pravṛittim—proper actions; cha—and; nivṛittim—improper actions; cha—and; janāḥ—persons; na—not; viduḥ—comprehend; āsurāḥ—those possessing demoniac nature; na—neither; śhaucham—purity; na—nor; api—even; cha—and; āchāraḥ—conduct; na—nor; satyam—truthfulness; teṣhu—in them; vidyate—exist ","pravṛittiṁ cha nivṛittiṁ cha janā na vidur āsurāḥ\n" + "na śhauchaṁ nāpi chāchāro na satyaṁ teṣhu vidyate",R.color.trans));
        mData.add(new NewsItem("असत्यमप्रतिष्ठं ते जगदाहुरनीश्वरम् |\n" + "अपरस्परसम्भूतं किमन्यत्कामहैतुकम् || 8||"," asatyam—without absolute truth; apratiṣhṭham—without any basis; te—they; jagat—the world; āhuḥ—say; anīśhvaram—without a God; aparaspara—without cause; sambhūtam—created; kim—what; anyat—other; kāma-haitukam—for sexual gratification only ","asatyam apratiṣhṭhaṁ te jagad āhur anīśhvaram\n" + "aparaspara-sambhūtaṁ kim anyat kāma-haitukam",R.color.trans));
        mData.add(new NewsItem("एतां दृष्टिमवष्टभ्य नष्टात्मानोऽल्पबुद्धय: |\n" + "प्रभवन्त्युग्रकर्माण: क्षयाय जगतोऽहिता: || 9||"," etām—such; dṛiṣhṭim—views; avaṣhṭabhya—holding; naṣhṭa—misdirected; ātmānaḥ—souls; alpa-buddhayaḥ—of small intellect; prabhavanti—arise; ugra—cruel; karmāṇaḥ—actions; kṣhayāya—destruction; jagataḥ—of the world; ahitāḥ—enemies ","etāṁ dṛiṣhṭim avaṣhṭabhya naṣhṭātmāno ’lpa-buddhayaḥ\n" + "prabhavanty ugra-karmāṇaḥ kṣhayāya jagato ’hitāḥ",R.color.trans));
        mData.add(new NewsItem("काममाश्रित्य दुष्पूरं दम्भमानमदान्विता: |\n" + "मोहाद्गृहीत्वासद्ग्राहान्प्रवर्तन्तेऽशुचिव्रता: || 10||"," kāmam—lust; āśhritya—harboring; duṣhpūram—insatiable; dambha—hypocrisy; māna—arrogance; mada-anvitāḥ—clinging to false tenets; mohāt—the illusioned; gṛihītvā—being attracted to; asat—impermanent; grāhān—things; pravartante—they flourish; aśhuchi-vratāḥ—with impure resolve ","kāmam āśhritya duṣhpūraṁ dambha-māna-madānvitāḥ\n" + "mohād gṛihītvāsad-grāhān pravartante ’śhuchi-vratāḥ",R.color.trans));
        mData.add(new NewsItem("चिन्तामपरिमेयां च प्रलयान्तामुपाश्रिता: |\n" + "कामोपभोगपरमा एतावदिति निश्चिता: || 11||"," chintām—anxieties; aparimeyām—endless; cha—and; pralaya-antām—until death; upāśhritāḥ—taking refuge; kāma-upabhoga—gratification of desires; paramāḥ—the purpose of life; etāvat—still; iti—thus; niśhchitāḥ—with complete assurance ","chintām aparimeyāṁ cha pralayāntām upāśhritāḥ\n" + "kāmopabhoga-paramā etāvad iti niśhchitāḥ",R.color.trans));
        mData.add(new NewsItem("आशापाशशतैर्बद्धा: कामक्रोधपरायणा: |\n" + "ईहन्ते कामभोगार्थमन्यायेनार्थसञ्जयान् || 12||"," āśhā-pāśha—bondage of desires; śhataiḥ—by hundreds; baddhāḥ—bound; kāma—lust; krodha—anger; parāyaṇāḥ—dedicated to; īhante—strive; kāma—lust; bhoga—gratification of the senses; artham—for; anyāyena—by unjust means; artha—wealth; sañchayān—to accumulate ","āśhā-pāśha-śhatair baddhāḥ kāma-krodha-parāyaṇāḥ\n" + "īhante kāma-bhogārtham anyāyenārtha-sañchayān",R.color.trans));
        mData.add(new NewsItem("इदमद्य मया लब्धमिमं प्राप्स्ये मनोरथम् |\n" + "इदमस्तीदमपि मे भविष्यति पुनर्धनम् || 13||\n" + "असौ मया हत: शत्रुर्हनिष्ये चापरानपि |\n" + "ईश्वरोऽहमहं भोगी सिद्धोऽहं बलवान्सुखी || 14||\n" + "आढ्योऽभिजनवानस्मि कोऽन्योऽस्ति सदृशो मया |\n" + "यक्ष्ये दास्यामि मोदिष्य इत्यज्ञानविमोहिता: || 15||"," idam—this; adya—today; mayā—by me; labdham—gained; imam—this; prāpsye—I shall acquire; manaḥ-ratham—desire; idam—this; asti—is; idam—this; api—also; me—mine; bhaviṣhyati—in future; punaḥ—again; dhanam—wealth; asau—that; mayā—by me; hataḥ—has been destroyed; śhatruḥ—enemy; haniṣhye—I shall destroy; cha—and; aparān—others; api—also; īśhvaraḥ—God; aham—I; aham—I; bhogī—the enjoyer; siddhaḥ—powerful; aham—I; bala-vān—powerful; sukhī—happy; āḍhyaḥ—wealthy; abhijana-vān—having highly placed relatives; asmi—me; kaḥ—who; anyaḥ—else; asti—is; sadṛiśhaḥ—like; mayā—to me; yakṣhye—I shall perform sacrifices; dāsyāmi—I shall give alms; modiṣhye—I shall rejoice; iti—thus; ajñāna—ignorance; vimohitāḥ—deluded ","idam adya mayā labdham imaṁ prāpsye manoratham\n" + "idam astīdam api me bhaviṣhyati punar dhanam\n" + "asau mayā hataḥ śhatrur haniṣhye chāparān api\n" + "īśhvaro ’ham ahaṁ bhogī siddho ’haṁ balavān sukhī\n" + "āḍhyo ’bhijanavān asmi ko ’nyo ’sti sadṛiśho mayā\n" + "yakṣhye dāsyāmi modiṣhya ity ajñāna-vimohitāḥ",R.color.trans));
        mData.add(new NewsItem("अनेकचित्तविभ्रान्ता मोहजालसमावृता: |\n" + "प्रसक्ता: कामभोगेषु पतन्ति नरकेऽशुचौ || 16||"," aneka—many; chitta—imaginings; vibhrāntāḥ—led astray; moha—delusion; jāla—mesh; samāvṛitāḥ—enveloped; prasaktāḥ—addicted; kāma-bhogeṣhu—gratification of sensuous pleasures; patanti—descend; narake—to hell; aśhuchau—murky ","aneka-chitta-vibhrāntā moha-jāla-samāvṛitāḥ\n" + "prasaktāḥ kāma-bhogeṣhu patanti narake ’śhuchau",R.color.trans));
        mData.add(new NewsItem("आत्मसम्भाविता: स्तब्धा धनमानमदान्विता: |\n" + "यजन्ते नामयज्ञैस्ते दम्भेनाविधिपूर्वकम् || 17||"," ātma-sambhāvitāḥ—self-conceited; stabdhāḥ—stubborn; dhana—wealth; māna—pride; mada—arrogance; anvitāḥ—full of; yajante—perform sacrifice; nāma—in name only; yajñaiḥ—sacrifices; te—they; dambhena—ostentatiously; avidhi-pūrvakam—with no regards to the rules of the scriptures ","ātma-sambhāvitāḥ stabdhā dhana-māna-madānvitāḥ\n" + "yajante nāma-yajñais te dambhenāvidhi-pūrvakam",R.color.trans));
        mData.add(new NewsItem("अहङ्कारं बलं दर्पं कामं क्रोधं च संश्रिता: |\n" + "मामात्मपरदेहेषु प्रद्विषन्तोऽभ्यसूयका: || 18||"," ahankāram—egotism; balam—strength; darpam—arrogance; kāmam—desire; krodham—anger; cha—and; sanśhritāḥ—covered by; mām—me; ātma-para-deheṣhu—within one’s own and bodies of others; pradviṣhantaḥ—abuse; abhyasūyakāḥ—the demoniac ","ahankāraṁ balaṁ darpaṁ kāmaṁ krodhaṁ cha sanśhritāḥ\n" + "mām ātma-para-deheṣhu pradviṣhanto ’bhyasūyakāḥ",R.color.trans));
        mData.add(new NewsItem("\n" + "तानहं द्विषत: क्रूरान्संसारेषु नराधमान् |\n" + "क्षिपाम्यजस्रमशुभानासुरीष्वेव योनिषु || 19||\n" + "आसुरीं योनिमापन्ना मूढा जन्मनि जन्मनि |\n" + "मामप्राप्यैव कौन्तेय ततो यान्त्यधमां गतिम् || 20||\n"," tān—these; aham—I; dviṣhataḥ—hateful; krūrān—cruel; sansāreṣhu—in the material world; nara-adhamān—the vile and vicious of humankind; kṣhipāmi—I hurl; ajasram—again and again; aśhubhān—inauspicious; āsurīṣhu—demoniac; eva—indeed; yoniṣhu—in to the wombs; āsurīm—demoniac; yonim—wombs; āpannāḥ—gaining; mūḍhāḥ—the ignorant; janmani janmani—in birth after birth; mām—me; aprāpya—failing to reach; eva—even; kaunteya—Arjun, the son of Kunti; tataḥ—thereafter; yānti—go; adhamām—abominable; gatim—destination ","tān ahaṁ dviṣhataḥ krūrān sansāreṣhu narādhamān\n" + "kṣhipāmy ajasram aśhubhān āsurīṣhv eva yoniṣhu\n" + "āsurīṁ yonim āpannā mūḍhā janmani janmani\n" + "mām aprāpyaiva kaunteya tato yānty adhamāṁ gatim",R.color.trans));
        mData.add(new NewsItem("त्रिविधं नरकस्येदं द्वारं नाशनमात्मन: |\n" + "काम: क्रोधस्तथा लोभस्तस्मादेतत्त्रयं त्यजेत् || 21||"," tri-vidham—three types of; narakasya—to the hell; idam—this; dvāram—gates; nāśhanam—destruction; ātmanaḥ—self; kāmaḥ—lust; krodhaḥ—anger; tathā—and; lobhaḥ—greed; tasmāt—therefore; etat—these; trayam—three; tyajet—should abandon ","tri-vidhaṁ narakasyedaṁ dvāraṁ nāśhanam ātmanaḥ\n" + "kāmaḥ krodhas tathā lobhas tasmād etat trayaṁ tyajet",R.color.trans));
        mData.add(new NewsItem("एतैर्विमुक्त: कौन्तेय तमोद्वारैस्त्रिभिर्नर: |\n" + "आचरत्यात्मन: श्रेयस्ततो याति परां गतिम् || 22||"," etaiḥ—from this; vimuktaḥ—freed; kaunteya—Arjun, the son of Kunti; tamaḥ-dvāraiḥ—gates to darkness; tribhiḥ—three; naraḥ—a person; ācharati—endeavor; ātmanaḥ—soul; śhreyaḥ—welfare; tataḥ—thereby; yāti—attain; parām—supreme; gatim—goal ","etair vimuktaḥ kaunteya tamo-dvārais tribhir naraḥ\n" + "ācharaty ātmanaḥ śhreyas tato yāti parāṁ gatim",R.color.trans));
        mData.add(new NewsItem("य: शास्त्रविधिमुत्सृज्य वर्तते कामकारत: |\n" + "न स सिद्धिमवाप्नोति न सुखं न परां गतिम् || 23||"," yaḥ—who; śhāstra-vidhim—scriptural injunctions; utsṛijya—discarding; vartate—act; kāma-kārataḥ—under the impulse of desire; na—neither; saḥ—they; siddhim—perfection; avāpnoti—attain; na—nor; sukham—happiness; na—nor; parām—the supreme; gatim—goal ","yaḥ śhāstra-vidhim utsṛijya vartate kāma-kārataḥ\n" + "na sa siddhim avāpnoti na sukhaṁ na parāṁ gatim",R.color.trans));
        mData.add(new NewsItem("तस्माच्छास्त्रं प्रमाणं ते कार्याकार्यव्यवस्थितौ |\n" + "ज्ञात्वा शास्त्रविधानोक्तं कर्म कर्तुमिहार्हसि || 24||"," tasmāt—therefore; śhāstram—scriptures; pramāṇam—authority; te—your; kārya—duty; akārya—forbidden action; vyavasthitau—in determining; jñātvā—having understood; śhāstra—scriptures; vidhāna—injunctions; uktam—as revealed; karma—actions; kartum—perform; iha—in this world; arhasi—you should ","tasmāch chhāstraṁ pramāṇaṁ te kāryākārya-vyavasthitau\n" + "jñātvā śhāstra-vidhānoktaṁ karma kartum ihārhasi",R.color.trans));

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
                            Intent intent = new Intent(Vchp16.this, CloseActivity.class);
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

            Intent myIntent = new Intent(this, Chp16.class);
            this.startActivity(myIntent);

        }

        if (id == R.id.verses){

        //    Intent myIntent = new Intent(this, Main2Activity.class);
         //   this.startActivity(myIntent);

        }

        if (id == R.id.explain){

            //   Intent myIntent = new Intent(this, Explaination.class);
            //   this.startActivity(myIntent);

            new FancyGifDialog.Builder(Vchp16.this)
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