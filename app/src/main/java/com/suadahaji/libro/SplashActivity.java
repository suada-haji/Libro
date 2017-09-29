package com.suadahaji.libro;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import co.gofynd.gravityview.GravityView;

public class SplashActivity extends AppCompatActivity {

    @BindView(R.id.bg)
    ImageView bg;

    @BindView(R.id.tv_logo)
    TextView logoTextView;

    @OnClick(R.id.btn_welcome)
    public void mainActivity() {
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }

    private GravityView gravityView;

    public static Typeface APPLE_CHANCERY;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);

        ButterKnife.bind(this);

        gravityView = GravityView.getInstance(this)
                .setImage(bg, R.drawable.background_two)
                .center();

        if (!gravityView.deviceSupported()) {
            Toast.makeText(getBaseContext(), "Gyroscope sensor not available in your device", Toast.LENGTH_LONG).show();
        }

        APPLE_CHANCERY = Typeface.createFromAsset(getAssets(), "fonts/Apple-Chancery.ttf");

        logoTextView.setTypeface(APPLE_CHANCERY);

    }

    @Override
    protected void onResume() {
        super.onResume();
        gravityView.registerListener();
    }

    @Override
    protected void onPause() {
        super.onPause();
        gravityView.unRegisterListener();
    }
}
