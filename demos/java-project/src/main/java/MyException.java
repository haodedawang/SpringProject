public class MyException extends RuntimeException {
    private ErrorCodeEnum errorCode;


    public MyException(ErrorCodeEnum errorCode) {
        //super(errorCode.getDesc());
        this.errorCode = errorCode;
    }

    public MyException( ErrorCodeEnum errorCode,String message) {
        super(message);
        this.errorCode = errorCode;
    }

    public ErrorCodeEnum getErrorCode() {
        return errorCode;
    }

}
