package io.github.ozzyozbourne.tests;

import io.github.ozzyozbourne.pojos.yaml.Order;
import lombok.val;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

import static io.github.ozzyozbourne.Rds.readYamlToPojo;
import static io.github.ozzyozbourne.Rds.writePojoToYaml;

@Test
public final class WriterTests {

    private static final String PATH_TO_RC_RD = "src" + File.separator + "test" + File.separator + "resources" + File.separator + "read" + File.separator;
    private static final String PATH_TO_RC_WR = "src" + File.separator + "test" + File.separator + "resources" + File.separator + "write" + File.separator;

    public void YamlTestOne() throws IOException {
        val locRd = PATH_TO_RC_RD + "YamlTest.yaml";
        val locWr = PATH_TO_RC_WR + "YamlTest.yaml";

        val res = readYamlToPojo(locRd, Order.class);
        Assert.assertTrue(res.isPresent());

        writePojoToYaml(locWr, res.get());
        Assert.assertTrue(new File(locWr).exists());
    }
}
