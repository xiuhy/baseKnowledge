/*
 * Copyright (C), 2002-2017, bigmoon,All Rights Reserved.
 * FileName: Duotai.java
 * Author:   bigmoon
 * Date:     19-6-13 上午11:19
 * Description: baseKnowledge
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * bigmoon     19-6-13 上午11:19      版本号        描述
 */

package bigmoon.learning.basejava.innerClass;

//多态
public class Duotai {

	
	//对域的访问，没有多台态
	public static void main(String[] args){
		Sub superOb=new Sub();
		System.out.println(superOb.testMethod("22"));
		superOb.testMethod(22);
		Object cn= new Object();
		System.out.print(superOb.testMethod(cn));
	}
	
}
