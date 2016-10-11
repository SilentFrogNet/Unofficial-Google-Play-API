package net.silentfrog.googleplayapi.api;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Ilario Dal Grande <support@silentfrog.net>
 */
public interface GooglePlayService {

	@GET("search")
	Call<ResponseBody> appList(@Query("q") String appname, @Query("c") String category);

}
