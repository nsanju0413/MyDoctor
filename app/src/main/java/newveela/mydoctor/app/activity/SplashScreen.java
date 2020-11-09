package newveela.mydoctor.app.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import newveela.mydoctor.app.R;

public class SplashScreen extends AppCompatActivity {

    private int SPLASH_TIME_OUT=3500;
    private ImageView mImageView;
    private TextView welcomeText,fest_info_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        welcomeText= findViewById(R.id.welcome_textView);
        mImageView= findViewById(R.id.applogo);
        fest_info_text= findViewById(R.id.welcome_textView2);
        Animation bottom= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.scale_up);
        Animation scale_up= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.scale_up);
        mImageView.startAnimation(scale_up);
        welcomeText.startAnimation(scale_up);
        fest_info_text.startAnimation(bottom);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(SplashScreen.this,MainActivity.class));
                finish();

            }
        },SPLASH_TIME_OUT);

    }
}