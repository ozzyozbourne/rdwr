package io.github.ozzyozbourne;

import com.fasterxml.jackson.dataformat.toml.TomlMapper;

/**
 * Singleton toml mapper
 */
public enum TomlMapperSingleton {

    INSTANCE(config());

    final TomlMapper tomlMapper;

    TomlMapperSingleton(final TomlMapper tomlMapper) {
        this.tomlMapper = tomlMapper;
    }

    private static TomlMapper config(){
        return new TomlMapper();
    }
}
