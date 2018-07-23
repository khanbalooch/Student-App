package khan.lab6;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.CharArrayBuffer;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static java.sql.Types.INTEGER;

public class MainActivity extends AppCompatActivity {

    String [] ideas = {"Convert To Islam","Sugar Controller", "Learn Quran Pornunciation","ALLAH-U-AKBAR","and Thats Enough"};
    TextView id, level, category,uniqueness, idea,rowCount ;
    Cursor cursor ;
    SQLiteDatabase myDb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        id = (TextView) findViewById(R.id.id);
        level = (TextView) findViewById(R.id.level);
        category = (TextView) findViewById(R.id.category);
        uniqueness = (TextView) findViewById(R.id.uniqueness);
        idea = (TextView) findViewById(R.id.idea);
        rowCount = (TextView) findViewById(R.id.RowCount);


    }

    public void ShowNextRow(View view)
    {

        /*id.setText(         "ID: "+  Integer.toString( cursor.getInt( cursor.getColumnIndex(Contract.CreativeEntry.colID) ) ) );
        level.setText(      "LEVEL: "+  Integer.toString( cursor.getInt( cursor.getColumnIndex(Contract.CreativeEntry.colLEVEL) ) ) );
        category.setText(   "CATEGORY: "+  Integer.toString( cursor.getInt( cursor.getColumnIndex(Contract.CreativeEntry.colCATEGORY) ) ) );
        uniqueness.setText( "UNIQUENESS: "+ Integer.toString( cursor.getInt( cursor.getColumnIndex(Contract.CreativeEntry.colUNIQEUNESS) ) ) );
        idea.setText(       "IDEA: "+   cursor.getString( cursor.getColumnIndex(Contract.CreativeEntry.colIDEA) ) );
        if(cursor.isLast())
        {
            cursor.moveToFirst();
        }else
        {
            cursor.moveToNext();
        }*/
        ContentValues val = new ContentValues();
        val.put(Contract.CreativeEntry.colID, 1);
        val.put(Contract.CreativeEntry.colCATEGORY, 2);
        val.put(Contract.CreativeEntry.colIDEA, "test");
        val.put(Contract.CreativeEntry.colLEVEL, 4);
        val.put(Contract.CreativeEntry.colCATEGORY, 5);
        Uri insert = this.getContentResolver().insert(Contract.CreativeEntry.CONTENT_URI, val); 
    }

}
