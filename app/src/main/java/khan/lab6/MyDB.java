package khan.lab6;
import khan.lab6.Contract;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Khan on 24-Feb-17.
 */

public class MyDB extends SQLiteOpenHelper
{
    static String dbName = "khan.db";
    static int dbVersion = 1;
    public MyDB(Context context ) {
        super(context, dbName, null, dbVersion);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        String createTable  = "Create Table "+ Contract.CreativeEntry.tableName+ "("+
                Contract.CreativeEntry.colID           + " INTEGER ,"+
                Contract.CreativeEntry.colCATEGORY     + " INTEGER ,"+
                Contract.CreativeEntry.colLEVEL        + " INTEGER ,"+
                Contract.CreativeEntry.colUNIQEUNESS   + " INTEGER ,"+
                Contract.CreativeEntry.colIDEA         + " TEXT   );";
        db.execSQL(createTable);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}