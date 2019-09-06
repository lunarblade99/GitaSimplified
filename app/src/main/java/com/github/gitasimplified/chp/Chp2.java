package com.github.gitasimplified.chp;

import android.content.Intent;
import android.content.SharedPreferences;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
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
import com.github.gitasimplified.NewsAdapter;
import com.github.gitasimplified.NewsItem;
import com.github.gitasimplified.R;
import com.github.gitasimplified.vchp.Vchp2;
import com.shashank.sony.fancygifdialoglib.FancyGifDialog;
import com.shashank.sony.fancygifdialoglib.FancyGifDialogListener;

import java.util.ArrayList;
import java.util.List;

public class Chp2 extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    RecyclerView NewsRecyclerview;
    NewsAdapter newsAdapter;
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

            if(position == 0) {
            }


        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // requestWindowFeature(Window.FEATURE_NO_TITLE);
        // getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
        //       WindowManager.LayoutParams.FLAG_FULLSCREEN);
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
        navigationView.getMenu().getItem(1).setChecked(true);

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
        mData.add(new NewsItem("Sanjay uvācha :- 『 2.1 』 ","Sanjay said: Seeing Arjun overwhelmed with pity, his mind grief-stricken, and his eyes full of tears, Shree Krishna spoke the following words.","||1||",R.drawable.chariot));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :- 『 2.2 』 ","The Supreme Lord said: My dear Arjun, how has this delusion overcome you in this hour of peril? It is not befitting an honorable person. It leads not to the higher abodes, but to disgrace.","||2||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :- 『 2.3 』 "," O Parth, it does not befit you to yield to this unmanliness. Give up such petty weakness of heart and arise, O vanquisher of enemies. ","||3||",R.drawable.krishna_c));
        mData.add(new NewsItem("Arjuna uvācha :- 『 2.4 』 ","Arjun said: O Madhusudan, how can I shoot arrows in battle on men like Bheeshma and Dronacharya, who are worthy of my worship, O destroyer of enemies? ","||4||",R.drawable.target));
        mData.add(new NewsItem("Arjuna uvācha :- 『 2.5 』 ","It would be better to live in this world by begging, than to enjoy life by killing these noble elders, who are my teachers. If we kill them, the wealth and pleasures we enjoy will be tainted with blood. ","||5||",R.drawable.target));
        mData.add(new NewsItem("Arjuna uvācha :- 『 2.6 』 ","We do not even know which result of this war is preferable for us—conquering them or being conquered by them. Even after killing them we will not desire to live. Yet they have taken the side of Dhritarasthra, and now stand before us on the battlefield. ","||6||",R.drawable.target));
        mData.add(new NewsItem("Arjuna uvācha :- 『 2.7 』 ","I am confused about my duty, and am besieged with anxiety and faintheartedness. I am your disciple, and am surrendered to you. Please instruct me for certain what is best for me. ","||7||",R.drawable.target));
        mData.add(new NewsItem("Arjuna uvācha :- 『 2.8 』 ","I can find no means of driving away this anguish that is drying up my senses. Even if I win a prosperous and unrivalled kingdom on the earth, or gain sovereignty like the celestial gods, I will be unable to dispel this grief. ","||8||",R.drawable.target));
        mData.add(new NewsItem("Sanjay uvācha :- 『 2.9 』 ","Sanjay said: Having thus spoken, Gudakesh, that chastiser of enemies, addressed Hrishikesh: “Govind, I shall not fight,” and became silent. ","||9||",R.drawable.chariot));
        mData.add(new NewsItem("Sanjay uvācha :- 『 2.10 』 ","O Dhritarashtra, thereafter, in the midst of both the armies, Shree Krishna smilingly spoke the following words to the grief-stricken Arjun. ","||10||",R.drawable.chariot));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :- 『 2.11 』 ","The Supreme Lord said: While you speak words of wisdom, you are mourning for that which is not worthy of grief. The wise lament neither for the living nor for the dead. ","||11||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :- 『 2.12 』 ","Never was there a time when I did not exist, nor you, nor all these kings; nor in the future shall any of us cease to be. ","||12||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :- 『 2.13 』 "," Just as the embodied soul continuously passes from childhood to youth to old age, similarly, at the time of death, the soul passes into another body. The wise are not deluded by this. ","||13||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :- 『 2.14 』 ","O son of Kunti, the contact between the senses and the sense objects gives rise to fleeting perceptions of happiness and distress. These are non-permanent, and come and go like the winter and summer seasons. O descendent of Bharat, one must learn to tolerate them without being disturbed. ","||14||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :- 『 2.15 』 ","O Arjun, noblest amongst men, that person who is not affected by happiness and distress, and remains steady in both, becomes eligible for liberation. ","||15||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :- 『 2.16 』 ","Of the transient there is no endurance, and of the eternal there is no cessation. This has verily been observed by the seers of the truth, after studying the nature of both. ","||16||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :- 『 2.17 』 ","That which pervades the entire body, know it to be indestructible. No one can cause the destruction of the imperishable soul. ","||17||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :- 『 2.18 』 ","Only the material body is perishable; the embodied soul within is indestructible, immeasurable, and eternal. Therefore, fight, O descendent of Bharat. ","||18||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :- 『 2.19 』 ","Neither of them is in knowledge—the one who thinks the soul can slay and the one who thinks the soul can be slain. For truly, the soul neither kills nor can it be killed. ","||19||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :- 『 2.20 』 ","The soul is neither born, nor does it ever die; nor having once existed, does it ever cease to be. The soul is without birth, eternal, immortal, and ageless. It is not destroyed when the body is destroyed. ","||20||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :- 『 2.21 』 ","O Parth, how can one who knows the soul to be imperishable, eternal, unborn, and immutable kill anyone or cause anyone to kill? ","||21||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :- 『 2.22 』 ","As a person sheds worn-out garments and wears new ones, likewise, at the time of death, the soul casts off its worn-out body and enters a new one. ","||22||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :- 『 2.23 』 ","Weapons cannot shred the soul, nor can fire burn it. Water cannot wet it, nor can the wind dry it. ","||23||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :- 『 2.24 』 ","The soul is unbreakable and incombustible; it can neither be dampened nor dried. It is everlasting, in all places, unalterable, immutable, and primordial. ","||24||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :- 『 2.25 』 ","The soul is spoken of as invisible, inconceivable, and unchangeable. Knowing this, you should not grieve for the body. ","||25||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :- 『 2.26 』 ","If, however, you think that the self is subject to constant birth and death, O mighty-armed Arjun, even then you should not grieve like this. ","||26||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :- 『 2.27 』 ","Death is certain for one who has been born, and rebirth is inevitable for one who has died. Therefore, you should not lament over the inevitable. ","||27||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :- 『 2.28 』 "," O scion of Bharat, all created beings are unmanifest before birth, manifest in life, and again unmanifest on death. So why grieve? ","||28||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :- 『 2.29 』 ","Some see the soul as amazing, some describe it as amazing, and some hear of the soul as amazing, while others, even on hearing, cannot understand it at all. ","||29||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :- 『 2.30 』 ","O Arjun, the soul that dwells within the body is immortal; therefore, you should not mourn for anyone. ","||30||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :- 『 2.31 』 ","Besides, considering your duty as a warrior, you should not waver. Indeed, for a warrior, there is no better engagement than fighting for upholding of righteousness. ","||31||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :- 『 2.32 』 "," O Parth, happy are the warriors to whom such opportunities to defend righteousness come unsought, opening for them the stairway to the celestial abodes. ","||32||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :- 『 2.33 』 ","If, however, you refuse to fight this righteous war, abandoning your social duty and reputation, you will certainly incur sin. ","||33||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :- 『 2.34 』 "," People will speak of you as a coward and a deserter. For a respectable person, infamy is worse than death. ","||34||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :- 『 2.35 』 ","The great generals who hold you in high esteem will think that you fled from the battlefield out of fear, and thus will lose their respect for you. ","||35||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :- 『 2.36 』 ","Your enemies will defame and humiliate you with unkind words, disparaging your might. Alas, what could be more painful than that? ","||36||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :- 『 2.37 』 "," If you fight, you will either be slain on the battlefield and go to the celestial abodes, or you will gain victory and enjoy the kingdom on earth. Therefore arise with determination, O son of Kunti, and be prepared to fight. ","||37||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :- 『 2.38 』 ","Fight for the sake of duty, treating alike happiness and distress, loss and gain, victory and defeat. Fulfilling your responsibility in this way, you will never incur sin. ","||38||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :- 『 2.39 』 ","Hitherto, I have explained to you Sānkhya Yog, or analytic knowledge regarding the nature of the soul. Now listen, O Parth, as I reveal Buddhi Yog, or the Yog of Intellect. When you work with such understanding, you will be freed from the bondage of karma. ","||39||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :- 『 2.40 』 ","Working in this state of consciousness, there is no loss or adverse result, and even a little effort saves one from great danger. ","||40||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :- 『 2.41 』 ","O descendent of the Kurus, the intellect of those who are on this path is resolute, and their aim is one-pointed. But the intellect of those who are irresolute is many-branched. ","||41||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :- 『 2.42/43 』 ","Those with limited understanding, get attracted to the flowery words of the Vedas, which advocate ostentatious rituals for elevation to the celestial abodes, and presume no higher principle is described in them. They glorify only those portions of the Vedas that please their senses, and perform pompous ritualistic ceremonies for attaining high birth, opulence, sensual enjoyment, and elevation to the heavenly planets. ","||42,43||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :- 『 2.44 』 ","With their minds deeply attached to worldly pleasures and their intellects bewildered by such things, they are unable to possess the resolute determination for success on the path to God. ","||44||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :- 『 2.45 』 ","The Vedas deal with the three modes of material nature, O Arjun. Rise above the three modes to a state of pure spiritual consciousness. Freeing yourself from dualities, eternally fixed in truth, and without concern for material gain and safety, be situated in the self. ","||45||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :- 『 2.46 』 ","Whatever purpose is served by a small well of water is naturally served in all respects by a large lake. Similarly, one who realizes the Absolute Truth also fulfills the purpose of all the Vedas. ","||46||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :- 『 2.47 』 ","You have a right to perform your prescribed duties, but you are not entitled to the fruits of your actions. Never consider yourself to be the cause of the results of your activities, nor be attached to inaction. ","||47||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :- 『 2.48 』 ","Be steadfast in the performance of your duty, O Arjun, abandoning attachment to success and failure. Such equanimity is called Yog. ","||48||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :- 『 2.49 』 ","Seek refuge in divine knowledge and insight, O Arjun, and discard reward-seeking actions that are certainly inferior to works performed with the intellect established in Divine knowledge. Miserly are those who seek to enjoy the fruits of their works. ","||49||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :- 『 2.50 』 ","One who prudently practices the science of work without attachment can get rid of both good and bad reactions in this life itself. Therefore, strive for Yog, which is the art of working skillfully (in proper consciousness). ","||50||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :- 『 2.51 』 ","The wise endowed with equanimity of intellect, abandon attachment to the fruits of actions, which bind one to the cycle of life and death. By working in such consciousness, they attain the state beyond all suffering. ","||51||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :- 『 2.52 』 ","When your intellect crosses the quagmire of delusion, you will then acquire indifference to what has been heard and what is yet to be heard (about enjoyments in this world and the next). ","||52||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :- 『 2.53 』 ","When your intellect ceases to be allured by the fruitive sections of the Vedas and remains steadfast in divine consciousness, you will then attain the state of perfect Yog. ","||53||",R.drawable.krishna_c));
        mData.add(new NewsItem("Arjuna uvācha :- 『 2.54 』 ","Arjun said : O Keshav, what is the disposition of one who is situated in divine consciousness? How does an enlightened person talk? How does he sit? How does he walk? ","||54||",R.drawable.target));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :- 『 2.55 』 ","The Supreme Lord said: O Parth, when one discards all selfish desires and cravings of the senses that torment the mind, and becomes satisfied in the realization of the self, such a person is said to be transcendentally situated. ","||55||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :- 『 2.56 』 ","One whose mind remains undisturbed amidst misery, who does not crave for pleasure, and who is free from attachment, fear, and anger, is called a sage of steady wisdom. ","||56||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :- 『 2.57 』 ","One who remains unattached under all conditions, and is neither delighted by good fortune nor dejected by tribulation, he is a sage with perfect knowledge. ","||57||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :- 『 2.58 』 ","One who is able to withdraw the senses from their objects, just as a tortoise withdraws its limbs into its shell, is established in divine wisdom. ","||58||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :- 『 2.59 』 ","Aspirants may restrain the senses from their objects of enjoyment, but the taste for the sense objects remains. However, even this taste ceases for those who realizes the Supreme. ","||59||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :- 『 2.60 』 ","The senses are so strong and turbulent, O son of Kunti, that they can forcibly carry away the mind even of a person endowed with discrimination and practicing self-control. ","||60||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :- 『 2.61 』 ","They are established in perfect knowledge, who subdue their senses and keep their minds ever absorbed in me. ","||61||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :- 『 2.62 』 ","While contemplating on the objects of the senses, one develops attachment to them. Attachment leads to desire, and from desire arises anger.","||62||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :- 『 2.63 』 ","Anger leads to clouding of judgment, which results in bewilderment of the memory. When the memory is bewildered, the intellect gets destroyed; and when the intellect is destroyed, one is ruined. ","||63||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :- 『 2.64 』 ","But one who controls the mind, and is free from attachment and aversion, even while using the objects of the senses, attains the Grace of God. ","||64||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :- 『 2.65 』 ","By divine grace comes the peace in which all sorrows end, and the intellect of such a person of tranquil mind soon becomes firmly established in God. ","||65||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :- 『 2.66 』 ","But an undisciplined person, who has not controlled the mind and senses, can neither have a resolute intellect nor steady contemplation on God. For one who never unites the mind with God there is no peace; and how can one who lacks peace be happy? ","||66||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :- 『 2.67 』 ","Just as a strong wind sweeps a boat off its chartered course on the water, even one of the senses on which the mind focuses can lead the intellect astray. ","||67||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :- 『 2.68 』 ","Therefore, one who has restrained the senses from their objects, O mighty armed Arjun, is firmly established in transcendental knowledge. ","||68||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :- 『 2.69 』 ","What all beings consider as day is the night of ignorance for the wise, and what all creatures see as night is the day for the introspective sage.","||69||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :- 『 2.70 』 ","Just as the ocean remains undisturbed by the incessant flow of waters from rivers merging into it, likewise the sage who is unmoved despite the flow of desirable objects all around him attains peace, and not the person who strives to satisfy desires.","||70||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :- 『 2.71 』 ","That person, who gives up all material desires and lives free from a sense of greed, proprietorship, and egoism, attains perfect peace. ","||71||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :- 『 2.72 』 ","O Parth, such is the state of an enlightened soul that having attained it, one is never again deluded. Being established in this consciousness even at the hour of death, one is liberated from the cycle of life and death and reaches the Supreme Abode of God.","||72||",R.drawable.krishna_c));





        // adapter ini and setup

        newsAdapter = new NewsAdapter(this,mData,isDark);
        NewsRecyclerview.setAdapter(newsAdapter);
        NewsRecyclerview.setLayoutManager(new LinearLayoutManager(this));
        NewsAdapter.setOnItemClickListener(onItemClickListener);

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

                newsAdapter = new NewsAdapter(getApplicationContext(),mData,isDark);
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
                            Intent intent = new Intent(Chp2.this, CloseActivity.class);
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
        getMenuInflater().inflate(R.menu.main, menu);
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

          //  Intent myIntent = new Intent(this, MainActivity.class);
          //  this.startActivity(myIntent);

        }

        if (id == R.id.verses){

            Intent myIntent = new Intent(this, Vchp2.class);
            this.startActivity(myIntent);

        }

        if (id == R.id.explain){

            //   Intent myIntent = new Intent(this, Explaination.class);
            //   this.startActivity(myIntent);

            new FancyGifDialog.Builder(Chp2.this)
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
            Intent myIntent = new Intent(this, com.github.gitasimplified.MainActivity.class);
            this.startActivity(myIntent);

        }
        if (id2 == R.id.two) {
            Intent myIntent = new Intent(this, Chp2.class);
            this.startActivity(myIntent);

        }
        if (id2 == R.id.three) {
            Intent myIntent = new Intent(this, Chp3.class);
            this.startActivity(myIntent);

        }
        if (id2 == R.id.four) {
            Intent myIntent = new Intent(this, Chp4.class);
            this.startActivity(myIntent);

        }if (id2 == R.id.five) {
            Intent myIntent = new Intent(this, Chp5.class);
            this.startActivity(myIntent);

        }
        if (id2 == R.id.six) {
            Intent myIntent = new Intent(this, Chp6.class);
            this.startActivity(myIntent);

        }if (id2 == R.id.seven) {
            Intent myIntent = new Intent(this, Chp7.class);
            this.startActivity(myIntent);

        }
        if (id2 == R.id.eight) {
            Intent myIntent = new Intent(this, Chp8.class);
            this.startActivity(myIntent);

        }if (id2 == R.id.nine) {
            Intent myIntent = new Intent(this, Chp9.class);
            this.startActivity(myIntent);

        }
        if (id2 == R.id.ten) {
            Intent myIntent = new Intent(this, Chp10.class);
            this.startActivity(myIntent);

        }if (id2 == R.id.eleven) {
            Intent myIntent = new Intent(this, Chp11.class);
            this.startActivity(myIntent);

        }
        if (id2 == R.id.twelve) {
            Intent myIntent = new Intent(this, Chp12.class);
            this.startActivity(myIntent);

        }if (id2 == R.id.thirteen) {
            Intent myIntent = new Intent(this, Chp13.class);
            this.startActivity(myIntent);

        }
        if (id2 == R.id.fourteen) {
            Intent myIntent = new Intent(this, Chp14.class);
            this.startActivity(myIntent);

        }if (id2 == R.id.fifteen) {
            Intent myIntent = new Intent(this, Chp15.class);
            this.startActivity(myIntent);

        }
        if (id2 == R.id.sixteen) {
            Intent myIntent = new Intent(this, Chp16.class);
            this.startActivity(myIntent);

        }if (id2 == R.id.seventeen) {
            Intent myIntent = new Intent(this, Chp17.class);
            this.startActivity(myIntent);

        }
        if (id2 == R.id.eighteen) {
            Intent myIntent = new Intent(this, Chp18.class);
            this.startActivity(myIntent);

        }
        //else{Toast.makeText(Chp2.this, "2 : ", Toast.LENGTH_SHORT).show(); }


        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;

    }
}
