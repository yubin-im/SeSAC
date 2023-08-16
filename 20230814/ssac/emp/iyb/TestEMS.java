package ssac.emp.iyb;

// ���α׷� ����
// ���, ���, ��, ����, ����, �˻�

import java.util.Scanner;

public class TestEMS {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        EmployeeMGR emgr = new EmployeeMGR();

        System.out.println("EMS(Employee Management System) ���α׷��� �����մϴ�.");
        while (true) {
            System.out.println("1.��� 2.��� 3.�˻� 4.����");
            System.out.print("������ ����� ��ȣ�� �Է����ּ���(1~4): ");
            int runCode1 = scanner.nextInt();
            System.out.println("------------------------------");

            if (runCode1 == 1) {
                emgr.selectAll();
                if (emgr.runEMS == false) {
                    break;
                }

                System.out.print("�� ������ Ȯ���� �̸��� �Է����ּ���: ");
                String name = scanner.next();
                emgr.select(name);

                System.out.println("1.���� 2.����");
                System.out.print("������ ����� ��ȣ�� �Է����ּ���(1~2): ");
                int runCode2 = scanner.nextInt();
                System.out.println("------------------------------");

                if (runCode2 == 1) {
                    emgr.update(name);
                } else if (runCode2 == 2) {
                    emgr.delete(name);
                }

            } else if (runCode1 == 2) {
                emgr.insert();

            } else if (runCode1 == 3) {
                emgr.search();

            } else if (runCode1 == 4) {
                System.out.println("���α׷��� �����մϴ�.");
                break;
            }
        }


    }
}
