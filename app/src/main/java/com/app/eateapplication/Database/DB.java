package com.app.eateapplication.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.app.eateapplication.model.Order;

/**
 * Created by best tech on 9/19/2017.
 */

public class DB {
    private final Context context;
    MysqliteDBhelper databasehelper;
    private SQLiteDatabase db;

    public DB(Context context) {
        databasehelper = new MysqliteDBhelper(context, "mydb", null, 4);
        this.context = context;
    }

    public DB open() {
        db = databasehelper.getWritableDatabase();
        return this;

    }

    public DB addtocart(Order order){
        Log.d("ooooh","ok");

        Log.d("hahahahah","ok");

        ContentValues values = new ContentValues();
        //addvlaue
        values.put(databasehelper.productId_COLUMN,order.getProductId());
        values.put(databasehelper.productNAME_COLUMN,order.getProducrName());
        values.put(databasehelper.productquantity_COLUMN,order.getQuantity());
        values.put(databasehelper.productPrice_COLUMN,order.getPrice());
        values.put(databasehelper.productDiscount_COLUMN,order.getDiscount());

        long id = db.insert(databasehelper.ORDER_TABLE,databasehelper.productId_COLUMN, values);

        return this ;

    }

    public DB addOrder(String ProductId, String ProductName, String Quantity, String Price, String Discount) {
        db.beginTransaction();
        ContentValues value = new ContentValues();
        //add value to database ;
        value.put(databasehelper.productId_COLUMN, ProductId);
        value.put(databasehelper.productNAME_COLUMN, ProductName);
        value.put(databasehelper.productquantity_COLUMN, Quantity);
        value.put(databasehelper.productPrice_COLUMN, Price);
        value.put(databasehelper.productDiscount_COLUMN, Discount);

        long id = db.insert(databasehelper.ORDER_TABLE, databasehelper.productId_COLUMN, value);
        db.beginTransaction();
        return this;
    }

    public Cursor getorder(int id) {
        Cursor cursor = db.rawQuery("select ProductName from order where id = ?", new String[]{id + ""});
        return cursor;
    }

    public int ubdateorder(String id, String ProductId, String ProductName, String Quantity, String Price, String Discount) {

        ContentValues values = new ContentValues();
        values.put(databasehelper.productId_COLUMN, ProductId);
        values.put(databasehelper.productNAME_COLUMN, ProductName);
        values.put(databasehelper.productquantity_COLUMN, Quantity);
        values.put(databasehelper.productPrice_COLUMN, Price);
        values.put(databasehelper.productDiscount_COLUMN, Discount);

        return db.update(databasehelper.ORDER_TABLE, values,
                databasehelper.ID_COLUMN + "=?",
                new String[]{id});

    }

    public int deleteorder(String id) {
        return db.delete(databasehelper.ORDER_TABLE, databasehelper.ID_COLUMN + "=?", new String[]{id});
    }

    public void close() {
        db.close();
    }
}
