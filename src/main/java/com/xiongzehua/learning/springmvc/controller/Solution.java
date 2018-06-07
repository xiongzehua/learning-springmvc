package com.xiongzehua.learning.springmvc.controller;

import java.util.Arrays;

/**
 * Created by xiongzehua on 2018/5/29.
 * 分析： x像这种时间复杂度超过 O(N^2) 的问题，一般都是多个指针，嵌套遍历多次。
 * 这时候可以考虑如下思路：
 * 1. 利用HashSet降低一个阶层的时间复杂度。
 * 2. 可以考虑先将元素进行排序，很多问题在顺序的情况下能简单很多。
 */
public class Solution {
    public static void main(String[] args) {
        new Solution().threeSumClosest(new int[]{-1,2,1,-4}, 1);
    }
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int sum = nums[0] + nums[1] + nums[2];
        int deviation = Math.abs(sum - target);
        for (int current = 1; current < nums.length - 1; current++) {
            int start = 0;//head向右走一位，sum增大
            int end = nums.length - 1;//end向左走一位，sum减小
            while (start != current && end != current) {
                int thisSum = nums[start] + nums[current] +nums[end];
                int thisDeviation = Math.abs(thisSum - target);
                if (thisDeviation < deviation) {
                    deviation = thisDeviation;
                    sum = thisSum;
                }

                /* debug
                System.out.println("------------");
                for (int i = 0; i < nums.length; i++) {
                    if (i == start) {
                        System.out.print(nums[i] + "*,");
                    } else if (i == current ) {
                        System.out.print(nums[i] + "*,");
                    } else if (i == end) {
                        System.out.print(nums[i] + "*,");
                    } else
                        System.out.print(nums[i] + ",");
                }
                System.out.println();
                System.out.println("thisSum: " + thisSum + " sum: " + sum + " thisDeviation: " + thisDeviation + " deviation: " + deviation);
                */

                if (thisSum < target)
                    start++;
                else
                    end--;
            }
        }
        return sum;
    }
}
