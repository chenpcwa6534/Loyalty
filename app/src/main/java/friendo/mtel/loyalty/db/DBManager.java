package friendo.mtel.loyalty.db;


import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import friendo.mtel.loyalty.R;
import friendo.mtel.loyalty.component.AreaData;
import friendo.mtel.loyalty.component.CatsData;
import friendo.mtel.loyalty.component.FilterData;
import friendo.mtel.loyalty.component.OrderData;
import friendo.mtel.loyalty.component.SubAreaData;
import friendo.mtel.loyalty.component.SubCatsData;
import friendo.mtel.loyalty.preferences.LoyaltyPreference;

/**
 * Created by MTel on 2015/9/16.
 */
public class DBManager {

    public static final String KEY_ID = "_id";

    public static final String COMMA = ",";
    public static final String CREATETABLE = " create table if not exists ";
    public static final String PRIMARKEY = " PRIMARY KEY AUTOINCREMENT, ";
    public static final String TEXT = " TEXT ";
    public static final String INTEGER = " INTEGER ";
    public static final String REAL = " REAL ";

    public static final String SELECT = "SELECT ";
    public static final String DELETE = "DELETE ";
    public static final String UPDATE = "UPDATE";
    public static final String FROM = " FROM ";
    public static final String WHERE = " WHERE ";
    public static final String ORDERBY = " ORDER BY ";

    public static final String AND = " and ";

    public static final String NOTNULL = " NOT NULL ";

    public static SQLiteDatabase database;

    private static Context mContext;

    public static SQLiteDatabase getDatabase(Context context){
        mContext = context;
        if(database == null){
            database = SQLite.getDatabase(context);
        }
        return database;
    }

    /** set database data*/
    public static void setFilterData(FilterData filterData){
        setCatsData(filterData.getCats());
        setAreaData(filterData.getArea());
        setOrderData();
    }

    private static void setCatsData(CatsData[] catsDatas){
        for(int i=0; i<catsDatas.length; i++){
            if(Table_Cat.get(catsDatas[i].getCat_id())){
                if(catsDatas[i].isCatVaild()){
                    Table_Cat.update(catsDatas[i]);
                }else{
                    Table_Cat.delete(catsDatas[i].getCat_id());
                }
            }else{
                if(catsDatas[i].isCatVaild()) Table_Cat.insert(catsDatas[i]);
            }
           setSubCatsData(catsDatas[i].getSubcat(), catsDatas[i].getCat_id());
        }
    }

    private static void setSubCatsData(SubCatsData[] subCatsDatas, int CatId){
        for(int i=0; i<subCatsDatas.length; i++){
            if(Table_SubCat.get(subCatsDatas[i].getSubcat_id(), CatId)){
                if(subCatsDatas[i].isSubcatVaild()){
                    Table_SubCat.update(subCatsDatas[i],CatId);
                }else{
                    Table_SubCat.delete(subCatsDatas[i].getSubcat_id(),CatId);
                }
            }else{
                if(subCatsDatas[i].isSubcatVaild()) Table_SubCat.insert(subCatsDatas[i], CatId);
            }
        }
    }

    private static void setAreaData(AreaData[] areaData){
        for(int i=0; i<areaData.length; i++){
            if(Table_City.get(areaData[i].getCity_id())){
                if(areaData[i].isCityVaild()){
                    Table_City.update(areaData[i]);
                }else{
                    Table_City.delete(areaData[i].getCity_id());
                }
            }else {
                if(areaData[i].isCityVaild()) Table_City.insert(areaData[i]);
            }
            setSubAreaData(areaData[i].getSubarea(), areaData[i].getCity_id());
        }
    }

    private static void setSubAreaData(SubAreaData[] subAreaDatas, int CityID){
        for(int i=0; i<subAreaDatas.length; i++){
            if(Table_SubCity.get(subAreaDatas[i].getSubarea_id(),CityID)){
                if(subAreaDatas[i].isSubcityVaild()){
                    Table_SubCity.update(subAreaDatas[i],CityID);
                }else{
                    Table_SubCity.delete(subAreaDatas[i].getSubarea_id(),CityID);
                }
            }else {
                if(subAreaDatas[i].isSubcityVaild()) Table_SubCity.insert(subAreaDatas[i],CityID);
            }
        }
    }

    private static void setOrderData(){
        String[] OrderData = mContext.getResources().getStringArray(R.array.filter_order);
        String oldVersion = LoyaltyPreference.getAPIRequestTime(mContext, LoyaltyPreference.API.Filter_Order);
        String nowVersion = OrderData[0];
        if(!oldVersion.equals(nowVersion)){
            for(int i=1; i<OrderData.length; i++){
                if(Table_Order.get(i)){
                    Table_Order.update(i,OrderData[i]);
                }else{
                    Table_Order.insert(i,OrderData[i]);
                }
            }
        }
    }

    /** get database data */
    public static FilterData getFilterData(){
        FilterData filterData = new FilterData();
        filterData.setCats(getCatsData());
        filterData.setArea(getAreaData());
        filterData.setOrder(getOrderData());
        return filterData;
    }

    private static CatsData[] getCatsData(){
        int index_cat = 0;

        /** Cats */
        Cursor result_Cat = database.query(Table_Cat.TABLE_NAME,null,null,null,null,null,null);
        CatsData[] catsDatas = new CatsData[result_Cat.getCount()];
        while (result_Cat.moveToNext()){
            CatsData catsData = new CatsData();
            catsData.setCat_id(result_Cat.getInt(1));
            catsData.setCat_name(result_Cat.getString(2));

            /** SubCats */
            int index_subcat = 0;
            String where = Table_Cat.COLUMN_ID + " = " + result_Cat.getInt(1);
            Cursor result_SubCat = database.query(Table_SubCat.TABLE_NAME,null,where,null,null,null,null);
            SubCatsData[] subCatsDatas = new SubCatsData[result_SubCat.getCount()];
            while (result_SubCat.moveToNext()){
                SubCatsData subCatsData = new SubCatsData();
                subCatsData.setSubcat_id(result_SubCat.getInt(1));
                subCatsData.setSubcat_name(result_SubCat.getString(2));
                subCatsDatas[index_subcat] = subCatsData;
                index_subcat += 1;
            }
            catsData.setSubcat(subCatsDatas);
            catsDatas[index_cat] = catsData;
            index_cat += 1;
        }
        return catsDatas;
    }

    private static AreaData[] getAreaData(){
        int index_city = 0;
        /** Citys */
        Cursor result_City = database.query(Table_City.TABLE_NAME,null,null,null,null,null,null);
        AreaData[] areaDatas = new AreaData[result_City.getCount()];
        while (result_City.moveToNext()){
            AreaData areaData = new AreaData();
            areaData.setCity_id(result_City.getInt(1));
            areaData.setCity_name(result_City.getString(2));

            /** SubCitys */
            int index_subcity = 0;
            String where = Table_City.COLUMN_ID + " = " + result_City.getInt(1);
            Cursor result_SubCity = database.query(Table_SubCity.TABLE_NAME,null,where,null,null,null,null);
            SubAreaData[] subAreaDatas = new SubAreaData[result_SubCity.getCount()];
            while (result_SubCity.moveToNext()){
                SubAreaData subAreaData = new SubAreaData();
                subAreaData.setSubarea_id(result_SubCity.getString(1));
                subAreaData.setSubarea_name(result_SubCity.getString(2));
                subAreaDatas[index_subcity] = subAreaData;
                index_subcity += 1;
            }
            areaData.setSubarea(subAreaDatas);
            areaDatas[index_city] = areaData;
            index_city += 1;
        }
        return areaDatas;
    }

    private static OrderData[] getOrderData(){
        int index_order = 0;
        /** Orders */
        Cursor result_Order = database.query(Table_Order.TABLE_NAME,null,null,null,null,null,null);
        OrderData[] orderDatas = new OrderData[result_Order.getCount()];
        while (result_Order.moveToNext()){
            OrderData orderData = new OrderData();
            orderData.setOrder_id(result_Order.getInt(1));
            orderData.setOrder_name(result_Order.getString(2));
            orderDatas[index_order] = orderData;
            index_order +=1;
        }
        return orderDatas;
    }
}
