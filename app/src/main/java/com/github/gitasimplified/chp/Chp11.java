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
import com.github.gitasimplified.vchp.Vchp11;
import com.shashank.sony.fancygifdialoglib.FancyGifDialog;
import com.shashank.sony.fancygifdialoglib.FancyGifDialogListener;

import java.util.ArrayList;
import java.util.List;

public class Chp11 extends AppCompatActivity
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
        mData.add(new NewsItem("Arjuna uvācha :-","Arjun said: Having heard the supremely confidential spiritual knowledge, which you have revealed out of compassion to me, my illusion is now dispelled.","||1||",R.drawable.target));
        mData.add(new NewsItem("Arjuna uvācha :-","I have heard from you in detail about the appearance and disappearance of all living beings, O lotus-eyed one, and also about your eternal majesty. ","||2||",R.drawable.target));
        mData.add(new NewsItem("Arjuna uvācha :-","O Supreme Lord, you are precisely what you declare yourself to be. Now I desire to see your divine cosmic form, O greatest of persons. ","||3||",R.drawable.target));
        mData.add(new NewsItem("Arjuna uvācha :-","O Lord of all mystic powers, if you think I am strong enough to behold it, then kindly reveal that imperishable cosmic form to me. ","||4||",R.drawable.target));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-","The Supreme Lord said: Behold, O Parth, my hundreds and thousands of wonderful forms of various shapes, sizes, and colors. ","||5||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-","Behold in me, O scion of the Bharatas, the (twelve) sons of Aditi, the (eight) Vasus, the (eleven) Rudras, the (twin) Ashwini Kumars, as well as the (forty-nine) Maruts and many more marvels never revealed before. ","||6||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-","Behold now, Arjun, the entire universe, with everything moving and non-moving, assembled together in my universal form. Whatever else you wish to see, observe it all within this universal form. ","||7||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-","But you cannot see my cosmic form with these physical eyes of yours. Therefore, I grant you divine vision. Behold my majestic opulence! ","||8||",R.drawable.krishna_c));
        mData.add(new NewsItem("Sanjay uvācha :-","Sanjay said: O King, having spoken thus, the Supreme Lord of Yog, Shree Krishna, displayed his divine and opulent form to Arjun. ","||9||",R.drawable.chariot));
        mData.add(new NewsItem("Sanjay uvācha :-","In that cosmic form, Arjun saw unlimited faces and eyes, decorated with many celestial ornaments and wielding many kinds of divine weapons. He wore many garlands on his body and was anointed with many sweet-smelling heavenly fragrances. He revealed himself as the wonderful and infinite Lord whose face is everywhere. ","||10,11||",R.drawable.chariot));
        mData.add(new NewsItem("Sanjay uvācha :-"," If a thousand suns were to blaze forth together in the sky, they would not match the splendor of that great form. ","||12||",R.drawable.chariot));
        mData.add(new NewsItem("Sanjay uvācha :-","There Arjun could see the totality of the entire universe established in one place, in that body of the God of gods. ","||13||",R.drawable.chariot));
        mData.add(new NewsItem("Sanjay uvācha :-","Then, Arjun, full of wonder and with hair standing on end, bowed his head with folded hands before the Lord and addressed him thus. ","||14||",R.drawable.chariot));
        mData.add(new NewsItem("Arjuna uvācha :-","Arjun said: O Shree Krishna, I behold within your body all the gods and hosts of different beings. I see Brahma seated on the lotus flower; I see Shiv, all the sages, and the celestial serpents. ","||15||",R.drawable.target));
        mData.add(new NewsItem("Arjuna uvācha :-","I see your infinite form in every direction, with countless arms, stomachs, faces, and eyes. O Lord of the universe, whose form is the universe itself, I do not see in you any beginning, middle, or end. ","||16||",R.drawable.target));
        mData.add(new NewsItem("Arjuna uvācha :-","I see your form, adorned with a crown, and armed with the club and disc, shining everywhere as the abode of splendor. It is hard to look upon you in the blazing fire of your effulgence, which is radiating like the sun in all directions. ","||17||",R.drawable.target));
        mData.add(new NewsItem("Arjuna uvācha :-","I recognize you as the supreme imperishable being, the ultimate truth to be known by the scriptures. You are the support of all creation; you are the eternal protector of sanātan dharma (the eternal religion); and you are the everlasting Supreme Divine Personality. ","||18||",R.drawable.target));
        mData.add(new NewsItem("Arjuna uvācha :-","You are without beginning, middle, or end; your power has no limits. Your arms are infinite; the sun and the moon are like your eyes, and fire is like your mouth. I see you warming the entire creation by your radiance. ","||19||",R.drawable.target));
        mData.add(new NewsItem("Arjuna uvācha :-","The space between heaven and earth and all the directions are pervaded by you alone. Seeing your wondrous and terrible form, I see the three worlds trembling in fear, O Greatest of all beings. ","||20||",R.drawable.target));
        mData.add(new NewsItem("Arjuna uvācha :-","All the celestial gods are taking your shelter by entering into you. In awe, some are praising you with folded hands. The great sages and perfected beings are extolling you with auspicious hymns and profuse prayers. ","||21||",R.drawable.target));
        mData.add(new NewsItem("Arjuna uvācha :-","The Rudras, Adityas, Vasus, Sadhyas, Vishvadevas, Ashwini Kumars, Maruts, ancestors, Gandharvas, Yakshas, Asuras, and Siddhas are all beholding you in wonder. ","||22||",R.drawable.target));
        mData.add(new NewsItem("Arjuna uvācha :-"," O mighty Lord, in veneration of your magnificent form with its many mouths, eyes, arms, thighs, legs, stomachs, and terrifying teeth, all the worlds are terror-stricken, and so am I. ","||23||",R.drawable.target));
        mData.add(new NewsItem("Arjuna uvācha :-","O Lord Vishnu, seeing your form touching the sky, effulgent in many colors, with mouths wide open and enormous blazing eyes, my heart is trembling with fear. I have lost all courage and peace of mind. ","||24||",R.drawable.target));
        mData.add(new NewsItem("Arjuna uvācha :-","Having seen your many mouths bearing your terrible teeth, resembling the raging fire at the time of annihilation, I forget where I am and do not know where to go. O Lord of lords, you are the shelter of the universe; please have mercy on me. ","||25||",R.drawable.target));
        mData.add(new NewsItem("Arjuna uvācha :-","I see all the sons of Dhritarashtra, along with their allied kings, including Bheeshma, Dronacharya, Karn, and also the generals from our side, rushing headlong into your fearsome mouths. I see some with their heads smashed between your terrible teeth. ","||26,27||",R.drawable.target));
        mData.add(new NewsItem("Arjuna uvācha :-"," As many waves of the rivers flowing rapidly into the ocean, so are all these great warriors entering into your blazing mouths. As moths rush with great speed into the fire to perish, so are all these armies entering with great speed into your mouths. ","||28,29||",R.drawable.target));
        mData.add(new NewsItem("Arjuna uvācha :-","With your fiery tongues you are licking up the hosts of living beings on all sides and devouring them with your blazing mouths. O Vishnu, you are scorching the entire universe with the fierce, all-pervading rays of your effulgence. ","||30||",R.drawable.target));
        mData.add(new NewsItem("Arjuna uvācha :-","Tell me who you are, so fierce of form. O God of gods, I bow before you; please bestow your mercy on me. You, who existed before all creation, I wish to know who you are, for I do not comprehend your nature and workings. ","||31||",R.drawable.target));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-","The Supreme Lord said: I am mighty Time, the source of destruction that comes forth to annihilate the worlds. Even without your participation, the warriors arrayed in the opposing army shall cease to exist. ","||32||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-","Therefore, arise and attain honor! Conquer your foes and enjoy prosperous rulership. These warriors stand already slain by me, and you will only be an instrument of my work, O expert archer. ","||33||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-","Dronacharya, Bheeshma, Jayadratha, Karn, and other brave warriors have already been killed by me. So slay them without being disturbed. Just fight and you will be victorious over your enemies in battle. ","||34||",R.drawable.krishna_c));
        mData.add(new NewsItem("Sanjay uvācha :-","Sanjay said: Hearing these words of Keshav, Arjun trembled with dread. With palms joined, he bowed before Shree Krishna and spoke in a faltering voice, overwhelmed with fear. ","||35||",R.drawable.chariot));
        mData.add(new NewsItem("Arjuna uvācha :-"," Arjun said: O Master of the senses, it is but apt that the universe rejoices in giving you praise and is enamored by You. Demons flee fearfully from you in all directions and the hosts of perfected saints bow to you. ","||36||",R.drawable.target));
        mData.add(new NewsItem("Arjuna uvācha :-","O Great one, who are even greater than Brahma, the original creator, why should they not bow to you? O limitless One, O Lord of the devatās, O Refuge of the universe, you are the imperishable reality beyond both the manifest and the non-manifest. ","||37||",R.drawable.target));
        mData.add(new NewsItem("Arjuna uvācha :-","You are the primeval God and the original Divine Personality; you are the sole resting place of this universe. You are both the knower and the object of knowledge; you are the Supreme Abode. O possessor of infinite forms, you alone pervade the entire universe. ","||38||",R.drawable.target));
        mData.add(new NewsItem("Arjuna uvācha :-","You are Vāyu (the god of wind), Yamraj (the god of death), Agni (the god of fire), Varuṇ (the god of water), and Chandra (the moon-God). You are the creator Brahma, and the great-grandfather of all beings. I offer my salutations unto you a thousand times, again and yet again! ","||39||",R.drawable.target));
        mData.add(new NewsItem("Arjuna uvācha :-","O Lord of infinite power, my salutations to you from the front and the rear, indeed from all sides! You possess infinite valor and might and pervade everything, and thus, you are everything.","||40||",R.drawable.target));
        mData.add(new NewsItem("Arjuna uvācha :-","Thinking of you as my friend, I presumptuously addressed you as, “O Krishna,” “O Yadav,” “O my dear mate.” I was ignorant of your majesty, showing negligence and undue affection. And if, jestfully, I treated you with disrespect, while playing, resting, sitting, eating, when alone, or before others—for all that I crave forgiveness. ","||41,42||",R.drawable.target));
        mData.add(new NewsItem("Arjuna uvācha :-","You are the father of the entire universe, of all moving and non-moving beings. You are the most deserving of worship and the supreme spiritual master. When there is none equal to you in all the three worlds, then who can possibly be greater than you, O possessor of incomparable power? ","||43||",R.drawable.target));
        mData.add(new NewsItem("Arjuna uvācha :-","Therefore, O adorable Lord, bowing deeply and prostrating before you, I implore you for your grace. As a father tolerates his son, a friend forgives his friend, and a lover pardons the beloved, please forgive me for my offences. ","||44||",R.drawable.target));
        mData.add(new NewsItem("Arjuna uvācha :-","Having seen your universal form that I had never seen before, I feel great joy. And yet, my mind trembles with fear. Please have mercy on me and again show me your pleasing form, O God of gods, O abode of the universe. ","||45||",R.drawable.target));
        mData.add(new NewsItem("Arjuna uvācha :-","O thousand-armed one, though you are the embodiment of all creation, I wish to see you in your four-armed form, carrying the mace and disc, and wearing the crown. ","||46||",R.drawable.target));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-","The Blessed Lord said: Arjun, being pleased with you, by my Yogmaya power, I gave you a vision of my resplendent, unlimited, and primeval cosmic form. No one before you has ever seen it. ","||47||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-","Not by study of the Vedas, nor by the performance of sacrifice, rituals, or charity, nor even by practicing severe austerities, has any mortal ever seen what you have seen, O best of the Kuru warriors. ","||48||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-"," Be neither afraid nor bewildered on seeing this terrible form of mine. Be free from fear and with a cheerful heart, behold me once again in my personal form. ","||49||",R.drawable.krishna_c));
        mData.add(new NewsItem("Sanjay uvācha :-","Sanjay said: Having spoken thus, the compassionate son of Vasudev displayed his personal (four-armed) form again. Then, he further consoled the frightened Arjun by assuming his gentle (two-armed) form. ","||50||",R.drawable.chariot));
        mData.add(new NewsItem("Arjuna uvācha :-","Arjun said: O Shree Krishna, seeing your gentle human form (two-armed), I have regained my composure and my mind is restored to normal. ","||51||",R.drawable.target));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-","The Supreme Lord said: This form of mine that you are seeing is exceedingly difficult to behold. Even the celestial gods are eager to see it. Neither by the study of the Vedas, nor by penance, charity, or fire sacrifices, can I be seen as you have seen me. ","||52,53||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-"," O Arjun, by unalloyed devotion alone can I be known as I am, standing before you. Thereby, on receiving my divine vision, O scorcher of foes, one can enter into union with me. ","||54||",R.drawable.krishna_c));
        mData.add(new NewsItem("Shrī Bhagavān uvācha :-","Those who perform all their duties for my sake, who depend upon me and are devoted to me, who are free from attachment, and are without malice toward all beings, such devotees certainly come to me. ","||55||",R.drawable.krishna_c));

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
                            Intent intent = new Intent(Chp11.this, CloseActivity.class);
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

        //    Intent myIntent = new Intent(this, MainActivity.class);
         //   this.startActivity(myIntent);

        }

        if (id == R.id.verses){

            Intent myIntent = new Intent(this, Vchp11.class);
            this.startActivity(myIntent);

        }

        if (id == R.id.explain){

            //   Intent myIntent = new Intent(this, Explaination.class);
            //   this.startActivity(myIntent);

            new FancyGifDialog.Builder(Chp11.this)
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
       // else{Intent myIntent = new Intent(this, com.github.gitasimplified.MainActivity.class);
       //     this.startActivity(myIntent);}

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;

    }
}
