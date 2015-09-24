package friendo.mtel.loyalty.db;

import android.content.ContentValues;
import android.database.Cursor;

import friendo.mtel.loyalty.component.SubAreaData;

/**
 * Created by MTel on 2015/9/16.
 */
public class Table_SubCity extends DBManager {

    private String TAG = Table_SubCity.class.getSimpleName();

    /** Table name */
    public static final String TABLE_NAME = "SUBCITY";

    /** Column */
    public static final String COLUMN_ID = "subCityID";
    public static final String COLUMN_Name = "subCityName";

    public static final String TABLE_CREATE =
            CREATETABLE + TABLE_NAME + " (" +
                    KEY_ID + INTEGER + PRIMARKEY +
                    COLUMN_ID + TEXT + NOTNULL + COMMA +
                    COLUMN_Name + TEXT + COMMA +
                    Table_City.COLUMN_ID + INTEGER +
                    ");";

    public static boolean get(String subCityid, int Cityid){
        String where = COLUMN_ID + " = " + "'" + subCityid +"'" + AND + Table_City.COLUMN_ID + " = "  + Cityid;
        Cursor result = database.query(TABLE_NAME,null,where,null,null,null,null);
        return result.getCount() > 0;
    }

    public static boolean update(SubAreaData subAreaData, int CityID){
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_ID,subAreaData.getSubarea_id());
        cv.put(COLUMN_Name,subAreaData.getSubarea_name());
        cv.put(Table_City.COLUMN_ID, CityID);

        String where = COLUMN_ID + " = " + "'" + subAreaData.getSubarea_id() + "'" + AND + Table_City.COLUMN_ID + " = "  + CityID;
        return database.update(TABLE_NAME, cv, where, null) > 0;
    }

    public static boolean delete(String subCityid, int Cityid){
        String where = COLUMN_ID + " = " + "'" + subCityid + "'" + AND + Table_City.COLUMN_ID + " = "  + Cityid;
        return database.delete(TABLE_NAME, where, null) > 0;
    }

    public static boolean insert(SubAreaData subAreaData, int Cityid){
        return database.insert(TABLE_NAME,null, getContentValues(subAreaData,Cityid)) > 0;
    }

    private static ContentValues getContentValues(SubAreaData subAreaData, int Cityid){
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_ID,subAreaData.getSubarea_id());
        cv.put(COLUMN_Name,subAreaData.getSubarea_name());
        cv.put(Table_City.COLUMN_ID,Cityid);
        return cv;
    }
}
