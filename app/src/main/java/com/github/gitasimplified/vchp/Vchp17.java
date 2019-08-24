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
import com.github.gitasimplified.chp.Chp17;
import com.shashank.sony.fancygifdialoglib.FancyGifDialog;
import com.shashank.sony.fancygifdialoglib.FancyGifDialogListener;

import java.util.ArrayList;
import java.util.List;

public class Vchp17 extends AppCompatActivity
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
        navigationView.getMenu().getItem(16).setChecked(true);

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

        mData.add(new NewsItem("अर्जुन उवाच |\n" + "ये शास्त्रविधिमुत्सृज्य यजन्ते श्रद्धयान्विता: |\n" + "तेषां निष्ठा तु का कृष्ण सत्वमाहो रजस्तम: || 1||"," arjunaḥ uvācha—Arjun said; ye—who; śhāstra-vidhim—scriptural injunctions; utsṛijya—disregard; yajante—worship; śhraddhayā-anvitāḥ—with faith; teṣhām—their; niṣhṭhā—faith; tu—indeed; kā—what; kṛiṣhṇa—Krishna; sattvam—mode of goodness; āho—or; rajaḥ—mode of passion; tamaḥ—mode of ignorance ","arjuna uvācha\n" + "ye śhāstra-vidhim utsṛijya yajante śhraddhayānvitāḥ\n" + "teṣhāṁ niṣhṭhā tu kā kṛiṣhṇa sattvam āho rajas tamaḥ",R.color.trans));
        mData.add(new NewsItem("श्रीभगवानुवाच |\n" + "त्रिविधा भवति श्रद्धा देहिनां सा स्वभावजा |\n" + "सात्विकी राजसी चैव तामसी चेति तां शृणु || 2||"," śhrī-bhagavān uvācha—the Supreme Personality said; tri-vidhā—of three kinds; bhavati—is; śhraddhā—faith; dehinām—embodied beings; sā—which; sva-bhāva-jā—born of one’s innate nature; sāttvikī—of the mode of goodness; rājasī—of the mode of passion; cha—and; eva—certainly; tāmasī—of the mode of ignorance; cha—and; iti—thus; tām—about this; śhṛiṇu—hear ","śhrī-bhagavān uvācha\n" + "tri-vidhā bhavati śhraddhā dehināṁ sā svabhāva-jā\n" + "sāttvikī rājasī chaiva tāmasī cheti tāṁ śhṛiṇu",R.color.trans));
        mData.add(new NewsItem("सत्वानुरूपा सर्वस्य श्रद्धा भवति भारत |\n" + "श्रद्धामयोऽयं पुरुषो यो यच्छ्रद्ध: स एव स: || 3||"," sattva-anurūpā—conforming to the nature of one’s mind; sarvasya—all; śhraddhā—faith; bhavati—is; bhārata—Arjun, the scion of Bharat; śhraddhāmayaḥ—possessing faith; ayam—that; puruṣhaḥ—human being; yaḥ—who; yat-śhraddhaḥ—whatever the nature of their faith; saḥ—their; eva—verily; saḥ—they ","sattvānurūpā sarvasya śhraddhā bhavati bhārata\n" + "śhraddhā-mayo ‘yaṁ puruṣho yo yach-chhraddhaḥ sa eva saḥ",R.color.trans));
        mData.add(new NewsItem("यजन्ते सात्विका देवान्यक्षरक्षांसि राजसा: |\n" + "प्रेतान्भूतगणांश्चान्ये यजन्ते तामसा जना: || 4||"," yajante—worship; sāttvikāḥ—those in the mode of goodness; devān—celestial gods; yakṣha—semi-celestial beings who exude power and wealth; rakṣhānsi—powerful beings who embody sensual enjoyment, revenge, and wrath; rājasāḥ—those in the mode of passion; pretān-bhūta-gaṇān—ghosts and spirits; cha—and; anye—others; yajante—worship; tāmasāḥ—those in the mode of ignorance; janāḥ—persons ","yajante sāttvikā devān yakṣha-rakṣhānsi rājasāḥ\n" + "pretān bhūta-gaṇānśh chānye yajante tāmasā janāḥ",R.color.trans));
        mData.add(new NewsItem("अशास्त्रविहितं घोरं तप्यन्ते ये तपो जना: |\n" + "दम्भाहङ्कारसंयुक्ता: कामरागबलान्विता: || 5||\n" + "कर्षयन्त: शरीरस्थं भूतग्राममचेतस: |\n" + "मां चैवान्त:शरीरस्थं तान्विद्ध्यासुरनिश्चयान् || 6||"," aśhāstra-vihitam—not enjoined by the scriptures; ghoram—stern; tapyante—perform; ye—who; tapaḥ—austerities; janāḥ—people; dambha—hypocrisy; ahankāra—egotism; sanyuktāḥ—possessed of; kāma—desire; rāga—attachment; bala—force; anvitāḥ—impelled by; karṣhayantaḥ—torment; śharīra-stham—within the body; bhūta-grāmam—elements of the body; achetasaḥ—senseless; mām—me; cha—and; eva—even; antaḥ—within; śharīra-stham—dwelling in the body; tān—them; viddhi—know; āsura-niśhchayān—of demoniacal resolves ","aśhāstra-vihitaṁ ghoraṁ tapyante ye tapo janāḥ\n" + "dambhāhankāra-sanyuktāḥ kāma-rāga-balānvitāḥ\n" + "karṣhayantaḥ śharīra-sthaṁ bhūta-grāmam achetasaḥ\n" + "māṁ chaivāntaḥ śharīra-sthaṁ tān viddhy āsura-niśhchayān",R.color.trans));
        mData.add(new NewsItem("आहारस्त्वपि सर्वस्य त्रिविधो भवति प्रिय: |\n" + "यज्ञस्तपस्तथा दानं तेषां भेदमिमं शृणु || 7||"," āhāraḥ—food; tu—indeed; api—even; sarvasya—of all; tri-vidhaḥ—of three kinds; bhavati—is; priyaḥ—dear; yajñaḥ—sacrifice; tapaḥ—austerity; tathā—and; dānam—charity; teṣhām—of them; bhedam—distinctions; imam—this; śhṛiṇu—hear ","āhāras tv api sarvasya tri-vidho bhavati priyaḥ\n" + "yajñas tapas tathā dānaṁ teṣhāṁ bhedam imaṁ śhṛiṇu",R.color.trans));
        mData.add(new NewsItem("आयु:सत्वबलारोग्यसुखप्रीतिविवर्धना: |\n" + "रस्या: स्निग्धा: स्थिरा हृद्या आहारा: सात्विकप्रिया: || 8||"," āyuḥ sattva—which promote longevity; bala—strength; ārogya—health; sukha—happiness; prīti—satisfaction; vivardhanāḥ—increase; rasyāḥ—juicy; snigdhāḥ—succulent; sthirāḥ—nourishing; hṛidyāḥ—pleasing to the heart; āhārāḥ—food; sāttvika-priyāḥ—dear to those in the mode of goodness ","āyuḥ-sattva-balārogya-sukha-prīti-vivardhanāḥ\n" + "rasyāḥ snigdhāḥ sthirā hṛidyā āhārāḥ sāttvika-priyāḥ",R.color.trans));
        mData.add(new NewsItem("कट्वम्ललवणात्युष्णतीक्ष्णरूक्षविदाहिन: |\n" + "आहारा राजसस्येष्टा दु:खशोकामयप्रदा: || 9||"," kaṭu—bitter; amla—sour; lavaṇa—salty; ati-uṣhṇa—very hot; tīkṣhṇa—pungent; rūkṣha—dry; vidāhinaḥ—chiliful; āhārāḥ—food; rājasasya—to persons in the mode of passion; iṣhṭāḥ—dear; duḥkha—pain; śhoka—grief; āmaya—disease; pradāḥ—produce ","kaṭv-amla-lavaṇāty-uṣhṇa- tīkṣhṇa-rūkṣha-vidāhinaḥ\n" + "āhārā rājasasyeṣhṭā duḥkha-śhokāmaya-pradāḥ",R.color.trans));
        mData.add(new NewsItem("यातयामं गतरसं पूति पर्युषितं च यत् |\n" + "उच्छिष्टमपि चामेध्यं भोजनं तामसप्रियम् || 10||"," yāta-yāmam—stale foods; gata-rasam—tasteless; pūti—putrid; paryuṣhitam—polluted; cha—and; yat—which; uchchhiṣhṭam—left over; api—also; cha—and; amedhyam—impure; bhojanam—foods; tāmasa—to persons in the mode of ignorance; priyam—dear ","yāta-yāmaṁ gata-rasaṁ pūti paryuṣhitaṁ cha yat\n" + "uchchhiṣhṭam api chāmedhyaṁ bhojanaṁ tāmasa-priyam",R.color.trans));
        mData.add(new NewsItem("अफलाकाङ्क्षिभिर्यज्ञो विधिदृष्टो य इज्यते |\n" + "यष्टव्यमेवेति मन: समाधाय स सात्विक: || 11||"," aphala-ākāṅkṣhibhiḥ—without expectation of any reward; yajñaḥ—sacrifice; vidhi-driṣhṭaḥ—that is in accordance with the scriptural injunctions; yaḥ—which; ijyate—is performed; yaṣhṭavyam-eva-iti—ought to be offered; manaḥ—mind; samādhāya—with conviction; saḥ—that; sāttvikaḥ—of the nature of goodness ","aphalākāṅkṣhibhir yajño vidhi-driṣhṭo ya ijyate\n" + "yaṣhṭavyam eveti manaḥ samādhāya sa sāttvikaḥ",R.color.trans));
        mData.add(new NewsItem("अभिसन्धाय तु फलं दम्भार्थमपि चैव यत् |\n" + "इज्यते भरतश्रेष्ठ तं यज्ञं विद्धि राजसम् || 12||"," abhisandhāya—motivated by; tu—but; phalam—the result; dambha—pride; artham—for the sake of; api—also; cha—and; eva—certainly; yat—that which; ijyate—is performed; bharata-śhreṣhṭha—Arjun, the best of the Bharatas; tam—that; yajñam—sacrifice; viddhi—know; rājasam—in the mode of passion ","abhisandhāya tu phalaṁ dambhārtham api chaiva yat\n" + "ijyate bharata-śhreṣhṭha taṁ yajñaṁ viddhi rājasam",R.color.trans));
        mData.add(new NewsItem("विधिहीनमसृष्टान्नं मन्त्रहीनमदक्षिणम् |\n" + "श्रद्धाविरहितं यज्ञं तामसं परिचक्षते || 13||"," vidhi-hīnam—without scriptural direction; asṛiṣhṭa-annam—without distribution of prasādam; mantra-hīnam—with no chanting of the Vedic hymns; adakṣhiṇam—with no remunerations to the priests; śhraddhā—faith; virahitam—without; yajñam—sacrifice; tāmasam—in the mode of ignorance; parichakṣhate—is to be considered ","vidhi-hīnam asṛiṣhṭānnaṁ mantra-hīnam adakṣhiṇam\n" + "śhraddhā-virahitaṁ yajñaṁ tāmasaṁ parichakṣhate",R.color.trans));
        mData.add(new NewsItem("देवद्विजगुरुप्राज्ञपूजनं शौचमार्जवम् |\n" + "ब्रह्मचर्यमहिंसा च शारीरं तप उच्यते || 14||"," deva—the Supreme Lord; dwija—the Brahmins; guru—the spiritual master; prājña—the elders; pūjanam—worship; śhaucham—cleanliness; ārjavam—simplicity; brahmacharyam—celibacy; ahinsā—non-violence; cha—and; śhārīram—of the body; tapaḥ—austerity; uchyate—is declared as ","deva-dwija-guru-prājña- pūjanaṁ śhaucham ārjavam\n" + "brahmacharyam ahinsā cha śhārīraṁ tapa uchyate",R.color.trans));
        mData.add(new NewsItem("अनुद्वेगकरं वाक्यं सत्यं प्रियहितं च यत् |\n" + "स्वाध्यायाभ्यसनं चैव वाङ्मयं तप उच्यते || 15||"," anudvega-karam—not causing distress; vākyam—words; satyam—truthful; priya- hitam—beneficial; cha—and; yat—which; svādhyāya-abhyasanam—recitation of the Vedic scriptures; cha eva—as well as; vāṅ-mayam—of speech; tapaḥ—austerity; uchyate—are declared as ","anudvega-karaṁ vākyaṁ satyaṁ priya-hitaṁ cha yat\n" + "svādhyāyābhyasanaṁ chaiva vāṅ-mayaṁ tapa uchyate",R.color.trans));
        mData.add(new NewsItem("मन: प्रसाद: सौम्यत्वं मौनमात्मविनिग्रह: |\n" + "भावसंशुद्धिरित्येतत्तपो मानसमुच्यते || 16||"," manaḥ-prasādaḥ—serenity of thought; saumyatvam—gentleness; maunam—silence; ātma-vinigrahaḥ—self-control; bhāva-sanśhuddhiḥ—purity of purpose; iti—thus; etat—these; tapaḥ—austerity; mānasam—of the mind; uchyate—are declared as ","manaḥ-prasādaḥ saumyatvaṁ maunam ātma-vinigrahaḥ\n" + "bhāva-sanśhuddhir ity etat tapo mānasam uchyate",R.color.trans));
        mData.add(new NewsItem("श्रद्धया परया तप्तं तपस्तत्त्रिविधं नरै: |\n" + "अफलाकाङ्क्षिभिर्युक्तै: सात्विकं परिचक्षते || 17||"," śhraddhayā—with faith; parayā—transcendental; taptam—practiced; tapaḥ—austerity; tat—that; tri-vidham—three-fold; naraiḥ—by persons; aphala-ākāṅkṣhibhiḥ—without yearning for material rewards; yuktaiḥ—steadfast; sāttvikam—in the mode of goodness; parichakṣhate—are designated ","śhraddhayā parayā taptaṁ tapas tat tri-vidhaṁ naraiḥ\n" + "aphalākāṅkṣhibhir yuktaiḥ sāttvikaṁ parichakṣhate",R.color.trans));
        mData.add(new NewsItem("सत्कारमानपूजार्थं तपो दम्भेन चैव यत् |\n" + "क्रियते तदिह प्रोक्तं राजसं चलमध्रुवम् || 18||"," sat-kāra—respect; māna—honor; pūjā—adoration; artham—for the sake of; tapaḥ—austerity; dambhena—with ostentation; cha—also; eva—certainly; yat—which; kriyate—is performed; tat—that; iha—in this world; proktam—is said; rājasam—in the mode of passion; chalam—flickering; adhruvam—temporary ","satkāra-māna-pūjārthaṁ tapo dambhena chaiva yat\n" + "kriyate tad iha proktaṁ rājasaṁ chalam adhruvam",R.color.trans));
        mData.add(new NewsItem("मूढग्राहेणात्मनो यत्पीडया क्रियते तप: |\n" + "परस्योत्सादनार्थं वा तत्तामसमुदाहृतम् || 19||"," mūḍha—those with confused notions; grāheṇa—with endeavor; ātmanaḥ—one’s own self; yat—which; pīḍayā—torturing; kriyate—is performed; tapaḥ—austerity; parasya—of others; utsādana-artham—for harming; vā—or; tat—that; tāmasam—in the mode of ignorance; udāhṛitam—is described to be ","mūḍha-grāheṇātmano yat pīḍayā kriyate tapaḥ\n" + "parasyotsādanārthaṁ vā tat tāmasam udāhṛitam",R.color.trans));
        mData.add(new NewsItem("दातव्यमिति यद्दानं दीयतेऽनुपकारिणे |\n" + "देशे काले च पात्रे च तद्दानं सात्विकं स्मृतम् || 20||"," dātavyam—worthy of charity; iti—thus; yat—which; dānam—charity; dīyate—is given; anupakāriṇe—to one who cannot give in return; deśhe—in the proper place; kāle—at the proper time; cha—and; pātre—to a worthy person; cha—and; tat—that; dānam—charity; sāttvikam—in the mode of goodness; smṛitam—is stated to be ","dātavyam iti yad dānaṁ dīyate ‘nupakāriṇe\n" + "deśhe kāle cha pātre cha tad dānaṁ sāttvikaṁ smṛitam",R.color.trans));
        mData.add(new NewsItem("यत्तु प्रत्युपकारार्थं फलमुद्दिश्य वा पुन: |\n" + "दीयते च परिक्लिष्टं तद्दानं राजसं स्मृतम् || 21||"," yat—which; tu—but; prati-upakāra-artham—with the hope of a return; phalam—reward; uddiśhya—expectation; vā—or; punaḥ—again; dīyate—is given; cha—and; parikliṣhṭam—reluctantly; tat—that; dānam—charity; rājasam—in the mode of passion; smṛitam—is said to be ","yat tu pratyupakārārthaṁ phalam uddiśhya vā punaḥ\n" + "dīyate cha parikliṣhṭaṁ tad dānaṁ rājasaṁ smṛitam",R.color.trans));
        mData.add(new NewsItem("अदेशकाले यद्दानमपात्रेभ्यश्च दीयते |\n" + "असत्कृतमवज्ञातं तत्तामसमुदाहृतम् || 22||"," adeśha—at the wrong place; kāle—at the wrong time; yat—which; dānam—charity; apātrebhyaḥ—to unworthy persons; cha—and; dīyate—is given; asat-kṛitam—without respect; avajñātam—with contempt; tat—that; tāmasam—of the nature of nescience; udāhṛitam—is held to be ","adeśha-kāle yad dānam apātrebhyaśh cha dīyate\n" + "asat-kṛitam avajñātaṁ tat tāmasam udāhṛitam",R.color.trans));
        mData.add(new NewsItem("ॐ तत्सदिति निर्देशो ब्रह्मणस्त्रिविध: स्मृत: |\n" + "ब्राह्मणास्तेन वेदाश्च यज्ञाश्च विहिता: पुरा || 23||"," om tat sat—syllables representing aspects of transcendence; iti—thus; nirdeśhaḥ—symbolic representatives; brahmaṇaḥ—the Supreme Absolute Truth; tri-vidhaḥ—of three kinds; smṛitaḥ—have been declared; brāhmaṇāḥ—the priests; tena—from them; vedāḥ—scriptures; cha—and; yajñāḥ—sacrifice; cha—and; vihitāḥ—came about; purā—from the beginning of creation ","oṁ tat sad iti nirdeśho brahmaṇas tri-vidhaḥ smṛitaḥ\n" + "brāhmaṇās tena vedāśh cha yajñāśh cha vihitāḥ purā",R.color.trans));
        mData.add(new NewsItem("तस्माद् ॐ इत्युदाहृत्य यज्ञदानतप:क्रिया: |\n" + "प्रवर्तन्ते विधानोक्ता: सततं ब्रह्मवादिनाम् || 24||"," tasmāt—therefore; om—sacred syllable om; iti—thus; udāhṛitya—by uttering; yajña—sacrifice; dāna—charity; tapaḥ—penance; kriyāḥ—performing; pravartante—begin; vidhāna-uktāḥ—according to the prescriptions of Vedic injunctions; satatam—always; brahma-vādinām—expounders of the Vedas ","tasmād oṁ ity udāhṛitya yajña-dāna-tapaḥ-kriyāḥ\n" + "pravartante vidhānoktāḥ satataṁ brahma-vādinām",R.color.trans));
        mData.add(new NewsItem("तदित्यनभिसन्धाय फलं यज्ञतप:क्रिया: |\n" + "दानक्रियाश्च विविधा: क्रियन्ते मोक्षकाङ्क्षिभि: || 25||"," tat—the syllable Tat; iti—thus; anabhisandhāya—without desiring; phalam—fruitive rewards; yajña—sacrifice; tapaḥ—austerity; kriyāḥ—acts; dāna—charity; kriyāḥ—acts; cha—and; vividhāḥ—various; kriyante—are done; mokṣha-kāṅkṣhibhiḥ—by seekers of freedom from material entanglements ","tad ity anabhisandhāya phalaṁ yajña-tapaḥ-kriyāḥ\n" + "dāna-kriyāśh cha vividhāḥ kriyante mokṣha-kāṅkṣhibhiḥ",R.color.trans));
        mData.add(new NewsItem("सद्भावे साधुभावे च सदित्येतत्प्रयुज्यते |\n" + "प्रशस्ते कर्मणि तथा सच्छब्द: पार्थ युज्यते || 26||\n" + "यज्ञे तपसि दाने च स्थिति: सदिति चोच्यते |\n" + "कर्म चैव तदर्थीयं सदित्येवाभिधीयते || 27||"," sat-bhāve—with the intention of eternal existence and goodness; sādhu-bhāve—with auspicious intention; cha—also; sat—the syllable Sat; iti—thus; etat—this; prayujyate—is used; praśhaste—auspicious; karmaṇi—action; tathā—also; sat-śhabdaḥ—the word “Sat”; pārtha—Arjun, the son of Pritha; yujyate—is used; yajñe—in sacrifice; tapasi—in penance; dāne—in charity; cha—and; sthitiḥ—established in steadiness; sat—the syllable Sat; iti—thus; cha—and; uchyate—is pronounced; karma—action; cha—and; eva—indeed; tat-arthīyam—for such purposes; sat—the syllable Sat; iti—thus; eva—indeed; abhidhīyate—is described ","sad-bhāve sādhu-bhāve cha sad ity etat prayujyate\n" + "praśhaste karmaṇi tathā sach-chhabdaḥ pārtha yujyate\n" + "yajñe tapasi dāne cha sthitiḥ sad iti chochyate\n" + "karma chaiva tad-arthīyaṁ sad ity evābhidhīyate",R.color.trans));
        mData.add(new NewsItem("अश्रद्धया हुतं दत्तं तपस्तप्तं कृतं च यत् |\n" + "असदित्युच्यते पार्थ न च तत्प्रेत्य नो इह || 28||"," aśhraddhayā—without faith; hutam—sacrifice; dattam—charity; tapaḥ—penance; taptam—practiced; kṛitam—done; cha—and; yat—which; asat—perishable; iti—thus; uchyate—are termed as; pārtha—Arjun, the son of Pritha; na—not; cha—and; tat—that; pretya—in the next world; na u—not; iha—in this world ","aśhraddhayā hutaṁ dattaṁ tapas taptaṁ kṛitaṁ cha yat\n" + "asad ity uchyate pārtha na cha tat pretya no iha",R.color.trans));


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
                            Intent intent = new Intent(Vchp17.this, CloseActivity.class);
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

            Intent myIntent = new Intent(this, Chp17.class);
            this.startActivity(myIntent);

        }

        if (id == R.id.verses){

         //   Intent myIntent = new Intent(this, Main2Activity.class);
         //   this.startActivity(myIntent);

        }

        if (id == R.id.explain){

            //   Intent myIntent = new Intent(this, Explaination.class);
            //   this.startActivity(myIntent);

            new FancyGifDialog.Builder(Vchp17.this)
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