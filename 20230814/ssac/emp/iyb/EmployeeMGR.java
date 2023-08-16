package ssac.emp.iyb;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class EmployeeMGR extends Employee{
    Scanner scanner = new Scanner(System.in);
    Map<String, Map<String, String>> db = new LinkedHashMap<>();
    Map<String, String> inDb;
    protected boolean runEMS = true;

    public EmployeeMGR() {
        super();
    }

    public void insert() {
        inDb = new LinkedHashMap<>();

        System.out.println("-���-");
        System.out.print("�̸��� �Է����ּ���: ");
        name = scanner.next();
        System.out.print("����� �Է����ּ���: ");
        sabun = scanner.next();
        System.out.print("��ȣ�� �Է����ּ���: ");
        phone = scanner.next();
        System.out.print("�ּҸ� �Է����ּ��� (ex. ��õ��): ");
        addr = scanner.next();

        inDb.put("sabun", sabun);
        inDb.put("phone", phone);
        inDb.put("addr", addr);

        db.put(name, inDb);

        System.out.println("------------------------------");
        System.out.println(name + " ����� ��ϵǾ����ϴ�. \n");
    }

    public void selectAll(){
        if (this.db.size() != 0) {
            System.out.println("-��ü ��� ���-");
            for (String name: this.db.keySet()){
                System.out.println(name);
            }
            System.out.println();
        } else {
            System.out.println("����� �������� �ʽ��ϴ�.");
            System.out.println("���α׷��� �����մϴ�.");
            this.runEMS = false;

        }
    }

    public void select(String name) {
        inDb = this.db.get(name);

        System.out.println("------------------------------");
        System.out.println("-" + name + " ����� �� ����-");
        System.out.println("���: " + inDb.get("sabun"));
        System.out.println("��ȣ: " + inDb.get("phone"));
        System.out.println("�ּ�: " + inDb.get("addr"));
        System.out.println();
    }

    public void update(String name) {
        inDb = this.db.get(name);

        while (true) {
            System.out.println("1. ��� 2. ��ȣ 3. �ּ� 4. �����Ϸ�");
            System.out.print("������ ������ ��ȣ�� �Է����ּ���(1~4): ");
            int modCode = scanner.nextInt();

            if (modCode == 1) {
                System.out.print("����� ���� ������ �Է����ּ���: ");
                String modSabun = scanner.next();
                inDb.replace("sabun", modSabun);
            } else if (modCode == 2) {
                System.out.print("��ȣ�� ���� ������ �Է����ּ���: ");
                String modPhone = scanner.next();
                inDb.replace("phone", modPhone);
            } else if (modCode == 3) {
                System.out.print("�ּ��� ���� ������ �Է����ּ���: ");
                String modAddr = scanner.next();
                inDb.replace("addr", modAddr);
            } else if (modCode == 4) {
                System.out.println(name+ " ����� ������ �Ϸ�Ǿ����ϴ�. \n");
                break;
            }
            System.out.println("------------------------------");
        }
    }

    public void delete(String name) {
        System.out.println(name + " ����� ���� �մϴ�. \n");
        this.db.remove(name);
    }

    public void search() {
        System.out.print("�˻��� ����� �̸��� �Է����ּ���: ");
        String inputName = scanner.next();

        for (String name: this.db.keySet()) {
            if (name.equals(inputName)) {
                select(inputName);
                break;
            } else {
                System.out.println(inputName + " ����� ��Ͽ� �������� �ʽ��ϴ�. \n");
            }
        }
    }

}
