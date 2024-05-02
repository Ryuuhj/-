package bronze;

import java.util.Scanner;

public class Main_2753 {
    //윤년이면 1, 아니면 0 출력
    //윤년 조건 - 1. 4의 배수 && !100의 배수 2. 400의 배수
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int year = sc.nextInt();
        if((year % 4 == 0 && year % 100 != 0) || year % 400 == 0)
            System.out.println(1);
        else
            System.out.println(0);
    }
}
