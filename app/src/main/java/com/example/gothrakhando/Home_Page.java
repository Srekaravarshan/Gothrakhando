package com.example.gothrakhando;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.Timer;
import java.util.TimerTask;

public class Home_Page extends AppCompatActivity {

    LinearLayout gothram,housename,porutham,prohithargal,muhurtham,dots;
    ViewPager viewPager;
    private int dotscount;
    private ImageView[] dotsarray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home__page);

        gothram = findViewById(R.id.gothram);
        housename = findViewById(R.id.housename);
        porutham = findViewById(R.id.porutham);
        prohithargal = findViewById(R.id.prothithar);
        muhurtham = findViewById(R.id.muhurtham);
        viewPager = findViewById(R.id.viewPager);
        dots = (LinearLayout) findViewById(R.id.indigator);

        final Intent intentgothram = new Intent(this,MainActivity.class);
        final Intent intenthouse = new Intent(this,House_names.class);
        final Intent intentmuhurtham = new Intent(this,Muhurtham.class);
        final Intent intentprohithar = new Intent(this,Prohithar.class);
        final Intent intentporutham = new Intent(this,MainActivity.class);

        viewPageAdapter adapter = new viewPageAdapter(this);
        dotscount = adapter.getCount();
        dotsarray = new ImageView[dotscount];

        viewPager.setAdapter(adapter);

        for(int i=0;i<dotscount;i++){
            dotsarray[i] = new ImageView(this);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.WRAP_CONTENT);
            dotsarray[i].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(),R.drawable.nonactive));
            params.setMargins(8,0,8,0);
            dots.addView(dotsarray[i],params);
        }

        dotsarray[0].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(),R.drawable.active));

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                for(int i=0;i<dotscount;i++){
                    dotsarray[i].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(),R.drawable.nonactive));
                }
                dotsarray[position].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(),R.drawable.active));
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new timerTask(),3000,3000);

        gothram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intentgothram);
            }
        });
        housename.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intenthouse);
            }
        });
        prohithargal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intentprohithar);
            }
        });
        muhurtham.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intentmuhurtham);
            }
        });
        porutham.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intentporutham);
            }
        });

    }

    public class timerTask extends TimerTask{

        @Override
        public void run() {
            Home_Page.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if(viewPager.getCurrentItem()<dotscount-1){
                        viewPager.setCurrentItem(viewPager.getCurrentItem()+1);
                    }
                    else{
                        viewPager.setCurrentItem(0);
                    }
                }
            });
        }
    }
}