package com.amebame.triton.json;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufInputStream;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.UUID;

import com.amebame.triton.exception.TritonJsonException;
import com.fasterxml.jackson.core.JsonParser.Feature;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.deser.std.ClassDeserializer;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.BooleanNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.NumericNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.TextNode;
import com.fasterxml.jackson.databind.ser.std.StdJdkSerializers.ClassSerializer;

public class Json {
	
	private static final ObjectMapper MAPPER = createMapper();
	
	/**
	 * Create common {@link ObjectMapper}
	 * @return
	 */
	private static ObjectMapper createMapper() {
		ObjectMapper mapper = new ObjectMapper();
		// set feature
		// write date as ISO8601 string
		mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
		// ignore unknown properties
		mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
		// accept comments in JSON
		mapper.configure(Feature.ALLOW_COMMENTS, true);
		// set serializer/deserializer
		SimpleModule module = new SimpleModule("triton-json")
		// UUID serializer/deserializer
		.addSerializer(new UUIDSerializer())
		.addDeserializer(UUID.class, new UUIDDeserializer())
		.addSerializer(new ClassSerializer())
		.addDeserializer(Class.class, new ClassDeserializer())
		;
		mapper.registerModule(module);
		return mapper;
	}
	
	/**
	 * Get common {@link ObjectMapper}
	 * @return
	 */
	public static final ObjectMapper mapper() {
		return MAPPER;
	}
	
	public static final <E> E read(InputStream input, Class<E> clazz) {
		try {
			return MAPPER.readValue(input, clazz);
		} catch (IOException e) {
			throw new TritonJsonException(e.getMessage(), e);
		}
	}
	
	/**
	 * Get the json tree represents the target object
	 * @param target
	 * @return
	 */
	public static final JsonNode tree(Object target) {
		return MAPPER.valueToTree(target);
	}
	
	public static final JsonNode tree(String source) {
		try {
			return MAPPER.readTree(source);
		} catch (IOException e) {
			throw new TritonJsonException(e.getMessage(), e);
		}
	}
	
	public static final JsonNode tree(byte[] bytes) {
		try {
			return MAPPER.readTree(bytes);
		} catch (IOException e) {
			throw new TritonJsonException(e.getMessage(), e);
		}
	}
	
	/**
	 * Get the json tree from channel buffer
	 * @param buffer
	 * @return
	 */
	public static final JsonNode tree(ByteBuf buffer) {
		try {
			return MAPPER.readTree(new ByteBufInputStream(buffer));
		} catch (IOException e) {
			throw new TritonJsonException(e.getMessage(), e);
		}
	}
	
	/**
	 * Convert object to {@link ByteBuffer}.
	 * @param target
	 * @return
	 */
	public static final ByteBuffer buffer(Object target) {
		return ByteBuffer.wrap(bytes(target));
	}
	
	/**
	 * Convert object to json bytes.
	 * @param target
	 * @return
	 */
	public static final byte[] bytes(Object target) {
		try {
			return MAPPER.writeValueAsBytes(target);
		} catch (JsonProcessingException e) {
			throw new TritonJsonException(e);
		}
	}
	
	/**
	 * Convert object to json text.
	 * @param target
	 * @return
	 */
	public static final String stringify(Object target) {
		try {
			return MAPPER.writeValueAsString(target);
		} catch (JsonProcessingException e) {
			throw new TritonJsonException(e);
		}
	}
	
	/**
	 * Convert {@link JsonNode} to specific object instance
	 * @param node
	 * @param clazz
	 * @return
	 */
	public static final <E> E convert(JsonNode node, Class<E> clazz) {
		try {
			return MAPPER.treeToValue(node, clazz);
		} catch (JsonProcessingException e) {
			throw new TritonJsonException(e);
		}
	}
	
	/**
	 * Convert node to list of specific type.
	 * @param node
	 * @param elementClass
	 * @return
	 */
	public static final <E> List<E> convertAsList(JsonNode node, Class<E> elementClass) {
		return MAPPER.convertValue(
				node,
				MAPPER.getTypeFactory().constructCollectionType(List.class, elementClass)
		);
	}
	
	/**
	 * Convert {@link ChannelBuffer} to specific object instance as JSON buffer.
	 * @param buffer
	 * @param clazz
	 * @return
	 */
	public static final <E> E convert(ByteBuf buffer, Class<E> clazz) {
		try {
			return MAPPER.readValue(new ByteBufInputStream(buffer), clazz);
		} catch (IOException e) {
			throw new TritonJsonException(e);
		}
	}
	
	/**
	 * Create an empty object node
	 * @return
	 */
	public static final ObjectNode object() {
		return JsonNodeFactory.instance.objectNode();
	}
	
	/**
	 * Create an empty array node
	 * @return
	 */
	public static final ArrayNode array() {
		return JsonNodeFactory.instance.arrayNode();
	}
	
	/**
	 * Create an text node
	 * @param text
	 * @return
	 */
	public static final TextNode text(String text) {
		return JsonNodeFactory.instance.textNode(text);
	}
	
	/**
	 * Create a numeric node
	 * @param number
	 * @return
	 */
	public static final NumericNode number(int value) {
		return JsonNodeFactory.instance.numberNode(value);
	}
	
	/**
	 * Create a numeric node
	 * @param value
	 * @return
	 */
	public static final NumericNode number(long value) {
		return JsonNodeFactory.instance.numberNode(value);
	}
	
	/**
	 * Create a numeric node
	 * @param value
	 * @return
	 */
	public static final NumericNode number(float value) {
		return JsonNodeFactory.instance.numberNode(value);
	}
	
	/**
	 * Create a numeric node
	 * @param value
	 * @return
	 */
	public static final NumericNode number(double value) {
		return JsonNodeFactory.instance.numberNode(value);
	}
	
	/**
	 * Create a numeric node
	 * @param value
	 * @return
	 */
	public static final NumericNode number(BigDecimal value) {
		return JsonNodeFactory.instance.numberNode(value);
	}
	
	/**
	 * Create a numeric node
	 * @param value
	 * @return
	 */
	public static final NumericNode number(BigInteger value) {
		return JsonNodeFactory.instance.numberNode(value);
	}
	
	/**
	 * Create a boolean node
	 * @param bool
	 * @return
	 */
	public static final BooleanNode bool(boolean bool) {
		return JsonNodeFactory.instance.booleanNode(bool);
	}

}

