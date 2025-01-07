package com.example.listview;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class EtudiantDao {
    public DbHandler dbh;
    private SQLiteDatabase db;
    public EtudiantDao(Context c){
        this.dbh = new DbHandler(c);
    }

    public long insertEtudiant(Etudiant e){
        db = dbh.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(dbh.Nom,e.getNom());
        cv.put(dbh.PRENOM,e.getPrenom());
        cv.put(dbh.EMAIL, e.getEmail());
        cv.put(dbh.PASSWORD, e.getPassword());

        //Log.d("InsertEtudiant", "Nom: " + e.getNom());
        //Log.d("InsertEtudiant", "Prenom: " + e.getPrenom());
        //Log.d("InsertEtudiant", "Email: " + e.getEmail());
        //Log.d("InsertEtudiant", "Password: " + e.getPassword());

        long res = db.insert(dbh.TABLENAME,null,cv);
        db.close();
        return res;
    }
    public Etudiant getEtudiantWithLogin(String email, String motdepasse) {
        SQLiteDatabase db = dbh.getReadableDatabase();
        Cursor cursor = db.query(dbh.TABLENAME, null,
                dbh.EMAIL + "=? AND " + dbh.PASSWORD + "=?", new String[]{email, motdepasse}, null, null, null);
        if (cursor != null && cursor.moveToFirst()) {
            Etudiant etudiant = new Etudiant();
            etudiant.setId(cursor.getInt(0));
            etudiant.setNom(cursor.getString(1));
            etudiant.setPrenom(cursor.getString(2));
            etudiant.setEmail(cursor.getString(3));
            etudiant.setPassword(cursor.getString(4));
            cursor.close();
            db.close();
            return etudiant;
        }
        return null;
    }
    public List<Etudiant> getAll(){
        List<Etudiant> lst = new ArrayList<>();
        Cursor cr =db.rawQuery("SELECT * FROM etudiant",null);
        if(cr.moveToFirst()){
            do{
                Etudiant e = new Etudiant();
                e.setId(cr.getInt(0));
                e.setNom(cr.getString(1));
                e.setPrenom(cr.getString(2));
                lst.add(e);

            }
            while(cr.moveToNext());
        }
        cr.close();
        return lst;
    }

    public int deleteEtudiant(Etudiant e) {
        return db.delete(dbh.TABLENAME, "id=?", new String[]{String.valueOf(e.getId())});
    }
}
