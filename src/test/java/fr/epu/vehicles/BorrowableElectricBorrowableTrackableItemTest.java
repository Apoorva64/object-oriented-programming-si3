package fr.epu.vehicles;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class BorrowableElectricBorrowableTrackableItemTest {

    @Test
    void borrow() {
        BorrowableElectricTrackableItem vehicle = new BorrowableElectricTrackableItem(new Battery(50), new GPS());
        vehicle.charge(50);
        vehicle.borrow();
    }

    @Test
    void returnBorrowable() {
        BorrowableElectricTrackableItem vehicle = new BorrowableElectricTrackableItem(new Battery(50), new GPS());
        vehicle.charge(50);
        vehicle.borrow();
        vehicle.returnBorrowable();
    }

    @Test
    void borrowNotEnoughCharge() {
        BorrowableElectricTrackableItem vehicle = new BorrowableElectricTrackableItem(new Battery(10), new GPS());
        assertThrows(IllegalStateException.class, vehicle::borrow);
    }

    @Test
    void borrowAlreadyBorrowed() {
        BorrowableElectricTrackableItem vehicle = new BorrowableElectricTrackableItem(new Battery(50), new GPS());
        vehicle.charge(50);
        vehicle.borrow();
        assertThrows(IllegalStateException.class, vehicle::borrow);
    }

    @Test
    void returnAlreadyReturned() {
        BorrowableElectricTrackableItem vehicle = new BorrowableElectricTrackableItem(new Battery(50), new GPS());
        assertThrows(IllegalStateException.class, vehicle::returnBorrowable);
    }

}