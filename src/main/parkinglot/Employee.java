package parkinglot;

import exception.NoAvailableReceiptException;
import exception.NoAvailiableParkinglotException;

import java.util.List;

public class Employee {

    protected List<ParkingLot> parkingLots;

    public Employee(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }

    public ParkingLotReceipt park(Car car) throws NoAvailiableParkinglotException {

        for (ParkingLot parkingLot : parkingLots) {
            if (parkingLot.hasAvailiableParkinglot() == true){
                return parkingLot.park(car);
            }
        }
        throw new NoAvailiableParkinglotException("当前可用车位为0！");
    }

    public Car get(ParkingLotReceipt receipt) {
        for (ParkingLot parkingLot : parkingLots) {
            if (parkingLot.containsReceipt(receipt)){
                return parkingLot.get(receipt);
            }
        }
        throw new NoAvailableReceiptException("票据验证失败!");
    }
}
