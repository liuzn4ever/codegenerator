package com.lzn.mybatisplus.codegenerator.service;



import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


/**
 * <p>
 *  服务类
 * </p>
 *
 * @author liuzhinan
 * @since 2020-07-17
 */
@Service
public class CodeProductService {

    @Resource
    private CodeProductMybatisDao codeProductDao;

    /**
     * 分页查询
     * */
    public GridDataModel<CodeProductVO>  findByPage(Map<String, Object> searchParams, OmuiPage page){
        GridDataModel<CodeProductVO> gm = new GridDataModel<CodeProductVO>();
        searchParams.put("start", page.getStart());
        searchParams.put("limit", page.getLimit());
        long count = codeProductDao.countForPage(searchParams);
        List<CodeProductVO> list = codeProductDao.listForPage(searchParams);
        gm.setTotal(count);
        gm.setRows(list);
        return gm;
    }



}

