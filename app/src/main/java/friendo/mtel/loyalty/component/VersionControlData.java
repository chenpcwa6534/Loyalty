package friendo.mtel.loyalty.component;

/**
 * Created by MTel on 2015/8/14.
 */
public class VersionControlData {
    private String ver_updatetime;
    private boolean update_status;
    private boolean service_update;
    private String servicerule_url;
    private ProtitleData protitle;

    public String getVer_updatetime() {
        return ver_updatetime;
    }

    public void setVer_updatetime(String ver_updatetime) {
        this.ver_updatetime = ver_updatetime;
    }

    public boolean isUpdate_status() {
        return update_status;
    }

    public void setUpdate_status(boolean update_status) {
        this.update_status = update_status;
    }

    public boolean isService_update() {
        return service_update;
    }

    public void setService_update(boolean service_update) {
        this.service_update = service_update;
    }

    public String getServicerule_url() {
        return servicerule_url;
    }

    public void setServicerule_url(String servicerule_url) {
        this.servicerule_url = servicerule_url;
    }

    public ProtitleData getProtitle() {
        return protitle;
    }

    public void setProtitle(ProtitleData protitle) {
        this.protitle = protitle;
    }
}
