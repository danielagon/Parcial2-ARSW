/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.parcial2.restcontrollers;

import edu.eci.arsw.parcial2.services.WeatherServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author 2109734
 */
@RestController
@RequestMapping(value = "/weather")
public class WeatherAPIController {
    
    @Autowired
    private WeatherServices weather;
    
    @RequestMapping("/")
    String index() {
        return "index";
    }
    
    @RequestMapping("/favicon.ico")
    String favicon(){
        return "";
    }
    
    /**
     * Solicita los datos del clima y los retorna al servicio web.
     * @param city nombre de la ciudad
     * @return Los datos del clima de la ciudad al servicio web con el estado de http.
     */
    @RequestMapping(method = RequestMethod.GET, value = "/{city}")
    public ResponseEntity<?> getWeatherByCity(@PathVariable String city){
        try{
            return new ResponseEntity<>(weather.getWeatherByCity(city),HttpStatus.ACCEPTED);
        }catch (Exception e){
            return new ResponseEntity<>("Error al consultar el clima de la ciudad "+city, HttpStatus.NOT_FOUND);
        }
    }
    
}
