package com.yc.music.interceptor;

import java.io.IOException;

import org.springframework.http.MediaType;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.converter.json.MappingJacksonValue;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;
/**
 * 重写AbstractJackson2HttpMessageConverter
  * @ClassName: MyMappingJackson2HttpMessageConverter
  * @Description: TODO
  * @author Comsys-panguixiang
  * @date 2016年4月21日 下午8:15:10
  *
 */
public class MyMappingJackson2HttpMessageConverter 
		extends MyAbstractJackson2HttpMessageConverter {

	private String jsonPrefix;


	/**
	 * Construct a new {@link MappingJackson2HttpMessageConverter} using default configuration
	 * provided by {@link Jackson2ObjectMapperBuilder}.
	 */
	public MyMappingJackson2HttpMessageConverter() {
		this(Jackson2ObjectMapperBuilder.json().build());
	}

	/**
	 * Construct a new {@link MappingJackson2HttpMessageConverter} with a custom {@link ObjectMapper}.
	 * You can use {@link Jackson2ObjectMapperBuilder} to build it easily.
	 * @see Jackson2ObjectMapperBuilder#json()
	 */
	public MyMappingJackson2HttpMessageConverter(ObjectMapper objectMapper) {
		super(objectMapper, MediaType.APPLICATION_JSON_UTF8,
				new MediaType("application", "*+json", DEFAULT_CHARSET));
	}

	/**
	 * Specify a custom prefix to use for this view's JSON output.
	 * Default is none.
	 * @see #setPrefixJson
	 */
	public void setJsonPrefix(String jsonPrefix) {
		this.jsonPrefix = jsonPrefix;
	}

	/**
	 * Indicate whether the JSON output by this view should be prefixed with ")]}', ". Default is false.
	 * <p>Prefixing the JSON string in this manner is used to help prevent JSON Hijacking.
	 * The prefix renders the string syntactically invalid as a script so that it cannot be hijacked.
	 * This prefix should be stripped before parsing the string as JSON.
	 * @see #setJsonPrefix
	 */
	public void setPrefixJson(boolean prefixJson) {
		this.jsonPrefix = (prefixJson ? ")]}', " : null);
	}


	@Override
	protected void writePrefix(JsonGenerator generator, Object object) throws IOException {
		if (this.jsonPrefix != null) {
			generator.writeRaw(this.jsonPrefix);
		}
		String jsonpFunction =
				(object instanceof MappingJacksonValue ? ((MappingJacksonValue) object).getJsonpFunction() : null);
		if (jsonpFunction != null) {
			generator.writeRaw("/**/");
			generator.writeRaw(jsonpFunction + "(");
		}
	}

	@Override
	protected void writeSuffix(JsonGenerator generator, Object object) throws IOException {
		String jsonpFunction =
				(object instanceof MappingJacksonValue ? ((MappingJacksonValue) object).getJsonpFunction() : null);
		if (jsonpFunction != null) {
			generator.writeRaw(");");
		}
	}

}
