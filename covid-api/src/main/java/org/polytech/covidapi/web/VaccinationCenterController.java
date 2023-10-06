package org.polytech.covidapi.web;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import org.polytech.covidapi.domain.VaccinationCenter;
import org.polytech.covidapi.service.VaccinationCenterService;

@RestController
public class VaccinationCenterController {
    @Autowired
    private VaccinationCenterService centerService;
    //Chercher dans queryparam pourcity
   // /api/centers?city=Nancy
   // /api/center/12
   // /api/centers?city=Nancy&open=true


    @GetMapping(path = "/api/center")
    public List<VaccinationCenter> get(
         @RequestParam("city") String city) {
        return centerService.findAllByCity(city);
    }

    
    @GetMapping(path = "/api/center/{id}")
    public Optional<VaccinationCenter> get(
        @PathVariable("id") Integer id) {
        return centerService.findById(id);
    }
    

    @GetMapping(path = "/api/center/")
    public List<VaccinationCenter> getAllCenter() {
        return centerService.findAll();
    }
}