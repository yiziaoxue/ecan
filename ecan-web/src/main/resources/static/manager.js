
$('#booking-tabs a').click(function (e) {
	  e.preventDefault()
	  $(this).tab('show')
});

$('#loginButton').click(function(){
	var data = {
		userPhone:$('#userPhone').val(),
		userPsd:$('#passWord').val()
	};
	$.ajax({
		url:'entrysystem/login',
		type: "post",
		data: data,
		dataType:'json',
		error: function(data) {
			console.log('登陸失敗,原因:'+data.resultMsg);
	    },
	    success: function(data) {
	    	if(data.resultCode == "0"){
		    	var str = JSON.stringify(data.data); 
			    $.cookie('user', str, new Date()+1/24/2, "/"); 
			    loadLoginMsg(data.data);
	    	}else{
	    		$('#loginModal').modal('show');
	    		console.log('登陸失敗,原因:'+data.resultMsg);
	    	}
	   }
	});
});

function jugdeLogin(){
	var str = $.cookie('user');
	if(!str){
		$('#loginModal').modal('show');
		return;
	}
	var obj = JSON.parse(str);
	if(obj.userPhone==null || obj.userPsd==null){
		$('#loginModal').modal('show');
	}else{
		var data = {
				userPhone:obj.userPhone,
				userPsd:obj.userPsd
		};
		$.ajax({
			url:'entrysystem/login',
			type: "post",
			data: data,
			dataType:'json',
			error: function(data) {
				$('#loginModal').modal('show');
		    },
		    success: function(data) {
		    	if(data.resultCode == "0"){
				    loadLoginMsg(data.data);
		    	}else{
		    		$('#loginModal').modal('show');
		    		console.log('登陸失敗,原因:'+data.resultMsg);
		    	}
		   }
		});
	}
};

$(document).ready(function(){
	jugdeLogin();
});

function loadLoginMsg(loginObj){
    $('#loginModal').modal('hide');
    $("#centerFrame").attr("src", "order.html");
    if(loginObj.userSex == 0)
    	$('#headImage').attr('src','images/head-man.png');
    else
    	$('#headImage').attr('src','images/head-girl.png');
    $('#headName').html(loginObj.userName);
}