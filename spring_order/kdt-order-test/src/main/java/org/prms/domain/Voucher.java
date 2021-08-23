package org.prms.domain;

import java.util.UUID;

public interface Voucher {

    UUID getVoucherId();
    long discount(long beforeDiscount);
    long getAmount();
    String getType();

}
