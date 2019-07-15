package xyz.alfonso.paypalcalc.utils;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

/**
 * Created by icrea on 03/07/17.
 */

public class SquaredLinearLayout extends LinearLayout {
    public SquaredLinearLayout(Context context) {
        super(context);
    }

    public SquaredLinearLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public SquaredLinearLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public SquaredLinearLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, widthMeasureSpec);
    }
}
