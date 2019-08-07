package parkinglot;

import exception.NoAvailiableParkinglotException;

import java.util.List;

public class SuperBoy extends Employee {

    public SuperBoy(List<ParkingLot> parkingLots) {
        super(parkingLots);
    }

    @Override
    public ParkingLotReceipt park(Car car) throws NoAvailiableParkinglotException {
        for (ParkingLot parkingLot : parkingLots) {
            if (parkingLot.hasAvailiableParkinglot()){
                ParkingLot chooseParkingLot = chooseAvailableParkinglot(parkingLots);
                return chooseParkingLot.park(car);
            }
        }
        throw new NoAvailiableParkinglotException("当前可用车位为0！");
    }


    protected ParkingLot chooseAvailableParkinglot(List<ParkingLot> parkingLots) {
        double maxVacancyRate = 0;
        ParkingLot maxParkinglot = null;
        for (ParkingLot parkinglot : parkingLots) {
            double curVacancyRate = (float) parkinglot.freeSpace / parkinglot.totalSpace;
            if (curVacancyRate > maxVacancyRate) {
                maxParkinglot = parkinglot;
                maxVacancyRate = curVacancyRate;
            }
        }
        return maxParkinglot;
    }
}
