package friendo.mtel.loyalty.db;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by MTel on 2015/8/17.
 */
public class SQLHelper extends SQLiteOpenHelper {
    private String TAG = SQLHelper.class.getSimpleName();
    private static final String DATABASE_NAME = "com.friendo.mtel.loyalty.db";
    private static final int DATABASE_VERSION = 1;

    private SQLiteDatabase database;

    public SQLHelper(Context context){
        super(context,DATABASE_NAME, null, DATABASE_VERSION);
        try{
            database = this.getWritableDatabase();
        }catch (Exception e){
            Log.e(TAG,"Greate database wrong. error on the SQLHelper.class line 19 , Exception:"+e);
        }
    }

    public SQLHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    protected void createDBTable(SQLiteDatabase db){
        try {

        }catch (Exception e){
            Log.e(TAG,"Create table exception wrong in SQLHelper.class line 43, Exception:"+ e);
        }
    }
}
