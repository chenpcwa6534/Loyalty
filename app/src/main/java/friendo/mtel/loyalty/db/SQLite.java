package friendo.mtel.loyalty.db;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by MTel on 2015/9/16.
 */
public class SQLite extends SQLiteOpenHelper {
    private String TAG = SQLite.class.getSimpleName();

    // 資料庫名稱
    public static final String DATABASE_NAME = "Loyalty.db";
    // 資料庫版本，資料結構改變的時候要更改這個數字，通常是加一
    public static final int VERSION = 1;
    // 資料庫物件，固定的欄位變數
    private static SQLiteDatabase database;

    public SQLite(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public SQLite(Context context, String name, SQLiteDatabase.CursorFactory factory, int version, DatabaseErrorHandler errorHandler) {
        super(context, name, factory, version, errorHandler);
    }

    public static SQLiteDatabase getDatabase(Context context) {
        if (database == null || !database.isOpen()) {
            database = new SQLite(context, DATABASE_NAME,
                    null, VERSION).getWritableDatabase();
        }
        return database;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        try{
            db.execSQL(Table_Cat.TABLE_CREATE);
            db.execSQL(Table_SubCat.TABLE_CREATE);
            db.execSQL(Table_City.TABLE_CREATE);
            db.execSQL(Table_SubCity.TABLE_CREATE);
            db.execSQL(Table_Order.TABLE_CREATE);
        }catch (Exception e){
            Log.d(TAG," SQL Create " + e );
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + Table_Cat.TABLE_CREATE);
        db.execSQL("DROP TABLE IF EXISTS " + Table_SubCat.TABLE_CREATE);
        db.execSQL("DROP TABLE IF EXISTS " + Table_City.TABLE_CREATE);
        db.execSQL("DROP TABLE IF EXISTS " + Table_SubCity.TABLE_CREATE);
        db.execSQL("DROP TABLE IF EXISTS " + Table_Order.TABLE_CREATE);
        onCreate(db);
    }
}
