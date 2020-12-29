package cn.cdfg.exceptionHandle;

public class PrintCouponNotFoundException extends RuntimeException{
    private static final long serialVersionUID=1L;

    public int getResultCode() {
        return resultCode;
    }

    public void setResultCode(int retCode) {
        this.resultCode = resultCode;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    private int resultCode;
    private String msg;

    public PrintCouponNotFoundException(int resultCode, String msg) {
        this.resultCode = resultCode;
        this.msg = msg;
    }

//    public StudentNotFoundException(String message) {
//        super(message);
//    }
}
