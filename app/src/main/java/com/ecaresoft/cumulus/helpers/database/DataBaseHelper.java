package com.ecaresoft.cumulus.helpers.database;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.Context;

/**
 * Created by juanortizjr on 9/10/15.
 */
public class DataBaseHelper extends SQLiteOpenHelper {
    public static final int database_version=1;

    public String sqlCreateUser="CREATE TABLE IF NOT EXISTS " + Table.Users.table_name
            + "( "
                + Table.Users.user_id + " INTEGER PRIMARY KEY, "
                + Table.Users.username + " TEXT, "
                + Table.Users.password + " TEXT, "
                + Table.Users.active + " INTEGER, "
                + Table.Users.curp + " TEXT"
            + ");";

    public String sqlCreateSection="CREATE TABLE IF NOT EXISTS " + Table.Sections.table_name
            + "( "
                + Table.Sections.user_id + " INTEGER, "
                + Table.Sections.section_id  + " TEXT, "
                + Table.Sections.content + " TEXT"
            +");";

    //Constructor para iniciar los metodos del a clase cuando sea llamado, solo si no existe
    public DataBaseHelper(Context context){
        super(context, Table.db_name, null, database_version);
    }

    //Metodo de la clase OpenHelper para crear la BD mediante el query previamente declarado
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        //sqLiteDatabase.execSQL("DROP TABLE " + Table.Users.table_name + "; DROP TABLE " + Table.Sections.table_name + "; ");
        sqLiteDatabase.execSQL(sqlCreateUser);
        sqLiteDatabase.execSQL(sqlCreateSection);
    }

    //Si ya existe la base de datos no la vuelve a crear desde 0 y vacia
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        onCreate(sqLiteDatabase);
    }


    //Retorna la session iniciada
    public static int getSession(Context ctx){
        int session = 0;
        try{
            DataBaseHelper conection = new DataBaseHelper(ctx);
            String sql = "SELECT " + Table.Users.user_id
                    + " FROM " + Table.Users.table_name
                    + " WHERE " + Table.Users.active + " = 1 LIMIT 1;";
            SQLiteDatabase sq=conection.getWritableDatabase();
            Cursor rs = sq.rawQuery(sql, new String[]{});
            if (rs != null) {
                rs.moveToFirst();
                session = rs.getInt(0);
            }
            conection.close();
        } catch (Exception e){
            //Error al recuperar si hay un usuario logeado
        }
        return session;
    }

    //Retorna la session iniciada
    public static int getLogin(Context ctx, String user, String password){
        int session = 0;
        try{
            DataBaseHelper conection = new DataBaseHelper(ctx);
            String sql = "SELECT " + Table.Users.user_id
                    + " FROM " + Table.Users.table_name
                    + " WHERE " + Table.Users.username + " = ? "
                    + " AND " + Table.Users.password + " = ? LIMIT 1;";
            SQLiteDatabase sq=conection.getWritableDatabase();
            Cursor rs = sq.rawQuery(sql, new String[]{user, password});
            if (rs != null && rs.moveToFirst()) {
                session = rs.getInt(0);
                sq.execSQL("UPDATE " + Table.Users.table_name
                        + " SET " + Table.Users.active
                        + " = 1 WHERE " + Table.Users.user_id + " = " + session);
            }
            conection.close();
        } catch (Exception e){
            e.getMessage();
            //Error al recuperar si hay un usuario logeado
        }
        return session;
    }

    //Actualiza la seccion
    public static int setSection(Context ctx, int userID, String section, String json){
        int updated = 0;
        if(!json.isEmpty()) {
            try {
                DataBaseHelper conection = new DataBaseHelper(ctx);
                StringBuilder where = new StringBuilder();
                where.append(Table.Sections.user_id).append(" = ? AND ");
                where.append(Table.Sections.section_id).append(" = ? ");

                StringBuilder sql = new StringBuilder();
                sql.append("SELECT ").append(Table.Sections.section_id);
                sql.append(" FROM ").append(Table.Sections.table_name);
                sql.append(" WHERE ").append(where.toString());

                SQLiteDatabase sq = conection.getWritableDatabase();
                Cursor rs = sq.rawQuery(sql.toString(), new String[]{userID + "", section});

                ContentValues cv = new ContentValues();
                cv.put(Table.Sections.user_id, userID);
                cv.put(Table.Sections.section_id, section);
                cv.put(Table.Sections.content, json);

                if (rs != null && rs.moveToFirst()) {
                    //UPDATE
                    sq.update(Table.Sections.table_name, cv, where.toString(), new String[]{userID + "", section});
                } else {
                    //INSERT
                    sq.insert(Table.Sections.table_name, null, cv);
                }
                conection.close();
            } catch (Exception e) {
                e.getMessage();
                //Error al recuperar si hay un usuario logeado
            }
        }
        return updated;
    }

    //Actualiza la seccion
    public static String getSection(Context ctx, int userID, String section){
        String result = null;
        try{
            DataBaseHelper conection = new DataBaseHelper(ctx);

            StringBuilder sql = new StringBuilder();
            sql.append("SELECT ").append(Table.Sections.content);
            sql.append(" FROM ").append(Table.Sections.table_name);
            sql.append(" WHERE ");
            sql.append(Table.Sections.user_id).append(" = ? AND ");
            sql.append(Table.Sections.section_id).append(" = ? ");

            SQLiteDatabase sq=conection.getWritableDatabase();
            Cursor rs = sq.rawQuery(sql.toString(), new String[]{userID+"", section});
            if (rs != null && rs.moveToFirst()) {
                result = rs.getString(0);
            }
            conection.close();
        } catch (Exception e){
            e.getMessage();
            //Error al recuperar si hay un usuario logeado
        }
        return result;
    }



    //Metodo para insertar informacion en la base de datos local, siempre y cuando sea la primera vez que se ingresa
    public void insertData(DataBaseHelper dop, String user, String password){
        SQLiteDatabase sq=dop.getWritableDatabase();
        Cursor c= sq.rawQuery("SELECT * FROM " + Table.Users.table_name, null);
        if(!(c.moveToFirst())){
            ContentValues cv=new ContentValues();
            cv.put(Table.Users.username,user);
            cv.put(Table.Users.password,password);
            long k=sq.insert(Table.Users.table_name,null,cv);
        }
        dop.close();
    }

    public void insert(DataBaseHelper dop){
        SQLiteDatabase sq=dop.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put(Table.Users.username,"superuser");
        cv.put(Table.Users.password, "NOMBRECOMPLETO");
        long k=sq.insert(Table.Users.table_name, null, cv);
    }
    //Metodo para verificar si el usuario y contraseña son correcto
    public boolean selectData(DataBaseHelper dop, String user, String password){
        SQLiteDatabase sq=dop.getWritableDatabase();
        Cursor c= sq.rawQuery("SELECT * FROM "+Table.Users.table_name+" WHERE "+Table.Users.username+"=? AND "+Table.Users.password+"= ?",new String[]{user,password});
        if(c.moveToFirst()) {
            dop.close();
            return true;
        }
        dop.close();
        return false;
    }


    @Deprecated
    public static void setDummyRegistry(Context ctx, String user, String password){
        try{
            DataBaseHelper conection = new DataBaseHelper(ctx);
            String sql = "SELECT " + Table.Users.user_id + " FROM " + Table.Users.table_name + " WHERE " + Table.Users.username + " = ? " + " AND " + Table.Users.password + " = ? LIMIT 1;";
            SQLiteDatabase sq=conection.getWritableDatabase();
            Cursor rs = sq.rawQuery(sql, new String[]{user, password});
            if (rs == null || !rs.moveToFirst()) {
                sq.execSQL("INSERT INTO " + Table.Users.table_name + "(" + Table.Users.username + ", " + Table.Users.password + ", " + Table.Users.user_id + ", " + Table.Users.active + ") VALUES ('" + user + "', '" + password + "', 1, 0);");
            }
            conection.close();
        } catch (Exception e){
            e.getMessage();
            //Error al recuperar si hay un usuario logeado
        }
    }
}
