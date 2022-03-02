package sparseArray;

public class SparseArray {
    public static void main(String[] args) {
        int doubleArray[][] = new int[11][11];
//        doubleArray[0][1] = 01;
        doubleArray[1][2] = 1;
        doubleArray[2][4] = 2;
//        doubleArray[1][3] = 13;
        System.out.println("二维数组");
        for (int[] ints : doubleArray) {
            for (int anInt : ints) {
                System.out.print(anInt + "\t");
            }
            System.out.print("\n");
        }
        int[][] sparseArray = changeDoubleArray2SparseArray(doubleArray);
        System.out.println("二维数组转为稀疏数组");
        for (int[] ints : sparseArray) {
            for (int i : ints) {
                System.out.print(i + "\t");
            }
            System.out.print("\n");
        }
        System.out.println("稀疏数组转为二维数组");
        int[][] sparseArray2DoubleArray = changeSparseArray2DoubleArray(sparseArray);
        for (int[] ints : sparseArray2DoubleArray) {
            for (int anInt : ints) {
                System.out.print(anInt + "\t");
            }
            System.out.print("\n");
        }
    }

    //将二维数组转换为稀疏数组
    public static int[][] changeDoubleArray2SparseArray(int[][] doubleArray) {
//        循环二维数组获取不为0的个数
        int total = 0;
        for (int[] singleInts : doubleArray) {
            for (int i = 0; i < singleInts.length; i++) {
                if (singleInts[i] != 0) {
                    total++;
                }
            }
        }
//        创建稀疏数组
        int[][] sparseArray = new int[total + 1][3];
        sparseArray[0][0] = doubleArray.length;
        sparseArray[0][1] = doubleArray[0].length;
        sparseArray[0][2] = total;
        int row = 1;
        for (int i = 0; i < doubleArray.length; i++) {
            for (int j = 0; j < doubleArray[i].length; j++) {
                if (doubleArray[i][j] != 0) {
                    sparseArray[row][0] = i;
                    sparseArray[row][1] = j;
                    sparseArray[row][2] = doubleArray[i][j];
                    row++;
                }
            }
        }
        return sparseArray;
    }

    public static int[][] changeSparseArray2DoubleArray(int[][] sparseArray) {
        //初始化二维数组
        int[][] doubleArray = new int[sparseArray[0][0]][sparseArray[0][1]];
        for (int i = 1; i < sparseArray.length; i++) {
            /**/
            int x = sparseArray[i][0];
            int y = sparseArray[i][1];
            int num = sparseArray[i][2];
            doubleArray[x][y] = num;
        }
        return doubleArray;
    }
}
