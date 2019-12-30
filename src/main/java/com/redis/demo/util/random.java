package com.redis.demo.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class random {

    /**
     * 权重随机数
     * @param weight [15,568,4181,2]
     * @return 索引值
     */
    public static int random(List<Integer> weight){
        List<Integer> weightTmp = new ArrayList<Integer>(weight.size()+1);
        weightTmp.add(0);
        Integer sum = 0;
        for( Integer d : weight ){
            sum += d;
            weightTmp.add(sum);
        }
        Random random = new Random();
        int rand = random.nextInt(sum);
        int index = 0;
        // 1:2:3:4
        // 1 3 6 10
        // 6 < 10   3
        // 6 < 6     2
        // 6 > 3     1
        for(int i = weightTmp.size()-1; i >0; i--){
            if( rand >= weightTmp.get(i)){
                index = i;
                break;
            }
        }
        return index;
    }

    public static void main(String[] args) {

        int[] weight = new int[]{60,20,20};

        List<Integer> weightTmp = new ArrayList<Integer>(weight.length+1);
        for (int i = 0 ; i < weight.length; i ++) {
            weightTmp.add(weight[i]);
        }

        int a = 0,b =0,c= 0;
        for (int i = 0; i < 50 ; i++) {
          int index =   random(weightTmp);
            System.out.println(index);
          if (weight[index] == 20) {
            a++;
          }

            if (weight[index] == 20) {
                b++;
            }


            if (weight[index] == 60) {
                c++;
            }
        }
        System.out.println("============================");
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
    }
}
