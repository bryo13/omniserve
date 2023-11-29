package com.group3.omniserve.Controller;

import com.group3.omniserve.Service.CountryService;
import com.group3.omniserve.Exception.CountryAlreadyExistsException;
import com.group3.omniserve.Exception.CountryNotFoundException;
import com.group3.omniserve.model.Country;
import com.group3.omniserve.dto.CountryPostRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/countries")
public class CountryController {

    @Autowired
    private CountryService countryService;

    // Create a new country
    @PostMapping
    public ResponseEntity<Country> createCountry(@RequestBody CountryPostRequest countryRequest) {
        try {
            Country createdCountry = countryService.createCountry(countryRequest);
            return new ResponseEntity<>(createdCountry, HttpStatus.CREATED);
        } catch (CountryAlreadyExistsException e) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }

    // Get all countries
    @GetMapping
    public ResponseEntity<List<Country>> getAllCountries() {
        List<Country> countries = countryService.getAllCountries();
        if (countries.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(countries, HttpStatus.OK);
    }

    // Get a specific country by ID
    @GetMapping("/{id}")
    public ResponseEntity<Country> getCountryById(@PathVariable Long id) {
        try {
            Country country = countryService.getCountryById(id);
            return new ResponseEntity<>(country, HttpStatus.OK);
        } catch (CountryNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Update a country
    @PutMapping("/{id}")
    public ResponseEntity<Country> updateCountry(@PathVariable Long id, @RequestBody CountryPostRequest updatedCountryRequest) {
        try {
            Country country = countryService.updateCountry(id, updatedCountryRequest);
            return new ResponseEntity<>(country, HttpStatus.OK);
        } catch (CountryNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (CountryAlreadyExistsException e) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }

    // Delete a country by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Country> deleteCountry(@PathVariable Long id) {
        try {
            countryService.deleteCountry(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (CountryNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
