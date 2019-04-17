package com.aincorp.model;

import java.util.List;

public class ResponseResult {

    private String code;

    private List<String> fileNames;

    private String error;

    public ResponseResult() {
    }

    public ResponseResult(String code, List<String> fileNames, String error) {
        this.code = code;
        this.fileNames = fileNames;
        this.error = error;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<String> getFileNames() {
        return fileNames;
    }

    public void setFileNames(List<String> fileNames) {
        this.fileNames = fileNames;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
