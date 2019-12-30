package com.redis.demo;

import com.redis.demo.util.random;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Demo1 {

    private static Random random = new Random();

    public static void main(String[] args) {

        int[] wight = new  int[]{60,20,20};

        List<Integer> list = new ArrayList<Integer>();

        int a =0,b=0,c=0;
        Integer weightSum = 0;
        for (int i = 0;i < wight.length; i++) {
            list.add(wight[i]);
            weightSum += wight[i];
        }
        //  1 1 1 1 1 1 1
        for (int d =0 ;d <20; d++ ) {
            Integer rand = random.nextInt(weightSum);
            Integer countSum = 0;

            int index = 0;
            for (int i = 0; i <list.size(); i ++  ){
                if (rand >= countSum && rand < countSum + list.get(i)) {
                    index = i;
                    if (list.get(i) == 60) {
                        a++;
                    }

                    if (list.get(i) == 20) {
                        b++;
                    }

                    if (list.get(i) == 20) {
                        c++;
                    }
                    break;
                }
                countSum += list.get(i);
            }
        }

        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
    }

}




