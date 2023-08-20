package io.github.ozzyozbourne;

import com.fasterxml.jackson.dataformat.toml.TomlMapper;

enum TomlMapperSingleton {

    INSTANCE(config());

    final TomlMapper tomlMapper;

    TomlMapperSingleton(final TomlMapper tomlMapper) {
        this.tomlMapper = tomlMapper;
    }

    private static TomlMapper config(){
        return new TomlMapper();
    }
}
