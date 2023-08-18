package test.date;

// 20230817 �ǽ�
/*
- Project: DateProject
- package: test.date
- Main_class: TestDate
- ����: �������� ���α׷��� ���� ��¥�� ǥ���ϱ� ���� Ŭ���� �����, ��¥�� ������(y, m, d)�� ������ ǥ��

1. int y, m, d;
2. date �ǹ�
3. data type ����: class Date (1�� ������ ����)
4. ���
5. today
6. today.m = 1;
7. �����
 */

public class TestDate {
    public static void main(String[] args) {
        int y, m, d;
        y = 2023;
        m = 8;
        d = 17;
        System.out.println(y + "-" + m + "-" + d);

        Date today = new Date(2023, 8, 17);
        // toString() �������̵� �ؾ� �ּҰ��� ��¾ȵǰ� ���ڿ��� ��µȴ�.
        System.out.println(today);

        // ���� ����: 1 ~ 12
        today.setMonth(-1);
        today.setDay(150);
        today.setMonth(2);
        today.print();

        // ���� Ȯ�� (ex. 1988, 2400 ...)
        today.setYear(1988);
        today.setMonth(2);
        today.setDay(30);
        today.print();

        Appoint appoint = new Appoint(2023, 8, 19, "���ɾ��");
        appoint.print();


//        // equals() �ʿ伺
//        Date today2 = new Date(2023, 8, 17);
//        System.out.println(
//                (today == today2) ? "same" : "not same");
//        // equals() �������̵带 �ؾ��� same�� ��µȴ�.
//        System.out.println(
//                (today.equals(today2) ? "same" : "not same")
//        );

    }
}
