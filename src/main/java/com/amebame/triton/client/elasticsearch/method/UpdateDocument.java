package com.amebame.triton.client.elasticsearch.method;

import java.util.Map;

import com.amebame.triton.client.TritonMethodData;
import com.fasterxml.jackson.databind.JsonNode;

@TritonMethodData("elasticsearch.update")
public class UpdateDocument {
	
	private String cluster;

	private String index;
	
	private String type;
	
	private String id;
	
	private JsonNode doc;
	
	private String script;
	
	private Map<String, Object> params;
	
	private JsonNode upsert;
	
	private boolean docAsUpsert = false;
	
	private String routing;
	
	private boolean refresh = false;

	public UpdateDocument() {
	}

	public String getCluster() {
		return cluster;
	}

	public void setCluster(String cluster) {
		this.cluster = cluster;
	}

	public String getIndex() {
		return index;
	}

	public void setIndex(String index) {
		this.index = index;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public boolean hasDoc() {
		return doc != null;
	}

	public JsonNode getDoc() {
		return doc;
	}
	
	public void setDoc(JsonNode doc) {
		this.doc = doc;
	}
	
	public boolean hasScript() {
		return script != null;
	}
	
	public String getScript() {
		return script;
	}
	
	public void setScript(String script) {
		this.script = script;
	}
	
	public boolean hasParams() {
		return params != null;
	}
	
	public Map<String, Object> getParams() {
		return params;
	}
	
	public void setParams(Map<String, Object> params) {
		this.params = params;
	}
	
	public JsonNode getUpsert() {
		return upsert;
	}
	
	public boolean hasUpsert() {
		return upsert != null;
	}
	
	public void setUpsert(JsonNode upsert) {
		this.upsert = upsert;
	}
	
	public boolean isDocAsUpsert() {
		return docAsUpsert;
	}
	
	public void setDocAsUpsert(boolean docAsUpsert) {
		this.docAsUpsert = docAsUpsert;
	}

	public void setRouting(String routing) {
		this.routing = routing;
	}
	
	public String getRouting() {
		return routing;
	}
	
	public boolean isRefresh() {
		return refresh;
	}
	
	public void setRefresh(boolean refresh) {
		this.refresh = refresh;
	}
	
}
