package friendo.mtel.loyalty.db;

import android.content.ContentValues;
import android.database.Cursor;

import friendo.mtel.loyalty.component.AreaData;

/**
 * Created by MTel on 2015/9/16.
 */
public class Table_City extends DBManager {
    private String TAG = Table_City.class.getSimpleName();

    /** Table name */
    public static final String TABLE_NAME = "CITY";

    /** Column */
    public static final String COLUMN_ID = "CityID";
    public static final String COLUMN_Name = "CityName";

    public static final String TABLE_CREATE =
            CREATETABLE + TABLE_NAME + " (" +
                    KEY_ID + INTEGER + PRIMARKEY +
                    COLUMN_ID + INTEGER + NOTNULL + COMMA +
                    COLUMN_Name + TEXT +
                    ");";

    public static boolean get(int id){
        String where = COLUMN_ID + " = " + id;
        Cursor result = database.query(TABLE_NAME,null,where,null,null,null,null);
        return result.getCount() > 0;
    }

    public static boolean update(AreaData areaData){
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_ID,areaData.getCity_id());
        cv.put(COLUMN_Name,areaData.getCity_name());

        String where = COLUMN_ID + " = " + areaData.getCity_id();
        return database.update(TABLE_NAME, cv, where, null) > 0;
    }

    public static boolean delete(int id){
        String where = COLUMN_ID + " = " +id;
        return database.delete(TABLE_NAME, where, null) > 0;
    }

    public static boolean insert(AreaData areaData){
        return database.insert(TABLE_NAME,null, getContentValues(areaData)) > 0;
    }

    private static ContentValues getContentValues(AreaData areaData){
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_ID,areaData.getCity_id());
        cv.put(COLUMN_Name,areaData.getCity_name());
        return cv;
    }
}
