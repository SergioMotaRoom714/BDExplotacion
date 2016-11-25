package com.herprogramacion.explotacion.data;

import android.content.ContentValues;
import android.database.Cursor;

import com.herprogramacion.explotacion.data.ExplotacionContract.ExplotacionEntry;

/**
 * Entidad "Explotacion"
 * Aquí definimos la estructura que tendrá nuesta base de datos
 * para el caso concreto de la eplotacion ganadera debera estar formada por:
 *  crotal = id
 *  crotalMadre = name
 *  sexo = specialty
 * fechaNacimiento = phoneNumber
 *  otros = bio;
 */


public class Explotacion {
    private String crotal;
    private String crotalMadre;
    private String sexo;
    private String fechaNacimiento;
    private String textoExtra;

    public Explotacion(String crotal,
                  String crotalMadre, String sexo,
                  String fechaNacimiento, String textoExtra) {
        this.crotal = crotal;
        this.crotalMadre = crotalMadre;
        this.sexo = sexo;
        this.fechaNacimiento = fechaNacimiento;
        this.textoExtra = textoExtra;
    }

    public Explotacion(Cursor cursor) {
        crotal = cursor.getString(cursor.getColumnIndex(ExplotacionEntry.CROTAL));
        crotalMadre = cursor.getString(cursor.getColumnIndex(ExplotacionEntry.CROTAL_MADRE));
        sexo = cursor.getString(cursor.getColumnIndex(ExplotacionEntry.SEXO));
        fechaNacimiento = cursor.getString(cursor.getColumnIndex(ExplotacionEntry.FECHA_NACIMIENTO));
        textoExtra = cursor.getString(cursor.getColumnIndex(ExplotacionEntry.TEXTO_EXTRA));
    }

    public ContentValues toContentValues() {
        ContentValues values = new ContentValues();
        values.put(ExplotacionEntry.CROTAL, crotal);
        values.put(ExplotacionEntry.CROTAL_MADRE, crotalMadre);
        values.put(ExplotacionEntry.SEXO, sexo);
        values.put(ExplotacionEntry.FECHA_NACIMIENTO, fechaNacimiento);
        values.put(ExplotacionEntry.TEXTO_EXTRA, textoExtra);
        return values;
    }

    public String getCrotal() {
        return crotal;
    }

    public String getCrotalMadre() {
        return crotalMadre;
    }

    public String getSexo() {
        return sexo;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public String getTextoExtra() {
        return textoExtra;
    }

}
