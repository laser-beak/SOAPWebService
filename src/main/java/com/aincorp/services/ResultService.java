package com.aincorp.services;

import com.aincorp.entity.Result;

import java.util.List;

public interface ResultService {

    void save(Result r);

    List<Result> list();

    Result getLastResult();
}
