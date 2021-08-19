package org.prgrms.orderApp.service;

import org.prgrms.orderApp.ProcessingStatus;
import org.prgrms.orderApp.model.voucher.Voucher;
import org.prgrms.orderApp.model.voucher.VoucherType;
import org.prgrms.orderApp.repository.VoucherRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class VoucherService {
    private final VoucherRepository voucherRepository;
    private Map<String,Object> processingResultsMessages = new HashMap<String, Object>();

    private ProcessingStatus status;
    private UUID voucherId ;
    public VoucherService(VoucherRepository voucherRepository) {

        this.voucherRepository = voucherRepository;
    }

    public Voucher getVoucher(UUID voucherId) {
        return voucherRepository
                .findById(voucherId)
                .orElseThrow(() -> new RuntimeException("Can not find a voucher for " + voucherId));
    }

    public Map<String, Object> saveVoucher(Voucher voucher){
        processingResultsMessages.clear();

        if (voucherRepository.save(voucher) >0 ){
            status = ProcessingStatus.SUCCESS;
            voucherId = voucher.getVoucherId();
        }else {
            status = ProcessingStatus.FAIL;
            voucherId = null;
        }
        processingResultsMessages.put("status", status);
        processingResultsMessages.put("voucherId", voucherId);
        return processingResultsMessages;

    }

    public List<Voucher> getAllVouchers(){
        return voucherRepository.findAll();
    }

    public void useVoucher(Voucher voucher) {

    }

}
