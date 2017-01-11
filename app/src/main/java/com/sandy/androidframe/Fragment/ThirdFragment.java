package com.sandy.androidframe.Fragment;

import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import com.sandy.androidframe.BaseFragment;

/**
 * Created by Sandy on 2017/1/11.
 */
public class ThirdFragment extends BaseFragment {
    private TextView textView;
//    private Context mContext;
    @Override
    protected View initView() {
        textView=new TextView(mContext);
        textView.setGravity(Gravity.CENTER);
        textView.setTextSize(20);
        textView.setTextColor(Color.BLACK);
        return textView;
    }

    @Override
    protected void initData() {
        super.initData();
        textView.setText("it is ......");
    }


}
