import java.lang.*;
/**
 * The ClockDisplay class implements a digital clock display for a
 * European-style 24 hour clock. The clock shows hours and minutes. The 
 * range of the clock is 00:00 (midnight) to 23:59 (one minute before 
 * midnight).
 * 
 * The clock display receives "ticks" (via the timeTick method) every minute
 * and reacts by incrementing the display. This is done in the usual clock
 * fashion: the hour increments when the minutes roll over to zero.
 * 
 * @author Micheal Kolling and David J. Barnes and Agina Oghenemena Benaiah
 * @version 2019.01.14
 */

public class ClockDisplay12
{
    public static final String AM = "a.m.";
    public static final String PM = "p.m.";
    private NumberDisplay hours;
    private NumberDisplay minutes;
    private String displayString; 
    private String displayTime; //holds a.m or p.m
    private boolean timeEntered;
    /**
     * Constructor for ClockDisplay objects. This constructor 
     * creates a new clock set at 00:00.
     */
    public ClockDisplay12()
    {   
        hours = new NumberDisplay(24);
        minutes = new NumberDisplay(60);
        updateDisplay();
        timeEntered = false; //the user hasn't entered a.m or p.m. we'll  default to a.m
    }

    /**
     * Constructor for ClockDisplay objects. This constructor
     * creates a new clock set at the time specified by the 
     * parameters.
     * 
     * @param hours stores the number of hours 
     * @param minutes stores the number of minutes 
     * @param time stores a.m. or p.m entered to set 
     */
    public ClockDisplay12(int hour, int minute,String time)
    {   
        if(time.equals(AM) || time.equals(PM)){
            displayTime = time;
        }else{
            displayTime= "a.m."; //default time
        }
        timeEntered = true; //the user entered a.m or p.m
        hours = new NumberDisplay(24);
        minutes = new NumberDisplay(60);
        setTime(hour, minute,displayTime);
    }

    /**
     * This method should get called once every minute - it makes
     * the clock display go one minute forward.
     */
    public void timeTick()
    {
        minutes.increment();
        if(minutes.getValue() == 0) {  // it just rolled over!
            hours.increment();
        }
        updateDisplay();
    }

    /**
     * Set the time of the display to the specified hour and
     * minute.
     * 
     * @param hours stores the number of hours 
     * @param minutes stores the number of minutes 
     * @param time stores a.m. or p.m entered to set 
     */
    public void setTime(int hour, int minute, String time)
    {   
        if(time.equals(AM) || time.equals(PM)){
            displayTime = time;
        }else{
            displayTime = "a.m."; //default time
        }
        timeEntered = true; //the user entered a.m or p.m
        hours.setValue(hour);
        minutes.setValue(minute);
        updateDisplay();
    }

    /**
     * Return the current time of this display in the format HH:MM.
     * 
     * @return returns the current time 
     */
    public String getTime()
    {
        return displayString;
    }

    /**
     * Update the internal string that represents the display.
     */

    private void updateDisplay()
    {  

        int newval,hoursValue;
        hoursValue = hours.getValue();
        if(timeEntered && hours.getValue()<=12){// normal checking time1 -11
            displayString = hours.getValue() + ":" +  //this is the normal time1 -11
            minutes.getDisplayValue()+displayTime;
            timeEntered = false; // the user has to set the time before it become true
        }
      
        
        
        
        
        
        else if(hours.getValue() == 12 && minutes.getValue() == 0 && displayTime.equals(AM)){
            displayString = "12:00p.m."; //turning to afternoon
            displayTime = PM; //updating the time
        }
        else if(hours.getValue() == 12 && minutes.getValue() == 0 && displayTime.equals(PM)){
            displayString = "12:00a.m."; //very early in the morning
            displayTime = AM; //updating the time
        }

        else if(hoursValue == 0){ //default constructor midnight
            displayString = "12:"+minutes.getDisplayValue()+AM;
        }

        else if(hoursValue > 12){ //incase the user types in from 13 - 23
            newval = hours.getValue() - 12;

            displayString = newval + ":" +  //this is the normal time1 -11
            minutes.getDisplayValue() + displayTime;
        }
        else{ //1 - 11
            if(displayTime.equals(AM) || displayTime.equals(PM)){
                displayString = hours.getValue() + ":" +  //keeps track of the ticking time
                minutes.getDisplayValue()+displayTime;
            }
        }
    }
}

