package GymManagerSpring.modelo;

import jakarta.persistence.*;
import java.util.Date;

/**
 * Entidad Cliente para GymManagerPro
 * Mapea la tabla clientes de la base de datos
 */
@Entity
@Table(name = "clientes")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    // Nombre del cliente
    private String nombre;

    // Apellido del cliente
    private String apellido;

    // Cedula del cliente
    private String cedula;

    // Telefono del cliente
    private String telefono;

    // Email del cliente
    private String email;

    // Tipo de membresia
    @Column(name = "tipo_membresia")
    private String tipoMembresia;

    // Estado del cliente
    private String estado;

    // Fecha de inscripcion
    @Column(name = "fecha_inscripcion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaInscripcion;

    public Cliente() {}

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getApellido() { return apellido; }
    public void setApellido(String apellido) { this.apellido = apellido; }
    public String getCedula() { return cedula; }
    public void setCedula(String cedula) { this.cedula = cedula; }
    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getTipoMembresia() { return tipoMembresia; }
    public void setTipoMembresia(String tipoMembresia) { this.tipoMembresia = tipoMembresia; }
    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
    public Date getFechaInscripcion() { return fechaInscripcion; }
    public void setFechaInscripcion(Date f) { this.fechaInscripcion = f;}
}
