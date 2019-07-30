package parkinglot;

import exception.NoAvailableReceiptException;
import exception.NoAvailiableParkinglotException;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {

    private int freeSpace;
    private final Map<ParkingLotReceipt,Car> parkingLotReceipts = new HashMap<>();

    public ParkingLot(int freeSpace) {
        this.freeSpace = freeSpace;
    }

    public ParkingLotReceipt park(Car car) throws NoAvailiableParkinglotException {
        if (freeSpace > 0){
            freeSpace --;
            return giveReceipt(car);
        }
        throw new NoAvailiableParkinglotException();
    }

    public Car get(ParkingLotReceipt receipt) {
        if (receipt == null || !isReceiptValid(receipt)){
            throw new NoAvailableReceiptException("No Available Receipt!");
        }
        return parkingLotReceipts.remove(receipt);
    }

    private ParkingLotReceipt giveReceipt(Car car){
        ParkingLotReceipt receipt = new ParkingLotReceipt();
        parkingLotReceipts.put(receipt,car);
        return receipt;
    }

    private boolean isReceiptValid(ParkingLotReceipt receipt){
        return parkingLotReceipts.containsKey(receipt);
    }
}
