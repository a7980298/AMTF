$(function(){
	EL_Number();
})

//数字入力check
function EL_Number(){
	$('.el_number').change(function(){
		var el = /^[0-9]*$/;
		$('.el_number').bind('input propertychange',function(){
			var _val = $(this).val();
			var bol = el.test(_val);
			if (!bol) {
				$(this).next().show();
				$(this).val(_val.substr(0,_val.length-1));
			}
		});
	});
}
//数字和字母(不区分大小写)入力check
function EL_NumberOrLetter(){
	$('.el_numberorletter').change(function(){
		var el = /^[A-Za-z]+$ /;
		$('.el_numberorletter').bind('input propertychange',function(){
			var _val = $(this).val();
			var bol = el.test(_val);
			if (!bol) {
				$(this).next().show();
				$(this).val(_val.substr(0,_val.length-1));
			}
		});
	});
	
}