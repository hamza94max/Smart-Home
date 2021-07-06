package com.example.hamza.smarthome.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.databinding.DataBindingUtil;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.SeekBar;
import android.widget.Switch;
import com.example.hamza.smarthome.R;
import com.example.hamza.smarthome.databinding.ActivityMainBinding;
import com.xw.repo.BubbleSeekBar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        BubbleSeekBar fan1 = findViewById(R.id.Fan1);
        BubbleSeekBar fan2 = findViewById(R.id.Fan2);
        BubbleSeekBar fan3 = findViewById(R.id.Fan3);
        BubbleSeekBar heater1 = findViewById(R.id.Heater1);
        BubbleSeekBar heater2 = findViewById(R.id.Heater2);
        BubbleSeekBar heater3 = findViewById(R.id.Heater3);








        SeekbarUi(fan1);
        SeekbarUi(fan2);
        SeekbarUi(fan3);
        SeekbarUi(heater1);
        SeekbarUi(heater2);
        SeekbarUi(heater3);






        @SuppressLint("UseSwitchCompatOrMaterialCode") Switch auto = findViewById(R.id.autoSwitch);
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
                .trackColor(ContextCompat.getColor(getApplicationContext(), R.color.bluee))
                .secondTrackColor(ContextCompat.getColor(getApplicationContext(), R.color.textcolor))
                .thumbColor(ContextCompat.getColor(getApplicationContext(), R.color.textcolor))
                .showSectionText()
                .sectionTextColor(ContextCompat.getColor(getApplicationContext(), R.color.textcolor))
                .sectionTextSize(18)
                .showThumbText()
                .thumbTextColor(ContextCompat.getColor(getApplicationContext(), R.color.blackcolor))
                .thumbTextSize(18)
                .bubbleColor(ContextCompat.getColor(getApplicationContext(), R.color.bluee))
                .bubbleTextSize(18)
                .showSectionMark()
                .seekBySection()
                .autoAdjustSectionMark()
                .sectionTextPosition(BubbleSeekBar.TextPosition.BELOW_SECTION_MARK)
                .build();
    }

}
