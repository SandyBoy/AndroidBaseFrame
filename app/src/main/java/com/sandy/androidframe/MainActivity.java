package com.sandy.androidframe;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.widget.RadioGroup;

import com.sandy.androidframe.Fragment.CommonFragment;
import com.sandy.androidframe.Fragment.CustomFragment;
import com.sandy.androidframe.Fragment.OtherFragment;
import com.sandy.androidframe.Fragment.ThirdFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends FragmentActivity {
    private RadioGroup mRg_main;
    private List<BaseFragment> mBaseFragment;
    private int position;
    /**
     * 上次切换的Fragment
     */
    private Fragment mContent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initView();
      initFragment();
        setListener();
    }

    private void setListener() {
        mRg_main.setOnCheckedChangeListener(new MyOnCheckedChangeListener());
        mRg_main.check(R.id.rb_common_frame);
    }

    private void initView() {
        setContentView(R.layout.activity_main);
        mRg_main = (RadioGroup) findViewById(R.id.rg_bottom_tag);
    }

    private void initFragment() {
        mBaseFragment = new ArrayList<>();
        mBaseFragment.add(new CommonFragment());//常用框架Fragment
        mBaseFragment.add(new ThirdFragment());//第三方Fragment
        mBaseFragment.add(new CustomFragment());//自定义控件Fragment
        mBaseFragment.add(new OtherFragment());//其他Fragment
    }

    class MyOnCheckedChangeListener implements RadioGroup.OnCheckedChangeListener{

        @Override
        public void onCheckedChanged(RadioGroup radioGroup, int i) {
            switch (i){
                case R.id.rb_common_frame:
                    position=0;
                    break;
                case R.id.rb_thirdparty:
                    position=1;
                    break;
                case R.id.rb_custom:
                    position=2;
                    break;
                case R.id.rb_other:
                    position=3;
                    break;
                default:
                    position=0;
                    break;
            }
            //根据位置得到对应的Fragment
            BaseFragment to = getFragment();
//            //替换
            switchFrament(mContent,to);
        }
    }
    /**
     * 根据位置得到对应的Fragment
     * @return
     */
    private BaseFragment getFragment() {
        BaseFragment fragment = mBaseFragment.get(position);
        return fragment;
    }

    /**
     *
     * @param from 刚显示的Fragment,马上就要被隐藏了
     * @param to 马上要切换到的Fragment，一会要显示
     */
    private void switchFrament(Fragment from,Fragment to) {
        if(from != to){
            mContent = to;
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            //才切换
            //判断有没有被添加
            if(!to.isAdded()){
                //to没有被添加
                //from隐藏
                if(from != null){
                    ft.hide(from);
                }
                //添加to
                if(to != null){
                    ft.add(R.id.f1_content,to).commit();
                }
            }else{
                //to已经被添加
                // from隐藏
                if(from != null){
                    ft.hide(from);
                }
                //显示to
                if(to != null){
                    ft.show(to).commit();
                }
            }
        }

    }
}
