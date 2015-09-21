package friendo.mtel.loyalty.db;


import android.content.ContentValues;
import android.database.Cursor;

import friendo.mtel.loyalty.component.CatsData;

/**
 * Created by MTel on 2015/9/16.
 */
public class Table_Cat extends DBManager {
    private static String TAG = Table_Cat.class.getSimpleName();

    /** Table name */
    public static final String TABLE_NAME = "CAT";

    /** Column */
    public static final String COLUMN_ID = "CatID";
    public static final String COLUMN_Name = "CatName";

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

    public static boolean update(CatsData catsData){
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_ID,catsData.getCat_id());
        cv.put(COLUMN_Name,catsData.getCat_name());

        String where = COLUMN_ID + " = " + catsData.getCat_id();
        return database.update(TABLE_NAME, cv, where, null) > 0;
    }

    public static boolean delete(int id){
        String where = COLUMN_ID + " = " +id;
        return database.delete(TABLE_NAME, where, null) > 0;
    }

    public static boolean insert(CatsData catsData){
        return database.insert(TABLE_NAME,null, getContentValues(catsData)) > 0;
    }

    private static ContentValues getContentValues(CatsData catsData){
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_ID,catsData.getCat_id());
        cv.put(COLUMN_Name,catsData.getCat_name());
        return cv;
    }
}
