package friendo.mtel.loyalty.db;

import android.content.ContentValues;
import android.database.Cursor;
import friendo.mtel.loyalty.component.SubCatsData;

/**
 * Created by MTel on 2015/9/16.
 */
public class Table_SubCat extends DBManager{
    private static String TAG = Table_SubCat.class.getSimpleName();

    /** Table name */
    public static final String TABLE_NAME = "SUBCAT";

    /** Column */
    public static final String COLUMN_ID = "subCatID";
    public static final String COLUMN_Name = "subCatName";

    public static final String TABLE_CREATE =
            CREATETABLE + TABLE_NAME + " (" +
                    KEY_ID + INTEGER + PRIMARKEY +
                    COLUMN_ID + INTEGER + NOTNULL + COMMA +
                    COLUMN_Name + TEXT + COMMA +
                    Table_Cat.COLUMN_ID + INTEGER +
                    ");";

    public static boolean get(int subCatid, int Catid){
        String where = COLUMN_ID + " = " + subCatid + AND + Table_Cat.COLUMN_ID + " = " + Catid;
        Cursor result = database.query(TABLE_NAME,null,where,null,null,null,null);
        return result.getCount() > 0;
    }

    public static boolean update(SubCatsData subCatsData, int Catid){
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_ID,subCatsData.getSubcat_id());
        cv.put(COLUMN_Name,subCatsData.getSubcat_name());

        String where = COLUMN_ID + " = " + subCatsData.getSubcat_id() + AND + Table_Cat.COLUMN_ID + " = " + Catid;
        return database.update(TABLE_NAME, cv, where, null) > 0;
    }

    public static boolean delete(int subCatid, int Catid){
        String where = COLUMN_ID + " = " + subCatid + AND + Table_Cat.COLUMN_ID + " = "  + Catid;
        return database.delete(TABLE_NAME, where, null) > 0;
    }

    public static boolean insert(SubCatsData subCatsData, int Catid){
        return database.insert(TABLE_NAME,null, getContentValues(subCatsData,Catid)) > 0;
    }

    private static ContentValues getContentValues(SubCatsData subCatsData, int Catid){
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_ID,subCatsData.getSubcat_id());
        cv.put(COLUMN_Name,subCatsData.getSubcat_name());
        cv.put(Table_Cat.COLUMN_ID, Catid);
        return cv;
    }
}
