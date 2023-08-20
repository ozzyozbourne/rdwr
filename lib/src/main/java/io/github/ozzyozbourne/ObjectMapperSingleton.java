package io.github.ozzyozbourne;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Singleton Object Mapper
 */
public enum ObjectMapperSingleton {

    /**
     * Init Object Mapper singleton
     */
    INSTANCE(config());

    final ObjectMapper objectMapper;

    ObjectMapperSingleton(final ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    private static ObjectMapper config(){
        return new ObjectMapper();
    }
}
