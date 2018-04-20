//隔行变色
function SetTableColor() {
	var tbl = document.getElementById("tbl");
	var rows = tbl.rows.length;
	for(var i=1;i<rows;i++){
	 if(i%2 == 0){
	   tbl.rows[i].style.backgroundColor = "#FFC1C1";
		}
	 else{
		 tbl.rows[i].style.backgroundColor = "#FFE4E1";
		 
	 }
	  }
	}

function deleteDept(){
	confirm('确定要删除吗');
	
}

function addDept() {
		var th = document.form1;
		if (th.username.value == "") {
			alert("用户名不能为空！！");
			th.username.focus();
			return false;
		}
		if (th.password.value == "") {
			alert("密码不能为空！！");
			th.password.focus();
			return false;
		}
		return true;
	}

$(function ($) {
		//弹出登录
		$("#example").hover(function () {
			$(this).stop().animate({
				opacity: '1'
			}, 600);
		}, function () {
			$(this).stop().animate({
				opacity: '0.6'
			}, 1000);
		}).on('click', function () {
			$("body").append("<div id='mask'></div>");
			$("#mask").addClass("mask").fadeIn("slow");
			$("#LoginBox").fadeIn("slow");
		});
		//
		//按钮的透明度
		$("#loginbtn").hover(function () {
			$(this).stop().animate({
				opacity: '1'
			}, 600);
		}, function () {
			$(this).stop().animate({
				opacity: '0.8'
			}, 1000);
		});
		//文本框不允许为空---按钮触发
		$("#loginbtn").on('click', function () {
			var name = $("#name").val();
			var remark = $("#remark").val();
			if (name == "" || name == undefined || name == null) {
				if (remark == "" || remark == undefined || remark == null) {
					$(".warning").css({ display: 'block' });
				}
				else {
					$("#warn").css({ display: 'block' });
					$("#warn2").css({ display: 'none' });
				}
			}
			else {
				if (remark == "" || remark == undefined || remark == null) {
					$("#warn").css({ display: 'none' });
					$(".warn2").css({ display: 'block' });
				}
				else {
					$(".warning").css({ display: 'none' });
				}
			}
		});
		//文本框不允许为空---单个文本触发
		$("#txtName").on('blur', function () {
			var name = $("#name").val();
			if (name == "" || name == undefined || name == null) {
				$("#warn").css({ display: 'block' });
			}
			else {
				$("#warn").css({ display: 'none' });
			}
		});
		$("#name").on('focus', function () {
			$("#warn").css({ display: 'none' });
		});
		//
		$("#remark").on('blur', function () {
			var remark = $("#remark").val();
			if (remark == "" || remark == undefined || remark == null) {
				$("#warn2").css({ display: 'block' });
			}
			else {
				$("#warn2").css({ display: 'none' });
			}
		});
		$("#remark").on('focus', function () {
			$("#warn2").css({ display: 'none' });
		});
		//关闭
		$(".close_btn").hover(function () { $(this).css({ color: 'black' }) }, function () { $(this).css({ color: '#999' }) }).on('click', function () {
			$("#LoginBox").fadeOut("fast");
			$("#mask").css({ display: 'none' });
		});
	});