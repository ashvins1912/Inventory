package product.services;

public abstract  class RootValidator<T> {

    protected final ValidationResult result = new ValidationResult();

    public void validateRequest(T request) throws ValidationException{
        if (this.result.failure()) throw  new ValidationException(result);

    }

    protected abstract <T> void validate(T request)throws ValidationException;
    protected <T> void notNull(final String key,final T value){
        if(value == null) this.result.addError(key,ErrorCode.NOTEMPTY);
    }
    protected <T> void notEmpty(final String key,final String value){
        if(value == null) this.result.addError(key,ErrorCode.NOTEMPTY);
    }

}

