function countDown(secs,surl){        
	  var regester = document.getElementById('regester');
	  regester.innerHTML=secs;  
	  if(--secs>0){     
	      setTimeout("countDown("+secs+",'"+surl+"')",1000);     
	      }     
	  else{       
	      location.href=surl;     
	  }  
};

var checkname=false;
var checkemail=true;

$(document).ready(function(){
    //发送邮件
    $("#postemail").click(function(){
    	if($("#email").val()!=""){
    		//alert("test");
    		$.post("postemail",{email:$("#email").val()},
             function(data){
                 if(data=="true"){
                     $("#emailtext").html("已经发送验证码，请填写验证码后提交，继续下一步操作");
                     checkemail=true;
                 }else{
                     $("#emailtext").html("验证码发送失败，请等等再发");
                     checkemail=false;
                 }
         },"text");
    	}
     });
 });

$(document).ready(function(){
    //验证密码是否一致
    $("#password3").click(function(){
    	if( $("#password").val()==$("#qpassword").val() ){
    		return true;
    	}
    	else{
    		alert("密码不一致，请重新确认");
    		return false;
    	}
    })
 });

/*function findpassword3(){
		if( ($("#password").val()!="") && ($("#password").val()==$("#qpassword").val() ) ){
			alter("密码一致");
			return true;
		}
		else{
			return false;
			alter("密码不一致");
		}
}*/
//3秒自动跳转
