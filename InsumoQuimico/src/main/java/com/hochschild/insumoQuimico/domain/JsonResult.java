package com.hochschild.insumoQuimico.domain;

import org.json.JSONException;
import org.json.JSONObject;

public class JsonResult {
	private String jsonObject;

	public JsonResult(boolean success,String mensaje) throws JSONException{
		JSONObject respuesta = new JSONObject();
		respuesta.put("success", success);
		respuesta.put("mensaje", mensaje);
		this.jsonObject  = respuesta.toString();
	}
	public JsonResult(){

	}
	public String getJsonObject() {
		return jsonObject;
	}
	public void setJsonObject(String jsonObject) {
		this.jsonObject = jsonObject;
	}
	
}
