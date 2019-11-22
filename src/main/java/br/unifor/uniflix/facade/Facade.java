package br.unifor.uniflix.facade;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.Response;

import org.json.JSONArray;
import org.json.JSONObject;

import br.unifor.uniflix.adapter.FilmeAdapter;
import br.unifor.uniflix.adapter.TvShowAdapter;
import br.unifor.uniflix.factory.RequestFactory;
import br.unifor.uniflix.model.Filme;
import br.unifor.uniflix.model.TvShow;
import okhttp3.Call;

public class Facade {	
    
		public List<Filme> popularMovies() throws IOException {

        RequestFactory movieRequest = new RequestFactory();
        Call call = movieRequest.requestCreate("/movie/popular");

        okhttp3.Response response = call.execute();
        if (response.isSuccessful()) {
            JSONObject jsonResponse = new  JSONObject(response.body().string());
            JSONArray result = jsonResponse.getJSONArray("results");
            FilmeAdapter adapterFilme = new FilmeAdapter();
            List<Filme> filmes = new ArrayList<>();
            for (int i = 0; i < result.length(); ++i) {
                JSONObject movieJson = result.getJSONObject(i);
                Filme filme = adapterFilme.adapter(movieJson);
                filmes.add(filme);
            }
            return filmes;
        }
        return new ArrayList<>();
    }
	
		
		public List<TvShow> airingToday() throws IOException {
	    	
	    	RequestFactory tvRequest = new RequestFactory();
	    	Call call = tvRequest.requestCreate("/tv/airing_today");
	    	
	        okhttp3.Response response = call.execute();
	        if (response.isSuccessful()) {
	            JSONObject jsonResponse = new  JSONObject(response.body().string());
	            JSONArray result = jsonResponse.getJSONArray("results");
	            List<TvShow> programas = new ArrayList<>();
	            TvShowAdapter adapterTvShow = new TvShowAdapter();
	            for (int i = 0; i < result.length(); i++) {
	                JSONObject tvJson = result.getJSONObject(i);
	                TvShow tv = adapterTvShow.adapter(tvJson);
	                System.out.println(tv);
	                programas.add(tv);
	            }
	            return programas;
	        }
	        return new ArrayList<>();
	    }
}

