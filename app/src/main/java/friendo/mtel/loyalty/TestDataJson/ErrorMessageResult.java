package friendo.mtel.loyalty.TestDataJson;

import friendo.mtel.loyalty.component.ErrorMessageData;

/**
 * Created by MTel on 2015/8/17.
 */
public class ErrorMessageResult {

    private boolean result;
    private int errorCode;
    private ErrorMessageData[] data;

    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public ErrorMessageData[] getData() {
        return data;
    }

    public void setData(ErrorMessageData[] data) {
        this.data = data;
    }
}
