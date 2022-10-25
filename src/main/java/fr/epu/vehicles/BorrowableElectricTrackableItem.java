package fr.epu.vehicles;

public class BorrowableElectricTrackableItem extends ElectricTrackableItem implements BorrowableTrackableItem {
    private boolean borrowed = false;

    public BorrowableElectricTrackableItem(Battery battery, GPS gps) {
        super(battery, gps);
    }
    protected BorrowableElectricTrackableItem() {
        super(new Battery(), new GPS());
        this.battery.charge(INITIAL_CHARGE);
    }
    @Override
    public boolean isBorrowable() {
        return !borrowed;
    }

    @Override
    public void borrow() {
        if (this.getChargePercent() < 20) {
            throw new IllegalStateException("The vehicle is not charged enough");
        }

        if (borrowed) {
            throw new IllegalStateException("Vehicle already borrowed");
        }
        borrowed = true;
    }


    @Override
    public void returnBorrowable() {
        if (!borrowed) {
            throw new IllegalStateException("Vehicle already returned");
        }
        borrowed = false;

    }
}

