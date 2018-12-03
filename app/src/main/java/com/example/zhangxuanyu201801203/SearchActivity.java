package com.example.zhangxuanyu201801203;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 可乐 on 2018/12/3.
 */

public class SearchActivity extends LinearLayout {
    private final int Max = 20;
    List<String> list = new ArrayList<>();
    private Context mMcontext;

    public SearchActivity(Context context) {
        this(context, null);
    }

    public SearchActivity(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SearchActivity(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mMcontext = context;
        Dao dao = new Dao(mMcontext);
        init();
    }

    private void init() {

        setOrientation(VERTICAL);
    }

    public void setData(List<String> list) {
        this.list = list;
        ShowData();
    }

    private void ShowData() {
        removeAllViews();
        LinearLayout linearLayout = (LinearLayout) View.inflate(mMcontext, R.layout.search_one, null);
        addView(linearLayout);
        int len = 0;
        for (int i = 0; i < list.size(); i++) {
            final String s = list.get(i);
            len += s.length();
            if (len == 0) {
                Toast.makeText(mMcontext, "输入的内容不能为空", Toast.LENGTH_SHORT).show();
            } else {
                if (len > Max) {
                    linearLayout = (LinearLayout) View.inflate(mMcontext, R.layout.search_one, null);
                    addView(linearLayout);
                    len = s.length();
                }
                View view = View.inflate(mMcontext, R.layout.search_two, null);
                TextView text = view.findViewById(R.id.tv_text);
                text.setText(s);
                linearLayout.addView(view);

                LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
                layoutParams.weight=1;
                view.setLayoutParams(layoutParams);
                final int index=i;
                view.setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(mMcontext,s,Toast.LENGTH_SHORT).show();
                    }
                });
            }
        }
    }
}
