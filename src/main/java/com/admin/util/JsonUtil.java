package com.admin.util;

import org.springframework.util.StringUtils;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

@SuppressWarnings("deprecation")
public class JsonUtil {

	private static ObjectMapper instance;

	private JsonUtil() {
	}

	public static ObjectMapper getInstance() {
		if (instance == null) {
			synchronized (ObjectMapper.class) {
				if (instance == null) {
					instance = new ObjectMapper().disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
					instance.setSerializationInclusion(Include.NON_NULL);
					// 序列化BigDecimal时是输出原始数字还是科学计数，默认false，即以toPlainString()科学计数方式来输出
					instance.configure(SerializationFeature.WRITE_BIGDECIMAL_AS_PLAIN, true);
				}
			}
		}
		return instance;
	}

	/**
	 * Json 反序列化
	 * 
	 * @param json
	 * @param t
	 * @return
	 */
	public static <T> T jsonToObject(String json, Class<T> t) {
		if (StringUtils.isEmpty(json)) {
			return null;
		}
		try {
			getInstance();
			return instance.readValue(json, t);
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * Json 序列化
	 * 
	 * @param obj
	 * @return
	 */
	public static String objectToJson(Object obj) {
		if (obj == null) {
			return null;
		}
		try {
			getInstance();
			return instance.writeValueAsString(obj);
		} catch (Exception e) {
			return null;
		}
	}

	public static String objectToStringPretty(Object obj) {
		if (obj == null) {
			return null;
		}
		try {
			getInstance();
			return instance.writerWithDefaultPrettyPrinter().writeValueAsString(obj);
		} catch (Exception e) {
			return null;
		}
	}

}
