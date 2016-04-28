package com.mytest.local.data2;

/**
 * Created by hebo on 2016/4/28.
 */
public class Sort {

    public static void main(String[] args){
        int array[] = {-5,1,2,12,-3,0,11};
        for (int i = 0; i < array.length; i++){
            for (int j = i+1; j < array.length; j++){
                if(array[i] < array[j]){
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }

        for (int i = 0; i < array.length; i++){
            System.out.print(array[i]+" ");
        }
    }
}
