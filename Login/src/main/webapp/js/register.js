var checkname=false;
var checkemail=true;

$(document).ready(function(){
    //异步验证
    $("#postemail").click(function(){
    	if($("#email").val()!=""){
    		//alert("test");
    		$.post("postemail",{email:$("#email").val()},
             function(data){
                 if(data=="true"){
                     //如果已经存在，提示账号已经被注册
                     $("#emailtext").html("已经发送验证码，请填写验证码");
                     checkemail=true;
                 }else{
                     //这里可以注册的可以不进行提示,清空即可
                     $("#emailtext").html("验证码发送失败，请稍后重试");
                     checkemail=false;
                     $("#displayemail").show();
                 }
         },"text");
    	}
     });
 });

//隐藏邮箱的验证功能
$(document).ready(function(){
	$("#displayemail").hide()
});

function register() {
	var th = document.form3;
	if (th.email.value == "") {
		alert("邮箱不能为空！！");
		th.email.focus();
		return false;
	}
	if (th.username.value == "") {
		alert("登录帐号不能为空！！");
		th.username.focus();
		return false;
	}
	if (th.password.value == "") {
		alert("登录密码不能为空！！");
		th.password.focus();
		return false;
	}
	if (checkname == true ) {
		alert("请使用另外一个账号注册！！！");
		th.username.focus();
		return false;
	}
	if (checkemail == false ) {
		alert("该邮箱已经注册！！！");
		//th.email.focus();
		return false;
	}
	return true;
}
//异步验证账号是否重复
$(document).ready(function(){
	        //异步验证
	        $("#username").blur(function(){
	        	if($(this).val()!=""){
	        		 $.post("addAjax",{username:$(this).val()},
	    	                 function(data){
	    	                     if(data=="true"){
	    	                         //如果已经存在，提示账号已经被注册
	    	                         $("#usernametext").html("×账号已存在");
	    	                         checkname=true;
	    	                     }else{
	    	                         //这里可以注册的可以不进行提示,清空即可
	    	                         $("#usernametext").html("√账号可以使用");
	    	                         checkname=false;
	    	                     }
	        		
	             },"text");
	        	}
	         });
	     });
//异步验证邮箱是否注册
$(document).ready(function(){
    //异步验证
	
    $("#email").blur(function(){
    	if($(this).val()!=""){
    		$.post("addEmailAjax",{email:$(this).val()},
             function(data){
                 if(data=="true"){
                     //如果已经存在，提示账号已经被注册
                     $("#emailtext").html("邮箱已经注册，请用这个邮箱登陆");
                 }else{
                     //这里可以注册的可以不进行提示,清空即可
                     $("#emailtext").html("√该邮箱可以注册");
                     $("#displayemail").show()
                 }
         },"text");
	}
 });
});

//3秒自动跳转
function countDown(secs,surl){        
	  var regester = document.getElementById('regester');
	  regester.innerHTML=secs;  
	  if(--secs>0){     
	      setTimeout("countDown("+secs+",'"+surl+"')",1000);     
	      }     
	  else{       
	      location.href=surl;     
	  }  
}