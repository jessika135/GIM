package com.gymmanager.controlador;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.*;

@WebServlet(name = "ClienteServlet", urlPatterns = {"/ClienteServlet"})
public class ClienteServlet extends HttpServlet {

    private static final String URL = "jdbc:mysql://127.0.0.1:3306/gymmanager_pro?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
    private static final String USUARIO = "root";
    private static final String PASSWORD = "1234";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            listarClientes(request, response);
        } catch (ClassNotFoundException e) {
            response.getWriter().println("Error driver: " + e.getMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("accion");
        if (accion == null) accion = "";
        try {
            switch (accion) {
                case "insertar":
                    insertarCliente(request, response);
                    break;
                default:
                    listarClientes(request, response);
            }
        } catch (ClassNotFoundException e) {
            response.getWriter().println("Error driver: " + e.getMessage());
        }
    }

    private void listarClientes(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html lang='es'><head><meta charset='UTF-8'>");
        out.println("<title>Clientes - GymManagerPro</title>");
        out.println("<style>");
        out.println("body { margin:0; font-family:'Segoe UI',sans-serif;");
        out.println("background: linear-gradient(rgba(0,0,0,0.7),rgba(0,0,0,0.7)),");
        out.println("url('img/gim.jpg') no-repeat center center fixed;");
        out.println("background-size:cover; padding:20px; }");
        out.println(".container { background:white; padding:30px; border-radius:15px; max-width:900px; margin:0 auto; }");
        out.println("h1 { color:#002366; }");
        out.println("table { width:100%; border-collapse:collapse; margin-top:20px; }");
        out.println("th { background:#002366; color:white; padding:12px; }");
        out.println("td { padding:10px; border-bottom:1px solid #ddd; text-align:center; }");
        out.println("tr:hover { background:#f5f5f5; }");
        out.println(".btn { display:inline-block; padding:10px 20px; border-radius:8px;");
        out.println("text-decoration:none; font-weight:bold; margin:5px; }");
        out.println(".btn-nuevo { background:#ff8c00; color:white; }");
        out.println(".btn-volver { background:#002366; color:white; }");
        out.println("</style></head><body>");
        out.println("<div class='container'>");
        out.println("<img src='img/logo.jpg' style='width:60px; float:left; margin-right:15px;'>");
        out.println("<h1>GymManagerPro - Lista de Clientes</h1>");
        out.println("<a href='registro.jsp' class='btn btn-nuevo'>➕ Nuevo Cliente</a>");
        out.println("<a href='index.html' class='btn btn-volver'>🏠 Inicio</a>");
        out.println("<table>");
        out.println("<tr><th>ID</th><th>Nombre</th><th>Apellido</th><th>Cédula</th><th>Teléfono</th><th>Email</th><th>Plan</th><th>Estado</th></tr>");

        try {
            Connection con = DriverManager.getConnection(URL, USUARIO, PASSWORD);
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM clientes");
            while (rs.next()) {
                out.println("<tr>");
                out.println("<td>" + rs.getInt("id") + "</td>");
                out.println("<td>" + rs.getString("nombre") + "</td>");
                out.println("<td>" + rs.getString("apellido") + "</td>");
                out.println("<td>" + rs.getString("cedula") + "</td>");
                out.println("<td>" + rs.getString("telefono") + "</td>");
                out.println("<td>" + rs.getString("email") + "</td>");
                out.println("<td>" + rs.getString("tipo_membresia") + "</td>");
                out.println("<td>" + rs.getString("estado") + "</td>");
                out.println("</tr>");
            }
            con.close();
        } catch (SQLException e) {
            out.println("<tr><td colspan='8'>Error BD: " + e.getMessage() + "</td></tr>");
        }
        out.println("</table></div></body></html>");
    }

    private void insertarCliente(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");

        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String cedula = request.getParameter("cedula");
        String telefono = request.getParameter("telefono");
        String email = request.getParameter("email");
        String tipoMembresia = request.getParameter("tipoMembresia");

        try {
            Connection con = DriverManager.getConnection(URL, USUARIO, PASSWORD);
            PreparedStatement ps = con.prepareStatement(
                "INSERT INTO clientes (nombre,apellido,cedula,telefono,email,tipo_membresia,estado,fecha_inscripcion) VALUES (?,?,?,?,?,?,'Activo',NOW())");
            ps.setString(1, nombre);
            ps.setString(2, apellido);
            ps.setString(3, cedula);
            ps.setString(4, telefono);
            ps.setString(5, email);
            ps.setString(6, tipoMembresia);
            ps.executeUpdate();
            con.close();

            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.println("<!DOCTYPE html>");
            out.println("<html lang='es'><head><meta charset='UTF-8'>");
            out.println("<title>Registro Exitoso</title>");
            out.println("<style>");
            out.println("body { margin:0; font-family:'Segoe UI',sans-serif;");
            out.println("background: linear-gradient(rgba(0,0,0,0.7),rgba(0,0,0,0.7)),");
            out.println("url('img/gim.jpg') no-repeat center center fixed;");
            out.println("background-size:cover; display:flex; justify-content:center;");
            out.println("align-items:center; height:100vh; }");
            out.println(".card { background:white; padding:40px; border-radius:20px;");
            out.println("text-align:center; max-width:450px; box-shadow:0 10px 30px rgba(0,0,0,0.5); }");
            out.println(".check { font-size:70px; }");
            out.println("h1 { color:#002366; }");
            out.println(".nombre { color:#ff8c00; font-size:24px; font-weight:bold; }");
            out.println(".info { background:#f5f5f5; padding:15px; border-radius:10px; margin:20px 0; text-align:left; }");
            out.println(".btn { display:inline-block; padding:12px 25px; border-radius:8px;");
            out.println("text-decoration:none; font-weight:bold; margin:5px; }");
            out.println(".btn-inicio { background:#002366; color:white; }");
            out.println("</style></head><body>");
            out.println("<div class='card'>");
            out.println("<div class='check'>✅</div>");
            out.println("<h1>¡Registro Exitoso!</h1>");
            out.println("<p>El cliente</p>");
            out.println("<div class='nombre'>" + nombre + " " + apellido + "</div>");
            out.println("<div class='info'>");
            out.println("<p>📋 <b>Cédula:</b> " + cedula + "</p>");
            out.println("<p>📱 <b>Teléfono:</b> " + telefono + "</p>");
            out.println("<p>📧 <b>Email:</b> " + email + "</p>");
            out.println("<p>🏋️ <b>Plan:</b> " + tipoMembresia + "</p>");
            out.println("</div>");
            out.println("<p>ha sido registrado en GymManagerPro</p>");
            out.println("<a href='index.html' class='btn btn-inicio'>🏠 Volver al Inicio</a>");
            out.println("</div></body></html>");

        } catch (SQLException e) {
            response.getWriter().println("Error BD: " + e.getMessage());
        }
    }
}