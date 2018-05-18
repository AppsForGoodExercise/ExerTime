package com.example.exertime;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class exercisecompleteList extends AppCompatActivity {

    HashMap<String, List<String>> Exercise_category;
    List<String> Exercise_desc;
    ExpandableListView Exp_list;
    ExerciseAdapter adapter;

    //  Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercisecomplete_list);


        Exp_list = (ExpandableListView) findViewById(R.id.exp_ListView);
        Exercise_category = ExerciseData.getInfo();
        Exercise_desc = new ArrayList<String>(Exercise_category.keySet());
        adapter = new ExerciseAdapter(this, Exercise_category, Exercise_desc);
        Exp_list.setAdapter(adapter);

    }
}
