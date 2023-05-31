package cart.ui;

import cart.application.OrderService;
import cart.dao.CartItemDao;
import cart.domain.Member;
import cart.dto.OrderCreateRequest;
import cart.dto.OrderResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;
    @Autowired
    private CartItemDao cartItemDao;

    @PostMapping
    public ResponseEntity<Void> createOrder(Member member, @RequestBody OrderCreateRequest orderCreateRequest){
        Long id = orderService.createOrder(member, orderCreateRequest);
        return ResponseEntity.created(URI.create("/orders/" + id)).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderResponse> getOrderById(@PathVariable Long id) {
        return ResponseEntity.ok(orderService.getProductById(id));
    }
}
