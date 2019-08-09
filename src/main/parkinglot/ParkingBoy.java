package parkinglot;

import exception.NoAvailableReceiptException;

import java.util.List;

public abstract class ParkingBoy {
    protected List<ParkingLot> parkingLots;

    public ParkingBoy(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }

    public abstract ParkingLotReceipt park(Car car);

    public Car get(ParkingLotReceipt receipt){
        for (ParkingLot parkingLot : parkingLots) {
            if (parkingLot.isValidReceipt(receipt)){
                return parkingLot.get(receipt);
            }
        }
        throw new NoAvailableReceiptException("票据验证失败！");
    }

    public boolean hasAvailableParkingLot(){
        return parkingLots.stream().anyMatch(ParkingLot::hasAvailableParkingLot);
    }

    public boolean isValidReceipt(ParkingLotReceipt receipt){
        for (ParkingLot parkingLot : parkingLots) {
            return parkingLot.isValidReceipt(receipt);
        }
        throw new NoAvailableReceiptException("票据验证失败!");
    }
}
