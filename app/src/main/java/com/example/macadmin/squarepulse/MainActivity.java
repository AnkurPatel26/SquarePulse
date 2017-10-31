package com.example.macadmin.squarepulse;

import android.graphics.Color;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    ImageView IV;
    Runnable refresh;
    RelativeLayout main;

    int H = 0;
    int W = 0;
    int r=0,g=0,b=0;
    boolean max=false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        IV = (ImageView) findViewById(R.id.imageView);
        main = (RelativeLayout)findViewById(R.id.activity_main);
        final Handler handler = new Handler();


        refresh = new Runnable() {
            @Override
            public void run() {
               if(!max) {
                   H = IV.getHeight();
                   W = IV.getWidth();
                   W += 5;
                   H += 5;
                  /* LinearLayout.LayoutParams layoutParams=new LinearLayout.LayoutParams(W, H);
                   layoutParams.gravity = Gravity.CENTER;
                   IV.setLayoutParams(layoutParams);
*/
                   RelativeLayout.LayoutParams parms = new RelativeLayout.LayoutParams(W,H);
                   IV.setLayoutParams(parms);

                   RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams)IV.getLayoutParams();
                   layoutParams.addRule(RelativeLayout.CENTER_IN_PARENT, RelativeLayout.TRUE);
                   IV.setLayoutParams(layoutParams);
                    if(W >1300){
                        max =true;
                    }


               }
                if(max){

                    H = IV.getHeight();
                    W = IV.getWidth();
                    W -= 5;
                    H -= 5;
                  /* LinearLayout.LayoutParams layoutParams=new LinearLayout.LayoutParams(W, H);
                   layoutParams.gravity = Gravity.CENTER;
                   IV.setLayoutParams(layoutParams);
*/
                    RelativeLayout.LayoutParams parms = new RelativeLayout.LayoutParams(W,H);
                    IV.setLayoutParams(parms);

                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams)IV.getLayoutParams();
                    layoutParams.addRule(RelativeLayout.CENTER_IN_PARENT, RelativeLayout.TRUE);
                    IV.setLayoutParams(layoutParams);
                    if(W <90){
                        max =false;
                    }

                }




                if(r==255){r=0;}
                else if(g==255){g=0;}
                else if(b==255){b=0;}
                r+=3;
                g+=4;
                b+=7;
                IV.setBackgroundColor(Color.rgb(r,g,b));

                handler.postDelayed(this, 10);
            }
        };

        handler.postDelayed(refresh, 100);
    }

    }

