package parkinglot;

import exception.NoAvailableReceiptException;
import exception.NoAvailiableParkinglotException;
import org.junit.*;

public class ParkinglotTest {
    @Test(expected = NoAvailiableParkinglotException.class)
    public void should_failure_when_1_car_parking_given_0_parkinglot() throws NoAvailiableParkinglotException {
        ParkingLot parkingLot = new ParkingLot(0);
        parkingLot.park(new Car());
    }

    @Test
    public void should_success_with_1_receipt_when_1_car_parking_given_1_parkinglot() throws NoAvailiableParkinglotException {
        ParkingLot parkingLot = new ParkingLot(1);
        ParkingLotReceipt receipt = parkingLot.park(new Car());
        Assert.assertNotNull(receipt);
    }

    @Test(expected = NoAvailiableParkinglotException.class)
    public void should_success_with_1_receipt_when_2_car_parking_given_2_parkinglot() throws NoAvailiableParkinglotException {
        ParkingLot parkingLot = new ParkingLot(1);
        ParkingLotReceipt receipt = parkingLot.park(new Car());
        parkingLot.park(new Car());
        Assert.assertNotNull(receipt);
    }

    @Test
    public void should_success_with_2_receipt_when_2_car_parking_given_2_parkinglot() throws NoAvailiableParkinglotException {
        ParkingLot parkingLot = new ParkingLot(2);
        ParkingLotReceipt receipt1 = parkingLot.park(new Car());
        ParkingLotReceipt receipt2 = parkingLot.park(new Car());
        Assert.assertNotNull(receipt1);
        Assert.assertNotNull(receipt2);
    }

    @Test(expected = NoAvailableReceiptException.class)
    public void should_failure_with_0_receipt_when_getting_car(){
        ParkingLot parkingLot = new ParkingLot(1);
        parkingLot.get(null);
    }

    @Test
    public void should_success_with_1_true_receipt_when_getting_car() throws NoAvailiableParkinglotException {
        ParkingLot parkingLot = new ParkingLot(1);
        Car myCar = new Car();
        ParkingLotReceipt receipt = parkingLot.park(myCar);
        Assert.assertSame(myCar,parkingLot.get(receipt));
    }

    @Test(expected = NoAvailableReceiptException.class)
    public void should_failure_with_fake_receipt_when_getting_car() throws NoAvailiableParkinglotException {
        ParkingLot parkingLot = new ParkingLot(1);
        ParkingLotReceipt receipt = new ParkingLotReceipt();
        parkingLot.get(receipt);
    }

    @Test(expected = NoAvailableReceiptException.class)
    public void should_success_first_with_1_receipt_when_getting_car_twice() throws NoAvailiableParkinglotException {
        ParkingLot parkingLot = new ParkingLot(1);
        Car myCar = new Car();
        ParkingLotReceipt parkingLotReceipt = parkingLot.park(myCar);
        Assert.assertSame(myCar,parkingLot.get(parkingLotReceipt));
        parkingLot.get(parkingLotReceipt);
    }

}

