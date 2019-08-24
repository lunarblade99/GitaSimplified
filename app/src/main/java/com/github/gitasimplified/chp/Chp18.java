package com.github.gitasimplified.chp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
import com.github.gitasimplified.NewsAdapter;
import com.github.gitasimplified.NewsItem;
import com.github.gitasimplified.R;
import com.github.gitasimplified.vchp.Vchp18;
import com.shashank.sony.fancygifdialoglib.FancyGifDialog;
import com.shashank.sony.fancygifdialoglib.FancyGifDialogListener;

import java.util.ArrayList;
import java.util.List;

public class Chp18 extends AppCompatActivity
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
        mData.add(new NewsItem("Arjuna uvācha :-","Arjun said: O mighty-armed Krishna, I wish to understand the nature of sanyās (renunciation of actions) and tyāg (renunciation of the desire for the fruits of actions). O Hrishikesh, I also wish to know the distinction between the two, O Keshinisudan. ","||1||",R.drawable.target));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-"," The Supreme Divine Personality said: Giving up of actions motivated by desire is what the wise understand as sanyās. Relinquishing the fruits of all actions is what the learned declare to be tyāg. ","||2||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-","Some learned people declare that all kinds of actions should be given up as evil, while others maintain that acts of sacrifice, charity, and penance should never be abandoned. ","||3||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-","Now hear my conclusion on the subject of renunciation, O tiger amongst men, for renunciation has been declared to be of three kinds. ","||4||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-","Actions based upon sacrifice, charity, and penance should never be abandoned; they must certainly be performed. Indeed, acts of sacrifice, charity, and penance are purifying even for those who are wise. ","||5||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-","These activities must be performed without attachment and expectation for rewards. This is my definite and supreme verdict, O Arjun. ","||6||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-","Prescribed duties should never be renounced. Such deluded renunciation is said to be in the mode of ignorance. ","||7||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-","To give up prescribed duties because they are troublesome or cause bodily discomfort is renunciation in the mode of passion. Such renunciation is never beneficial or elevating. ","||8||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-","When actions are taken in response to duty, Arjun, and one relinquishes attachment to any reward, it is considered renunciation in the nature of goodness. ","||9||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-","Those who neither avoid disagreeable work nor seek work because it is agreeable are persons of true renunciation. They are endowed with the quality of the mode of goodness and have no doubts (about the nature of work). ","||10||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-","For the embodied being, it is impossible to give up activities entirely. But those who relinquish the fruits of their actions are said to be truly renounced. ","||11||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-","The three-fold fruits of actions—pleasant, unpleasant, and mixed—accrue even after death to those who are attached to personal reward. But, for those who renounce the fruits of their actions, there are no such results in the here or hereafter. ","||12||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-","O Arjun, now learn from me about the five factors that have been mentioned for the accomplishment of all actions in the doctrine of Sānkhya, which explains how to stop the reactions of karmas. ","||13||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-","The body, the doer, the various senses, the many kinds of efforts, and Divine Providence—these are the five factors of action. ","||14||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-","These five are the contributory factors for whatever action is performed, whether proper or improper, with body, speech, or mind. Those who do not understand this regard the soul as the only doer. With their impure intellects they cannot see things as they are. ","||15,16||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-","Those who are free from the ego of being the doer, and whose intellect is unattached, though they may slay living beings, they neither kill nor are they bound by actions. ","||17||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-","Knowledge, the object of knowledge, and the knower—these are the three factors that induce action. The instrument of action, the act itself, and the doer—these are the three constituents of action. ","||18||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-","Knowledge, action, and the doer are declared to be of three kinds in the Sānkhya philosophy, distinguished according to the three modes of material nature. Listen, and I will explain their distinctions to you. ","||19||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-","Understand that knowledge to be in the mode of goodness by which a person sees one undivided imperishable reality within all diverse living beings. ","||20||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-","That knowledge is to be considered in the mode of passion by which one sees the manifold living entities in diverse bodies as individual and unconnected. ","||21||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-","That knowledge is said to be in the mode of ignorance where one is engrossed in a fragmental concept as if it encompasses the whole, and which is neither grounded in reason nor based on the truth. ","||22||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-","Action that is in accordance with the scriptures, which is free from attachment and aversion, and which is done without desire for rewards, is in the mode of goodness. ","||23||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-","Action that is prompted by selfish desire, enacted with pride, and full of stress, is in the nature of passion. ","||24||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-"," That action is declared to be in the mode of ignorance, which is begun out of delusion, without thought to one’s own ability, and disregarding consequences, loss, and injury to others. ","||25||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-","The performer is said to be in the mode of goodness, when he or she is free from egotism and attachment, endowed with enthusiasm and determination, and equipoised in success and failure. ","||26||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-","The performer is considered in the mode of passion when he or she craves the fruits of the work, is covetous, violent-natured, impure, and moved by joy and sorrow. ","||27||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-","A performer in the mode of ignorance is one who is undisciplined, vulgar, stubborn, deceitful, slothful, despondent, and procrastinating. ","||28||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-","Hear now, O Arjun, of the distinctions of intellect and determination, according to the three modes of material nature, as I describe them in detail. ","||29||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-","The intellect is said to be in the nature of goodness, O Parth, when it understands what is proper action and what is improper action, what is duty and what is non-duty, what is to be feared and what is not to be feared, what is binding and what is liberating. ","||30||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-","The intellect is considered in the mode of passion when it is confused between righteousness and unrighteousness, and cannot distinguish between right and wrong conduct. ","||31||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-","That intellect which is shrouded in darkness, imagining irreligion to be religion, and perceiving untruth to be the truth, is of the nature of ignorance. ","||32||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-","The steadfast will that is developed through Yog, and which sustains the activities of the mind, the life-airs, and the senses, is said to be determination in the mode of goodness. ","||33||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-","The steadfast will by which one holds to duty, pleasures, and wealth, out of attachment and desire for rewards, is determination in the mode of passion. ","||34||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-"," That unintelligent resolve is said to be determination in the mode of ignorance, in which one does not give up dreaming, fearing, grieving, despair, and conceit. ","||35||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-","And now hear from me, O Arjun, of the three kinds of happiness in which the embodied soul rejoices, and can even reach the end of all suffering. ","||36||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-","That which seems like poison at first, but tastes like nectar in the end, is said to be happiness in the mode of goodness. It is generated by the pure intellect that is situated in self-knowledge. ","||37||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-","Happiness is said to be in the mode of passion when it is derived from the contact of the senses with their objects. Such happiness is like nectar at first but poison at the end. ","||38||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-","That happiness which covers the nature of the self from beginning to end, and which is derived from sleep, indolence, and negligence, is said to be in the mode of ignorance. ","||39||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-","No living being on earth or the higher celestial abodes in this material realm is free from the influence of these three modes of nature. ","||40||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-","The duties of the Brahmins, Kshatriyas, Vaishyas, and Shudras—are distributed according to their qualities, in accordance with their guṇas (and not by birth). ","||41||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-","Tranquility, restraint, austerity, purity, patience, integrity, knowledge, wisdom, and belief in a hereafter—these are the intrinsic qualities of work for Brahmins. ","||42||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-","Valor, strength, fortitude, skill in weaponry, resolve never to retreat from battle, large-heartedness in charity, and leadership abilities, these are the natural qualities of work for Kshatriyas. ","||43||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-","Agriculture, dairy farming, and commerce are the natural works for those with the qualities of Vaishyas. Serving through work is the natural duty for those with the qualities of Shudras. ","||44||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-"," By fulfilling their duties, born of their innate qualities, human beings can attain perfection. Now hear from me how one can become perfect by discharging one’s prescribed duties. ","||45||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-","By performing one’s natural occupation, one worships the Creator from whom all living entities have come into being, and by whom the whole universe is pervaded. By such performance of work, a person easily attains perfection. ","||46||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-","It is better to do one’s own dharma, even though imperfectly, than to do another’s dharma, even though perfectly. By doing one’s innate duties, a person does not incur sin. ","||47||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-","One should not abandon duties born of one’s nature, even if one sees defects in them, O son of Kunti. Indeed, all endeavors are veiled by some evil, as fire is by smoke. ","||48||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-","Those whose intellect is unattached everywhere, who have mastered the mind, and are free from desires by the practice of renunciation, attain the highest perfection of freedom from action. ","||49||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-","Hear from me briefly, O Arjun, and I shall explain how one, who has attained perfection (of cessation of actions), can also attain Brahman by being firmly fixed in transcendental knowledge. ","||50||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-"," One becomes fit to attain Brahman when he or she possesses a purified intellect and firmly restrains the senses, abandoning sound and other objects of the senses, casting aside attraction and aversion. Such a person relishes solitude, eats lightly, controls body, mind, and speech, is ever engaged in meditation, and practices dispassion. Free from egotism, violence, arrogance, desire, possessiveness of property, and selfishness, such a person, situated in tranquility, is fit for union with Brahman (i.e., realization of the Absolute Truth as Brahman). ","||51,52,53||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-","One situated in the transcendental Brahman realization becomes mentally serene, neither grieving nor desiring. Being equitably disposed toward all living beings, such a yogi attains supreme devotion unto me. ","||54||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-","Only by loving devotion to me does one come to know who I am in truth. Then, having come to know me, my devotee enters into full consciousness of me. ","||55||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-","My devotees, though performing all kinds of actions, take full refuge in me. By my grace, they attain the eternal and imperishable abode. ","||56||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-","Dedicate your every activity to me, making me your supreme goal. Taking shelter of the Yog of the intellect, keep your consciousness absorbed in me always. ","||57||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-","If you remember me always, by my grace you will overcome all obstacles and difficulties. But if, due to pride, you do not listen to my advice, you will perish. ","||58||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-"," If, motivated by pride, you think, “I shall not fight,” your decision will be in vain. Your own material (Kshatriya) nature will compel you to fight. ","||59||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-"," O Arjun, that action which out of delusion you do not wish to do, you will be driven to do it by your own inclination, born of your own material nature. ","||60||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-","The Supreme Lord dwells in the hearts of all living beings, O Arjun. According to their karmas, he directs the wanderings of the souls, who are seated on a machine made of the material energy. ","||61||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-","Surrender exclusively unto him with your whole being, O Bharat. By his grace, you will attain perfect peace and the eternal abode. ","||62||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-","Thus, I have explained to you this knowledge that is more secret than all secrets. Ponder over it deeply, and then do as you wish. ","||63||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-","Hear again my supreme instruction, the most confidential of all knowledge. I am revealing this for your benefit because you are very dear to me. ","||64||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-","Always think of me, be devoted to me, worship me, and offer obeisance to me. Doing so, you will certainly come to me. This is my pledge to you, for you are very dear to me. ","||65||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-","Abandon all varieties of dharmas and simply surrender unto me alone. I shall liberate you from all sinful reactions; do not fear. ","||66||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-","This instruction should never be explained to those who are not austere or to those who are not devoted. It should also not be spoken to those who are averse to listening (to spiritual topics), and especially not to those who are envious of me. ","||67||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-","his instruction should never be explained to those who are not austere or to those who are not devoted. It should also not be spoken to those who are averse to listening (to spiritual topics), and especially not to those who are envious of me. ","||68||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-","No human being does more loving service to me than they; nor shall there ever be anyone on this earth more dear to me. ","||69||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-","And I proclaim that those who study this sacred dialogue of ours will worship me (with their intellect) through the sacrifice of knowledge; such is my view. ","||70||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-","Even those who only listen to this knowledge with faith and without envy will be liberated from sins and attain the auspicious abodes where the pious dwell. ","||71||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-","O Arjun, have you heard me with a concentrated mind? Have your ignorance and delusion been destroyed? ","||72||",R.drawable.krishna_c));
        mData.add(new NewsItem("Arjuna uvācha :-","Arjun Said: O infallible one, by your grace my illusion has been dispelled, and I am situated in knowledge. I am now free from doubts, and I shall act according to your instructions. ","||73||",R.drawable.target));
        mData.add(new NewsItem("Sanjaya uvācha :-","Sanjay said: Thus, have I heard this wonderful conversation between Shree Krishna, the son of Vasudev, and Arjun, the noble-hearted son of Pritha. So thrilling is the message that my hair is standing on end. ","||74||",R.drawable.chariot));
        mData.add(new NewsItem("Sanjaya uvācha :-","By the grace of Veda Vyas, I have heard this supreme and most secret Yog from the Lord of Yog, Shree Krishna himself. ","||75||",R.drawable.chariot));
        mData.add(new NewsItem("Sanjaya uvācha :-","As I repeatedly recall this astonishing and wonderful dialogue between the Supreme Lord Shree Krishna and Arjun, O King, I rejoice again and again. ","||76||",R.drawable.chariot));
        mData.add(new NewsItem("Sanjaya uvācha :-","And remembering that most astonishing and wonderful cosmic form of Lord Krishna, great is my astonishment, and I am thrilled with joy over and over again. ","||77||",R.drawable.chariot));
        mData.add(new NewsItem("Sanjaya uvācha :-","Wherever there is Shree Krishna, the Lord of all Yog, and wherever there is Arjun, the supreme archer, there will also certainly be unending opulence, victory, prosperity, and righteousness. Of this, I am certain. ","||78||",R.drawable.chariot));

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
                            Intent intent = new Intent(Chp18.this, CloseActivity.class);
                            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                            startActivity(intent);                     }
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

         //   Intent myIntent = new Intent(this, MainActivity.class);
         //   this.startActivity(myIntent);

        }

        if (id == R.id.verses){

            Intent myIntent = new Intent(this, Vchp18.class);
            this.startActivity(myIntent);

        }

        if (id == R.id.explain){

            //   Intent myIntent = new Intent(this, Explaination.class);
            //   this.startActivity(myIntent);

            new FancyGifDialog.Builder(Chp18.this)
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
     //   else{Intent myIntent = new Intent(this, com.github.gitasimplified.MainActivity.class);
       //     this.startActivity(myIntent);}

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;

    }
}
