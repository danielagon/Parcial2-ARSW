/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.parcial2.services;

/**
 * Interface para poder utilizar diferentes API sin tener que cambiar lo que ya esta implementado.
 * @author 2109734
 */
public interface WeatherServices {
    String getWeatherByCity(String city);
}
