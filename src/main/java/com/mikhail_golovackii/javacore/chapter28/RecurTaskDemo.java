
package com.mikhail_golovackii.javacore.chapter28;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;


public class RecurTaskDemo {
    public static void main(String[] args) {
        ForkJoinPool fjp = new ForkJoinPool();
        
        double nums[] = new double[5000];
        
        for (int i = 0; i < nums.length; i++){
            nums[i] = (double) (((i % 2) == 0) ? i : -i);
        }
        Sum1 task = new Sum1(nums, 0, nums.length);
        
        double summa = fjp.invoke(task);
        
        System.out.println("Summ: " + summa);
    }
}

class Sum1 extends RecursiveTask<Double>{
    final int seqThreshHold = 500;
    
    double[] data;
    
    int start;
    int end;

    public Sum1(double[] data, int start, int end) {
        this.data = data;
        this.start = start;
        this.end = end;
    }
    
    protected Double compute(){
        double sum = 0;
        
        if ((end - start) < seqThreshHold){
            for (int i = start; i < end; i++){
                sum += data[i];
            }
        }
        else{
            int middle = (start + end) / 2;
            Sum1 subTastA = new Sum1(data, start, middle);
            Sum1 subTastB = new Sum1(data, middle, end);
            
            subTastA.fork();
            subTastB.fork();
            
            sum = subTastA.join() + subTastB.join();
        }
        return sum;
    }
}