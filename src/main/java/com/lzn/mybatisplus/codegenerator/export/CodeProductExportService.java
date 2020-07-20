package com.lzn.mybatisplus.codegenerator.export;


import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import com.lzn.mybatisplus.codegenerator.utils.ParameterUtil;
import com.lzn.mybatisplus.codegenerator.utils.export.AbstractCSVExportService;
import com.lzn.mybatisplus.codegenerator.dao.CodeProductMybatisDao;
import com.lzn.mybatisplus.codegenerator.export.CodeProductVO;
import com.lzn.mybatisplus.codegenerator.utils.entity.*;

import javax.annotation.Resource;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  导出
 * </p>
 *
 * @author liuzhinan
 * @since 2020-07-20
 */
@Component
public class CodeProductExportService extends AbstractCSVExportService<CodeProductVO> {

    @Resource
    private CodeProductMybatisDao codeProductMybatisDao;

    Map<String, Object> searchMap;

    @Override
    public void prepareExport(Map<String, Object> parameterMap) {
        searchMap = ParameterUtil.getParametersStartingWith(parameterMap,"filter_");
        Iterator<String> iterator = searchMap.keySet().iterator();
        while (iterator.hasNext()) {
            String key = iterator.next();
            String value = (String) searchMap.get(key);
            if (StringUtils.isEmpty(value)) {
                iterator.remove();
                continue;
            }
        }
    }

    @Override
    public int queryTotal() {
        Long count = codeProductMybatisDao.countForPage(searchMap);
        return Integer.valueOf(count.toString());
    }

    @Override
    public List<CodeProductVO> queryList(int start, int size) {
        searchMap.put("start", start);
        searchMap.put("limit", size);
        List<CodeProductVO> resultList  = codeProductMybatisDao.listForPage(searchMap);
        return resultList;
    }

    @Override
    public String[] getTableHead() {
            String[] head = new String[]{
                        "",                        "创建时间",                        "更新时间",                        "姓名",                        "手机号",                        "生成时间",                        "公司名称",                        "主营商品",                        "备注信息",                        "状态",                        "处理人"            };

        return head;
    }

    @Override
    public String getFileName() {
        return "";
    }

    @Override
    public Class<CodeProductVO> getClazz() {
        return CodeProductVO.class;
    }
}
