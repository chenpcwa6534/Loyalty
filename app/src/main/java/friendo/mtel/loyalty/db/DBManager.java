package friendo.mtel.loyalty.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import friendo.mtel.loyalty.component.CatsData;
import friendo.mtel.loyalty.component.AreaData;
import friendo.mtel.loyalty.component.FilterData;
import friendo.mtel.loyalty.component.OrderData;
import friendo.mtel.loyalty.component.OrdersData;
import friendo.mtel.loyalty.component.SubAreaData;
import friendo.mtel.loyalty.component.SubCatsData;
import friendo.mtel.loyalty.dbStructure.TableFilterCity;

/**
 * Created by MTel on 2015/8/17.
 */
public class DBManager extends SQLiteOpenHelper {
    private String TAG = DBManager.class.getSimpleName();
    private static final String DATABASE_NAME = "com.friendo.mtel.loyalty.db";
    private static final int DATABASE_VERSION = 1;
    private static DBManager dbManager = null;

    public static DBManager getInstance(Context context){
        if(dbManager != null){
            dbManager = new DBManager(context,DATABASE_NAME,null,DATABASE_VERSION);
        }
        return dbManager;
    }

    public DBManager(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public DBManager(Context context, String name, SQLiteDatabase.CursorFactory factory, int version, DatabaseErrorHandler errorHandler) {
        super(context, name, factory, version, errorHandler);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TableFilterCity.DATABASE_CREATE_TABLE_city);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }


//    private final static String Comma = ",";
//    private final static String TEXT = " TEXT";
//    private final static String INT = " INTEGER ";
//
//    //TAB Name
//    /** Filter Data*/
//    private final static String TAB_Filter_city = "Filter_city_data";
//    private final static String TAB_Filter_subcity = "Filter_subcity_data";
//    private final static String TAB_Filter_cat = "Filter_cat_data";
//    private final static String TAB_Filter_subcat = "Filter_subcat_data";
//    private final static String TAB_Filter_order_point = "Filter_order_point_data";
//    private final static String TAB_Filter_order_limit = "Filter_order_limit_data";
//
//    //Table column
//    private final static String COL_keyid = "_id";
//    //TAB_Filter_citys
//    private final static String COL_cityid = "cityid";
//    private final static String COL_cityname = "cityname";
//    //TAB_Filter_subcity
//    private final static String COL_subcityid = "areaid";
//    private final static String COL_subcityname = "areaname";
//    //TAB_Filter_cats
//    private final static String COL_catid = "catid";
//    private final static String COL_catname = "catname";
//    //TAB_Filter_subcat
//    private final static String COL_subcatid = "subcatid";
//    private final static String COL_subcatname = "subcatname";
//    //TAB_Filter_order
//    private final static String COL_orderid = "orderid";
//    private final static String COL_ordername = "ordername";
//
//
//    //Create city table string
//    private final String DATABASE_CREATE_TABLE_city =
//            "create table if not exists" + TAB_Filter_city + " ("
//            +COL_keyid + " INTEGER PRIMARY KEY AUTOINCREMENT, "
//            +COL_cityid + TEXT + Comma
//            +COL_cityname + TEXT +Comma
//                    +" );";
//
//    //Create subarea table string
//    private final String DATABASE_CREATE_TABLE_subcity =
//            "create table if not exists" + TAB_Filter_subcity + " ("
//                    +COL_keyid + " INTEGER PRIMARY KEY AUTOINCREMENT, "
//                    +COL_cityid + TEXT + Comma
//                    +COL_subcityid + TEXT + Comma
//                    +COL_subcityname + TEXT +Comma
//                    +" );";
//
//    //Create cats table string
//    private final String DATABASE_CREATE_TABLE_cat =
//            "create table if not exists" + TAB_Filter_cat + " ("
//                    +COL_keyid + " INTEGER PRIMARY KEY AUTOINCREMENT, "
//                    +COL_catid + TEXT + Comma
//                    +COL_catname + TEXT +Comma
//                    +" );";
//
//    //Create subcat table string
//    private final String DATABASE_CREATE_TABLE_subcat =
//            "create table if not exists" + TAB_Filter_subcat + " ("
//                    +COL_keyid + " INTEGER PRIMARY KEY AUTOINCREMENT, "
//                    +COL_catid + TEXT + Comma
//                    +COL_subcatid + TEXT + Comma
//                    +COL_subcatname + TEXT +Comma
//                    +" );";
//
//    //Create subcat table string
//    private final String DATABASE_CREATE_TABLE_order_point =
//            "create table if not exists" + TAB_Filter_order_point + " ("
//                    +COL_keyid + " INTEGER PRIMARY KEY AUTOINCREMENT, "
//                    +COL_orderid + TEXT + Comma
//                    +COL_ordername + TEXT +Comma
//                    +" );";
//
//    //Create subcat table string
//    private final String DATABASE_CREATE_TABLE_order_limit =
//            "create table if not exists" + TAB_Filter_order_limit + " ("
//                    +COL_keyid + " INTEGER PRIMARY KEY AUTOINCREMENT, "
//                    +COL_orderid + TEXT + Comma
//                    +COL_ordername + TEXT +Comma
//                    +" );";
//
//
//    /**
//     * =======================================================================================================================================
//     * get data
//     * =======================================================================================================================================
//     */
//
//
//    /**
//     * Filter db
//     *
//     *     Ci = citydata index
//     *     SCi = subAreadata index
//     * @param data
//     */
//    public void setFilter(FilterData data){
//        setFilterCity(data.getArea());
//        setFilterCat(data.getCats());
//        setFilterOder(data.getOrder());
//    }
//
//    /**
//     * Filter city data db
//     *
//     *     Ci = citydata index
//     *     SCi = subAreadata index
//     * @param data
//     */
//    private void setFilterCity(AreaData[] data){
//        //city
//        for(int Ci=0; Ci<data.length; Ci++){
//            String where = COL_cityid +" = " + data[Ci].getCity_id();
//            boolean isExist = get(TAB_Filter_city,where);
//            ContentValues cv = new ContentValues();
//            cv.put(COL_cityid, data[Ci].getCity_id());
//            cv.put(COL_cityname, data[Ci].getCity_name());
//            if(isExist){
//                if(data[Ci].isCityVaild() == true){
//                    /** if data is exist and valid is true then data is update */
//                    update(TAB_Filter_city,cv,where);
//                }else{
//                    /** if data is exist and valid is true then data is delete */
//                    delete(TAB_Filter_city,where);
//                }
//            }else {
//                if(data[Ci].isCityVaild() == true){
//                    /** if data is exist and valid is true then data is insert */
//                    add(TAB_Filter_city,cv,where);
//                }
//            }
//
//            //subarea data
//            SubAreaData[] subAreaDatas = data[Ci].getSubarea();
//            for(int SCi=0; SCi<subAreaDatas.length; SCi++){
//                where = COL_subcityid + " = " + subAreaDatas[SCi].getSubarea_id();
//                isExist = get(TAB_Filter_subcity,where);
//                ContentValues Subcv = new ContentValues();
//                Subcv.put(COL_cityid,data[Ci].getCity_id());
//                Subcv.put(COL_subcityid,subAreaDatas[SCi].getSubarea_id());
//                Subcv.put(COL_subcityname,subAreaDatas[SCi].getSubarea_name());
//                if(isExist){
//                    if(subAreaDatas[SCi].isSubcityVaild() == true){
//                        /** if data is exist and valid is true then data is update */
//                        update(TAB_Filter_subcity,cv,where);
//                    }else{
//                        /** if data is exist and valid is true then data is delete */
//                        delete(TAB_Filter_subcity,where);
//                    }
//                }else {
//                    if(subAreaDatas[SCi].isSubcityVaild() == true){
//                        /** if data is exist and valid is true then data is insert */
//                        add(TAB_Filter_subcity,cv,where);
//                    }
//                }
//            }
//        }
//    }
//
//    /**
//     * Filter cat data db
//     *
//     *     CAi = catdata index
//     *     SCAi = subCatdata index
//     * @param data
//     */
//    private void setFilterCat(CatsData[] data){
//        //cat
//        for(int CAi=0; CAi<data.length; CAi++){
//            String where = COL_catid +" = " + data[CAi].getCat_id();
//            boolean isExist = get(TAB_Filter_cat,where);
//            ContentValues cv = new ContentValues();
//            cv.put(COL_catid, data[CAi].getCat_id());
//            cv.put(COL_catname, data[CAi].getCat_name());
//            if(isExist){
//                if(data[CAi].isCatVaild() == true){
//                    /** if data is exist and valid is true then data is update */
//                    update(TAB_Filter_cat,cv,where);
//                }else{
//                    /** if data is exist and valid is true then data is delete */
//                    delete(TAB_Filter_cat,where);
//                }
//            }else {
//                if(data[CAi].isCatVaild() == true){
//                    /** if data is exist and valid is true then data is insert */
//                    add(TAB_Filter_cat,cv,where);
//                }
//            }
//
//            //subarea data
//            SubCatsData[] subCatsDatas = data[CAi].getSubcat();
//            for(int SCAi=0; SCAi<subCatsDatas.length; SCAi++){
//                where = COL_subcatid + " = " + subCatsDatas[SCAi].getSubcat_id();
//                isExist = get(TAB_Filter_subcat,where);
//                ContentValues Subcv = new ContentValues();
//                Subcv.put(COL_catid,data[CAi].getCat_id());
//                Subcv.put(COL_subcatid,subCatsDatas[SCAi].getSubcat_id());
//                Subcv.put(COL_subcatname,subCatsDatas[SCAi].getSubcat_name());
//                if(isExist){
//                    if(subCatsDatas[SCAi].isSubcatVaild() == true){
//                        /** if data is exist and valid is true then data is update */
//                        update(TAB_Filter_subcat,cv,where);
//                    }else{
//                        /** if data is exist and valid is true then data is delete */
//                        delete(TAB_Filter_subcat,where);
//                    }
//                }else {
//                    if(subCatsDatas[SCAi].isSubcatVaild() == true){
//                        /** if data is exist and valid is true then data is insert */
//                        add(TAB_Filter_subcat,cv,where);
//                    }
//                }
//            }
//        }
//    }
//
//    private void setFilterOder(OrderData[] data){
//
//    }
//
//    private void setFilterOder(OrdersData data){
//        OrderData[] point = data.getPoint();
//        OrderData[] limit = data.getLimit();
//
//        for(int Pi=0; Pi<point.length; Pi++){
//            String where = COL_orderid + " = " + point[Pi].getOrderID();
//            boolean isExist = get(TAB_Filter_order_point,where);
//            ContentValues cv = new ContentValues();
//            cv.put(COL_orderid,point[Pi].getOrderID());
//            cv.put(COL_ordername,point[Pi].getOrderName());
//            if(isExist){
//                if(point[Pi].isOrderVaild() == true){
//                    /** if data is exist and valid is true then data is update */
//                    update(TAB_Filter_order_point,cv,where);
//                }else{
//                    /** if data is exist and valid is true then data is delete */
//                    delete(TAB_Filter_order_point,where);
//                }
//            }else {
//                if(point[Pi].isOrderVaild() == true){
//                    /** if data is exist and valid is true then data is insert */
//                    add(TAB_Filter_order_point,cv,where);
//                }
//            }
//        }
//
//        for(int Li=0; Li<limit.length; Li++){
//            String where = COL_orderid + " = " + point[Li].getOrderID();
//            boolean isExist = get(TAB_Filter_order_limit,where);
//            ContentValues cv = new ContentValues();
//            cv.put(COL_orderid,point[Li].getOrderID());
//            cv.put(COL_ordername,point[Li].getOrderName());
//            if(isExist){
//                if(point[Li].isOrderVaild() == true){
//                    /** if data is exist and valid is true then data is update */
//                    update(TAB_Filter_order_limit,cv,where);
//                }else{
//                    /** if data is exist and valid is true then data is delete */
//                    delete(TAB_Filter_order_limit,where);
//                }
//            }else {
//                if(point[Li].isOrderVaild() == true){
//                    /** if data is exist and valid is true then data is insert */
//                    add(TAB_Filter_order_limit,cv,where);
//                }
//            }
//        }
//
//    }
//
//    /**
//     * db control delete
//     * @param tablename
//     * @param where
//     * @return
//     */
//    private boolean delete(String tablename, String where ){
//        SQLiteDatabase db = getReadableDatabase();
//        boolean result = db.delete(tablename,where,null) > 0;
//        if(result){
//            Log.e(TAG,"datebase in " + tablename + " delete  where is " + where + " success");
//        }else {
//            Log.e(TAG,"datebase in " + tablename + " delete  where is " + where + " fail");
//        }
//        return result;
//    }
//
//
//    /**
//     * db control insert
//     * @param tablename
//     * @param cv
//     * @param where
//     * @return
//     */
//    private boolean add(String tablename, ContentValues cv, String where){
//        SQLiteDatabase db = getReadableDatabase();
//        boolean result = db.insert(tablename,null, cv) > 0;
//        if(result){
//            Log.e(TAG,"datebase in " + tablename + " add  where is " + where + " success");
//        }else {
//            Log.e(TAG,"datebase in " + tablename + " add  where is " + where + " fail");
//        }
//        return result;
//    }
//
//    /**
//     * db control insert
//     * @param tablename
//     * @param cv
//     * @param where
//     * @return
//     */
//    private boolean update(String tablename, ContentValues cv, String where){
//        SQLiteDatabase db = getReadableDatabase();
//        boolean result = db.update(tablename,cv,where,null) > 0;
//        if(result){
//            Log.e(TAG,"datebase in " + tablename + " update  where is " + where + " success");
//        }else {
//            Log.e(TAG,"datebase in " + tablename + " update  where is " + where + " fail");
//        }
//        return result;
//    }
//
//    private boolean get(String tablename, String where){
//        SQLiteDatabase db = getReadableDatabase();
//        Cursor result = db.query(tablename,null,where,null,null,null,null);
//        return result.moveToFirst();
//    }
//
//
//    @Override
//    public void onCreate(SQLiteDatabase db) {
//        super.onCreate(db);
//    }
//
//    @Override
//    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
//        super.onUpgrade(db, oldVersion, newVersion);
//    }
//
//    @Override
//    protected void createDBTable(SQLiteDatabase db) {
//        Log.d(TAG,"Create Table");
//        try{
//            db.execSQL(TableFilterCity.TABLE_city);
////            db.execSQL(DATABASE_CREATE_TABLE_city);
////            db.execSQL(DATABASE_CREATE_TABLE_subcity);
////            db.execSQL(DATABASE_CREATE_TABLE_cat);
////            db.execSQL(DATABASE_CREATE_TABLE_subcat);
////            db.execSQL(DATABASE_CREATE_TABLE_order_point);
////            db.execSQL(DATABASE_CREATE_TABLE_order_limit);
//        }catch (Exception e){
//            Log.e(TAG,"Create table exception wrong in DBManager.class line 123, Exception:"+ e);
//        }
//    }
}
