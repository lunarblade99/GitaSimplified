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
import com.github.gitasimplified.chp.Chp15;
import com.shashank.sony.fancygifdialoglib.FancyGifDialog;
import com.shashank.sony.fancygifdialoglib.FancyGifDialogListener;

import java.util.ArrayList;
import java.util.List;

public class Vchp15 extends AppCompatActivity
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
        navigationView.getMenu().getItem(14).setChecked(true);

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
        mData.add(new NewsItem("श्रीभगवानुवाच |\n" + "ऊर्ध्वमूलमध:शाखमश्वत्थं प्राहुरव्ययम् |\n" + "छन्दांसि यस्य पर्णानि यस्तं वेद स वेदवित् || 1||"," śhrī-bhagavān uvācha—the Supreme Divine Personality said; ūrdhva-mūlam—with roots above; adhaḥ—downward; śhākham—branches; aśhvattham—the sacred fig tree; prāhuḥ—they speak; avyayam—eternal; chhandānsi—Vedic mantras; yasya—of which; parṇāni—leaves; yaḥ—who; tam—that; veda—knows; saḥ—he; veda-vit—the knower of the Vedas ","śhrī-bhagavān uvācha\n" + "ūrdhva-mūlam adhaḥ-śhākham aśhvatthaṁ prāhur avyayam\n" + "chhandānsi yasya parṇāni yas taṁ veda sa veda-vit",R.color.trans));
        mData.add(new NewsItem("अधश्चोर्ध्वं प्रसृतास्तस्य शाखा\n" + "गुणप्रवृद्धा विषयप्रवाला: |\n" + "अधश्च मूलान्यनुसन्ततानि\n" + "कर्मानुबन्धीनि मनुष्यलोके || 2||"," adhaḥ—downward; cha—and; ūrdhvam—upward; prasṛitāḥ—extended; tasya—its; śhākhāḥ—branches; guṇa—modes of material nature; pravṛiddhāḥ—nourished; viṣhaya—objects of the senses; pravālāḥ—buds; adhaḥ—downward; cha—and; mūlāni—roots; anusantatāni—keep growing; karma—actions; anubandhīni—bound; manuṣhya-loke—in the world of humans ","adhaśh chordhvaṁ prasṛitās tasya śhākhā\n" + "guṇa-pravṛiddhā viṣhaya-pravālāḥ\n" + "adhaśh cha mūlāny anusantatāni\n" + "karmānubandhīni manuṣhya-loke",R.color.trans));
        mData.add(new NewsItem("न रूपमस्येह तथोपलभ्यते\n" + "नान्तो न चादिर्न च सम्प्रतिष्ठा |\n" + "अश्वत्थमेनं सुविरूढमूल\n" + "मसङ्गशस्त्रेण दृढेन छित्वा || 3||\n" + "तत: पदं तत्परिमार्गितव्यं\n" + "यस्मिन्गता न निवर्तन्ति भूय: |\n" + "तमेव चाद्यं पुरुषं प्रपद्ये\n" + "यत: प्रवृत्ति: प्रसृता पुराणी || 4||"," na—not; rūpam—form; asya—of this; iha—in this world; tathā—as such; upalabhyate—is perceived; na—neither; antaḥ—end; na—nor; cha—also; ādiḥ—beginning; na—never; cha—also; sampratiṣhṭhā—the basis; aśhvattham—sacred fig tree; enam—this; su-virūḍha-mūlam—deep-rooted; asaṅga-śhastreṇa—by the axe of detachment; dṛiḍhena—strong; chhittvā—having cut down; tataḥ—then; padam—place; tat—that; parimārgitavyam—one must search out; yasmin—where; gatāḥ—having gone; na—not; nivartanti—return; bhūyaḥ—again; tam—to him; eva—certainly; cha—and; ādyam—original; puruṣham—the Supreme Lord; prapadye—take refuge; yataḥ—whence; pravṛittiḥ—the activity; prasṛitā—streamed forth; purāṇi—very old ","na rūpam asyeha tathopalabhyate\n" + "nānto na chādir na cha sampratiṣhṭhā\n" + "aśhvattham enaṁ su-virūḍha-mūlam\n" + "asaṅga-śhastreṇa dṛiḍhena chhittvā\n" + "tataḥ padaṁ tat parimārgitavyaṁ\n" + "yasmin gatā na nivartanti bhūyaḥ\n" + "tam eva chādyaṁ puruṣhaṁ prapadye\n" + "yataḥ pravṛittiḥ prasṛitā purāṇī",R.color.trans));
        mData.add(new NewsItem("निर्मानमोहा जितसङ्गदोषा\n" + "अध्यात्मनित्या विनिवृत्तकामा: |\n" + "द्वन्द्वैर्विमुक्ता: सुखदु:खसंज्ञै\n" + "र्गच्छन्त्यमूढा: पदमव्ययं तत् || 5||"," niḥ—free from; māna—vanity; mohāḥ—delusion; jita—having overcome; saṅga—attachment; doṣhāḥ—evils; adhyātma-nityāḥ—dwelling constantly in the self and God; vinivṛitta—freed from; kāmāḥ—desire to enjoy senses; dvandvaiḥ—from the dualities; vimuktāḥ—liberated; sukha-duḥkha—pleasure and pain; saṁjñaiḥ—known as; gachchhanti—attain; amūḍhāḥ—unbewildered; padam—Abode; avyayam—eternal; tat—that ","nirmāna-mohā jita-saṅga-doṣhā\n" + "adhyātma-nityā vinivṛitta-kāmāḥ\n" + "dvandvair vimuktāḥ sukha-duḥkha-sanjñair\n" + "gachchhanty amūḍhāḥ padam avyayaṁ tat",R.color.trans));
        mData.add(new NewsItem("न तद्भासयते सूर्यो न शशाङ्को न पावक: |\n" + "यद्गत्वा न निवर्तन्ते तद्धाम परमं मम || 6||"," na—neither; tat—that; bhāsayate—illumine; sūryaḥ—the sun; na—nor; śhaśhāṅkaḥ—the moon; na—nor; pāvakaḥ—fire; yat—where; gatvā—having gone; na—never; nivartante—they return; tat—that; dhāma—Abode; paramam—supreme; mama—Mine\n","na tad bhāsayate sūryo na śhaśhāṅko na pāvakaḥ\n" + "yad gatvā na nivartante tad dhāma paramaṁ mama",R.color.trans));
        mData.add(new NewsItem("ममैवांशो जीवलोके जीवभूत: सनातन: |\n" + "मन:षष्ठानीन्द्रियाणि प्रकृतिस्थानि कर्षति || 7||"," mama—My; eva—only; anśhaḥ—fragmental part; jīva-loke—in the material world; jīva-bhūtaḥ—the embodied souls; sanātanaḥ—eternal; manaḥ—with the mind; ṣhaṣhṭhāni—the six; indriyāṇi—senses; prakṛiti-sthāni—bound by material nature; karṣhati—struggling ","mamaivānśho jīva-loke jīva-bhūtaḥ sanātanaḥ\n" + "manaḥ-ṣhaṣhṭhānīndriyāṇi prakṛiti-sthāni karṣhati",R.color.trans));
        mData.add(new NewsItem("शरीरं यदवाप्नोति यच्चाप्युत्क्रामतीश्वर: |\n" + "गृहीत्वैतानि संयाति वायुर्गन्धानिवाशयात् || 8||"," śharīram—the body; yat—as; avāpnoti—carries; yat—as; cha api—also; utkrāmati—leaves; īśhvaraḥ—the Lord of the material body, the embodied soul; gṛihītvā—taking; etāni—these; sanyāti—goes away; vāyuḥ—the air; gandhān—fragrance; iva—like; āśhayāt—from seats ","śharīraṁ yad avāpnoti yach chāpy utkrāmatīśhvaraḥ\n" + "gṛihītvaitāni sanyāti vāyur gandhān ivāśhayāt",R.color.trans));
        mData.add(new NewsItem("श्रोत्रं चक्षु: स्पर्शनं च रसनं घ्राणमेव च |\n" + "अधिष्ठाय मनश्चायं विषयानुपसेवते || 9||"," śhrotram—ears; chakṣhuḥ—eyes; sparśhanam—the sense of touch; cha—and; rasanam—tongue; ghrāṇam—nose; eva—also; cha—and; adhiṣhṭhāya—grouped around; manaḥ—mind; cha—also; ayam—they; viṣhayān—sense objects; upasevate—savors ","śhrotraṁ chakṣhuḥ sparśhanaṁ cha rasanaṁ ghrāṇam eva cha\n" + "adhiṣhṭhāya manaśh chāyaṁ viṣhayān upasevate",R.color.trans));
        mData.add(new NewsItem("उत्क्रामन्तं स्थितं वापि भुञ्जानं वा गुणान्वितम् |\n" + "विमूढा नानुपश्यन्ति पश्यन्ति ज्ञानचक्षुष: || 10||"," utkrāmantam—departing; sthitam—residing; vā api—or even; bhuñjānam—enjoys; vā—or; guṇa-anvitam—under the spell of the modes of material nature; vimūḍhāḥ—the ignorant; na—not; anupaśhyanti—percieve; paśhyanti—behold; jñāna-chakṣhuṣhaḥ—those who possess the eyes of knowledge ","utkrāmantaṁ sthitaṁ vāpi bhuñjānaṁ vā guṇānvitam\n" + "vimūḍhā nānupaśhyanti paśhyanti jñāna-chakṣhuṣhaḥ",R.color.trans));
        mData.add(new NewsItem("यतन्तो योगिनश्चैनं पश्यन्त्यात्मन्यवस्थितम् |\n" + "यतन्तोऽप्यकृतात्मानो नैनं पश्यन्त्यचेतस: || 11||"," yatantaḥ—striving; yoginaḥ—yogis; cha—too; enam—this (the soul); paśhyanti—see; ātmani—in the body; avasthitam—enshrined; yatantaḥ—strive; api—even though; akṛita-ātmānaḥ—those whose minds are not purified; na—not; enam—this; paśhyanti—cognize; achetasaḥ—unaware ","yatanto yoginaśh chainaṁ paśhyanty ātmany avasthitam\n" + "yatanto ‘py akṛitātmāno nainaṁ paśhyanty achetasaḥ",R.color.trans));
        mData.add(new NewsItem("यदादित्यगतं तेजो जगद्भासयतेऽखिलम् |\n" + "यच्चन्द्रमसि यच्चाग्नौ तत्तेजो विद्धि मामकम् || 12||"," yat—which; āditya-gatam—in the sun; tejaḥ—brilliance; jagat—solar system; bhāsayate—illuminates; akhilam—entire; yat—which; chandramasi—in the moon; yat—which; cha—also; agnau—in the fire; tat—that; tejaḥ—brightness; viddhi—know; māmakam—Mine ","yad āditya-gataṁ tejo jagad bhāsayate ’khilam\n" + "yach chandramasi yach chāgnau tat tejo viddhi māmakam",R.color.trans));
        mData.add(new NewsItem("गामाविश्य च भूतानि धारयाम्यहमोजसा |\n" + "पुष्णामि चौषधी: सर्वा: सोमो भूत्वा रसात्मक: || 13||"," gām—earth; āviśhya—permeating; cha—and; bhūtāni—living beings; dhārayāmi—sustain; aham—I; ojasā—energy; puṣhṇāmi—nourish; cha—and; auṣhadhīḥ—plants; sarvāḥ—all; somaḥ—the moon; bhūtvā—becoming; rasa-ātmakaḥ—supplying the juice of life ","gām āviśhya cha bhūtāni dhārayāmy aham ojasā\n" + "puṣhṇāmi chauṣhadhīḥ sarvāḥ somo bhūtvā rasātmakaḥ",R.color.trans));
        mData.add(new NewsItem("अहं वैश्वानरो भूत्वा प्राणिनां देहमाश्रित: |\n" + "प्राणापानसमायुक्त: पचाम्यन्नं चतुर्विधम् || 14||"," aham—I; vaiśhvānaraḥ—fire of digestion; bhūtvā—becoming; prāṇinām—of all living beings; deham—the body; āśhritaḥ—situated; prāṇa-apāna—outgoing and incoming breath; samāyuktaḥ—keeping in balance; pachāmi—I digest; annam—foods; chatuḥ-vidham—the four kinds ","ahaṁ vaiśhvānaro bhūtvā prāṇināṁ deham āśhritaḥ\n" + "prāṇāpāna-samāyuktaḥ pachāmy annaṁ chatur-vidham",R.color.trans));
        mData.add(new NewsItem("सर्वस्य चाहं हृदि सन्निविष्टो\n" + "मत्त: स्मृतिर्ज्ञानमपोहनं च |\n" + "वेदैश्च सर्वैरहमेव वेद्यो\n" + "वेदान्तकृद्वेदविदेव चाहम् || 15||"," sarvasya—of all living beings; cha—and; aham—I; hṛidi—in the hearts; sanniviṣhṭaḥ—seated; mattaḥ—from Me; smṛitiḥ—memory; jñānam—knowledge; apohanam—forgetfulness; cha—as well as; vedaiḥ—by the Vedas; cha—and; sarvaiḥ—all; aham—I; eva—alone; vedyaḥ—to be known; vedānta-kṛit—the author of the Vedānt; veda-vit—the knower of the meaning of the Vedas; eva—alone; cha—and; aham—I ","sarvasya chāhaṁ hṛidi sanniviṣhṭo\n" + "mattaḥ smṛitir jñānam apohanaṁ cha\n" + "vedaiśh cha sarvair aham eva vedyo\n" + "vedānta-kṛid veda-vid eva chāham",R.color.trans));
        mData.add(new NewsItem("द्वाविमौ पुरुषौ लोके क्षरश्चाक्षर एव च |\n" + "क्षर: सर्वाणि भूतानि कूटस्थोऽक्षर उच्यते || 16||"," dvau—two; imau—these; puruṣhau—beings; loke—in creation; kṣharaḥ—the perishable; cha—and; akṣharaḥ—the imperishable; eva—even; cha—and; kṣharaḥ—the perishable; sarvāṇi—all; bhūtāni—beings; kūṭa-sthaḥ—the liberated; akṣharaḥ—the imperishable; uchyate—is said ","dvāv imau puruṣhau loke kṣharaśh chākṣhara eva cha\n" + "kṣharaḥ sarvāṇi bhūtāni kūṭa-stho ’kṣhara uchyate",R.color.trans));
        mData.add(new NewsItem("उत्तम: पुरुषस्त्वन्य: परमात्मेत्युदाहृत: |\n" + "यो लोकत्रयमाविश्य बिभर्त्यव्यय ईश्वर: || 17||"," uttamaḥ—the Supreme; puruṣhaḥ—Divine Personality; tu—but; anyaḥ—besides; parama-ātmā—the Supreme Soul; iti—thus; udāhṛitaḥ—is said; yaḥ—who; loka trayam—the three worlds; āviśhya—enters; bibharti—supports; avyayaḥ—indestructible; īśhvaraḥ—the controller ","uttamaḥ puruṣhas tv anyaḥ paramātmety udāhṛitaḥ\n" + "yo loka-trayam āviśhya bibharty avyaya īśhvaraḥ",R.color.trans));
        mData.add(new NewsItem("यस्मात्क्षरमतीतोऽहमक्षरादपि चोत्तम: |\n" + "अतोऽस्मि लोके वेदे च प्रथित: पुरुषोत्तम: || 18||"," yasmāt—hence; kṣharam—to the perishable; atītaḥ—transcendental; aham—I; akṣharāt—to the imperishable; api—even; cha—and; uttamaḥ—transcendental; ataḥ—therefore; asmi—I am; loke—in the world; vede—in the Vedas; cha—and; prathitaḥ—celebrated; puruṣha-uttamaḥ—as the Supreme Divine Personality ","yasmāt kṣharam atīto ’ham akṣharād api chottamaḥ\n" + "ato ’smi loke vede cha prathitaḥ puruṣhottamaḥ",R.color.trans));
        mData.add(new NewsItem("यो मामेवमसम्मूढो जानाति पुरुषोत्तमम् |\n" + "स सर्वविद्भजति मां सर्वभावेन भारत || 19||"," yaḥ—who; mām—Me; evam—thus; asammūḍhaḥ—without a doubt; jānāti—know; puruṣha-uttamam—the Supreme Divine Personality; saḥ—they; sarva-vit—those with complete knowledge; bhajati—worship; mām—Me; sarva-bhāvena—with one’s whole being; bhārata—Arjun, the son of Bharat ","yo mām evam asammūḍho jānāti puruṣhottamam\n" + "sa sarva-vid bhajati māṁ sarva-bhāvena bhārata",R.color.trans));
        mData.add(new NewsItem("इति गुह्यतमं शास्त्रमिदमुक्तं मयानघ |\n" + "एतद्बुद्ध्वा बुद्धिमान्स्यात्कृतकृत्यश्च भारत || 20||"," iti—these; guhya-tamam—most secret; śhāstram—Vedic scriptures; idam—this; uktam—spoken; mayā—by Me; anagha—Arjun, the sinless one; etat—this; buddhvā—understanding; buddhi-mān—enlightened; syāt—one becomes; kṛita-kṛityaḥ—who fulfills all that is to be accomplished; cha—and; bhārata—Arjun, the son of Bharat ","iti guhyatamaṁ śhāstram idam uktaṁ mayānagha\n" + "etad buddhvā buddhimān syāt kṛita-kṛityaśh cha bhārata",R.color.trans));

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
                            Intent intent = new Intent(Vchp15.this, CloseActivity.class);
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

            Intent myIntent = new Intent(this, Chp15.class);
            this.startActivity(myIntent);

        }

        if (id == R.id.verses){

         //   Intent myIntent = new Intent(this, Main2Activity.class);
         //   this.startActivity(myIntent);

        }

        if (id == R.id.explain){

            //   Intent myIntent = new Intent(this, Explaination.class);
            //   this.startActivity(myIntent);

            new FancyGifDialog.Builder(Vchp15.this)
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