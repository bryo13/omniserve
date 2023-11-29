package com.group3.omniserve.Service;

import com.group3.omniserve.Exception.CityAlreadyExistsException;
import com.group3.omniserve.Exception.CityNotFoundException;
import com.group3.omniserve.model.City;
import com.group3.omniserve.dto.CityPostRequest;
import com.group3.omniserve.repository.CityRepository;
import com.group3.omniserve.repository.CountyRepository;
import com.group3.omniserve.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityService {
    private final CityRepository cityRepository;
    private final CountyRepository countyRepository;
    private final CountryRepository countryRepository;

    @Autowired
    public CityService(
        CityRepository cityRepository,
        CountyRepository countyRepository,
        CountryRepository countryRepository
    ) {
        this.cityRepository = cityRepository;
        this.countyRepository = countyRepository;
        this.countryRepository = countryRepository;
    }

    public City createCity(CityPostRequest cityRequest) {
        // Check if a city with the same name already exists in the same county
        if (cityRepository.existsByNameAndCounty(cityRequest.getName(), cityRequest.getCounty())) {
            throw new CityAlreadyExistsException("A city with the same name already exists in this county.");
        }

        // Check if the County exists
        countyRepository.findById(cityRequest.getCounty().getId())
            .orElseThrow(() -> new IllegalArgumentException("County with the given ID does not exist."));

        // Check if the User (created by) exists
        // You may need to implement this check if there's a createdBy field in CityPostRequest.

        // Create a new City entity and set its attributes from the request
        City city = new City();
        city.setName(cityRequest.getName());
        city.setCounty(cityRequest.getCounty());
        // Set the createdBy field as well if it's part of your City entity.

        // Save the city to the database
        return cityRepository.save(city);
    }

    public List<City> getAllCities() {
        return cityRepository.findAll();
    }

    public City getCityById(Long id) {
        return cityRepository.findById(id)
            .orElseThrow(() -> new CityNotFoundException("City not found with ID: " + id));
    }

    public City updateCity(Long id, CityPostRequest updatedCityRequest) {
        // Check if a city with the same name already exists in the same county (excluding the current city)
        if (cityRepository.existsByNameAndCountyAndIdNot(updatedCityRequest.getName(), updatedCityRequest.getCounty(), id)) {
            throw new CityAlreadyExistsException("A city with the same name already exists in this county.");
        }

        City existingCity = cityRepository.findById(id)
            .orElseThrow(() -> new CityNotFoundException("City not found with ID: " + id));

        // Update the existing city entity with data from the request
        existingCity.setName(updatedCityRequest.getName());
        // Update other fields as needed.

        // Save the updated city to the database
        return cityRepository.save(existingCity);
    }

    public void deleteCity(Long id) {
        if (!cityRepository.existsById(id)) {
            throw new CityNotFoundException("City not found with ID: " + id);
        }

        cityRepository.deleteById(id);
    }

   
   
}
