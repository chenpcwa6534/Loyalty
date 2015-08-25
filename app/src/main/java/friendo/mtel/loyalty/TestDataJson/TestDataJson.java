package friendo.mtel.loyalty.TestDataJson;

import android.util.Log;

import com.google.gson.Gson;

import org.json.JSONObject;

import friendo.mtel.loyalty.component.CatsData;
import friendo.mtel.loyalty.component.CitysData;
import friendo.mtel.loyalty.component.ErrorMessageData;
import friendo.mtel.loyalty.component.FilterData;
import friendo.mtel.loyalty.component.OrderData;
import friendo.mtel.loyalty.component.OrdersData;
import friendo.mtel.loyalty.component.SubAreaData;
import friendo.mtel.loyalty.component.SubCatsData;

/**
 * Created by MTel on 2015/8/12.
 */
public class TestDataJson {
    private static String TAG = TestDataJson.class.getSimpleName();
    private static Gson gson = new Gson();

    private static  String ResponseError = "{\"result\":false,\"errorCode':301}";

    private static String VersionControl = "{\"result\":true,\"errorCode\":200,\"data\":{\"verUpdateTime\":\"2015/08/01 12:00:00\",\"updateStatus\":true,\"serviceupdate\":true,\"protitle\":{\"name\":\"王大明\",\"birthday\":\"03/05\",\"gender\":\"M\",\"number\":\"0912345678\",\"picture\":\"http\",\"isModify\":true,\"pushService\":true}}}";
    private static String AskOTPData = "{\"result\":true,\"errorCode\":200}";
    private static String VerificationData = "{\"result\":true,\"errorCode\":200,\"data\":{\"memberID\":\"1\"}}";
    private static String ads = "{\"result\":true,\"errorCode\":200,\"data\":{\"updateTime\":\"2015/08/08 19:52:11\",\"adsInfo\":[{\"title\":\"banner one\",\"adType\":1,\"picture\":\"https://showcard.s3-ap-northeast-1.amazonaws.com/ad/0fbfb6fd-9d1e-4926-a30b-954c22658b41.jpg\",\"picturePath\":\"\",\"intentInfo\":{\"link\":\"http://www.google.com\"}},{\"title\":\"banner two\",\"adType\":2,\"picture\":\"https://showcard.s3-ap-northeast-1.amazonaws.com/ad/e0e8a9b8-0e8f-47aa-8fc6-b1008e672c0c.jpg\",\"picturePath\":\"\",\"intentInfo\":{\"videoURL\":\"https://youtu.be/4BWPTXHDiSU\"}},{\"title\":\"banner there\",\"adType\":3,\"picture\":\"https://showcard.s3-ap-northeast-1.amazonaws.com/ad/e0e8a9b8-0e8f-47aa-8fc6-b1008e672c0c.jpg\",\"picturePath\":\"\",\"intentInfo\":{\"link\":\"https://showcard.s3-ap-northeast-1.amazonaws.com/ad/0fbfb6fd-9d1e-4926-a30b-954c22658b41.jpg\"}},{\"title\":\"banner four  intent coupon\",\"adType\":4,\"picture\":\"https://showcard.s3-ap-northeast-1.amazonaws.com/ad/d28beda8-452a-495d-9ff4-0a39283487ae.jpg\",\"picturePath\":\"\",\"intentInfo\":{\"intentType\":1,\"couponID\":1}},{\"title\":\"banner four  intent pocket\",\"adType\":4,\"picture\":\"https://showcard.s3-ap-northeast-1.amazonaws.com/ad/e0e8a9b8-0e8f-47aa-8fc6-b1008e672c0c.jpg\",\"picturePath\":\"\",\"intentInfo\":{\"intentType\":2}},{\"title\":\"banner four  intent search\",\"adType\":4,\"picture\":\"https://showcard.s3-ap-northeast-1.amazonaws.com/ad/0fbfb6fd-9d1e-4926-a30b-954c22658b41.jpg\",\"picturePath\":\"\",\"intentInfo\":{\"intentType\":3,\"catID\":1,\"cityID\":1,\"subcatID\":1,\"subareaID\":\"1\",\"orderID\":2}}]}}";

    private static String firmList = "{\"result\":true,\"errorCode\":200,\"data\":[{\"firmID\":1,\"firmName\":\"60嵐\",\"picture\":\"https://showcard.s3-ap-northeast-1.amazonaws.com/firm/e5343e13-b412-4ff0-8d74-5c291151744e.jpg\",\"picturePath\":\"\",\"pointDesc\":\"憑卷兌換甘蔗一支\",\"firstDesc\":\"\",\"distance\":100,\"latitude\":\"25.065652\",\"longitude\":\"121.53951400000005\",\"catID\":1,\"thumbnail\":\"\",\"thumbnailPath\":\"\",\"partner\":true,\"partnerMessage\":\"message\"},{\"firmID\":2,\"firmName\":\"ICE MONSTER-忠孝旗艦店\",\"picture\":\"https://showcard.s3-ap-northeast-1.amazonaws.com/firm/7f4279eb-9aad-4bca-96fa-a3df43ac2dc9.jpg\",\"picturePath\":\"\",\"pointDesc\":\"憑 首次體驗劵免費嘗點心\",\"firstDesc\":\"\",\"distance\":100,\"latitude\":\"25.0792018\",\"longitude\":\"121.54270930000007\",\"catID\":2,\"thumbnail\":\"\",\"thumbnailPath\":\"\",\"partner\":true,\"partnerMessage\":\"message\"},{\"firmID\":3,\"firmName\":\"北投漾館\",\"picture\":\"https://showcard.s3-ap-northeast-1.amazonaws.com/firm/6abe7f2f-48a6-413d-a95b-a9c7df28a52b.jpg\",\"picturePath\":\"\",\"pointDesc\":\"持 會員卡 至 漾 北投溫泉泡湯，即有機會抽中日本泡湯旅遊機票。\",\"firstDesc\":\"\",\"distance\":100,\"latitude\":\"25.1352235\",\"longitude\":\"121.50466719999997\",\"catID\":3,\"thumbnail\":\"https://showcard.s3-ap-northeast-1.amazonaws.com/firm/9bda1928-f5c7-4360-a49c-76ce664132ff.jpg\",\"thumbnailPath\":\"\",\"partner\":true,\"partnerMessage\":\"message\"},{\"firmID\":4,\"firmName\":\"壽賀喜屋-比漾百貨\",\"picture\":\"http://friendoprod.blob.core.windows.net/o2o/firm/8c3a2816-a613-401d-a978-abd264ecffab.jpg\",\"picturePath\":\"\",\"pointDesc\":\"壽賀喜屋八週年慶 Double A級下午茶組合，憑劵兌換蜂蜜煉乳冰\",\"firstDesc\":\"\",\"distance\":100,\"latitude\":\"25.1352235\",\"longitude\":\"121.50466719999997\",\"catID\":4,\"thumbnail\":\"http://friendoprod.blob.core.windows.net/o2o/firm/ab24a922-e412-4288-b352-76f4ddc0d220.PNG\",\"thumbnailPath\":\"\",\"partner\":true,\"partnerMessage\":\"message\"},{\"firmID\":5,\"firmName\":\"壽賀喜屋-科教館店\",\"picture\":\"https://showcard.s3-ap-northeast-1.amazonaws.com/firm/070e00c4-1615-4048-bf71-c772b3218562.jpg\",\"picturePath\":\"\",\"pointDesc\":\"來店就送日式甜點一份\",\"firstDesc\":\"\",\"distance\":100,\"latitude\":\"25.0957569\",\"longitude\":\"121.51660179999999\",\"catID\":4,\"thumbnail\":\"https://showcard.s3-ap-northeast-1.amazonaws.com/firm/58f645d3-57ac-4dc2-ae5a-9b8c036da6dc.jpg\",\"thumbnailPath\":\"\",\"partner\":true,\"partnerMessage\":\"message\"},{\"firmID\":6,\"firmName\":\"春樹科技\",\"picture\":\"https://showcard.s3-ap-northeast-1.amazonaws.com/firm/2b91be4b-d9f7-4048-b61d-71749cddd740.jpg\",\"picturePath\":\"\",\"pointDesc\":\"來店就送中式甜點1一份\",\"firstDesc\":\"歡樂週年慶，現在集滿10點就有精美套餐送給您, 首次來店還送日式小菜！\",\"distance\":100,\"latitude\":\"25.0511507\",\"longitude\":\"121.53326070000003\",\"catID\":6,\"thumbnail\":\"https://showcard.s3-ap-northeast-1.amazonaws.com/firm/58f645d3-57ac-4dc2-ae5a-9b8c036da6dc.jpg\",\"thumbnailPath\":\"\",\"partner\":true,\"partnerMessage\":\"message\"},{\"firmID\":7,\"firmName\":\"哈瓦那咖啡館\",\"picture\":\"https://showcard.s3-ap-northeast-1.amazonaws.com/firm/d106bd3d-0a37-436e-86eb-c0ae2f3d686d.PNG\",\"picturePath\":\"\",\"pointDesc\":\"來店就送中式甜點1一份\",\"firstDesc\":\"歡樂週年慶，現在集滿10點就有精美套餐送給您, 首次來店還送日式小菜！\",\"distance\":100,\"latitude\":\"25.083576\",\"longitude\":\"121.55709849999994\",\"catID\":7,\"thumbnail\":\"https://showcard.s3-ap-northeast-1.amazonaws.com/firm/bae97923-a151-4bf5-a2fb-15119dadac8e.PNG\",\"thumbnailPath\":\"\",\"partner\":true,\"partnerMessage\":\"message\"},{\"firmID\":8,\"firmName\":\"路易‧莎咖啡\",\"picture\":\"https://showcard.s3-ap-northeast-1.amazonaws.com/firm/6e0dab47-39a5-492e-a405-d0c16f3f53c7.jpg\",\"picturePath\":\"\",\"pointDesc\":\"\",\"firstDesc\":\"90+ 真心話 Nekisse N2\",\"distance\":100,\"latitude\":\"25.056694\",\"longitude\":\"121.546333\",\"catID\":8,\"thumbnail\":\"https://showcard.s3-ap-northeast-1.amazonaws.com/firm/51ce21c5-2914-40a4-a103-0db75f48433e.PNG\",\"thumbnailPath\":\"\",\"partner\":true,\"partnerMessage\":\"message\"}]}";

    private static String firmCoupons = "{\"result\":true,\"errorCode\":200,\"data\":[{\"couponID\":1,\"title\":\"優惠卷\",\"description\":\"測試用優惠卷\",\"pciture\":\"https://showcard.s3-ap-northeast-1.amazonaws.com/ad/88af0435-01f0-43a0-9281-1ca41b83c3ea.jpeg\",\"picture\":\"\",\"expireDay\":10},{\"couponID\":2,\"title\":\"優惠卷\",\"description\":\"滷肉飯一碗\",\"pciture\":\"http://friendoprod.blob.core.windows.net/o2o/prod/7b61d443-b2e3-4606-b157-e8c9cd51325d.jpg\",\"picture\":\"\",\"expireDay\":5}]}";

    private static String firmPoint = "{\"result\":true,\"errorCode\":200,\"data\":{\"description\":\"多多努力集點吧\",\"notics\":\"兌點規則明細： 沒有規則\",\"currentPoint\":5,\"maxPoint\":33,\"maturityDay\":\"2015/09/11\",\"redeem\":[{\"point\":5,\"Adpicture\":\"http://friendoprod.blob.core.windows.net/o2o/prod/7b61d443-b2e3-4606-b157-e8c9cd51325d.jpg\",\"AdpicturePath\":\"\",\"convertlist\":[{\"couponID\":1,\"couponPicture\":\"http://friendoprod.blob.core.windows.net/o2o/prod/7b61d443-b2e3-4606-b157-e8c9cd51325d.jpg\",\"couponPicturePath\":\"\"},{\"couponID\":2,\"couponPicture\":\"https://showcard.s3-ap-northeast-1.amazonaws.com/ad/88af0435-01f0-43a0-9281-1ca41b83c3ea.jpeg\",\"couponPicturePath\":\"\"}]},{\"point\":10,\"Adpicture\":\"https://showcard.s3-ap-northeast-1.amazonaws.com/ad/d28beda8-452a-495d-9ff4-0a39283487ae.jpg\",\"AdpicturePath\":\"\",\"convertlist\":[{\"couponID\":1,\"couponPicture\":\"https://showcard.s3-ap-northeast-1.amazonaws.com/ad/d28beda8-452a-495d-9ff4-0a39283487ae.jpg\",\"couponPicturePath\":\"\"}]}]}}";
    private static String firmInfo = "{\"result\":true,\"errorCode\":200,\"data\":{\"beaconID\":1111,\"description\":\"\",\"address\":\"台北市大安區忠孝東路四段270號\",\"number\":\"0221232222\",\"businessWeek\":[\"monday 08:00 ~ 18:00\",\"tuesday 08:00 ~ 18:00\",\"wednesday 08:00 ~ 18:00\",\"thursday 08:00 ~ 18:00\",\"friday 08:00 ~ 18:00\",\"saturday 08:00 ~ 18:00\",\"sunday 10:00 ~ 20:00\"\n" + "],\"traffic\":\"\",\"carpark\":\"\",\"webUrl\":[\"http://www.google.com\",\"http://www.yahoo.com\"],\"fbUrl\":\"http://facebook.com\",\"blogConnent\":\"王品\"}}";

    private static String couponDetail = "{\"result\":true,\"errorCode\":200,\"data\":{\"title\":\"太平洋游泳池優惠卷\",\"description\":\"佔地5000000平超大游泳池\",\"available\":\"201509/10~2015/09/30\",\"picture\":\"https://www.dropbox.com/s/ukwvzzncjgdytmf/13473446023828_500.jpg?dl=0\",\"picturePath\":\"\",\"cancellationType\":1,\"showType\":1,\"cancellationStatus\":0,\"isConvert\":true,\"isCollect\":true,\"notic\":\"android notic\",\"storeInfo\":{\"picture\":\"\",\"picturePath\":\"\",\"address\":\"大安區忠孝東路四段270號\",\"numer\":\"0227000000\"}}}";

    private static String limitCoupon = "{\"result\":true,\"errorCode\":200,\"data\":[{\"name\":\"首次優惠卷\",\"title\":\"限量優惠卷測試資料一\",\"catID\":1,\"desc\":\"this is text limit data\",\"expireday\":3,\"count\":100,\"picture\":\"https://showcard.s3-ap-northeast-1.amazonaws.com/ad/bd855ccd-140e-4437-808b-c18d38c704ae.jpg\",\"picturePath\":\"\",\"couponID\":300},{\"name\":\"限量優惠卷\",\"title\":\"限量優惠卷測試資料二\",\"catID\":2,\"desc\":\"限 專家使用\",\"expireday\":13,\"count\":900,\"picture\":\"http://friendoprod.blob.core.windows.net/o2o/prod/afc4468b-9456-4037-b17c-540b173049e1.jpg\",\"picturePath\":\"\",\"couponID\":300}]}";

    private static String memberInfo = "{\"result\":true,\"errorCode\":200,\"data\":{\"LV\":3,\"progress\":40,\"benefitstatus\":true,\"benefitnotic\":\"you have new notic\",\"store\":30,\"point\":1533,\"count\":12,\"money\":2141}}";

    private static String memberPoint = "{\"result\":true,\"errorCode\":200,\"data\":[{\"storeID\":11,\"name\":\"XSSS 店家\",\"picture\":\"http://friendoprod.blob.core.windows.net/o2o/prod/7b61d443-b2e3-4606-b157-e8c9cd51325d.jpg\",\"picturePath\":\"\",\"day\":\"2015/08/25\",\"description\":\"you have 5 point\"},{\"storeID\":12,\"name\":\"TTTT 店家\",\"picture\":\"http://friendoprod.blob.core.windows.net/o2o/prod/7b61d443-b2e3-4606-b157-e8c9cd51325d.jpg\",\"picturePath\":\"\",\"day\":\"2015/09/28\",\"description\":\"you have 15 point\"}]}";

    private static String memberCoupons = "{\"result\":true,\"errorCode\":200,\"data\":[{\"couponID\":1,\"name\":\"WQRR\",\"picture\":\"http://friendoprod.blob.core.windows.net/o2o/prod/7b61d443-b2e3-4606-b157-e8c9cd51325d.jpg\",\"picturePath\":\"\",\"expireDay\":4,\"description\":\"\"},{\"couponID\":2,\"name\":\"sebsb\",\"picture\":\"http://friendoprod.blob.core.windows.net/o2o/prod/7b61d443-b2e3-4606-b157-e8c9cd51325d.jpg\",\"picturePath\":\"\",\"expireDay\":8,\"description\":\"\"}]}";

    private static String memberExChange = "{\"result\":true,\"errorCode\":200,\"data\":[{\"storeID\":13,\"name\":\"\",\"picture\":\"http://friendoprod.blob.core.windows.net/o2o/prod/7b61d443-b2e3-4606-b157-e8c9cd51325d.jpg\",\"picturePath\":\"\",\"convertdate\":4,\"description\":\"use 3 point change coupon\"},{\"storeID\":23,\"name\":\"\",\"picture\":\"http://friendoprod.blob.core.windows.net/o2o/prod/7b61d443-b2e3-4606-b157-e8c9cd51325d.jpg\",\"picturePath\":\"\",\"convertdate\":14,\"description\":\"use 14 point change coupon\"}]}";


    public static JSONObject getAskOTPResponseData(){
        return getJsonObject(AskOTPData);
    }

    public static JSONObject getVerificationCodeResponseData(){
        return getJsonObject(VerificationData);
    }

    public static JSONObject getVersionControlResponseData(){
        return getJsonObject(VersionControl);
    }

    public static JSONObject getAds(){
        return getJsonObject(ads);
    }

    public static JSONObject getFirmList(){
        return getJsonObject(firmList);
    }

    public static JSONObject getFirmCoupons(){
        return getJsonObject(firmCoupons);
    }

    public static JSONObject getCouponDetail(){
        return getJsonObject(couponDetail);
    }

    public static JSONObject getFirmPoint(){
        return getJsonObject(firmPoint);
    }

    public static JSONObject getFirmInfo(){
        return getJsonObject(firmInfo);
    }

    public static JSONObject getLimitCoupon(){
        return getJsonObject(limitCoupon);
    }

    public static JSONObject getMemberInfo(){return getJsonObject(memberInfo);}

    public static JSONObject getMemberPoint(){return getJsonObject(memberPoint);}

    public static JSONObject getMemberCoupons(){return getJsonObject(memberCoupons);}

    public static JSONObject getMemberExChange(){return getJsonObject(memberExChange);}

    public static JSONObject getErrorMessage(){
        ErrorMessageResult errorMessageResult = new ErrorMessageResult();
        errorMessageResult.setResult(true);
        errorMessageResult.setErrorCode(200);

        ErrorMessageData[] errorMessageData = new ErrorMessageData[2];
        ErrorMessageData errorMessageData1 = new ErrorMessageData();
        errorMessageData1.setCode(200);
        errorMessageData1.setMessage("sucess");
        ErrorMessageData errorMessageData2 = new ErrorMessageData();
        errorMessageData2.setCode(303);
        errorMessageData2.setMessage("fail");
        errorMessageData[0] = errorMessageData1;
        errorMessageData[1] = errorMessageData2;
        errorMessageResult.setData(errorMessageData);

        return getJsonObject(gson.toJson(errorMessageResult));
    }

    public static JSONObject getFilter(){
        SubAreaData[] subAreaDataTaipai = new SubAreaData[3];
        subAreaDataTaipai[0]  = new SubAreaData();
        subAreaDataTaipai[0].setSubareaID("1");
        subAreaDataTaipai[0].setSubareaName("大安區");
        subAreaDataTaipai[1]  = new SubAreaData();
        subAreaDataTaipai[1].setSubareaID("2");
        subAreaDataTaipai[1].setSubareaName("士林區");
        subAreaDataTaipai[2]  = new SubAreaData();
        subAreaDataTaipai[2].setSubareaID("3");
        subAreaDataTaipai[2].setSubareaName("大同區");

        SubAreaData[] subAreaDataNewTaipai = new SubAreaData[2];
        subAreaDataNewTaipai[0] = new SubAreaData();
        subAreaDataNewTaipai[0].setSubareaID("1");
        subAreaDataNewTaipai[0].setSubareaName("三峽區");
        subAreaDataNewTaipai[1] = new SubAreaData();
        subAreaDataNewTaipai[1].setSubareaID("2");
        subAreaDataNewTaipai[1].setSubareaName("三重區");

        CitysData[] citysDatas = new CitysData[3];
        citysDatas[0] = new CitysData();
        citysDatas[0].setCityID(0);
        citysDatas[0].setCityName("附近店家");
        citysDatas[1] = new CitysData();
        citysDatas[1].setCityID(1);
        citysDatas[1].setCityName("台北市");
        citysDatas[1].setSubareas(subAreaDataTaipai);
        citysDatas[2] = new CitysData();
        citysDatas[2].setCityID(2);
        citysDatas[2].setCityName("新北市");
        citysDatas[2].setSubareas(subAreaDataNewTaipai);


        SubCatsData[] subCatsDatas_re = new SubCatsData[3];
        subCatsDatas_re[0] = new SubCatsData();
        subCatsDatas_re[0].setSubcatID(0);
        subCatsDatas_re[0].setSubcatName("全部");
        subCatsDatas_re[1] = new SubCatsData();
        subCatsDatas_re[1].setSubcatID(1);
        subCatsDatas_re[1].setSubcatName("西式");
        subCatsDatas_re[2] = new SubCatsData();
        subCatsDatas_re[2].setSubcatID(2);
        subCatsDatas_re[2].setSubcatName("中式");

        SubCatsData[] subCatsDatas_Lo = new SubCatsData[2];
        subCatsDatas_Lo[0] = new SubCatsData();
        subCatsDatas_Lo[0].setSubcatID(0);
        subCatsDatas_Lo[0].setSubcatName("全部");
        subCatsDatas_Lo[1] = new SubCatsData();
        subCatsDatas_Lo[1].setSubcatID(1);
        subCatsDatas_Lo[1].setSubcatName("王品");

        CatsData[] catsDatas = new CatsData[3];
        catsDatas[0] = new CatsData();
        catsDatas[0].setCatID(0);
        catsDatas[0].setCatName("全部");
        catsDatas[1] = new CatsData();
        catsDatas[1].setCatID(1);
        catsDatas[1].setCatName("餐飲");
        catsDatas[1].setSubcats(subCatsDatas_re);
        catsDatas[2] = new CatsData();
        catsDatas[2].setCatID(2);
        catsDatas[2].setCatName("品牌");
        catsDatas[2].setSubcats(subCatsDatas_Lo);

        OrderData[] orderDatasPoint = new OrderData[3];
        orderDatasPoint[0] = new OrderData();
        orderDatasPoint[0].setOrderID(1);
        orderDatasPoint[0].setOrderName("依距離");
        orderDatasPoint[1] = new OrderData();
        orderDatasPoint[1].setOrderID(2);
        orderDatasPoint[1].setOrderName("依優惠");
        orderDatasPoint[2] = new OrderData();
        orderDatasPoint[2].setOrderID(3);
        orderDatasPoint[2].setOrderName("依更新");

        OrderData[] orderDataLimit = new OrderData[2];
        orderDataLimit[0] = new OrderData();
        orderDataLimit[0].setOrderID(1);
        orderDataLimit[0].setOrderName("依距離");
        orderDataLimit[1] = new OrderData();
        orderDataLimit[1].setOrderID(2);
        orderDataLimit[1].setOrderName("依優惠");

        OrdersData ordersDatas = new OrdersData();
        ordersDatas.setPoint(orderDatasPoint);
        ordersDatas.setLimit(orderDataLimit);

        FilterData filterData = new FilterData();
        filterData.setUpdateTime("2015/08/08 15:32:25");
        filterData.setCitys(citysDatas);
        filterData.setCats(catsDatas);
        filterData.setOrder(ordersDatas);

        FilterResult filterResult = new FilterResult();
        filterResult.setErrorCode(200);
        filterResult.setResult(true);
        filterResult.setData(filterData);

        return getJsonObject(gson.toJson(filterResult));
    }

    public static JSONObject getResponseError(){
        return getJsonObject(ResponseError);
    }

    private static JSONObject getJsonObject(String data){
        JSONObject jsonObject = null;
        try{
            jsonObject = new JSONObject(data);
        }catch (Exception e) {
            Log.e(TAG,"Exception:"+e);
        }
        return jsonObject;
    }
}
