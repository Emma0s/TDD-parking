package parkinglot;

import exception.NoAvailableReceiptException;
import exception.NoAvailableParkingLotException;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {

    protected int totalSpace;
    protected final Map<ParkingLotReceipt,Car> parkingLotReceipts = new HashMap<>();

    public ParkingLot(int totalSpace) {
        this.totalSpace = totalSpace;
    }

    public ParkingLotReceipt park(Car car) {
        if (hasAvailiableParkinglot()){
            return giveReceipt(car);
        } else {
            throw new NoAvailableParkingLotException("当前可用车位为0！");
        }

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
        if (totalSpace - parkingLotReceipts.size() > 0) return true;
        return false;
    }

    private boolean isReceiptValid(ParkingLotReceipt receipt){
        return parkingLotReceipts.containsKey(receipt);
    }
}
