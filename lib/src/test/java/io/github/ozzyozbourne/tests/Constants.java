package io.github.ozzyozbourne.tests;

import java.io.File;

public interface Constants {

    String PATH_TO_RS = "src" + File.separator + "test" + File.separator + "resources";
    String PATH_TO_RD = PATH_TO_RS + File.separator + "read" + File.separator;
    String PATH_TO_WR = PATH_TO_RS + File.separator + "write" + File.separator;
    String PATH_TO_TH = PATH_TO_RS + File.separator + "threaded" + File.separator;
    String PATH_YML_RD = PATH_TO_TH + "yaml" + File.separator + "read" + File.separator;
    String PATH_YML_WR = PATH_TO_TH + "yaml" + File.separator + "write" + File.separator;
}
