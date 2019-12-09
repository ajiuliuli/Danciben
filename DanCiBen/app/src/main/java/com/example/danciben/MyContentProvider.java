package com.example.danciben;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;

import com.example.danciben.DataBase.Vocabularyshell;

import org.litepal.LitePal;
import org.litepal.crud.LitePalSupport;

import java.util.ArrayList;
import java.util.List;

public class MyContentProvider extends ContentProvider {

    public static final int VOCABULARYSHELL_DIR = 0;

    public static final int VOCABULARYSHELL_ITEM = 1;

    public static final String AUTHORITY = "com.example.danciben.provider";

    private static UriMatcher uriMatcher;

    private SQLiteOpenHelper dbHelper;



    static {
        uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
        uriMatcher.addURI(AUTHORITY,"vocabularyshell",VOCABULARYSHELL_DIR);
        uriMatcher.addURI(AUTHORITY,"vocabularyshell/#",VOCABULARYSHELL_ITEM);
    }

    public MyContentProvider() {
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        // Implement this to handle requests to delete one or more rows.
        int i = 0;
        LitePal.deleteAll(Vocabularyshell.class,"key = ?",selection);
        return i;
    }

    @Override
    public String getType(Uri uri) {
        // TODO: Implement this to handle requests for the MIME type of the data
        // at the given URI.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {
        // TODO: Implement this to handle requests to insert a new row.
        Uri u = null;
        Vocabularyshell vocabularyshell = new Vocabularyshell();
        vocabularyshell.setKey(values.getAsString("key"));
        vocabularyshell.save();
        return u;
    }

    @Override
    public boolean onCreate() {
        // TODO: Implement this to initialize your content provider on startup.

        return true;
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection,
                        String[] selectionArgs, String sortOrder) {
        // TODO: Implement this to handle query requests from clients.

        Cursor c = LitePal.findBySQL("select * from vocabularyshell where key = ?",selection);
        return c;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection,
                      String[] selectionArgs) {
        // TODO: Implement this to handle requests to update one or more rows.
        int i = 0;
        Vocabularyshell v = new Vocabularyshell();
        v.setKey(selection);
        v.updateAll("key = ?",values.getAsString("key"));
        return i;
    }
}
