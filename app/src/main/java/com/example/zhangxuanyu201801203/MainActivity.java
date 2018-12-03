package com.example.zhangxuanyu201801203;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<String> lits=new ArrayList<>();
    private EditText edit_text;
    private Button search;
    private SearchActivity search_one,search_two;
    private Dao dao;
    private ImageView delete;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dao = new Dao(this);
        init();
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s = edit_text.getText().toString();
                lits.add(s);
                dao.add(s);
                search_two.setData(lits);
                initData();
            }
        });
        initData();
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dao.delete();
                search_one.removeAllViews();
            }
        });
    }

    private void initData() {
        List<String> query = dao.query();
        search_one.setData(query);
    }

    private void init() {
        edit_text = findViewById(R.id.edit_text);
        search = findViewById(R.id.search);
        search_one = findViewById(R.id.search_one);
        search_two=findViewById(R.id.search_two);
        delete=findViewById(R.id.delete);
    }
}
