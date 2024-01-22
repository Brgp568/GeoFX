package dad.geoFX.api;

import dad.geoFX.resources.Ipapi;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface IpapiSchema {
	@GET("ip_api.php")
	public Call<Ipapi> getIPapiData(@Query("ip") String ip);
}
