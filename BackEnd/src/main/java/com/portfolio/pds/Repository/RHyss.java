package com.portfolio.pds.Repository;

import com.portfolio.pds.Entity.Hyss;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RHyss extends JpaRepository<Hyss, Integer>{
    public Optional<Hyss> findByNombreH(String nombreH);
    public boolean existsByNombreH(String nombreH);
}
