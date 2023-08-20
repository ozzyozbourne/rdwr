package io.github.ozzyozbourne;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.toml.TomlFactory;

/**
 * Singleton Toml Object Mapper
 */
public enum MapperTmlSingleton {

    /**
     * Init Toml Mapper singleton
     */
    INSTANCE(config());

    final ObjectMapper objectMapper;

    MapperTmlSingleton(final ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    private static ObjectMapper config(){
        return new ObjectMapper(new TomlFactory()).findAndRegisterModules()
                .disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
    }
}
