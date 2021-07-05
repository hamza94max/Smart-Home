package com.example.hamza.smarthome.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Switch;
import com.example.hamza.smarthome.R;
import com.xw.repo.BubbleSeekBar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        @SuppressLint("UseSwitchCompatOrMaterialCode") Switch led1 = findViewById(R.id.led1);
        @SuppressLint("UseSwitchCompatOrMaterialCode") Switch led2 = findViewById(R.id.led2);
        @SuppressLint("UseSwitchCompatOrMaterialCode") Switch led3 = findViewById(R.id.led3);
        @SuppressLint("UseSwitchCompatOrMaterialCode") Switch led4 = findViewById(R.id.led4);
        @SuppressLint("UseSwitchCompatOrMaterialCode") Switch led5 = findViewById(R.id.led5);
        @SuppressLint("UseSwitchCompatOrMaterialCode") Switch led6 = findViewById(R.id.led1_out);
        @SuppressLint("UseSwitchCompatOrMaterialCode") Switch led7 = findViewById(R.id.led2_out);

        BubbleSeekBar fan1 = findViewById(R.id.seekbar1);
        BubbleSeekBar fan2 = findViewById(R.id.seekbar2);
        BubbleSeekBar fan3 = findViewById(R.id.seekbar3);
        BubbleSeekBar heater1 = findViewById(R.id.seekbar4);
        BubbleSeekBar heater2 = findViewById(R.id.seekbar5);
        BubbleSeekBar heater3 = findViewById(R.id.seekbar6);

        SeekbarUi(fan1);
        SeekbarUi(fan2);
        SeekbarUi(fan3);
        SeekbarUi(heater1);
        SeekbarUi(heater2);
        SeekbarUi(heater3);






        Switch auto =findViewById(R.id.auto);
        auto.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

            }
        });





    }




    private void SeekbarUi (BubbleSeekBar BbubbleSeekBar){

        BbubbleSeekBar.getConfigBuilder()
                .min(0)
                .max(5)
                .sectionCount(5)
                .trackColor(ContextCompat.getColor(getApplicationContext(), R.color.back))
                .secondTrackColor(ContextCompat.getColor(getApplicationContext(), R.color.bluee))
                .thumbColor(ContextCompat.getColor(getApplicationContext(), R.color.bluee))
                .showSectionText()
                .sectionTextColor(ContextCompat.getColor(getApplicationContext(), R.color.dab))
                .sectionTextSize(18)
                .showThumbText()
                .thumbTextColor(ContextCompat.getColor(getApplicationContext(), R.color.blackcolor))
                .thumbTextSize(18)
                .bubbleColor(ContextCompat.getColor(getApplicationContext(), R.color.colorAccent))
                .bubbleTextSize(18)
                .showSectionMark()
                .seekBySection()
                .autoAdjustSectionMark()
                .sectionTextPosition(BubbleSeekBar.TextPosition.BELOW_SECTION_MARK)
                .build();


    }

}
