package com.zhiwen.openai;

/**
 * @ClassName: Demo1
 * @Description:
 * @author：minghua@66money.com
 * @version：1.0.0
 * @createTime：2023/2/10 2:55 下午
 */
public class Demo1 {
    public static void main(String[] args) {
        int[] arr = {4, 5, 7, 3, 2, 9, 1, 6};
        System.out.println("排序前：");
        printArr(arr);
        bubbleSort(arr);
        System.out.println("排序后：");
        printArr(arr);
    }

    public static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void printArr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
