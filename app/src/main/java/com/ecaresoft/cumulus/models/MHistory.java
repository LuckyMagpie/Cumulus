package com.ecaresoft.cumulus.models;

/**
 * Created by erodriguez on 09/10/2015.
 */
public class MHistory {
    private String clinica;
    private String personal;
    private String familiar;

    public MHistory(){}

    public void setClinica(String clinica) {
        this.clinica = clinica;
    }

    public void setFamiliar(String familiar) {
        this.familiar = familiar;
    }

    public void setPersonal(String personal) {
        this.personal = personal;
    }

    public String getClinica() {
        return clinica;
    }

    public String getFamiliar() {
        return familiar;
    }

    public String getPersonal() {
        return personal;
    }
}