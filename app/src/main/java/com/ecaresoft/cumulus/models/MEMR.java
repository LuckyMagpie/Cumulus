package com.ecaresoft.cumulus.models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

/**
 * Modelo de Expediente Clinico Electronico
 * Created by erodriguez on 09/10/2015.
 */
public class MEMR {
    private String paciente;
    private List<MEvent> eventos;
    private List<MPrescription> recetas;
    private List<MAllergy> alergias;
    private List<MDiagnosis> diagnosticos;
    private List<MInterventions> intervenciones;
    private List<MHomeMed> medicamentos;
    private List<MVitalSign> signos;
    private List<MHistory> historia;

    public MEMR()  {}

    public void setPaciente(String paciente) {
        this.paciente = paciente;
    }

    public String getPaciente() {
        return paciente;
    }

    public void setAlergias(List<MAllergy> alergias) {
        this.alergias = alergias;
    }

    public List<MAllergy> getAlergias() {
        return alergias;
    }

    public void setDiagnosticos(List<MDiagnosis> diagnosticos) {
        this.diagnosticos = diagnosticos;
    }

    public List<MDiagnosis> getDiagnosticos() {
        return diagnosticos;
    }

    public void setEventos(List<MEvent> eventos) {
        this.eventos = eventos;
    }

    public List<MEvent> getEventos() {
        return eventos;
    }

    public void setHistoria(List<MHistory> historia) {
        this.historia = historia;
    }

    public List<MHistory> getHistoria() {
        return historia;
    }

    public void setIntervenciones(List<MInterventions> intervenciones) {
        this.intervenciones = intervenciones;
    }

    public List<MInterventions> getIntervenciones() {
        return intervenciones;
    }

    public void setMedicamentos(List<MHomeMed> medicamentos) {
        this.medicamentos = medicamentos;
    }

    public List<MHomeMed> getMedicamentos() {
        return medicamentos;
    }

    public void setRecetas(List<MPrescription> recetas) {
        this.recetas = recetas;
    }

    public List<MPrescription> getRecetas() {
        return recetas;
    }

    public void setSignos(List<MVitalSign> signos) {
        this.signos = signos;
    }

    public List<MVitalSign> getSignos() {
        return signos;
    }
}
