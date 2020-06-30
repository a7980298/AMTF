var CONTEXT_PATH = "/amtf";
var TARGET = "_self";

//添加错误信息，并改变颜色
function setErrList(errlist) {
	if (errlist.length > 0) {
		var lists = errlist.split(',');
		for (var i = 0; i < lists.length; i++) {
			var _id = lists[i].substring(lists[i].indexOf('name:') + 5,lists[i].indexOf('}'));
			var _val = lists[i].substring(lists[i].indexOf('err:') + 4,lists[i].indexOf('+'));
			$('input[name=' + _id + ']').css('border','1px solid red');
			$('input[name=' + _id + "]").after("<div id='"+_id+"_err' style='color:red;'><span>" + _val + "</span></div>");
		}
	}
}

//表单提交
function amtf_submit(form,action) {
	form.action = CONTEXT_PATH + action;
	form.target = TARGET;
	form.submit();
}

//打开modal模态框
function setCodeErrList(codeErrList){
	if (codeErrList != null && codeErrList != '') {
		$('#myModal_codeErr').modal('show');
	}
}

//打开modal模态框
function setCodeSuccess(CodeSuccess){
	if (CodeSuccess != null && CodeSuccess != '') {
		$('#myModal_success').modal('show');
	}
}
//关闭遮罩
function evenOff(){
	$('#myModal_wait').modal('hide');
	$('button').removeAttr('disabled');
	$('body').css('pointer-events','');
}
//打开遮罩
function evenOn(){
	$('#myModal_wait').modal('show');
	$('button').attr('disabled','disabled');
	$('body').css('pointer-events','none');
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
		showUpload : true, //是否显示上传按钮
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
	})
	
	/*.on('filebatchpreupload', function(event, data) {
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

	if (window.createObjectURL!=undefined) { // basic
		url = window.createObjectURL(file) ;
	} else if (window.URL!=undefined) { // mozilla(firefox) 火狐
		url = window.URL.createObjectURL(file) ;
	} else if (window.webkitURL!=undefined) { // webkit or chrome 谷歌
		url = window.webkitURL.createObjectURL(file) ;
	}
	return url ;
}