package spring;

public class TestGoTo {
    public static void main(String[] args) {
        test();
    }

    private static void test() {
        int i = 0;

        label:
        for (int j = 0; j < 5; j++) {
            if (j == 3) {
//                continue label;
                break label;
            }
            System.out.println(j);
        }

        System.out.println("finish");
    }
}
