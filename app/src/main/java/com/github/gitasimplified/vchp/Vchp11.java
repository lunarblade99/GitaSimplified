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
import com.github.gitasimplified.chp.Chp11;
import com.shashank.sony.fancygifdialoglib.FancyGifDialog;
import com.shashank.sony.fancygifdialoglib.FancyGifDialogListener;

import java.util.ArrayList;
import java.util.List;

public class Vchp11 extends AppCompatActivity
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
        navigationView.getMenu().getItem(10).setChecked(true);

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
        mData.add(new NewsItem("अर्जुन उवाच |\n" + "मदनुग्रहाय परमं गुह्यमध्यात्मसञ्ज्ञितम् |\n" + "यत्वयोक्तं वचस्तेन मोहोऽयं विगतो मम || 1||"," arjunaḥ uvācha—Arjun said; mat-anugrahāya—out of compassion to me; paramam—supreme; guhyam—confidential; adhyātma-sanjñitam—about spiritual knowledge; yat—which; tvayā—by you; uktam—spoken; vachaḥ—words; tena—by that; mohaḥ—illusion; ayam—this; vigataḥ—is dispelled; mama—my ","arjuna uvācha\n" + "mad-anugrahāya paramaṁ guhyam adhyātma-sanjñitam\n" + "yat tvayoktaṁ vachas tena moho ’yaṁ vigato mama",R.color.trans));
        mData.add(new NewsItem("भवाप्ययौ हि भूतानां श्रुतौ विस्तरशो मया |\n" + "त्वत्त: कमलपत्राक्ष माहात्म्यमपि चाव्ययम् || 2||"," bhava—appearance; apyayau—disappearance; hi—indeed; bhūtānām—of all living beings; śhrutau—have heard; vistaraśhaḥ—in detail; mayā—by me; tvattaḥ—from you; kamala-patra-akṣha—lotus-eyed one; māhātmyam—greatness; api—also; cha—and; avyayam—eternal ","bhavāpyayau hi bhūtānāṁ śhrutau vistaraśho mayā\n" + "tvattaḥ kamala-patrākṣha māhātmyam api chāvyayam",R.color.trans));
        mData.add(new NewsItem("एवमेतद्यथात्थ त्वमात्मानं परमेश्वर |\n" + "द्रष्टुमिच्छामि ते रूपमैश्वरं पुरुषोत्तम || 3||"," evam—thus; etat—this; yathā—as; āttha—have spoken; tvam—you; ātmānam—yourself; parama-īśhvara—Supreme Lord; draṣhṭum—to see; ichchhāmi—I desire; te—your; rūpam—form; aiśhwaram—divine; puruṣha-uttama—Shree Krishna, the Supreme Divine Personality ","evam etad yathāttha tvam ātmānaṁ parameśhvara\n" + "draṣhṭum ichchhāmi te rūpam aiśhwaraṁ puruṣhottama",R.color.trans));
        mData.add(new NewsItem("मन्यसे यदि तच्छक्यं मया द्रष्टुमिति प्रभो |\n" + "योगेश्वर ततो मे त्वं दर्शयात्मानमव्ययम् || 4||"," manyase—you think; yadi—if; tat—that; śhakyam—possible; mayā—by me; draṣhṭum—to behold; iti—thus; prabho—Lord; yoga-īśhvara—Lord of all mystic powers; tataḥ—then; me—to me; tvam—you; darśhaya—reveal; ātmānam—yourself; avyayam—imperishable ","manyase yadi tach chhakyaṁ mayā draṣhṭum iti prabho\n" + "yogeśhvara tato me tvaṁ darśhayātmānam avyayam",R.color.trans));
        mData.add(new NewsItem("श्रीभगवानुवाच |\n" + "पश्य मे पार्थ रूपाणि शतशोऽथ सहस्रश: |\n" +"नानाविधानि दिव्यानि नानावर्णाकृतीनि च || 5||"," śhrī-bhagavān uvācha—the Supreme Lord said; paśhya—behold; me—my; pārtha—Arjun, the son of Pritha; rūpāṇi—forms; śhataśhaḥ—by the hundreds; atha—and; sahasraśhaḥ—thousands; nānā-vidhāni—various; divyāni—divine; nānā—various; varṇa—colors; ākṛitīni—shapes; cha—and ","śhrī-bhagavān uvācha\n" + "paśhya me pārtha rūpāṇi śhataśho ’tha sahasraśhaḥ\n" + "nānā-vidhāni divyāni nānā-varṇākṛitīni cha",R.color.trans));
        mData.add(new NewsItem("पश्यादित्यान्वसून् रुद्रानश्विनौ मरुतस्तथा |\n" + "बहून्यदृष्टपूर्वाणि पश्याश्चर्याणि भारत || 6||"," paśhya—behold; ādityān—the (twelve) sons of Aditi; vasūn—the (eight) Vasus; rudrān—the (eleven) Rudras; aśhvinau—the (twin) Ashvini Kumars; marutaḥ—the (forty-nine) Maruts; tathā—and; bahūni—many; adṛiṣhṭa—never revealed; pūrvāṇi—before; paśhya—behold; āśhcharyāṇi—marvels; bhārata—Arjun, scion of the Bharatas ","paśhyādityān vasūn rudrān aśhvinau marutas tathā\n" + "bahūny adṛiṣhṭa-pūrvāṇi paśhyāśhcharyāṇi bhārata",R.color.trans));
        mData.add(new NewsItem("इहैकस्थं जगत्कृत्स्नं पश्याद्य सचराचरम् |\n" + "मम देहे गुडाकेश यच्चान्यद्द्रष्टुमिच्छसि || 7||"," iha—here; eka-stham—assembled together; jagat—the universe; kṛitsnam—entire; paśhya—behold; adya—now; sa—with; chara—the moving; acharam—the non- moving; mama—my; dehe—in this form; guḍākeśha—Arjun, the conqueror of sleep; yat—whatever; cha—also; anyat—else; draṣhṭum—to see; ichchhasi—you wish ","ihaika-sthaṁ jagat kṛitsnaṁ paśhyādya sa-charācharam\n" + "mama dehe guḍākeśha yach chānyad draṣhṭum ichchhasi",R.color.trans));
        mData.add(new NewsItem("न तु मां शक्यसे द्रष्टुमनेनैव स्वचक्षुषा |\n" + "दिव्यं ददामि ते चक्षु: पश्य मे योगमैश्वरम् || 8||"," na—not; tu—but; mām—me; śhakyase—you can; draṣhṭum—to see; anena—with these; eva—even; sva-chakṣhuṣhā—with your physical eyes; divyam—divine; dadāmi—I give; te—to you; chakṣhuḥ—eyes; paśhya—behold; me—my; yogam aiśhwaram—majestic opulence ","na tu māṁ śhakyase draṣhṭum anenaiva sva-chakṣhuṣhā\n" + "divyaṁ dadāmi te chakṣhuḥ paśhya me yogam aiśhwaram",R.color.trans));
        mData.add(new NewsItem("सञ्जय उवाच |\n" + "एवमुक्त्वा ततो राजन्महायोगेश्वरो हरि: |\n" + "दर्शयामास पार्थाय परमं रूपमैश्वरम् || 9||"," sañjayaḥ uvācha—Sanjay said; evam—thus; uktvā—having spoken; tataḥ—then; rājan—King; mahā-yoga-īśhvaraḥ—the Supreme Lord of Yog; hariḥ—Shree Krishna; darśhayām āsa—displayed; pārthāya—to Arjun; paramam—divine; rūpam aiśhwaram—opulence ","sañjaya uvācha\n" + "evam uktvā tato rājan mahā-yogeśhvaro hariḥ\n" + "darśhayām āsa pārthāya paramaṁ rūpam aiśhwaram",R.color.trans));
        mData.add(new NewsItem("अनेकवक्त्रनयनमनेकाद्भुतदर्शनम् |\n" + "अनेकदिव्याभरणं दिव्यानेकोद्यतायुधम् || 10||\n" + "दिव्यमाल्याम्बरधरं दिव्यगन्धानुलेपनम् |\n" + "सर्वाश्चर्यमयं देवमनन्तं विश्वतोमुखम् || 11||"," aneka—many; vaktra—faces; nayanam—eyes; aneka—many; adbhuta—wonderful; darśhanam—had a vision of; aneka—many; divya—divine; ābharaṇam—ornaments; divya—divine; aneka—many; udyata—uplifted; āyudham—weapons; divya—divine; mālya—garlands; āmbara—garments; dharam—wearing; divya—divine; gandha—fragrances; anulepanam—anointed with; sarva—all; āśhcharya-mayam—wonderful; devam—Lord; anantam—unlimited; viśhwataḥ—all sides; mukham—face ","aneka-vaktra-nayanam anekādbhuta-darśhanam\n" + "aneka-divyābharaṇaṁ divyānekodyatāyudham\n" + "divya-mālyāmbara-dharaṁ divya-gandhānulepanam\n" + "sarvāśhcharya-mayaṁ devam anantaṁ viśhvato-mukham",R.color.trans));
        mData.add(new NewsItem("दिवि सूर्यसहस्रस्य भवेद्युगपदुत्थिता |\n" + "यदि भा: सदृशी सा स्याद्भासस्तस्य महात्मन: || 12||"," divi—in the sky; sūrya—suns; sahasrasya—thousand; bhavet—were; yugapat—simultaneously; utthitā—rising; yadi—if; bhāḥ—splendor; sadṛiśhī—like; sā—that; syāt—would be; bhāsaḥ—splendor; tasya—of them; mahā-ātmanaḥ—the great personality ","divi sūrya-sahasrasya bhaved yugapad utthitā\n" + "yadi bhāḥ sadṛiśhī sā syād bhāsas tasya mahātmanaḥ",R.color.trans));
        mData.add(new NewsItem("तत्रैकस्थं जगत्कृत्स्नं प्रविभक्तमनेकधा |\n" + "अपश्यद्देवदेवस्य शरीरे पाण्डवस्तदा || 13||"," tatra—there; eka-stham—established in one place; jagat—the universe; kṛitsnam—entire; pravibhaktam—divided; anekadhā—many; apaśhyat—could see; deva-devasya—of the God of gods; śharīre—in the body; pāṇḍavaḥ—Arjun; tadā—at that time ","tatraika-sthaṁ jagat kṛitsnaṁ pravibhaktam anekadhā\n" + "apaśhyad deva-devasya śharīre pāṇḍavas tadā",R.color.trans));
        mData.add(new NewsItem("तत: स विस्मयाविष्टो हृष्टरोमा धनञ्जय: |\n" + "प्रणम्य शिरसा देवं कृताञ्जलिरभाषत || 14||"," tataḥ—then; saḥ—he; vismaya-āviṣhṭaḥ—full of wonder; hṛiṣhṭa-romā—with hair standing on end; dhanañjayaḥ—Arjun, the conqueror of wealth; praṇamya—bow down; śhirasā—with (his) head; devam—the Lord; kṛita-añjaliḥ—with folded hands; abhāṣhata—he addressed ","tataḥ sa vismayāviṣhṭo hṛiṣhṭa-romā dhanañjayaḥ\n" + "praṇamya śhirasā devaṁ kṛitāñjalir abhāṣhata",R.color.trans));
        mData.add(new NewsItem("अर्जुन उवाच |\n" + "पश्यामि देवांस्तव देव देहे\n" + "सर्वांस्तथा भूतविशेषसङ्घान् |\n" + "ब्रह्माणमीशं कमलासनस्थ-\n" + "मृषींश्च सर्वानुरगांश्च दिव्यान् || 15||"," arjunaḥ uvācha—Arjun said; paśhyāmi—I behold; devān—all the gods; tava—your; deva—Lord; dehe—within the body; sarvān—all; tathā—as well as; bhūta viśheṣha-saṅghān—hosts of different beings; brahmāṇam—Lord Brahma; īśham—Shiv; kamala-āsana-stham—seated on the lotus flower; ṛiṣhīn—sages; cha—and; sarvān—all; uragān—serpents; cha—and; divyān—divine ","arjuna uvācha\n" + "paśhyāmi devāns tava deva dehe\n" + "sarvāns tathā bhūta-viśheṣha-saṅghān\n" + "brahmāṇam īśhaṁ kamalāsana-stham\n" + "ṛiṣhīnśh cha sarvān uragānśh cha divyān",R.color.trans));
        mData.add(new NewsItem("अनेकबाहूदरवक्त्रनेत्रं\n" + "पश्यामि त्वां सर्वतोऽनन्तरूपम् |\n" + "नान्तं न मध्यं न पुनस्तवादिं\n" + "पश्यामि विश्वेश्वर विश्वरूप || 16||"," aneka—infinite; bāhu—arms; udara—stomachs; vaktra—faces; netram—eyes; paśhyāmi—I see; tvām—you; sarvataḥ—in every direction; ananta-rūpam—inifinite forms; na antam—without end; na—not; madhyam—middle; na—no; punaḥ—again; tava—your; ādim—beginning; paśhyāmi—I see; viśhwa-īśhwara—The Lord of the universe; viśhwa-rūpa—universal form ","aneka-bāhūdara-vaktra-netraṁ\n" + "paśhyāmi tvāṁ sarvato ’nanta-rūpam\n" + "nāntaṁ na madhyaṁ na punas tavādiṁ\n" + "paśhyāmi viśhveśhvara viśhva-rūpa",R.color.trans));
        mData.add(new NewsItem("किरीटिनं गदिनं चक्रिणं च\n" + "तेजोराशिं सर्वतो दीप्तिमन्तम् |\n" + "पश्यामि त्वां दुर्निरीक्ष्यं समन्ताद्\n" + "दीप्तानलार्कद्युतिमप्रमेयम् || 17||"," kirīṭinam—adorned with a crown; gadinam—with club; chakriṇam—with discs; cha—and; tejaḥ-rāśhim—abode of splendor; sarvataḥ—everywhere; dīpti-mantam—shining; paśhyāmi—I see; tvām—you; durnirīkṣhyam—difficult to look upon; samantāt—in all directions; dīpta-anala—blazing fire; arka—like the sun; dyutim—effulgence; aprameyam—immeasurable ","kirīṭinaṁ gadinaṁ chakriṇaṁ cha\n" + "tejo-rāśhiṁ sarvato dīptimantam\n" + "paśhyāmi tvāṁ durnirīkṣhyaṁ samantād\n" + "dīptānalārka-dyutim aprameyam",R.color.trans));
        mData.add(new NewsItem("त्वमक्षरं परमं वेदितव्यं\n" + "त्वमस्य विश्वस्य परं निधानम् |\n" + "त्वमव्यय: शाश्वतधर्मगोप्ता\n" + "सनातनस्त्वं पुरुषो मतो मे || 18||"," tvam—you; akṣharam—the imperishable; paramam—the supreme being; veditavyam—worthy of being known; tvam—you; asya—of this; viśhwasya—of the creation; param—supreme; nidhānam—support; tvam—you; avyayaḥ—eternal; śhāśhvata-dharma-goptā—protector of the eternal religion; sanātanaḥ—everlasting; tvam—you; puruṣhaḥ—the Supreme Divine Person; mataḥ me—my opinion ","tvam akṣharaṁ paramaṁ veditavyaṁ\n" + "tvam asya viśhvasya paraṁ nidhānam\n" + "tvam avyayaḥ śhāśhvata-dharma-goptā\n" + "sanātanas tvaṁ puruṣho mato me",R.color.trans));
        mData.add(new NewsItem("\n" + "\n" + "अनादिमध्यान्तमनन्तवीर्य-\n" + "मनन्तबाहुं शशिसूर्यनेत्रम् |\n" + "पश्यामि त्वां दीप्तहुताशवक्त्रं-\n" + "स्वतेजसा विश्वमिदं तपन्तम् || 19||\n"," anādi-madhya-antam—without beginning, middle, or end; ananta—infinite; vīryam—power; ananta—unlimited; bāhum—arms; śhaśhi—the moon; sūrya—the sun; netram—eyes; paśhyāmi—I see; tvām—you; dīpta—blazing; hutāśha—emanating from; vaktram—your mouth; sva-tejasā—by your radiance; viśhwam—universe; idam—this; tapantam—warming ","anādi-madhyāntam ananta-vīryam\n" + "ananta-bāhuṁ śhaśhi-sūrya-netram\n" + "paśhyāmi tvāṁ dīpta-hutāśha-vaktraṁ\n" + "sva-tejasā viśhvam idaṁ tapantam",R.color.trans));
        mData.add(new NewsItem("द्यावापृथिव्योरिदमन्तरं हि\n" + "व्याप्तं त्वयैकेन दिशश्च सर्वा: |\n" + "दृष्ट्वाद्भुतं रूपमुग्रं तवेदं\n" + "लोकत्रयं प्रव्यथितं महात्मन् || 20||"," dyau-ā-pṛithivyoḥ—between heaven and earth; idam—this; antaram—space between; hi—indeed; vyāptam—pervaded; tvayā—by you; ekena—alone; diśhaḥ—directions; cha—and; sarvāḥ—all; dṛiṣhṭvā—seeing; adbhutam—wondrous; rūpam—form; ugram—terrible; tava—your; idam—this; loka—worlds; trayam—three; pravyathitam—trembling; mahā-ātman—The greatest of all beings ","dyāv ā-pṛithivyor idam antaraṁ hi\n" + "vyāptaṁ tvayaikena diśhaśh cha sarvāḥ\n" + "dṛiṣhṭvādbhutaṁ rūpam ugraṁ tavedaṁ\n" + "loka-trayaṁ pravyathitaṁ mahātman",R.color.trans));
        mData.add(new NewsItem("अमी हि त्वां सुरसङ्घा विशन्ति\n" + "केचिद्भीता: प्राञ्जलयो गृणन्ति |\n" + "स्वस्तीत्युक्त्वा महर्षिसिद्धसङ्घा:\n" + "स्तुवन्ति त्वां स्तुतिभि: पुष्कलाभि: || 21||"," amī—these; hi—indeed; tvām—you; sura-saṅghāḥ—assembly of celestial gods; viśhanti—are entering; kechit—some; bhītāḥ—in fear; prāñjalayaḥ—with folded hands; gṛiṇanti—praise; svasti—auspicious; iti—thus; uktvā—reciting; mahā-ṛiṣhi—great sages; siddha-saṅghāḥ—perfect beings; stuvanti—are extolling; tvām—you; stutibhiḥ—with prayers; puṣhkalābhiḥ—hymns ","amī hi tvāṁ sura-saṅghā viśhanti\n" + "kechid bhītāḥ prāñjalayo gṛiṇanti\n" + "svastīty uktvā maharṣhi-siddha-saṅghāḥ\n" + "stuvanti tvāṁ stutibhiḥ puṣhkalābhiḥ",R.color.trans));
        mData.add(new NewsItem("रुद्रादित्या वसवो ये च साध्या\n" + "विश्वेऽश्विनौ मरुतश्चोष्मपाश्च |\n" + "गन्धर्वयक्षासुरसिद्धसङ्घा\n" + "वीक्षन्ते त्वां विस्मिताश्चैव सर्वे || 22||"," rudra—a form of Lord Shiv; ādityāḥ—the Adityas; vasavaḥ—the Vasus; ye—these; cha—and; sādhyāḥ—the Sadhyas; viśhve—the Vishvadevas; aśhvinau—the Ashvini kumars; marutaḥ—the Maruts; cha—and; uṣhma-pāḥ—the ancestors; cha—and; gandharva—Gandharvas; yakṣha—the Yakshas; asura—the demons; siddha—the perfected beings; saṅghāḥ—the assemblies; vīkṣhante—are beholding; tvām—you; vismitāḥ—in wonder; cha—and; eva—verily; sarve—all ","rudrādityā vasavo ye cha sādhyā\n" + "viśhve ’śhvinau marutaśh choṣhmapāśh cha\n" + "gandharva-yakṣhāsura-siddha-saṅghā\n" + "vīkṣhante tvāṁ vismitāśh chaiva sarve",R.color.trans));
        mData.add(new NewsItem("रूपं महत्ते बहुवक्त्रनेत्रं\n" + "महाबाहो बहुबाहूरुपादम् |\n" + "बहूदरं बहुदंष्ट्राकरालं\n" + "दृष्ट्वा लोका: प्रव्यथितास्तथाहम् || 23||"," rūpam—form; mahat—magnificent; te—your; bahu—many; vaktra—mouths; netram—eyes; mahā-bāho—mighty-armed Lord; bahu—many; bāhu—arms; ūru—thighs; pādam—legs; bahu-udaram—many stomachs; bahu-danṣhṭrā—many teeth; karālam—terrifying; dṛiṣhṭvā—seeing; lokāḥ—all the worlds; pravyathitāḥ—terror-stricken; tathā—so also; aham—I ","rūpaṁ mahat te bahu-vaktra-netraṁ\n" + "mahā-bāho bahu-bāhūru-pādam\n" + "bahūdaraṁ bahu-danṣhṭrā-karālaṁ\n" + "dṛiṣhṭvā lokāḥ pravyathitās tathāham",R.color.trans));
        mData.add(new NewsItem("नभ:स्पृशं दीप्तमनेकवर्णं\n" + "व्यात्ताननं दीप्तविशालनेत्रम् |\n" + "दृष्ट्वा हि त्वां प्रव्यथितान्तरात्मा\n" + "धृतिं न विन्दामि शमं च विष्णो || 24||"," nabhaḥ-spṛiśham—touching the sky; dīptam—effulgent; aneka—many; varṇam—colors; vyātta—open; ānanam—mouths; dīpta—blazing; viśhāla—enormous; netram—eyes; dṛiṣhṭvā—seeing; hi—indeed; tvām—you; pravyathitāntar-ātmā—my heart is trembling with fear; dhṛitim—firmness; na—not; vindāmi—I find; śhamam—mental peace; cha—and; viṣhṇo—Lord Vishnu ","nabhaḥ-spṛiśhaṁ dīptam aneka-varṇaṁ\n" + "vyāttānanaṁ dīpta-viśhāla-netram\n" + "dṛiṣhṭvā hi tvāṁ pravyathitāntar-ātmā\n" + "dhṛitiṁ na vindāmi śhamaṁ cha viṣhṇo",R.color.trans));
        mData.add(new NewsItem("दंष्ट्राकरालानि च ते मुखानि\n" + "दृष्ट्वैव कालानलसन्निभानि |\n" + "दिशो न जाने न लभे च शर्म\n" + "प्रसीद देवेश जगन्निवास || 25||"," danṣhṭrā—teeth; karālāni—terrible; cha—and; te—your; mukhāni—mouths; dṛiṣhṭvā—having seen; eva—indeed; kāla-anala—the fire of annihilation; sannibhāni—resembling; diśhaḥ—the directions; na—not; jāne—know; na—not; labhe—I obtain; cha—and; śharma—peace; prasīda—have mercy; deva-īśha—The Lord of lords; jagat-nivāsa—The shelter of the universe ","danṣhṭrā-karālāni cha te mukhāni\n" + "dṛiṣhṭvaiva kālānala-sannibhāni\n" + "diśho na jāne na labhe cha śharma\n" + "prasīda deveśha jagan-nivāsa",R.color.trans));
        mData.add(new NewsItem("अमी च त्वां धृतराष्ट्रस्य पुत्रा:\n" + "सर्वे सहैवावनिपालसङ्घै: |\n" + "भीष्मो द्रोण: सूतपुत्रस्तथासौ\n" + "सहास्मदीयैरपि योधमुख्यै: || 26||\n" + "वक्त्राणि ते त्वरमाणा विशन्ति\n" + "दंष्ट्राकरालानि भयानकानि |\n" + "केचिद्विलग्ना दशनान्तरेषु\n" + "सन्दृश्यन्ते चूर्णितैरुत्तमाङ्गै: || 27||"," amī—these; cha—and; tvām—you; dhṛitarāśhtrasya—of Dhritarashtra; putrāḥ—sons; sarve—all; saha—with; eva—even; avani-pāla—their allied kings; sanghaiḥ—assembly; bhīṣhmaḥ—Bheeshma; droṇaḥ—Dronacharya; sūta-putraḥ—Karna; tathā—and also; asau—this; saha—with; asmadīyaiḥ—from our side; api—also; yodha-mukhyaiḥ—generals; vaktrāṇi—mouths; te—your; tvaramāṇāḥ—rushing; viśhanti—enter; danṣhṭrā—teeth; karālāni—terrible; bhayānakāni—fearsome; kechit—some; vilagnāḥ—getting stuck; daśhana-antareṣhu—between the teeth; sandṛiśhyante—are seen; chūrṇitaiḥ—getting smashed; uttama-aṅgaiḥ—heads ","amī cha tvāṁ dhṛitarāśhtrasya putrāḥ\n" + "sarve sahaivāvani-pāla-saṅghaiḥ\n" + "bhīṣhmo droṇaḥ sūta-putras tathāsau\n" + "sahāsmadīyair api yodha-mukhyaiḥ\n" + "vaktrāṇi te tvaramāṇā viśhanti\n" + "danṣhṭrā-karālāni bhayānakāni\n" + "kechid vilagnā daśhanāntareṣhu\n" + "sandṛiśhyante chūrṇitair uttamāṅgaiḥ",R.color.trans));
        mData.add(new NewsItem("यथा नदीनां बहवोऽम्बुवेगा:\n" + "समुद्रमेवाभिमुखा द्रवन्ति |\n" + "तथा तवामी नरलोकवीरा\n" + "विशन्ति वक्त्राण्यभिविज्वलन्ति || 28||\n" + "यथा प्रदीप्तं ज्वलनं पतङ्गा\n" + "विशन्ति नाशाय समृद्धवेगा: |\n" + "तथैव नाशाय विशन्ति लोका-\n" + "स्तवापि वक्त्राणि समृद्धवेगा: || 29||"," yathā—as; nadīnām—of the rivers; bahavaḥ—many; ambu-vegāḥ—water waves; samudram—the ocean; eva—indeed; abhimukhāḥ—toward; dravanti—flowing rapidly; tathā—similarly; tava—your; amī—these; nara-loka-vīrāḥ—kings of human society; viśhanti—enter; vaktrāṇi—mouths; abhivijvalanti—blazing; yathā—as; pradīptam—blazing; jvalanam—fire; pataṅgāḥ—moths; viśhanti—enter; nāśhāya—to be perished; samṛiddha vegāḥ—with great speed; tathā eva—similarly; nāśhāya—to be perished; viśhanti—enter; lokāḥ—these people; tava—your; api—also; vaktrāṇi—mouths; samṛiddha-vegāḥ—with great speed ","yathā nadīnāṁ bahavo ’mbu-vegāḥ\n" + "samudram evābhimukhā dravanti\n" + "tathā tavāmī nara-loka-vīrā\n" + "viśhanti vaktrāṇy abhivijvalanti\n" + "yathā pradīptaṁ jvalanaṁ pataṅgā\n" + "viśhanti nāśhāya samṛiddha-vegāḥ\n" + "tathaiva nāśhāya viśhanti lokās\n" + "tavāpi vaktrāṇi samṛiddha-vegāḥ",R.color.trans));
        mData.add(new NewsItem("लेलिह्यसे ग्रसमान: समन्ता-\n" + "ल्लोकान्समग्रान्वदनैर्ज्वलद्भि: |\n" + "तेजोभिरापूर्य जगत्समग्रं\n" + "भासस्तवोग्रा: प्रतपन्ति विष्णो || 30||"," lelihyase—you are licking; grasamānaḥ—devouring; samantāt—on all sides; lokān—worlds; samagrān—all; vadanaiḥ—with mouths; jvaladbhiḥ—blazing; tejobhiḥ—by effulgence; āpūrya—filled with; jagat—the universe; samagram—all; bhāsaḥ—rays; tava—your; ugrāḥ—fierce; pratapanti—scorching; viṣhṇo—Lord Vishnu ","lelihyase grasamānaḥ samantāl\n" + "lokān samagrān vadanair jvaladbhiḥ\n" + "tejobhir āpūrya jagat samagraṁ\n" + "bhāsas tavogrāḥ pratapanti viṣhṇo",R.color.trans));
        mData.add(new NewsItem("आख्याहि मे को भवानुग्ररूपो\n" + "नमोऽस्तु ते देववर प्रसीद |\n" + "विज्ञातुमिच्छामि भवन्तमाद्यं\n" + "न हि प्रजानामि तव प्रवृत्तिम् || 31||"," ākhyāhi—tell; me—me; kaḥ—who; bhavān—you; ugra-rūpaḥ—fierce form; namaḥ astu—I bow; te—to you; deva-vara—God of gods; prasīda—be merciful; vijñātum—to know; ichchhāmi—I wish; bhavantam—you; ādyam—the primeval; na—not; hi—because; prajānāmi—comprehend; tava—your; pravṛittim—workings ","ākhyāhi me ko bhavān ugra-rūpo\n" + "namo ’stu te deva-vara prasīda\n" + "vijñātum ichchhāmi bhavantam ādyaṁ\n" + "na hi prajānāmi tava pravṛittim",R.color.trans));
        mData.add(new NewsItem("श्रीभगवानुवाच |\n" + "कालोऽस्मि लोकक्षयकृत्प्रवृद्धो\n" + "लोकान्समाहर्तुमिह प्रवृत्त: |\n" + "ऋतेऽपि त्वां न भविष्यन्ति सर्वे\n" + "येऽवस्थिता: प्रत्यनीकेषु योधा: || 32||"," śhrī-bhagavān uvācha—the Supreme Lord said; kālaḥ—time; asmi—I am; loka-kṣhaya-kṛit—the source of destruction of the worlds; pravṛiddhaḥ—mighty; lokān—the worlds; samāhartum—annihilation; iha—this world; pravṛittaḥ—participation; ṛite—without; api—even; tvām—you; na bhaviṣhyanti—shall cease to exist; sarve—all; ye—who; avasthitāḥ—arrayed; prati-anīkeṣhu—in the opposing army; yodhāḥ—the warriors ","śhrī-bhagavān uvācha\n" + "kālo ’smi loka-kṣhaya-kṛit pravṛiddho\n" + "lokān samāhartum iha pravṛittaḥ\n" + "ṛite ’pi tvāṁ na bhaviṣhyanti sarve\n" + "ye ’vasthitāḥ pratyanīkeṣhu yodhāḥ",R.color.trans));
        mData.add(new NewsItem("तस्मात्वमुत्तिष्ठ यशो लभस्व\n" + "जित्वा शत्रून्भुङ् क्ष्व राज्यं समृद्धम् |\n" + "मयैवैते निहता: पूर्वमेव\n" + "निमित्तमात्रं भव सव्यसाचिन् || 33||"," tasmāt—therefore; tvam—you; uttiṣhṭha—arise; yaśhaḥ—honor; labhasva—attain; jitvā—conquer; śhatrūn—foes; bhuṅkṣhva—enjoy; rājyam—kingdom; samṛiddham—prosperous; mayā—by me; eva—indeed; ete—these; nihatāḥ—slain; pūrvam—already; eva nimitta-mātram—only an instrument; bhava—become; savya-sāchin—Arjun, the one who can shoot arrows with both hands ","tasmāt tvam uttiṣhṭha yaśho labhasva\n" + "jitvā śhatrūn bhuṅkṣhva rājyaṁ samṛiddham\n" + "mayaivaite nihatāḥ pūrvam eva\n" + "nimitta-mātraṁ bhava savya-sāchin",R.color.trans));
        mData.add(new NewsItem("द्रोणं च भीष्मं च जयद्रथं च\n" + "कर्णं तथान्यानपि योधवीरान् |\n" + "मया हतांस्त्वं जहि मा व्यथिष्ठा\n" + "युध्यस्व जेतासि रणे सपत्नान् || 34||"," droṇam—Dronacharya; cha—and; bhīṣhmam—Bheeshma; cha—and; jayadratham—Jayadratha; cha—and; karṇam—Karn; tathā—also; anyān—others; api—also; yodha-vīrān—brave warriors; mayā—by me; hatān—already killed; tvam—you; jahi—slay; mā—not; vyathiṣhṭhāḥ—be disturbed; yudhyasva—fight; jetā asi—you shall be victorious; raṇe—in battle; sapatnān—enemies ","droṇaṁ cha bhīṣhmaṁ cha jayadrathaṁ cha\n" + "karṇaṁ tathānyān api yodha-vīrān\n" + "mayā hatāṁs tvaṁ jahi mā vyathiṣhṭhā\n" + "yudhyasva jetāsi raṇe sapatnān",R.color.trans));
        mData.add(new NewsItem("सञ्जय उवाच |\n" + "एतच्छ्रुत्वा वचनं केशवस्य\n" + "कृताञ्जलिर्वेपमान: किरीटी |\n" + "नमस्कृत्वा भूय एवाह कृष्णं\n" + "सगद्गदं भीतभीत: प्रणम्य || 35||"," sañjayaḥ uvācha—Sanjay said; etat—thus; śhrutvā—hearing; vachanam—words; keśhavasya—of Shree Krishna; kṛita-añjaliḥ—with joined palms; vepamānaḥ—trembling; kirītī—the crowned one, Arjun; namaskṛitvā—with palms joined; bhūyaḥ—again; eva—indeed; āha—spoke; kṛiṣhṇam—to Shree Krishna; sa-gadgadam—in a faltering voice; bhīta-bhītaḥ—overwhelmed with fear; praṇamya—bowed down ","sañjaya uvācha\n" + "etach chhrutvā vachanaṁ keśhavasya\n" + "kṛitāñjalir vepamānaḥ kirīṭī\n" + "namaskṛitvā bhūya evāha kṛiṣhṇaṁ\n" + "sa-gadgadaṁ bhīta-bhītaḥ praṇamya",R.color.trans));
        mData.add(new NewsItem("अर्जुन उवाच |\n" + "स्थाने हृषीकेश तव प्रकीर्त्या\n" + "जगत्प्रहृष्यत्यनुरज्यते च |\n" + "रक्षांसि भीतानि दिशो द्रवन्ति\n" + "सर्वे नमस्यन्ति च सिद्धसङ्घा: || 36||"," arjunaḥ uvācha—Arjun said; sthāne—it is but apt; hṛiṣhīka-īśha—Shree Krishna, the master of the senses; tava—your; prakīrtyā—in praise; jagat—the universe; prahṛiṣhyati—rejoices; anurajyate—be enamored; cha—and; rakṣhānsi—the demons; bhītāni—fearfully; diśhaḥ—in all directions; dravanti—flee; sarve—all; namasyanti—bow down; cha—and; siddha-saṅghāḥ—hosts of perfected saints ","arjuna uvācha\n" + "sthāne hṛiṣhīkeśha tava prakīrtyā\n" + "jagat prahṛiṣhyaty anurajyate cha\n" + "rakṣhānsi bhītāni diśho dravanti\n" + "sarve namasyanti cha siddha-saṅghāḥ",R.color.trans));
        mData.add(new NewsItem("कस्माच्च ते न नमेरन्महात्मन्\n" + "गरीयसे ब्रह्मणोऽप्यादिकर्त्रे |\n" + "अनन्त देवेश जगन्निवास\n" + "त्वमक्षरं सदसतत्परं यत् || 37||"," kasmāt—why; cha—and; te—you; na nameran—should they not bow down; mahā-ātman—The Great one; garīyase—who are greater; brahmaṇaḥ—than Brahma; api—even; ādi-kartre—to the original creator; ananta—The limitless One; deva-īśha—Lord of the devatās; jagat-nivāsa—Refuge of the universe; tvam—you; akṣharam—the imperishable; sat-asat—manifest and non-manifest; tat—that; param—beyond; yat—which ","kasmāch cha te na nameran mahātman\n" + "garīyase brahmaṇo ’py ādi-kartre\n" + "ananta deveśha jagan-nivāsa\n" + "tvam akṣharaṁ sad-asat tat paraṁ yat",R.color.trans));
        mData.add(new NewsItem("त्वमादिदेव: पुरुष: पुराण-\n" + "स्त्वमस्य विश्वस्य परं निधानम् |\n" + "वेत्तासि वेद्यं च परं च धाम\n" + "त्वया ततं विश्वमनन्तरूप || 38||"," tvam—you; ādi-devaḥ—the original Divine God; puruṣhaḥ—personality; purāṇaḥ—primeval; tvam—you; asya—of (this); viśhwasya—universe; param—Supreme; nidhānam—resting place; vettā—the knower; asi—you are; vedyam—the object of knowledge; cha—and; param—Supreme; cha—and; dhāma—Abode; tvayā—by you; tatam—pervaded; viśhwam—the universe; ananta-rūpa—posessor of infinite forms ","tvam ādi-devaḥ puruṣhaḥ purāṇas\n" + "tvam asya viśhvasya paraṁ nidhānam\n" + "vettāsi vedyaṁ cha paraṁ cha dhāma\n" + "tvayā tataṁ viśhvam ananta-rūpa",R.color.trans));
        mData.add(new NewsItem("वायुर्यमोऽग्निर्वरुण: शशाङ्क:\n" + "प्रजापतिस्त्वं प्रपितामहश्च |\n" + "नमो नमस्तेऽस्तु सहस्रकृत्व:\n" + "पुनश्च भूयोऽपि नमो नमस्ते || 39||"," vāyuḥ—the god of wind; yamaḥ—the god of death; agniḥ—the god of fire; varuṇaḥ—the god of water; śhaśha-aṅkaḥ—the moon-God; prajāpatiḥ—Brahma; tvam—you; prapitāmahaḥ—the great-grandfather; cha—and; namaḥ—my salutations; namaḥ—my salutations; te—unto you; astu—let there be; sahasra-kṛitvaḥ—a thousand times; punaḥ cha—and again; bhūyaḥ—again; api—also; namaḥ—(offering) my salutations; namaḥ te—offering my salutations unto you ","vāyur yamo ’gnir varuṇaḥ śhaśhāṅkaḥ\n" + "prajāpatis tvaṁ prapitāmahaśh cha\n" + "namo namas te ’stu sahasra-kṛitvaḥ\n" + "punaśh cha bhūyo ’pi namo namas te",R.color.trans));
        mData.add(new NewsItem("नम: पुरस्तादथ पृष्ठतस्ते\n" + "नमोऽस्तु ते सर्वत एव सर्व |\n" + "अनन्तवीर्यामितविक्रमस्त्वं\n" + "सर्वं समाप्नोषि ततोऽसि सर्व: || 40||"," namaḥ—offering salutations; purastāt—from the front; atha—and; pṛiṣhṭhataḥ—the rear; te—to you; namaḥ astu—I offer my salutations; te—to you; sarvataḥ—from all sides; eva—indeed; sarva—all; ananta-vīrya—infinite power; amita-vikramaḥ—infinite valor and might; tvam—you; sarvam—everything; samāpnoṣhi—pervade; tataḥ—thus; asi—(you) are; sarvaḥ—everything ","namaḥ purastād atha pṛiṣhṭhatas te\n" + "namo ’stu te sarvata eva sarva\n" + "ananta-vīryāmita-vikramas tvaṁ\n" + "sarvaṁ samāpnoṣhi tato ’si sarvaḥ",R.color.trans));
        mData.add(new NewsItem("सखेति मत्वा प्रसभं यदुक्तं\n" + "हे कृष्ण हे यादव हे सखेति |\n" + "अजानता महिमानं तवेदं\n" + "मया प्रमादात्प्रणयेन वापि || 41||\n" + "यच्चावहासार्थमसत्कृतोऽसि\n" + "विहारशय्यासनभोजनेषु |\n" + "एकोऽथवाप्यच्युत तत्समक्षं\n" + "तत्क्षामये त्वामहमप्रमेयम् || 42||"," sakhā—friend; iti—as; matvā—thinking; prasabham—presumptuously; yat—whatever; uktam—addressed; he kṛiṣhṇa—O Shree Krishna; he yādava—O Shree Krishna, who was born in the Yadu clan; he sakhe—O my dear mate; iti—thus; ajānatā—in ignorance; mahimānam—majesty; tava—your; idam—this; mayā—by me; pramādāt—out of negligence; praṇayena—out of affection; vā api—or else; yat—whatever; cha—also; avahāsa-artham—humorously; asat-kṛitaḥ—disrespectfully; asi—you were; vihāra—while at play; śhayyā—while resting; āsana—while sitting; bhojaneṣhu—while eating; ekaḥ—(when) alone; athavā—or; api—even; achyuta—Krishna, the infallible one; tat-samakṣham—before others; tat—all that; kṣhāmaye—beg for forgiveness; tvām—from you; aham—I; aprameyam—immeasurable ","sakheti matvā prasabhaṁ yad uktaṁ\n" + "he kṛiṣhṇa he yādava he sakheti\n" + "ajānatā mahimānaṁ tavedaṁ\n" + "mayā pramādāt praṇayena vāpi\n" + "yach chāvahāsārtham asat-kṛito ’si\n" + "vihāra-śhayyāsana-bhojaneṣhu\n" + "eko ’tha vāpy achyuta tat-samakṣhaṁ\n" + "tat kṣhāmaye tvām aham aprameyam",R.color.trans));
        mData.add(new NewsItem("पितासि लोकस्य चराचरस्य\n" + "त्वमस्य पूज्यश्च गुरुर्गरीयान् |\n" + "न त्वत्समोऽस्त्यभ्यधिक: कुतोऽन्यो\n" + "लोकत्रयेऽप्यप्रतिमप्रभाव || 43||"," pitā—the father; asi—you are; lokasya—of the entire universe; chara—moving; acharasya—nonmoving; tvam—you; asya—of this; pūjyaḥ—worshipable; cha—and; guruḥ—spiritual master; garīyān—glorious; na—not; tvat-samaḥ—equal to you; asti—is; abhyadhikaḥ—greater; kutaḥ—who is?; anyaḥ—other; loka-traye—in the three worlds; api—even; apratima-prabhāva—possessor of incomparable power ","pitāsi lokasya charācharasya\n" + "tvam asya pūjyaśh cha gurur garīyān\n" + "na tvat-samo ’sty abhyadhikaḥ kuto ’nyo\n" + "loka-traye ’py apratima-prabhāva",R.color.trans));
        mData.add(new NewsItem("तस्मात्प्रणम्य प्रणिधाय कायं\n" + "प्रसादये त्वामहमीशमीड्यम् |\n" + "पितेव पुत्रस्य सखेव सख्यु:\n" + "प्रिय: प्रियायार्हसि देव सोढुम् || 44||"," tasmāt—therefore; praṇamya—bowing down; praṇidhāya—prostrating; kāyam—the body; prasādaye—to implore grace; tvām—your; aham—I; īśham—the Supreme Lord; īḍyam—adorable; pitā—father; iva—as; putrasya—with a son; sakhā—friend; iva—as; sakhyuḥ—with a friend; priyaḥ—a lover; priyāyāḥ—with the beloved; arhasi—you should; deva—Lord; soḍhum—forgive ","\n" + "\n" + "tasmāt praṇamya praṇidhāya kāyaṁ\n" + "prasādaye tvām aham īśham īḍyam\n" + "piteva putrasya sakheva sakhyuḥ\n" + "priyaḥ priyāyārhasi deva soḍhum\n",R.color.trans));
        mData.add(new NewsItem("अदृष्टपूर्वं हृषितोऽस्मि दृष्ट्वा\n" + "भयेन च प्रव्यथितं मनो मे |\n" + "तदेव मे दर्शय देवरूपं\n" + "प्रसीद देवेश जगन्निवास || 45||"," adṛiṣhṭa-pūrvam—that which has not been seen before; hṛiṣhitaḥ—great joy; asmi—I am; dṛiṣhṭvā—having seen; bhayena—with fear; cha—yet; pravyathitam—trembles; manaḥ—mind; me—my; tat—that; eva—certainly; me—to me; darśhaya—show; deva—Lord; rūpam—form; prasīda—please have mercy; deva-īśha—God of gods; jagat-nivāsa—abode of the universe ","adṛiṣhṭa-pūrvaṁ hṛiṣhito ’smi dṛiṣhṭvā\n" + "bhayena cha pravyathitaṁ mano me\n" + "tad eva me darśhaya deva rūpaṁ\n" + "prasīda deveśha jagan-nivāsa",R.color.trans));
        mData.add(new NewsItem("किरीटिनं गदिनं चक्रहस्त-\n" + "मिच्छामि त्वां द्रष्टुमहं तथैव |\n" + "तेनैव रूपेण चतुर्भुजेन\n" + "सहस्रबाहो भव विश्वमूर्ते || 46||"," kirīṭinam—wearing the crown; gadinam—carrying the mace; chakra-hastam—disc in hand; ichchhāmi—I wish; tvām—you; draṣhṭum—to see; aham—I; tathā eva—similarly; tena eva—in that; rūpeṇa—form; chatuḥ-bhujena—four-armed; sahasra-bāho—thousand-armed one; bhava—be; viśhwa-mūrte—universal form ","kirīṭinaṁ gadinaṁ chakra-hastam\n" + "ichchhāmi tvāṁ draṣhṭum ahaṁ tathaiva\n" + "tenaiva rūpeṇa chatur-bhujena\n" + "sahasra-bāho bhava viśhva-mūrte",R.color.trans));
        mData.add(new NewsItem("श्रीभगवानुवाच |\n" + "मया प्रसन्नेन तवार्जुनेदं\n" + "रूपं परं दर्शितमात्मयोगात् |\n" + "तेजोमयं विश्वमनन्तमाद्यं\n" + "यन्मे त्वदन्येन न दृष्टपूर्वम् || 47||"," śhrī-bhagavān uvācha—the Blessed Lord said; mayā—by me; prasannena—being pleased; tava—with you; arjuna—Arjun; idam—this; rūpam—form; param—divine; darśhitam—shown; ātma-yogāt—by my Yogmaya power; tejaḥ-mayam—resplendent; viśhwam—cosmic; anantam—unlimited; ādyam—primeval; yat—which; me—my; tvat anyena—other than you; na dṛiṣhṭa-pūrvam—no one has ever seen ","\n" + "\n" + "śhrī-bhagavān uvācha\n" + "mayā prasannena tavārjunedaṁ\n" + "rūpaṁ paraṁ darśhitam ātma-yogāt\n" + "tejo-mayaṁ viśhvam anantam ādyaṁ\n" + "yan me tvad anyena na dṛiṣhṭa-pūrvam\n",R.color.trans));
        mData.add(new NewsItem("न वेदयज्ञाध्ययनैर्न दानै-\n" + "र्न च क्रियाभिर्न तपोभिरुग्रै: |\n" + "एवंरूप: शक्य अहं नृलोके\n" + "द्रष्टुं त्वदन्येन कुरुप्रवीर || 48||"," na—not; veda-yajña—by performance of sacrifice; adhyayanaiḥ—by study of the Vedas; na—nor; dānaiḥ—by charity; na—nor; cha—and; kriyābhiḥ—by rituals; na—not; tapobhiḥ—by austerities; ugraiḥ—severe; evam-rūpaḥ—in this form; śhakyaḥ—possible; aham—I; nṛi-loke—in the world of the mortals; draṣhṭum—to be seen; tvat—than you; anyena—by another; kuru-pravīra—the best of the Kuru warriors ","na veda-yajñādhyayanair na dānair\n" + "na cha kriyābhir na tapobhir ugraiḥ\n" + "evaṁ-rūpaḥ śhakya ahaṁ nṛi-loke\n" + "draṣhṭuṁ tvad anyena kuru-pravīra",R.color.trans));
        mData.add(new NewsItem("मा ते व्यथा मा च विमूढभावो\n" + "दृष्ट्वा रूपं घोरमीदृङ्ममेदम् |\n" + "व्यपेतभी: प्रीतमना: पुनस्त्वं\n" + "तदेव मे रूपमिदं प्रपश्य || 49||"," mā te—you shout not be; vyathā—afraid; mā—not; cha—and; vimūḍha-bhāvaḥ—bewildered state; dṛiṣhṭvā—on seeing; rūpam—form; ghoram—terrible; īdṛik—such; mama—of mine; idam—this; vyapeta-bhīḥ—free from fear; prīta-manāḥ—cheerful mind; punaḥ—again; tvam—you; tat eva—that very; me—my; rūpam—form; idam—this; prapaśhya—behold ","mā te vyathā mā cha vimūḍha-bhāvo\n" + "dṛiṣhṭvā rūpaṁ ghoram īdṛiṅ mamedam\n" + "vyapeta-bhīḥ prīta-manāḥ punas tvaṁ\n" + "tad eva me rūpam idaṁ prapaśhya",R.color.trans));
        mData.add(new NewsItem("सञ्जय उवाच |\n" + "इत्यर्जुनं वासुदेवस्तथोक्त्वा\n" + "स्वकं रूपं दर्शयामास भूय: |\n" + "आश्वासयामास च भीतमेनं\n" + "भूत्वा पुन: सौम्यवपुर्महात्मा || 50||"," sañjayaḥ uvācha—Sanjay said; iti—thus; arjunam—to Arjun; vāsudevaḥ—Krishna, the son of Vasudev; tathā—in that way; uktvā—having spoken; svakam—his personal; rūpam—form; darśhayām āsa—displayed; bhūyaḥ—again; āśhvāsayām āsa—consoled; cha—and; bhītam—frightened; enam—him; bhūtvā—becoming; punaḥ—again; saumya-vapuḥ—the gentle (two-armed) form; mahā-ātmā—the compassionate ","\n" + "\n" + "sañjaya uvācha\n" + "ity arjunaṁ vāsudevas tathoktvā\n" + "svakaṁ rūpaṁ darśhayām āsa bhūyaḥ\n" + "āśhvāsayām āsa cha bhītam enaṁ\n" + "bhūtvā punaḥ saumya-vapur mahātmā\n",R.color.trans));
        mData.add(new NewsItem("अर्जुन उवाच |\n" + "दृष्ट्वेदं मानुषं रूपं तव सौम्यं जनार्दन |\n" + "इदानीमस्मि संवृत्त: सचेता: प्रकृतिं गत: || 51||"," arjunaḥ uvācha—Arjun said; dṛiṣhṭvā—seeing; idam—this; mānuṣham—human; rūpam—form; tava—your; saumyam—gentle; janārdana—he who looks after the public, Krishna; idānīm—now; asmi—I am; saṁvṛittaḥ—composed; sa-chetāḥ—in my mind; prakṛitim—to normality; gataḥ—have become ","arjuna uvācha\n" + "dṛiṣhṭvedaṁ mānuṣhaṁ rūpaṁ tava saumyaṁ janārdana\n" + "idānīm asmi saṁvṛittaḥ sa-chetāḥ prakṛitiṁ gataḥ",R.color.trans));
        mData.add(new NewsItem("श्रीभगवानुवाच |\n" + "सुदुर्दर्शमिदं रूपं दृष्टवानसि यन्मम |\n" + "देवा अप्यस्य रूपस्य नित्यं दर्शनकाङ्क्षिण: || 52||\n" + "नाहं वेदैर्न तपसा न दानेन न चेज्यया |\n" + "शक्य एवंविधो द्रष्टुं दृष्टवानसि मां यथा || 53||"," śhrī-bhagavān uvācha—the Supreme Lord said; su-durdarśham—exceedingly difficult to behold; idam—this; rūpam—form; dṛiṣhṭavān asi—that you are seeing; yat—which; mama—of mine; devāḥ—the celestial gods; api—even; asya—this; rūpasya—form; nityam—eternally; darśhana-kāṅkṣhiṇaḥ—aspiring to see; na—never; aham—I; vedaiḥ—by study of the Vedas; na—never; tapasā—by serious penances; na—never; dānena—by charity; na—never; cha—also; ijyayā—by worship; śhakyaḥ—it is possible; evam-vidhaḥ—like this; draṣhṭum—to see; dṛiṣhṭavān—seeing; asi—you are; mām—me; yathā—as ","śhrī-bhagavān uvācha\n" + "su-durdarśham idaṁ rūpaṁ dṛiṣhṭavān asi yan mama\n" + "devā apy asya rūpasya nityaṁ darśhana-kāṅkṣhiṇaḥ\n" + "nāhaṁ vedair na tapasā na dānena na chejyayā\n" + "śhakya evaṁ-vidho draṣhṭuṁ dṛiṣhṭavān asi māṁ yathā",R.color.trans));
        mData.add(new NewsItem("भक्त्या त्वनन्यया शक्य अहमेवंविधोऽर्जुन |\n" + "ज्ञातुं द्रष्टुं च तत्वेन प्रवेष्टुं च परन्तप || 54||"," bhaktyā—by devotion; tu—alone; ananyayā—unalloyed; śhakyaḥ—possible; aham—I; evam-vidhaḥ—like this; arjuna—Arjun; jñātum—to be known; draṣhṭum—to be seen; cha—and; tattvena—truly; praveṣhṭum—to enter into (union with me); cha—and; parantapa—scorcher of foes ","bhaktyā tv ananyayā śhakya aham evaṁ-vidho ’rjuna\n" + "jñātuṁ draṣhṭuṁ cha tattvena praveṣhṭuṁ cha parantapa",R.color.trans));
        mData.add(new NewsItem("मत्कर्मकृन्मत्परमो मद्भक्त: सङ्गवर्जित: |\n" + "निर्वैर: सर्वभूतेषु य: स मामेति पाण्डव || 55||"," mat-karma-kṛit—perform duties for my sake; mat-paramaḥ—considering me the Supreme; mat-bhaktaḥ—devoted to me; saṅga-varjitaḥ—free from attachment; nirvairaḥ—without malice; sarva-bhūteṣhu—toward all entities; yaḥ—who; saḥ—he; mām—to me; eti—comes; pāṇḍava—Arjun, the son of Pandu ","\n" + "\n" + "mat-karma-kṛin mat-paramo mad-bhaktaḥ saṅga-varjitaḥ\n" + "nirvairaḥ sarva-bhūteṣhu yaḥ sa mām eti pāṇḍava\n",R.color.trans));


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
                            Intent intent = new Intent(Vchp11.this, CloseActivity.class);
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

            Intent myIntent = new Intent(this, Chp11.class);
            this.startActivity(myIntent);

        }

        if (id == R.id.verses){

        //    Intent myIntent = new Intent(this, Main2Activity.class);
         //   this.startActivity(myIntent);

        }

        if (id == R.id.explain){

            //   Intent myIntent = new Intent(this, Explaination.class);
            //   this.startActivity(myIntent);

            new FancyGifDialog.Builder(Vchp11.this)
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