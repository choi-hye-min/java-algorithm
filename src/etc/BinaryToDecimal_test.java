package etc;

// by. arthur
public class BinaryToDecimal_test {

    public static void main(String[] args) {
        BinaryToDecimal_test binaryToDecimal = new BinaryToDecimal_test();
        int[] binary = new int[]{1, 1, 0, 0};
        System.out.println(binaryToDecimal.binaryToDecimal(binary));
    }

    public int binaryToDecimal(int[] binaryAr) {
        if (binaryAr == null || binaryAr.length == 0) throw new IllegalArgumentException();

        int result = binaryToDecimal(binaryAr, binaryAr.length - 1, 2, 0);

        return result;
    }

    private int binaryToDecimal(int[] binaryAr, int positionIndex, int binary, int calculate) {
        if (positionIndex == -1) return calculate;

        calculate += binaryAr[positionIndex] * Math.pow(binary, (binaryAr.length - (positionIndex + 1)));
        positionIndex--;

        return binaryToDecimal(binaryAr, positionIndex, binary, calculate);
    }
}