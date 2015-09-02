package friendo.mtel.loyalty.component;

/**
 * Created by MTel on 2015/9/2.
 */
public class VerificationData {
    private String member_id;
    private String[] message;

    public String getMember_id() {
        return member_id;
    }

    public void setMember_id(String member_id) {
        this.member_id = member_id;
    }

    public void setMessage(String[] message) {
        this.message = message;
    }

    public String[] getMessage() {
        return message;
    }
}
