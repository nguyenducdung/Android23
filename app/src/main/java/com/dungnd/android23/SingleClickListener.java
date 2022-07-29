package com.dungnd.android23;

import android.os.SystemClock;
import android.view.View;

public class SingleClickListener implements View.OnClickListener {
    private long mLastClickTime = 0;

    //Check sự kiện 2 lần bấm liên tiếp phải cách nhau 1s
    @Override
    public void onClick(View view) {
        //*1000 is time to perform second click*
        if (SystemClock.elapsedRealtime() - mLastClickTime < 1000)
            return; // return when second click happen in second*
        mLastClickTime = SystemClock.elapsedRealtime();
    }
}
