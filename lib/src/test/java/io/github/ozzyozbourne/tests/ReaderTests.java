package io.github.ozzyozbourne.tests;

import io.github.ozzyozbourne.pojos.Order;
import lombok.val;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

import static io.github.ozzyozbourne.Rdwr.*;

@Test
public final class ReaderTests {

    private static final String PATH_TO_RC = "src" + File.separator + "test" + File.separator + "resources" + File.separator + "read" + File.separator;

    public void YamlTestOne() throws IOException {
        val res = readYamlToPojo(PATH_TO_RC + "YamlTest.yaml", Order.class);
        Assert.assertTrue(res.isPresent());
        System.out.println(res.get());
    }

    public void TomlTestOne() throws IOException {
        val res = readTomlToPojo(PATH_TO_RC + "TomlTest.toml", Order.class);
        Assert.assertTrue(res.isPresent());
        System.out.println(res.get());
    }

    public void CsvTestOne(){

    }

    public void JsonTestOne(){

    }

    public void PropTestOne() throws IOException {
        val res = getValueFromProp(PATH_TO_RC + "Test.properties");
        Assert.assertTrue(res.isPresent());
        Assert.assertEquals(res.get().get("age"), "654654");
        Assert.assertEquals(res.get().get("name"), "osaid");
        Assert.assertEquals(res.get().get("height"), "54685465131354311cm");
    }

}
