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
    private String paciente;
    private String id;

    public MDiagnosis(){}

    public static List<MDiagnosis> getMDiagnosis(){
        List<MDiagnosis> diag = new ArrayList<>();

        MDiagnosis d = new MDiagnosis();
        d.setCodigo("L50.0");
        d.setEvento(null);
        d.setFecha("1985-01-23T06:40:06Z");
        d.setNombre("Urticaria alergica");
        diag.add(d);

        d = new MDiagnosis();
        d.setCodigo("L50.0");
        d.setEvento(null);
        d.setFecha("1985-01-23T06:40:06Z");
        d.setNombre("Dolor de garganta y en el pecho");
        diag.add(d);

        d = new MDiagnosis();
        d.setCodigo("L50.0");
        d.setEvento(null);
        d.setFecha("1985-01-23T06:40:06Z");
        d.setNombre("Litiasis de los conductos biliares con colangitis o colecistitis");
        diag.add(d);

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

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setPaciente(String paciente) {
        this.paciente = paciente;
    }

    public String getPaciente() {
        return paciente;
    }
}