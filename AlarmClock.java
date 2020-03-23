
/**
 * AlarmClock class simulates a real world clock that displays the current time
 * and can also set an alarm
 *
 * @author Micheal Kolling and David J. Barnes and Agina Oghenemena Benaiah
 * @version 2019.01.12
 */
public class AlarmClock
{

    private ClockDisplay12 currentTime; //this represents the current time
    private Alarm alarmTime; //this irepresents the alarm time

    /**
     * Default constructor that creates an object of type clockDisplay12
     * and Alarm object
     */
    public AlarmClock()
    {
        // initialise instance variables
        currentTime = new ClockDisplay12(); //creating the current time object that sets the alarm to midnight
        alarmTime = new Alarm(); //creating alarm object that sets the alarm to midnight
    }

    /**
     * Constructor that takes the number of hours, minutes and specifies a.m. or p.m.
     * for the clock and the alarm. It creates an object for the current time and the 
     * alarm
     * 
     * @param hoursClock stores the hours entered by the user
     * @param minutesClock stores the minutes entered by the user
     * @param timeClock stores a.m. or p.m. entered by the user
     * @param hoursAlarm stores the hours entered by the user
     * @param minutesAlarm stores the minutes entered by the user
     * @param alarmTime stores a.m. or p.m. entered by the user
     * @param setAlarm to true or false. True means it is set. false
     *   means it's not set
     * 
     */
    public AlarmClock(int hoursClock, int minutesClock, String timeClock, int hoursAlarm, int minutesAlarm, String timeAlarm, boolean setAlarm){
        currentTime= new ClockDisplay12(hoursClock,minutesClock, timeClock); //creating the currentTime object
        alarmTime = new Alarm( hoursAlarm,  minutesAlarm, timeAlarm,  setAlarm ); //creating an object of type alarm

    }

    /**
     * set the clocl time with the number of hours, minutes and specify a.m. or p.m.
     * 
     * @param hours stores the number of hours entered by the user
     * @param minutes stores the number of minutes entered by the user
     * @param time sets the clock time to a.m. or p.m.
     */
    public void setTime(int hours, int minutes ,String time){ //sets the clock time
        currentTime.setTime( hours, minutes , time);
    }

    /**
     * set the alarm time with the number of hours, minutes and specify a.m. or p.m.
     * 
     * @param hours stores the number of hours entered by the user
     * @param minutes stores the number of minutes entered by the user
     * @param time sets the Alarm time time to a.m. or p.m.
     */
    public void setAlarmTime(int hours, int minutes, String time){
        alarmTime.setTime( hours, minutes, time);
    }

    /**
     * Increments the minute and checks the time current clock time is thesame as the alarm set time.
     * if they are thesame, it prints out a message and turns the alarm off.
     */
    public void clockTick(){
        currentTime.timeTick();
        //we now have to comepare both objects to see if they are equal(currentTime and alarmTime)
        if(currentTime.getTime().equals(alarmTime.getTime())){ //checking if both objects are equal. 
            System.out.println("RING RING RING");
            alarmTime.turnOff();
        }
    }

    /**
     * Turns on the alarm
     */
    public void setAlarm(){
        alarmTime.turnOn();
    }

    /**
     * Sets the alarm off
     */
    public void unsetAlarm(){
        alarmTime.turnOff();
    }

    /**
     * Returns the current clock time
     * 
     * @return the current time of the clock
     */
    public String getTime(){
        return currentTime.getTime();
    }

    /**
     * it returns the current time of the alarm
     * 
     * @return the current alarm time
     */
    public String  getAlarmTime(){
        return alarmTime.getTime();
    }

    /**
     * It returns true or false if the alarm is on
     * 
     * @return returns true if the alarm is set or not
     */
    public boolean isAlarmSet(){
        if(alarmTime.isSet()){ //returns true if the alarm is set
            return true;
        }else{
            return false;
        }
    }
}
