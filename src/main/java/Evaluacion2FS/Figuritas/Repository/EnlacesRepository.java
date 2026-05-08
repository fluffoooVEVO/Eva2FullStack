package Evaluacion2FS.Figuritas.Repository;

import Evaluacion2FS.Figuritas.Model.Enlaces;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

// interfaz que hereda anejar las operaciones en la tabla intermedia Enlaces
@Repository
public interface EnlacesRepository extends JpaRepository<Enlaces, Integer> {

    @Query("SELECT e FROM Enlaces e JOIN FETCH e.enlace JOIN FETCH e.producto")
    List<Enlaces> findAllWithRelations();
}