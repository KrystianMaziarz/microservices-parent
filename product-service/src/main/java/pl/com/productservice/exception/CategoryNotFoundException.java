package pl.com.productservice.exception;

public class CategoryNotFoundException extends ProductServiceException {

    public CategoryNotFoundException(Long id) {

        super(buildErrorMessage(id));
    }

    private static String buildErrorMessage(Long id) {
        return String.format("Category with id %d not found", id);
    }
}
