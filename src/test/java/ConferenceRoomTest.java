import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ConferenceRoomTest {

    Guest guest1;
    Guest guest2;
    Guest guest3;
    ConferenceRoom conferenceRoom1;


    @Before
    public void before(){
        guest1 = new Guest("Emil");
        guest2 = new Guest("Alex");
        guest3 = new Guest("Sam");
        conferenceRoom1 = new ConferenceRoom(6, "Fast meeting", 105);

    }

    @Test
    public void hasCapacity(){
        assertEquals(6, conferenceRoom1.getCapacity());
    }


    @Test
    public void startsNoGuests(){
        assertEquals(0, conferenceRoom1.guestCount());
    }

    @Test
    public void canAddGuests(){
        conferenceRoom1.addGuest(guest1);
        conferenceRoom1.addGuest(guest2);
        assertEquals(2, conferenceRoom1.guestCount());
    }

    @Test
    public void canRemoveGuests(){
        conferenceRoom1.addGuest(guest1);
        assertEquals(1, conferenceRoom1.guestCount());
        conferenceRoom1.removeGuest(guest1);
        assertEquals(0, conferenceRoom1.guestCount());
    }

    @Test
    public void spacesLeft(){
        conferenceRoom1.addGuest(guest1);
        assertEquals(5, conferenceRoom1.spacesLeft());
    }

    @Test
    public void canNotAddGuests(){
        conferenceRoom1.addGuest(guest1);
        conferenceRoom1.addGuest(guest2);
        conferenceRoom1.addGuest(guest3);
        assertEquals(3, conferenceRoom1.guestCount());
    }

    @Test
    public void canNotRemoveGuest(){
        conferenceRoom1.addGuest(guest1);
        conferenceRoom1.addGuest(guest2);
        conferenceRoom1.removeGuest(guest3);
        assertEquals(2, conferenceRoom1.guestCount());
    }

//    BedRoom specific tests:

    @Test
    public void hasName(){
        assertEquals("Fast meeting", conferenceRoom1.getRoomName());
    }


    @Test
    public void hasDayRate(){
        assertEquals(105, conferenceRoom1.getDayRate(), 0);
    }

    @Test
    public void canCalculateBill(){
        double bill = conferenceRoom1.payBill(3);
        assertEquals(315, bill, 0);
    }


}
