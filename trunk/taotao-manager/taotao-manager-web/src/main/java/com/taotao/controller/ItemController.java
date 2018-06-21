package com.taotao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotao.common.pojo.EasyUIDataGridResult;
import com.taotao.pojo.TbItem;
import com.taotao.service.ItemService;
import com.taotao.common.pojo.TaotaoResult;

@Controller
@RequestMapping("/item")
public class ItemController 
{
	@Autowired
	private ItemService itemService;


	@RequestMapping("/{itemId}")
	@ResponseBody
	private TbItem geItemById(@PathVariable Long itemId)
	{
		TbItem Item = itemService.getItemById(itemId);
		return Item;
	}
	@RequestMapping("/list")
	@ResponseBody
	public EasyUIDataGridResult getItenList(Integer page, Integer rows)
	{
		EasyUIDataGridResult result =  itemService.getItemList(page, rows);
		return result;
	}
	@RequestMapping(value = "/save",method = RequestMethod.POST)
	@ResponseBody
	public TaotaoResult addItem(TbItem item , String desc,String itemParams)
	{
		TaotaoResult result = itemService.createItem(item,desc,itemParams);
		return result;
	}
	@RequestMapping("/desc/{id}")
	@ResponseBody
	public TaotaoResult getDescById(@PathVariable Long id)
	{
		TaotaoResult result = itemService.getDescById(id);
		return  result;
	}
	@RequestMapping("/itemParamDesplay/{itemId}")
	public String itemParamDesplay(@PathVariable Long itemId,Model model)
	{
		String paramListHtml = itemService.getParamListHtml(itemId);
		model.addAttribute("Myhtml",paramListHtml);
		return "ItemparamDesplay";
	}
}

