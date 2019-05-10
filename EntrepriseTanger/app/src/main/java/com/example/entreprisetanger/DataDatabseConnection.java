package com.example.entreprisetanger;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DataDatabseConnection extends SQLiteOpenHelper {
    public static final String dbname = "Tanger_BD.db";
    public static final int version = 1;

    public DataDatabseConnection(Context context) {
        super(context, dbname, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sqlquery = "CREATE TABLE if NOT EXISTS base_entreprise (id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, Nom TEXT NOT NULL ,Domaine TEXT NOT NULL,Telephone TEXT NOT NULL,Zone TEXT NOT NULL,Adresse TEXT NOT NULL,Lat TEXT NOT NULL,Lng TEXT NOT NULL)";
        db.execSQL(sqlquery);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("Drop TABLE IF EXISTS base_entreprise");
            onCreate(db);
        }

        public void Ajouter_Entreprise(String nom, String dom, String tel, String zone, String adr, String Lat, String Lng) {
            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put("Nom", nom);
            contentValues.put("Domaine", dom);
            contentValues.put("Telephone", tel);
            contentValues.put("Zone", zone);
            contentValues.put("Adresse", adr);
            contentValues.put("Lat", Lat);
            contentValues.put("Lng", Lng);
            db.insert("base_entreprise", null, contentValues);

    }
    public void Supprimer_Entreprise(String id){
        SQLiteDatabase db=this.getWritableDatabase();
        db.delete("base_entreprise ","id=?",new String[] {id});
    }
    public ArrayList<Entreprise_Manager> ListeZone1(){
        ArrayList<Entreprise_Manager> Liste=new ArrayList<>();
        Entreprise_Manager E;
        SQLiteDatabase db=this.getReadableDatabase();
        try  {
            Cursor resultat;
            resultat = db.rawQuery("select * from base_entreprise where Zone=?", new String [] {String.valueOf("Gzenaya")});
            resultat.moveToFirst();
            while (resultat.isAfterLast()==false){
                E=new Entreprise_Manager(resultat.getString(resultat.getColumnIndex("Nom")),resultat.getString(resultat.getColumnIndex("Adresse")),resultat.getString(resultat.getColumnIndex("Domaine")),resultat.getString(resultat.getColumnIndex("Zone")),resultat.getString(resultat.getColumnIndex("Telephone")),resultat.getString(resultat.getColumnIndex("Lat")),resultat.getString(resultat.getColumnIndex("Lng")),resultat.getInt(resultat.getColumnIndex("id")));
                Liste.add(E);
                resultat.moveToNext();
            }
        }catch (Exception R){

        }

        return  Liste;
    }
    public ArrayList<Entreprise_Manager> ListeZone2(){
        ArrayList<Entreprise_Manager> Liste=new ArrayList<>();
        Entreprise_Manager E;
        SQLiteDatabase db=this.getReadableDatabase();
        try  {
            Cursor resultat;
            resultat = db.rawQuery("select * from base_entreprise where Zone=?", new String [] {String.valueOf("freezone")});
            resultat.moveToFirst();
            while (resultat.isAfterLast()==false){
                E=new Entreprise_Manager(resultat.getString(resultat.getColumnIndex("Nom")),resultat.getString(resultat.getColumnIndex("Adresse")),resultat.getString(resultat.getColumnIndex("Domaine")),resultat.getString(resultat.getColumnIndex("Zone")),resultat.getString(resultat.getColumnIndex("Telephone")),resultat.getString(resultat.getColumnIndex("Lat")),resultat.getString(resultat.getColumnIndex("Lng")),resultat.getInt(resultat.getColumnIndex("id")));
                Liste.add(E);
                resultat.moveToNext();
            }
        }catch (Exception R){

        }

        return  Liste;
    }
public boolean isdouble(String Lat ,String lng){
        double a,b;
        try{
            a=Double.parseDouble(Lat);
            b=Double.parseDouble(lng);
            return true;
        }catch (Exception e){

        }
        return false;
}
}
