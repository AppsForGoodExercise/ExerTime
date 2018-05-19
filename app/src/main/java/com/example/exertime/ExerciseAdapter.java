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

    /**
     * ExerciseAdapter Class provides the layout of the hierarchical Exercise List view (both parent
     * and child Views). All the 10 methods are provided.
     * @param ctx Context
     * @param Exercise_category Exercise type
     * @param Exercise_desc     Exercise description
     */
    public ExerciseAdapter(Context ctx, HashMap<String, List<String>> Exercise_category, List<String> Exercise_desc){

        this.ctx = ctx;
        this.Exercise_category = Exercise_category;
        this.Exercise_desc = Exercise_desc;
    }

    /**
     * This method returns the number of exercises.
     * @return exercise number
     */
    @Override
    public int getGroupCount() {

        return Exercise_category.size();
    }

    /**
     *  This method returns the description of the specified exercise type
     * @param i index of the exercise type
     * @return count of the children of the specified exercise type
     */
    @Override
    public int getChildrenCount(int i) {

        return Exercise_category.get(Exercise_desc.get(i)).size();
    }

    /**
     *  This method returns the name of exercise type
     * @param i index of the exercise type
     * @return name of the exercise
     */
    @Override
    public Object getGroup(int i) {
        return Exercise_category.get(i);
    }

    /**
     * This method returns the child object referenced by the exercise type
     * @param parent index of the exercise type
     * @param child Child object
     * @return
     */
    @Override
    public Object getChild(int parent, int child) {

        return Exercise_category.get(Exercise_desc.get(parent)).get(child);
    }

    /**
     *  This method returns index of the exercise type
     * @param i index of exercise type
     * @return index of exercise type
     */
    @Override
    public long getGroupId(int i) {
        return i;
    }

    /**
     * This method returns the id of the child of the exercise type
     * @param parent index of the exercise type
     * @param child index of child
     * @return ID of child
     */
    @Override
    public long getChildId(int parent, int child) {
        return child;
    }

    /**
     * This method returns false
     * @return false
     */
    @Override
    public boolean hasStableIds() {
        return false;
    }

    /**
     * This method returns the View that displays the list of all exercise types
     * @param parent index of the parent
     * @param isExpanded boolean variable that describes if the View is expanded or not
     * @param convertview Returned View
     * @param parentview Parent View
     * @return View that shows the intensity and list of all exercise types
     */
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

    /**
     *  This method returns the Child or expanded view of all the exercises.
     * @param parent index of the parent
     * @param child index of the child
     * @param lastChild Boolean whether this is the last child or not
     * @param convertview View that is returned
     * @param parentview parent View
     * @return View that shows the expanded view of all the exercises which includes the descriptions.
     */
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

    /**
     * Returns if the child is selectable
     * @param i index of parent
     * @param i1 index of child
     * @return false
     */
    @Override
    public boolean isChildSelectable(int i, int i1) {
        return false;
    }

    /**
     *  This class holds the exercise name, exercise intensity and image of the exercise. 
     */

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