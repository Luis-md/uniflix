package br.unifor.uniflix.controller;

import br.unifor.uniflix.adapter.FilmeAdapter;
import br.unifor.uniflix.facade.Facade;
import br.unifor.uniflix.factory.RequestFactory;
import br.unifor.uniflix.model.Filme;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Path("/filmes")
public class FilmesController {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response popularMovies() throws IOException {
    	Facade facade = new Facade();
    	List<Filme> filmes = facade.popularMovies(); 
    	return Response.ok(filmes).build();
    }
}
