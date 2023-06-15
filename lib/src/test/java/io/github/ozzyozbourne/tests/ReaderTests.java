package io.github.ozzyozbourne.tests;

import io.github.ozzyozbourne.pojos.OrderYaml;
import lombok.val;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

import static io.github.ozzyozbourne.Rds.getYamlToPojo;

@Test
public final class ReaderTests {

    public static final String PATH_TO_RC = "src" + File.separator + "test" + File.separator + "resources" + File.separator;

    public void YamlTestOne() throws IOException {
        val loc = PATH_TO_RC + "YamlTest.yaml";
        val res = getYamlToPojo(loc, OrderYaml.class);
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
