package friendo.mtel.loyalty.Request;

/**
 * Created by MTel on 2015/8/14.
 */
public class RegRequest {
    
    private String cell_no;
    private String verf_code;
    private String device_token;
    private int device_type;
    private String checkno;

    public void setCell_no(String cell_no) {
        this.cell_no = cell_no;
    }

    public String getCell_no() {
        return cell_no;
    }

    public int getDevice_type() {
        return device_type;
    }

    public void setDevice_type(int device_type) {
        this.device_type = device_type;
    }

    public String getCheckno() {
        return checkno;
    }

    public void setCheckno(String checkno) {
        this.checkno = checkno;
    }

    public String getDevice_token() {
        return device_token;
    }

    public void setDevice_token(String device_token) {
        this.device_token = device_token;
    }

    public String getVerf_code() {
        return verf_code;
    }

    public void setVerf_code(String verf_code) {
        this.verf_code = verf_code;
    }
}
