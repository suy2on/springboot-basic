package org.prgrms.orderApp.model.voucher;

import java.util.UUID;


public interface Voucher {
    UUID getVoucherId();
    long discount(long beforeDiscount);
}
