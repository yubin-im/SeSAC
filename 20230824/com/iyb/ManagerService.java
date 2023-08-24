package com.iyb;

import java.util.ArrayList;

public class ManagerService {
    private static ArrayList<Employee> emps = new ArrayList();

    public static void main(String[] args) {
        Employee iyb = new Employee("0001", "1111", "������", "ybyb130@gmail.com", "01030422886", "9901301234567");
        insert(iyb);
        String id = "0001";
        Employee emp1 = select(id);
        System.out.println(emp1);
        emp1.setPhone("01042852886");
        boolean result = update(id, emp1);
        System.out.println("����[" + id + "] ������ �����Ǿ����ϴ�." + "\n���: " + result);
        emp1 = select(id);
        System.out.println("�ٲ� ����: " + emp1);
        result = delete(id);
        System.out.println("���� ���� ���� �Ϸ�: " + result);
        ArrayList<Employee> someones = selectAll();
        System.out.println("ȸ�� �� �ο� ��: " + emps.size());
        System.out.println("�˻��� �ο� ��: " + someones.size());
    }

    private static void insert(Employee name) {
        emps.add(name);
    }

    private static Employee select(String id) {
        for (int i = 0; i < emps.size(); i++) {
            Employee emp = emps.get(i);
            if (emp.getId().equals(id)) {
                return emp;
            }
        }
        return null;
    }

//    private static Employee select(String id) {
//        int i = 0;
//        Employee emp = emps.get(i);
//        System.out.println("select(" + id + "):: emp: " + emp);
//        System.out.println("\t emp's id:: " + emp.getId());
//        if (emp.getId().equals(id)) {
//            return emp;
//        } else {
//            return null;
//        }
//    }

    private static boolean update(String id, Employee emp1) {
        for(int i = 0; i < emps.size(); i++){
            Employee emp = emps.get(i);
            if (emp.getId().equals(id)) {
                emps.set(i, emp1);
                return true;
            }
        }
        return false;
    }

    private static boolean delete(String id) {
        for(Employee emp: emps) {
            if (emp.getId().equals(id)) {
                emps.remove(emp);
                return true;
            }
        }
        return false;
    }

    private static ArrayList<Employee> selectAll(){
        return emps;
    }

}
