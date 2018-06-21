<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link href="/js/kindeditor-4.1.10/themes/default/default.css" type="text/css" rel="stylesheet">
<script type="text/javascript" charset="utf-8" src="/js/kindeditor-4.1.10/kindeditor-all-min.js"></script>
<script type="text/javascript" charset="utf-8" src="/js/kindeditor-4.1.10/lang/zh_CN.js"></script>
<div style="padding:10px 10px 10px 10px">
    <form id="itemParamEditForm" class="itemForm" method="post">
        <input type="hidden" name="id"/>
        <table cellpadding="5">
            <tr>
                <td>ID:</td>
                <td><input class="easyui-textbox" type="easyui-numberbox" name="id" data-options="required:true" style="width: 280px;"></input></td>
            </tr>
            <tr>
                <td>商品类目ID:</td>
                <td>
                    <a href="javascript:void(0)" class="easyui-linkbutton selectItemCat">选择类目</a>
                </td>
            </tr>
            <tr>
                <td>商品类目</td>
                <td><input class="" type="text" name="itemCatName" style="width: 280px;"></input></td>
            </tr>
            <tr class="params">
                <td>规格</td>
                <td></td>
            </tr>
        </table>
        <input type="hidden" name="itemParams"/>
        <input type="hidden" name="itemParamId"/>
    </form>
    <div style="padding:5px">
        <a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitForm()">提交</a>
    </div>
</div>
<script type="text/javascript">
    function submitForm(){
        if(!$('#itemeEditForm').form('validate')){
            $.messager.alert('提示','表单还未填写完成!');
            return ;
        }

        var paramJson = [];
        $("#itemeEditForm .params li").each(function(i,e){
            var trs = $(e).find("tr");
            var group = trs.eq(0).text();
            var ps = [];
            for(var i = 1;i<trs.length;i++){
                var tr = trs.eq(i);
                ps.push({
                    "k" : $.trim(tr.find("td").eq(0).find("span").text()),
                    "v" : $.trim(tr.find("input").val())
                });
            }
            paramJson.push({
                "group" : group,
                "params": ps
            });
        });
        paramJson = JSON.stringify(paramJson);

        $("#itemeEditForm [name=itemParams]").val(paramJson);

        $.post("/rest/item/param/update",$("#itemeEditForm").serialize(), function(data){
            if(data.state == 200){
                $.messager.alert('提示','修改商品成功!','info',function(){
                    $("#itemEditWindow").window('close');
                    $("#itemList").datagrid("reload");
                });
            }
        });
    }
</script>