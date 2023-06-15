package io.github.ozzyozbourne;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.toml.TomlMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.Predicate;
import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

/**
 *
 */
public final class Rds {

    private Rds() {
    }

    /**
     *
     * @param pathToGet json jay way query
     * @param pathToFile path to toml file
     * @return The result of the jay way query
     * @param <T> Expected java type
     * @throws IOException when file exception occurs
     */
    public static <T> Optional<T> srcInToml (final String pathToGet, final String pathToFile) throws IOException {
        final JsonNode jsonNode = new TomlMapper().readTree(new File(pathToFile));
        return Optional.of(JsonPath.read(jsonNode.toString(), pathToGet));
    }

    /**
     *
     * @param pathToGet json jay way query
     * @param pathToFile path to yaml file
     * @return The result of the jay way query
     * @param <T> Expected java type
     * @throws IOException when file exception occurs
     */
    public static <T> Optional<T> srcInYaml (final String pathToGet, final String pathToFile) throws IOException {
        final JsonNode jsonNode = new ObjectMapper().valueToTree(new Yaml().load(new FileReader(pathToFile)));
        return Optional.of(JsonPath.read(jsonNode.toString(), pathToGet));
    }

    /**
     *
     * @param pathToGet json jay way query
     * @param pathToFile path to json file
     * @param filters jay json filters for query
     * @return The result of the jay way query
     * @param <T> Expected java type
     * @throws IOException when file exception occurs
     */
    public static <T> Optional<T> srcInJsn (final String pathToGet, final String pathToFile, final Predicate... filters) throws IOException {
        return Optional.of(JsonPath.read(new FileReader(pathToFile), pathToGet, filters));
    }

    /**
     *
     * @param filePath path to csv file
     * @param t pojo class type
     * @param separator csv file separator being used
     * @param skipFirstRow whether to leave to include first row
     * @return The result of the jay way query
     * @param <T> Expected java type
     * @throws IOException when file exception occurs
     */
    public static <T> Optional<List<T>> rdCsv(final String filePath, final Class<T> t, final char separator, final boolean skipFirstRow) throws IOException {
        final CsvMapper csvMapper = CsvMapper.csvBuilder().build();
        Optional<List<T>> optionalTList;
        try(MappingIterator<T> iterator = csvMapper.readerFor(t)
                .with(csvMapper.schemaFor(t).withSkipFirstDataRow(skipFirstRow).withColumnSeparator(separator))
                .readValues(new File(filePath))){
            optionalTList = Optional.of(iterator.readAll());
        }return optionalTList;
    }

    public static <T> Optional<T>  getYamlToPojo(final String filePath, final Class<T> t) throws IOException {
      return Optional.of(new ObjectMapper(new YAMLFactory()).findAndRegisterModules().readValue(new File(filePath), t));
    }
}
