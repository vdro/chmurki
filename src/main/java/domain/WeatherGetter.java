package domain;

import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


public class WeatherGetter {
	public static final String URL = "http://api.openweathermap.org/data/2.5/weather?appid=c5f73f8449efda69fa2258f91eb7512f&lang=pl&units=metric&q=";
	
	public WeatherEntry getWeather(String city){
		Client client = ClientBuilder.newClient();
	    WebTarget target = client.target(URL+city);
	    Response response = target.request(MediaType.APPLICATION_JSON_TYPE)
	            .get();
	    
	    if(response.getStatus()==200)
			return response.readEntity(WeatherEntry.class);

		return null;
	}
}
