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
									formatter : function(value, row, index) {
										return index + 1;
									}
								},
								{
									field : 'orderCode',
									align : 'center',
									title : '订单编码'
								},
								{
									field : 'orderName',
									align : 'center',
									title : '订单名称'
								},
								{
									field : 'orderClient',
									align : 'center',
									title : '客戶名称'
								},
								{
									field : 'orderRate',
									align : 'center',
									title : '订单价格'
								},
								{
									field : 'orderFollow',
									align : 'center',
									title : '订单负责人'
								},{
									field : 'orderState',
									align : 'center',
									title : '订单状态',
									formatter : function(value){
										return GetOrderState(value);
									}
								},{
									field : 'orderType',
									align : 'center',
									title : '订单进度',
									formatter : function(value){
										return GetOrderType(value);
									}
								},{
									field : 'payState',
									align : 'center',
									title : '支付状态',
									formatter : function(value){
										return GetPayState(value);
									}
								},{
									field : 'createTime',
									align : 'center',
									title : '下单时间',
									formatter : function(value){
										 var date = new Date(value);
										 return date.getFullYear()+"-"+(date.getMonth())+"-"+date.getDate()+" "+date.getHours()+":"+date.getMinutes()+":"+date.getSeconds();
									}
								},{
									field : 'orderRemark',
									align : 'center',
									title : '备注'
								},
								{
									title : '操作',
									field : '',
									align : 'center',
									formatter : function(value, row, index) {
										return '<button class="btn btn-primary" onclick="UpdateButtonChange(this)">编辑</button>';
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
		var param = {
			limit : params.limit, // 页面大小
			offset : params.offset, // 页码
			orderCode : $("#orderCodeSerch").val(),
			orderClient : $("#orderClientSerch").val()
		};
		$("#tb_departments").bootstrapTable("refresh", param);

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
		alert(obj.usid);
		alert(data.orderOwner);
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
		   }
		});
	});
});

function UpdateButtonChange(_this){
	if(!ButtonFlag){
		$(_this).html("更新");
		$(_this).css("background","Gold");
		ButtonFlag = true;	
	}else{
		$(_this).html("編輯");
		$(_this).css("background","#337ab7");
		ButtonFlag = false;	
	}
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

function FormatDate (strTime) {
    var date = new Date(strTime);
    return date.getFullYear()+"-"+(date.getMonth()+1)+"-"+date.getDate();
}

function GetOrderState(value){
	var e = '<select style="border: 0; background: transparent;"><option value="0" select="select">新建</option>'+
		'<option value="1">进行中</option>'+
		'<option value="2">取消</option>'+
		'<option value="3">已完成</option></select>';
switch(value){
	case 0 :
		e = '<select style="border: 0; background: transparent;"><option value="0" select="select">新建</option>'+
			'<option value="1">进行中</option>'+
			'<option value="2">取消</option>'+
			'<option value="3">已完成</option></select>';
		return e;
	case 1 :
		e = '<select style="border: 0; background: transparent;"><option value="0">新建</option>'+
			'<option value="1" select="select">进行中</option>'+
			'<option value="2">取消</option>'+
			'<option value="3">已完成</option></select>';
		return e;
	case 2 :
		e = '<select style="border: 0; background: transparent;"><option value="0">新建</option>'+
			'<option value="1">进行中</option>'+
			'<option value="2" select="select">取消</option>'+
			'<option value="3">已完成</option></select>';
		return e;
	case 3 :
		e = '<select><option value="0">新建</option>'+
			'<option value="1">进行中</option>'+
			'<option value="2">取消</option>'+
			'<option value="3" select="select">已完成</option></select>';
		return e;
	default : 
		return e;
	}
}

function GetOrderType(value){
	var e = '<select style="border: 0; background: transparent;"><option value="0" select="select">选题</option>'+
		'<option value="1">开题</option>'+
		'<option value="2">初稿</option>'+
		'<option value="3">定稿</option>'+
		'<option value="4">盲审</option>'+
		'<option value="5">答辩</option></select>';
switch(value){
	case 0 :
		e = '<select style="border: 0; background: transparent;"><option value="0" select="select">选题</option>'+
			'<option value="1">开题</option>'+
			'<option value="2">初稿</option>'+
			'<option value="3">定稿</option>'+
			'<option value="4">盲审</option>'+
			'<option value="5">答辩</option></select>';
		return e;
	case 1 :
		e = '<select style="border: 0; background: transparent;"><option value="0" select="select">选题</option>'+
			'<option value="1" select="select">开题</option>'+
			'<option value="2">初稿</option>'+
			'<option value="3">定稿</option>'+
			'<option value="4">盲审</option>'+
			'<option value="5">答辩</option></select>';
		return e;
	case 2 :
		e = '<select style="border: 0; background: transparent;"><option value="0">选题</option>'+
			'<option value="1">开题</option>'+
			'<option value="2" select="select">初稿</option>'+
			'<option value="3">定稿</option>'+
			'<option value="4">盲审</option>'+
			'<option value="5">答辩</option></select>';
		return e;
	case 3 :
		e = '<select style="border: 0; background: transparent;"><option value="0">选题</option>'+
			'<option value="1">开题</option>'+
			'<option value="2">初稿</option>'+
			'<option value="3" select="select">定稿</option>'+
			'<option value="4">盲审</option>'+
			'<option value="5">答辩</option></select>';
		return e;
	case 4 :
		e = '<select style="border: 0; background: transparent;"><option value="0">选题</option>'+
			'<option value="1">开题</option>'+
			'<option value="2">初稿</option>'+
			'<option value="3">定稿</option>'+
			'<option value="4" select="select">盲审</option>'+
			'<option value="5">答辩</option></select>';
		return e;
	case 5 :
		e = '<select style="border: 0; background: transparent;"><option value="0">选题</option>'+
			'<option value="1">开题</option>'+
			'<option value="2">初稿</option>'+
			'<option value="3">定稿</option>'+
			'<option value="4">盲审</option>'+
			'<option value="5" select="select">答辩</option></select>';
		return e;
	default :
		return e;
}
}

function GetPayState(value){
	var e = '<select style="border: 0; background: transparent;"><option value="0" select="select">未付款</option>'+
		'<option value="1">已付款</option>'+
		'<option value="2">退款中</option>'+
		'<option value="3">已退款</option></select>';
switch(value){
	case 0 :
		e = '<select style="border: 0; background: transparent;"><option value="0" select="select">未付款</option>'+
			'<option value="1">已付款</option>'+
			'<option value="2">退款中</option>'+
			'<option value="3">已退款</option></select>';
		return e;
	case 1 :
		e = '<select style="border: 0; background: transparent;"><option value="0">未付款</option>'+
			'<option value="1" select="select">已付款</option>'+
			'<option value="2">退款中</option>'+
			'<option value="3">已退款</option></select>';
		return e;
	case 2 :
		e = '<select style="border: 0; background: transparent;"><option value="0">未付款</option>'+
			'<option value="1">已付款</option>'+
			'<option value="2" select="select">退款中</option>'+
			'<option value="3">已退款</option></select>';
		return e;
	case 3 :
		e = '<select><option value="0">未付款</option>'+
			'<option value="1">已付款</option>'+
			'<option value="2">退款中</option>'+
			'<option value="3" select="select">已退款</option></select>';
		return e;
	default :
		return e;
}
}