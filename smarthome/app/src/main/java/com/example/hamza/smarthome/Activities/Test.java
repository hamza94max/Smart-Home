package com.example.hamza.smarthome.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;

import com.example.hamza.smarthome.R;
import com.warkiz.widget.IndicatorSeekBar;
import com.warkiz.widget.IndicatorType;
import com.warkiz.widget.TickMarkType;
import com.xw.repo.BubbleSeekBar;

import static java.security.AccessController.getContext;

public class Test extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);


        BubbleSeekBar mBbubbleSeekBar = findViewById(R.id.test);
        mBbubbleSeekBar.getConfigBuilder()
                .min(0)
                .max(5)
                .progress(1)
                .trackColor(ContextCompat.getColor(getApplicationContext(), R.color.back))
                .secondTrackColor(ContextCompat.getColor(getApplicationContext(), R.color.bluee))
                .thumbColor(ContextCompat.getColor(getApplicationContext(), R.color.bluee))
                .showSectionText()
                .sectionTextColor(ContextCompat.getColor(getApplicationContext(), R.color.dab))
                .sectionTextSize(18)
                .showThumbText()
                .thumbTextColor(ContextCompat.getColor(getApplicationContext(), R.color.blackcolor))
                .thumbTextSize(18)
                .bubbleColor(ContextCompat.getColor(getApplicationContext(), R.color.dab))
                .bubbleTextSize(18)
                .showSectionMark()
                .seekBySection()
                .autoAdjustSectionMark()
                .sectionTextPosition(BubbleSeekBar.TextPosition.BELOW_SECTION_MARK)
                .build();




    }
}