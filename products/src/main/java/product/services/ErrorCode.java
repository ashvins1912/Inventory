package product.services;

import lombok.AllArgsConstructor;
@AllArgsConstructor
public class ErrorCode {
    final int code;
    final String desc;
    public static final ErrorCode UNKONWN= new ErrorCode(-1,"Unknown Error");
    public static final ErrorCode NOTEMPTY= new ErrorCode(-100,"Field Should Not be Empty");

}
