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
import com.github.gitasimplified.chp.Chp18;
import com.shashank.sony.fancygifdialoglib.FancyGifDialog;
import com.shashank.sony.fancygifdialoglib.FancyGifDialogListener;

import java.util.ArrayList;
import java.util.List;

public class Vchp18 extends AppCompatActivity
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
        navigationView.getMenu().getItem(17).setChecked(true);

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
        mData.add(new NewsItem("अर्जुन उवाच |\n" + "सन्न्यासस्य महाबाहो तत्वमिच्छामि वेदितुम् |"," arjunaḥ uvācha—Arjun said; sanyāsasya—of renunciation of actions; mahā-bāho—mighty-armed one; tattvam—the truth; ichchhāmi—I wish; veditum—to understand; tyāgasya—of renunciation of desires for enjoying the fruits of actions; cha—and; hṛiṣhīkeśha—Krishna, the Lord of the senses; pṛithak—distinctively; keśhī-niṣhūdana—Krishna, the killer of the Keshi demon ","arjuna uvācha\n" + "sannyāsasya mahā-bāho tattvam ichchhāmi veditum\n" + "tyāgasya cha hṛiṣhīkeśha pṛithak keśhi-niṣhūdana",R.color.trans));
        mData.add(new NewsItem("श्रीभगवानुवाच |\n" + "काम्यानां कर्मणां न्यासं सन्न्यासं कवयो विदु: |\n" + "सर्वकर्मफलत्यागं प्राहुस्त्यागं विचक्षणा: || 2||"," śhrī-bhagavān uvācha—the Supreme Divine Personality said; kāmyānām—desireful; karmaṇām—of actions; nyāsam—giving up; sanyāsam—renunciation of actions; kavayaḥ—the learned; viduḥ—to understand; sarva—all; karma-phala—fruits of actions; tyāgam—renunciation of desires for enjoying the fruits of actions; prāhuḥ—declare; tyāgam—renunciation of desires for enjoying the fruits of actions; vichakṣhaṇāḥ—the wise ","śhrī-bhagavān uvācha\n" + "kāmyānāṁ karmaṇāṁ nyāsaṁ sannyāsaṁ kavayo viduḥ\n" + "sarva-karma-phala-tyāgaṁ prāhus tyāgaṁ vichakṣhaṇāḥ",R.color.trans));
        mData.add(new NewsItem("त्याज्यं दोषवदित्येके कर्म प्राहुर्मनीषिण: |\n" + "यज्ञदानतप:कर्म न त्याज्यमिति चापरे || 3||"," tyājyam—should be given up; doṣha-vat—as evil; iti—thus; eke—some; karma—actions; prāhuḥ—declare; manīṣhiṇaḥ—the learned; yajña—sacrifice; dāna—charity; tapaḥ—penance; karma—acts; na—never; tyājyam—should be abandoned; iti—thus; cha—and; apare—others ","tyājyaṁ doṣha-vad ity eke karma prāhur manīṣhiṇaḥ\n" + "yajña-dāna-tapaḥ-karma na tyājyam iti chāpare",R.color.trans));
        mData.add(new NewsItem("निश्चयं शृणु मे तत्र त्यागे भरतसत्तम |\n" + "त्यागो हि पुरुषव्याघ्र त्रिविध: सम्प्रकीर्तित: || 4||"," niśhchayam—conclusion; śhṛiṇu—hear; me—my; tatra—there; tyāge—about renunciation of desires for enjoying the fruits of actions; bharata-sat-tama—best of the Bharatas; tyāgaḥ—renunciation of desires for enjoying the fruits of actions; hi—indeed; puruṣha-vyāghra—tiger amongst men; tri-vidhaḥ—of three kinds; samprakīrtitaḥ—declared ","niśhchayaṁ śhṛiṇu me tatra tyāge bharata-sattama\n" + "tyāgo hi puruṣha-vyāghra tri-vidhaḥ samprakīrtitaḥ",R.color.trans));
        mData.add(new NewsItem("यज्ञदानतप:कर्म न त्याज्यं कार्यमेव तत् |\n" + "यज्ञो दानं तपश्चैव पावनानि मनीषिणाम् || 5||"," yajña—sacrifice; dāna—charity; tapaḥ—penance; karma—actions; na—never; tyājyam—should be abandoned; kāryam eva—must certainly be performed; tat—that; yajñaḥ—sacrifice; dānam—charity; tapaḥ—penance; cha—and; eva—indeed; pāvanāni—purifying; manīṣhiṇām—for the wise ","yajña-dāna-tapaḥ-karma na tyājyaṁ kāryam eva tat\n" + "yajño dānaṁ tapaśh chaiva pāvanāni manīṣhiṇām",R.color.trans));
        mData.add(new NewsItem("एतान्यपि तु कर्माणि सङ्गं त्यक्त्वा फलानि च |\n" + "कर्तव्यानीति मे पार्थ निश्चितं मतमुत्तमम् || 6||"," etāni—these; api tu—must certainly be; karmāṇi—activities; saṅgam—attachment; tyaktvā—giving up; phalāni—rewards; cha—and; kartavyāni—should be done as duty; iti—such; me—my; pārtha—Arjun, the son of Pritha; niśhchitam—definite; matam—opinion; uttamam—supreme ","etāny api tu karmāṇi saṅgaṁ tyaktvā phalāni cha\n" + "kartavyānīti me pārtha niśhchitaṁ matam uttamam",R.color.trans));
        mData.add(new NewsItem("नियतस्य तु सन्न्यास: कर्मणो नोपपद्यते |\n" + "मोहात्तस्य परित्यागस्तामस: परिकीर्तित: || 7||"," niyatasya—of prescribed duties; tu—but; sanyāsaḥ—renunciation; karmaṇaḥ—actions; na—never; upapadyate—to be performed; mohāt—deluded; tasya—of that; parityāgaḥ—renunciation; tāmasaḥ—in the mode of ignorance; parikīrtitaḥ—has been declared ","niyatasya tu sannyāsaḥ karmaṇo nopapadyate\n" + "mohāt tasya parityāgas tāmasaḥ parikīrtitaḥ",R.color.trans));
        mData.add(new NewsItem("दु:खमित्येव यत्कर्म कायक्लेशभयात्यजेत् |\n" + "स कृत्वा राजसं त्यागं नैव त्यागफलं लभेत् || 8||"," duḥkham—troublesome; iti—as; eva—indeed; yat—which; karma—duties; kāya—bodily; kleśha—discomfort; bhayāt—out of fear; tyajet—giving up; saḥ—they; kṛitvā—having done; rājasam—in the mode of passion; tyāgam—renunciation of desires for enjoying the fruits of actions; na—never; eva—certainly; tyāga—renunciation of desires for enjoying the fruits of actions; phalam—result; labhet—attain ","duḥkham ity eva yat karma kāya-kleśha-bhayāt tyajet\n" + "sa kṛitvā rājasaṁ tyāgaṁ naiva tyāga-phalaṁ labhet",R.color.trans));
        mData.add(new NewsItem("कार्यमित्येव यत्कर्म नियतं क्रियतेऽर्जुन |\n" + "सङ्गं त्यक्त्वा फलं चैव स त्याग: सात्विको मत: || 9||"," kāryam—as a duty; iti—as; eva—indeed; yat—which; karma niyatam—obligatory actions; kriyate—are performed; arjuna—Arjun; saṅgam—attachment; tyaktvā—relinquishing; phalam—reward; cha—and; eva—certainly; saḥ—such; tyāgaḥ—renunciation of desires for enjoying the fruits of actions; sāttvikaḥ—in the mode of goodness; mataḥ—considered ","kāryam ity eva yat karma niyataṁ kriyate ‘rjuna\n" + "saṅgaṁ tyaktvā phalaṁ chaiva sa tyāgaḥ sāttviko mataḥ",R.color.trans));
        mData.add(new NewsItem("न द्वेष्ट्यकुशलं कर्म कुशले नानुषज्जते |\n" + "त्यागी सत्वसमाविष्टो मेधावी छिन्नसंशय: || 10||"," na—neither; dveṣhṭi—hate; akuśhalam—disagreeable; karma—work; kuśhale—to an agreeable; na—nor; anuṣhajjate—seek; tyāgī—one who renounces desires for enjoying the fruits of actions; sattva—in the mode of goodness; samāviṣhṭaḥ—endowed with; medhāvī—intelligent; chhinna-sanśhayaḥ—those who have no doubts ","na dveṣhṭy akuśhalaṁ karma kuśhale nānuṣhajjate\n" + "tyāgī sattva-samāviṣhṭo medhāvī chhinna-sanśhayaḥ",R.color.trans));
        mData.add(new NewsItem("न हि देहभृता शक्यं त्यक्तुं कर्माण्यशेषत: |\n" + "यस्तु कर्मफलत्यागी स त्यागीत्यभिधीयते || 11||"," na—not; hi—indeed; deha-bhṛitā—for the embodied being; śhakyam—possible; tyaktum—to give up; karmāṇi—activities; aśheṣhataḥ—entirely; yaḥ—who; tu—but; karma-phala—fruits of actions; tyāgī—one who renounces all desires for enjoying the fruits of actions; saḥ—they; tyāgī—one who renounces all desires for enjoying the fruits of actions; iti—as; abhidhīyate—are said ","na hi deha-bhṛitā śhakyaṁ tyaktuṁ karmāṇy aśheṣhataḥ\n" + "yas tu karma-phala-tyāgī sa tyāgīty abhidhīyate",R.color.trans));
        mData.add(new NewsItem("अनिष्टमिष्टं मिश्रं च त्रिविधं कर्मण: फलम् |\n" + "भवत्यत्यागिनां प्रेत्य न तु सन्न्यासिनां क्वचित् || 12||"," aniṣhṭam—unpleasant; iṣhṭam—pleasant; miśhram—mixed; cha—and; tri-vidham—three-fold; karmaṇaḥ phalam—fruits of actions; bhavati—accrue; atyāginām—to those who are attached to persona reward; pretya—after death; na—not; tu—but; sanyāsinām—for the renouncers of actions; kvachit—ever ","aniṣhṭam iṣhṭaṁ miśhraṁ cha tri-vidhaṁ karmaṇaḥ phalam\n" + "bhavaty atyāgināṁ pretya na tu sannyāsināṁ kvachit",R.color.trans));
        mData.add(new NewsItem("पञ्चैतानि महाबाहो कारणानि निबोध मे |\n" + "साङ् ख्ये कृतान्ते प्रोक्तानि सिद्धये सर्वकर्मणाम् || 13||"," pañcha—five; etāni—these; mahā-bāho—mighty-armed one; kāraṇāni—causes; nibodha—listen; me—from me; sānkhye—of Sānkya; kṛita-ante—stop reactions of karmas; proktāni—explains; siddhaye—for the accomplishment; sarva—all; karmaṇām—of karmas ","pañchaitāni mahā-bāho kāraṇāni nibodha me\n" + "sānkhye kṛitānte proktāni siddhaye sarva-karmaṇām",R.color.trans));
        mData.add(new NewsItem("अधिष्ठानं तथा कर्ता करणं च पृथग्विधम् |\n" + "विविधाश्च पृथक्चेष्टा दैवं चैवात्र पञ्चमम् || 14||"," adhiṣhṭhānam—the body; tathā—also; kartā—the doer (soul); karaṇam—senses; cha—and; pṛithak-vidham—various kinds; vividhāḥ—many; cha—and; pṛithak—distinct; cheṣhṭāḥ—efforts; daivam—Divine Providence; cha eva atra—these certainly are (causes); pañchamam—the fifth ","adhiṣhṭhānaṁ tathā kartā karaṇaṁ cha pṛithag-vidham\n" + "vividhāśh cha pṛithak cheṣhṭā daivaṁ chaivātra pañchamam",R.color.trans));
        mData.add(new NewsItem("शरीरवाङ्मनोभिर्यत्कर्म प्रारभते नर: |\n" + "न्याय्यं वा विपरीतं वा पञ्चैते तस्य हेतव: || 15||\n" + "तत्रैवं सति कर्तारमात्मानं केवलं तु य: |\n" + "पश्यत्यकृतबुद्धित्वान्न स पश्यति दुर्मति: || 16||"," śharīra-vāk-manobhiḥ—with body, speech, or mind; yat—which; karma—action; prārabhate—performs; naraḥ—a person; nyāyyam—proper; vā—or; viparītam—improper; vā—or; pañcha—five; ete—these; tasya—their; hetavaḥ—factors; tatra—there; evam sati—in spite of this; kartāram—the doer; ātmānam—the soul; kevalam—only; tu—but; yaḥ—who; paśhyati—see; akṛita-buddhitvāt—with impure intellect; na—not; saḥ—they; paśhyati—see; durmatiḥ—foolish ","śharīra-vāṅ-manobhir yat karma prārabhate naraḥ\n" + "nyāyyaṁ vā viparītaṁ vā pañchaite tasya hetavaḥ\n" + "tatraivaṁ sati kartāram ātmānaṁ kevalaṁ tu yaḥ\n" + "paśhyaty akṛita-buddhitvān na sa paśhyati durmatiḥ",R.color.trans));
        mData.add(new NewsItem("यस्य नाहङ् कृतो भावो बुद्धिर्यस्य न लिप्यते |\n" + "हत्वाऽपि स इमाँल्लोकान्न हन्ति न निबध्यते || 17||"," yasya—whose; na ahankṛitaḥ—free from the ego of being the doer; bhāvaḥ—nature; buddhiḥ—intellect; yasya—whose; na lipyate—unattached; hatvā—slay; api—even; saḥ—they; imān—this; lokān—living beings; na—neither; hanti—kill; na—nor; nibadhyate—get bound ","yasya nāhankṛito bhāvo buddhir yasya na lipyate\n" + "hatvā ‘pi sa imāl lokān na hanti na nibadhyate",R.color.trans));
        mData.add(new NewsItem("ज्ञानं ज्ञेयं परिज्ञाता त्रिविधा कर्मचोदना |\n" + "करणं कर्म कर्तेति त्रिविध: कर्मसंग्रह: || 18||"," jñānam—knowledge; jñeyam—the object of knowledge; parijñātā—the knower; tri-vidhā—three factors; karma-chodanā—factors that induce action; karaṇam—the instrumens of action; karma—the act; kartā—the doer; iti—thus; tri-vidhaḥ—threefold; karma-saṅgrahaḥ—constituents of action ","jñānaṁ jñeyaṁ parijñātā tri-vidhā karma-chodanā\n" + "karaṇaṁ karma karteti tri-vidhaḥ karma-saṅgrahaḥ",R.color.trans));
        mData.add(new NewsItem("ज्ञानं कर्म च कर्ता च त्रिधैव गुणभेदत: |\n" + "प्रोच्यते गुणसङ् ख्याने यथावच्छृणु तान्यपि || 19||"," jñānam—knowledge; karma—action; cha—and; kartā—doer; cha—also; tridhā—of three kinds; eva—certainly; guṇa-bhedataḥ—distinguished according to the three modes of material nature; prochyate—are declared; guṇa-saṅkhyāne—Sānkhya philosophy, which describes the modes of material nature; yathā-vat—as they are; śhṛiṇu—listen; tāni—them; api—also ","jñānaṁ karma cha kartā cha tridhaiva guṇa-bhedataḥ\n" + "prochyate guṇa-saṅkhyāne yathāvach chhṛiṇu tāny api",R.color.trans));
        mData.add(new NewsItem("सर्वभूतेषु येनैकं भावमव्ययमीक्षते |\n" + "अविभक्तं विभक्तेषु तज्ज्ञानं विद्धि सात्विकम् || 20||"," sarva-bhūteṣhu—within all living beings; yena—by which; ekam—one; bhāvam—nature; avyayam—imperishable; īkṣhate—one sees; avibhaktam—undivided; vibhakteṣhu—in diversity; tat—that; jñānam—knowledge; viddhi—understand; sāttvikam—in the mode of goodness ","sarva-bhūteṣhu yenaikaṁ bhāvam avyayam īkṣhate\n" + "avibhaktaṁ vibhakteṣhu taj jñānaṁ viddhi sāttvikam",R.color.trans));
        mData.add(new NewsItem("पृथक्त्वेन तु यज्ज्ञानं नानाभावान्पृथग्विधान् |\n" + "वेत्ति सर्वेषु भूतेषु तज्ज्ञानं विद्धि राजसम् || 21||"," pṛithaktvena—unconnected; tu—however; yat—which; jñānam—knowledge; nānā-bhāvān—manifold entities; pṛithak-vidhān—of diversity; vetti—consider; sarveṣhu—in all; bhūteṣhu—living entities; tat—that; jñānam—knowledge; viddhi—know; rājasam—in the mode of passion ","pṛithaktvena tu yaj jñānaṁ nānā-bhāvān pṛithag-vidhān\n" + "vetti sarveṣhu bhūteṣhu taj jñānaṁ viddhi rājasam",R.color.trans));
        mData.add(new NewsItem("यत्तु कृत्स्नवदेकस्मिन्कार्ये सक्तमहैतुकम् |\n" + "अतत्वार्थवदल्पं च तत्तामसमुदाहृतम् || 22||"," yat—which; tu—but; kṛitsna-vat—as if it encompasses the whole; ekasmin—in single; kārye—action; saktam—engrossed; ahaitukam—without a reason; atattva-artha-vat—not based on truth; alpam—fragmental; cha—and; tat—that; tāmasam—in the mode of ignorance; udāhṛitam—is said to be ","yat tu kṛitsna-vad ekasmin kārye saktam ahaitukam\n" + "atattvārtha-vad alpaṁ cha tat tāmasam udāhṛitam",R.color.trans));
        mData.add(new NewsItem("नियतं सङ्गरहितमरागद्वेषत: कृतम् |\n" + "अफलप्रेप्सुना कर्म यतत्सात्विकमुच्यते || 23||"," niyatam—in accordance with scriptures; saṅga-rahitam—free from attachment; arāga-dveṣhataḥ—free from attachment and aversion; kṛitam—done; aphala-prepsunā—without desire for rewards; karma—action; yat—which; tat—that; sāttvikam—in the mode of goodness; uchyate—is called ","niyataṁ saṅga-rahitam arāga-dveṣhataḥ kṛitam\n" + "aphala-prepsunā karma yat tat sāttvikam uchyate",R.color.trans));
        mData.add(new NewsItem("यत्तुकामेप्सुना कर्म साहङ्कारेण वा पुन: |\n" + "क्रियते बहुलायासं तद्राजसमुदाहृतम् || 24||"," yat—which; tu—but; kāma-īpsunā—prompted by selfish desire; karma—action; sa-ahaṅkāreṇa—with pride; vā—or; punaḥ—again; kriyate—enacted; bahula-āyāsam—stressfully; tat—that; rājasam—in the nature of passion; udāhṛitam—is said to be ","yat tu kāmepsunā karma sāhankāreṇa vā punaḥ\n" + "kriyate bahulāyāsaṁ tad rājasam udāhṛitam",R.color.trans));
        mData.add(new NewsItem("अनुबन्धं क्षयं हिंसामनपेक्ष्य च पौरुषम् |\n" + "मोहादारभ्यते कर्म यतत्तामसमुच्यते || 25||"," anubandham—consequences; kṣhayam—loss; hinsām—injury; anapekṣhya—by disregarding; cha—and; pauruṣham—one’s own ability; mohāt—out of delusion; ārabhyate—is begun; karma—action; yat—which; tat—that; tāmasam—in the mode of ignorance; uchyate—is declared to be ","anubandhaṁ kṣhayaṁ hinsām anapekṣhya cha pauruṣham\n" + "mohād ārabhyate karma yat tat tāmasam uchyate",R.color.trans));
        mData.add(new NewsItem("मुक्तसङ्गोऽनहंवादी धृत्युत्साहसमन्वित: |\n" + "सिद्ध्यसिद्ध्योर्निर्विकार: कर्ता सात्विक उच्यते || 26||"," mukta-saṅgaḥ—free from worldly attachment; anaham-vādī—free from ego; dhṛiti—strong resolve; utsāha—zeal; samanvitaḥ—endowed with; siddhi-asiddhyoḥ—in success and failure; nirvikāraḥ—unaffected; kartā—worker; sāttvikaḥ—in the mode of goodness; uchyate—is said to be ","mukta-saṅgo ‘nahaṁ-vādī dhṛity-utsāha-samanvitaḥ\n" + "siddhy-asiddhyor nirvikāraḥ kartā sāttvika uchyate",R.color.trans));
        mData.add(new NewsItem("रागी कर्मफलप्रेप्सुर्लुब्धो हिंसात्मकोऽशुचि: |\n" + "हर्षशोकान्वित: कर्ता राजस: परिकीर्तित: || 27||"," rāgī—craving; karma-phala—fruit of work; prepsuḥ—covet; lubdhaḥ—greedy; hinsā-ātmakaḥ—violent-natured; aśhuchiḥ—impure; harṣha-śhoka-anvitaḥ—moved by joy and sorrow; kartā—performer; rājasaḥ—in the mode of passion; parikīrtitaḥ—is declared ","rāgī karma-phala-prepsur lubdho hinsātmako ‘śhuchiḥ\n" + "harṣha-śhokānvitaḥ kartā rājasaḥ parikīrtitaḥ",R.color.trans));
        mData.add(new NewsItem("अयुक्त: प्राकृत: स्तब्ध: शठो नैष्कृतिकोऽलस: |\n" + "विषादी दीर्घसूत्री च कर्ता तामस उच्यते || 28||"," ayuktaḥ—undisciplined; prākṛitaḥ—vulgar; stabdhaḥ—obstinate; śhaṭhaḥ—cunning; naiṣhkṛitikaḥ—dishonest or vile; alasaḥ—slothful; viṣhādī—unhappy and morose; dīrgha-sūtrī—procrastinating; cha—and; kartā—performer; tāmasaḥ—in the mode of ignorance; uchyate—is said to be ","ayuktaḥ prākṛitaḥ stabdhaḥ śhaṭho naiṣhkṛitiko ‘lasaḥ\n" + "viṣhādī dīrgha-sūtrī cha kartā tāmasa uchyate",R.color.trans));
        mData.add(new NewsItem("बुद्धेर्भेदं धृतेश्चैव गुणतस्त्रिविधं शृणु |\n" + "प्रोच्यमानमशेषेण पृथक्त्वेन धनञ्जय || 29||"," buddheḥ—of intellect; bhedam—the distinctions; dhṛiteḥ—of determination; cha—and; eva—certainly; guṇataḥ tri-vidham—according to the three modes of material nature; śhṛiṇu—hear; prochyamānam—described; aśheṣheṇa—in detail; pṛithaktvena—distinctly; dhanañjaya—conqueror of wealth, Arjun ","buddher bhedaṁ dhṛiteśh chaiva guṇatas tri-vidhaṁ śhṛiṇu\n" + "prochyamānam aśheṣheṇa pṛithaktvena dhanañjaya",R.color.trans));
        mData.add(new NewsItem("प्रवृत्तिंच निवृत्तिं च कार्याकार्ये भयाभये |\n" + "बन्धं मोक्षं च या वेत्तिबुद्धि: सा पार्थ सात्विकी || 30||"," pravṛittim—activities; cha—and; nivṛittim—renuncation from action; cha—and; kārya—proper action; akārye—improper action; bhaya—fear; abhaye—without fear; bandham—what is binding; mokṣham—what is liberating; cha—and; yā—which; vetti—understands; buddhiḥ—intellect; sā—that; pārtha—son of Pritha; sāttvikī—in the nature of goodness ","pravṛittiṁ cha nivṛittiṁ cha kāryākārye bhayābhaye\n" + "bandhaṁ mokṣhaṁ cha yā vetti buddhiḥ sā pārtha sāttvikī",R.color.trans));
        mData.add(new NewsItem("यया धर्ममधर्मं च कार्यं चाकार्यमेव च |\n" + "अयथावत्प्रजानाति बुद्धि: सा पार्थ राजसी || 31||"," yayā—by which; dharmam—righteousness; adharmam—unrighteousness; cha—and; kāryam—right conduct; cha—and; akāryam—wrong conduct; eva—certainly; cha—and; ayathā-vat—confused; prajānāti—distinguish; buddhiḥ—intellect; sā—that; pārtha—Arjun, the son of Pritha; rājasī—in the mode of passion ","yayā dharmam adharmaṁ cha kāryaṁ chākāryam eva cha\n" + "ayathāvat prajānāti buddhiḥ sā pārtha rājasī",R.color.trans));
        mData.add(new NewsItem("अधर्मं धर्ममिति या मन्यते तमसावृता |\n" + "सर्वार्थान्विपरीतांश्च बुद्धि: सा पार्थ तामसी || 32||"," adharmam—irreligion; dharmam—religion; iti—thus; yā—which; manyate—imagines; tamasa-āvṛitā—shrouded in darkness; sarva-arthān—all things; viparītān—opposite; cha—and; buddhiḥ—intellect; sā—that; pārtha—Arjun, the son of Pritha; tāmasī—of the nature of ignorance ","adharmaṁ dharmam iti yā manyate tamasāvṛitā\n" + "sarvārthān viparītānśh cha buddhiḥ sā pārtha tāmasī",R.color.trans));
        mData.add(new NewsItem("धृत्या यया धारयते मन:प्राणेन्द्रियक्रिया: |\n" + "योगेनाव्यभिचारिण्या धृति: सा पार्थ सात्विकी || 33||"," dhṛityā—by determining; yayā—which; dhārayate—sustains; manaḥ—of the mind; prāṇa—life-airs; indriya—senses; kriyāḥ—activities; yogena—through Yog; avyabhichāriṇyā—with steadfastness; dhṛitiḥ—determination; sā—that; pārtha—Arjun, the son of Pritha; sāttvikī—in the mode of goodness ","dhṛityā yayā dhārayate manaḥ-prāṇendriya-kriyāḥ\n" + "yogenāvyabhichāriṇyā dhṛitiḥ sā pārtha sāttvikī",R.color.trans));
        mData.add(new NewsItem("यया तु धर्मकामार्थान्धृत्या धारयतेऽर्जुन |\n" + "प्रसङ्गेन फलाकाङ् क्षी धृति: सा पार्थ राजसी || 34||"," yayā—by which; tu—but; dharma-kāma-arthān—duty, pleasures, and wealth; dhṛityā—through steadfast will; dhārayate—holds; arjuna—Arjun; prasaṅgena—due of attachment; phala-ākāṅkṣhī—desire for rewards; dhṛitiḥ—determination; sā—that; pārtha—Arjun, the son of Pritha; rājasī—in the mode of passion ","yayā tu dharma-kāmārthān dhṛityā dhārayate ‘rjuna\n" + "prasaṅgena phalākāṅkṣhī dhṛitiḥ sā pārtha rājasī",R.color.trans));
        mData.add(new NewsItem("यया स्वप्नं भयं शोकं विषादं मदमेव च |\n" + "न विमुञ्चति दुर्मेधा धृति: सा पार्थ तामसी || 35||"," yayā—in which; svapnam—dreaming; bhayam—fearing; śhokam—grieving; viṣhādam—despair; madam—conceit; eva—indeed; cha—and; na—not; vimuñchati—give up; durmedhā—unintelligent; dhṛitiḥ—resolve; sā—that; pārtha—Arjun, the son of Pritha; tāmasī—in the mode of ignorance ","yayā svapnaṁ bhayaṁ śhokaṁ viṣhādaṁ madam eva cha\n" + "na vimuñchati durmedhā dhṛitiḥ sā pārtha tāmasī",R.color.trans));
        mData.add(new NewsItem("सुखं त्विदानीं त्रिविधं शृणु मे भरतर्षभ |\n" + "अभ्यासाद्रमते यत्र दु:खान्तं च निगच्छति || 36||"," sukham—happiness; tu—but; idānīm—now; tri-vidham—of three kinds; śhṛiṇu—hear; me—from me; bharata-ṛiṣhabha—Arjun, the best of the Bharatas; abhyāsāt—by practice; ramate—rejoices; yatra—in which; duḥkha-antam—end of all suffering; cha—and; nigachchhati—reaches ","sukhaṁ tv idānīṁ tri-vidhaṁ śhṛiṇu me bharatarṣhabha\n" + "abhyāsād ramate yatra duḥkhāntaṁ cha nigachchhati",R.color.trans));
        mData.add(new NewsItem("यत्तदग्रे विषमिव परिणामेऽमृतोपमम् |\n" + "तत्सुखं सात्विकं प्रोक्तमात्मबुद्धिप्रसादजम् || 37||"," yat—which; tat—that; agre—at first; viṣham iva—like poison; pariṇāme—in the end; amṛita-upamam—like nectar; tat—that; sukham—happiness; sāttvikam—in the mode of goodness; proktam—is said to be; ātma-buddhi—situated in self-knowledge; prasāda-jam—generated by the pure intellect ","yat tad agre viṣham iva pariṇāme ‘mṛitopamam\n" + "tat sukhaṁ sāttvikaṁ proktam ātma-buddhi-prasāda-jam",R.color.trans));
        mData.add(new NewsItem("विषयेन्द्रियसंयोगाद्यत्तदग्रेऽमृतोपमम् |\n" + "परिणामे विषमिव तत्सुखं राजसं स्मृतम् || 38||"," viṣhaya—with the sense objects; indriya—the senses; sanyogāt—from the contact; yat—which; tat—that; agre—at first; amṛita-upamam—like nectar; pariṇāme—at the end; viṣham iva—like poison; tat—that; sukham—happiness; rājasam—in the mode of passion; smṛitam—is said to be ","viṣhayendriya-sanyogād yat tad agre ’mṛitopamam\n" + "pariṇāme viṣham iva tat sukhaṁ rājasaṁ smṛitam",R.color.trans));
        mData.add(new NewsItem("यदग्रे चानुबन्धे च सुखं मोहनमात्मन: |\n" + "निद्रालस्यप्रमादोत्थं तत्तामसमुदाहृतम् || 39||"," yat—which; agre—from beginning; cha—and; anubandhe—to end; cha—and; sukham—happiness; mohanam—illusory; ātmanaḥ—of the self; nidrā—sleep; ālasya—indolence; pramāda—negligence; uttham—derived from; tat—that; tāmasam—in the mode of ignorance; udāhṛitam—is said to be ","yad agre chānubandhe cha sukhaṁ mohanam ātmanaḥ\n" + "nidrālasya-pramādotthaṁ tat tāmasam udāhṛitam",R.color.trans));
        mData.add(new NewsItem("न तदस्ति पृथिव्यां वा दिवि देवेषु वा पुन: |\n" + "सत्वं प्रकृतिजैर्मुक्तं यदेभि: स्यात्त्रिभिर्गुणै: || 40||"," na—no; tat—that; asti—exists; pṛithivyām—on earth; vā—or; divi—the higher celestial abodes; deveṣhu—amongst the celestial gods; vā—or; punaḥ—again; sattvam—existence; prakṛiti-jaiḥ—born of material nature; muktam—liberated; yat—that; ebhiḥ—from the influence of these; syāt—is; tribhiḥ—three; guṇaiḥ—modes of material nature ","na tad asti pṛithivyāṁ vā divi deveṣhu vā punaḥ\n" + "sattvaṁ prakṛiti-jair muktaṁ yad ebhiḥ syāt tribhir guṇaiḥ",R.color.trans));
        mData.add(new NewsItem("ब्राह्मणक्षत्रियविशां शूद्राणां च परन्तप |\n" + "कर्माणि प्रविभक्तानि स्वभावप्रभवैर्गुणै: || 41||"," brāhmaṇa—of the priestly class; kṣhatriya—the warrior and administrative class; viśhām—the mercantile and farming class; śhūdrāṇām—of the worker class; cha—and; parantapa—Arjun, subduer of the enemies; karmāṇi—duties; pravibhaktāni—distributed; svabhāva-prabhavaiḥ-guṇaiḥ—work based on one’s nature and guṇas ","brāhmaṇa-kṣhatriya-viśhāṁ śhūdrāṇāṁ cha parantapa\n" + "karmāṇi pravibhaktāni svabhāva-prabhavair guṇaiḥ",R.color.trans));
        mData.add(new NewsItem("शमो दमस्तप: शौचं क्षान्तिरार्जवमेव च |\n" + "ज्ञानं विज्ञानमास्तिक्यं ब्रह्मकर्म स्वभावजम् || 42||"," śhamaḥ—tranquility; damaḥ—restraint; tapaḥ—austerity; śhaucham—purity; kṣhāntiḥ—patience; ārjavam—integrity; eva—certainly; cha—and; jñānam—knowledge; vijñānam—wisdom; āstikyam—belief in a hereafter; brahma—of the priestly class; karma—work; svabhāva-jam—born of one’s intrinsic qualities ","śhamo damas tapaḥ śhauchaṁ kṣhāntir ārjavam eva cha\n" + "jñānaṁ vijñānam āstikyaṁ brahma-karma svabhāva-jam",R.color.trans));
        mData.add(new NewsItem("शौर्यं तेजो धृतिर्दाक्ष्यं युद्धे चाप्यपलायनम् |\n" + "दानमीश्वरभावश्च क्षात्रं कर्म स्वभावजम् || 43||"," śhauryam—valor; tejaḥ—strength; dhṛitiḥ—fortitude; dākṣhyam yuddhe—skill in weaponry; cha—and; api—also; apalāyanam—not fleeing; dānam—large-heartedness; īśhvara—leadership; bhāvaḥ—qualities; cha—and; kṣhātram—of the warrior and administrative class; karma—work; svabhāva-jam—born of one’s intrinsic qualities ","śhauryaṁ tejo dhṛitir dākṣhyaṁ yuddhe chāpy apalāyanam\n" + "dānam īśhvara-bhāvaśh cha kṣhātraṁ karma svabhāva-jam",R.color.trans));
        mData.add(new NewsItem("कृषिगौरक्ष्यवाणिज्यं वैश्यकर्म स्वभावजम् |\n" + "परिचर्यात्मकं कर्म शूद्रस्यापि स्वभावजम् || 44||"," kṛiṣhi—agriculture; gau-rakṣhya—dairy farming; vāṇijyam—commerce; vaiśhya—of the mercantile and farming class; karma—work; svabhāva-jam—born of one’s intrinsic qualities; paricharyā—serving through work; ātmakam—natural; karma—duty; śhūdrasya—of the worker class; api—and; svabhāva-jam—born of one’s intrinsic qualities ","kṛiṣhi-gau-rakṣhya-vāṇijyaṁ vaiśhya-karma svabhāva-jam\n" + "paricharyātmakaṁ karma śhūdrasyāpi svabhāva-jam",R.color.trans));
        mData.add(new NewsItem("स्वे स्वे कर्मण्यभिरत: संसिद्धिं लभते नर: |\n" + "स्वकर्मनिरत: सिद्धिं यथा विन्दति तच्छृणु || 45||"," sve sve—respectively; karmaṇi—work; abhirataḥ—fulfilling; sansiddhim—perfection; labhate—achieve; naraḥ—a person; sva-karma—to one’s own prescribed duty; nirataḥ—engaged; siddhim—perfection; yathā—as; vindati—attains; tat—that; śhṛiṇu—hear ","sve sve karmaṇy abhirataḥ sansiddhiṁ labhate naraḥ\n" + "sva-karma-nirataḥ siddhiṁ yathā vindati tach chhṛiṇu",R.color.trans));
        mData.add(new NewsItem("यत: प्रवृत्तिर्भूतानां येन सर्वमिदं ततम् |\n" + "स्वकर्मणा तमभ्यर्च्य सिद्धिं विन्दति मानव: || 46||"," yataḥ—from whom; pravṛittiḥ—have come into being; bhūtānām—of all living entities; yena—by whom; sarvam—all; idam—this; tatam—pervaded; sva-karmaṇā—by one’s natural occupation; tam—him; abhyarchya—by worshipping; siddhim—perfection; vindati—attains; mānavaḥ—a person ","yataḥ pravṛittir bhūtānāṁ yena sarvam idaṁ tatam\n" + "sva-karmaṇā tam abhyarchya siddhiṁ vindati mānavaḥ",R.color.trans));
        mData.add(new NewsItem("श्रेयान्स्वधर्मो विगुण: परधर्मात्स्वनुष्ठितात् |\n" + "स्वभावनियतं कर्म कुर्वन्नाप्नोति किल्बिषम् || 47||"," śhreyān—better; swa-dharmaḥ—one’s own prescribed occupational duty; viguṇaḥ—imperfectly done; para-dharmāt—than another’s dharma; su-anuṣhṭhitāt—perfectly done; svabhāva-niyatam—according to one’s innate nature; karma—duty; kurvan—by performing; na āpnoti—does not incur; kilbiṣham—sin ","śhreyān swa-dharmo viguṇaḥ para-dharmāt sv-anuṣhṭhitāt\n" + "svabhāva-niyataṁ karma kurvan nāpnoti kilbiṣham",R.color.trans));
        mData.add(new NewsItem("सहजं कर्म कौन्तेय सदोषमपि न त्यजेत् |\n" + "सर्वारम्भा हि दोषेण धूमेनाग्निरिवावृता: || 48||"," saha-jam—born of one’s nature; karma—duty; kaunteya—Arjun, the son of Kunti; sa-doṣham—with defects; api—even if; na tyajet—one should not abandon; sarva-ārambhāḥ—all endeavors; hi—indeed; doṣheṇa—with evil; dhūmena—with smoke; agniḥ—fire; iva—as; āvṛitāḥ—veiled ","saha-jaṁ karma kaunteya sa-doṣham api na tyajet\n" + "sarvārambhā hi doṣheṇa dhūmenāgnir ivāvṛitāḥ",R.color.trans));
        mData.add(new NewsItem("असक्तबुद्धि: सर्वत्र जितात्मा विगतस्पृह: |\n" + "नैष्कर्म्यसिद्धिं परमां सन्न्यासेनाधिगच्छति || 49||"," asakta-buddhiḥ—those whose intellect is unattached; sarvatra—everywhere; jita-ātmā—who have mastered their mind; vigata-spṛihaḥ—free from desires; naiṣhkarmya-siddhim—state of actionlessness; paramām—highest; sanyāsena—by the practice of renunciation; adhigachchhati—attain ","asakta-buddhiḥ sarvatra jitātmā vigata-spṛihaḥ\n" + "naiṣhkarmya-siddhiṁ paramāṁ sannyāsenādhigachchhati",R.color.trans));
        mData.add(new NewsItem("सिद्धिं प्राप्तो यथा ब्रह्म तथाप्नोति निबोध मे |\n" + "समासेनैव कौन्तेय निष्ठा ज्ञानस्य या परा || 50||"," siddhim—perfection; prāptaḥ—attained; yathā—how; brahma—Brahman; tathā—also; āpnoti—attain; nibodha—hear; me—from me; samāsena—briefly; eva—indeed; kaunteya—Arjun, the son of Kunti; niṣhṭhā—firmly fixed; jñānasya—of knowledge; yā—which; parā—transcendental ","siddhiṁ prāpto yathā brahma tathāpnoti nibodha me\n" + "samāsenaiva kaunteya niṣhṭhā jñānasya yā parā",R.color.trans));
        mData.add(new NewsItem("बुद्ध्या विशुद्धया युक्तो धृत्यात्मानं नियम्य च |\n" + "शब्दादीन्विषयांस्त्यक्त्वा रागद्वेषौ व्युदस्य च || 51||\n" + "विविक्तसेवी लघ्वाशी यतवाक्कायमानस: |\n" + "ध्यानयोगपरो नित्यं वैराग्यं समुपाश्रित: || 52||\n" + "अहङ्कारं बलं दर्पं कामं क्रोधं परिग्रहम् |\n" + "विमुच्य निर्मम: शान्तो ब्रह्मभूयाय कल्पते || 53||"," buddhyā—intellect; viśhuddhayā—purified; yuktaḥ—endowed with; dhṛityā—by determination; ātmānam—the intellect; niyamya—restraining; cha—and; śhabda-ādīn viṣhayān—sound and other objects of the senses; tyaktvā—abandoning; rāga-dveṣhau—attachment and aversion; vyudasya—casting aside; cha—and; vivikta-sevī—relishing solitude; laghu-āśhī—eating light; yata—controls; vāk—speech; kāya—body; mānasaḥ—and mind; dhyāna-yoga-paraḥ—engaged in meditation; nityam—always; vairāgyam—dispassion; samupāśhritaḥ—having taken shelter of; ahankāram—egotism; balam—violence; darpam—arrogance; kāmam—desire; krodham—anger; parigraham—selfishness; vimuchya—being freed from; nirmamaḥ—without possessiveness of property; śhāntaḥ—peaceful; brahma-bhūyāya—union with Brahman; kalpate—is fit ","buddhyā viśhuddhayā yukto dhṛityātmānaṁ niyamya cha\n" + "śhabdādīn viṣhayāns tyaktvā rāga-dveṣhau vyudasya cha\n" + "vivikta-sevī laghv-āśhī yata-vāk-kāya-mānasaḥ\n" + "dhyāna-yoga-paro nityaṁ vairāgyaṁ samupāśhritaḥ\n" + "ahankāraṁ balaṁ darpaṁ kāmaṁ krodhaṁ parigraham\n" + "vimuchya nirmamaḥ śhānto brahma-bhūyāya kalpate",R.color.trans));
        mData.add(new NewsItem("ब्रह्मभूत: प्रसन्नात्मा न शोचति न काङ् क्षति |\n" + "सम: सर्वेषु भूतेषु मद्भक्तिं लभते पराम् || 54||"," brahma-bhūtaḥ—one situated in Brahman; prasanna-ātmā—mentally serene; na—neither; śhochati—grieving; na—nor; kāṅkṣhati—desiring; samaḥ—equitably disposed; sarveṣhu—toward all; bhūteṣhu—living beings; mat-bhaktim—devotion to me; labhate—attains; parām—supreme ","brahma-bhūtaḥ prasannātmā na śhochati na kāṅkṣhati\n" + "samaḥ sarveṣhu bhūteṣhu mad-bhaktiṁ labhate parām",R.color.trans));
        mData.add(new NewsItem("भक्त्या मामभिजानाति यावान्यश्चास्मि तत्वत: |\n" + "ततो मां तत्वतो ज्ञात्वा विशते तदनन्तरम् || 55||"," bhaktyā—by loving devotion; mām—me; abhijānāti—one comes to know; yāvān—as much as; yaḥ cha asmi—as I am; tattvataḥ—in truth; tataḥ—then; mām—me; tattvataḥ—in truth; jñātvā—having known; viśhate—enters; tat-anantaram—thereafter ","bhaktyā mām abhijānāti yāvān yaśh chāsmi tattvataḥ\n" + "tato māṁ tattvato jñātvā viśhate tad-anantaram",R.color.trans));
        mData.add(new NewsItem("सर्वकर्माण्यपि सदा कुर्वाणो मद्व्यपाश्रय: |\n" + "मत्प्रसादादवाप्नोति शाश्वतं पदमव्ययम् || 56||"," sarva—all; karmāṇi—actions; api—though; sadā—always; kurvāṇaḥ—performing; mat-vyapāśhrayaḥ—take full refuge in me; mat-prasādāt—by my grace; avāpnoti—attain; śhāśhvatam—the eternal; padam—abode; avyayam—imperishable ","sarva-karmāṇy api sadā kurvāṇo mad-vyapāśhrayaḥ\n" + "mat-prasādād avāpnoti śhāśhvataṁ padam avyayam",R.color.trans));
        mData.add(new NewsItem("चेतसा सर्वकर्माणि मयि सन्न्यस्य मत्पर: |\n" + "बुद्धियोगमुपाश्रित्य मच्चित्त: सततं भव || 57||"," chetasā—by consciousness; sarva-karmāṇi—every activity; mayi—to me; sannyasya—dedicating; mat-paraḥ—having me as the supreme goal; buddhi-yogam—having the intellect united with God; upāśhritya—taking shelter of; mat-chittaḥ—consciousness absorbed in me; satatam—always; bhava—be ","chetasā sarva-karmāṇi mayi sannyasya mat-paraḥ\n" + "buddhi-yogam upāśhritya mach-chittaḥ satataṁ bhava",R.color.trans));
        mData.add(new NewsItem("मच्चित्त: सर्वदुर्गाणि मत्प्रसादात्तरिष्यसि |\n" + "अथ चेत्वमहङ्कारान्न श्रोष्यसि विनङ्क्ष्यसि || 58||"," mat-chittaḥ—by always remembering me; sarva—all; durgāṇi—obstacles; mat-prasādāt—by my grace; tariṣhyasi—you shall overcome; atha—but; chet—if; tvam—you; ahankārāt—due to pride; na śhroṣhyasi—do not listen; vinaṅkṣhyasi—you will perish ","mach-chittaḥ sarva-durgāṇi mat-prasādāt tariṣhyasi\n" + "atha chet tvam ahankārān na śhroṣhyasi vinaṅkṣhyasi",R.color.trans));
        mData.add(new NewsItem("यदहङ्कारमाश्रित्य न योत्स्य इति मन्यसे |\n" + "मिथ्यैष व्यवसायस्ते प्रकृतिस्त्वां नियोक्ष्यति || 59||"," yat—if; ahankāram—motivated by pride; āśhritya—taking shelter; na yotsye—I shall not fight; iti—thus; manyase—you think; mithyā eṣhaḥ—this is all false; vyavasāyaḥ—determination; te—your; prakṛitiḥ—material nature; tvām—you; niyokṣhyati—will engage ","yad ahankāram āśhritya na yotsya iti manyase\n" + "mithyaiṣha vyavasāyas te prakṛitis tvāṁ niyokṣhyati",R.color.trans));
        mData.add(new NewsItem("स्वभावजेन कौन्तेय निबद्ध: स्वेन कर्मणा |\n" + "कर्तुं नेच्छसि यन्मोहात्करिष्यस्यवशोऽपि तत् || 60||"," swabhāva-jena—born of one’s own material nature; kaunteya—Arjun, the son of Kunti; nibaddhaḥ—bound; svena—by your own; karmaṇā—actions; kartum—to do; na—not; ichchhasi—you wish; yat—which; mohāt—out of delusion; kariṣhyasi—you will do; avaśhaḥ—helplessly; api—even though; tat—that ","swbhāva-jena kaunteya nibaddhaḥ svena karmaṇā\n" + "kartuṁ nechchhasi yan mohāt kariṣhyasy avaśho ’pi tat",R.color.trans));
        mData.add(new NewsItem("ईश्वर: सर्वभूतानां हृद्देशेऽर्जुन तिष्ठति |\n" + "भ्रामयन्सर्वभूतानि यन्त्रारूढानि मायया || 61||"," īśhvaraḥ—the Supreme Lord; sarva-bhūtānām—in all living being; hṛit-deśhe—in the hearts; arjuna—Arjun; tiṣhṭhati—dwells; bhrāmayan—causing to wander; sarva-bhūtāni—all living beings; yantra ārūḍhani—seated on a machine; māyayā—made of the material energy ","īśhvaraḥ sarva-bhūtānāṁ hṛid-deśhe ‘rjuna tiṣhṭhati\n" + "bhrāmayan sarva-bhūtāni yantrārūḍhāni māyayā",R.color.trans));
        mData.add(new NewsItem("तमेव शरणं गच्छ सर्वभावेन भारत |\n" + "तत्प्रसादात्परां शान्तिं स्थानं प्राप्स्यसि शाश्वतम् || 62||"," tam—unto him; eva—only; śharaṇam gachchha—surrender; sarva-bhāvena—whole-heartedly; bhārata—Arjun, the son of Bharat; tat-prasādāt—by his grace; parām—supreme; śhāntim—peace; sthānam—the abode; prāpsyasi—you will attain; śhāśhvatam—eternal ","tam eva śharaṇaṁ gachchha sarva-bhāvena bhārata\n" + "tat-prasādāt parāṁ śhāntiṁ sthānaṁ prāpsyasi śhāśhvatam",R.color.trans));
        mData.add(new NewsItem("इति ते ज्ञानमाख्यातं गुह्याद्गुह्यतरं मया |\n" + "विमृश्यैतदशेषेण यथेच्छसि तथा कुरु || 63||"," iti—thus; te—to you; jñānam—knowledge; ākhyātam—explained; guhyāt—than secret knowledge; guhya-taram—still more secret knowledge; mayā—by me; vimṛiśhya—pondering; etat—on this; aśheṣheṇa—completely; yathā—as; ichchhasi—you wish; tathā—so; kuru—do ","iti te jñānam ākhyātaṁ guhyād guhyataraṁ mayā\n" + "vimṛiśhyaitad aśheṣheṇa yathechchhasi tathā kuru",R.color.trans));
        mData.add(new NewsItem("सर्वगुह्यतमं भूय: शृणु मे परमं वच: |\n" + "इष्टोऽसि मे दृढमिति ततो वक्ष्यामि ते हितम् || 64||"," sarva-guhya-tamam—the most confidential of all; bhūyaḥ—again; śhṛiṇu—hear; me—by me; paramam—supreme; vachaḥ—instruction; iṣhṭaḥ asi—you are dear; me—to me; dṛiḍham—very; iti—thus; tataḥ—because; vakṣhyāmi—I am speaking; te—for your; hitam—benefit ","sarva-guhyatamaṁ bhūyaḥ śhṛiṇu me paramaṁ vachaḥ\n" + "iṣhṭo ‘si me dṛiḍham iti tato vakṣhyāmi te hitam",R.color.trans));
        mData.add(new NewsItem("मन्मना भव मद्भक्तो मद्याजी मां नमस्कुरु |\n" + "मामेवैष्यसि सत्यं ते प्रतिजाने प्रियोऽसि मे || 65||"," mat-manāḥ—thinking of me; bhava—be; mat-bhaktaḥ—my devotee; mat-yājī—worship me; mām—to me; namaskuru—offer obeisance; mām—to me; eva—certainly; eṣhyasi—you will come; satyam—truly; te—to you; pratijāne—I promise; priyaḥ—dear; asi—you are; me—to me ","man-manā bhava mad-bhakto mad-yājī māṁ namaskuru\n" + "mām evaiṣhyasi satyaṁ te pratijāne priyo ‘si me",R.color.trans));
        mData.add(new NewsItem("सर्वधर्मान्परित्यज्य मामेकं शरणं व्रज |\n" + "अहं त्वां सर्वपापेभ्यो मोक्षयिष्यामि मा शुच: || 66||"," sarva-dharmān—all varieties of dharmas; parityajya—abandoning; mām—unto me; ekam—only; śharaṇam—take refuge; vraja—take; aham—I; tvām—you; sarva—all; pāpebhyaḥ—from sinful reactions; mokṣhayiṣhyāmi—shall liberate; mā—do not; śhuchaḥ—fear ","sarva-dharmān parityajya mām ekaṁ śharaṇaṁ vraja\n" + "ahaṁ tvāṁ sarva-pāpebhyo mokṣhayiṣhyāmi mā śhuchaḥ",R.color.trans));
        mData.add(new NewsItem("इदं ते नातपस्काय नाभक्ताय कदाचन |\n" + "न चाशुश्रूषवे वाच्यं न च मां योऽभ्यसूयति || 67||"," idam—this; te—by you; na—never; atapaskāya—to those who are not austere; na—never; abhaktāya—to those who are not devoted; kadāchana—at any time; na—never; cha—also; aśhuśhrūṣhave—to those who are averse to listening (to spiritual topics); vāchyam—to be spoken; na—never; cha—also; mām—toward me; yaḥ—who; abhyasūyati—those who are envious ","idaṁ te nātapaskyāya nābhaktāya kadāchana\n" + "na chāśhuśhruṣhave vāchyaṁ na cha māṁ yo ‘bhyasūtayi",R.color.trans));
        mData.add(new NewsItem("य इदं परमं गुह्यं मद्भक्तेष्वभिधास्यति |\n" + "भक्तिं मयि परां कृत्वा मामेवैष्यत्यसंशय: || 68||"," yaḥ—who; idam—this; paramam—most; guhyam—confidential knowledge; mat-bhakteṣhu—amongst my devotees; abhidhāsyati—teaches; bhaktim—greatest act of love; mayi—to me; parām—transcendental; kṛitvā—doing; mām—to me; eva—certainly; eṣhyati—comes; asanśhayaḥ—without doubt ","ya idaṁ paramaṁ guhyaṁ mad-bhakteṣhv abhidhāsyati\n" + "bhaktiṁ mayi parāṁ kṛitvā mām evaiṣhyaty asanśhayaḥ",R.color.trans));
        mData.add(new NewsItem("न च तस्मान्मनुष्येषु कश्चिन्मे प्रियकृत्तम: |\n" + "भविता न च मे तस्मादन्य: प्रियतरो भुवि || 69||"," na—no; cha—and; tasmāt—than them; manuṣhyeṣhu—amongst human beings; kaśhchit—anyone; me—to me; priya-kṛit-tamaḥ—more dear; bhavitā—will be; na—never; cha—and; me—to me; tasmāt—than them; anyaḥ—another; priya-taraḥ—dearer; bhuvi—on this earth ","na cha tasmān manuṣhyeṣhu kaśhchin me priya-kṛittamaḥ\n" + "bhavitā na cha me tasmād anyaḥ priyataro bhuvi",R.color.trans));
        mData.add(new NewsItem("अध्येष्यते च य इमं धर्म्यं संवादमावयो: |\n" + "ज्ञानयज्ञेन तेनाहमिष्ट: स्यामिति मे मति: || 70||"," adhyeṣhyate—study; cha—and; yaḥ—who; imam—this; dharmyam—sacred; saṁvādam—dialogue; āvayoḥ—of ours; jñāna—of knowledge; yajñena-tena—through the sacrifice of knowledge; aham—I; iṣhṭaḥ—worshipped; syām—shall be; iti—such; me—my; matiḥ—opinion ","adhyeṣhyate cha ya imaṁ dharmyaṁ saṁvādam āvayoḥ\n" + "jñāna-yajñena tenāham iṣhṭaḥ syām iti me matiḥ",R.color.trans));
        mData.add(new NewsItem("श्रद्धावाननसूयश्च शृणुयादपि यो नर: |\n" + "सोऽपि मुक्त: शुभाँल्लोकान्प्राप्नुयात्पुण्यकर्मणाम् || 71||"," śhraddhā-vān—faithful; anasūyaḥ—without envy; cha—and; śhṛiṇuyāt—listen; api—certainly; yaḥ—who; naraḥ—a person; saḥ—that person; api—also; muktaḥ—liberated; śhubhān—the auspicious; lokān—abodes; prāpnuyāt—attain; puṇya-karmaṇām—of the pious ","śhraddhāvān anasūyaśh cha śhṛiṇuyād api yo naraḥ\n" + "so ‘pi muktaḥ śhubhāl lokān prāpnuyāt puṇya-karmaṇām",R.color.trans));
        mData.add(new NewsItem("कच्चिदेतच्छ्रुतं पार्थ त्वयैकाग्रेण चेतसा |\n" + "कच्चिदज्ञानसम्मोह: प्रनष्टस्ते धनञ्जय || 72||"," kachchit—whether; etat—this; śhrutam—heard; pārtha—Arjun, the son of Pritha; tvayā—by you; eka-agreṇa chetasā—with a concentrated mind; kachchit—whether; ajñāna—ignorance; sammohaḥ—delusion; pranaṣhṭaḥ—destroyed; te—your; dhanañjaya—Arjun, conqueror of wealth ","kachchid etach chhrutaṁ pārtha tvayaikāgreṇa chetasā\n" + "kachchid ajñāna-sammohaḥ pranaṣhṭas te dhanañjaya",R.color.trans));
        mData.add(new NewsItem("अर्जुन उवाच |\n" + "नष्टो मोह: स्मृतिर्लब्धा त्वत्प्रसादान्मयाच्युत |\n" + "स्थितोऽस्मि गतसन्देह: करिष्ये वचनं तव || 73||"," arjunaḥ uvācha—Arjun said; naṣhṭaḥ—dispelled; mohaḥ—illusion; smṛitiḥ—memory; labdhā—regained; tvat-prasādāt—by your grace; mayā—by me; achyuta—Shree Krishna, the infallible one; sthitaḥ—situated; asmi—I am; gata-sandehaḥ—free from doubts; kariṣhye—I shall act; vachanam—instructions; tava—your ","arjuna uvācha\n" + "naṣhṭo mohaḥ smṛitir labdhā tvat-prasādān mayāchyuta\n" + "sthito ‘smi gata-sandehaḥ kariṣhye vachanaṁ tava",R.color.trans));
        mData.add(new NewsItem("सञ्जय उवाच |\n" + "इत्यहं वासुदेवस्य पार्थस्य च महात्मन: |\n" + "संवादमिममश्रौषमद्भुतं रोमहर्षणम् || 74||"," sañjayaḥ uvācha—Sanjay said; iti—thus; aham—I; vāsudevasya—of Shree Krishna; pārthasya—Arjun; cha—and; mahā-ātmanaḥ—the noble hearted soul; saṁvādam—conversation; imam—this; aśhrauṣham—have heard; adbhutam—wonderful; roma-harṣhaṇam—which causes the hair to stand on end ","sañjaya uvācha\n" + "ity ahaṁ vāsudevasya pārthasya cha mahātmanaḥ\n" + "saṁvādam imam aśhrauṣham adbhutaṁ roma-harṣhaṇam",R.color.trans));
        mData.add(new NewsItem("व्यासप्रसादाच्छ्रुतवानेतद्गुह्यमहं परम् |\n" + "योगं योगेश्वरात्कृष्णात्साक्षात्कथयत: स्वयम् || 75||"," vyāsa-prasādāt—by the grace of Ved Vyas; śhrutavān—have heard; etat—this; guhyam—secret; aham—I; param—supreme; yogam—Yog; yoga-īśhvarāt—from the Lod of Yog; kṛiṣhṇāt—from Shree Krishna; sākṣhāt—directly; kathayataḥ—speaking; svayam—himself ","vyāsa-prasādāch chhrutavān etad guhyam ahaṁ param\n" + "yogaṁ yogeśhvarāt kṛiṣhṇāt sākṣhāt kathayataḥ svayam",R.color.trans));
        mData.add(new NewsItem("राजन्संस्मृत्य संस्मृत्य संवादमिममद्भुतम् |\n" + "केशवार्जुनयो: पुण्यं हृष्यामि च मुहुर्मुहु: || 76||"," rājan—King; sansmṛitya saṁsmṛitya—repeatedly recalling; saṁvādam—dialogue; imam—this; adbhutam—astonishing; keśhava-arjunayoḥ—between Lord Shree Krishna and Arjun; puṇyam—pious; hṛiṣhyāmi—I rejoice; cha—and; muhuḥ muhuḥ—repeatedly ","rājan sansmṛitya sansmṛitya saṁvādam imam adbhutam\n" + "keśhavārjunayoḥ puṇyaṁ hṛiṣhyāmi cha muhur muhuḥ",R.color.trans));
        mData.add(new NewsItem("तच्च संस्मृत्य संस्मृत्य रूपमत्यद्भुतं हरे: |\n" + "विस्मयो मे महानराजन्हृष्यामि च पुन: पुन: || 77||"," tat—that; cha—and; sansmṛitya saṁsmṛitya—remembering repeatedly; rūpam—cosmic form; ati—most; adbhutam—wonderful; hareḥ—of Lord Krishna; vismayaḥ—astonishment; me—my; mahān—great; rājan—King; hṛiṣhyāmi—I am thrilled with joy; cha—and; punaḥ punaḥ—over and over again ","tach cha sansmṛitya saṁsmṛitya rūpam aty-adbhutaṁ hareḥ\n" + "vismayo ye mahān rājan hṛiṣhyāmi cha punaḥ punaḥ",R.color.trans));
        mData.add(new NewsItem("यत्र योगेश्वर: कृष्णो यत्र पार्थो धनुर्धर: |\n" + "तत्र श्रीर्विजयो भूतिध्रुवा नीतिर्मतिर्मम || 78||"," yatra—wherever; yoga-īśhvaraḥ—Shree Krishna, the Lord of Yog; kṛiṣhṇaḥ—Shree Krishna; yatra—wherever; pārthaḥ—Arjun, the son of Pritha; dhanuḥ-dharaḥ—the supreme archer; tatra—there; śhrīḥ—opulence; vijayaḥ—victory; bhūtiḥ—prosperity; dhruvā—unending; nītiḥ—righteousness; matiḥ mama—my opinion ","yatra yogeśhvaraḥ kṛiṣhṇo yatra pārtho dhanur-dharaḥ\n" + "tatra śhrīr vijayo bhūtir dhruvā nītir matir mama",R.color.trans));
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
                            Intent intent = new Intent(Vchp18.this, CloseActivity.class);
                            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                            startActivity(intent);                      }
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

            Intent myIntent = new Intent(this, Chp18.class);
            this.startActivity(myIntent);

        }

        if (id == R.id.verses){

         //   Intent myIntent = new Intent(this, Main2Activity.class);
         //   this.startActivity(myIntent);

        }

        if (id == R.id.explain){

            //   Intent myIntent = new Intent(this, Explaination.class);
            //   this.startActivity(myIntent);

            new FancyGifDialog.Builder(Vchp18.this)
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