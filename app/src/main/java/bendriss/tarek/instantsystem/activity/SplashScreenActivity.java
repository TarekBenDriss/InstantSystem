package bendriss.tarek.instantsystem.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import bendriss.tarek.instantsystem.R;
import bendriss.tarek.instantsystem.databinding.ActivitySplashScreenBinding;
import bendriss.tarek.instantsystem.utils.AnimationUtils;
import bendriss.tarek.instantsystem.utils.WindowUtils;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

/**
 * The first activity to start, it contains the logo of "lemonde" and then it starts the main activity.
 * The statusBarColor is set to black, the same color as the logo
 * The logo is animated with its alpha
 * After 3.2 seconds, the main activity is started
 */
public class SplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivitySplashScreenBinding mBinding = DataBindingUtil.setContentView(this, R.layout.activity_splash_screen);

        WindowUtils.setStatusBarColor(this, R.color.black);
        AnimationUtils.setAlphaAnimation(mBinding.logoIv, 0.0f, 1.0f, 3000, 0);

        new Handler().postDelayed(() -> {
            Intent intent = new Intent(SplashScreenActivity.this, MainActivity.class);
            SplashScreenActivity.this.startActivity(intent);
            SplashScreenActivity.this.finish();
        }, 3200);
    }
}
