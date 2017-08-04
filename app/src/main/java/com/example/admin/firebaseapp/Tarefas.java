package com.example.admin.firebaseapp;


public class Tarefas {
    public String getIdTarefa() {
        return idTarefa;
    }



    private String idTarefa;
    private String assunto;
    private String data;
    private String descricao;
    private String curso;
    private String materia;

    public Tarefas() {
    }

    public Tarefas(String idTarefa,String assunto, String data, String descricao, String curso, String materia) {
        this.idTarefa=idTarefa;
        this.assunto = assunto;
        this.data = data;
        this.descricao = descricao;
        this.curso = curso;
        this.materia = materia;
    }

    public void setIdTarefa(String idTarefa) {
        this.idTarefa = idTarefa;
    }

    public String getAssunto() {
        return assunto;
    }

    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }
}
