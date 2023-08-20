package io.github.ozzyozbourne;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlFactory;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.xml.deser.FromXmlParser;
import com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator;

/**
 * Singleton Xml Mapper
 */
public enum MapperXmlSingleton {

    /**
     * Init Xml mapper singleton
     */
    INSTANCE(config());

    final ObjectMapper objectMapper;

    MapperXmlSingleton(final ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    private static ObjectMapper config(){
        return new XmlMapper(new XmlFactory()
                .configure(ToXmlGenerator.Feature.WRITE_XML_DECLARATION, true))
                .configure(FromXmlParser.Feature.EMPTY_ELEMENT_AS_NULL, true)
                .findAndRegisterModules()
                .enable(SerializationFeature.INDENT_OUTPUT);
    }
}
