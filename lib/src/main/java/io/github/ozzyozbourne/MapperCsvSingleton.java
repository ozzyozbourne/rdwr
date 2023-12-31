package io.github.ozzyozbourne;

import com.fasterxml.jackson.dataformat.csv.CsvMapper;

/**
 * Singleton CSV Mapper
 */
public enum MapperCsvSingleton {

    /**
     * Init CSV mapper singleton
     */
    INSTANCE(config());

    final CsvMapper csvMapper;

    MapperCsvSingleton(final CsvMapper csvMapper) {
        this.csvMapper = csvMapper;
    }

    private static CsvMapper config(){
        return new CsvMapper();
    }
}
