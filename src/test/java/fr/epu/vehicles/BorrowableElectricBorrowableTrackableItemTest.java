package fr.epu.vehicles;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class BorrowableElectricBorrowableTrackableItemTest {

    @Test
    void borrow() {
        BorrowableElectricTracableItem vehicle = new BorrowableElectricTracableItem(new Battery(50), new GPS());
        vehicle.charge(50);
        vehicle.borrow();
    }

    @Test
    void returnBorrowable() {
        BorrowableElectricTracableItem vehicle = new BorrowableElectricTracableItem(new Battery(50), new GPS());
        vehicle.charge(50);
        vehicle.borrow();
        vehicle.returnBorrowable();
    }

    @Test
    void borrowNotEnoughCharge() {
        BorrowableElectricTracableItem vehicle = new BorrowableElectricTracableItem(new Battery(10), new GPS());
        assertThrows(IllegalStateException.class, vehicle::borrow);
    }

    @Test
    void borrowAlreadyBorrowed() {
        BorrowableElectricTracableItem vehicle = new BorrowableElectricTracableItem(new Battery(50), new GPS());
        vehicle.charge(50);
        vehicle.borrow();
        assertThrows(IllegalStateException.class, vehicle::borrow);
    }

    @Test
    void returnAlreadyReturned() {
        BorrowableElectricTracableItem vehicle = new BorrowableElectricTracableItem(new Battery(50), new GPS());
        assertThrows(IllegalStateException.class, vehicle::returnBorrowable);
    }

}