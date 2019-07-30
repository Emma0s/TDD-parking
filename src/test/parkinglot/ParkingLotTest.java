package parkinglot;

import exception.NoAvailableReceiptException;
import exception.NoAvailiableParkinglotException;
import org.junit.*;


public class ParkingLotTest {
    @Test(expected = NoAvailiableParkinglotException.class)
    public void should_failure_when_one_car_parking_given_zero_parkinglot() throws NoAvailiableParkinglotException {
        ParkingLot parkingLot = new ParkingLot(0);
        parkingLot.park(new Car());
    }

    @Test
    public void should_success_with_one_receipt_when_one_car_parking_given_one_parkinglot() throws NoAvailiableParkinglotException {
        ParkingLot parkingLot = new ParkingLot(1);
        ParkingLotReceipt receipt = parkingLot.park(new Car());
        Assert.assertNotNull(receipt);
    }

    @Test(expected = NoAvailiableParkinglotException.class)
    public void should_success_with_one_receipt_when_two_car_parking_given_one_parkinglot() throws NoAvailiableParkinglotException {
        ParkingLot parkingLot = new ParkingLot(1);
        ParkingLotReceipt receipt = parkingLot.park(new Car());
        parkingLot.park(new Car());
        Assert.assertNotNull(receipt);
    }

    @Test
    public void should_success_with_two_receipt_when_two_car_parking_given_two_parkinglot() throws NoAvailiableParkinglotException {
        ParkingLot parkingLot = new ParkingLot(2);
        ParkingLotReceipt receipt1 = parkingLot.park(new Car());
        ParkingLotReceipt receipt2 = parkingLot.park(new Car());
        Assert.assertNotNull(receipt1);
        Assert.assertNotNull(receipt2);
    }

    @Test(expected = NoAvailableReceiptException.class)
    public void should_failure_with_zero_receipt_when_getting_car(){
        ParkingLot parkingLot = new ParkingLot(1);
        parkingLot.get(null);
    }

    @Test
    public void should_success_with_one_receipt_when_getting_car() throws NoAvailiableParkinglotException {
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
    public void should_success_first_with_one_receipt_when_getting_car_twice() throws NoAvailiableParkinglotException {
        ParkingLot parkingLot = new ParkingLot(1);
        Car myCar = new Car();
        ParkingLotReceipt parkingLotReceipt = parkingLot.park(myCar);
        Assert.assertSame(myCar,parkingLot.get(parkingLotReceipt));
        parkingLot.get(parkingLotReceipt);
    }

}

