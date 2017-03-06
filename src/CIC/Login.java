package CIC;

/**
 * Created by bb36 on 2/27/2017.
 */
public class Login {
    private String name;
    private int meals=0;
    private double misc=0;
    private float bonus=0;

    String getName(){
        //name = (String)PIN_Controller.students.get(PIN_Controller.pin_saved);
        name = (String)PIN_Controller.students.get("1234");
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
