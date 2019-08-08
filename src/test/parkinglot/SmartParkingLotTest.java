package parkinglot;

import exception.NoAvailableReceiptException;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class SmartParkingLotTest {
    @Test
    public void should_success_with_only_parkinglot2_has_1_parkinglot_when_1_car_parking(){
        ParkingLot parkingLot1 = new ParkingLot(0);
        ParkingLot parkingLot2 = new ParkingLot(1);
        SmartBoy smartBoy = new SmartBoy(Arrays.asList(parkingLot1,parkingLot2));

        Car car = new Car();
        ParkingLotReceipt receipt = smartBoy.park(car);

        Assert.assertTrue(parkingLot2.isValidReceipt(receipt));
    }

    @Test
    public void should_success_with_parkinglot1_has_1_parkinglot_parkinglot2_has_2_parkinglot_when_1_car_parking(){
        ParkingLot parkingLot1 = new ParkingLot(1);
        ParkingLot parkingLot2 = new ParkingLot(2);
        SmartBoy smartBoy = new SmartBoy(Arrays.asList(parkingLot1,parkingLot2));

        ParkingLotReceipt receipt = smartBoy.park(new Car());

        Assert.assertTrue(parkingLot2.isValidReceipt(receipt));
    }

    @Test
    public void should_success_with_parkinglot1_has_2_parkinglot_parkinglot2_has_1_parkinglot_when_1_car_parking(){
        ParkingLot parkingLot1 = new ParkingLot(2);
        ParkingLot parkingLot2 = new ParkingLot(1);
        SmartBoy smartBoy = new SmartBoy(Arrays.asList(parkingLot1,parkingLot2));

        Car car = new Car();
        ParkingLotReceipt receipt = smartBoy.park(car);

        Assert.assertTrue(parkingLot1.isValidReceipt(receipt));
    }

    @Test
    public void should_success_with_parkinglot1_has_1_parkinglot_parkinglot2_has_2_parkinglot_when_2_car_parking(){
        ParkingLot parkingLot1 = new ParkingLot(1);
        ParkingLot parkingLot2 = new ParkingLot(2);
        SmartBoy smartBoy = new SmartBoy(Arrays.asList(parkingLot1,parkingLot2));

        Car car1 = new Car();
        Car car2 = new Car();
        ParkingLotReceipt receipt1 = smartBoy.park(car1);
        ParkingLotReceipt receipt2 = smartBoy.park(car2);

        Assert.assertTrue(parkingLot2.isValidReceipt(receipt1));
        Assert.assertTrue(parkingLot1.isValidReceipt(receipt2));
    }

    @Test
    public void should_success_with_1_true_receipt_when_getting_car(){
        ParkingLot parkingLot1 = new ParkingLot(0);
        ParkingLot parkingLot2 = new ParkingLot(1);
        SmartBoy smartBoy = new SmartBoy(Arrays.asList(parkingLot1,parkingLot2));

        Car car = new Car();
        ParkingLotReceipt receipt = parkingLot2.park(car);

        Assert.assertSame(car,smartBoy.get(receipt));
    }

    @Test(expected = NoAvailableReceiptException.class)
    public void should_success_with_1_true_receipt_when_getting_car_twice(){
        ParkingLot parkingLot1 = new ParkingLot(0);
        ParkingLot parkingLot2 = new ParkingLot(1);
        SmartBoy smartBoy = new SmartBoy(Arrays.asList(parkingLot1,parkingLot2));

        Car car = new Car();
        ParkingLotReceipt receipt = parkingLot2.park(car);

        Assert.assertSame(car,smartBoy.get(receipt));
        smartBoy.get(receipt);
    }

    @Test(expected = NoAvailableReceiptException.class)
    public void should_failure_with_fake_receipt_when_getting_car(){
        ParkingLot parkingLot1 = new ParkingLot(0);
        ParkingLot parkingLot2 = new ParkingLot(1);
        SmartBoy smartBoy = new SmartBoy(Arrays.asList(parkingLot1,parkingLot2));

        ParkingLotReceipt receipt = new ParkingLotReceipt();
        smartBoy.get(receipt);
    }

}
