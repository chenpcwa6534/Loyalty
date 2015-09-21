package friendo.mtel.loyalty.db;

import android.content.ContentValues;
import android.database.Cursor;

/**
 * Created by MTel on 2015/9/17.
 */
public class Table_Order extends DBManager {
    private String TAG = Table_Order.class.getSimpleName();

    /** Table name */
    public static final String TABLE_NAME = "SEQUENCE";

    /** Column */
    public static final String COLUMN_ID = "SequenceID";
    public static final String COLUMN_Name = "SequenceName";

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

    public static final boolean update(int order_id,String order_name){
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_ID,order_id);
        cv.put(COLUMN_Name,order_name);

        String where = COLUMN_ID + " = " + order_id;
        return database.update(TABLE_NAME, cv, where, null) > 0;
    }

    public static boolean insert(int order_id,String order_name){
        return database.insert(TABLE_NAME,null, getContentValues(order_id,order_name)) > 0;
    }

    private static ContentValues getContentValues(int order_id,String order_name){
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_ID,order_id);
        cv.put(COLUMN_Name,order_name);
        return cv;
    }
}
