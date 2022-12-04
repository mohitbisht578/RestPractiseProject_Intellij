package lombokUse;

public class SUMDIGIT {

    public static void main(String[] args) {

        int N = 7;
        System.out.println(getNo(N));
    }

    public static int getNo(int N) {
        return (int) ((N % 9 + 1) *
                        Math.pow(10, (N / 9)) - 1);
    }
}
