package com.group3.omniserve.Service;

import com.group3.omniserve.Exception.CountryAlreadyExistsException;
import com.group3.omniserve.Exception.CountryNotFoundException;
import com.group3.omniserve.model.Country;
import com.group3.omniserve.dto.CountryPostRequest;
import com.group3.omniserve.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CountryService {
    private final CountryRepository countryRepository;

    @Autowired
    public CountryService(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    // Create a new country
    public Country createCountry(CountryPostRequest countryRequest) {
        // Check if the Name is not empty
        if (countryRequest.getName() == null || countryRequest.getName().isEmpty()) {
            throw new IllegalArgumentException("Country name cannot be empty.");
        }

        // Check if a country with the same name already exists
        if (countryRepository.existsByName(countryRequest.getName())) {
            throw new CountryAlreadyExistsException("Country with the same name already exists.");
        }

        // Create a new country entity and set its attributes from the request
        Country country = new Country();
        country.setName(countryRequest.getName());

        // Save the country to the database
        return countryRepository.save(country);
    }

    // Get all countries
    public List<Country> getAllCountries() {
        return countryRepository.findAll();
    }

    // Get a specific country by ID
    public Country getCountryById(Long id) {
        Optional<Country> country = countryRepository.findById(id);
        if (country.isPresent()) {
            return country.get();
        } else {
            throw new CountryNotFoundException("Country not found with ID: " + id);
        }
    }

    // Update a country
    public Country updateCountry(Long id, CountryPostRequest updatedCountryRequest) {
        // Check if a country with the same name already exists (excluding the current country's ID)
        Country existingCountry = countryRepository.findByName(updatedCountryRequest.getName());
        if (existingCountry != null && !existingCountry.getId().equals(id)) {
            throw new CountryAlreadyExistsException("A country with this name already exists.");
        }

        Optional<Country> countryOptional = countryRepository.findById(id);
        if (countryOptional.isEmpty()) {
            throw new CountryNotFoundException("Country not found with ID: " + id);
        }

        // Update the existing country entity with data from the request
        existingCountry.setName(updatedCountryRequest.getName());

        // You can add more update logic here

        return countryRepository.save(existingCountry);
    }

    // Delete a country by ID
    public void deleteCountry(Long id) {
        if (!countryRepository.existsById(id)) {
            throw new CountryNotFoundException("Country not found with ID: " + id);
        }

        countryRepository.deleteById(id);
    }
}
