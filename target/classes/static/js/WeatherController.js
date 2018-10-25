/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var WeatherControllerModule = (function (){
    
    
    var getWeather = function(id){
        
        var callback = {
            onSuccess: function(response){
                var property = Object.keys(response);
                
                $('#data').empty();
                $('#data').append("<h5>Informacion del clima</h5>");
                $('#data').append("<p class='table-sm table-dark'>Coordenadas: Longitud:"+response[property[0]]['lon']+", Latitud: "+response[property[0]]['lat']+" <br> Clima: "+response[property[1]][0]['description']+" <br> Temperatura: "+response[property[3]]['temp']+" <br> Humedad: "+response[property[3]]['humidity']+" <br> Temperatura mínima: "+response[property[3]]['temp_min']+" <br> Temperatura máxima: "+response[property[3]]['temp_max']+"</p>");
                //$('#tableConsult').append("<tr> <th class='col'>Date</th> <th class='col'>Open</th> <th class='col'>High</th> <th class='col'>Low</th> <th class='col'>Close</th> <th class='col'>Volume</th> </tr> </thead>");
                //for (i in response[property[1]]){
                   // $('#tableConsult').append("<tbody> <tr> <td> <a>"+i+"</a> </td> <td> <a>"+response[property[1]][i]['1. open']+"</a> </td> <td> <a>"+response[property[1]][i]['2. high']+"</a> </td> <td> <a>"+response[property[1]][i]['3. low']+"</a> </td> <td> <a>"+response[property[1]][i]['4. close']+"</a> </td> <td> <a>"+response[property[1]][i]['5. volume']+"</a> </td> </tr> </tbody>");
                //}
            },
            onFailed: function(exception){
                console.log(exception);
                alert("There is a problem with our servers.");
            }
        };
        RestControllerModule.getWeather(id,callback);
    };
    
    return {
        getWeather: getWeather
    };
})();    