package com.aincorp.processor;

import com.aincorp.entity.Result;
import com.aincorp.model.ResponseResult;
import com.aincorp.services.ResultService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

public class FindNumberProcessor {

    private final Logger logger = LoggerFactory.getLogger(FindNumberProcessor.class);

    private ResultService service;

    private FileReaderProcessor fileReaderProcessor;

    public void setService(ResultService service) {
        this.service = service;
    }

    public void setFileReaderProcessor(FileReaderProcessor fileReaderProcessor) {
        this.fileReaderProcessor = fileReaderProcessor;
    }

    public ResponseResult findNumberInFiles(Integer number) {

        try {
            Result result = findNumberInFilesProcessor(number);
            service.save(result);
        } catch (Exception e) {
            Result resultError = fillResultError(e.toString(), number);
            service.save(resultError);
            logger.error(e.getMessage(), e);
        }

        Result result = service.getLastResult();

        ResponseResult responseResult = fillResponseResult(result);

        return responseResult;
    }

    public ResponseResult fillResponseResult(Result result) {
        ResponseResult responseResult = new ResponseResult();
        responseResult.setCode(result.getCode());
        if (result.getFilenames() != null) {
            responseResult.setFileNames(Arrays.asList(result.getFilenames().split(" ")));
        }
        responseResult.setError(result.getError());

        return responseResult;
    }


    public Result findNumberInFilesProcessor(Integer number) throws IOException {
        Result result = new Result();

        List<String> fileNameList = fillFileNames(number);

        if (!fileNameList.isEmpty()) {
            String fileNames = "";

            for (String name : fileNameList) {
                fileNames = fileNames + " " + name;
            }

            result.setCode("00.ResponseResult.OK");
            result.setNumber(number);
            result.setFilenames(fileNames);
        } else {
            result.setCode("01.ResponseResult.NotFound");
            result.setNumber(number);
        }

        return result;
    }

    private List<String> fillFileNames(final Integer number) throws IOException {
        List<String> list = new ArrayList<>();


        String path = fileReaderProcessor.getFilePath();
        File[] lisOfFiles = fileReaderProcessor.getListOfFilesInDirectory(path);

        for (File file : lisOfFiles) {

            /*try(SeekableByteChannel channel = Files.newByteChannel(Paths.get(String.valueOf(file)))) {
                ByteBuffer buffer = ByteBuffer.allocate();

            } catch (IOException exception) {
                System.out.println("Input / Output error");
            }*/


            byte[] bytes = new byte[(int) file.length()];
            FileInputStream fis = new FileInputStream(file);
            fis.read(bytes);
            fis.close();

            String[] valueStr = new String(bytes).trim().split(",");

            boolean found = Arrays.stream(valueStr).anyMatch(x-> Integer.parseInt(x) == number);

            if (found) {
                list.add(file.getName());
            }
        }

        return list;
    }

    public Result fillResultError(String error, Integer number) {
        Result result = new Result();
        result.setCode("02.ResponseResult.Error");
        result.setError(error);
        result.setNumber(number);

        return result;
    }
}
