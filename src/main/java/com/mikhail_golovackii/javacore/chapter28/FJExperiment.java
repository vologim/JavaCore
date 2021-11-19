
package com.mikhail_golovackii.javacore.chapter28;

import java.util.concurrent.ForkJoinPool;
import static java.util.concurrent.ForkJoinTask.invokeAll;
import java.util.concurrent.RecursiveAction;


public class FJExperiment {
    public static void main(String[] args) {
        int plevel;
        int threshold;
        
//        if(args.length != 2){
//            System.out.println("Порог");
//            return;
//        }
        
//        plevel = Integer.parseInt(args[0]);
//        threshold = Integer.parseInt(args[1]);

        plevel = 1;
        threshold = 1000;
        
        long beginT;
        long endT;
        
        ForkJoinPool fjp = new ForkJoinPool(plevel);
        double nums[] = new double[1_000_000];
        
        for (int i = 0; i < nums.length; i++){
            nums[i] = (double) i;
        }
        
        Transform1 task = new Transform1(nums, 0, nums.length, threshold);
        beginT = System.nanoTime();
        
        fjp.invoke(task);
        
        endT = System.nanoTime();
        System.out.println("Уровень параллелизма: " + plevel);
        System.out.println("Порог последовательной обработки: " + threshold);
        System.out.println("Время: " + (endT - beginT));
        System.out.println();
    }
}

class Transform1 extends RecursiveAction{
    int seqThreshold;
    double data[];
    int start;
    int end;

    public Transform1(double[] data, int start, int end, int seqThreshold) {
        this.seqThreshold = seqThreshold;
        this.data = data;
        this.start = start;
        this.end = end;
    }
    
    protected void compute(){
        if ((end - start) < seqThreshold){
            for (int i = start; i < end; i++){
                if ((data[i] % 2) == 0){
                    data[i] = Math.sqrt(data[i]);
                }
                else{
                    data[i] = Math.cbrt(data[i]);
                }
            }
        }
        else{
            int middle = (start + end) / 2;
            
            invokeAll(new Transform1(data, start, middle, seqThreshold),
                      new Transform1(data, middle, end, seqThreshold));
        }
    }
}