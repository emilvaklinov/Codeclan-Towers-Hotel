import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class HotelTest {

    Guest guest1;
    Guest guest2;
    Guest guest3;
    BedRoom apartment;
    BedRoom doubleBedroom;
    BedRoom singleBedroom;
    ConferenceRoom conferenceRoom1;
    DiningRoom diningRoom1;
    DiningRoom diningRoom2;
    Hotel codeClanTowers;

    @Before
    public void before(){
        guest1 = new Guest("Emil");
        guest2 = new Guest("Alex");
        guest3 = new Guest("Sam");
        singleBedroom = new BedRoom(4, RoomType.SINGLE, 35);
        doubleBedroom = new BedRoom(8, RoomType.DOUBLE, 50);
        apartment = new BedRoom(1, RoomType.APARTMENT, 120);
        conferenceRoom1 = new ConferenceRoom(6, "Fast meeting", 105);
        diningRoom1 = new DiningRoom(50);
        diningRoom2 = new DiningRoom(10);
        codeClanTowers = new Hotel("CodeClan Towers");

        codeClanTowers.addRoomCategory("Bedrooms");
        codeClanTowers.addRoomCategory("Conference Rooms");
        codeClanTowers.addRoomCategory("Dining Rooms");

        codeClanTowers.addRoom("Bedrooms", apartment);
        codeClanTowers.addRoom("Bedrooms", singleBedroom);
//        codeClanTowers.addRoom("Bedrooms", doubleBedroom);
        codeClanTowers.addRoom("Conference Rooms", conferenceRoom1);
        codeClanTowers.addRoom("Conference Rooms", diningRoom1);
        codeClanTowers.addRoom("Dining Rooms", diningRoom2);

    }

    @Test
    public void hasName(){
        assertEquals("CodeClan Towers", codeClanTowers.getName());
    }

    @Test
    public void hasRooms(){
        assertEquals(3, codeClanTowers.getAllRooms().size());
    }

    @Test
    public void canGetAllRoomsOfACategory(){
        assertEquals(1, codeClanTowers.getCategoryRooms("Dining Rooms").size());
        assertEquals(2, codeClanTowers.getCategoryRooms("Bedrooms").size());
    }

    @Test
    public void canGetAllRoomCategories(){
        ArrayList<String> expected = new ArrayList<>();
        expected.add("Dining Rooms");
        expected.add("Bedrooms");
        expected.add("Conference Rooms");
        assertEquals(expected, codeClanTowers.getRoomCategories());
    }

    @Test
    public void canAddRoomCategory(){
        codeClanTowers.addRoomCategory("Test");
        assertEquals(4, codeClanTowers.getAllRooms().size());
    }

    @Test
    public void canAddRoomToHotel(){
        codeClanTowers.addRoom("Bedrooms", doubleBedroom);
        ArrayList<Room> expectedRooms = new ArrayList<>();
        expectedRooms.add(apartment);
        expectedRooms.add(singleBedroom);
        expectedRooms.add(doubleBedroom);
        assertEquals(expectedRooms, codeClanTowers.getAllRooms().get("Bedrooms"));
    }

    @Test
    public void canNotAddRoomToHotelWithInvalidCategory(){
        codeClanTowers.addRoom("Null", doubleBedroom);
        assertEquals(3, codeClanTowers.getAllRooms().size());
    }

    @Test
    public void canCheckInGuestToSpecificRoom(){
        codeClanTowers.checkInGuest(guest1, "Bedrooms", apartment);
        assertEquals(1, apartment.guestCount());
    }

    @Test
    public void canNotCheckInGuestToRoomNotInHotel(){
        codeClanTowers.checkInGuest(guest2, "Bedrooms", doubleBedroom);
        assertEquals(0, doubleBedroom.guestCount());
    }

    @Test
    public void canNotCheckInGuestTwiceToSameRoom(){
        codeClanTowers.checkInGuest(guest2, "Bedrooms", apartment);
        codeClanTowers.checkInGuest(guest2, "Bedrooms", apartment);
        assertEquals(1, apartment.guestCount());
    }

    @Test
    public void canCheckOutGuest(){
        codeClanTowers.checkInGuest(guest1, "Bedrooms", apartment);
        assertEquals(1, apartment.guestCount());
        codeClanTowers.checkOutGuest(guest1, "Bedrooms", apartment);
        assertEquals(0, apartment.guestCount());
    }

    @Test
    public void canNotCheckOutGuestFromWrongRoom(){
        codeClanTowers.checkInGuest(guest1, "Bedrooms", apartment);
        assertEquals(1, apartment.guestCount());
        codeClanTowers.checkOutGuest(guest1, "Conference Rooms", conferenceRoom1);
        assertEquals(1, apartment.guestCount());
        assertEquals(0, conferenceRoom1.guestCount());
    }

    @Test
    public void canGetListOfCurrentGuestsFromRoom(){
        codeClanTowers.checkInGuest(guest1, "Bedrooms", apartment);
        codeClanTowers.checkInGuest(guest2, "Bedrooms", apartment);
        ArrayList<Guest> expectedGuests = new ArrayList<>();
        expectedGuests.add(guest1);
        expectedGuests.add(guest2);
        assertEquals(expectedGuests, codeClanTowers.listGuests("Bedrooms", apartment));
    }

    @Test
    public void canListEmptyRoomsInARoomCategory(){
        codeClanTowers.checkInGuest(guest1, "Bedrooms", apartment);
        ArrayList<Room> expectedRooms = new ArrayList<>();
        expectedRooms.add(singleBedroom);
        assertEquals(expectedRooms, codeClanTowers.listEmptyRooms("Bedrooms"));
    }

//    @Test
//    public void can

}
