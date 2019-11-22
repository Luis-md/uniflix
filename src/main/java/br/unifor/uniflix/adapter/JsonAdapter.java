package br.unifor.uniflix.adapter;

import org.json.JSONObject;

interface JsonAdapter<T> {

	T adapter(JSONObject obj);	
}
