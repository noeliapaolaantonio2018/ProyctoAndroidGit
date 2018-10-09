package com.example.noelia.proyctoandroidgit.adapter;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;


public class ProyectoAdapter {
    private static final String NAME ="PROYECTO";
    private SQLiteDatabase sqlDB;

    public ProyectoAdapter (SQLiteDatabase sqlDB){
        this.sqlDB =sqlDB;
    }

    private class Columns implements BaseColumns{
        public final static String ID ="proyecto_id";
        public final static String DESCRIPCION="descripcion";
        public final static String COSTO="costo";
        public final static String CLIENTE_ID="cliente_id";
    }
    private final static String [] COLUMNS ={
            Columns.ID,Columns.DESCRIPCION,Columns.COSTO,Columns.CLIENTE_ID
    };
    public final static String CR_TABLE = "create table if not exist"
    + NAME + "(" + Columns.ID
    + "integer primary key autoincrement,"
    + Columns.DESCRIPCION+ "TEXTO NULL,"
    + Columns.COSTO + "real,"
    +Columns.CLIENTE_ID + "INTEGER FOREING KEY (cliente id) REFERENCES cliente (cliente_id))";

    public boolean Insert (String descripcion, double costo, int cliente_id){
        ContentValues values = new ContentValues();
        values.put(Columns.DESCRIPCION, descripcion);
        values.put(Columns.COSTO, costo);
        values.put(Columns.CLIENTE_ID, cliente_id);

    return sqlDB.insert(NAME, null, values)> 0;
    }
    public Cursor getDescripciones(){
        String[] columns={Columns.DESCRIPCION};
        return sqlDB.query(NAME,columns,null,null,null,null,null);

        }

    public static String getNAME() {
        return NAME;
    }

    public static String[] getCOLUMNS() {
        return COLUMNS;
    }

    public  boolean isEmpty(){
        return sqlDB.query(NAME, COLUMNS,null,null,null,null,null). getCount()==0;

    }
    public Cursor getDatos(){
        return sqlDB.query(NAME, COLUMNS,null,null,null,null,null);
    }
}

