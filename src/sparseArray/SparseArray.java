package sparseArray;

public class SparseArray {
    public static void main(String[] args) {
        int doubleArray[][] = new int[11][11];
        doubleArray[0][1] = 01;
        doubleArray[0][2] = 02;
        doubleArray[2][3] = 23;
        doubleArray[1][3] = 13;
        System.out.println("二维数组");
        for (int[] ints : doubleArray) {
            for (int anInt : ints) {
                System.out.print(anInt + "\t");
            }
            System.out.print("\n");
        }
        int[][] sparseArray = change2SparseArray(doubleArray);
        System.out.println("稀疏数组");
        for (int[] ints : sparseArray) {
            for (int i : ints) {
                System.out.print(i+"\t");
            }
            System.out.print("\n");
        }

    }

    public static int[][] change2SparseArray(int[][] doubleArray) {
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
        int[][] sparseArray = new int[total+1][3];
        sparseArray[0][0] = doubleArray.length;
        sparseArray[0][1] = doubleArray[0].length;
        sparseArray[0][2] = total;
        int row = 1;
        for (int i = 0; i < doubleArray.length; i++) {
            for (int j = 0; j < doubleArray[i].length; j++) {
                if (doubleArray[i][j] != 0){
                    sparseArray[row][0] = i;
                    sparseArray[row][1] = j;
                    sparseArray[row][2] = doubleArray[i][j];
                    row ++;
                }
            }
        }
        return sparseArray;
    }
}
