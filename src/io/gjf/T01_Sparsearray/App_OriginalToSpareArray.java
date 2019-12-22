package io.gjf.T01_Sparsearray;

/**
 * Create by GuoJF on 2019/12/16
 */
public class App_OriginalToSpareArray {
    public static void main(String[] args) {
        /*
         *
         * 首先创建原始数组
         * */

        int[][] originalArray = new int[9][9];
        /*
         * 手动为数组中的两个位置赋值
         * */
        originalArray[0][1] = 1;
        originalArray[2][1] = 2;


        for (int[] values : originalArray) {

            for (int value : values) {

                System.out.print(value + "\t");

            }
            System.out.println();
        }


        /*
         * 获取到数组的长度 |     纵向长度
         * */
        int length = originalArray.length;

        /*
         * 获取到数组的 "宽"度  |  横向长度
         * */
        int width = originalArray[1].length;


        /*
         * 设置count 存储有效值个数
         * */
        int count = 0;

        /*
         * 获取数组中有几个有效值
         * */

        for (int[] values : originalArray) {

            for (int value : values) {

                if (value != 0) {

                    count++;
                }

            }
        }




        /*
         * 创建稀疏数组
         * */


        int[][] sparseArray = new int[count + 1][3];


        /*
         * 设置稀疏数组第一行的值
         * */
        sparseArray[0][0] = length;
        sparseArray[0][1] = width;
        sparseArray[0][2] = count;
        int cycleNum = 0;

        for (int i = 0; i < originalArray.length; i++) {

            for (int j = 0; j < originalArray.length; j++) {

                int currentValue = originalArray[i][j];

                if (currentValue != 0) {

                    sparseArray[cycleNum + 1][0] = i;
                    sparseArray[cycleNum + 1][1] = j;
                    sparseArray[cycleNum + 1][2] = currentValue;

                    cycleNum++;

                }


            }

        }

        for (int[] values : sparseArray) {

            for (int value : values) {

                System.out.print(value + "\t");

            }
            System.out.println();
        }






    }
}
