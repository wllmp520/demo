package com.example.demo.utilTest;

import java.math.BigDecimal;

/**
 * @program: demo
 * @description: 示例:计算Pi的小数点后5000位
 * @author: wllmp520
 * @create: 2019-07-01 09:29
 */
public class ThreadComputePi {
    private static final BigDecimal FOUR=BigDecimal.valueOf(4);

    private static final int roundingMode=BigDecimal.ROUND_HALF_EVEN;//银行家舍入法

    private static BigDecimal result;

    public static void main(String[] args) {
        Runnable r=()-> {
          result=computePi(50000);
        };
        Thread t=new Thread(r,"Thred-ComputePi");
        t.start();
        try {
            t.join();//main主线程 无限期 等待 t线程运行结束，
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(t.getName()+"运算出π的小数点后50000位:"+result);
    }

    private static BigDecimal computePi(int digits) {
        int scale=digits+5;
        BigDecimal arctan1_5=arctan(5,scale);
        BigDecimal arctan1_239=arctan(239,scale);
        BigDecimal pi=arctan1_5.multiply(FOUR).subtract(arctan1_239).multiply(FOUR);
        return pi.setScale(digits,BigDecimal.ROUND_HALF_UP);
    }

    private static BigDecimal arctan(int inverseX, int scale) {
        BigDecimal result,numer,term;
        BigDecimal invX=BigDecimal.valueOf(inverseX);
        BigDecimal invX2=BigDecimal.valueOf(inverseX * inverseX);
        numer=BigDecimal.ONE.divide(invX,scale,roundingMode);
        result=numer;
        int i=1;
        do {
            numer=numer.divide(invX2,scale,roundingMode);
            int denom=2*i+1;
            term = numer.divide(BigDecimal.valueOf(denom),scale,roundingMode);
            if ((i%2)!= 0) result=result.subtract(term);
            else    result=result.add(term);
            i++;
        }while (term.compareTo(BigDecimal.ZERO)!=0);
        return  result;
    }
}