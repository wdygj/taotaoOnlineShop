package com.taotao.controller;

import com.taotao.common.pojo.ParamListResult;
import com.taotao.common.pojo.TaotaoResult;
import com.taotao.service.paramListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/item/param")
public class paramListController
{
    @Autowired
    paramListService paramListService;
    @RequestMapping("/list")
    @ResponseBody
    public ParamListResult getParamList(Integer page, Integer rows)
    {
        ParamListResult result = paramListService.getParamList(page,rows);
        return result;
    }

    @RequestMapping("/query/itemcatid/{id}")
    @ResponseBody
    public TaotaoResult getparamByCid(@PathVariable long id)
    {
        TaotaoResult param = paramListService.getParam(id);
        return param;
    }
    @RequestMapping("/save/{cid}")
    @ResponseBody
    public TaotaoResult insertItemParam(@PathVariable long cid,String paramData)
    {
        TaotaoResult taotaoResult = paramListService.insertItemParam(cid, paramData);
        return taotaoResult;
    }
    @RequestMapping("/query/item/{id}")
    @ResponseBody
    public TaotaoResult getParamItemByCid(@PathVariable long id)
    {
        TaotaoResult param = paramListService.getParamItem(id);
        return param;
    }
}

