package parkinglot;

import java.util.List;

public class SmartBoy extends Employee {

    public SmartBoy(List<ParkingLot> parkingLots) {
        super(parkingLots);
    }

    @Override
    public ParkingLotReceipt park(Car car) {
        ParkingLot maxParkinglot = null;
        int maxSpace = 0;
        for (ParkingLot parkinglot : parkingLots) {
            if (parkinglot.totalSpace - parkinglot.parkingLotReceipts.size() > maxSpace){
                maxParkinglot = parkinglot;
                maxSpace = parkinglot.totalSpace - parkinglot.parkingLotReceipts.size();
            }
        }
        return maxParkinglot.park(car);
    }
}
