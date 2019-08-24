package com.github.gitasimplified;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.github.gitasimplified.vchp.Vchp18;
import com.shashank.sony.fancygifdialoglib.FancyGifDialog;
import com.shashank.sony.fancygifdialoglib.FancyGifDialogListener;

public class Aboutus extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.au);

        LinearLayout linearLayout=findViewById(R.id.li1);
        LinearLayout linearLayout2=findViewById(R.id.li2);
        LinearLayout linearLayout3=findViewById(R.id.li3);
        LinearLayout linearLayout4=findViewById(R.id.li4);
        LinearLayout linearLayout5=findViewById(R.id.li5);
        LinearLayout linearLayout6=findViewById(R.id.li6);
        LinearLayout linearLayout7=findViewById(R.id.li7);


        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new FancyGifDialog.Builder(Aboutus.this)
                        .setTitle("Do you know?")
                        .setMessage("In the Bhagavad-Gita, there are a total of 18 chapters, out of which 6 chapters (chapters 1 through 6 ) talk about how one should do his duties and is called karma yoga. The second set of 6 chapters from chapter 7th to 12th is called as bhakti yoga.")
                        .setNegativeBtnText("Thanks!")
                       // .setPositiveBtnBackground("#1ec1f2")
                       // .setPositiveBtnText("Yes")
                        .setNegativeBtnBackground("#D60621")
                        .setGifResource(R.drawable.more)
                        .isCancellable(true)
                       // .OnPositiveClicked(new FancyGifDialogListener() {
                        //    @Override
                       //     public void OnClick() {
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
        });

        linearLayout2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new FancyGifDialog.Builder(Aboutus.this)
                        .setTitle("Do you know?")
                        .setMessage("700 in some Gita Books (and) 701 in some other. The difference comes because in some Gita books , 1st verse in 13th chapter is omitted, as indicated in “Bhagavad Gita - The Song of God” by Swami Mukundananda.\n1 verse by Dhritarastra,40 by Sanjaya, 84 by Arjuna and the rest 575 by Krishna.")
                        .setNegativeBtnText("Thanks!")
                      //  .setPositiveBtnBackground("#1ec1f2")
                       // .setPositiveBtnText("Yes")
                        .setNegativeBtnBackground("#1ec1f2")
                        .setGifResource(R.drawable.more)
                        .isCancellable(true)
                      //  .OnPositiveClicked(new FancyGifDialogListener() {
                       //     @Override
                        //    public void OnClick() {
                         //       Intent intent = new Intent(Aboutus.this, CloseActivity.class);
                        //        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                        //        startActivity(intent);                      }
                       // })
                        .OnNegativeClicked(new FancyGifDialogListener() {
                            @Override
                            public void OnClick() {
                            }
                        })
                        .build();
            }
        });

        linearLayout3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new FancyGifDialog.Builder(Aboutus.this)
                        .setTitle("Do you know?")
                        .setMessage("The meter of the Bhagavad Gita is called “Anushtup” and it contains 32 syllables in each verse.\nThe general theme is in four lines of eight syllables each.")
                        .setNegativeBtnText("Thanks!")
                      //  .setPositiveBtnBackground("#1ec1f2")
                      //  .setPositiveBtnText("Yes")
                        .setNegativeBtnBackground("#D60621")
                        .setGifResource(R.drawable.more)
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
        });

        linearLayout4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:"+ "Sanjeev.jadhav99@gmail.com")));
            }
        });

        linearLayout5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phone = "+919867410605";
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", phone, null));
                startActivity(intent);
            }
        });

        linearLayout6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent shareIntent = new Intent(Intent.ACTION_SEND);
                shareIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                shareIntent.setType("text/plain");
                shareIntent.putExtra(android.content.Intent.EXTRA_TEXT, "Hey, thanks for download this app!\nEnjoy reading!!!");
                startActivity(shareIntent);
            }
        });

        linearLayout7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new FancyGifDialog.Builder(Aboutus.this)
                        .setTitle("Couldn't have done without you guys!")
                        .setMessage("Very special thanks to my parents,little sister & all my dear friends\n\n\uD83D\uDCA5️ Shashank for FancyGifDialog\n\n\uD83D\uDCA5️ Aws rh (for everything)\n\n\uD83D\uDCA5️ To all of you user's! \uD83D\uDC99️")
                        .setNegativeBtnText("Thanks!")
                       // .setPositiveBtnBackground("#1ec1f2")
                       // .setPositiveBtnText("Yes")
                        .setNegativeBtnBackground("#1ec1f2")
                        .setGifResource(R.drawable.thank)
                        .isCancellable(true)
                       // .OnPositiveClicked(new FancyGifDialogListener() {
                        //    @Override
                        //    public void OnClick() {
                         //       Intent intent = new Intent(Aboutus.this, CloseActivity.class);
                         //       intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                         //       startActivity(intent);                      }
                    //    })
                        .OnNegativeClicked(new FancyGifDialogListener() {
                            @Override
                            public void OnClick() {
                            }
                        })
                        .build(); }

        });

        Button button = findViewById(R.id.fbut);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(i);
            }
        });

    }
}
