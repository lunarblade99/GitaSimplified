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
import com.github.gitasimplified.chp.Chp12;
import com.shashank.sony.fancygifdialoglib.FancyGifDialog;
import com.shashank.sony.fancygifdialoglib.FancyGifDialogListener;

import java.util.ArrayList;
import java.util.List;

public class Vchp12 extends AppCompatActivity
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
        navigationView.getMenu().getItem(11).setChecked(true);

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
        mData.add(new NewsItem("अर्जुन उवाच |\n" + "एवं सततयुक्ता ये भक्तास्त्वां पर्युपासते |\n" + "ये चाप्यक्षरमव्यक्तं तेषां के योगवित्तमा: || 1||"," arjunaḥ uvācha—Arjun said; evam—thus; satata—steadfastly; yuktāḥ—devoted; ye—those; bhaktāḥ—devotees; tvām—you; paryupāsate—worship; ye—those; cha—and; api—also; akṣharam—the imperishable; avyaktam—the formless Brahman; teṣhām—of them; ke—who; yoga-vit-tamāḥ—more perfect in Yog ","arjuna uvācha\n" + "evaṁ satata-yuktā ye bhaktās tvāṁ paryupāsate\n" + "ye chāpy akṣharam avyaktaṁ teṣhāṁ ke yoga-vittamāḥ",R.color.trans));
        mData.add(new NewsItem("श्रीभगवानुवाच |\n" + "मय्यावेश्य मनो ये मां नित्ययुक्ता उपासते |\n" + "श्रद्धया परयोपेतास्ते मे युक्ततमा मता: || 2||"," śhrī-bhagavān uvācha—the Blessed Lord said; mayi—on Me; āveśhya—fix; manaḥ—the mind; ye—those; mām—Me; nitya yuktāḥ—always engaged; upāsate—worship; śhraddhayā—with faith; parayā—best; upetāḥ—endowed; te—they; me—by Me; yukta-tamāḥ—situated highest in Yog; matāḥ—I consider ","śhrī-bhagavān uvācha\n" + "mayy āveśhya mano ye māṁ nitya-yuktā upāsate\n" + "śhraddhayā parayopetās te me yuktatamā matāḥ",R.color.trans));
        mData.add(new NewsItem("ये त्वक्षरमनिर्देश्यमव्यक्तं पर्युपासते |\n" + "सर्वत्रगमचिन्त्यञ्च कूटस्थमचलन्ध्रुवम् || 3||\n" + "सन्नियम्येन्द्रियग्रामं सर्वत्र समबुद्धय: |\n" + "ते प्राप्नुवन्ति मामेव सर्वभूतहिते रता: || 4||"," ye—who; tu—but; akṣharam—the imperishable; anirdeśhyam—the indefinable; avyaktam—the unmanifest; paryupāsate—worship; sarvatra-gam—the all-pervading; achintyam—the unthinkable; cha—and; kūṭa-stham—the unchanging; achalam—the immovable; dhruvam—the eternal; sanniyamya—restraining; indriya-grāmam—the senses; sarvatra—everywhere; sama-buddhayaḥ—even-minded; te—they; prāpnuvanti—attain; mām—Me; eva—also; sarva-bhūta-hite—in the welfare of all beings; ratāḥ—engaged ","ye tv akṣharam anirdeśhyam avyaktaṁ paryupāsate\n" + "sarvatra-gam achintyañcha kūṭa-stham achalandhruvam\n" + "sanniyamyendriya-grāmaṁ sarvatra sama-buddhayaḥ\n" + "te prāpnuvanti mām eva sarva-bhūta-hite ratāḥ",R.color.trans));
        mData.add(new NewsItem("क्लेशोऽधिकतरस्तेषामव्यक्तासक्तचेतसाम् ||\n" + "अव्यक्ता हि गतिर्दु:खं देहवद्भिरवाप्यते || 5||"," kleśhaḥ—tribulations; adhika-taraḥ—full of; teṣhām—of those; avyakta—to the unmanifest; āsakta—attached; chetasām—whose minds; avyaktā—the unmanifest; hi—indeed; gatiḥ—path; duḥkham—exceeding difficulty; deha-vadbhiḥ—for the embodied; avāpyate—is reached ","kleśho ’dhikataras teṣhām avyaktāsakta-chetasām\n" + "avyaktā hi gatir duḥkhaṁ dehavadbhir avāpyate",R.color.trans));
        mData.add(new NewsItem("ये तु सर्वाणि कर्माणि मयि संन्न्यस्य मत्पर: |\n" + "अनन्येनैव योगेन मां ध्यायन्त उपासते || 6||\n" + "तेषामहं समुद्धर्ता मृत्युसंसारसागरात् |\n" + "भवामि नचिरात्पार्थ मय्यावेशितचेतसाम् || 7||"," ye—who; tu—but; sarvāṇi—all; karmāṇi—actions; mayi—to Me; sannyasya—dedicating; mat-paraḥ—regarding Me as the Supreme goal; ananyena—exclusively; eva—certainly; yogena—with devotion; mām—Me; dhyāyantaḥ—meditating; upāsate—worship; teṣhām—of those; aham—I; samuddhartā—the deliverer; mṛityu-saṁsāra-sāgarāt—from the ocean of birth and death; bhavāmi—(I) become; na—not; chirāt—after a long time; pārtha—Arjun, the son of Pritha; mayi—with Me; āveśhita chetasām—of those whose consciousness is united ","ye tu sarvāṇi karmāṇi mayi sannyasya mat-paraḥ\n" + "ananyenaiva yogena māṁ dhyāyanta upāsate\n" + "teṣhām ahaṁ samuddhartā mṛityu-saṁsāra-sāgarāt\n" + "bhavāmi na chirāt pārtha mayy āveśhita-chetasām",R.color.trans));
        mData.add(new NewsItem("मय्येव मन आधत्स्व मयि बुद्धिं निवेशय |\n" + "निवसिष्यसि मय्येव अत ऊर्ध्वं न संशय: || 8||"," mayi—on Me; eva—alone; manaḥ—mind; ādhatsva—fix; mayi—on Me; buddhim—intellect; niveśhaya—surrender; nivasiṣhyasi—you shall always live; mayi—in Me; eva—alone; ataḥ ūrdhvam—thereafter; na—not; sanśhayaḥ—doubt ","mayy eva mana ādhatsva mayi buddhiṁ niveśhaya\n" + "nivasiṣhyasi mayy eva ata ūrdhvaṁ na sanśhayaḥ",R.color.trans));
        mData.add(new NewsItem("अथ चित्तं समाधातुं न शक्नोषि मयि स्थिरम् |\n" + "अभ्यासयोगेन ततो मामिच्छाप्तुं धनञ्जय || 9||"," atha—if; chittam—mind; samādhātum—to fix; na śhaknoṣhi—(you) are unable; mayi—on Me; sthiram—steadily; abhyāsa-yogena—by uniting with God through repeated practice; tataḥ—then; mām—me; ichchhā—desire; āptum—to attain; dhanañjaya—Arjun, the conqueror of wealth ","atha chittaṁ samādhātuṁ na śhaknoṣhi mayi sthiram\n" + "abhyāsa-yogena tato mām ichchhāptuṁ dhanañjaya",R.color.trans));
        mData.add(new NewsItem("अभ्यासेऽप्यसमर्थोऽसि मत्कर्मपरमो भव |\n" + "मदर्थमपि कर्माणि कुर्वन्सिद्धिमवाप्स्यसि || 10||"," abhyāse—in practice; api—if; asamarthaḥ—unable; asi—you; mat-karma paramaḥ—devotedly work for Me; bhava—be; mat-artham—for My sake; api—also; karmāṇi—work; kurvan—performing; siddhim—perfection; avāpsyasi—you shall achieve ","abhyāse ’py asamartho ’si mat-karma-paramo bhava\n" + "mad-artham api karmāṇi kurvan siddhim avāpsyasi",R.color.trans));
        mData.add(new NewsItem("अथैतदप्यशक्तोऽसि कर्तुं मद्योगमाश्रित: |\n" + "सर्वकर्मफलत्यागं तत: कुरु यतात्मवान् || 11||"," atha—if; etat—this; api—even; aśhaktaḥ—unable; asi—you are; kartum—to work; mad-yogam—with devotion to Me; āśhritaḥ—taking refuge; sarva-karma—of all actions; phala-tyāgam—to renounce the fruits; tataḥ—then; kuru—do; yata-ātma-vān—be situated in the self ","athaitad apy aśhakto ’si kartuṁ mad-yogam āśhritaḥ\n" + "sarva-karma-phala-tyāgaṁ tataḥ kuru yatātmavān",R.color.trans));
        mData.add(new NewsItem("श्रेयो हि ज्ञानमभ्यासाज्ज्ञानाद्ध्यानं विशिष्यते |"," śhreyaḥ—better; hi—for; jñānam—knowledge; abhyāsāt—than (mechanical) practice; jñānāt—than knowledge; dhyānam—meditation; viśhiṣhyate—better; dhyānāt—than meditation; karma-phala-tyāgaḥ—renunciation of the fruits of actions; tyāgāt—renunciation; śhāntiḥ—peace; anantaram—immediately ","śhreyo hi jñānam abhyāsāj jñānād dhyānaṁ viśhiṣhyate\n" + "dhyānāt karma-phala-tyāgas tyāgāch chhāntir anantaram",R.color.trans));
        mData.add(new NewsItem("अद्वेष्टा सर्वभूतानां मैत्र: करुण एव च |\n" + "निर्ममो निरहङ्कार: समदु:खसुख: क्षमी || 13||\n" + "सन्तुष्ट: सततं योगी यतात्मा दृढनिश्चय: |\n" + "मय्यर्पितमनोबुद्धिर्यो मद्भक्त: स मे प्रिय: || 14||"," adveṣhṭā—free from malice; sarva-bhūtānām—toward all living beings; maitraḥ—friendly; karuṇaḥ—compassionate; eva—indeed; cha—and; nirmamaḥ—free from attachment to possession; nirahankāraḥ—free from egoism; sama—equipoised; duḥkha—distress; sukhaḥ—happiness; kṣhamī—forgiving; santuṣhṭaḥ—contented; satatam—steadily; yogī—united in devotion; yata-ātmā—self-controlled; dṛiḍha-niśhchayaḥ—firm in conviction; mayi—to me; arpita—dedicated; manaḥ—mind; buddhiḥ—intellect; yaḥ—who; mat-bhaktaḥ—My devotees; saḥ—they; me—to Me; priyaḥ—very dear ","\n" + "\n" + "adveṣhṭā sarva-bhūtānāṁ maitraḥ karuṇa eva cha\n" + "nirmamo nirahankāraḥ sama-duḥkha-sukhaḥ kṣhamī\n" + "\n" + "santuṣhṭaḥ satataṁ yogī yatātmā dṛiḍha-niśhchayaḥ\n" + "mayy arpita-mano-buddhir yo mad-bhaktaḥ sa me priyaḥ\n",R.color.trans));
        mData.add(new NewsItem("यस्मान्नोद्विजते लोको लोकान्नोद्विजते च य: |\n" + "हर्षामर्षभयोद्वेगैर्मुक्तो य: स च मे प्रिय: || 15||"," yasmāt—by whom; na—not; udvijate—are agitated; lokaḥ—people; lokāt—from people; na—not; udvijate—are disturbed; cha—and; yaḥ—who; harṣha—pleasure; amarṣha—pain; bhaya—fear; udvegaiḥ—anxiety; muktaḥ—freed; yaḥ—who; saḥ—they; cha—and; me—to Me; priyaḥ—very dear ","yasmān nodvijate loko lokān nodvijate cha yaḥ\n" + "harṣhāmarṣha-bhayodvegair mukto yaḥ sa cha me priyaḥ",R.color.trans));
        mData.add(new NewsItem("अनपेक्ष: शुचिर्दक्ष उदासीनो गतव्यथ: |\n" + "सर्वारम्भपरित्यागी यो मद्भक्त: स मे प्रिय: || 16||"," anapekṣhaḥ—indifferent to worldly gain; śhuchiḥ—pure; dakṣhaḥ—skillful; udāsīnaḥ—without cares; gata-vyathaḥ—untroubled; sarva-ārambha—of all undertakings; parityāgī—renouncer; saḥ—who; mat-bhaktaḥ—My devotee; saḥ—he; me—to Me; priyaḥ—very dear ","anapekṣhaḥ śhuchir dakṣha udāsīno gata-vyathaḥ\n" + "sarvārambha-parityāgī yo mad-bhaktaḥ sa me priyaḥ",R.color.trans));
        mData.add(new NewsItem("यो न हृष्यति न द्वेष्टि न शोचति न काङ् क्षति |\n" + "शुभाशुभपरित्यागी भक्तिमान्य: स मे प्रिय: || 17||"," yaḥ—who; na—neither; hṛiṣhyati—rejoice; na—nor; dveṣhṭi—despair; na—neither; śhochati—lament; na—nor; kāṅkṣhati—hanker for gain; śhubha-aśhubha-parityāgī—who renounce both good and evil deeds; bhakti-mān—full of devotion; yaḥ—who; saḥ—that person; me—to Me; priyaḥ—very dear ","yo na hṛiṣhyati na dveṣhṭi na śhochati na kāṅkṣhati\n" + "śhubhāśhubha-parityāgī bhaktimān yaḥ sa me priyaḥ",R.color.trans));
        mData.add(new NewsItem("सम: शत्रौ च मित्रे च तथा मानापमानयो: |\n" + "शीतोष्णसुखदु:खेषु सम: सङ्गविवर्जित: || 18||\n" + "तुल्यनिन्दास्तुतिर्मौनी सन्तुष्टो येन केनचित् |\n" + "अनिकेत: स्थिरमतिर्भक्तिमान्मे प्रियो नर: || 19||"," samaḥ—alike; śhatrau—to a foe; cha—and; mitre—to a friend; cha tathā—as well as; māna-apamānayoḥ—in honor and dishonor; śhīta-uṣhṇa—in cold and heat; sukha-duḥkheṣhu—in joy and sorrow; samaḥ—equipoised; saṅga-vivarjitaḥ—free from all unfavorable association; tulya—alike; nindā-stutiḥ—reproach and praise; maunī—silent contemplation; santuṣhṭaḥ—contented; yena kenachit—with anything; aniketaḥ—without attachment to the place of residence; sthira—firmly fixed; matiḥ—intellect; bhakti-mān—full of devotion; me—to Me; priyaḥ—very dear; naraḥ—a person ","samaḥ śhatrau cha mitre cha tathā mānāpamānayoḥ\n" + "śhītoṣhṇa-sukha-duḥkheṣhu samaḥ saṅga-vivarjitaḥ\n" + "tulya-nindā-stutir maunī santuṣhṭo yena kenachit\n" + "aniketaḥ sthira-matir bhaktimān me priyo naraḥ",R.color.trans));
        mData.add(new NewsItem("ये तु धर्म्यामृतमिदं यथोक्तं पर्युपासते |\n" + "श्रद्दधाना मत्परमा भक्तास्तेऽतीव मे प्रिया: || 20||"," ye—who; tu—indeed; dharma—of wisdom; amṛitam—nectar; idam—this; yathā—as; uktam—declared; paryupāsate—exclusive devotion; śhraddadhānāḥ—with faith; mat-paramāḥ—intent on Me as the supreme goal; bhaktāḥ—devotees; te—they; atīva—exceedingly; me—to Me; priyāḥ—dear ","\n" + "\n" + "ye tu dharmyāmṛitam idaṁ yathoktaṁ paryupāsate\n" + "śhraddadhānā mat-paramā bhaktās te ’tīva me priyāḥ\n",R.color.trans));

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
                            Intent intent = new Intent(Vchp12.this, CloseActivity.class);
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

            Intent myIntent = new Intent(this, Chp12.class);
            this.startActivity(myIntent);

        }

        if (id == R.id.verses){

         //   Intent myIntent = new Intent(this, Main2Activity.class);
         //   this.startActivity(myIntent);

        }

        if (id == R.id.explain){

            //   Intent myIntent = new Intent(this, Explaination.class);
            //   this.startActivity(myIntent);

            new FancyGifDialog.Builder(Vchp12.this)
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