package io.github.ozzyozbourne.tests;

import io.github.ozzyozbourne.pojos.Order;
import lombok.val;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

import static io.github.ozzyozbourne.Rdwr.*;

@Test
public final class WriterTests {

    private static final String PATH_TO_RC_RD = "src" + File.separator + "test" + File.separator + "resources" + File.separator + "read" + File.separator;
    private static final String PATH_TO_RC_WR = "src" + File.separator + "test" + File.separator + "resources" + File.separator + "write" + File.separator;

    public void YamlTestOne() throws IOException {
        val res = readYamlToPojo(PATH_TO_RC_RD + "YamlTest.yaml", Order.class);
        Assert.assertTrue(res.isPresent());

        writePojoToYaml(PATH_TO_RC_WR + "YamlTest.yaml", res.get());
        Assert.assertTrue(new File(PATH_TO_RC_WR + "YamlTest.yaml").exists());
    }

    public void TomlTestOne() throws IOException {
        val res = readTomlToPojo(PATH_TO_RC_RD + "TomlTest.toml", Order.class);
        Assert.assertTrue(res.isPresent());

        writePojoToToml(PATH_TO_RC_WR + "TomlTest.toml", res.get());
        Assert.assertTrue(new File(PATH_TO_RC_WR + "TomlTest.toml").exists());
    }

    public void PropTestOne() throws IOException {
        val res = getValueFromProp(PATH_TO_RC_RD + "Test.properties");
        Assert.assertTrue(res.isPresent());

        writePojoToProperties(PATH_TO_RC_WR + "Test.properties", res.get());
        Assert.assertTrue(new File(PATH_TO_RC_WR + "Test.properties").exists());
    }
}
