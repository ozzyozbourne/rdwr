package io.github.ozzyozbourne.tests;

import io.github.ozzyozbourne.pojos.CsvRec;
import io.github.ozzyozbourne.pojos.Order;
import io.github.ozzyozbourne.pojos.Prop;
import lombok.val;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import static io.github.ozzyozbourne.Rdwr.*;
import static io.github.ozzyozbourne.tests.Constants.PATH_TO_RD;

@Test
public final class ReaderTests {


    public void YamlTestOne() throws IOException {
        val res = readYamlToPojo(PATH_TO_RD + "YamlTest.yaml", Order.class);
        Assert.assertTrue(res.isPresent());
        Assert.assertEquals(res.get().orderNo(), "A001");
    }

    public void YamlTestTwo() throws IOException {
        val res = srcInYaml("$.ORDER_NO", PATH_TO_RD + "YamlTest.yaml");
        Assert.assertTrue(res.isPresent());
        Assert.assertEquals(res.get(), "A001");
    }


    public void TomlTestOne() throws IOException {
        val res = readTomlToPojo(PATH_TO_RD + "TomlTest.toml", Order.class);
        Assert.assertTrue(res.isPresent());
        Assert.assertEquals(res.get().orderNo(), "A001");
    }

    public void TomlTestTwo() throws IOException {
        Optional<String> res = srcInToml("$.ORDER_NO", PATH_TO_RD + "TomlTest.toml");
        Assert.assertTrue(res.isPresent());
        Assert.assertEquals(res.get(), "A001");
    }

    public void CsvTestOne() throws IOException {
        val csvOptional  = readCsvToPojo(PATH_TO_RD + "CsvTest.csv", CsvRec.class, '|', true);
        Assert.assertTrue(csvOptional.isPresent());

        Assert.assertEquals(csvOptional.get().get(0).elementName().trim(), "UserName");
        Assert.assertEquals(csvOptional.get().get(0).type().trim(), "xpath");
        Assert.assertEquals(csvOptional.get().get(0).locatorValue().trim(), "//h1[@class = 'heello']");

        Assert.assertEquals(csvOptional.get().get(1).elementName().trim(),"Password");
        Assert.assertEquals(csvOptional.get().get(1).type().trim(),"xpath");
        Assert.assertEquals(csvOptional.get().get(1).locatorValue().trim(),"//a[contains(text(), 'yello')]");

        Assert.assertEquals(csvOptional.get().get(2).elementName().trim(), "Sign-in");
        Assert.assertEquals(csvOptional.get().get(2).type().trim(), "css");
        Assert.assertEquals(csvOptional.get().get(2).locatorValue().trim(), "#singinbutton");

        Assert.assertEquals(csvOptional.get().size(), 3);
    }

    public void JsonTestOne() throws IOException {
        Optional<List<Integer>> res = srcInJsn("$.code.rbga", PATH_TO_RD + "JsonTest.json");
        Assert.assertTrue(res.isPresent());
        Assert.assertEquals(res.get(), List.of(255, 255, 255, 1));
    }

    public void PropTestOne() throws IOException {
        val res = readProp(PATH_TO_RD + "Test.properties");
        Assert.assertTrue(res.isPresent());
        Assert.assertEquals(res.get().get("age"), "654654");
        Assert.assertEquals(res.get().get("name"), "osaid");
        Assert.assertEquals(res.get().get("height"), "54685465131354311cm");
    }

    public void PropTestTwo() throws IOException {
        val res = readPropToPojo(PATH_TO_RD + "Test.properties", Prop.class);
        Assert.assertTrue(res.isPresent());
        Assert.assertEquals(res.get().age(), "654654");
        Assert.assertEquals(res.get().name(), "osaid");
        Assert.assertEquals(res.get().height(), "54685465131354311cm");
    }

}
