
package com.mikhail_golovackii.javacore.chapter15;

interface MyFunc <T> {
    boolean func(T t1, T t2);
}

class HighTemp {
    private int hTemp;
    
    HighTemp(int ht){
        hTemp = ht;
    }
    
    boolean sameTemp(HighTemp ht2){
        return hTemp == ht2.hTemp;
    }
    
    boolean lessThatTemp(HighTemp ht2){
        return hTemp < ht2.hTemp;
    }
}

public class InstanceMethWithObjectRefDemo {
    
    static <T> int counter(T[] vals, MyFunc<T> f, T v){
        int count = 0;
        
        for(int i = 0; i < vals.length; i++){
            if(f.func(vals[i], v)){
                count++;
            }
        }
        return count;
    }
    
    public static void main(String[] args) {
        int count;
        HighTemp[] weekDaysHigh = { new HighTemp(89), new HighTemp(82),
                                    new HighTemp(90), new HighTemp(91),
                                    new HighTemp(84), new HighTemp(83) };
        
        count = counter(weekDaysHigh, HighTemp::sameTemp, new HighTemp(89));
        System.out.println("Дней, когда максимальная температура была 89: " + count);

        HighTemp[] weekDaysHigh2 = { new HighTemp(32), new HighTemp(12),
                                    new HighTemp(24), new HighTemp(19),
                                    new HighTemp(18), new HighTemp(12),
                                    new HighTemp(-1), new HighTemp(13)};
        
        count = counter(weekDaysHigh2, HighTemp::sameTemp, new HighTemp(12));
        System.out.println("Дней, когда максимальная температура была 12: " + count);
        
        count = counter(weekDaysHigh, HighTemp::lessThatTemp, new HighTemp(89));
        System.out.println("Дней, когда максимальная температура была меньше 89: " + count);
        
        count = counter(weekDaysHigh2, HighTemp::lessThatTemp, new HighTemp(19));
        System.out.println("Дней, когда максимальная температура была меньше 19: " + count);
    }
}
