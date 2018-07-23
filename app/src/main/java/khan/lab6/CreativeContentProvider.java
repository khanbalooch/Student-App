package khan.lab6;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.annotation.Nullable;

/**
 * Created by Khan on 03-Mar-17.
 */

public class CreativeContentProvider extends ContentProvider {

    private MyDB helper;
    private SQLiteDatabase db;
    public static final int IDEAS = 100;
    public static final int IDEA_WITH_ID = 101;
    // Declare a static variable for the Uri matcher that you
    // construct
    private static final UriMatcher sUriMatcher = buildUriMatcher();

    public static UriMatcher buildUriMatcher()
    {
        // Initialize a UriMatcher with no matches by passing in NO_MATCH to the constructor
        UriMatcher uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
        /*
        All paths added to the UriMatcher have a corresponding int.
        For each kind of uri you may want to access, add the corresponding match with addURI.
        The two calls below add matches for the task directory and a single item by ID.
        */
        uriMatcher.addURI(Contract.AUTHORITY, Contract.PATH_CREATIVE, IDEAS);
        uriMatcher.addURI(Contract.AUTHORITY, Contract.PATH_CREATIVE + "/#", IDEA_WITH_ID);
        return uriMatcher;
    }
    @Override
    public boolean onCreate()
    {
        Context context = getContext();
        helper = new MyDB(context);
        db = helper.getWritableDatabase();
        return true;
    }

    @Nullable
    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder)
    {
        return null;
    }

    @Nullable
    @Override
    public String getType(Uri uri) {
        return null;
    }

    @Nullable
    @Override
    public Uri insert(Uri uri, ContentValues values)
    {
        int match = sUriMatcher.match(uri);
        Uri returnUri; // URI to be returned
        switch (match) {
            case IDEAS:
// Insert new values into the database
// Inserting values into students table
                long id = db.insert(Contract.CreativeEntry.tableName, null, values);
                if ( id > 0 ) {
                    returnUri = ContentUris.withAppendedId(Contract.CreativeEntry.CONTENT_URI, id);
                } else {
                    throw new android.database.SQLException("Failed to insert row into " + uri);
                }
                break;
// Set the value for the returnedUri and write the default case for unknown URI's
// Default case throws an UnsupportedOperationException
            default:
                throw new UnsupportedOperationException("Unknown uri: " + uri);
        }
// Notify the resolver if the uri has been changed, and return the newly inserted URI
        getContext().getContentResolver().notifyChange(uri, null);
        return null;
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs)
    {
        /*switch () {
// Handle the single item case, recognized by the ID included in the URI path
            case IDEA_WITH_ID:
// Get the student ID from the URI path
                String id = uri.getPathSegments().get(1);
// Use selections/selectionArgs to filter for this ID
                studentsDeleted = db.delete(Contract.CreativeEntry.tableName, "_id=?", new String[]{id});
                break;
            default:
                throw new UnsupportedOperationException("Unknown uri: " + uri);
        }
// Notify the resolver of a change and return the number of items deleted
        if (studentsDeleted != 0) {
// A student was deleted, set notification
            getContext().getContentResolver().notifyChange(uri, null);
        }*/
        return 0;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        return 0;
    }

}