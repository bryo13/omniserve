package com.group3.omniserve.Controller;
import com.group3.omniserve.Exception.CountyAlreadyExistsException;
import com.group3.omniserve.Exception.CountyNotFoundException;
import com.group3.omniserve.Service.CountyService;
import com.group3.omniserve.model.County;
import com.group3.omniserve.dto.CountyPostRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/counties")
public class CountyController {

    @Autowired
    private CountyService countyService;

    // Create a new county
    @PostMapping
    public ResponseEntity<County> createCounty(@RequestBody CountyPostRequest countyRequest) { // Use CountyPostRequest as the request payload
        try {
            County createdCounty = countyService.createCounty(countyRequest);
            return new ResponseEntity<>(createdCounty, HttpStatus.CREATED);
        } catch (CountyAlreadyExistsException e) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }

    // Get all counties
    @GetMapping
    public ResponseEntity<List<County>> getAllCounties() {
        List<County> counties = countyService.getAllCounties();
        if (counties.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(counties, HttpStatus.OK);
    }

    // Get a specific county by ID
    @GetMapping("/{id}")
    public ResponseEntity<County> getCountyById(@PathVariable Long id) {
        try {
            County county = countyService.getCountyById(id);
            return new ResponseEntity<>(county, HttpStatus.OK);
        } catch (CountyNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    // Update a county
    @PutMapping("/{id}")
    public ResponseEntity<County> updateCounty(@PathVariable Long id, @RequestBody CountyPostRequest updatedCountyRequest) { // Use CountyPostRequest as the request payload
        try {
            County county = countyService.updateCounty(id, updatedCountyRequest);
            return new ResponseEntity<>(county, HttpStatus.OK);
        } catch (CountyNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (CountyAlreadyExistsException e) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }

    // Delete a county by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<County> deleteCounty(@PathVariable Long id) {
        try {
            countyService.deleteCounty(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (CountyNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
