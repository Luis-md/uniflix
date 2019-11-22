package br.unifor.uniflix.factory;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;

public class RequestFactory {
	
	public Call requestCreate(String path) {
		OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("https://api.themoviedb.org/3" + path + "?api_key=e6a0bb4b36db22f170511e1bd3b86e5a")
                .build();
		
		return client.newCall(request);
	}
}
