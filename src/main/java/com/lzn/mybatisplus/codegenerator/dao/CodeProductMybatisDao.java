package com.lzn.mybatisplus.codegenerator.dao;

import com.elog.fs.admin.codeproduct.entity.CodeProduct;
import com.elog.fs.admin.codeproduct.export.CodeProductVO;
import java.util.List;
import java.util.Map;

public interface CodeProductMybatisDao  {
    /**
     *  根据主键删除数据库的记录, test_code_product
     */
    int deleteByPrimaryKey(Long id);

    /**
     *  新写入数据库记录, test_code_product
     */
    int insert(CodeProduct record);

    /**
     *  根据指定主键获取一条数据库记录, test_code_product
     */
    CodeProduct selectByPrimaryKey(Long id);

    /**
     *  根据主键来更新符合条件的数据库记录, test_code_product
     */
    int updateByPrimaryKey(CodeProduct record);

    /**
     *  根据条件分页查询
     * */
    List<CodeProductVO> listForPage(Map<String,Object> searchMap);

    /**
     *  根据条件分页查询(计数)
     * */
    long countForPage(Map<String,Object> searchMap);
    
}
