$(function(){
	EL_Number();
	EL_NumberOrLetter();
	EL_WordAndSymbol();
})

//数字入力check
function EL_Number() {
	var el = /^[0-9]*$/;
	$('.el_number').bind('input propertychange',function() {
		var _val = $(this).val();
		var bol = el.test(_val);
		if (!bol) {
			$(this).next().show();
			$(this).val(_val.substr(0,_val.length-1));
		}
	});
}
//数字和字母(不区分大小写)入力check
function EL_NumberOrLetter() {
	var el = /^[A-Za-z0-9]*$/;
	$('.el_numberorletter').bind('input propertychange',function() {
		var _val = $(this).val();
		var bol = el.test(_val);
		if (!bol) {
			$(this).next().show();
			$(this).val(_val.substr(0,_val.length-1));
		}
	});
}

//只能输入汉字和标点符号check
function EL_WordAndSymbol() {
	var el = /^[\u4E00-\u9FA5]+$/;
	$('.el_word').bind('input propertychange',function() {
		var _val = $(this).val();
		var bol = el.test(_val);
		if (!bol) {
			$(this).next().show();
			$(this).val(_val.substr(0,_val.length-1));
		}
	});
}