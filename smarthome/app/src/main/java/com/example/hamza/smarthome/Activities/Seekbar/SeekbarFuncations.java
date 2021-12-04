package com.example.hamza.smarthome.Activities.Seekbar;

import android.content.Context;
import androidx.core.content.ContextCompat;
import com.example.hamza.smarthome.R;
import com.xw.repo.BubbleSeekBar;

public class SeekbarFuncations {

    public static void SeekbarUi(Context context, BubbleSeekBar BbubbleSeekBar){

        BbubbleSeekBar.getConfigBuilder()
                .min(0)
                .max(5)
                .sectionCount(5)
                .trackColor(ContextCompat.getColor(context, R.color.bluee))
                .secondTrackColor(ContextCompat.getColor(context, R.color.textcolor))
                .thumbColor(ContextCompat.getColor(context, R.color.textcolor))
                .showSectionText()
                .sectionTextColor(ContextCompat.getColor(context, R.color.textcolor))
                .sectionTextSize(18)
                .showThumbText()
                .thumbTextColor(ContextCompat.getColor(context, R.color.blackcolor))
                .thumbTextSize(18)
                .bubbleColor(ContextCompat.getColor(context, R.color.bluee))
                .bubbleTextSize(18)
                .showSectionMark()
                .seekBySection()
                .autoAdjustSectionMark()
                .sectionTextPosition(BubbleSeekBar.TextPosition.BELOW_SECTION_MARK)
                .build();
    }
}
