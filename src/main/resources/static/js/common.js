var CONTEXT_PATH = "/amtf";
var TARGET = "_self";

function setErrList(errlist) {
	if (errlist.length > 0) {
		var lists = errlist.split(',');
		for (var i = 0; i < lists.length; i++) {
			var _id = lists[i].substring(lists[i].indexOf('name:') + 5,lists[i].indexOf('}'));
			var _val = lists[i].substring(lists[i].indexOf('err:') + 4,lists[i].indexOf('+'));
			$('input[name=' + _id + "]").after("<div style='color:red;'>" + _val + "</div>");
		}
	}
}

function amtf_submit(form,action) {
	form.action = CONTEXT_PATH + action;
	form.target = TARGET;
	form.submit();
}

function setCodeErrList(codeErrList){
	if (codeErrList != null && codeErrList != '') {
		$('#myModal_codeErr').modal('show');
	}
}

function amtf_fenye(form,thisid) {
	form.action = $(thisid).parent('#fenye').attr('action');
	form.target = TARGET;
	form.submit();
}