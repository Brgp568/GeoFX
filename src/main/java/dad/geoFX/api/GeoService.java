package dad.geoFX.api;

import java.util.concurrent.TimeUnit;

import dad.geoFX.resources.Ipapi;
import dad.geoFX.resources.Ipify;
import okhttp3.ConnectionPool;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class GeoService {

	private IpapiSchema ipapiSchema;
	private IpifySchema ipifySchema;

	public GeoService() {
		ConnectionPool pool = new ConnectionPool(1, 5, TimeUnit.SECONDS);

		OkHttpClient client = new OkHttpClient.Builder().connectionPool(pool).build();

		Retrofit retrofitIpapi = new Retrofit.Builder().baseUrl("https://ipapi.com/")
				.addConverterFactory(GsonConverterFactory.create()).client(client).build();

		ipapiSchema = retrofitIpapi.create(IpapiSchema.class);

		Retrofit retrofitIpify = new Retrofit.Builder().baseUrl("https://api.ipify.org/")
				.addConverterFactory(GsonConverterFactory.create()).client(client).build();
		ipifySchema = retrofitIpify.create(IpifySchema.class);

	}

	public Ipify getIP() throws Exception {
		Call<Ipify> call = ipifySchema.getIPify();
		Response<Ipify> response = call.execute();
		return response.body();
	}

	public Ipapi getIPData(String ip) throws Exception {
		Call<Ipapi> call = ipapiSchema.getIPapiData(ip);
		Response<Ipapi> response = call.execute();
		return response.body();
	}

}
