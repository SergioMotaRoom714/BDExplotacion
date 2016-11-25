package com.herprogramacion.explotacion.data;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import static com.herprogramacion.explotacion.data.ExplotacionContract.ExplotacionEntry;

/**
 * Manejador de la base de datos
 */
public class ExplotacionDbHelper extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "explotacion.db";

    public ExplotacionDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + ExplotacionEntry.TABLE_NAME + " ("
                + ExplotacionEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + ExplotacionEntry.CROTAL + " TEXT NOT NULL,"
                + ExplotacionEntry.CROTAL_MADRE + " TEXT NOT NULL,"
                + ExplotacionEntry.SEXO + " TEXT NOT NULL,"
                + ExplotacionEntry.FECHA_NACIMIENTO + " TEXT NOT NULL,"
                + ExplotacionEntry.TEXTO_EXTRA + " TEXT NOT NULL,"
                + "UNIQUE (" + ExplotacionEntry.CROTAL + "))");

        // Insertar datos ficticios para prueba inicial
        mockData(db);

    }

    private void mockData(SQLiteDatabase sqLiteDatabase) {
        mockExplotacion(sqLiteDatabase, new Explotacion("ES000802635183","ES000802635183", "HEMBRA",
                 "10/05/2010","SOY UNA VACA LECHERA"));

    }

    public long mockExplotacion(SQLiteDatabase db, Explotacion vaca) {
        return db.insert(
                ExplotacionEntry.TABLE_NAME,
                null,
                vaca.toContentValues());
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // No hay operaciones
    }

    public long saveExplotacion(Explotacion vaca) {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();

        return sqLiteDatabase.insert(
                ExplotacionEntry.TABLE_NAME,
                null,
                vaca.toContentValues());

    }

    public Cursor getExplotacion() {
        return getReadableDatabase()
                .query(
                        ExplotacionEntry.TABLE_NAME,
                        null,
                        null,
                        null,
                        null,
                        null,
                        null);
    }

    public Cursor getExplotacionCrotal(String crotal) {
        Cursor c = getReadableDatabase().query(
                ExplotacionEntry.TABLE_NAME,
                null,
                ExplotacionEntry.CROTAL + " LIKE ?",
                new String[]{crotal},
                null,
                null,
                null);
        return c;
    }

    public int deleteExplotacion(String vacaCrotal) {
        return getWritableDatabase().delete(
                ExplotacionEntry.TABLE_NAME,
                ExplotacionEntry.CROTAL + " LIKE ?",
                new String[]{vacaCrotal});
    }

    public int updateExplotacion(Explotacion vaca, String vacaCrotal) {
        return getWritableDatabase().update(
                ExplotacionEntry.TABLE_NAME,
                vaca.toContentValues(),
                ExplotacionEntry.CROTAL + " LIKE ?",
                new String[]{vacaCrotal}
        );
    }
}
