public class BedRoom extends Room {

    private int roomNumber;
    private RoomType type;
    private double nightRate;

    public BedRoom(int roomNumber, RoomType type, double nightRate) {
        super(type.getCapacity());
        this.roomNumber = roomNumber;
        this.type = type;
        this.nightRate = nightRate;
    }

    public int getRoomNumber() {
        return this.roomNumber;
    }

    public RoomType getType() {
        return this.type;
    }

    public double getNightRate() {
        return this.nightRate;
    }

    public double payBill(int nights) {
        return (this.nightRate * nights);
    }
}