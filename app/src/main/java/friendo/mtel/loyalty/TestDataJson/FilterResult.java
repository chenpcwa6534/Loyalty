package friendo.mtel.loyalty.TestDataJson;

import friendo.mtel.loyalty.component.ErrorMessageData;
import friendo.mtel.loyalty.component.FilterData;

/**
 * Created by MTel on 2015/8/17.
 */
public class FilterResult {

    private boolean result;
    private int errorCode;
    private FilterData data;

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

    public FilterData getData() {
        return data;
    }

    public void setData(FilterData data) {
        this.data = data;
    }
}
