
package com.lzn.mybatisplus.codegenerator.controller;

import com.lzn.mybatisplus.codegenerator.entity.CodeProduct;
import com.lzn.mybatisplus.codegenerator.service.CodeProductService;
import com.lzn.codegenerate.export.CodeProductVO;
import com.lzn.codegenerate.utils.entity.OmuiPage;
import com.lzn.codegenerate.utils.export.ExportMethod;
import org.apache.commons.beanutils.ConvertUtils;
import org.elogside.modules.mapper.JsonMapper;
import org.elogside.modules.utils.Exceptions;
import org.elogside.modules.utils.MyStringUtils;
import com.lzn.codegenerate.utils.ParameterUtil;
import com.lzn.codegenerate.utils.entity.GridDataModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * ${tablecomment}  前端控制器
 * </p>
 *
 * @author liuzhinan
 * @since 2020-07-17
 */
@Controller
@RequestMapping(value="/admin/codeProduct")
public class CodeProductController{
    private static Logger logger = LoggerFactory.getLogger(CodeProductController.class);

    @Resource
    private CodeProductService codeProductService;



    @RequestMapping(value = "list", method = RequestMethod.GET)
    public String list(Model model){
        return "/admin/codeproduct/list";
    }

    @RequestMapping(value = "searchList", method = RequestMethod.POST)
    @ResponseBody
    @ExportMethod(serviceClass = CodeProductExportService.class, memo = "明细导出")
    public String searchList(ServletRequest request,@ModelAttribute("page")  OmuiPage page){
        try {
            Map<String,Object> searchParam =	 ServletUtils.getParametersStartingWith(request, "filter_");
            GridDataModel<CodeProductVO> gd =codeProductService.findByPage(searchParam, page);
            return JsonMapper.nonDefaultMapper().toJson(gd);
        } catch (Exception e) {
            logger.error(Exceptions.getStackTraceAsString(e));
            return JsonMapper.nonDefaultMapper().toJson(new Resp("false", e.getMessage()));
        }
    }


}
