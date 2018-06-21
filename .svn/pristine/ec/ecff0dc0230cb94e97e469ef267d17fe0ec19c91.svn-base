package com.taotao.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.common.pojo.ParamListResult;
import com.taotao.common.pojo.TaotaoResult;
import com.taotao.mapper.TbItemParamItemMapper;
import com.taotao.mapper.TbItemParamMapper;
import com.taotao.pojo.TbItemParam;
import com.taotao.pojo.TbItemParamExample;
import com.taotao.pojo.TbItemParamItem;
import com.taotao.pojo.TbItemParamItemExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import utils.JSONUtil;

import java.util.Date;
import java.util.List;

@Service
public class paramListServiceImp implements paramListService
{
    @Autowired
    TbItemParamMapper itemParam;
    @Autowired
    TbItemParamItemMapper tbItemParamItemMapper;
    @Override
    public ParamListResult getParamList(int page, int rows)
    {
        PageHelper.startPage(page,rows);
        TbItemParamExample tbItemParamExample = new TbItemParamExample();
        List<TbItemParam> list = itemParam.selectByExampleWithBLOBs(tbItemParamExample);
        PageInfo pageInfo = new PageInfo(list);
        ParamListResult result = new ParamListResult();
        result.setRows(list);
        result.setTotal(pageInfo.getTotal());
        return result;
    }

    @Override
    public TaotaoResult getParam(long cid)
    {
        TbItemParamExample tbItemParamExample = new TbItemParamExample();
        TbItemParamExample.Criteria criteria = tbItemParamExample.createCriteria();
        criteria.andItemCatIdEqualTo(cid);
        List<TbItemParam> tbItemParams = itemParam.selectByExampleWithBLOBs(tbItemParamExample);
        if (tbItemParams!=null && tbItemParams.size()>0)
        {
            TbItemParam tbItemParam = tbItemParams.get(0);
            return TaotaoResult.ok(tbItemParam);
        }
           return TaotaoResult.ok();
    }

    @Override
    public TaotaoResult insertItemParam(long cid, String param)
    {
        TbItemParam tbItemParam = new TbItemParam();
        tbItemParam.setItemCatId(cid);
        tbItemParam.setParamData(param);
        Date date = new Date();
        tbItemParam.setCreated(date);
        tbItemParam.setUpdated(date);
        itemParam.insert(tbItemParam);
        return TaotaoResult.ok();
    }

    @Override
    public TaotaoResult getParamItem(long id)
    {
        TbItemParamItemExample tbItemParamItemExample = new TbItemParamItemExample();
        TbItemParamItemExample.Criteria criteria = tbItemParamItemExample.createCriteria();
        criteria.andItemIdEqualTo(id);
        List<TbItemParamItem> tbItemParamItems = tbItemParamItemMapper.selectByExampleWithBLOBs(tbItemParamItemExample);
        TbItemParamItem paramItem = tbItemParamItems.get(0);
        return TaotaoResult.ok(paramItem);
    }

}
