/**
 * This class represents a Time Object
 * 
 * @author (Moshe Arbiv) 
 * @version (2020)
 */

public class Time1
{
    private final int MAXHOUR=23;
    private final int HOURSINDAY=24;
    private final int MAXMINUTE=59;
    private final int MIN=0;
    private final int MININHOUR=60;
    private int _hour;
    private int _minute;
    /**
     * creates a new Time object
     * @param hours, insert hour (0-23)
     * @param minutes, insert minutes(0-59)
     */

    public Time1 (int hour,int minute){
        if((hour>=MIN)&&(hour<=MAXHOUR))
            _hour=hour;
        else
            _hour=MIN;
        if((minute>=MIN)&&(minute<=MAXMINUTE))
            _minute=minute;
        else
            _minute=MIN;
    }

    /**
     * Copy Constructor
     * @param time to be copied
     */
    public Time1 (Time1 other){
        _hour=other._hour;
        _minute=other._minute;
    }

    /** gets a Time
     * @return the hour
     */ 
    public int getHour(){
        return _hour;
    }

    /** gets a Time
     * @return the minutes
     */ 
    public int getMinute(){
        return _minute;
    }

    /** set hour
     * @param num, insert hour
     */
    public void setHour(int num){
        if((num>=MIN)&&(num<=MAXHOUR))
            _hour=num;
    }

    /** set minute
     * @param num, insert minutes
     */
    public void setMinute(int num){
        if((num>=MIN)&&(num<=MAXMINUTE))
            _minute=num;
    }

    /** returns the time, hours and minutes in clock method
     *  @return the time 
     */
    public String toString(){
        String s;
        s="";
        if (_hour<10)
            s+="MIN";
        s+=_hour;
        s+=":";
        if (_minute<10)
            s+="0";
        s+=_minute;
        return s;
    }

    /** gets a time and checks the minutes passed since midnight on given time
     *  @return the minutes passed since midnight
     */
    public int minFromMidnight(){
        int m;
        m=(_hour*MININHOUR)+_minute;
        return m;
    }

    /** gets other time and checks if its equal to this time
     *  @return true if they equal
     *  @return false if they arent equal
     */
    public boolean equals(Time1 other){
        if((_hour==other._hour)&&(_minute==other._minute))
            return true;
        else
            return false;
    }

    /** gets other time and checks if its before this time
     *  @return true if this time is before other time
     *  @return false if other time is before this time
     */
    public boolean before(Time1 other){
        if((_hour<other._hour)||(_hour==other._hour)&&(_minute<other._minute))
            return true;
        else 
            return false;
    }

    /** gets other time and checks if its after this time
     *  @return true if this time is after other time
     *  @return false if other time is after this time
     */
    public boolean after(Time1 other){
        return other.before(this);
    }

    /** gets other time and checks the diff between this time in minutes
     *  @return the difference in minutes
     */
    public int difference(Time1 other){
        int h=(other._hour-_hour)*MININHOUR;
        int m=other._minute-_minute;
        return h+m;
    }

    /** add minutes
     * @param num the minutes to add on this time
     * @return new time object after the additional num of minutes
     */
    public Time1 addMinutes (int num){
        int m=_minute;
        int hoursToMinutes=_hour*MININHOUR;
        int comb=num+hoursToMinutes+m;
        int totalHours=comb/MININHOUR;
        if (totalHours<MIN)
            totalHours+=HOURSINDAY;
        else
            totalHours=totalHours;
        int totalMinutes=comb%MININHOUR;
        if (totalMinutes<MIN)
            totalMinutes+=MININHOUR;
        else
            totalMinutes=totalMinutes;
        int dayHoursFormat=totalHours%HOURSINDAY;
        int h2=dayHoursFormat;
        int m2=totalMinutes;
        Time1 t2=new Time1(h2, m2);
        return t2;
    }
}