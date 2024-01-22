package dad.geoFX.api;

import dad.geoFX.resources.Ipify;
import retrofit2.Call;
import retrofit2.http.GET;

public interface IpifySchema {
	@GET("?format=json")
	public Call<Ipify> getIPify();
}
