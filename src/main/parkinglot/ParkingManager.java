package parkinglot;

import exception.NoAvailableParkingLotException;
import exception.NoAvailableReceiptException;

import java.util.List;

public class ParkingManager{

    private List<ParkingBoy> parkingBoys;

    public ParkingManager(List<ParkingBoy> parkingBoys) {
        this.parkingBoys = parkingBoys;
    }

    public ParkingLotReceipt park(Car car) {
        for (ParkingBoy parkingBoy: parkingBoys) {
            if (parkingBoy.hasAvailableParkingLot()) return parkingBoy.park(car);
        }
        throw new NoAvailableParkingLotException("当前无可用车位！");
    }

    public Car get(ParkingLotReceipt receipt) {
        for (ParkingBoy parkingBoy : parkingBoys){
            if (parkingBoy.isValidReceipt(receipt)) return parkingBoy.get(receipt);
        }
        throw new NoAvailableReceiptException("票据验证失败！");
    }
}
