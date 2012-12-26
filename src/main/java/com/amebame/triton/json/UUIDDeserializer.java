package com.amebame.triton.json;

import java.io.IOException;
import java.util.UUID;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdScalarDeserializer;

public class UUIDDeserializer extends StdScalarDeserializer<UUID> {

	private static final long serialVersionUID = -6186423319849754786L;

	public UUIDDeserializer() {
		super(UUID.class);
	}

	@Override
	public UUID deserialize(JsonParser jp, DeserializationContext ctxt)
			throws IOException, JsonProcessingException {
		String text = jp.getValueAsString();
		if (text == null) {
			return null;
		}
		return UUID.fromString(text);
	}

}
