package com.ai.photo.controller.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;
import java.util.regex.Pattern;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PropertyUtil {
	private static final Logger LOGGER = LoggerFactory.getLogger(PropertyUtil.class);
	private static String confFileUrl;
	public static final String SYSTEM_PROPERTIES_MODE_NEVER = "0";
	public static final String SYSTEM_PROPERTIES_MODE_FALLBACK = "1";
	public static final String SYSTEM_PROPERTIES_MODE_OVERRIDE = "2";
	private static Properties prop = null;
	private static String systemPropertyMode;

	private static void init() {
		prop = new Properties();
		loadData();
	}

	private static void loadData() {
		InputStreamReader in = null;

		try {
			in = new InputStreamReader(
					Thread.currentThread().getContextClassLoader().getResourceAsStream("application.properties"),
					"UTF-8");
			prop = new Properties();
			if (in != null) {
				prop.load(in);
				systemPropertyMode = prop.getProperty("uap.system.properties.mode");
			}
			systemPropertyMode = StringUtils.isNotBlank(systemPropertyMode)
					&& Pattern.matches("[012]", systemPropertyMode) ? systemPropertyMode : "2";
		} catch (IOException var11) {
			LOGGER.error("Fail to load application.properties", var11);
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (IOException var10) {
					LOGGER.error("Fail to Close inputStream", var10);
				}
			}

		}

	}

	private static String getConfigFilePath() {
		String filePath = null;
		if (StringUtils.isBlank(filePath)) {
			filePath = System.getProperty("iuap.server.conf.url");
		}

		if (StringUtils.isBlank(filePath)) {
			filePath = System.getenv("iuap.server.conf.url");
		}

		if (StringUtils.isBlank(filePath)) {
			filePath = confFileUrl;
		}

		return filePath;
	}

	public static String getPropertyByKey(String key) {
		String value = null;
		if ("2".equals(systemPropertyMode)) {
			value = resolveSystemProperty(key);
		}

		if (StringUtils.isBlank(value)) {
			value = prop.getProperty(key);
		}

		if (StringUtils.isBlank(value) && "1".equals(systemPropertyMode)) {
			value = resolveSystemProperty(key);
		}

		return StringUtils.isBlank(value) ? "" : value;
	}

	public static String getPropertyByKey(String key, String defaultValue) {
		String value = null;
		if ("2".equals(systemPropertyMode)) {
			value = resolveSystemProperty(key);
		}

		if (StringUtils.isBlank(value)) {
			value = prop.getProperty(key);
		}

		if (StringUtils.isBlank(value) && "1".equals(systemPropertyMode)) {
			value = resolveSystemProperty(key);
		}

		return StringUtils.isBlank(value) ? defaultValue : value;
	}

	private static String resolveSystemProperty(String key) {
		try {
			String value = System.getProperty(key);
			if (StringUtils.isBlank(value)) {
				value = System.getenv(key);
			}

			return value;
		} catch (Exception var2) {
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug("Could not access system property '" + key + "': " + var2);
			}

			return null;
		}
	}

	static {
		init();
	}
}