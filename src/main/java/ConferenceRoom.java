public class ConferenceRoom extends Room {


    private String roomName;
    private double dayRate;

    public ConferenceRoom(int capacity, String roomName, double dayRate) {
        super(capacity);
        this.roomName = roomName;
        this.dayRate = dayRate;
    }

    public String getRoomName(){
        return this.roomName;
    }

    public double getDayRate(){
        return this.dayRate;
    }

    public double payBill(int days){
        return (this.dayRate * days);
    }
}
