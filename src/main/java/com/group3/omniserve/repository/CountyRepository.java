package com.group3.omniserve.repository;
import com.group3.omniserve.model.Country;
import com.group3.omniserve.model.County;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;
import org.springframework.data.jpa.repository.Query;

@Repository
public interface CountyRepository extends JpaRepository<County, Long> {
   boolean existsByName(String name);
    County findByName(String name);
 
    boolean existsByNameAndCountry(String name, Country country);
    @Query("SELECT COUNT(c) > 0 FROM County c WHERE c.name = :name")
    boolean existsCountryByName(String name);   
}
