package product.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public abstract class ServiceHandler<T, R> {


    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    public R handleRequest(final T request) {
        R respone;
        try {
            respone = handle(request);

        } catch (Exception ex) {
            logger.error("caught error on processing ");
            respone = handleException(ex);
        }
        return respone;
    }

    protected abstract R handleException(Exception ex);

    protected abstract R handle(T request) throws Exception;

    protected void validate(final T request) throws Exception {
        this.validate(request);
    }
}
