function clickTest(){
    	alert("test");
    	var user = document.getElementById("iframeContent");
    	var userSrc = user.getAttribute("src");
    	user.setAttribute("src","userjsp");
    }
    
    function user(){
    	var user = document.getElementById("iframeContent");
    	var userSrc = user.getAttribute("src");
    	user.setAttribute("src","userjsp");
    }

    function dept(){
    	alert("test");
    }

    function job(){
    	var user = document.getElementById("iframeContent");
    	var userSrc = user.getAttribute("src");
    	user.setAttribute("src","jobjsp");
    }

    function employee(){
    	var user = document.getElementById("iframeContent");
    	var userSrc = user.getAttribute("src");
    	user.setAttribute("src","employeejsp");
    }

    function notice(){
    	var user = document.getElementById("iframeContent");
    	var userSrc = user.getAttribute("src");
    	user.setAttribute("src","noticejsp");
    }

    function doc(){
    	var user = document.getElementById("iframeContent");
    	var userSrc = user.getAttribute("src");
    	user.setAttribute("src","docjsp");
    }