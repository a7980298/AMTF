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
			$('input[name=' + _id + "]").after("<div style='color:red;'>" + _val + "</div>");
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