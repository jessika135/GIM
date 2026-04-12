package GymManagerSpring.repositorio;

import GymManagerSpring.modelo.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositorio para acceder a los datos de Cliente
 * Spring Data JPA genera automaticamente el CRUD
 */
@Repository
public interface ClienteRepositorio extends JpaRepository<Cliente, Integer> {
}