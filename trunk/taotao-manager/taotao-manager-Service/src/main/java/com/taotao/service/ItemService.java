package com.taotao.service;

import com.taotao.common.pojo.EasyUIDataGridResult;
import com.taotao.pojo.TbItem;
import com.taotao.common.pojo.TaotaoResult;

public interface ItemService 
{
	TbItem getItemById(Long itenmId);
	EasyUIDataGridResult getItemList(int page, int rows);
	TaotaoResult createItem(TbItem item, String desc, String paramData);
    TaotaoResult getDescById(Long id);
    String getParamListHtml(Long id);
}
