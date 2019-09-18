package product.services;

import org.springframework.beans.factory.annotation.Autowired;

public class ValidationException extends RuntimeException {
    final ValidationResult result;

    @Autowired
    public ValidationException (ValidationResult result){
        super("Caused by Validation");
        this.result=result;
    }

}

