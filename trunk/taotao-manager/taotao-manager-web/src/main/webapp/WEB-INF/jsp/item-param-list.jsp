<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<table class="easyui-datagrid" id="itemParamList" title="商品列表" 
       data-options="singleSelect:false,collapsible:true,pagination:true,url:'/item/param/list',method:'get',pageSize:30,toolbar:itemParamListToolbar">
    <thead>
        <tr>
        	<th data-options="field:'ck',checkbox:true"></th>
        	<th data-options="field:'id',width:60">ID</th>
        	<th data-options="field:'itemCatId',width:80">商品类目ID</th>
        	<th data-options="field:'itemCatName',width:100">商品类目</th>
            <th data-options="field:'paramData',width:300,formatter:formatItemParamData">规格(只显示分组名称)</th>
            <th data-options="field:'created',width:130,align:'center',formatter:TAOTAO.formatDateTime">创建日期</th>
            <th data-options="field:'updated',width:130,align:'center',formatter:TAOTAO.formatDateTime">更新日期</th>
        </tr>
    </thead>
</table>
<div id="itemParamEditWindow" class="easyui-window" title="编辑商品" data-options="modal:true,closed:true,iconCls:'icon-save',href:'/item-param-edit'" style="width:80%;height:80%;padding:10px;">
</div>
<script>

	function formatItemParamData(value , index){
		var json = JSON.parse(value);
		var array = [];
		$.each(json,function(i,e){
			array.push(e.group);
		});
		return array.join(",");
	}

    function getSelectionsIds(){
    	var itemList = $("#itemParamList");
    	var sels = itemList.datagrid("getSelections");
    	var ids = [];
    	for(var i in sels){
    		ids.push(sels[i].id);
    	}
    	ids = ids.join(",");
    	return ids;
    }
    
    var itemParamListToolbar = [{
        text:'新增',
        iconCls:'icon-add',
        handler:function(){
        	TAOTAO.createWindow({
        		url : "/item-param-add",
        	});
        }
    },{
        text:'编辑',
        iconCls:'icon-edit',
        handler:function(){
            var ids = getSelectionsIds();
            if(ids.length == 0){
                $.messager.alert('提示','必须选择一个商品才能编辑!');
                return ;
            }
            if(ids.indexOf(',') > 0) {
                $.messager.alert('提示', '只能选择一个商品!');
                return;
            }
            $("#itemParamEditWindow").window({
                onLoad :function(){
                    //回显数据
                    var data = $("#itemParamList").datagrid("getSelections")[0];
                    $("#itemParamEditForm").form("load",data);
                            //回显商品规格
                            var paramData = JSON.parse(data.paramData);
                            var html = "<table cellpadding=\"5\" style=\"margin-left: 30px\" id=\"itemParamAddTable\" class=\"itemParam\"><tbody>";
                            html+="<tr class=\"addGroupTr\">";
                            html+="<td>规格参数:</td>";
                            html+="<td><ul><li><a href=\"javascript:void(0)\" class=\"easyui-linkbutton addGroup\">添加分组</a></li>";
                            html+="<li class=\"param\"><ul><li>";
                            for(var i in paramData){
                                var pd = paramData[i];
                                html+="<input class=\"easyui-textbox\" style=\"width: 150px;\" name=\"group\" value='"+pd.group+"'/><a href=\"javascript:void(0)\" class=\"easyui-linkbutton addParam\"  title=\"添加参数\" data-options=\"plain:true,iconCls:'icon-add'\"></a></li>";
                                for(var j in pd.params){
                                    var ps = pd.params[j];
                                    html+="<li>";
                                    html+="<span>|-------</span><input  style=\"width: 150px;\" class=\"easyui-textbox\" name=\"param\"/>"+ps+"<a href=\"javascript:void(0)\" class=\"easyui-linkbutton delParam\" title=\"删除\" data-options=\"plain:true,iconCls:'icon-cancel'\"></a></li>";
                                    html+="</ul></li></ul></td></tr></tbody></table>"
                                }

                            }
                            html+= "</ul>";
                            $("#itemParamEditForm .params td").eq(1).html(html);

                    TAOTAO.init({
                        "itemCatId" : data.itemCatId,
                        fun:function(node){
                            TAOTAO.changeItemParam(node, "itemeEditForm");
                        }
                    });
                    $(".addGroup").click(function(){
                        var temple = $(".itemParamAddTemplate li").eq(0).clone();
                        $(this).parent().parent().append(temple);
                        temple.find(".addParam").click(function(){
                            var li = $(".itemParamAddTemplate li").eq(2).clone();
                            li.find(".delParam").click(function(){
                                $(this).parent().remove();
                            });
                            li.appendTo($(this).parentsUntil("ul").parent());
                        });
                        temple.find(".delParam").click(function(){
                            $(this).parent().remove();
                        });
                    });
                }
            }).window("open");
        }
    },{
        text:'删除',
        iconCls:'icon-cancel',
        handler:function(){
        	var ids = getSelectionsIds();
        	if(ids.length == 0){
        		$.messager.alert('提示','未选中商品规格!');
        		return ;
        	}
        	$.messager.confirm('确认','确定删除ID为 '+ids+' 的商品规格吗？',function(r){
        	    if (r){
        	    	var params = {"ids":ids};
                	$.post("/item/param/delete",params, function(data){
            			if(data.state == 200){
            				$.messager.alert('提示','删除商品规格成功!',undefined,function(){
            					$("#itemParamList").datagrid("reload");
            				});
            			}
            		});
        	    }
        	});
        }
    }];
</script>