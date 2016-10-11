package net.silentfrog.googleplayapi.utils.retrofit;

import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

/**
 * Created by Ilario Dal Grande <support@silentfrog.net>
 */
public class ServiceGenerator {

	public static final String TAG = "ServiceGenerator";

	// No need to instantiate this class.
	private ServiceGenerator() {}

	public static <S> S createService(Class<S> serviceClass, String base_url) {
		OkHttpClient httpClient = new OkHttpClient.Builder().build();

		Retrofit.Builder builder = new Retrofit.Builder()
				.baseUrl(base_url)
				.client(httpClient);

		return builder.build().create(serviceClass);
	}

	public static <S> S createService(Class<S> serviceClass, HttpUrl url) {
		OkHttpClient httpClient = new OkHttpClient.Builder().build();

		Retrofit.Builder builder = new Retrofit.Builder()
				.baseUrl(url)
				.client(httpClient);

		return builder.build().create(serviceClass);
	}

}