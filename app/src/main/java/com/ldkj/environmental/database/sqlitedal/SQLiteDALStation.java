package com.ldkj.environmental.database.sqlitedal;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.ldkj.environmental.database.base.SQLiteDALBase;

/**
 * Created by john on 15-3-20.
 */
public class SQLiteDALStation extends SQLiteDALBase{

    public SQLiteDALStation(Context p_Context) {
        super(p_Context);
    }

    @Override
    protected String[] GetTableNameAndPK() {
        return new String[0];
    }

    @Override
    protected Object FindModel(Cursor p_Cursor) {
        return null;
    }

    @Override
    public void OnCreate(SQLiteDatabase p_DataBase) {

    }

    @Override
    public void OnUpgrade(SQLiteDatabase p_DataBase) {

    }
}
