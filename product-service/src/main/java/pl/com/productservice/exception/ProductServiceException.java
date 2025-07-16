package pl.com.productservice.exception;

public class ProductServiceException extends RuntimeException {

    public ProductServiceException(String message) {
        super(message);
    }

    public ProductServiceException() {
    }
}
