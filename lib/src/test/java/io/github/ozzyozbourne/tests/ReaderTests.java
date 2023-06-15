package io.github.ozzyozbourne.tests;

import io.github.ozzyozbourne.pojos.yaml.Order;
import lombok.val;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

import static io.github.ozzyozbourne.Rdwr.readYamlToPojo;

@Test
public final class ReaderTests {

    private static final String PATH_TO_RC = "src" + File.separator + "test" + File.separator + "resources" + File.separator + "read" + File.separator;

    public void YamlTestOne() throws IOException {
        val loc = PATH_TO_RC + "YamlTest.yaml";
        val res = readYamlToPojo(loc, Order.class);
        Assert.assertTrue(res.isPresent());
        System.out.println(res.get());
    }

    public void TomlTestOne(){

    }

    public void CsvTestOne(){

    }
    public void JsonTestOne(){

    }

}
