package com.ecaresoft.cumulus.models;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by erodriguez on 09/10/2015.
 */
public class MDiagnosis {
    private String evento;
    private String fecha;
    private String codigo;
    private String nombre;

    public MDiagnosis(){}

    public static List<MDiagnosis> getMDiagnosis(){
        List<MDiagnosis> diag = new ArrayList<>();
        for(int i = 0; i < 5; i++){
            MDiagnosis d = new MDiagnosis();
            d.setCodigo("codigo"+i);
            d.setEvento("event"+i);
            d.setFecha("0"+i+"/09/2015");
            d.setNombre("Cirujia No."+i);
            diag.add(d);
        }
        return diag;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getFecha() {
        return fecha;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setEvento(String evento) {
        this.evento = evento;
    }

    public String getEvento() {
        return evento;
    }
}