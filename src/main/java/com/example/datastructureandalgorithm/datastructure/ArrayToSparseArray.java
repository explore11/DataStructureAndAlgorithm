package com.example.datastructureandalgorithm.datastructure;

/* *
 * @program: DataStructureAndAlgorithm
 * @description 二位数组转换为稀疏数组
 * @author: swq
 * @create: 2020-10-11 13:07
 **/
public class ArrayToSparseArray {
    public static void main(String[] args) {
        // 使用稀疏数组，来保留类似前面的二维数组(棋盘、地图等等)把稀疏数组存盘，并且可以从新恢复原来的二维数组数整体思路分析
        // 二维数组转换为稀疏数组
        // 声明数组大小
        System.out.println("================= 二维数组转换为稀疏数组 =====================");
        int[][] array = new int[11][11];
        // 赋值大小 1表示黑子  2表示 蓝字
        array[0][2] = 1;
        array[1][3] = 2;
        array[2][3] = 2;
        // 循环输出值
        System.out.println("============遍历二维数组===========");
        for (int[] rows : array) {
            for (int item : rows) {
                System.out.printf("%d\t", item);
            }
            System.out.println();
        }

        // 将二维数组转化为稀疏数组

        //1、 获取二维数组中的有效个数
        int sum = 0;
        for (int[] ints : array) {
            for (int j = 0; j < array.length; j++) {
                if (ints[j] != 0) {
                    sum++;
                }
            }
        }
        //2、 定义稀疏数组
        int[][] sparseArray = new int[sum + 1][3];

        //3、稀疏数组中设置值
        sparseArray[0][0] = array.length;
        sparseArray[0][1] = array[0].length;
        sparseArray[0][2] = sum;

        //4、将有效数据设置到稀疏数组中
        // 行的个数
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if (array[i][j] != 0) {
                    count++;
                    sparseArray[count][0]=i;
                    sparseArray[count][1]=j;
                    sparseArray[count][2]=array[i][j];
                }
            }
        }

        System.out.println("============遍历稀疏数组===========");
        // 遍历稀疏数组
        for (int[] sparseRows : sparseArray) {
            for (int item : sparseRows) {
                System.out.printf("%d\t", item);
            }
            System.out.println();
        }

        System.out.println("================= 稀疏数组转换为二维数组 =====================");

        // 稀疏数组转换为二维数组
        // 定义二维数组的声明
        int[][] array2 =new int[sparseArray[0][0]][sparseArray[0][1]];

        // 遍历稀疏数组
        for (int i = 1; i < sparseArray.length; i++) {
            // 设置值
            array2[sparseArray[i][0]][sparseArray[i][1]]=sparseArray[i][2];
        }

        // 循环数组
        for (int[] rows : array2) {
            for (int item : rows) {
                System.out.printf("%d\t", item);
            }
            System.out.println();
        }

    }
}
