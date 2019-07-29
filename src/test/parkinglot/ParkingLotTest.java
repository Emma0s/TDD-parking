package parkinglot;

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
    public void should_succes_with_two_receipt_when_two_car_parking_given_two_parkinglot() throws NoAvailiableParkinglotException {
        ParkingLot parkingLot = new ParkingLot(2);
        ParkingLotReceipt receipt1 = parkingLot.park(new Car());
        ParkingLotReceipt receipt2 = parkingLot.park(new Car());
        Assert.assertNotNull(receipt1);
        Assert.assertNotNull(receipt2);
    }



}

