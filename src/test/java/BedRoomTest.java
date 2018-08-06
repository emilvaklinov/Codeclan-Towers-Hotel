import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

    public class BedRoomTest {
        Guest guest1;
        Guest guest2;
        Guest guest3;
        BedRoom singleBedroom;
        BedRoom doubleBedroom;
        BedRoom apartment;

        @Before
        public void before(){
            guest1 = new Guest("Emil");
            guest2 = new Guest("Alex");
            guest3 = new Guest("Sam");
            singleBedroom = new BedRoom(4, RoomType.SINGLE, 35);
            doubleBedroom = new BedRoom(8, RoomType.DOUBLE, 50);
            apartment = new BedRoom(1, RoomType.APARTMENT, 120);

        }

        @Test
        public void hasCapacityDouble(){
            assertEquals(5, doubleBedroom.getCapacity());
        }

        @Test
        public void hasCapacitySingle(){
            assertEquals(5, singleBedroom.getCapacity());
        }

        @Test
        public void hasCapacityApartment(){
            assertEquals(6, apartment.getCapacity());
        }

        @Test
        public void startsNoGuests(){
            assertEquals(0, doubleBedroom.guestCount());
        }

        @Test
        public void canAddGuests(){
            apartment.addGuest(guest1);
            apartment.addGuest(guest2);
            assertEquals(2, apartment.guestCount());
        }

        @Test
        public void canRemoveGuests(){
            apartment.addGuest(guest1);
            assertEquals(1, apartment.guestCount());
            apartment.removeGuest(guest1);
            assertEquals(0, apartment.guestCount());
        }

        @Test
        public void spacesLeft(){
            apartment.addGuest(guest1);
            assertEquals(5, apartment.spacesLeft());
        }

        @Test
        public void canNotAddGuests(){
            apartment.addGuest(guest1);
            apartment.addGuest(guest2);
            apartment.addGuest(guest3);
            assertEquals(3, apartment.guestCount());
        }

        @Test
        public void canNotRemoveGuest(){
            apartment.addGuest(guest1);
            apartment.addGuest(guest2);
            apartment.removeGuest(guest3);
            assertEquals(2, apartment.guestCount());
        }

//     Specific tests:

        @Test
        public void hasRoomNumber(){
            assertEquals(8, doubleBedroom.getRoomNumber());
        }

        @Test
        public void hasBedRoomType(){
            assertEquals(RoomType.DOUBLE, doubleBedroom.getType());
        }

        @Test
        public void hasNightRate(){
            assertEquals(50, doubleBedroom.getNightRate(), 0);
        }

        @Test
        public void canCalculateBill(){
            double bill = doubleBedroom.payBill(3);
            assertEquals(150, bill, 0);
        }


    }
