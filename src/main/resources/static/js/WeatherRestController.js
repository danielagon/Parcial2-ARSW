/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var RestControllerModule = (function (){
    
    var getWeather = function (id, callback){
        axios.get('/weather/'+id)
            .then(function (response){
                callback.onSuccess(response.data);
            })
            .catch(function (error){
                callback.onFailed(error);
            })
    };
    
    return {
        getWeather: getWeather
    };
})();
