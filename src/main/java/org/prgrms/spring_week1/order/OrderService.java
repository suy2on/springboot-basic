package org.prgrms.spring_week1.order;

import org.prgrms.spring_week1.Voucher.VoucherService;
import org.prgrms.spring_week1.order.model.Order;
import org.prgrms.spring_week1.order.model.OrderItem;
import org.prgrms.spring_week1.Voucher.model.Voucher;
import org.prgrms.spring_week1.order.repository.OrderRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class OrderService {

    private static final Logger logger = LoggerFactory
        .getLogger(OrderService.class); // 모든 인스턴스가 공유(static) 변경불가(final)

    OrderRepository orderRepository;
    VoucherService voucherService;

    public OrderService(OrderRepository orderRepository, VoucherService voucherService) {
        this.orderRepository = orderRepository;
        this.voucherService = voucherService;
    }

    // voucher 없는 경우
    public Order createOrder(UUID customerId, List<OrderItem> orderItems) {
        Order order = new Order(UUID.randomUUID(), customerId, orderItems);
        orderRepository.insert(order);
        return order;
    }

    // voucher 있는 경우
    public Order createOrder(UUID customerId, List<OrderItem> orderItems, Voucher voucher) {
        Order order = new Order(UUID.randomUUID(), customerId, orderItems, voucher);
        orderRepository.insert(order);
        return order;
    }
}
