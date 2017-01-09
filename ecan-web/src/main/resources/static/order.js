var ButtonFlag = false;
$(function() {
	$('#tb_departments').bootstrapTable(
					{
						url : 'entrysystem/getOrderDetail', // 请求后台的URL（*）
						method : 'post', // 请求方式（*）
//						toolbar : '#toolbar', // 工具按钮用哪个容器
						cache : false, // 是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
						pagination : true, // 是否显示分页（*）
						sortable : false, // 是否启用排序
//						sortOrder : "asc", // 排序方式
						queryParams : queryParams,// 传递参数（*）
						queryParamsType : "limit",
//						sidePagination : "client", // 分页方式：client客户端分页，server服务端分页（*）
						pageNumber : 1, // 初始化加载第一页，默认第一页
						pageSize : 10, // 每页的记录行数（*）
						pageList : [ 10, 25, 50, 100 ], // 可供选择的每页的行数（*）
//						showRefresh : true, // 是否显示刷新按钮
						clickToSelect : true, // 是否启用点击选中行
//						showToggle : true, // 是否显示详细视图和列表视图的切换按钮
						height : 610,
						uniqueId: 'usid',
						onLoadSuccess: function (data) {
				            if(data.resultCode == "-1"){
				            	console.log("订单查询失败");
				            	return null;
				            }
				        },
						columns : [
								{
									field : 'usid',
									align : 'center',
									title : '序号',
									width : '2%',
									formatter : function(value, row, index) {
										return index + 1;
									}
								},
								{
									field : 'orderCode',
									align : 'center',
									width : '5%',
									title : '订单编码'
								},
								{
									field : 'orderName',
									align : 'center',
									width : '5%',
									title : '订单名称'
								},
								{
									field : 'orderClient',
									align : 'center',
									width : '5%',
									title : '客戶名称'
								},
								{
									field : 'orderRate',
									align : 'center',
									width : '5%',
									title : '订单价格'
								},
								{
									field : 'orderFollow',
									align : 'center',
									width : '5%',
									title : '订单负责人'
								},{
									field : 'orderState',
									align : 'center',
									width : '5%',
									title : '订单状态',
									formatter : function(value, row, index){
										return GetOrderState(value, row, index);
									}
								},{
									field : 'orderType',
									align : 'center',
									width : '5%',
									title : '订单进度',
									formatter : function(value, row, index){
										return GetOrderType(value, row, index);
									}
								},{
									field : 'payState',
									align : 'center',
									width : '5%',
									title : '支付状态',
									formatter : function(value, row, index){
										return GetPayState(value, row, index);
									}
								},{
									field : 'orderBalance',
									align : 'center',
									width : '5%',
									title : '结算状态',
									formatter : function(value, row, index){
										return GetBalanceState(value, row, index);
									}
								},{
									field : 'createTime',
									align : 'center',
									width : '5%',
									title : '下单时间',
									formatter : function(value){
										 var date = new Date(value);
										 return date.getFullYear()+"-"+(date.getMonth())+"-"+date.getDate()+" "+date.getHours()+":"+date.getMinutes()+":"+date.getSeconds();
									}
								},{
									field : 'orderRemark',
									align : 'center',
									width : '10%',
									title : '备注'
								},
								{
									title : '操作',
									width : '6%',
									align : 'center',
									clickToSelect : true,
									formatter : function(value, row, index) {
										var e = '<button class="btn btn-primary" onclick="UpdateButtonChange(this,'+ row.usid +','+ index +')">更新</button>&nbsp;&nbsp;'+
												'<button class="btn btn-primary" onclick="DeleteButtonChange(this,'+ row.usid +','+ index +')">删除</button>';
										return e;
									}
								} ]
						/*onClickRow : function(row, $element) {
							// $element是当前tr的jquery对象
							if (isClick == false) {
								$element.css("background-color", "gray");
								isClick = true;
							} else{
								$element.css("background-color", "white");
								isClick = false;
							}
						}// 单击row事件
*/					});

	// 搜索
	$("#orderQuery").click(function(params) {
		$("#tb_departments").bootstrapTable("refresh");
	});
	// enter键搜索
	$("#searchKey").keydown(function(event) {
		if (event.keyCode == 13) {
			$("#orderQuery").click();
		}
	});
	
	$( "#datepicker" ).datepicker();
	
	$("#orderSave").click(function() {
		var str = $.cookie('user');
		var obj = JSON.parse(str);
		var data = $('#orderForm').serializeObject();
		data.orderOwner = obj.usid;
		$.ajax({
			url:'entrysystem/addOrder',
			type: "post",
			data: data,
			dataType:'json',
			error: function(data) {
				console.log("下单失败");
				$('#myModal').modal('hide');
		    },
		    success: function(data) {
		    	console.log("下单成功");
		    	$('#myModal').modal('hide');
		    	$("#orderQuery").click();
		   }
		});
	});
});

function UpdateButtonChange(_this,usid,index){
	var selects = $("#tb_departments").bootstrapTable('getRowByUniqueId',usid);
	var data = {
			usid : usid,
			orderState : selects.orderState,
			payState : selects.payState,
			orderType : selects.orderType,
			balanceState : selects.balanceState
		};
	UpdateOrderDate(data);
//	if(!ButtonFlag){
//		$(_this).html("更新");
//		$(_this).css("color","Gold");
//		$('.selectState'+ index).attr("disabled",false);
//		ButtonFlag = true;	
//	}else{
//		$(_this).html("编辑");
//		$(_this).css("color","white");
//		$('.selectState'+ index).attr("disabled",true);
//		ButtonFlag = false;	
//	}
}

function DeleteButtonChange(_this,usid,index){
	var selects = $("#tb_departments").bootstrapTable('getRowByUniqueId',usid);
	var data = {
		usid : usid,
		flag : 0
	};
	UpdateOrderDate(data);
	$("#tb_departments").bootstrapTable('hideRow', {index:index});
	$("#tb_departments").bootstrapTable("refresh");
}

function UpdateOrderDate(data){
	$.ajax({
		url:'entrysystem/updateOrder',
		type: "post",
		data: data,
		dataType:'json',
		error: function(data) {
			console.log("更新出错");
			$('#myModal').modal('hide');
	    },
	    success: function(data) {
	    	if(data.resultCode == "0"){
	    		console.log("更新成功");
	    		
	    	}else{
	    		console.log("更新失败");
	    	}
	   }
	});	
}

function queryParams(params) {
	var temp = { // 这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
		limit : params.limit, // 页面大小
		offset : params.offset, // 页码
		orderCode : $("#orderCodeSerch").val(),
		orderClient : $("#orderClientSerch").val()
	};
	return temp;
};


function ChangeSelect(id,_this,index){
	var value = $(_this).val();
	switch(id){
	case 1:
		$("#tb_departments").bootstrapTable('updateRow', { 
			index: index,  
		    row: {  
		    	orderState : parseInt(value)
		    }  
		});  
		break;
	case 2:
		$("#tb_departments").bootstrapTable('updateRow', { 
			index: index,  
		    row: {  
		    	orderType : parseInt(value)
		    }  
		});  
		break;
	case 3:
		$("#tb_departments").bootstrapTable('updateRow', { 
			index: index,  
		    row: {  
		    	payState : parseInt(value)
		    }  
		});  
		break;
	case 4:
		$("#tb_departments").bootstrapTable('updateRow', { 
			index: index,  
		    row: {  
		    	orderBalance : parseInt(value)
		    }  
		});  
		break;
	}
}

function FormatDate (strTime) {
    var date = new Date(strTime);
    return date.getFullYear()+"-"+(date.getMonth()+1)+"-"+date.getDate();
}

function GetOrderState(value, row, index){
	var e = '';
	switch(value){
		case 0 :
			e = '<select onChange="ChangeSelect(1,this,'+ index +')" style="border: 0; background: transparent;" class="selectState'+ index +'"><option value="0" selected = "selected">新建</option>'+
				'<option value="1">进行中</option>'+
				'<option value="2">取消</option>'+
				'<option value="3">已完成</option></select>';
			return e;
		case 1 :
			e = '<select onChange="ChangeSelect(1,this,'+ index +')" style="border: 0; background: transparent;" class="selectState'+ index +'"><option value="0">新建</option>'+
				'<option value="1" selected = "selected">进行中</option>'+
				'<option value="2">取消</option>'+
				'<option value="3">已完成</option></select>';
			return e;
		case 2 :
			e = '<select onChange="ChangeSelect(1,this,'+ index +')" style="border: 0; background: transparent;" class="selectState'+ index +'"><option value="0">新建</option>'+
				'<option value="1">进行中</option>'+
				'<option value="2" selected = "selected">取消</option>'+
				'<option value="3">已完成</option></select>';
			return e;
		case 3 :
			e = '<select onChange="ChangeSelect(1,this,'+ index +')" style="border: 0; background: transparent;" class="selectState'+ index +'"><option value="0">新建</option>'+
				'<option value="1">进行中</option>'+
				'<option value="2">取消</option>'+
				'<option value="3" selected = "selected">已完成</option></select>';
			return e;
		default : 
			return e;
	}
}

function GetOrderType(value, row, index){
	var e = '';
	switch(value){
		case 0 :
			e = '<select onChange="ChangeSelect(2,this,'+ index +')" style="border: 0; background: transparent;" class="selectState'+ index +'"><option value="0" selected = "selected">选题</option>'+
				'<option value="1">开题</option>'+
				'<option value="2">初稿</option>'+
				'<option value="3">定稿</option>'+
				'<option value="4">盲审</option>'+
				'<option value="5">答辩</option></select>';
			return e;
		case 1 :
			e = '<select onChange="ChangeSelect(2,this,'+ index +')" style="border: 0; background: transparent;" class="selectState'+ index +'"><option value="0">选题</option>'+
				'<option value="1" selected = "selected">开题</option>'+
				'<option value="2">初稿</option>'+
				'<option value="3">定稿</option>'+
				'<option value="4">盲审</option>'+
				'<option value="5">答辩</option></select>';
			return e;
		case 2 :
			e = '<select onChange="ChangeSelect(2,this,'+ index +')" style="border: 0; background: transparent;" class="selectState'+ index +'"><option value="0">选题</option>'+
				'<option value="1">开题</option>'+
				'<option value="2" selected = "selected">初稿</option>'+
				'<option value="3">定稿</option>'+
				'<option value="4">盲审</option>'+
				'<option value="5">答辩</option></select>';
			return e;
		case 3 :
			e = '<select onChange="ChangeSelect(2,this,'+ index +')" style="border: 0; background: transparent;" class="selectState'+ index +'"><option value="0">选题</option>'+
				'<option value="1">开题</option>'+
				'<option value="2">初稿</option>'+
				'<option value="3" selected = "selected">定稿</option>'+
				'<option value="4">盲审</option>'+
				'<option value="5">答辩</option></select>';
			return e;
		case 4 :
			e = '<select onChange="ChangeSelect(2,this,'+ index +')" style="border: 0; background: transparent;" class="selectState'+ index +'"><option value="0">选题</option>'+
				'<option value="1">开题</option>'+
				'<option value="2">初稿</option>'+
				'<option value="3">定稿</option>'+
				'<option value="4" selected = "selected">盲审</option>'+
				'<option value="5">答辩</option></select>';
			return e;
		case 5 :
			e = '<select onChange="ChangeSelect(2,this,'+ index +')" style="border: 0; background: transparent;" class="selectState'+ index +'"><option value="0">选题</option>'+
				'<option value="1">开题</option>'+
				'<option value="2">初稿</option>'+
				'<option value="3">定稿</option>'+
				'<option value="4">盲审</option>'+
				'<option value="5" selected = "selected">答辩</option></select>';
			return e;
		default :
			return e;
	}
}

function GetPayState(value, row, index){
	var e = '';
	switch(value){
		case 0 :
			e = '<select onChange="ChangeSelect(3,this,'+ index +')" style="border: 0; background: transparent;" class="selectState'+ index +'"><option value="0" selected = "selected">未付款</option>'+
				'<option value="1">开题已付款</option>'+
				'<option value="2">定稿已付款</option>'+
				'<option value="3">答辩已付款</option>'+
				'<option value="4">退款中</option>'+
				'<option value="5">已退款</option></select>';
			return e;
		case 1 :
			e = '<select onChange="ChangeSelect(3,this,'+ index +')" style="border: 0; background: transparent;" class="selectState'+ index +'"><option value="0">未付款</option>'+
				'<option value="1" selected = "selected">开题已付款</option>'+
				'<option value="2">定稿已付款</option>'+
				'<option value="3">答辩已付款</option>'+
				'<option value="4">退款中</option>'+
				'<option value="5">已退款</option></select>';
			return e;
		case 2 :
			e = '<select onChange="ChangeSelect(3,this,'+ index +')" style="border: 0; background: transparent;" class="selectState'+ index +'"><option value="0">未付款</option>'+
				'<option value="1">开题已付款</option>'+
				'<option value="2">定稿已付款</option>'+
				'<option value="3">答辩已付款</option>'+
				'<option value="4" selected = "selected">退款中</option>'+
				'<option value="5">已退款</option></select>';
			return e;
		case 3 :
			e = '<select onChange="ChangeSelect(3,this,'+ index +')" style="border: 0; background: transparent;" class="selectState'+ index +'"><option value="0">未付款</option>'+
				'<option value="1">开题已付款</option>'+
				'<option value="2">定稿已付款</option>'+
				'<option value="3">答辩已付款</option>'+
				'<option value="4">退款中</option>'+
				'<option value="5" selected = "selected">已退款</option></select>';
			return e;
		case 4 :
			e = '<select onChange="ChangeSelect(3,this,'+ index +')" style="border: 0; background: transparent;" class="selectState'+ index +'"><option value="0">未付款</option>'+
				'<option value="1">开题已付款</option>'+
				'<option value="2" selected = "selected">定稿已付款</option>'+
				'<option value="3">答辩已付款</option>'+
				'<option value="4">退款中</option>'+
				'<option value="5">已退款</option></select>';
			return e;
		case 5 :
			e = '<select onChange="ChangeSelect(3,this,'+ index +')" style="border: 0; background: transparent;" class="selectState'+ index +'"><option value="0">未付款</option>'+
				'<option value="1">开题已付款</option>'+
				'<option value="2">定稿已付款</option>'+
				'<option value="3" selected = "selected">答辩已付款</option>'+
				'<option value="4">退款中</option>'+
				'<option value="5">已退款</option></select>';
			return e;
		default :
			return e;
	}
}

function GetBalanceState(value, row, index){
	var e = '';
	switch(value){
		case 0 :
			e = '<select onChange="ChangeSelect(4,this,'+ index +')" style="border: 0; background: transparent;" class="selectState'+ index +'"><option value="0" selected = "selected">未结算</option>'+
				'<option value="1">开题已结算</option>'+
				'<option value="2">定稿已结算</option>'+
				'<option value="3">答辩已结算</option></select>';
			return e;
		case 1 :
			e = '<select onChange="ChangeSelect(4,this,'+ index +')" style="border: 0; background: transparent;" class="selectState'+ index +'"><option value="0">未结算</option>'+
				'<option value="1" selected = "selected">开题已结算</option>'+
				'<option value="2">定稿已结算</option>'+
				'<option value="3">答辩已结算</option></select>';
			return e;
		case 2 :
			e = '<select onChange="ChangeSelect(4,this,'+ index +')" style="border: 0; background: transparent;" class="selectState'+ index +'"><option value="0">未结算</option>'+
				'<option value="1">开题已结算</option>'+
				'<option value="2" selected = "selected">定稿已结算</option>'+
				'<option value="3">答辩已结算</option></select>';
			return e;
		case 3 :
			e = '<select onChange="ChangeSelect(4,this,'+ index +')" style="border: 0; background: transparent;" class="selectState'+ index +'"><option value="0">未结算</option>'+
				'<option value="1">开题已结算</option>'+
				'<option value="2">定稿已结算</option>'+
				'<option value="3" selected = "selected">答辩已结算</option></select>';
			return e;
		default : 
			return e;
	}
}
