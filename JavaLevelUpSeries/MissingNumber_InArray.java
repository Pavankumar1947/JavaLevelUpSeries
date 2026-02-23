package com.eclothing.clothing.programming;

import java.util.Arrays;

public class MissingNumber_InArray {
    public static void main(String[] args) {
        int[] arr = {1,2,3,5,6,7,8};

        int start = arr[0];
        int end = arr[arr.length-1];

        int ab = (end - start + 1) * (start + end)/2;
        int bc = Arrays.stream(arr).sum();
        System.out.println(  ab-bc);
    }
}
