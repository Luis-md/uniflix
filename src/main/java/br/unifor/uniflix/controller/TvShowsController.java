package br.unifor.uniflix.controller;

import br.unifor.uniflix.adapter.TvShowAdapter;
import br.unifor.uniflix.facade.Facade;
import br.unifor.uniflix.factory.RequestFactory;
import br.unifor.uniflix.model.TvShow;
import okhttp3.Call;
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

@Path("/tvshows")
public class TvShowsController {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response airingToday() throws IOException {
    	Facade facade = new Facade();
    	List<TvShow> programas = facade.airingToday();
        return Response.ok(programas).build();
    }
}

