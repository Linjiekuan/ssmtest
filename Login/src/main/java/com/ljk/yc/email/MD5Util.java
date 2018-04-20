package com.ljk.yc.email;
public class MD5Util {
	public  String yanzhengma() {
		String yanzhengma="";
		java.util.Random r=new java.util.Random();
		yanzhengma+=r.nextInt();
		yanzhengma.substring(4);
        return yanzhengma;
}
}