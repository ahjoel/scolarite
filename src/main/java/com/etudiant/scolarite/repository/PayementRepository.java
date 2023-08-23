package com.etudiant.scolarite.repository;

import com.etudiant.scolarite.model.entities.Payement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface PayementRepository extends JpaRepository<Payement, Long> {
    boolean existsByCodePayIgnoreCase(String reference);
    Optional<Payement> findPayementById(Long id);

    @Query("SELECT SUM(montantReg) AS total_mt_regle, etudiant.id\n" +
            "FROM Payement\n" +
            "WHERE etudiant.id = :etudiantId\n" +
            "GROUP BY etudiant.id")
    Long sumMontantDejaRegle(@Param("etudiantId") Long etudiantId);
}
