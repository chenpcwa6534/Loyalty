package friendo.mtel.loyalty.component;

/**
 * Created by MTel on 2015/8/14.
 */
public class VersionControlData {
    private String verUpdateTime;
    private boolean updateStatus;
    private boolean serviceupdate;
    private ProtitleData protitle;

    public String getVerUpdateTime() {
        return verUpdateTime;
    }

    public void setVerUpdateTime(String verUpdateTime) {
        this.verUpdateTime = verUpdateTime;
    }

    public boolean isUpdateStatus() {
        return updateStatus;
    }

    public void setUpdateStatus(boolean updateStatus) {
        this.updateStatus = updateStatus;
    }

    public boolean isServiceupdate() {
        return serviceupdate;
    }

    public void setServiceupdate(boolean serviceupdate) {
        this.serviceupdate = serviceupdate;
    }

    public ProtitleData getProtitleData() {
        return protitle;
    }

    public void setProtitleData(ProtitleData protitleData) {
        this.protitle = protitleData;
    }
}
