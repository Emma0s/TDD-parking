package parkinglot;

import exception.NoAvailableParkingLotException;

import java.util.List;

public class SuperBoy extends GraduateBoy {

    public SuperBoy(List<ParkingLot> parkingLots) {
        super(parkingLots);
    }

    @Override
    public ParkingLotReceipt park(Car car) {
        for (ParkingLot parkingLot : parkingLots) {
            if (parkingLot.hasAvailableParkingLot()){
                ParkingLot chooseParkingLot = chooseAvailableParkingLot(parkingLots);
                return chooseParkingLot.park(car);
            }
        }
        throw new NoAvailableParkingLotException("当前可用车位为0！");
    }


    protected ParkingLot chooseAvailableParkingLot(List<ParkingLot> parkingLots) {
        double maxVacancyRate = 0;
        ParkingLot maxParkinglot = null;
        for (ParkingLot parkinglot : parkingLots) {
            int freeSpace = parkinglot.totalSpace - parkinglot.parkingLotReceipts.size();
            double curVacancyRate = (double)freeSpace / parkinglot.totalSpace;
            if (curVacancyRate > maxVacancyRate) {
                maxParkinglot = parkinglot;
                maxVacancyRate = curVacancyRate;
            }
        }
        return maxParkinglot;
    }
}
