
/**
 * The Alarm class creates an alarm object that functions as a real world alarm
 * that set the time,turns the alarm off and on and checks if the alarm was set
 *
 * @author Micheal Kolling and David J. Barnes and Agina Oghenemena Benaiah
 * @version 2019.01.12
 */
public class Alarm
{

    private ClockDisplay12 timeSet; //declearing a reference to ClockDisplay12 object
    private boolean alarmSetCondition; //true means it's set while false means it's not set

    /**
     * A default constructor setting the alarm time to midnight and alarm off
     */
    public Alarm()
    {
        timeSet = new ClockDisplay12();
        alarmSetCondition = false;
    }
    
    /**
     * A constructor that take the number of hours,minutes and specifies a.m
     * or p.m and indicating if the alarm is set or not
     * 
     * @param hours stores the number of hours in the alarm clock
     * @param minutes stores the number of minutes in the alarm clock
     * @param time stores a.m. or p.m entered to set the alarm time
     * @param alarmCondition sets the alarm to true(alarm is turned on)
     * or false(alarm is turned off)
     */
    public Alarm(int hours, int minutes,String time, boolean alarmCondition ){
        timeSet = new ClockDisplay12(hours, minutes,time);
        alarmSetCondition = alarmCondition;
    }

    /**
     * Set the alarm time with the number of hours, minutes 
     * specify a.m. or p.m. 
     * 
     * @param hours stores the number of hours in the alarm clock
     * @param minutes stores the number of minutes in the alarm clock
     * @param time stores a.m. or p.m entered to set the alarm time
     */
    public void setTime(int hours, int minutes, String time){
        timeSet.setTime(hours,minutes,time);
        alarmSetCondition = true; // the alarm is set
    }

    /**
     * Turns on the alarm
     */
    public void turnOn(){
        alarmSetCondition = true;
    }

    /**
     * Turns off the alarm
     */
    public void turnOff(){
        alarmSetCondition = false;
    }

    /**
     * gets the current alarm time
     * 
     * @return returns the current alarm time
     */
    public String getTime(){
        return timeSet.getTime();
    }

    /**
     * checks if the alarm time is set or not
     * 
     * @return returns true if the alarm is set 
     */
    public boolean isSet(){
        if(alarmSetCondition){//alarm time is set if it's true
            return true; 
        }else{
            return false; //alarm time isn't set
        }
    }

}
