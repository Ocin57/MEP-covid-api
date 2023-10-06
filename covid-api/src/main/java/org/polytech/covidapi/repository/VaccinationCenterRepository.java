package org.polytech.covidapi.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import org.polytech.covidapi.domain.VaccinationCenter;
@Repository
public interface VaccinationCenterRepository extends JpaRepository<VaccinationCenter, Integer> {
    public List<VaccinationCenter> findAllByCity(String city);
    public List<VaccinationCenter> findAll();
    public Optional<VaccinationCenter> findById(Integer id);
    
}