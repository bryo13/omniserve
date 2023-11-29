package com.group3.omniserve.Controller;

import com.group3.omniserve.Exception.CityAlreadyExistsException;
import com.group3.omniserve.Exception.CityNotFoundException;
import com.group3.omniserve.Service.CityService;
import com.group3.omniserve.model.City;
import com.group3.omniserve.dto.CityPostRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cities")
public class CityController {
    private final CityService cityService;

    @Autowired
    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    // Create a new city
    @PostMapping
    public ResponseEntity<City> createCity(@RequestBody CityPostRequest cityRequest) {
        try {
            City createdCity = cityService.createCity(cityRequest);
            return new ResponseEntity<>(createdCity, HttpStatus.CREATED);
        } catch (CityAlreadyExistsException e) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }

    // Get all cities
    @GetMapping
    public ResponseEntity<List<City>> getAllCities() {
        List<City> cities = cityService.getAllCities();
        if (cities.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(cities, HttpStatus.OK);
    }

    // Get a specific city by ID
    @GetMapping("/{id}")
    public ResponseEntity<City> getCityById(@PathVariable Long id) {
        try {
            City city = cityService.getCityById(id);
            return new ResponseEntity<>(city, HttpStatus.OK);
        } catch (CityNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Update a city
    @PutMapping("/{id}")
    public ResponseEntity<City> updateCity(@PathVariable Long id, @RequestBody CityPostRequest cityRequest) {
        try {
            City updatedCity = cityService.updateCity(id, cityRequest);
            return new ResponseEntity<>(updatedCity, HttpStatus.OK);
        } catch (CityNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (CityAlreadyExistsException e) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }

    // Delete a city by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCity(@PathVariable Long id) {
        try {
            cityService.deleteCity(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (CityNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

   

  
}
