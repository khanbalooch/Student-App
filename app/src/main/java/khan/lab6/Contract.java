package khan.lab6;

import android.content.UriMatcher;
import android.net.Uri;
import android.provider.BaseColumns;

public class Contract implements BaseColumns
{
    public static final String AUTHORITY = "khan.lab6.CreativeContentProvider";
    public static final Uri BASE_CONTENT_URI = Uri.parse("content://"+AUTHORITY);
    public static final String PATH_CREATIVE = "creative";



    public static final class CreativeEntry implements BaseColumns
    {
        public static final String tableName = "CREATIVE";
        public static final String colID = "ID";
        public static final String colCATEGORY = "CATEGORY";
        public static final String colLEVEL = "LEVEL";
        public static final String colUNIQEUNESS = "UNIQUENESS";
        public static final String colIDEA = "IDEA";
        public static final Uri CONTENT_URI = BASE_CONTENT_URI.buildUpon().appendPath(PATH_CREATIVE).build();

    }
}
