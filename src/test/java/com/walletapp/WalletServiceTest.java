package com.walletapp;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class WalletServiceTest {

    WalletService service = new WalletService();

    @Test
    public void testViewBalanceInitiallyZero() {
        assertEquals(0, service.getBalance());
    }

    @Test
    public void testAddMoney() {
        service.addMoney(500);
        assertEquals(500, service.getBalance());
    }

    @Test
    public void testWithdrawMoney() {
        service.addMoney(1000);
        service.withdrawMoney(400);
        assertEquals(600, service.getBalance());
    }

    @Test
    public void testOverdraw() {
        Exception exception = assertThrows(RuntimeException.class, () -> {
            service.withdrawMoney(100);
        });
        assertEquals("Insufficient balance", exception.getMessage());
    }
}
