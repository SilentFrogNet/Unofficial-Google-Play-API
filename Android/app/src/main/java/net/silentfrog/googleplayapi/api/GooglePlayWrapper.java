package net.silentfrog.googleplayapi.api;

import android.util.Log;

import net.silentfrog.googleplayapi.GooglePlayElement;
import net.silentfrog.googleplayapi.utils.retrofit.ServiceGenerator;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;

/**
 * Created by Ilario Dal Grande <support@silentfrog.net>
 */
public class GooglePlayWrapper {

	public static final String TAG = "GooglePlayWrapper";
	public static final String BASE_URL = "https://play.google.com/store/";

	private GooglePlayService mService;

	public GooglePlayWrapper() {
		mService = ServiceGenerator.createService(GooglePlayService.class, BASE_URL);

		Log.d(TAG, "Google Play Service: " + mService.toString());
	}

	public List<GooglePlayElement> searchMagazine(String appname) throws IOException {
		return search(appname, "magazines");
	}
	public List<GooglePlayElement> searchBook(String appname) throws IOException {
		return search(appname, "books");
	}
	public List<GooglePlayElement> searchMusic(String appname) throws IOException {
		return search(appname, "music");
	}
	public List<GooglePlayElement> searchMovie(String appname) throws IOException {
		return search(appname, "movies");
	}
	public List<GooglePlayElement> searchApp(String appname) throws IOException {
		return search(appname, "apps");
	}
	public List<GooglePlayElement> search(String appname) throws IOException {
		return search(appname, null);
	}
	public List<GooglePlayElement> search(String appname, String category) throws IOException {
		Call<ResponseBody> callRequest = mService.appList(appname, category);
		Response<ResponseBody> reqBody = callRequest.execute();

		if (reqBody == null) {
			Log.d(TAG, "response body is null");
			return null;
		}

		int code = reqBody.code();

		Log.d(TAG, "returned code: " + code + " [" + reqBody.message() + "]");
		if (code == 200) {
			Log.d(TAG, "analysisRequest body: " + reqBody.toString());
		}
		else {
			Log.d(TAG, "errorbody: " + reqBody.errorBody());
			return null;
		}

		return parseAppList(reqBody.body().string());
	}

	private List<GooglePlayElement> parseAppList(String httpBody) {
		List<GooglePlayElement> result = new LinkedList<>();

		Document doc = Jsoup.parse(httpBody);

		Elements cards = doc.select(".card");
		for (Element card : cards) {
			String elementPackage = card.attr("data-docid");
			Element target = card.select(".cover a.card-click-target").get(0);
			String elementDetailsUrl = target.attr("href");
			String elementName = target.attr("aria-label").trim();
			String elementImgUrl = card.select("img.cover-image").get(0).attr("src");
			String elementAuthor = card.select("a.subtitle").get(0).attr("title");

			GooglePlayElement element = new GooglePlayElement.Builder()
					.elementName(elementName)
					.elementAuthor(elementAuthor)
					.elementPackage(elementPackage)
					.elementDetailsUrl(elementDetailsUrl)
					.elementImgageUrl(elementImgUrl)
					.build();

			result.add(element);
		}

		return result;
	}

}
