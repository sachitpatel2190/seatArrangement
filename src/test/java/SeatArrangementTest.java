import org.junit.Before;
import org.junit.Test;

public class SeatArrangementTest {

    SeatArragement seatArragement;

    @Before
    public void setUp(){
        seatArragement = new SeatArragement();
    }

    @Test(expected = Exception.class)
    public void testThrowExceptionOnExceedingNumberOfPassenger() throws Exception {

        int[][] seatsPattern = {{3,2}, {4,3}, {2,3},{3,4},{2,3}, {3,3}};
        int numberOfPassenger = 100;
        seatArragement.arrangePassenger(seatsPattern, numberOfPassenger);
    }
}
