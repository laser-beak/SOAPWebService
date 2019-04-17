package com.aincorp.dao;

import com.aincorp.entity.Result;

import java.util.List;

public interface ResultDAO {

    void save(Result r);

    List<Result> list();

    Result getLastResult();

}
