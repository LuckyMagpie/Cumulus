package com.ecaresoft.cumulus.helpers;

import android.annotation.TargetApi;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.Context;
import android.os.Build;

/**
 * Created by juanortizjr on 9/10/15.
 */
public class DataBaseHelper extends SQLiteOpenHelper {
    public static final int database_version=1;
    public String sqlQuery="CREATE TABLE IF NOT EXISTS " +Table.TableInfo.table_name+"( "+ Table.TableInfo.id_user+" INTEGER PRIMARY KEY, " +
            Table.TableInfo.user+" TEXT," +Table.TableInfo.password+" TEXT);";

    //Constructor para iniciar los metodos del a clase cuando sea llamado, solo si no existe
    public DataBaseHelper(Context context){
        super(context, Table.TableInfo.db_name, null, database_version);
    }

    //Metodo de la clase OpenHelper para crear la BD mediante el query previamente declarado
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(sqlQuery);
    }

    //Si ya existe la base de datos no la vuelve a crear desde 0 y vacia
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        onCreate(sqLiteDatabase);
    }

    //Metodo para insertar informacion en la base de datos local, siempre y cuando sea la primera vez que se ingresa
    public void insertData(DataBaseHelper dop,String user, String password){
        SQLiteDatabase sq=dop.getWritableDatabase();
        Cursor c= sq.rawQuery("SELECT * FROM " + Table.TableInfo.table_name, null);
        if(!(c.moveToFirst())){
            ContentValues cv=new ContentValues();
            cv.put(Table.TableInfo.user,user);
            cv.put(Table.TableInfo.password,password);
            long k=sq.insert(Table.TableInfo.table_name,null,cv);
        }
        dop.close();
    }

    public void insert(DataBaseHelper dop){
        SQLiteDatabase sq=dop.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put(Table.TableInfo.user,"superuser");
        cv.put(Table.TableInfo.password,"NOMBRECOMPLETO");
        long k=sq.insert(Table.TableInfo.table_name, null, cv);
    }
    //Metodo para verificar si el usuario y contraseña son correcto
    public boolean selectData(DataBaseHelper dop, String user, String password){
        SQLiteDatabase sq=dop.getWritableDatabase();
        Cursor c= sq.rawQuery("SELECT * FROM "+Table.TableInfo.table_name+" WHERE "+Table.TableInfo.user+"=? AND "+Table.TableInfo.password+"= ?",new String[]{user,password});
        if(c.moveToFirst()) {
            dop.close();
            return true;
        }
        dop.close();
        return false;
    }
}
