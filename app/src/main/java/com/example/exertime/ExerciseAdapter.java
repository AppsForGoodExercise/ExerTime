package com.example.exertime;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;

// Rahul's code added on 05/06/2018

public class ExerciseAdapter extends BaseExpandableListAdapter{

    private Context ctx;
    private HashMap<String, List<String>> Exercise_category;
    private List<String> Exercise_desc;
    String[] exerciseName = {"Pushups","Squats","Crunches","High Knees","Tricep Dips","Lunges","Jump Squat","Wall Sit"};
    String[] intensity = {"Intensity: Medium","Intensity: Easy","Intensity: Easy","Intensity: Easy","Intensity: Medium","Intensity: Easy","Intensity: Medium","Intensity: Hard"};
    Integer [] imgid = {R.drawable.pushups,R.drawable.squats,R.drawable.crunches,R.drawable.hiknees,R.drawable.tricepdips,R.drawable.lunges,R.drawable.jumpingsquats,R.drawable.wallsit};


    public ExerciseAdapter(Context ctx, HashMap<String, List<String>> Exercise_category, List<String> Exercise_desc){

        this.ctx = ctx;
        this.Exercise_category = Exercise_category;
        this.Exercise_desc = Exercise_desc;
    }

    @Override
    public int getGroupCount() {

        return Exercise_category.size();
    }

    @Override
    public int getChildrenCount(int i) {

        return Exercise_category.get(Exercise_desc.get(i)).size();
    }

    @Override
    public Object getGroup(int i) {
        return Exercise_category.get(i);
    }

    @Override
    public Object getChild(int parent, int child) {

        return Exercise_category.get(Exercise_desc.get(parent)).get(child);
    }

    @Override
    public long getGroupId(int i) {
        return i;
    }

    @Override
    public long getChildId(int parent, int child) {
        return child;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int parent, boolean isExpanded, View convertview, ViewGroup parentview) {

        ViewHolder viewHolder = null;

        if (convertview == null){

            LayoutInflater inflater = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertview = inflater.inflate(R.layout.exerlistview_layout, parentview,false);
            viewHolder = new ViewHolder(convertview);
            convertview.setTag(viewHolder);
        }
        else {
            viewHolder = (ViewHolder) convertview.getTag();

        }

        viewHolder.exerNamevw.setText(exerciseName[parent]);
        viewHolder.intensityvw.setText(intensity[parent]);
        viewHolder.ivw.setImageResource(imgid[parent]);

        return convertview;

    }

    @Override
    public View getChildView(int parent, int child, boolean lastChild, View convertview, ViewGroup parentview) {

        String child_desc = (String) getChild(parent,child);
        if (convertview == null){
            LayoutInflater inflater = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertview = inflater.inflate(R.layout.exer_child_layout, parentview,false);

        }
        TextView child_textview = (TextView) convertview.findViewById(R.id.exerciseDesc);
        child_textview.setText(child_desc);

        return convertview;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return false;
    }

    class ViewHolder
    {
        TextView exerNamevw;
        TextView intensityvw;
        ImageView ivw;
        ViewHolder (View v)
        {
            exerNamevw = (TextView) v.findViewById(R.id.exerciseName);
            intensityvw = (TextView) v.findViewById(R.id.intensity);
            ivw = (ImageView) v.findViewById(R.id.imageView);
        }
    }
}