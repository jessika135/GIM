package com.gymmanager.modelo;

public class Cliente {
    private int    id;
    private String nombre;
    private String apellido;
    private String cedula;
    private String telefono;
    private String email;
    private String tipoMembresia;
    private String estado;

    public Cliente() {}

    public int    getId()                    { return id; }
    public void   setId(int id)              { this.id = id; }
    public String getNombre()                { return nombre; }
    public void   setNombre(String nombre)   { this.nombre = nombre; }
    public String getApellido()              { return apellido; }
    public void   setApellido(String a)      { this.apellido = a; }
    public String getCedula()                { return cedula; }
    public void   setCedula(String c)        { this.cedula = c; }
    public String getTelefono()              { return telefono; }
    public void   setTelefono(String t)      { this.telefono = t; }
    public String getEmail()                 { return email; }
    public void   setEmail(String e)         { this.email = e; }
    public String getTipoMembresia()         { return tipoMembresia; }
    public void   setTipoMembresia(String tm){ this.tipoMembresia = tm; }
    public String getEstado()                { return estado; }
    public void   setEstado(String e)        { this.estado = e; }
}