package android.satoripop.com.test;

import android.graphics.drawable.Drawable;
import android.satoripop.com.ratingbar.BaseRatingBar;
import android.satoripop.com.ratingbar.ScaleRatingBar;
import android.satoripop.com.switchbutton.interfaces.OnToggledListener;
import android.satoripop.com.switchbutton.model.ToggleableView;
import android.satoripop.com.switchbutton.widget.LabeledSwitch;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.content.res.AppCompatResources;
import android.view.View;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity   {

    private LabeledSwitch mSwitchHorsService;
    private LabeledSwitch mSwitchEnService;
    private ScaleRatingBar mScaleRatingBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSwitchHorsService = findViewById(R.id.switchHorsService);
        mSwitchEnService = findViewById(R.id.switchoEnService);
        mScaleRatingBar=findViewById(R.id.simpleRatingBar);

        this.initSwitchService();

        this.initRatingBarListener();

    }

    private void initRatingBarListener() {

        Drawable mDrawableEmpty = AppCompatResources.getDrawable(getApplicationContext(), R.drawable.ic_star_6);
        Drawable mDrawableFilled = AppCompatResources.getDrawable(getApplicationContext(), R.drawable.ic_star_5);

        mScaleRatingBar.setEmptyDrawable(mDrawableEmpty);
        mScaleRatingBar.setFilledDrawable(mDrawableFilled);

        mScaleRatingBar.setOnRatingChangeListener(new BaseRatingBar.OnRatingChangeListener() {
            @Override
            public void onRatingChange(BaseRatingBar ratingBar, float rating, boolean fromUser) {
               // Toast.makeText(getApplicationContext(),"Rating"+rating,Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initSwitchService() {

        mSwitchEnService.setVisibility(View.INVISIBLE);

        mSwitchHorsService.setOnToggledListener(new OnToggledListener() {
            @Override
            public void onSwitched(ToggleableView toggleableView, boolean isOn) {


                if(isOn)
                {
                    mSwitchEnService.setVisibility(View.VISIBLE);
                    mSwitchHorsService.setVisibility(View.INVISIBLE);
                    mSwitchHorsService.setOn(false);
                    mSwitchEnService.setOn(true);

                }

            }


        });


        mSwitchEnService.setOnToggledListener(new OnToggledListener() {
            @Override
            public void onSwitched(ToggleableView toggleableView, boolean isOn) {

                if(!isOn)
                {
                    mSwitchEnService.setVisibility(View.INVISIBLE);
                    mSwitchHorsService.setVisibility(View.VISIBLE);
                    mSwitchEnService.setOn(true);
                    mSwitchHorsService.setOn(false);

                }

            }



        });
    }


}
