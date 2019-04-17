package com.aincorp.processor;

import java.io.File;
import java.util.Properties;

public class FileReaderProcessor {

    private Properties properties;

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    public String getFilePath() {

        String filePath = properties.getProperty("file.directory.path");

        return filePath;
    }

    public File[] getListOfFilesInDirectory(String path) {
        File folder = new File(path);
        File[] listOfFiles = folder.listFiles();

        return listOfFiles;
    }
}
