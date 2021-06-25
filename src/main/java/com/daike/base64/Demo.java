package com.daike.base64;

import java.util.Base64;

/**
 * Base64 Demo
 *
 * @author PigPig
 * @date 2021/06/21 14:37
 **/
public class Demo {

	public static void main(String[] args) {
		String originalInput = "贵州省22502石阡五德14520623铜仁27.4281108.3772但是只能读不能写：gdal.AllRegister () 单独注册某一类型的数据驱动，这样的话可以读也可以写";
		String originalInput2 = "贵州省22502石阡五德14520623铜仁27.4281108.3772但是只能读不能写：gdal.AllRegister () 单独注册某一类型的数据驱动，这样的话可以读也可以写";
		String encodedString = Base64.getEncoder().encodeToString(originalInput.getBytes());
		String encodedString2 = Base64.getEncoder().encodeToString(originalInput2.getBytes());
		System.out.println(encodedString);
		System.out.println(encodedString2);
		System.out.println(encodedString.equals(encodedString2));
	}

}
