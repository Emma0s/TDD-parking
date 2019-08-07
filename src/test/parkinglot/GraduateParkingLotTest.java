package parkinglot;

import exception.NoAvailableReceiptException;
import exception.NoAvailableParkingLotException;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class GraduateParkingLotTest {
    @Test
    public void should_success_with_parkinglot1_has_1_parkinglot_when_1_car_parking() {
        ParkingLot parkingLot1 = new ParkingLot(1);
        ParkingLot parkingLot2 = new ParkingLot(0);
        Employee employee = new Employee(Arrays.asList(parkingLot1, parkingLot2));

        Car car = new Car();
        ParkingLotReceipt receipt = employee.park(car);

        Assert.assertSame(car,employee.get(receipt));
    }

    @Test
    public void should_success_with_parkinglot2_has_1_parkinglot_when_1_car_parking() {
        ParkingLot parkingLot1 = new ParkingLot(0);
        ParkingLot parkingLot2 = new ParkingLot(1);
        Employee employee = new Employee(Arrays.asList(parkingLot1, parkingLot2));

        Car car = new Car();
        ParkingLotReceipt receipt = employee.park(car);

        Assert.assertSame(car,employee.get(receipt));
    }

    @Test
    public void should_success_with_parkinglot1_parkinglot2_both_have_1_parkinglot_when_1_car_parking() {
        ParkingLot parkingLot1 = new ParkingLot(1);
        ParkingLot parkingLot2 = new ParkingLot(1);
        Employee employee = new Employee(Arrays.asList(parkingLot1,parkingLot2));

        Car car = new Car();
        ParkingLotReceipt receipt = employee.park(car);

        Assert.assertSame(car,employee.get(receipt));
    }

    @Test(expected = NoAvailableParkingLotException.class)
    public void should_success_first_car_with_only_parkinglot1_has_1_parkinglot_when_2_car_parking() {
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
    public void should_success_with_1_true_receipt_when_pick_up_car() {
        ParkingLot parkingLot1 = new ParkingLot(1);
        ParkingLot parkingLot2 = new ParkingLot(1);
        Employee employee = new Employee(Arrays.asList(parkingLot1,parkingLot2));

        Car car = new Car();
        ParkingLotReceipt receipt = parkingLot2.park(car);

        Assert.assertSame(car,employee.get(receipt));
    }

    @Test(expected = NoAvailableReceiptException.class)
    public void should_success_fist_with_1_true_receipt_when_pick_up_twice() {
        ParkingLot parkingLot1 = new ParkingLot(1);
        ParkingLot parkingLot2 = new ParkingLot(1);
        Employee employee = new Employee(Arrays.asList(parkingLot1,parkingLot2));

        Car car = new Car();
        ParkingLotReceipt receipt = parkingLot1.park(car);

        Assert.assertSame(car,employee.get(receipt));
        employee.get(receipt);
    }
}
