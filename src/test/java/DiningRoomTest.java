import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DiningRoomTest {

    Guest guest1;
    Guest guest2;
    Guest guest3;
    DiningRoom diningRoom1;
    DiningRoom diningRoom2;


    @Before
    public void before(){
        guest1 = new Guest("Emil");
        guest2 = new Guest("Alex");
        guest3 = new Guest("Sam");
        diningRoom1 = new DiningRoom(50);
        diningRoom2 = new DiningRoom(10);

    }

    @Test
    public void hasCapacity(){
        assertEquals(50, diningRoom1.getCapacity());
        assertEquals(10, diningRoom2.getCapacity());
    }


    @Test
    public void startsNoGuests(){
        assertEquals(0, diningRoom1.guestCount());
    }

    @Test
    public void canAddGuests(){
        diningRoom1.addGuest(guest1);
        diningRoom1.addGuest(guest2);
        assertEquals(2, diningRoom1.guestCount());
    }

    @Test
    public void canRemoveGuests(){
        diningRoom1.addGuest(guest1);
        assertEquals(1, diningRoom1.guestCount());
        diningRoom1.removeGuest(guest1);
        assertEquals(0, diningRoom1.guestCount());
    }

    @Test
    public void spacesLeft(){
        diningRoom1.addGuest(guest1);
        assertEquals(49, diningRoom1.spacesLeft());
    }

    @Test
    public void canNotAddGuests(){
        diningRoom1.addGuest(guest1);
        diningRoom1.addGuest(guest2);
        diningRoom1.addGuest(guest3);
        assertEquals(3, diningRoom1.guestCount());
    }

    @Test
    public void canNotRemoveGuest(){
        diningRoom1.addGuest(guest1);
        diningRoom1.addGuest(guest2);
        diningRoom1.removeGuest(guest3);
        assertEquals(2, diningRoom1.guestCount());
    }


}
