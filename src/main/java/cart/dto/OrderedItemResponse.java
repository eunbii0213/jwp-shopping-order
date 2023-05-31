package cart.dto;

public class OrderedItemResponse {

    private int quantity;
    private ProductResponse productResponse;

    public ProductResponse getProductResponse() {
        return productResponse;
    }

    public OrderedItemResponse(int quantity, ProductResponse productResponse) {
        this.quantity = quantity;
        this.productResponse = productResponse;
    }

    public int getQuantity() {
        return quantity;
    }
}
