package product.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ValidationResult {
    private Map<String, List<ErrorCode>> errors = new HashMap<>();

    public boolean ok() {
        return errors.size() == 0;
    }

    public boolean failure() {
        return !ok();
    }

    public Map<String, List<ErrorCode>> getErrors() {
        return errors;
    }

    public void addError(String key, ErrorCode errorCode) {
        if (errors.containsKey(key)) errors.get(key).add(errorCode);
        else {
            List<ErrorCode> errorCodeList = new ArrayList<>();
            errorCodeList.add(errorCode);
            errors.put(key, errorCodeList);
        }
    }

}
