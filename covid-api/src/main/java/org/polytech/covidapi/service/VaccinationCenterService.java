package org.polytech.covidapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.polytech.covidapi.domain.VaccinationCenter;
import org.polytech.covidapi.repository.VaccinationCenterRepository;

@Service
public class VaccinationCenterService {
        @Autowired
        private VaccinationCenterRepository centerRepository;

        public List<VaccinationCenter> findAllByCity(String cityName) {
            return centerRepository.findAllByCity(cityName);
        }

        public List<VaccinationCenter> findAll() {
            return centerRepository.findAll();
        }
        
        public Optional<VaccinationCenter> findById(Integer id) {
            return  centerRepository.findById(id);
        }

}