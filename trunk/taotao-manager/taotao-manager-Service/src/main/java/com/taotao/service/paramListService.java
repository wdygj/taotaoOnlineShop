package com.taotao.service;

import com.taotao.common.pojo.ParamListResult;
import com.taotao.common.pojo.TaotaoResult;

public interface paramListService
{
    ParamListResult getParamList(int page, int rows);
    TaotaoResult getParam(long cid);
    TaotaoResult insertItemParam(long cid,String param);

    TaotaoResult getParamItem(long id);
}

