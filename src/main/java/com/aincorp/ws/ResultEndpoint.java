package com.aincorp.ws;

import com.aincorp.model.ResponseResult;
import com.aincorp.processor.FindNumberProcessor;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/*
 * http://localhost:8080/SOAPWebService/responseResult?wsdl
 */
@WebService(serviceName = "resultService")
public class ResultEndpoint {

    private FindNumberProcessor findNumberProcessor;

    @WebMethod(exclude = true)
    public void setFindNumberProcessor(FindNumberProcessor findNumberProcessor) {
        this.findNumberProcessor = findNumberProcessor;
    }

    @WebMethod(operationName = "findNumber")
    public ResponseResult findNumber(@WebParam(name = "number") Integer number) {
        return findNumberProcessor.findNumberInFiles(number);
    }
}
