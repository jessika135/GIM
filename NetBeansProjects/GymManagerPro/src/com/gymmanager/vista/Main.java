package com.gymmanager.vista;

import com.gymmanager.dao.ClienteDAO;
import com.gymmanager.modelo.Cliente;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        ClienteDAO dao = new ClienteDAO();

        // ===== INSERTAR =====
        System.out.println("\n=== INSERTAR CLIENTE ===");
        Cliente c1 = new Cliente();
        c1.setNombre("Jessica");
        c1.setApellido("Manrique");
        c1.setCedula("111111111");
        c1.setTelefono("3001111111");
        c1.setEmail("jessica@gmail.com");
        c1.setTipoMembresia("Mensual");
        c1.setEstado("Activo");
        System.out.println("Insertado: " + dao.insertar(c1));

        Cliente c2 = new Cliente();
        c2.setNombre("Carlos");
        c2.setApellido("Perez");
        c2.setCedula("222222222");
        c2.setTelefono("3002222222");
        c2.setEmail("carlos@gmail.com");
        c2.setTipoMembresia("Anual");
        c2.setEstado("Activo");
        System.out.println("Insertado: " + dao.insertar(c2));

        // ===== CONSULTAR =====
        System.out.println("\n=== CONSULTAR CLIENTES ===");
        List<Cliente> lista = dao.consultarTodos();
        for (Cliente c : lista) {
            System.out.println(c.getId() + " | " + c.getNombre()
                + " | " + c.getApellido()
                + " | " + c.getTipoMembresia()
                + " | " + c.getEstado());
        }

        // ===== ACTUALIZAR =====
        System.out.println("\n=== ACTUALIZAR CLIENTE ===");
        lista = dao.consultarTodos();
        if (!lista.isEmpty()) {
            Cliente cAct = lista.get(0);
            cAct.setTipoMembresia("Trimestral");
            cAct.setEstado("Activo");
            System.out.println("Actualizado: " + dao.actualizar(cAct));
        }

        // ===== CONSULTAR DESPUÉS DE ACTUALIZAR =====
        System.out.println("\n=== CLIENTES DESPUÉS DE ACTUALIZAR ===");
        lista = dao.consultarTodos();
        for (Cliente c : lista) {
            System.out.println(c.getId() + " | " + c.getNombre()
                + " | " + c.getApellido()
                + " | " + c.getTipoMembresia()
                + " | " + c.getEstado());
        }

        // ===== ELIMINAR =====
        System.out.println("\n=== ELIMINAR CLIENTE ===");
        lista = dao.consultarTodos();
        if (!lista.isEmpty()) {
            int idElim = lista.get(lista.size()-1).getId();
            System.out.println("Eliminado ID " + idElim + ": " + dao.eliminar(idElim));
        }

        // ===== CONSULTAR FINAL =====
        System.out.println("\n=== CLIENTES FINALES ===");
        lista = dao.consultarTodos();
        for (Cliente c : lista) {
            System.out.println(c.getId() + " | " + c.getNombre()
                + " | " + c.getApellido()
                + " | " + c.getTipoMembresia()
                + " | " + c.getEstado());
        }
    }
}