package parkinglot;

import exception.NoAvailableReceiptException;
import exception.NoAvailiableParkinglotException;
import org.junit.*;

import java.util.Arrays;
import java.util.List;


public class ParkingLotTest {
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
    public void should_success_with_1_receipt_when_getting_car() throws NoAvailiableParkinglotException {
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


    @Test
    public void should_success_with_parkinglot1_has_1_space_when_1_car_parking() throws NoAvailiableParkinglotException {
        ParkingLot parkingLot1 = new ParkingLot(1);
        ParkingLot parkingLot2 = new ParkingLot(0);
        Employee employee = new Employee(Arrays.asList(parkingLot1, parkingLot2));
        Car car = new Car();
        ParkingLotReceipt receipt = employee.park(car);
        Assert.assertSame(car,employee.get(receipt));
    }

    @Test
    public void should_success_with_parkinglot2_has_1_space_when_1_car_parking() throws NoAvailiableParkinglotException {
        ParkingLot parkingLot1 = new ParkingLot(0);
        ParkingLot parkingLot2 = new ParkingLot(1);
        Employee employee = new Employee(Arrays.asList(parkingLot1, parkingLot2));
        Car car = new Car();
        ParkingLotReceipt receipt = employee.park(car);
        Assert.assertSame(car,employee.get(receipt));
    }

    @Test
    public void should_success_with_parkinglot1_parkinglot2_both_have_1_space_when_1_car_parking() throws NoAvailiableParkinglotException {
        ParkingLot parkingLot1 = new ParkingLot(1);
        ParkingLot parkingLot2 = new ParkingLot(1);
        Employee employee = new Employee(Arrays.asList(parkingLot1,parkingLot2));
        Car car = new Car();
        ParkingLotReceipt receipt = employee.park(car);
        Assert.assertSame(car,employee.get(receipt));
    }

    @Test(expected = NoAvailiableParkinglotException.class)
    public void should_success_first_car_with_only_parkinglot1_has_1_space_when_2_car_parking() throws NoAvailiableParkinglotException {
        ParkingLot parkingLot1 = new ParkingLot(1);
        ParkingLot parkingLot2 = new ParkingLot(0);
        Employee employee = new Employee(Arrays.asList(parkingLot1,parkingLot2));
        Car car1 = new Car();
        Car car2 = new Car();
        ParkingLotReceipt receipt = employee.park(car1);
        Assert.assertNotNull(receipt);
        employee.park(car2);
    }

    @Test
    public void should_success_with_1_true_receipt_when_pick_up_car() throws NoAvailiableParkinglotException {
        ParkingLot parkingLot1 = new ParkingLot(0);
        ParkingLot parkingLot2 = new ParkingLot(1);
        Employee employee = new Employee(Arrays.asList(parkingLot1,parkingLot2));
        Car car = new Car();
        ParkingLotReceipt receipt = parkingLot2.park(car);
        Assert.assertSame(car,employee.get(receipt));
    }

    @Test(expected = NoAvailableReceiptException.class)
    public void should_success_fist_with_1_true_receipt_when_pick_up_twice() throws NoAvailiableParkinglotException {
        ParkingLot parkingLot1 = new ParkingLot(1);
        ParkingLot parkingLot2 = new ParkingLot(0);
        Employee employee = new Employee(Arrays.asList(parkingLot1,parkingLot2));
        Car car = new Car();
        ParkingLotReceipt receipt = parkingLot1.park(car);
        Assert.assertSame(car,employee.get(receipt));
        employee.get(receipt);
    }
}

