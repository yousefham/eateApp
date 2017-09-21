package com.app.eateapplication.Adapter;

import android.content.Context;
import android.database.Cursor;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;

/**
 * Created by best tech on 9/19/2017.
 */

public class MyDBAdapter extends CursorAdapter {
    public MyDBAdapter(Context context, Cursor c, boolean autoRequery) {
        super(context, c,autoRequery);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        return null;
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {

    }
}
