package com.taotao.service;

import com.taotao.common.pojo.EasyUITreeNode;
import com.taotao.mapper.TbItemCatMapper;
import com.taotao.pojo.TbItemCat;
import com.taotao.pojo.TbItemCatExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class getItemCatListImp implements getItemCatList
{
    @Autowired
    TbItemCatMapper itemCatMapper;
    @Override
    public List<EasyUITreeNode> getitemCatList(long parentId)
    {
        TbItemCatExample example = new TbItemCatExample();
        TbItemCatExample.Criteria criteria = example.createCriteria();
        criteria.andParentIdEqualTo(parentId);
        List<TbItemCat> tbItemCats = itemCatMapper.selectByExample(example);
        List<EasyUITreeNode> list = new ArrayList<>();
        for (int i = 0; i < tbItemCats.size(); i++)
        {
            EasyUITreeNode easyUITreeNode = new EasyUITreeNode();
            easyUITreeNode.setId(tbItemCats.get(i).getId());
            easyUITreeNode.setText(tbItemCats.get(i).getName());
            easyUITreeNode.setState(tbItemCats.get(i).getIsParent()?"closed":"opened");
            list.add(easyUITreeNode);
        }
        return list;
    }
}
