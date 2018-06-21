package com.taotao.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.taotao.mapper.TbItemDescMapper;
import com.taotao.mapper.TbItemParamItemMapper;
import com.taotao.mapper.TbItemParamMapper;
import com.taotao.pojo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.common.pojo.EasyUIDataGridResult;
import com.taotao.mapper.TbItemMapper;
import utils.IDUtils;
import com.taotao.common.pojo.TaotaoResult;
import utils.JSONUtil;

@Service
public class ItemServiceImp implements ItemService
{
	@Autowired
	private TbItemMapper itemMapper;
	@Autowired
	private TbItemDescMapper tbItemDescMapper;
	@Autowired
	private TbItemParamItemMapper tbItemParamItemMapper;
	@Override
	public TbItem getItemById(Long itemId) {
		TbItem item = itemMapper.selectByPrimaryKey(itemId);
		return item;
	}

	@Override
	public EasyUIDataGridResult getItemList(int page, int rows) {
		PageHelper.startPage(page, rows);
		// TODO Auto-generated method stub
		TbItemExample example = new TbItemExample();
		List<TbItem> list =  itemMapper.selectByExample(example);
		PageInfo pageInfo = new PageInfo(list);
		EasyUIDataGridResult result = new EasyUIDataGridResult();
		result.setTotal(pageInfo.getTotal());
		result.setRows(list);
		return result;
	}

	@Override
	public TaotaoResult createItem(TbItem item, String desc, String paramData)
	{
		//Create cargo ID
		long itemId= IDUtils.getItemId();;
		Date date = new Date();
		item.setId(itemId);
		item.setUpdated(date);
		item.setCreated(date);
		//1-normal 2-undercarriage 3-delete
		item.setStatus((byte)1);
		itemMapper.insert(item);
		//desc
		TbItemDesc desc1 = new TbItemDesc();
		desc1.setItemId(itemId);
		desc1.setItemDesc(desc);
		desc1.setCreated(date);
		desc1.setUpdated(date);
		tbItemDescMapper.insert(desc1);
		TbItemParamItem paramItem = new TbItemParamItem();
		paramItem.setItemId(itemId);
		paramItem.setParamData(paramData);
		paramItem.setCreated(date);
		paramItem.setUpdated(date);
		tbItemParamItemMapper.insert(paramItem);
		return TaotaoResult.ok();
	}

	@Override
	public TaotaoResult getDescById(Long id)
	{
		TbItemDesc tbItemDesc = tbItemDescMapper.selectByPrimaryKey(id);
		return TaotaoResult.ok(tbItemDesc);
	}

	@Override
	public String getParamListHtml(Long id)
	{
		TbItemParamItemExample example = new TbItemParamItemExample();
		TbItemParamItemExample.Criteria criteria = example.createCriteria();
		criteria.andItemIdEqualTo(id);
		List<TbItemParamItem> tbItemParamItems = tbItemParamItemMapper.selectByExampleWithBLOBs(example);
		if (tbItemParamItems==null&&tbItemParamItems.isEmpty()){return  "";}
		TbItemParamItem paramItem = tbItemParamItems.get(0);
		String paramData = paramItem.getParamData();
		List<Map> maps = JSONUtil.parseArray(paramData, Map.class);
		StringBuffer sb =new StringBuffer();
		sb.append("<table cellpadding=\"0\" cellspacing=\"1\" width=\"100%\" border=\"1\" class=\"Ptable\">\n");
		sb.append("	<tbody>\n");
		for (Map a: maps)
		{
			sb.append("		<tr>\n");
			sb.append("			<th class=\"tdTitle\" colspan=\"2\">"+a.get("group")+"</th>\n");
			sb.append("		</tr>\n");
			List<Map> map2 = (List<Map>) a.get("params");
			for (Map b:map2)
			{
				sb.append("		<tr>\n");
				sb.append("			<td class=\"tdTitle\">"+b.get("k")+"</td>\n");
				sb.append("			<td>"+b.get("v")+"</td>\n");
				sb.append("		</tr>\n");
			}
		}
		sb.append("	</tbody>\n");
		sb.append("</table>");
		return sb.toString();
	}
}
