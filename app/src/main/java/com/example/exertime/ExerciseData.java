package com.example.exertime;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *  The ExerciseData class implements the getInfo() method where all the exercises and the descriptions
 *  of the exercises are captured.
 */

public class ExerciseData {

    /**
     * Returns the list of all the exercises and their associated descriptions.
     * @return a HashMap of the list of exercises and descriptions.
     */

    public static HashMap<String, List<String>> getInfo()
    {
        HashMap<String, List<String>> ExerciseDetails = new HashMap<String, List<String>>();

        //Exercises and descriptions
        List<String> Pushups = new ArrayList<String>();
        Pushups.add("Pushups: A conditioning exercise performed in a prone position by raising" +
                " and lowering the body with the straightening and bending of the arms while keeping " +
                "the back straight and supporting the body on the hands and toes.");

        List<String> Squats = new ArrayList<String>();
        Squats.add("Squats: The basic squat is an extremely effective lower body move that " +
                "strengthens all leg muscles including glutes, quads, hamstrings and calves. " +
                "During the squat you use every single lower body muscle, " +
                "all while maintaining an upright posture will deliver an entire leg workout with core strength " +
                "as an added bonus making the squat the ultimate lower body workout.");

        List<String> Crunches = new ArrayList<String>();
        Crunches.add("Crunches: A crunch begins with lying face up on the floor with knees bent. " +
                "The movement begins by curling the shoulders towards the pelvis. The hands can be " +
                "behind or beside the neck or crossed over the chest.");

        List<String> High_Knees = new ArrayList<String>();
        High_Knees.add("High Knees: High knees combine the typical running motion with exaggerated knee lifts. " +
                "Perform high knees as a component of your warm-up or prolong the exercise and add " +
                "them to your workout routine to really get your heart rate going.");

        List<String> Tricep_Dips = new ArrayList<String>();
        Tricep_Dips.add("Tricep Dips: Straighten your arms, keeping a little bend in your elbows to " +
                "keep tension on your triceps and off your elbow joints. Slowly bend your elbows to " +
                "lower your body toward the floor until your elbows are at about a 90-degree angle.");

        List<String> Lunges = new ArrayList<String>();
        Lunges.add("Lunges: Keep your upper body straight, with your shoulders back and relaxed, " +
                "and chin up (pick a point to stare at in front of you so you don't keep looking down). " +
                "Step forward with one leg, lowering your hips until both knees are bent at " +
                "about a 90-degree angle.");

        List<String> Jump_Squat = new ArrayList<String>();
        Jump_Squat.add("Jump Squats: Stand with your feet shoulder-width apart " +
                "Start by doing a regular squat, then engage your core and jump up explosively. " +
                "When you land, lower your body back into the squat position to complete one rep. " +
                "Land as quietly as possible, which requires control.");

        List<String> Wall_Sit = new ArrayList<String>();
        Wall_Sit.add("Wall Sits: A wall sit is an exercise done to strengthen the quadriceps muscles. " +
                "The person wall-sitting places their back against a wall with their feet shoulder " +
                "width apart and a little ways out from the wall. Then, keeping their back against " +
                "the wall, they lower their hips until their knees form right angles.");

        //Mapping
        ExerciseDetails.put("Pushups",Jump_Squat);//Jump Squats
        ExerciseDetails.put("Squats", Lunges);//Lunges
        ExerciseDetails.put("Crunches", Tricep_Dips);//Tricep Dips
        ExerciseDetails.put("High Knees", High_Knees);//High Knees
        ExerciseDetails.put("Tricep Dips", Squats);//Squats
        ExerciseDetails.put("Lunges", Wall_Sit);//Wall Sit
        ExerciseDetails.put("Jump Squat", Crunches);//Crunches
        ExerciseDetails.put("Wall Sit", Pushups);//Pushups

        return ExerciseDetails;

    }
}