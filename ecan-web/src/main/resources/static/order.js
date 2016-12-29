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
									title : '序号',
									formatter : function(value, row, index) {
										return index + 1;
									}
								},
								{
									field : 'orderCode',
									title : '订单编码'
								},
								{
									field : 'orderName',
									title : '订单名称'
								},
								{
									field : 'orderClient',
									title : '客戶名称'
								},
								{
									field : 'orderRate',
									title : '订单价格'
								},
								{
									field : 'orderFollow',
									title : '订单负责人'
								},{
									field : 'orderState',
									title : '订单状态',
									formatter : function(value){
										console.log(value);
										switch(value){
											case 0 :
												return "新建";
											case 1 :
												return "进行中";
											case 2 :
												return "取消";
											case 4 :
												return "已完成";
										}
									}
								},{
									field : 'orderType',
									title : '订单进度'
								},{
									field : 'createTime',
									title : '下单时间'
								},{
									field : 'remarks',
									title : '备注'
								},
								{
									title : '操作',
									field : '',
									align : 'center',
									formatter : function(value, row, index) {
										var e = '<button class="btn btn-primary" onclick="edit(\''
												+ row.id + '\')">编辑</button>&nbsp;&nbsp;';
										var d = '<button class="btn btn-primary" onclick="del(\''
												+ row.id + '\')">删除</button> ';
										return e + d;
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
		var obj = JSON.parse($.cookie('user'));
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
		   }
		});
	});
});

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

