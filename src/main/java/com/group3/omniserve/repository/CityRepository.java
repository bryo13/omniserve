
package com.group3.omniserve.repository;
import com.group3.omniserve.model.City;
import com.group3.omniserve.model.County;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {
    boolean existsByName(String name);
    City findByName(String name);
   
    @Query("SELECT CASE WHEN COUNT(c) > 0 THEN true ELSE false END FROM City c WHERE c.name = ?1 AND c.county = ?2")
    boolean existsByNameAndCounty(String name, County county);
    
    boolean existsByNameAndCountyAndIdNot(String name, County county, Long id);
    
 
    
 

 

   
}
