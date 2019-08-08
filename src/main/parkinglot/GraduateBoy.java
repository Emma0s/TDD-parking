package parkinglot;

import exception.NoAvailableReceiptException;
import exception.NoAvailableParkingLotException;

import java.util.List;

public class GraduateBoy extends ParkingBoy {

    public GraduateBoy(List<ParkingLot> parkingLots) {
        super(parkingLots);
    }

    @Override
    public ParkingLotReceipt park(Car car) {

        for (ParkingLot parkingLot : parkingLots) {
            if (parkingLot.hasAvailableParkingLot()){
                return parkingLot.park(car);
            }
        }
        throw new NoAvailableParkingLotException("当前无可用车位！");
    }

}
