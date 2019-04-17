package com.aincorp.services;

import com.aincorp.dao.ResultDAO;
import com.aincorp.entity.Result;

import java.util.List;

public class ResultServiceImpl implements ResultService {

    private ResultDAO resultDao;

    public void setResultDao(ResultDAO resultDao) {
        this.resultDao = resultDao;
    }

    public void save(Result r) {
        resultDao.save(r);
    }

    public List<Result> list() {
        return resultDao.list();
    }

    public Result getLastResult() {
        return resultDao.getLastResult();
    }
}
