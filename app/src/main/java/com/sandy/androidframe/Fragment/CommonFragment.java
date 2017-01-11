package com.sandy.androidframe.Fragment;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.sandy.androidframe.Adapter.CommonDataAdapter;
import com.sandy.androidframe.BaseFragment;
import com.sandy.androidframe.R;

/**
 * Created by Sandy on 2017/1/11.
 */
public class CommonFragment extends BaseFragment {
    private TextView textView;
//    private Context mContext;
    private ListView mListView;
    private String[] datas;
    private CommonDataAdapter adapter;
    @Override
    protected View initView() {
       View view=View.inflate(mContext, R.layout.fragment_common_frame,null);
        mListView = (ListView) view.findViewById(R.id.listview);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String data =  datas[position];
                Toast.makeText(mContext, "data==" + data, Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }

    @Override
    protected void initData() {
        super.initData();
        datas=new String[]{"1","2","3","4","5"};
        adapter=new CommonDataAdapter(mContext,datas);
        mListView.setAdapter(adapter);
    }
//@Override
//protected View initView() {
//    textView=new TextView(mContext);
//    textView.setGravity(Gravity.CENTER);
//    textView.setTextSize(20);
//    textView.setTextColor(Color.BLACK);
//    return textView;
//}

//    @Override
//    protected void initData() {
//        super.initData();
//        textView.setText("you are ......");
//    }

}
