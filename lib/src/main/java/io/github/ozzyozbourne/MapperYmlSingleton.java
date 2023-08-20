package io.github.ozzyozbourne;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.fasterxml.jackson.dataformat.yaml.YAMLGenerator;

/**
 * Singleton Yaml Mapper
 */
public enum MapperYmlSingleton {

    /**
     * Init Yaml mapper singleton
     */
    INSTANCE(config());

    final ObjectMapper objectMapper;

    MapperYmlSingleton(final ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    private static ObjectMapper config(){
        return new ObjectMapper(new YAMLFactory()
                .disable(YAMLGenerator.Feature.WRITE_DOC_START_MARKER))
                .findAndRegisterModules()
                .disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
    }
}
