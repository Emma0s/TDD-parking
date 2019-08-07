package parkinglot;

import exception.NoAvailableReceiptException;
import exception.NoAvailiableParkinglotException;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class SuperParkinglotTest {

    @Test
    public void should_success_with_pl1_has_0_space_1_pl_pl2_has_1_space_1_pl_when_1_car_parking(){
        ParkingLot parkingLot1 = new ParkingLot(0,1);
        ParkingLot parkingLot2 = new ParkingLot(1,1);
        SuperBoy superBoy = new SuperBoy(Arrays.asList(parkingLot1,parkingLot2));
        Assert.assertTrue(parkingLot2.containsReceipt(superBoy.park(new Car())));
    }

    @Test
    public void should_success_with_pl1_has_1_space_1_pl_pl2_has_1_space_2_pl_when_1_car_parking(){
        ParkingLot parkingLot1 = new ParkingLot(1,1);
        ParkingLot parkingLot2 = new ParkingLot(1,2);
        SuperBoy superBoy = new SuperBoy(Arrays.asList(parkingLot1,parkingLot2));
        Assert.assertTrue(parkingLot1.containsReceipt(superBoy.park(new Car())));
    }

    @Test
    public void should_success_with_pl1_has_1_space_2_pl_pl2_has_2_space_2_pl_when_1_car_parking(){
        ParkingLot parkingLot1 = new ParkingLot(1,2);
        ParkingLot parkingLot2 = new ParkingLot(2,2);
        SuperBoy superBoy = new SuperBoy(Arrays.asList(parkingLot1,parkingLot2));
        Assert.assertTrue(parkingLot2.containsReceipt(superBoy.park(new Car())));
    }

    @Test
    public void should_success_with_pl1_has_1_space_2_pl_pl2_has_2_space_2_pl_when_2_car_parking(){
        ParkingLot parkingLot1 = new ParkingLot(1,2);
        ParkingLot parkingLot2 = new ParkingLot(2,2);
        SuperBoy superBoy = new SuperBoy(Arrays.asList(parkingLot1,parkingLot2));
        Car car1 = new Car();
        Car car2 = new Car();
        ParkingLotReceipt receipt1 = superBoy.park(car1);
        ParkingLotReceipt receipt2 = superBoy.park(car2);
        Assert.assertTrue(parkingLot2.containsReceipt(receipt1));
        Assert.assertTrue(parkingLot1.containsReceipt(receipt2));
    }

    @Test(expected = NoAvailiableParkinglotException.class)
    public void should_failure_with_pl1_has_0_space_1_pl_pl2_has_0_space_2_pl_when_1_car_parking(){
        ParkingLot parkingLot1 = new ParkingLot(0,1);
        ParkingLot parkingLot2 = new ParkingLot(0,2);
        SuperBoy superBoy = new SuperBoy(Arrays.asList(parkingLot1,parkingLot2));
        superBoy.park(new Car());
    }

    @Test
    public void should_success_with_1_true_receipt_when_getting_car(){
        ParkingLot parkingLot1 = new ParkingLot(0,1);
        ParkingLot parkingLot2 = new ParkingLot(1,1);
        SuperBoy superBoy = new SuperBoy(Arrays.asList(parkingLot1,parkingLot2));
        Car car = new Car();
        ParkingLotReceipt receipt = parkingLot2.park(car);
        Assert.assertSame(car,superBoy.get(receipt));
    }

    @Test(expected = NoAvailableReceiptException.class)
    public void should_success_first_with_1_true_receipt_when_getting_car_twice(){
        ParkingLot parkingLot1 = new ParkingLot(0,1);
        ParkingLot parkingLot2 = new ParkingLot(1,1);
        SuperBoy superBoy = new SuperBoy(Arrays.asList(parkingLot1,parkingLot2));
        Car car = new Car();
        ParkingLotReceipt receipt = parkingLot2.park(car);
        Assert.assertSame(car,superBoy.get(receipt));
        superBoy.get(receipt);
    }

    @Test(expected = NoAvailableReceiptException.class)
    public void should_failure_with_fake_receipt_when_getting_car(){
        ParkingLot parkingLot1 = new ParkingLot(0,1);
        ParkingLot parkingLot2 = new ParkingLot(1,1);
        SuperBoy superBoy = new SuperBoy(Arrays.asList(parkingLot1,parkingLot2));
        ParkingLotReceipt receipt = new ParkingLotReceipt();
        superBoy.get(receipt);
    }

}
