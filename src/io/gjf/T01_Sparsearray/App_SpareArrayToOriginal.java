package io.gjf.T01_Sparsearray;

/**
 * Create by GuoJF on 2019/12/16
 */
public class App_SpareArrayToOriginal {
    public static void main(String[] args) {
        int[][] sparseArray = new int[3][3];

        sparseArray[0][0] = 9;
        sparseArray[0][1] = 9;
        sparseArray[0][2] = 2;
        sparseArray[1][0] = 0;
        sparseArray[1][1] = 1;
        sparseArray[1][2] = 1;
        sparseArray[2][0] = 2;
        sparseArray[2][1] = 1;
        sparseArray[2][2] = 2;



        for (int[] values : sparseArray) {

            for (int value : values) {

                System.out.print(value + "\t");

            }
            System.out.println();
        }


        /*
         * 得到原始数组的长度
         * 得到原始数组的宽度
         * */


        int length = sparseArray[0][0];
        int width = sparseArray[0][1];
        int valueSum = sparseArray[0][2];


        int[][] originalArray = new int[length][width];

        for (int i = 0; i < valueSum; i++) {

            int i0 = sparseArray[i + 1][0];
            int i1 = sparseArray[i + 1][1];
            int i2 = sparseArray[i + 1][2];

            originalArray[i0][i1] = i2;

        }



        for (int[] values : originalArray) {

            for (int value : values) {

                System.out.print(value + "\t");

            }
            System.out.println();
        }


    }
}
