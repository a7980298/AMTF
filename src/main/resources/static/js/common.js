var CONTEXT_PATH = "/amtf";
var TARGET = "_self";

//添加错误信息，并改变颜色
function setErrList(errlist) {
	$('.errlist').remove();
	$('.errclass').removeClass('errclass');
	if (errlist.length > 0) {
		var lists = errlist.split(',');
		for (var i = 0; i < lists.length; i++) {
			var _id = lists[i].substring(lists[i].indexOf('name:') + 5,lists[i].indexOf('}'));
			var _val = lists[i].substring(lists[i].indexOf('err:') + 4,lists[i].indexOf('+'));
			/*if ($('input[name=' + _id + ']').parent().hasClass('parentClass')) {
				$('input[name=' + _id + ']').parent().after("<div id='" + _id + "_err' class='errlist' style='color:red;'><span>" + _val + "</span></div>");
			} else {
				$('input[name=' + _id + ']').after("<div id='" + _id + "_err' class='errlist' style='color:red;'><span>" + _val + "</span></div>");
			}*/
			$('input[name=' + _id + ']').addClass('errclass');
			$('input[name=' + _id + ']').css('background-image','linear-gradient(0deg,red 2px,rgba(156,39,176,0) 0),linear-gradient(0deg,#d2d2d2 1px,hsla(0,0%,82%,0) 0)');
			$('#errlist').text(_val);
			$('#errlist').css('border','1px solid');
			/*alert(_val);*/
		}
	}
}
// 输入正确删除err提示
function blurSetInputTextVal(){
	$("input").on('change',function(){
		var _id = this.id;
		if ($('#' + _id + '-error').text() == '') {
			$('#' + _id + '-error').remove();
		}
	})
	$("input").on('blur',function(){
		var _id = this.id;
		if ($('#' + _id + '-error').text() == '') {
			$('#' + _id + '-error').remove();
		}
	})
}

// jq输入校验
function setFormValidation(id) {
	$(id).validate({
		highlight: function(element) {
			$(element).closest('.form-group').removeClass('has-success').addClass('has-danger');
			$(element).closest('.form-check').removeClass('has-success').addClass('has-danger');
		},
		success: function(element) {
			$(element).closest('.form-group').removeClass('has-danger').addClass('has-success');
			$(element).closest('.form-check').removeClass('has-danger').addClass('has-success');
		},
		errorPlacement: function(error, element) {
			if(error.text() != ''){
				if($(element).parent().hasClass('d-flex')) {
					$(element).parent().parent().after(error);
				} else {
					$(element).closest("input").after(error);
				}
			} else {
				$(element).find('lable').eq(0).remove();
			}
		},
	});
}

//监听页面直接关闭
function myFunction(){
	/* $.session.remove('loginfo');
	$.session.get('key'); */
	/*$.ajax({
		url: CONTEXT_PATH + '/f010002/T001',
		type: 'post',
		dateType: 'html',
		async: true,
		data: {},
		success: function (result) {},
		error: function (res, textStaus) {},
	});*/
}

//表单提交
function amtf_submit(form,action) {
	form.action = CONTEXT_PATH + action;
	form.target = TARGET;
	form.submit();
}
//表单提交新打开一个页面
function amtf_submitNew(form,action) {
	form.action = CONTEXT_PATH + action;
	form.target = '_blank';
	form.submit();
}

//表单提交(管理页面)
function amtf_submitAdmin(form,action) {
	form.action = CONTEXT_PATH + action;
	form.target = '_blank';
	form.submit();
}

//打开模态框显示错误信息
function setCodeErrList(codeErrList){
	if (codeErrList != null && codeErrList != '') {
		swal({
			title: codeErrList,
			text: "",
			type: "warning",
			showCancelButton:false,
			closeOnConfirm:false,
			confirmButtonText:"确认",
			cancelButtonText:"",
			animation: "",
			inputPlaceholder: ""
		},
		function () {});
		$('.swal2-container').css('z-index','9999999999');
	}
}

//打开模态框显示成功信息
function setCodeSuccess(codeSuccess){
	if (codeSuccess != null && codeSuccess != '') {
		if (codeSuccess != null && codeSuccess != '') {
			swal({
				title: codeSuccess,
				text: "",
				type: "input",
				showCancelButton:false,
				closeOnConfirm:false,
				confirmButtonText:"确认",
				cancelButtonText:"",
				animation: "",
				inputPlaceholder: ""
			},
			function () {});
			$('.swal2-container').css('z-index','9999999999');
		}
	}
}
////关闭遮罩
//function evenOff(){
//	$('#myModal_wait').removeClass('show');
//	$('button').removeAttr('disabled');
//	$('body').css('pointer-events','');
//	$('#myModal_wait').attr('aria','true');
//}
////打开遮罩
//function evenOn(){
//	$('#myModal_wait').modal('show');
//	$('button').attr('disabled','disabled');
//	$('body').css('pointer-events','none');
//}
//打开遮罩
function showdiv() {
	document.getElementById("loding_div").style.display ="block";
	//禁用滚动条
	/*var top = $(document).scrollTop();
	$(document).on('scroll.unable',function (e) {
		$(document).scrollTop(top);
	})*/
}
//关闭遮罩
function hidediv() {
	document.getElementById("loding_div").style.display ='none';
	//取消禁用滚动条
	/*$(document).unbind("scroll.unable");*/
}
// 打开跳转页面遮罩
function loginshowdiv() {
	document.getElementById("loginstop").style.display ="block";
}
//关闭跳转页面遮罩
function loginhidediv() {
	document.getElementById("loginstop").style.display ='none';
}
//全局不可點擊
function htmlEvenOff(_id){
	$('button').attr('disabled','disabled');
	$('body').css('pointer-events','none');
	$('#' + _id).removeAttr('disabled');
	$('#' + _id).css('pointer-events','');
}
//全局可點擊
function htmlEvenOn(_id){
	$('button').removeAttr('disabled');
	$('body').css('pointer-events','');
}
//上传图片
function initFileInput(ctrlName, uploadUrl) {
	var control = $('#' + ctrlName);
	control.fileinput({
		resizeImage : true,
		maxImageWidth : 200,
		maxImageHeight : 200,
		resizePreference : 'width',
		language : 'zh', //设置语言
		uploadUrl : uploadUrl,
		uploadAsync : true,
		allowedFileExtensions : [ 'jpg', 'png', 'gif' ],//接收的文件后缀
		showUpload : false, //是否显示上传按钮
		showCaption : true,//是否显示标题
		browseClass : "btn btn-primary", //按钮样式
		previewFileIcon : "<i class='glyphicon glyphicon-king'></i>",
		maxFileCount : 3,
		msgFilesTooMany : "选择图片超过了最大数量",
		maxFileSize : 2000,
		layoutTemplates:{
			actionDelete: '',//去除上传预览的缩列图中的删除图标	
			actionUpload: '',//去除上传预览的缩列图中的上传图标	
			actionZoom: '',//去除上传预览的缩列图中的预览图标	
		},
		uploadExtraData: function(previewId, index) {//额外参数的关键点
			var data = {
				messageTitle : $("#messageTitle").val(),
			};
			return data;
		},
	}).on('fileuploaded', function (event, data) {//异步上传成功结果处理
		if(data.name != ''){
			
		}
	})/*.on('filebatchpreupload', function(event, data) {
		if($("#messageTitle").val()==''|| $("#messageTitle").val()==null){ 
			return {
				message: "上传失败，请填写标题！", 
				data:{} 
			};
		}else{
				var n = data.files.length, files = n > 1 ? n + '个文件' : '1个文件';
				if (!window.confirm("确定上传 " + files + "?")) {
					return {
						message: "上传取消!!", // upload error message
						data:{} // any other data to send that can be referred in `filecustomerror`
					};
				}else{
					if(data.success==false){
						return {
						message: data.error, // upload error message
						data:{} // any other data to send that can be referred in `filecustomerror`
					};
				}
			}
		}
	});*/
};

// 仅显示图片和选择按钮
function initFileInputCommit(ctrlName, uploadUrl) {
	var control = $('#' + ctrlName);
	control.fileinput({
		resizeImage : true,
		maxImageWidth : 80,
		maxImageHeight : 80,
		resizePreference : 'width',
		language : 'zh', //设置语言
		uploadUrl : uploadUrl,
		uploadAsync : true,
		allowedFileExtensions : [ 'jpg', 'png', 'gif' ],//接收的文件后缀
		showUpload : false, //是否显示上传按钮
		showCaption : false,//是否显示标题
		dropZoneEnabled: false,
		browseClass : "btn", //按钮样式
		previewFileIcon : "<i class='glyphicon glyphicon-king'></i>",
		maxFileCount : 3,
		msgFilesTooMany : "选择图片超过了最大数量",
		maxFileSize : 2000,
		layoutTemplates:{
			actionDelete: '',//去除上传预览的缩列图中的删除图标	
			actionUpload: '',//去除上传预览的缩列图中的上传图标	
			actionZoom: '',//去除上传预览的缩列图中的预览图标	
		},
		uploadExtraData: function(previewId, index) {//额外参数的关键点
			var data = {
				messageTitle : $("#messageTitle").val(),
			};
			return data;
		},
	}).on('fileuploaded', function (event, data) {//异步上传成功结果处理
		if(data.name != ''){
			
		}
	})
};

//根据浏览器获取图片路径
function getObjectURL(file) {
	var url = null ;
	if (window.createObjectURL!=undefined) {
		// basic
		url = window.createObjectURL(file) ;
	} else if (window.URL!=undefined) {
		// mozilla(firefox) 火狐
		url = window.URL.createObjectURL(file) ;
	} else if (window.webkitURL!=undefined) {
		// webkit or chrome 谷歌
		url = window.webkitURL.createObjectURL(file) ;
	}
	return url ;
}
// 手机端判断
function isMobile() {
	var userAgentInfo = navigator.userAgent;

	var mobileAgents = ["Android", "iPhone", "SymbianOS", "Windows Phone", "iPad", "iPod"];

	var mobile_flag = false;

	//根据userAgent判断是否是手机
	for (var v = 0; v < mobileAgents.length; v++) {
		if (userAgentInfo.indexOf(mobileAgents[v]) > 0) {
			mobile_flag = true;
			break;
		}
	}
	var screen_width = window.screen.width;
	var screen_height = window.screen.height;

	//根据屏幕分辨率判断是否是手机
	if (screen_width < 500 && screen_height < 800) {
		mobile_flag = true;
	}

	return mobile_flag;
}
//日历控件生成
$(document).ready(function() {
	md.initFullCalendar();
});

// 日历控件中文化
function getFullCalendar(_id){
	$('#' + _id).fullCalendar({
		theme: true,
		header: {
			left: 'prev,next today',
			center: 'title',
			right: 'month,agendaWeek,agendaDay'
		},
		monthNames: ["一月", "二月", "三月", "四月", "五月", "六月", "七月", "八月", "九月", "十月", "十一月", "十二月"],
		monthNamesShort: ["一月", "二月", "三月", "四月", "五月", "六月", "七月", "八月", "九月", "十月", "十一月", "十二月"],
		dayNames: ["周日", "周一", "周二", "周三", "周四", "周五", "周六"],
		dayNamesShort: ["周日", "周一", "周二", "周三", "周四", "周五", "周六"],
		today: ["今天"],
		firstDay: 1,
		buttonText: {
			today: '本月',
			month: '月',
			week: '周',
			day: '日',
			prev: '上一月',
			next: '下一月'
			// “xx周”是否可以被点击，默认false，如果为true则周视图“周几”被点击之后进入日视图。本地测试：没什么效果
		},
	})
}

// iso-8859-1转码为utf-8
function IsoTurnUtf8(str_ISO5589_1) {
	return decodeURI(escape(str_ISO5589_1));
}

// 下载显示
function getDownLoad(response) {
	// 文件（Blob）对象获取
	var blob = response.data;
	// 创建链接文件对象的URL
	var objectURL = window.URL.createObjectURL(blob);
	// <a>创建临时元素
	var _link = document.createElement('a');
	// 添加URL
	_link.href = objectURL;
	// 设置<a>的download属性（指定文件名）
	_link.download = IsoTurnUtf8(response.headers["content-disposition"].split("filename=")[1]);
	_link.hidden = true;
	// <a>向机体添加元素
	document.body.appendChild(_link);
	// 触发链接点击事件
	_link.click();
	// <a>删除元素
	document.body.removeChild(_link);
}

/* WebSocket 使用 */
var socket;
function openSocket(_user_email) {
	if (typeof (WebSocket) == "undefined") {
		console.log("您的浏览器不支持WebSocket");
	} else {
		console.log("您的浏览器支持WebSocket");
		//实现化WebSocket对象，指定要连接的服务器地址与端口  建立连接
		//等同于socket = new WebSocket("ws://localhost:8888/xxxx/im/25");
		//var socketUrl="${request.contextPath}/im/"+$("#userId").val();
		var socketUrl = "https://192.168.43.239:8080/amtf/imserver/" + _user_email;
		socketUrl = socketUrl.replace("https", "ws").replace("http", "ws");
		console.log(socketUrl);
		if (socket != null) {
			socket.close();
			socket = null;
		}
		socket = new WebSocket(socketUrl);
		//打开事件
		socket.onopen = function() {
			console.log("websocket已打开");
			//socket.send("这是来自客户端的消息" + location.href + new Date());
		};
		//获得消息事件
		socket.onmessage = function(msg) {
			var data;
			try{
				data = JSON.parse(msg.data);
				var userimg;
				if(data.fromUserId == ''){
					userimg = '/amtf/imgs/userimg.jpg';
				} else {
					userimg = '/amtf/istatic/' + data.fromUserId;
				}
				$('#chat_text').append("<li class='msgleft'><img class='ml-2' style='float: left;height:40px;' src='" + userimg +"'><p class='msgcard' style='float:left;'>"+ data.contentText +"</p></li>");
			} catch {
				var _entity = new Array(); 
				_entity =msg.data.split(',');
				if(_entity[0] != _user_email && _entity[0] != '连接成功'){
					var _istext = '';
					$('#adduser').find('span').each(function(){
						if($(this).text() == _entity[0]){
							_isimg = $(this).prev().attr('src');
							_istext = '1';
						}
					});
					if (_istext != '1') {
						var _imgpath;
						if(_entity[1] == ''){
							_imgpath = '/amtf/imgs/userimg.jpg';
						} else {
							_imgpath = '/amtf/istatic/' + _entity[1];
						}
						$('#adduser').append("<ul><li><a class='nav-link' href='#' onclick='amtf_getChat(this)'><img style='height:40px;' src='" + _imgpath + "'><span style='margin-left: 10px;'>" + _entity[0] + "</span></a></li></ul>");
					}
				}
			}
			console.log(msg.data);
			//发现消息进入    开始处理前端触发逻辑
		};
		//关闭事件
		socket.onclose = function() {
			console.log("websocket已关闭");
		};
		//发生了错误事件
		socket.onerror = function() {
			console.log("websocket发生了错误");
		}
	}
}
// 生成一个input标签
function getNewInput(name, value) {
	var tempInput = document.createElement("input");
	tempInput.type = "hidden";
	tempInput.name = name;
	tempInput.value = value;
	return tempInput;
}
// 根据name删除标签
function reomveNewInput(name){
	$('[name = '+ name +']').remove();
}
//转义字符还原成html字符
function htmlRestore(str){
	var s = "";
	if (str.length === 0) {
		return "";
	}
	s = str.replace(/&amp;/g, "&");
	s = s.replace(/&lt;/g, "<");
	s = s.replace(/&gt;/g, ">");
	s = s.replace(/&nbsp;/g, " ");
	s = s.replace(/&#39;/g, "\'");
	s = s.replace(/&quot;/g, "\"");
	return s;
}
//随机数
function getRandomInt(min,max){
	return Math.floor(Math.random()*(max-min+1))+min;
}