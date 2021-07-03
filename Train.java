
/**
 * This class represents a Train Object
 * 
 * @author (Moshe Arbiv) 
 * @version (2020)
 */

public class Train
{
    private String _destination;
    private Time1 _departure;
    private int _duration;
    private int _passengers;
    private int _seats;
    private int _price;
    private final int MIN=0;
    /**
     * creates a new Train object
     * @param destination (city)
     * @param hours, insert hour (0-23)
     * @param minutes, insert minutes(0-59)
     * @param duration, insert train ride duration in minutes
     * @param passengers, insert amount of passengers on the train
     * @param seats, insert amount of seats in the train\
     * @param price, insert train ticket price
     */

    public Train (String destination,int hours, int minutes,int duration,int passengers,int seats,int price){
        _destination=destination;
        _departure=new Time1(hours, minutes);
        if(duration<MIN)
            _duration=MIN;
        else
            _duration=duration;
        if(passengers>seats)
            _passengers=seats;
        if(passengers<MIN)
            _passengers=MIN;
        else
            _passengers=passengers;
        if(seats<MIN)
            _seats=MIN;
        else
            _seats=seats;
        if(price<MIN)
            _price=MIN;
        else
            _price=price;
    }

    /**
     * Copy Constructor
     * @param train to be copied
     */
    public Train (Train other){
        _destination=other._destination;
        _departure=new Time1(other._departure);
        _duration=other._duration;
        _passengers=other._passengers;
        _seats=other._seats;
        _price=other._price;
    }

    /** set destination
     * @param d the destination to set
     */
    public void setDestination(java.lang.String d){
        if(d!=null)
            _destination=d;
        else
            _destination=_destination;
    }

    /** set departure
     * @param t the departure time to set
     */
    public void setDeparture(Time1 t){
        if(t!=null)
            _departure=new Time1(t);
        else
            _departure=_departure;
    }

    /** set duration
     * @param d the duration of the train ride
     */
    public void setDuration(int d){
        if(d>=MIN)
            _duration=d;
        else
            _duration=_duration;
    }

    /** set passengers
     * @param p the amount of passengers to set
     */
    public void setPassengers(int p){
        if((p>=MIN)&&(p<_seats))
            _passengers=p;
        if(p>_seats)
            _seats=p;
        else
            _passengers=_passengers;
    }

    /** set price
     * @param p the ticket price to set
     */
    public void setPrice(int p){
        if(p>=MIN)
            _price=p;
        else
            _price=_price;
    }

    /** set seats
     * @param s the amount of seats to set
     */
    public void setSeats(int s){
        if((s>=0)&&(s>_passengers))
            _seats=s;
        else
            _seats=_seats;
    }

    /** gets a Train
     * @return the arrival time
     */ 
    public Time1 getArrivalTime(){
        Time1 t=new Time1(_departure);
        Time1 t2=t.addMinutes(_duration);
        return t2;
    }

    /** gets a Train
     * @return the departure time
     */ 
    public Time1 getDeparture(){
        Time1 d=new Time1(_departure);
        return d;
    }

    /** gets a Train
     * @return the destination
     */ 
    public java.lang.String getDestination(){
        return _destination;
    }

    /** gets a Train
     * @return the duration of the ride
     */ 
    public int getDuration(){
        return _duration;
    }

    /** gets a Train
     * @return the number of passengers
     */ 
    public int getPassengers(){
        return _passengers;
    }

    /** gets a Train
     * @return the ticket price
     */ 
    public int getPrice(){
        return _price;
    }

    /** gets a Train
     * @return the seats in the train
     */ 
    public int getSeats(){
        return _seats;
    }

    /** check if 2 trains are the same
     * @param other the train to compare this train to
     * @return true if the trains are the same
     */
    public boolean equals (Train other){
        if((_destination.equals(other._destination))&&(_departure.equals(other._departure))&&(_seats==other._seats))
            return true;
        else
            return false;
    }

    /** adds passengers to the train
     * @param num the amount of passengers to add
     *  @return true and add the passengers if there is a room in the train
     *  @returns false and dont add any passengers if the train is full
     */
    public boolean addPassengers(int num){
        if((num+_passengers)<_seats){
            _passengers+=num;
            return true;
        }
        else
            _passengers=_passengers;
        return false;
    }

    /** check if the train is full
     *  @return true if the train is full
     *  @return false if the train isnt full
     */
    public boolean isFull(){
        if(_passengers>=_seats)
            return true;
        else
            return false;
    }

    /** check if 1 ticket price is cheaper than the other
     * @param other train ticket price to compare this ticket price to
     *  @return true if the ticket is cheaper
     *  @return false if the ticket is not cheaper
     */
    public boolean isCheaper (Train other){
        if(_price<other._price)
            return true;
        else 
            return false;
    }

    /** returns the total price of tickets paid on this train
     *  @return the total price
     */
    public int totalPrice(){
        return _price*_passengers;
    }

    /** check if train arrives before other train
     * @param other the train we compare to
     *  @return true if the train arrives earlier than other train
     *  @returns false of the train isnt arriving earlier than the other train
     */
    public boolean arrivesEarlier(Train other){
        Time1 t1=new Time1(_departure);
        t1.addMinutes(_duration);
        Time1 t2=new Time1(other._departure);
        t2.addMinutes(other._duration);
        if(t1.before(t2))
            return true;
        else
            return false;
    }

    /** returns the summary of the train ride (destination, departe time and if full or not)
     *  @return the train ride summary
     */
    public String toString(){
        if(_passengers>=_seats)
            return (" Train to : "+_destination+"departs at: "+_departure+
                "the train is full");
        else
            return (" Train to : "+_destination+" departs at: "+_departure+
                " the train is not full");
    }
}
