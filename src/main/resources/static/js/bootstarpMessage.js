function Message(type, message, duration = 2000, isClose = false) {
	if(type == 'success'){
		message = "<i class=\"fa fa-check\" style=\"color:white\"></i>" + message;
	} else if(type == 'error') {
		message = "<i class=\"fa fa-close\" style=\"color:white\"></i>" + message;
	}
	if (!message) {
		message = type;
	}
	let closeHTML = '';
	if (isClose) {
		closeHTML = '<a href="#" class="close" data-dismiss="alert">&times;</a>';
	}
	let messageHTML = '<div class="alert alert-warning fade in" style="position: fixed; top: 34px; left: 50%; min-width: 200px; text-align: center; z-index: 9999;">' +
		closeHTML + message +
		'</div>';
	//必须先放入body里，否则removeClass和addClass失效
	$('body').append(messageHTML);

	$('.alert').css('margin-left',-$('.alert').outerWidth()/2+"px");
	switch (type) {
		case 'success':
			success();
			break;
		case 'info':
			info();
			break;
		case 'warning':
			warning();
			break;
		case 'error':
			error();
			break;
		default:
			info();
	}
	delayClose(duration);
}

function success() {
	$('.alert').removeClass().addClass('alert alert-success');
}

function info() {
	$('.alert').removeClass().addClass('alert alert-info');
}

function warning() {
	$('.alert').removeClass().addClass('alert alert-warning');
}

function error() {
	$('.alert').removeClass().addClass('alert alert-danger');
}

//延迟两秒关闭
function delayClose(duration) {
	if (duration !== 0) {
		setTimeout(function () {
			$(".alert").alert('close');
		}, duration);
	}
}