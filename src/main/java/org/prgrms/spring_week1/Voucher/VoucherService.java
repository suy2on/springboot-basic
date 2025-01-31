package org.prgrms.spring_week1.Voucher;

import java.util.List;
import java.util.UUID;
import org.prgrms.spring_week1.Voucher.model.FixedAmountVoucher;
import org.prgrms.spring_week1.Voucher.model.PercentDiscountVoucher;
import org.prgrms.spring_week1.Voucher.model.Voucher;
import org.prgrms.spring_week1.Voucher.model.VoucherType;
import org.prgrms.spring_week1.Voucher.repository.VoucherRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

@Service
public class VoucherService {

    private static final Logger logger = LoggerFactory
        .getLogger(VoucherService.class); // 모든 인스턴스가 공유(static) 변경불가(final)

    private VoucherRepository voucherRepository;

    public VoucherService(VoucherRepository voucherRepository) {
        this.voucherRepository = voucherRepository;
    }

    public Voucher createVoucher(long discount, UUID customerId, VoucherType voucherType) throws DataAccessException{
        Voucher voucher;
        if (voucherType == VoucherType.FIXEDAMOUNT){
            voucher = new FixedAmountVoucher(UUID.randomUUID(), discount, customerId);
        } else {
            voucher = new PercentDiscountVoucher(UUID.randomUUID(), discount, customerId);
        }
        voucherRepository.insert(voucher);
        return voucher;
    }

    public List<Voucher> getAllVoucher() {
        return voucherRepository.getAllVoucher();

    }

    public List<Voucher> findByCustomer(UUID customerId) throws DataAccessException {
        return voucherRepository.findByCustomer(customerId);
    }

    public Voucher updateVoucher(Voucher voucher) throws DataAccessException{
        return voucherRepository.update(voucher);
    }


}
