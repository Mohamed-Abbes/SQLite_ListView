package com.example.listview;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbHandler extends SQLiteOpenHelper {
    public static final int DBVERSION= 1;
    public static final String DBNAME="BDD_Etudiant";
    public static final String TABLENAME="etudiant";
    public static final String ID = "id";
    public static final String Nom = "nom";
    public static final String PRENOM = "prenom";
    public static final String EMAIL ="email";
    public static final String PASSWORD = "motdepasse";

    public DbHandler(Context c){
        super(c, DBNAME,null,DBVERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_ETUDIANT_TABLE = "CREATE TABLE " + TABLENAME + "(" +
                ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                Nom + " TEXT," +
                PRENOM + " TEXT," +
                EMAIL + " TEXT UNIQUE," +
                PASSWORD + " TEXT" + ")";

        db.execSQL(CREATE_ETUDIANT_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLENAME );
        onCreate(db);
    }
}
