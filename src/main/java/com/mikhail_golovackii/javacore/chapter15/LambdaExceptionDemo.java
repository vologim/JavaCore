
package com.mikhail_golovackii.javacore.chapter15;

interface DoubleNumericArrayFunc {
    double func(double[] n) throws EmptyArrayException;
}

class EmptyArrayException extends Exception {

    EmptyArrayException() {
        super("Массив пуст");
    }
    
}

public class LambdaExceptionDemo {
    public static void main(String[] args) throws EmptyArrayException{
        double values[] = { 1.0, 2.0, 3.0, 4.0 };
        
        DoubleNumericArrayFunc avg = (n) -> {
            double sum = 0.0;
            
            if(n.length == 0){
                throw new EmptyArrayException();
            }
            
            for(int i = 0; i < n.length; i++){
                sum += n[i];
            }
            
            return sum / n.length;
        };
        
        System.out.println("Среднее значение: " + avg.func(values));
        System.out.println("Ошибка: " + avg.func(new double[0]));
    }
}
