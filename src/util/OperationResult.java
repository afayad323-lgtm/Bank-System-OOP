package util;

public class OperationResult {
    private boolean success;
    private String message;

    public OperationResult(boolean success , String message){
        this.success = success;
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public boolean isSuccess() {
        return success;
    }
}
