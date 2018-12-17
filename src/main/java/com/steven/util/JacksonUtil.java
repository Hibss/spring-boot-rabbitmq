package com.steven.util;


import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.PropertyNamingStrategy;
import org.codehaus.jackson.map.SerializationConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JacksonUtil {

	private static ObjectMapper mapper;

	private static ObjectMapper mapperCamel;

	private static Logger logger = LoggerFactory.getLogger(JacksonUtil.class);

	static {
		mapper = new ObjectMapper().configure(SerializationConfig.Feature.FAIL_ON_EMPTY_BEANS, false)
				.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		mapperCamel = new ObjectMapper().configure(SerializationConfig.Feature.FAIL_ON_EMPTY_BEANS, false)
				.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false)
				.setPropertyNamingStrategy(PropertyNamingStrategy.CAMEL_CASE_TO_LOWER_CASE_WITH_UNDERSCORES);
	}

	public static <T> T readObj(String json, Class<T> clazz) {

		try {

			T obj = (T) mapper.readValue(json, clazz);

			return obj;

		} catch (Exception e) {
			logger.error("json转换异常", e);
		}
		return null;
	}

	/**
	 * String2Object
	 * 
	 * @param json
	 * @param clazz
	 * @param isCamel
	 *            是否驼峰下划线转换
	 * @return
	 */
	public static <T> T readObj(String json, Class<T> clazz, boolean isCamel) {

		if (isCamel) {
			try {
				T obj = (T) mapperCamel.readValue(json, clazz);

				return obj;

			} catch (Exception e) {
				logger.error("json转换异常", e);
			}
			return null;
		} else {
			return readObj(json, clazz);
		}
	}

	/**
	 * 复杂类型转换
	 * 
	 * @param json
	 * @param collectionClass
	 *            外层集合类型
	 * @param elementClasses
	 *            元素泛型类型
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T, R> R readObj(String json, Class<T> collectionClass, Class<?>[] elementClasses) {

		try {

			R obj = (R) mapper.readValue(json,
					mapper.getTypeFactory().constructParametricType(collectionClass, elementClasses));

			return obj;

		} catch (Exception e) {
			logger.error("json转换异常", e);
		}
		return null;
	}

	/**
	 * 复杂类型转换
	 * 
	 * @param json
	 * @param collectionClass
	 *            外层集合类型
	 * @param elementClasses
	 *            元素泛型类型
	 * @param isCamel
	 *            是否驼峰下划线转换
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T, R> R readObj(String json, Class<T> collectionClass, Class<?>[] elementClasses, boolean isCamel) {

		if (isCamel) {
			try {
				R obj = (R) mapperCamel.readValue(json,
						mapperCamel.getTypeFactory().constructParametricType(collectionClass, elementClasses));
				return obj;

			} catch (Exception e) {
				logger.error("json转换异常", e);
			}
			return null;
		} else {
			return readObj(json, collectionClass, elementClasses);
		}
	}

	public static String toJSONString(Object object) {
		try {
			return mapper.writeValueAsString(object);
		} catch (Exception e) {
			logger.error("json转换异常", e);
		}
		return "{}";
	}

	/**
	 * Object2String
	 * 
	 * @param object
	 * @param isCamel
	 *            是否驼峰下划线转换
	 * @return
	 */
	public static String toJSONString(Object object, boolean isCamel) {

		if (isCamel) {
			try {
				return mapperCamel.writeValueAsString(object);
			} catch (Exception e) {
				logger.error("json转换异常", e);
			}
			return "{}";
		} else {
			return toJSONString(object);
		}

	}
}
