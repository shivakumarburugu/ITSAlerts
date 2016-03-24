package itsalerts.rti.com.itsalerts;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SplashScreen extends AppCompatActivity {

    Handler mHandler = new Handler();
    Runnable mRunnable;
    private int SPLASH_SCREEN_DELAY = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);
        mRunnable = new Runnable() {

            /*
             * Showing splash screen with a timer. This will be useful when you
             * want to show case your app logo / company
             */

            @Override
            public void run() {
                // This method will be executed once the timer is over
                // Start your app main activity
                Intent i = new Intent(SplashScreen.this, LoginActivity.class);
                startActivity(i);
                // close this activity
                finish();
            }
        };
        SPLASH_SCREEN_DELAY = 3000;
        mHandler.postDelayed(mRunnable, SPLASH_SCREEN_DELAY);
    }

    @Override
    protected void onStop() {
        super.onStop();
        mHandler.removeCallbacks(mRunnable);
    }
}
