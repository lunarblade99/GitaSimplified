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
import com.github.gitasimplified.chp.Chp13;
import com.shashank.sony.fancygifdialoglib.FancyGifDialog;
import com.shashank.sony.fancygifdialoglib.FancyGifDialogListener;

import java.util.ArrayList;
import java.util.List;

public class Vchp13 extends AppCompatActivity
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
        navigationView.getMenu().getItem(12).setChecked(true);

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
        mData.add(new NewsItem("अर्जुन उवाच |\n" + "प्रकृतिं पुरुषं चैव क्षेत्रं क्षेत्रज्ञमेव च |\n" + "एतद्वेदितुमिच्छामि ज्ञानं ज्ञेयं च केशव || 1||"," arjunaḥ uvācha—Arjun said; prakṛitim—material nature; puruṣham—the enjoyer; cha—and; eva—indeed; kṣhetram—the field of activities; kṣhetra-jñam—the knower of the field; eva—even; cha—also; etat—this; veditum—to know; ichchhāmi—I wish; jñānam—knowledge; jñeyam—the goal of knowledge; cha—and; keśhava—Krishna, the killer of the demon named Keshi ","arjuna uvācha\n" + "prakṛitiṁ puruṣhaṁ chaiva kṣhetraṁ kṣhetra-jñam eva cha\n" + "etad veditum ichchhāmi jñānaṁ jñeyaṁ cha keśhava",R.color.trans));
        mData.add(new NewsItem("श्रीभगवानुवाच |\n" + "इदं शरीरं कौन्तेय क्षेत्रमित्यभिधीयते |\n" + "एतद्यो वेत्ति तं प्राहु: क्षेत्रज्ञ इति तद्विद: || 2||"," śhrī-bhagavān uvācha—the Supreme Divine Lord said; idam—this; śharīram—body; kaunteya—Arjun, the son of Kunti; kṣhetram—the field of activities; iti—thus; abhidhīyate—is termed as; etat—this; yaḥ—one who; vetti—knows; tam—that person; prāhuḥ—is called; kṣhetra-jñaḥ—the knower of the field; iti—thus; tat-vidaḥ—those who discern the truth ","śhrī-bhagavān uvācha\n" + "idaṁ śharīraṁ kaunteya kṣhetram ity abhidhīyate\n" + "etad yo vetti taṁ prāhuḥ kṣhetra-jña iti tad-vidaḥ",R.color.trans));
        mData.add(new NewsItem("क्षेत्रज्ञं चापि मां विद्धि सर्वक्षेत्रेषु भारत |\n" + "क्षेत्रक्षेत्रज्ञयोर्ज्ञानं यत्तज्ज्ञानं मतं मम || 3||"," kṣhetra-jñam—the knower of the field; cha—also; api—only; mām—me; viddhi—know; sarva—all; kṣhetreṣhu—in individual fields of activities; bhārata—scion of Bharat; kṣhetra—the field of activities; kṣhetra-jñayoḥ—of the knower of the field; jñānam—understanding of; yat—which; tat—that; jñānam—knowledge; matam—opinion; mama—my ","kṣhetra-jñaṁ chāpi māṁ viddhi sarva-kṣhetreṣhu bhārata\n" + "kṣhetra-kṣhetrajñayor jñānaṁ yat taj jñānaṁ mataṁ mama",R.color.trans));
        mData.add(new NewsItem("तत्क्षेत्रं यच्च यादृक्च यद्विकारि यतश्च यत् |\n" + "स च यो यत्प्रभावश्च तत्समासेन मे शृणु || 4||"," tat—that; kṣhetram—field of activities; yat—what; cha—and; yādṛik—its nature; cha—and; yat-vikāri—how change takes place in it; yataḥ—from what; cha—also; yat—what; saḥ—he; cha—also; yaḥ—who; yat-prabhāvaḥ—what his powers are; cha—and; tat—that; samāsena—in summary; me—from me; śhṛiṇu—listen ","tat kṣhetraṁ yach cha yādṛik cha yad-vikāri yataśh cha yat\n" + "sa cha yo yat-prabhāvaśh cha tat samāsena me śhṛiṇu",R.color.trans));
        mData.add(new NewsItem("ऋषिभिर्बहुधा गीतं छन्दोभिर्विविधै: पृथक् |\n" + "ब्रह्मसूत्रपदैश्चैव हेतुमद्भिर्विनिश्चितै: || 5 ||"," ṛiṣhibhiḥ—by great sages; bahudhā—in manifold ways; gītam—sung; chhandobhiḥ—in Vedic hymns; vividhaiḥ—various; pṛithak—variously; brahma-sūtra—the Brahma Sūtra; padaiḥ—by the hymns; cha—and; eva—especially; hetu-madbhiḥ—with logic; viniśhchitaiḥ—conclusive evidence ","ṛiṣhibhir bahudhā gītaṁ chhandobhir vividhaiḥ pṛithak\n" + "brahma-sūtra-padaiśh chaiva hetumadbhir viniśhchitaiḥ",R.color.trans));
        mData.add(new NewsItem("महाभूतान्यङ्ककारो बुद्धिरव्यक्त मेव च |\n" + "इन्द्रियाणि दशैकं च पञ्च चेन्द्रियगोचरा: || 6||"," mahā-bhūtāni—the (five) great elements; ahankāraḥ—the ego; buddhiḥ—the intellect; avyaktam—the unmanifested primordial matter; eva—indeed; cha—and; indriyāṇi—the senses; daśha-ekam—eleven; cha—and; pañcha—five; cha—and; indriya-go-charāḥ—the (five) objects of the senses; ","mahā-bhūtāny ahankāro buddhir avyaktam eva cha\n" + "indriyāṇi daśhaikaṁ cha pañcha chendriya-gocharāḥ",R.color.trans));
        mData.add(new NewsItem("इच्छा द्वेष: सुखं दु:खं सङ्घातश्चेतना धृति: |\n" + "एतत्क्षेत्रं समासेन सविकारमुदाहृतम् || 7||"," ichchhā—desire; dveṣhaḥ—aversion; sukham—happiness; duḥkham—misery; saṅghātaḥ—the aggregate; chetanā—the consciousness; dhṛitiḥ—the will; etat—all these; kṣhetram—the field of activities; samāsena—comprise of; sa-vikāram—with modifications; udāhṛitam—are said ","ichchhā dveṣhaḥ sukhaṁ duḥkhaṁ saṅghātaśh chetanā dhṛitiḥ\n" + "etat kṣhetraṁ samāsena sa-vikāram udāhṛitam",R.color.trans));
        mData.add(new NewsItem("अमानित्वमदम्भित्वमहिंसा क्षान्तिरार्जवम् |\n" + "आचार्योपासनं शौचं स्थैर्यमात्मविनिग्रह: || 8||\n" + "इन्द्रियार्थेषु वैराग्यमनहङ्कार एव च |\n" + "जन्ममृत्युजराव्याधिदु:खदोषानुदर्शनम् || 9||\n" + "असक्तिरनभिष्वङ्ग: पुत्रदारगृहादिषु |\n" + "नित्यं च समचित्तत्वमिष्टानिष्टोपपत्तिषु || 10||\n" + "मयि चानन्ययोगेन भक्तिरव्यभिचारिणी |\n" + "विविक्तदेशसेवित्वमरतिर्जनसंसदि || 11||\n" + "अध्यात्मज्ञाननित्यत्वं तत्वज्ञानार्थदर्शनम् |\n" + "एतज्ज्ञानमिति प्रोक्तमज्ञानं यदतोऽन्यथा || 12||"," amānitvam—humbleness; adambhitvam—freedom from hypocrisy; ahinsā—non-violence; kṣhāntiḥ—forgiveness; ārjavam—simplicity; āchārya-upāsanam—service of the Guru; śhaucham—cleanliness of body and mind; sthairyam—steadfastness; ātma-vinigrahaḥ—self-control; indriya-artheṣhu—toward objects of the senses; vairāgyam—dispassion; anahankāraḥ—absence of egotism; eva cha—and also; janma—of birth; mṛityu—death; jarā—old age; vyādhi—disease; duḥkha—evils; doṣha—faults; anudarśhanam—perception; asaktiḥ—non-attachment; anabhiṣhvaṅgaḥ—absence of craving; putra—children; dāra—spouse; gṛiha-ādiṣhu—home, etc; nityam—constant; cha—and; sama-chittatvam—even-mindedness; iṣhṭa—the desirable; aniṣhṭa—undesirable; upapattiṣhu—having obtained; mayi—toward Me; cha—also; ananya-yogena—exclusively united; bhaktiḥ—devotion; avyabhichāriṇī—constant; vivikta—solitary; deśha—places; sevitvam—inclination for; aratiḥ—aversion; jana-sansadi—for mundane society; adhyātma—spiritual; jñāna—knowledge; nityatvam—constancy; tattva-jñāna—knowledge of spiritual principles; artha—for; darśhanam—philosophy; etat—all this; jñānam—knowledge; iti—thus; proktam—declared; ajñānam—ignorance; yat—what; ataḥ—to this; anyathā—contrary ","amānitvam adambhitvam ahinsā kṣhāntir ārjavam\n" + "āchāryopāsanaṁ śhauchaṁ sthairyam ātma-vinigrahaḥ\n" + "indriyārtheṣhu vairāgyam anahankāra eva cha\n" + "janma-mṛityu-jarā-vyādhi-duḥkha-doṣhānudarśhanam\n" + "asaktir anabhiṣhvaṅgaḥ putra-dāra-gṛihādiṣhu\n" + "nityaṁ cha sama-chittatvam iṣhṭāniṣhṭopapattiṣhu\n" + "mayi chānanya-yogena bhaktir avyabhichāriṇī\n" + "vivikta-deśha-sevitvam aratir jana-sansadi\n" + "adhyātma-jñāna-nityatvaṁ tattva-jñānārtha-darśhanam\n" + "etaj jñānam iti proktam ajñānaṁ yad ato ’nyathā",R.color.trans));
        mData.add(new NewsItem("ज्ञेयं यत्तत्प्रवक्ष्यामि यज्ज्ञात्वामृतमश्रुते |\n" + "अनादिमत्परं ब्रह्म न सत्तन्नासदुच्यते || 13||"," jñeyam—ought to be known; yat—which; tat—that; pravakṣhyāmi—I shall now reveal; yat—which; jñātvā—knowing; amṛitam—immortality; aśhnute—one achieves; anādi—beginningless; mat-param—subordinate to Me; brahma—Brahman; na—not; sat—existent; tat—that; na—not; asat—non-existent; uchyate—is called ","jñeyaṁ yat tat pravakṣhyāmi yaj jñātvāmṛitam aśhnute\n" + "anādi mat-paraṁ brahma na sat tan nāsad uchyate",R.color.trans));
        mData.add(new NewsItem("सर्वत: पाणिपादं तत्सर्वतोऽक्षिशिरोमुखम् |\n" + "सर्वत: श्रुतिमल्लोके सर्वमावृत्य तिष्ठति || 14||"," sarvataḥ—everywhere; pāṇi—hands; pādam—feet; tat—that; sarvataḥ—everywhere; akṣhi—eyes; śhiraḥ—heads; mukham—faces; sarvataḥ—everywhere; śhruti-mat—having ears; loke—in the universe; sarvam—everything; āvṛitya—pervades; tiṣhṭhati—exists ","sarvataḥ pāṇi-pādaṁ tat sarvato ’kṣhi-śhiro-mukham\n" + "sarvataḥ śhrutimal loke sarvam āvṛitya tiṣhṭhati",R.color.trans));
        mData.add(new NewsItem("सर्वेन्द्रियगुणाभासं सर्वेन्द्रियविवर्जितम् |\n" + "असक्तं सर्वभृच्चैव निर्गुणं गुणभोक्तृ च || 15||"," sarva—all; indriya—senses; guṇa—sense-objects; ābhāsam—the perciever; sarva—all; indriya—senses; vivarjitam—devoid of; asaktam—unattached; sarva-bhṛit—the sustainer of all; cha—yet; eva—indeed; nirguṇam—beyond the three modes of material nature; guṇa-bhoktṛi—the enjoyer of the three modes of material nature; cha—although ","sarvendriya-guṇābhāsaṁ sarvendriya-vivarjitam\n" + "asaktaṁ sarva-bhṛich chaiva nirguṇaṁ guṇa-bhoktṛi cha",R.color.trans));
        mData.add(new NewsItem("बहिरन्तश्च भूतानामचरं चरमेव च |\n" + "सूक्ष्मत्वात्तदविज्ञेयं दूरस्थं चान्तिके च तत् || 16||"," bahiḥ—outside; antaḥ—inside; cha—and; bhūtānām—all living beings; acharam—not moving; charam—moving; eva—indeed; cha—and; sūkṣhmatvāt—due to subtlety; tat—he; avijñeyam—incomprehensible; dūra-stham—very far away; cha—and; antike—very near; cha—also; tat—He ","bahir antaśh cha bhūtānām acharaṁ charam eva cha\n" + "sūkṣhmatvāt tad avijñeyaṁ dūra-sthaṁ chāntike cha tat",R.color.trans));
        mData.add(new NewsItem("अविभक्तं च भूतेषु विभक्तमिव च स्थितम् |\n" + "भूतभर्तृ च तज्ज्ञेयं ग्रसिष्णु प्रभविष्णु च || 17||"," avibhaktam—indivisible; cha—although; bhūteṣhu—amongst living beings; vibhaktam—divided; iva—apparently; cha—yet; sthitam—situated; bhūta-bhartṛi—the Sustainer of all beings; cha—also; tat—that; jñeyam—to be known; grasiṣhṇu—the Annihilator; prabhaviṣhṇu—the Creator; cha—and ","avibhaktaṁ cha bhūteṣhu vibhaktam iva cha sthitam\n" + "bhūta-bhartṛi cha taj jñeyaṁ grasiṣhṇu prabhaviṣhṇu cha",R.color.trans));
        mData.add(new NewsItem("ज्योतिषामपि तज्ज्योतिस्तमस: परमुच्यते |\n" + "ज्ञानं ज्ञेयं ज्ञानगम्यं हृदि सर्वस्य विष्ठितम् || 18||"," jyotiṣhām—in all luminarie; api—and; tat—that; jyotiḥ—the source of light; tamasaḥ—the darkness; param—beyond; uchyate—is said (to be); jñānam—knowledge; jñeyam—the object of knowledge; jñāna-gamyam—the goal of knowledge; hṛidi—within the heart; sarvasya—of all living beings; viṣhṭhitam—dwells ","jyotiṣhām api taj jyotis tamasaḥ param uchyate\n" + "jñānaṁ jñeyaṁ jñāna-gamyaṁ hṛidi sarvasya viṣhṭhitam",R.color.trans));
        mData.add(new NewsItem("इति क्षेत्रं तथा ज्ञानं ज्ञेयं चोक्तं समासत: |\n" + "मद्भक्त एतद्विज्ञाय मद्भावायोपपद्यते || 19||"," iti—thus; kṣhetram—the nature of the field; tathā—and; jñānam—the meaning of knowledge; jñeyam—the object of knowledge; cha—and; uktam—revealed; samāsataḥ—in summary; mat-bhaktaḥ—My devotee; etat—this; vijñāya—having understood; mat-bhāvāya—My divine nature; upapadyate—attain ","iti kṣhetraṁ tathā jñānaṁ jñeyaṁ choktaṁ samāsataḥ\n" + "mad-bhakta etad vijñāya mad-bhāvāyopapadyate",R.color.trans));
        mData.add(new NewsItem("प्रकृतिं पुरुषं चैव विद्ध्यनादी उभावपि |\n" + "विकारांश्च गुणांश्चैव विद्धि प्रकृतिसम्भवान् || 20||"," prakṛitim—material nature; puruṣham—the individual souls; cha—and; eva—indeed; viddhi—know; anādī—beginningless; ubhau—both; api—and; vikārān—transformations (of the body); cha—also; guṇān—the three modes of nature; cha—and; eva—indeed; viddhi—know; prakṛiti—material energy; sambhavān—produced by ","prakṛitiṁ puruṣhaṁ chaiva viddhy anādī ubhāv api\n" + "vikārānśh cha guṇānśh chaiva viddhi prakṛiti-sambhavān",R.color.trans));
        mData.add(new NewsItem("कार्यकारणकर्तृत्वे हेतु: प्रकृतिरुच्यते |\n" + "पुरुष: सुखदु:खानां भोक्तृत्वे हेतुरुच्यते || 21||"," kārya—effect; kāraṇa—cause; kartṛitve—in the matter of creation; hetuḥ—the medium; prakṛitiḥ—the material energy; uchyate—is said to be; puruṣhaḥ—the individual soul; sukha-duḥkhānām—of happiness and distress; bhoktṛitve—in experiencing; hetuḥ—is responsible; uchyate—is said to be ","kārya-kāraṇa-kartṛitve hetuḥ prakṛitir uchyate\n" + "puruṣhaḥ sukha-duḥkhānāṁ bhoktṛitve hetur uchyate",R.color.trans));
        mData.add(new NewsItem("पुरुष: प्रकृतिस्थो हि भुङक्ते प्रकृतिजान्गुणान् |\n" + "कारणं गुणसङ्गोऽस्य सदसद्योनिजन्मसु || 22||"," puruṣhaḥ—the individual soul; prakṛiti-sthaḥ—seated in the material energy; hi—indeed; bhuṅkte—desires to enjoy; prakṛiti-jān—produced by the material energy; guṇān—the three modes of nature; kāraṇam—the cause; guṇa-saṅgaḥ—the attachment (to three guṇas); asya—of its; sat-asat-yoni—in superior and inferior wombs; janmasu—of birth ","puruṣhaḥ prakṛiti-stho hi bhuṅkte prakṛiti-jān guṇān\n" + "kāraṇaṁ guṇa-saṅgo ’sya sad-asad-yoni-janmasu",R.color.trans));
        mData.add(new NewsItem("उपद्रष्टानुमन्ता च भर्ता भोक्ता महेश्वर: |\n" + "परमात्मेति चाप्युक्तो देहेऽस्मिन्पुरुष: पर: || 23||"," upadraṣhṭā—the Witness; anumantā—the Permitter; cha—and; bhartā—the Supporter; bhoktā—the Transcendental Enjoyer; mahā-īśhvaraḥ—the ultimate Controller; parama-ātmā—Superme Soul; iti—that; cha api—and also; uktaḥ—is said; dehe—within the body; asmin—this; puruṣhaḥ paraḥ—the Supreme Lord ","upadraṣhṭānumantā cha bhartā bhoktā maheśhvaraḥ\n" + "paramātmeti chāpy ukto dehe ’smin puruṣhaḥ paraḥ",R.color.trans));
        mData.add(new NewsItem("य एवं वेत्ति पुरुषं प्रकृतिं च गुणै: सह |\n" + "सर्वथा वर्तमानोऽपि न स भूयोऽभिजायते || 24||"," yaḥ—who; evam—thus; vetti—understand; puruṣham—Puruṣh; prakṛitim—the material nature; cha—and; guṇaiḥ—the three modes of nature; saha—with; sarvathā—in every way; vartamānaḥ—situated; api—although; na—not; saḥ—they; bhūyaḥ—again; abhijāyate—take birth ","ya evaṁ vetti puruṣhaṁ prakṛitiṁ cha guṇaiḥ saha\n" + "sarvathā vartamāno ’pi na sa bhūyo ’bhijāyate",R.color.trans));
        mData.add(new NewsItem("ध्यानेनात्मनि पश्यन्ति केचिदात्मानमात्मना |\n" + "अन्ये साङ् ख्येन योगेन कर्मयोगेन चापरे || 25||"," dhyānena—through meditation; ātmani—within one’s heart; paśhyanti—percieve; kechit—some; ātmānam—the Supreme soul; ātmanā—by the mind; anye—others; sānkhyena—through cultivation of knowledge; yogena—the yog system; karma-yogena—union with God with through path of action; cha—and; apare—others ","dhyānenātmani paśhyanti kechid ātmānam ātmanā\n" + "anye sānkhyena yogena karma-yogena chāpare",R.color.trans));
        mData.add(new NewsItem("अन्ये त्वेवमजानन्त: श्रुत्वान्येभ्य उपासते |\n" + "तेऽपि चातितरन्त्येव मृत्युं श्रुतिपरायणा: || 26||"," anye—others; tu—still; evam—thus; ajānantaḥ—those who are unaware (of spiritual paths); śhrutvā—by hearing; anyebhyaḥ—from others; upāsate—begin to worship; te—they; api—also; cha—and; atitaranti—cross over; eva—even; mṛityum—death; śhruti-parāyaṇāḥ—devotion to hearing (from saints) ","anye tv evam ajānantaḥ śhrutvānyebhya upāsate\n" + "te ’pi chātitaranty eva mṛityuṁ śhruti-parāyaṇāḥ",R.color.trans));
        mData.add(new NewsItem("यावत्सञ्जायते किञ्चित्सत्वं स्थावरजङ्गमम् |\n" + "क्षेत्रक्षेत्रज्ञसंयोगात्तद्विद्धि भरतर्षभ || 27||"," yāvat—whatever; sañjāyate—manifesting; kiñchit—anything; sattvam—being; sthāvara—unmoving; jaṅgamam—moving; kṣhetra—field of activities; kṣhetra-jña—knower of the field; sanyogāt—combination of; tat—that; viddhi—know; bharata-ṛiṣhabha—best of the Bharatas ","yāvat sañjāyate kiñchit sattvaṁ sthāvara-jaṅgamam\n" + "kṣhetra-kṣhetrajña-sanyogāt tad viddhi bharatarṣhabha",R.color.trans));
        mData.add(new NewsItem("समं सर्वेषु भूतेषु तिष्ठन्तं परमेश्वरम् |\n" + "विनश्यत्स्वविनश्यन्तं य: पश्यति स पश्यति || 28||"," samam—equally; sarveṣhu—in all; bhūteṣhu—beings; tiṣhṭhan-tam—accompanying; parama-īśhvaram—Supreme Soul; vinaśhyatsu—amongst the perishable; avinaśhyantam—the imperishable; yaḥ—who; paśhyati—see; saḥ—they; paśhyati—perceive ","samaṁ sarveṣhu bhūteṣhu tiṣhṭhantaṁ parameśhvaram\n" + "vinaśhyatsv avinaśhyantaṁ yaḥ paśhyati sa paśhyati",R.color.trans));
        mData.add(new NewsItem("समं पश्यन्हि सर्वत्र समवस्थितमीश्वरम् |\n" + "न हिनस्त्यात्मनात्मानं ततो याति परां गतिम् || 29||"," samam—equally; paśhyan—see; hi—indeed; sarvatra—everywhere; samavasthitam—equally present; īśhvaram—God as the Supreme soul; na—do not; hinasti—degrade; ātmanā—by one’s mind; ātmānam—the self; tataḥ—thereby; yāti—reach; parām—the supreme; gatim—destination ","samaṁ paśhyan hi sarvatra samavasthitam īśhvaram\n" + "na hinasty ātmanātmānaṁ tato yāti parāṁ gatim",R.color.trans));
        mData.add(new NewsItem("प्रकृत्यैव च कर्माणि क्रियमाणानि सर्वश: |\n" + "य: पश्यति तथात्मानमकर्तारं स पश्यति || 30||"," prakṛityā—by material nature; eva—truly; cha—also; karmāṇi—actions; kriyamāṇāni—are performed; sarvaśhaḥ—all; yaḥ—who; paśhyati—see; tathā—also; ātmānam—(embodied) soul; akartāram—actionless; saḥ—they; paśhyati—see ","prakṛityaiva cha karmāṇi kriyamāṇāni sarvaśhaḥ\n" + "yaḥ paśhyati tathātmānam akartāraṁ sa paśhyati",R.color.trans));
        mData.add(new NewsItem("यदा भूतपृथग्भावमेकस्थमनुपश्यति |\n" + "तत एव च विस्तारं ब्रह्म सम्पद्यते तदा || 31||"," yadā—when; bhūta—living entities; pṛithak-bhāvam—diverse variety; eka-stham—situated in the same place; anupaśhyati—see; tataḥ—thereafter; eva—indeed; cha—and; vistāram—born from; brahma—Brahman; sampadyate—(they) attain; tadā—then ","yadā bhūta-pṛithag-bhāvam eka-stham anupaśhyati\n" + "tata eva cha vistāraṁ brahma sampadyate tadā",R.color.trans));
        mData.add(new NewsItem("अनादित्वान्निर्गुणत्वात्परमात्मायमव्यय: |\n" + "शरीरस्थोऽपि कौन्तेय न करोति न लिप्यते || 32||"," anāditvāt—being without beginning; nirguṇatvāt—being devoid of any material qualities; parama—the Supreme; ātmā—soul; ayam—this; avyayaḥ—imperishable; śharīra-sthaḥ—dwelling in the body; api—although; kaunteya—Arjun, the the son of Kunti; na—neither; karoti—acts; na—nor; lipyate—is tainted ","anāditvān nirguṇatvāt paramātmāyam avyayaḥ\n" + "śharīra-stho ’pi kaunteya na karoti na lipyate",R.color.trans));
        mData.add(new NewsItem("यथा सर्वगतं सौक्ष्म्यादाकाशं नोपलिप्यते |\n" + "सर्वत्रावस्थितो देहे तथात्मा नोपलिप्यते || 33||"," yathā—as; sarva-gatam—all-pervading; saukṣhmyāt—due to subtlety; ākāśham—the space; na—not; upalipyate—is contaminated; sarvatra—everywhere; avasthitaḥ—situated; dehe—the body; tathā—similarly; ātmā—the soul; na—not; upalipyate—is contaminated ","yathā sarva-gataṁ saukṣhmyād ākāśhaṁ nopalipyate\n" + "sarvatrāvasthito dehe tathātmā nopalipyate",R.color.trans));
        mData.add(new NewsItem("यथा प्रकाशयत्येक: कृत्स्नं लोकमिमं रवि: |\n" + "क्षेत्रं क्षेत्री तथा कृत्स्नं प्रकाशयति भारत || 34||"," yathā—as; prakāśhayati—illumines; ekaḥ—one; kṛitsnam—entire; lokam—solar system; imam—this; raviḥ—sun; kṣhetram—the body; kṣhetrī—the soul; tathā—so; kṛitsnam—entire; prakāśhayati—illumine; bhārata—Arjun, the son of Bharat ","yathā prakāśhayaty ekaḥ kṛitsnaṁ lokam imaṁ raviḥ\n" + "kṣhetraṁ kṣhetrī tathā kṛitsnaṁ prakāśhayati bhārata",R.color.trans));
        mData.add(new NewsItem("क्षेत्रक्षेत्रज्ञयोरेवमन्तरं ज्ञानचक्षुषा |\n" + "भूतप्रकृतिमोक्षं च ये विदुर्यान्ति ते परम् || 35||"," kṣhetra—the body; kṣhetra-jñayoḥ—of the knower of the body; evam—thus; antaram—the difference; jñāna-chakṣhuṣhā—with the eyes of knowledge; bhūta—the living entity; prakṛiti-mokṣham—release from material nature; cha—and; ye—who; viduḥ—know; yānti—approach; te—they; param—the Supreme ","kṣhetra-kṣhetrajñayor evam antaraṁ jñāna-chakṣhuṣhā\n" + "bhūta-prakṛiti-mokṣhaṁ cha ye vidur yānti te param",R.color.trans));


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
                            Intent intent = new Intent(Vchp13.this, CloseActivity.class);
                            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                            startActivity(intent);                       }
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

            Intent myIntent = new Intent(this, Chp13.class);
            this.startActivity(myIntent);

        }

        if (id == R.id.verses){

         //   Intent myIntent = new Intent(this, Main2Activity.class);
         //   this.startActivity(myIntent);

        }

        if (id == R.id.explain){

            //   Intent myIntent = new Intent(this, Explaination.class);
            //   this.startActivity(myIntent);

            new FancyGifDialog.Builder(Vchp13.this)
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