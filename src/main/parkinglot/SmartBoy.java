package parkinglot;

import exception.NoAvailableParkingLotException;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class SmartBoy extends ParkingBoy {

    public SmartBoy(List<ParkingLot> parkingLots) {
        super(parkingLots);
    }

    @Override
    public ParkingLotReceipt park(Car car) {

        Optional<ParkingLot> parkingLot = parkingLots.stream().max(Comparator.comparing(ParkingLot::getFreeSpace));
        if (parkingLot.isPresent()){
            return parkingLot.get().park(car);
        }
        throw  new NoAvailableParkingLotException("当前无可用车位！");
    }
}
