package org.prms.configure;

import org.prms.domain.Order;
import org.prms.repository.FileRepository;
import org.prms.repository.MemoryRepository;
import org.prms.repository.OrderRepository;
import org.prms.repository.VoucherRepository;
import org.prms.service.OrderService;
import org.prms.service.VoucherService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

// Bean을 정의할 도면이다라고 스프링에게 알려줘야 함. @Configuration
// 각 메소드에 Bean 어노테이션 사용
@Configuration
@ComponentScan(basePackages = {"org.prms.repository","org.prms.service"})
public class AppConfiguration {


//    @Bean
//    public VoucherRepository voucherRepository() throws IOException {
//
//    //  return new MemoryRepository();
//        return new FileRepository();
//    }
//    @Bean
//    public OrderRepository orderRepository() {
//        return new OrderRepository() {
//            @Override
//            public void insert(Order order) {
//
//            }
//        };
//    }
//    @Bean
//    public VoucherService voucherService(VoucherRepository voucherRepository) {
//        return new VoucherService(voucherRepository);
//    }
//
//    @Bean
//    public OrderService orderService(VoucherService voucherService, OrderRepository orderRepository) {
//        return new OrderService(voucherService,orderRepository);
//    }

}
