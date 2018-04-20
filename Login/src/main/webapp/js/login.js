    var code;
    var check_yanzhengma=0;
    var check_username1=0;
    var check_password1=0; //不知道为什有时候么onblur不执行，有时候用这种方法会判断不了，暂时没有找到原因 //原因是函数与变量同名，浏览器不知道执行的是哪个，修改名字后成功
	function yanzhengma(){
		code = ""; 
		var codeLength = 4;//验证码的长度 
		var checkCode = document.getElementById("yanzhengma"); 
		var random = new Array(0,1,2,3,4,5,6,7,8,9,'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R', 
		'S','T','U','V','W','X','Y','Z');//随机数 
		for(var i = 0; i < codeLength; i++) {//循环操作 
		var index = Math.floor(Math.random()*36);//取得随机数的索引（0~35） 
		code += random[index];//根据索引取得随机数加到code上 
		
		} 
		var text = code;
		var description = document.getElementById("yanzhengma");
		description.firstChild.nodeValue = text;
	}
	window.onload = yanzhengma;
	//checkCode.value = code;//把code值赋给验证码 
//校验验证码 
function check(){ 
var inputCode = document.getElementById("yanzheng").value.toUpperCase(); //取得输入的验证码并且取大写
if(inputCode.length <= 0) { //若输入的验证码长度为0 
	check_yanzhengma=0;
} 
else if(inputCode != code ) { //若输入的验证码与产生的验证码不一致时 
alert("验证码输入错误"); //则弹出验证码输入错误 
yanzhengma();//刷新验证码 
document.getElementById("yanzheng").value = "";//清空文本框 
} 
else { //输入正确时 
	check_yanzhengma =1;
}
} 

function login() {
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
		if( th.yanzheng.value == "") {
			alert("请输入验证码");
			th.yanzheng.focus();
			return false;
		}
		return true;
	}
function countDown(secs,surl){        
	  var login = document.getElementById('login');
	  login.innerHTML=secs;  
	  if(--secs>0){     
	      setTimeout("countDown("+secs+",'"+surl+"')",1000);     
	      }     
	  else{       
	      location.href=surl;     
	  }  
}