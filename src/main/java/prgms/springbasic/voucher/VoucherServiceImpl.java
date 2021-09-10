package prgms.springbasic.voucher;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import prgms.springbasic.io.Printer;
import prgms.springbasic.repository.VoucherRepository;

import java.io.IOException;
import java.text.MessageFormat;
import java.util.List;
import java.util.UUID;

@Service
@Qualifier("voucherService")
public class VoucherServiceImpl implements VoucherService {

    private final VoucherRepository voucherRepository;

    public VoucherServiceImpl(@Qualifier("fileVoucherRepository") VoucherRepository voucherRepository) {
        this.voucherRepository = voucherRepository;
    }

    @Override
    public Voucher createVoucher(VoucherType voucherType, UUID voucherId, String value) throws IOException {
        if (voucherType == VoucherType.FIXED_AMOUNT_VOUCHER) {
            return createFixedAmountVoucher(voucherId, Integer.parseInt(value));
        } else if (voucherType == VoucherType.PERCENT_DISCOUNT_VOUCHER) {
            return createPercentDiscountVoucher(voucherId, Long.parseLong(value));
        }
        return null;
    }

    @Override
    public List<Voucher> getVoucherList() throws IOException {
        return voucherRepository.getVoucherList();
    }

    @Override
    public void listIsEmpty() {
        Printer printer = new Printer();
        printer.printVoucherListEmpty();
    }

    public Voucher createFixedAmountVoucher(UUID voucherId, int amount) throws IOException {
        Voucher newVoucher = new FixedAmountVoucher(voucherId, amount);
        return voucherRepository.save(newVoucher);
    }

    public Voucher createPercentDiscountVoucher(UUID voucherId, long percent) throws IOException {
        Voucher newVoucher = new PercentDiscountVoucher(voucherId, percent);
        return voucherRepository.save(newVoucher);
    }

    public Voucher getVoucher(UUID voucherId) throws IOException {
        return voucherRepository.findById(voucherId)
                .orElseThrow(() -> new RuntimeException(MessageFormat.format("해당 바우처를 찾을 수 없습니다. 바우처 ID = {0}", voucherId))
                );
    }
}
