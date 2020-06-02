
var CONTEXT_PATH = "/amtf";

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

function amtf_submit(form,url,target) {
	form.action = CONTEXT_PATH + url;
	form.target = target;
	form.submit();
}