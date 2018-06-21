package com.taotao.controller;

import com.taotao.common.pojo.EasyUITreeNode;
import com.taotao.service.getItemCatList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class itemCatListController
{
    @Autowired
    private getItemCatList getItemCatList;

    @RequestMapping("/item/cat/list")
    @ResponseBody
    public List<EasyUITreeNode> getCatList(@RequestParam(value="id",defaultValue = "0") long parentId)
    {
        return getItemCatList.getitemCatList(parentId);

    }
}
