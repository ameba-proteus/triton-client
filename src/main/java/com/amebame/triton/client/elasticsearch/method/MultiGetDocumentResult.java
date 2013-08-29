package com.amebame.triton.client.elasticsearch.method;

import java.util.HashMap;
import java.util.Map;

public class MultiGetDocumentResult {
	
	private Map<String, GetDocumentResult> items;
	
	private Map<String, String> fails;

	public MultiGetDocumentResult() {
		items = new HashMap<>();
		fails = new HashMap<>();
	}
	
	public void addItem(GetDocumentResult result) {
		items.put(result.getId(), result);
	}
	
	public void addFail(String id, String message) {
		fails.put(id, message);
	}

	public Map<String, GetDocumentResult> getItems() {
		return items;
	}
	
	public Map<String, String> getFails() {
		return fails;
	}
}
