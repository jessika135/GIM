package com.gymmanager.dao;

import com.gymmanager.conexion.ConexionDB;
import com.gymmanager.modelo.Cliente;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {

    // INSERTAR
    public boolean insertar(Cliente c) {
        String sql = "INSERT INTO clientes (nombre, apellido, cedula, telefono, email, tipoMembresia, estado) VALUES (?,?,?,?,?,?,?)";
        try (Connection con = ConexionDB.obtenerConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, c.getNombre());
            ps.setString(2, c.getApellido());
            ps.setString(3, c.getCedula());
            ps.setString(4, c.getTelefono());
            ps.setString(5, c.getEmail());
            ps.setString(6, c.getTipoMembresia());
            ps.setString(7, c.getEstado());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error al insertar: " + e.getMessage());
            return false;
        }
    }

    // CONSULTAR TODOS
    public List<Cliente> consultarTodos() {
        List<Cliente> lista = new ArrayList<>();
        String sql = "SELECT * FROM clientes";
        try (Connection con = ConexionDB.obtenerConexion();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                Cliente c = new Cliente();
                c.setId(rs.getInt("id"));
                c.setNombre(rs.getString("nombre"));
                c.setApellido(rs.getString("apellido"));
                c.setCedula(rs.getString("cedula"));
                c.setTelefono(rs.getString("telefono"));
                c.setEmail(rs.getString("email"));
                c.setTipoMembresia(rs.getString("tipoMembresia"));
                c.setEstado(rs.getString("estado"));
                lista.add(c);
            }
        } catch (SQLException e) {
            System.out.println("Error al consultar: " + e.getMessage());
        }
        return lista;
    }

    // ACTUALIZAR
    public boolean actualizar(Cliente c) {
        String sql = "UPDATE clientes SET tipoMembresia=?, estado=?, nombre=?, apellido=? WHERE id=?";
        try (Connection con = ConexionDB.obtenerConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, c.getTipoMembresia());
            ps.setString(2, c.getEstado());
            ps.setString(3, c.getNombre());
            ps.setString(4, c.getApellido());
            ps.setInt(5, c.getId());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error al actualizar: " + e.getMessage());
            return false;
        }
    }

    // ELIMINAR
    public boolean eliminar(int id) {
        String sql = "DELETE FROM clientes WHERE id=?";
        try (Connection con = ConexionDB.obtenerConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error al eliminar: " + e.getMessage());
            return false;
        }
    }
}