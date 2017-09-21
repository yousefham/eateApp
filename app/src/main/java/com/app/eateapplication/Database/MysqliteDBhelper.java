package com.app.eateapplication.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by best tech on 9/19/2017.
 */

public class MysqliteDBhelper extends SQLiteOpenHelper {

    public static final String ORDER_TABLE = "order";
    public static final String ID_COLUMN = "id";
    public static final String productId_COLUMN = "ProductId";
    public static final String productNAME_COLUMN = "ProductName";
    public static final String productquantity_COLUMN = "Quantity";
    public static final String productPrice_COLUMN = "Price";
    public static final String productDiscount_COLUMN = "Discount";


    public MysqliteDBhelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + ORDER_TABLE + "(" + ID_COLUMN + "INTEGER PRIMARY KEY AUTOINCREMENT" + "," +
                productId_COLUMN + "TEXT" + "," +
                productNAME_COLUMN + "TEXT" + "," +
                productquantity_COLUMN + "TEXT" + "," +
                productPrice_COLUMN + "TEXT" + "," +
                productDiscount_COLUMN + "TEXT);"
        );

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS order ");
        this.onCreate(db);

    }
}
