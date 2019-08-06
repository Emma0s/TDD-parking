package parkinglot;

import exception.NoAvailableReceiptException;
import exception.NoAvailiableParkinglotException;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {

    protected int freeSpace;
    private final Map<ParkingLotReceipt,Car> parkingLotReceipts = new HashMap<>();

    public ParkingLot(int freeSpace) {
        this.freeSpace = freeSpace;
    }

    public ParkingLotReceipt park(Car car) throws NoAvailiableParkinglotException {
        if (freeSpace <= 0){
            throw new NoAvailiableParkinglotException("当前可用车位为0！");
        } else {
            freeSpace --;
        }
        return giveReceipt(car);

    }
    public Car get(ParkingLotReceipt receipt) {
        if (receipt == null || !isReceiptValid(receipt)){
            throw new NoAvailableReceiptException("票据验证失败！");
        }
        return parkingLotReceipts.remove(receipt);
    }

    private ParkingLotReceipt giveReceipt(Car car){
        ParkingLotReceipt receipt = new ParkingLotReceipt();
        parkingLotReceipts.put(receipt,car);
        return receipt;
    }

    public boolean containsReceipt(ParkingLotReceipt receipt){
        if (parkingLotReceipts.containsKey(receipt)) return true;
        return false;
    }

    public boolean hasAvailiableParkinglot(){
        if (freeSpace > 0) return true;
        return false;
    }

    private boolean isReceiptValid(ParkingLotReceipt receipt){
        return parkingLotReceipts.containsKey(receipt);
    }
}
