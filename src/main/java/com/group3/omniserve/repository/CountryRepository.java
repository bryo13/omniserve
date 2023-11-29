
package com.group3.omniserve.repository;

import com.group3.omniserve.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;
import org.springframework.data.jpa.repository.Query;

@Repository
public interface CountryRepository extends JpaRepository<Country, Long> {
    boolean existsByName(String name);
    Country findByName(String name);

    @Query("SELECT COUNT(c) > 0 FROM Country c WHERE c.name = :name")
    boolean existsCountryByName(String name);

}
