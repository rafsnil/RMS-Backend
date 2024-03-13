package com.github.rafsnil.rms.service.utilities;

import com.github.rafsnil.rms.configuration.ApplicationConstants;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Map;
import java.util.Properties;
import java.util.logging.Logger;

public class CommonUtils {
    private static final Logger logger = Logger.getLogger(CommonUtils.class.getName());

    public static String getMessage(String key) {
        try {
            Resource resource = new ClassPathResource(ApplicationConstants.MessagePropertiesFilePath);
            Properties props = PropertiesLoaderUtils.loadProperties(resource);
            return props.getProperty(key);
        } catch (Exception exception) {
            logger.warning(exception.getMessage());
        }
        return "read message exception occur";
    }

    public static ResponseEntity<?> sendResponse(HttpStatus httpStatus, String message, Object data) {
        return ResponseEntity.status(httpStatus).body(Map.of("status", httpStatus.value(), "message", message, "data", data));
    }
}
