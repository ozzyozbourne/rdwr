package io.github.ozzyozbourne;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.javaprop.JavaPropsMapper;
import com.fasterxml.jackson.dataformat.toml.TomlFactory;
import com.fasterxml.jackson.dataformat.toml.TomlMapper;
import com.fasterxml.jackson.dataformat.xml.XmlFactory;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.xml.deser.FromXmlParser;
import com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.fasterxml.jackson.dataformat.yaml.YAMLGenerator;
import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.Predicate;
import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 *This class contains reader and writers for YAML, TOML, JSON, XML CSV and PROPERTIES file formats
 */
public final class Rdwr {

    private Rdwr() {
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
        return Optional.of(JsonPath.read(new TomlMapper().readTree(new File(pathToFile)).toString(), pathToGet));
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
        return Optional.of(JsonPath.read(new ObjectMapper().valueToTree(new Yaml().load(new FileReader(pathToFile))).toString(), pathToGet));
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
        return Optional.of(JsonPath.read(Files.newInputStream(Paths.get(pathToFile)), pathToGet, filters));
    }

    /**
     *
     * @param filePath path to csv file
     * @param t pojo class type
     * @param separator csv file separator being used
     * @param skipFirstRow whether to leave to include first row
     * @return Optional list of type T
     * @param <T> Expected java type
     * @throws IOException when file exception occurs
     */
    public static <T> Optional<List<T>> readCsvToPojo(final String filePath, final Class<T> t, final char separator, final boolean skipFirstRow) throws IOException {
        final CsvMapper csvMapper = CsvMapper.csvBuilder().build();
        Optional<List<T>> optionalTList;
        try(MappingIterator<T> iterator = csvMapper.readerFor(t)
                .with(csvMapper.schemaFor(t)
                        .withSkipFirstDataRow(skipFirstRow)
                        .withColumnSeparator(separator))
                .readValues(new File(filePath))){
            optionalTList = Optional.of(iterator.readAll());
        }return optionalTList;
    }

    /***
     *
     * @param filePath path to csv file
     * @param tList pojo class type List
     * @param t pojo class type
     * @param separator csv file separator being used
     * @param useHeader whether to write or leave the header row
     * @param <T> Expected java type
     * @throws IOException when file exception occurs
     */
    public static <T> void writePojoToCsv(final String filePath, final List<T> tList, final Class<T> t, final char separator, final boolean useHeader) throws IOException {
        final CsvMapper mapper = new CsvMapper();
        mapper.writer(mapper
                .schemaFor(t)
                .withColumnSeparator(separator)
                .withUseHeader(useHeader)
                .withoutQuoteChar())
                .writeValue(new File(filePath), tList);
    }

    /***
     *
     * @param filePath path to yaml file
     * @param t pojo class type
     * @return Optional Object of type T
     * @param <T> Expected java type
     * @throws IOException when file exception occurs
     */
    public static <T> Optional<T>  readYamlToPojo(final String filePath, final Class<T> t) throws IOException {
      return Optional.of(new ObjectMapper(new YAMLFactory())
              .findAndRegisterModules()
              .readValue(new File(filePath), t));
    }

    /***
     *
     * @param filePath path to toml file
     * @param t pojo class type
     * @return Optional Object of type T
     * @param <T> Expected java type
     * @throws IOException when file exception occurs
     */
    public static <T> Optional<T>  readTomlToPojo(final String filePath, final Class<T> t) throws IOException {
        return Optional.of(new ObjectMapper(new TomlFactory())
                .findAndRegisterModules()
                .readValue(new File(filePath), t));
    }

    /***
     *
     * @param filePath path to yaml file
     * @param t pojo class type
     * @param <T> Expected java type
     * @throws IOException when file exception occurs
     */
    public static <T> void writePojoToYaml(final String filePath, final T t) throws IOException {
        new ObjectMapper(new YAMLFactory()
                .disable(YAMLGenerator.Feature.WRITE_DOC_START_MARKER))
                .findAndRegisterModules()
                .disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
                .writeValue(new File(filePath), t);
    }

    /***
     *
     * @param filePath path to toml file
     * @param t pojo class type
     * @param <T> Expected java type
     * @throws IOException when file exception occurs
     */
    public static <T> void writePojoToToml(final String filePath, final T t) throws IOException {
        new ObjectMapper(new TomlFactory())
                .findAndRegisterModules()
                .disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
                .writeValue(new File(filePath), t);
    }

    /**
     *
     * @param filePath path to properties file
     * @return optional type containing and map of string and string
     * @throws IOException when file exception occurs
     */
    public static Optional<Map<String, String>> getValueFromProp(final String filePath) throws IOException {
        return Optional.of(new JavaPropsMapper().readValue(new File(filePath), new TypeReference<>(){}));
    }

    /**
     *
     * @param filePath path to properties file
     * @param t Pojo class mapped to properties
     * @return optional object containing the pojo mapped to properties
     * @param <T> Expected java type
     * @throws IOException when file exception occurs
     */
    public static <T> Optional<T> getValueFromProp(final String filePath, final Class<T> t) throws IOException {
        return Optional.of(new JavaPropsMapper().readValue(new File(filePath), t));
    }

    /**
     *
     * @param filePath path to properties file
     * @param t Property Pojo
     * @param <T> Expected java type
     * @throws IOException when file exception occurs
     */
    public static <T> void writePojoToProperties(final String filePath, final T t) throws IOException {
        new JavaPropsMapper().writerFor(t.getClass()).writeValue(new File(filePath), t);
    }

    /***
     *
     * @param filePath path to properties file
     * @param tMap Property Map
     * @param <T> Expected java type
     * @throws IOException when file exception occurs
     */
    public static <T extends Map<String, String>> void writePojoToProperties(final String filePath, final T tMap) throws IOException {
        new JavaPropsMapper().writerFor(new TypeReference<T>() {}).writeValue(new File(filePath), tMap);
    }

    /***
     *
     * @param filePath path to xml file
     * @param tClass xml pojo class
     * @return Xml mapped to POJO
     * @param <T> Expected java type
     */
    public static <T> Optional<T>  readXmlToPojo (final String filePath, final Class<T> tClass) throws IOException {
        return Optional.of(new XmlMapper(new XmlFactory()
                .configure(FromXmlParser.Feature.EMPTY_ELEMENT_AS_NULL, true))
                .findAndRegisterModules()
                .readValue(new File(filePath), tClass));
    }

    /**
     *
     * @param filePath path to xml file
     * @param t Pojo to be written
     * @param <T> Expected java type
     * @throws IOException Write exception
     */
    public static <T> void writePojoToXml (final String filePath, final T t) throws IOException {
        new XmlMapper(new XmlFactory()
                .configure(ToXmlGenerator.Feature.WRITE_XML_DECLARATION, true))
                .findAndRegisterModules()
                .enable(SerializationFeature.INDENT_OUTPUT)
                .writeValue(new File(filePath), t);
    }

    /**
     * @param t Pojo to be written
     * @param <T> Expected java type
     * @throws IOException Write exception
     * @return Optional String of xml
     */
    public static <T> Optional<String> writePojoToXmlString (final T t) throws IOException {
        return Optional.of(new XmlMapper(new XmlFactory()
                .configure(ToXmlGenerator.Feature.WRITE_XML_DECLARATION, true))
                .findAndRegisterModules()
                .enable(SerializationFeature.INDENT_OUTPUT)
                .writeValueAsString(t));
    }
}
