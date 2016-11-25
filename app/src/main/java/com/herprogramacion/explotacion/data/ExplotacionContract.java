package com.herprogramacion.explotacion.data;

import android.provider.BaseColumns;

/**
 * Esquema de la base de datos para las explotaciones
 */
public class ExplotacionContract {


    /*
    * Añade dentro del paquete data una nueva clase llamada ExplotacionContract
    * donde define una clase interna con los datos de la tabla "explotacion" que se creará en la base de datos:
    */
    public static abstract class ExplotacionEntry implements BaseColumns{
        public static final String TABLE_NAME ="Explotacion Ganadera";

        public static final String CROTAL = "crotal";
        public static final String CROTAL_MADRE = "crotalMadre";
        public static final String SEXO = "sexo";
        public static final String FECHA_NACIMIENTO = "fechaNacimiento";
        public static final String TEXTO_EXTRA = "textoExtra";
    }
}

/*
En el anterior código podemos notar los siguientes detalles:

Creamos la clase interna ExplotacionEntry para guardar el nombre de las columnas de la tabla.
Se implementó la interfaz BaseColumns con el fin de agregar una columna extra que se recomienda tenga toda tabla.
Estas declaraciones facilitan el mantenimiento del esquema, por si en algún momento cambian los nombres de las tablas o columnas.

*/