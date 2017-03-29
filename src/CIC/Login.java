package CIC;

/**
 * Created by bb36 on 2/27/2017.
 */
//probably can be deleted?
public class Login {
    private String name;
    private int meals=0;
    private double misc=0;
    private float bonus=0;

    String getName(){
        name = (String)PIN_Controller.students.get(PIN_Controller.pin_saved);
        return name;
    }
    int getMeals(){
        meals = 13;
        return meals;
    }
    double getMisc(){
        misc = 75.00;
        return misc;
    }
    float getBonus(){
        bonus = 21;
        return bonus;
    }

}
