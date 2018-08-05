public enum RoomType {

    SINGLE("Single Room", 5),
    DOUBLE("Double Room", 5),
    APARTMENT("Apartments", 6);

    private String type;
    private int capacity;

    RoomType(String type, int capacity){
        this.type = type;
        this.capacity = capacity;
    }

    public int getCapacity(){
        return this.capacity;
    }

    public String getType(){
        return this.type;
    }
}
