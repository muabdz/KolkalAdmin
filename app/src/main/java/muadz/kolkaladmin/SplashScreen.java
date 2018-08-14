package muadz.kolkaladmin;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import muadz.kolkaladmin.Utils.SessionManager;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        final ImageView logoKolkal = (ImageView) findViewById(R.id.ivLogoKolkal);

        logoKolkal.setAlpha(0f);
        ValueAnimator fadeAnim = ObjectAnimator.ofFloat(logoKolkal, "alpha", 3f, 0f);
        fadeAnim.setDuration(2500);
        fadeAnim.start();

        Thread timer = new Thread() {
            public void run() {
                try{
                    sleep(2300);
                } catch (InterruptedException e){
                    e.printStackTrace();
                } finally {
                    SessionManager sessionManager = new SessionManager(getApplicationContext());

                    sessionManager.setFirstTimeLaunch(true);

                    Intent intent = new Intent(SplashScreen.this, HomeScreen.class);
                    startActivity(intent);
                    finish();

                }

            }
        };
        timer.start();
    }

    
}
