package com.company.easy.MaxConsecutiveOnes;

/**
 * Given a binary array, find the maximum number of consecutive 1s in this array.
 * Created by ogl4jo3 on 2017/3/12.
 */
public class MaxConsecutiveOnes {
    public static void main(String[] args) {
        int[] nums={0,1,0,1,1,1,1,0,1,1,0,1,1,1,0,0};
        int count=0;
        int max_count=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==1){
                count++;
                if(count>max_count) max_count=count;
            }else {
                count=0;
            }
        }
        System.out.println("max_count:"+max_count);
    }
}
