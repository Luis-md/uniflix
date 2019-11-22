package br.unifor.uniflix.adapter;

import org.json.JSONObject;

import br.unifor.uniflix.model.Filme;

public class FilmeAdapter implements JsonAdapter<Filme> {


	@Override
	public Filme adapter(JSONObject obj) {
		Filme filme = new Filme();
        filme.setTitulo(obj.getString("title"));
        filme.setSinopse(obj.getString("overview"));
        filme.setAdulto(obj.getBoolean("adult"));
        filme.setNota(obj.getDouble("vote_average"));
		return filme;
	}

}
