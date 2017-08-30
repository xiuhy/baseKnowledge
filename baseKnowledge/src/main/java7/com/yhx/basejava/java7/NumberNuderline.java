/*
 * Copyright (C), 2002-2017, 苏宁易购电子商务有限公司
 * FileName: NumberNuderline.java
 * Author:   17081794
 * Date:     2017年8月30日 下午1:10:21
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.yhx.basejava.java7;

/**
 *主要说在jdk7 中可以用下划线分割数字。目的为了让数字有更好的可读效果
 *  
 *  注意：
 *      1.只能再数字中才有这样效果
 *      2.不能再数字开头和结尾
 *      3.不能在小数点相邻加下划线(_)
 *      4.不能放在x或者l的前面或者后面
 *      5.不能破环前缀例如ox前缀
 * @author 17081794
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class NumberNuderline {

    /**
     * 功能描述: <br>
     * 〈功能详细描述〉
     *
     * @param args
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
        int intV=1233_233;
        float f1=12_23_22.344f;
        long l1=1244_33_23_22L;
        
       // int int2=_123;   //无效
        System.out.println(String.format("int=%d,float=%f,long=%d", intV,f1,l1));
        
    }

}
