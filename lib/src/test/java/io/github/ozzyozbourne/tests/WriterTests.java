package io.github.ozzyozbourne.tests;

import io.github.ozzyozbourne.pojos.CsvRec;
import io.github.ozzyozbourne.pojos.Order;
import io.github.ozzyozbourne.pojos.Prop;
import lombok.val;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

import static io.github.ozzyozbourne.Rdwr.*;
import static io.github.ozzyozbourne.tests.Constants.PATH_TO_RD;
import static io.github.ozzyozbourne.tests.Constants.PATH_TO_WR;

@Test
public final class WriterTests {

    public void YamlTestOne() throws IOException {
        val res = readYamlToPojo(PATH_TO_RD + "YamlTest.yaml", Order.class);
        Assert.assertTrue(res.isPresent());

        writePojoToYaml(PATH_TO_WR + "YamlTest.yaml", res.get());
        Assert.assertTrue(new File(PATH_TO_WR + "YamlTest.yaml").exists());
    }

    public void TomlTestOne() throws IOException {
        val res = readTomlToPojo(PATH_TO_RD + "TomlTest.toml", Order.class);
        Assert.assertTrue(res.isPresent());

        writePojoToToml(PATH_TO_WR + "TomlTest.toml", res.get());
        Assert.assertTrue(new File(PATH_TO_WR + "TomlTest.toml").exists());
    }

    public void PropTestOne() throws IOException {
        val res = readProp(PATH_TO_RD + "Test.properties");
        Assert.assertTrue(res.isPresent());

        writePojoToProperties(PATH_TO_WR + "Test.properties", res.get());
        Assert.assertTrue(new File(PATH_TO_WR + "Test.properties").exists());
    }

    public void PropTestTwo() throws IOException {
        val res = readPropToPojo(PATH_TO_RD + "Test.properties", Prop.class);
        Assert.assertTrue(res.isPresent());

        writePojoToProperties(PATH_TO_WR + "TestTwo.properties", res.get());
        Assert.assertTrue(new File(PATH_TO_WR + "TestTwo.properties").exists());
    }

    public void csvWriterTestOne() throws IOException {
        val csvOptional  = readCsvToPojo(PATH_TO_RD + "CsvTest.csv", CsvRec.class, '|', true);
        Assert.assertTrue(csvOptional.isPresent());
        writePojoToCsv(PATH_TO_WR + "CsvTest.csv", csvOptional.get(), CsvRec.class, '|', true);

    }
}
