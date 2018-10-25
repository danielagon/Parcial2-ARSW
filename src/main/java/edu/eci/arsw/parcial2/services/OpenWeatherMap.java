/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.parcial2.services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.stereotype.Service;

/**
 * Obtiene los datos del clima con del API OpenWeatherMap
 * @author 2109734
 */
@Service
public class OpenWeatherMap implements WeatherServices{
    
    /**
     * Solicita los datos del clima de la ciudad dada al API externo
     * @param city nombre de la ciudad a consultar el clima
     * @return Todos los datos del clima en un string.
     */
    @Override
    public String getWeatherByCity(String city){
        //http://api.openweathermap.org/data/2.5/weather?q=London&appid=f70fd1eb9fb8c63c6a242766f8f90670
        String respuesta = "";
        try {
            String GET_URL = "http://api.openweathermap.org/data/2.5/weather?q="+city+"&appid=f70fd1eb9fb8c63c6a242766f8f90670";
            URL obj = new URL(GET_URL);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            con.setRequestMethod("GET");
            
            int responseCode = con.getResponseCode();
            
            if (responseCode == HttpURLConnection.HTTP_OK) { // success
                BufferedReader in = new BufferedReader(new InputStreamReader(
                        con.getInputStream()));
                String inputLine;
                StringBuffer response = new StringBuffer();
                
                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();
                
                respuesta = response.toString();
            } else {
                respuesta = "GET request not worked";
            }
        } catch (MalformedURLException ex) {
            Logger.getLogger(OpenWeatherMap.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(OpenWeatherMap.class.getName()).log(Level.SEVERE, null, ex);
        }
        return respuesta;
    }
}
