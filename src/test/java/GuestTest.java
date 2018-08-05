import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GuestTest {
    Guest guest1;

    @Before
    public void before() {
        guest1 = new Guest("Emil");
    }

    @Test
    public void hasName(){
    assertEquals("Emil", guest1.getName());
}
}
