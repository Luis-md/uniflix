package br.unifor.uniflix.adapter;

import org.json.JSONObject;

import br.unifor.uniflix.model.TvShow;

public class TvShowAdapter implements JsonAdapter<TvShow> {

	@Override
	public TvShow adapter(JSONObject obj) {
			TvShow tv = new TvShow();
			tv.setNome(obj.getString("name"));
			tv.setNota(obj.getDouble("vote_average"));
			tv.setResumo(obj.getString("overview"));

		return tv;
	}

	
}
