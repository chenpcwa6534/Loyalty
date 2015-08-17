package friendo.mtel.loyalty.HttpsParams;

/**
 * Created by MTel on 2015/7/27.
 */
public class FrontPageInParams {

    private String latitude;
    private String longitude;
    private String search;
    private UserFilterParams userfilter;

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }

    public UserFilterParams getUserfilter() {
        return userfilter;
    }

    public void setUserfilter(UserFilterParams userfilter) {
        this.userfilter = userfilter;
    }

    public FrontPageInParams getFrontPageResponse(String latitude, String longitude, String search,int catID, int cityID, int orderID, String subareaID, int subcatID){
        setLatitude(latitude);
        setLongitude(longitude);
        setSearch(search);
        UserFilterParams userFilterResponse = new UserFilterParams();
        userFilterResponse.setCat_id(catID);
        userFilterResponse.setCity_id(cityID);
        userFilterResponse.setOrder_id(orderID);
        userFilterResponse.setSubarea_id(subareaID);
        userFilterResponse.setSubcat_id(subcatID);

        return new FrontPageInParams();
    }
}
