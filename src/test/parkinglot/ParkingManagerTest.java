package parkinglot;

import exception.NoAvailableParkingLotException;
import exception.NoAvailableReceiptException;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class ParkingManagerTest {
    @Test
    public void should_success_with_own_1_parkingBoy_manage_1_parkingLot_has_1_space_when_parking_1_car(){
        ParkingLot parkingLot = new ParkingLot(1);
        GraduateBoy graduateBoy = new GraduateBoy(Arrays.asList(parkingLot));
        ParkingManager parkingManager = new ParkingManager(Arrays.asList(graduateBoy));

        Car car = new Car();
        ParkingLotReceipt receipt = parkingManager.park(car);

        Assert.assertSame(car,parkingManager.get(receipt));
    }

    @Test(expected = NoAvailableParkingLotException.class)
    public void should_failure_with_own_1_parkingBoy_manage_1_parkingLot_has_0_space_when_parking_1_car() {
        ParkingLot parkingLot = new ParkingLot(1);
        SmartBoy smartBoy = new SmartBoy(Arrays.asList(parkingLot));
        smartBoy.park(new Car());

        ParkingManager parkingManager = new ParkingManager(Arrays.asList(smartBoy));
        parkingManager.park(new Car());
    }

    @Test
    public void should_success_with_own_2_parkingBoy_each_manage_2_parkingLot_has_1_space_when_parking_1_car(){
        ParkingLot parkingLot1 = new ParkingLot(0);
        ParkingLot parkingLot2 = new ParkingLot(1);
        ParkingLot parkingLot3 = new ParkingLot(0);
        SmartBoy smartBoy = new SmartBoy(Arrays.asList(parkingLot1,parkingLot2));
        SuperBoy superBoy = new SuperBoy(Arrays.asList(parkingLot2,parkingLot3));

        ParkingManager parkingManager = new ParkingManager(Arrays.asList(smartBoy,superBoy));
        Car car = new Car();
        ParkingLotReceipt receipt = parkingManager.park(car);

        Assert.assertSame(car,parkingManager.get(receipt));
    }

    @Test(expected = NoAvailableParkingLotException.class)
    public void should_success_first_with_own_2_parkingBoy_each_manage_2_parkingLot_has_1_space_when_parking_2_car(){
        ParkingLot parkingLot1 = new ParkingLot(0);
        ParkingLot parkingLot2 = new ParkingLot(1);
        ParkingLot parkingLot3 = new ParkingLot(0);
        GraduateBoy graduateBoy = new GraduateBoy(Arrays.asList(parkingLot1,parkingLot2));
        SuperBoy superBoy = new SuperBoy(Arrays.asList(parkingLot1,parkingLot3));

        ParkingManager parkingManager = new ParkingManager(Arrays.asList(graduateBoy,superBoy));

        Car car1 = new Car();
        Car car2 = new Car();
        Assert.assertNotNull(parkingManager.park(car1));
        parkingManager.park(car2);
    }

    @Test(expected = NoAvailableReceiptException.class)
    public void should_failure_with_own_1_parkingBoy_with_1_fake_receipt_when_get_1_car(){
        ParkingLot parkingLot = new ParkingLot(1);
        SuperBoy superBoy = new SuperBoy(Arrays.asList(parkingLot));
        ParkingManager parkingManager = new ParkingManager(Arrays.asList(superBoy));

        ParkingLotReceipt receipt = new ParkingLotReceipt();
        parkingManager.get(receipt);
    }

}
