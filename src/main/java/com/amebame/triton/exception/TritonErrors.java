package com.amebame.triton.exception;

import java.util.HashMap;
import java.util.Map;

/**
 * Triton error codes
 */
public enum TritonErrors {
	
	// unknown error
	unknown(10),

	// client errors
	client_error(400),
	not_found(404),
	client_timeout(408),
	json_format(415),
	body_format(416),
	not_connected(420),
	
	// server errors
	server_error(500),
	
	
	// cassandra errors
	cassandra_error(600),
	cassandra_connection_fail(601),
	cassandra_no_cluster(610),
	cassandra_no_keyspace(611),
	cassandra_no_column_family(612),
	
	cassandra_invalid_consistency(680),
	cassandra_invalid_comparator(681),
	cassandra_invalid_token_type(682),
	cassandra_invalid_datatype(683),
	cassandra_unsupported_datatype(690),
	
	// memcached errros
	memcached_not_cofigured(700),
	memcached_error(710),
	memcached_timeout(711),

	// elastic search
	elasticsearch_error(800),
	elasticsearch_no_cluster(810)
	
	;
	
	private int code;
	
	private static final Map<Integer, TritonErrors> MAP = createMap();
	
	private TritonErrors(int code) {
		this.code = code;
	}
	
	public int code() {
		return code;
	}
	
	public static final TritonErrors codeOf(int code) {
		if (MAP.containsKey(code)) {
			return MAP.get(code);
		} else {
			return unknown;
		}
	}
	
	private static final Map<Integer, TritonErrors> createMap() {
		Map<Integer, TritonErrors> map = new HashMap<>();
		for (TritonErrors error : TritonErrors.values()) {
			map.put(error.code, error);
		}
		return map;
	}
}
