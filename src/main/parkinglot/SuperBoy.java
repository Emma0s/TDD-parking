package parkinglot;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class SuperBoy extends ParkingBoy {

    public SuperBoy(List<ParkingLot> parkingLots) {
        super(parkingLots);
    }

    @Override
    public ParkingLotReceipt park(Car car) {
        Optional<ParkingLot> parkingLot = parkingLots.stream().max(Comparator.comparing(ParkingLot::getCurVacancyRate));
        if (parkingLot.isPresent()) {
            return parkingLot.get().park(car);
        }
        throw new NegativeArraySizeException("当前无可用车位！");
    }
}
