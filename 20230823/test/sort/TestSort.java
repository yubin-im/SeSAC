package test.sort;
// 20230822 �ǽ�
// ���� �˰���
import java.util.ArrayList;

public class TestSort {
    private static ArrayList<Integer> data;
    private static ArrayList<Integer>[] queue = new ArrayList[10];
    // static initializer(Ŭ���� �ʱ�ȭ)
    static {
        for(int i = 0; i < 10; i++){
            queue[i] = new ArrayList();
        }
    }

    public static void main(String[] args) {
        data = new ArrayList<Integer>();

        data.add(3);
        data.add(8);
        data.add(65);
        data.add(68);
        data.add(53);
        data.add(100);
        data.add(48);
        data.add(25);
        data.add(86);
        data.add(4);

        System.out.println("���� ��:: " + data);
        //insertSort(data, data.size());
        //bubbleSort(data, data.size());
        //mergeSort(data, data.size());
        //quickSort(data, data.size());
        radixSort(data, data.size());
        System.out.println("���� ��:: " + data);
    }


    // ���� ���� �˰���
    private static void insertSort(ArrayList<Integer> data, int size){
        int key = 0;
        int i = 0;
        int j = 0;

        for(i = 1; i < data.size(); i++) {  // ��ü �����͸� ���������� ����(0�� �ε����� ���� ����� �����Ƿ� 1������)
            key = data.get(i);  // �����͸� �����´�.

            for(j = i-1; j >= 0; j--) {  // i ��°�� ���� �� ���ڸ��� ���� ���ϸ鼭 ���� ���� ����
                if(data.get(j) > key) {
                    data.set(j+1, data.get(j));  // replace ���
                } else {
                    break;
                }
            }
            data.set(j+1, key);
        }
    }


    // ���� ���� �˰���
    private static void bubbleSort(ArrayList<Integer> data, int size) {
        int temp = 0;
        int i = 0;
        int j = 0;

        for (i = 1; i < data.size() - 1; i++) {
            for (j = 0; j < data.size() - 1 - i; j++) {
                if (data.get(j) > data.get(j + 1)) {
                    temp = data.get(j);
                    data.set(j, data.get(j + 1));
                    data.set(j + 1, temp);

                }
            }
        }
    }


    // ���� ���� �˰���
    private static ArrayList<Integer> newData;

    private static void mergeSort(ArrayList<Integer> data, int size){
        partition(0, size-1);  // ��ü �����͸� 2���� ������ ���� ���� ����
    }

    private static void partition(int left, int right){
        if (left < right) {
            int mid = (left + right) / 2;  // ��ü �����͸� 2���� ������ ���� �߰� ���� ����
            partition(left, mid);  // �� �κ��� �ٽ� 2���� ������. (���ȣ��� ���� �� ���� ������ ������.)
            partition(mid + 1, right);  // �� �κ��� �ٽ� 2���� ������. (���ȣ��� ���� �� ���� ������ ������.)
            merge(left, right);  // ����
        }
    }

    private static void merge(int left, int right){
        newData = new ArrayList<Integer>(data);  // ������ ������ �ƴϰ� ũ�⸦ ���� ���������.

        // ����¥�� arr�� newData�� ����
        for (int i = left; i <= right; i++) {
            newData.add(data.get(i));
        }

        int mid = (left + right) / 2;

        int tempLeft = left;
        int tempRight = mid+1;
        int curIndex = left;

        //newData�� ��ȯ�Ͽ� ���� ���ݰ� ������ ���� ���ؼ� �� ���� ���� data�� ����
        while (tempLeft <= mid && tempRight <= right) {  // left�� right�� ���ؼ� ������ �ٲ��ִ� �۾�
            if (newData.get(tempLeft) <= newData.get(tempRight)) {
                data.set(curIndex++, newData.get(tempLeft++));
            } else {
                data.set(curIndex++, newData.get(tempRight++));
            }
        }

        //���� ���ݿ� ���� ���ҵ��� ���� �迭�� ����
        int remain = mid - tempLeft;
        for (int i = 0; i <= remain; i++) {  // newData�� �ִ� ���ڸ� ���� ���� ������ data�� ������ �ִ� �۾�
            data.set(curIndex + i, newData.get(tempLeft + i));
        }
    }


    // �� ���� �˰���
    private static void quickSort(ArrayList<Integer> data, int size){
        quick(0, size - 1);
    }

    private static void quick(int left, int right) {
        if (left < right) {
            int p = partitionQuick(left, right);  // �Ǻ� ���� ���� ��ġ Ȯ��

            quick(left, p-1);  // �Ǻ� ���� ���� �ٽ� ����
            quick(p+1, right);  // �Ǻ� ���� ������ �ٽ� ����
        }
    }

    private static int partitionQuick(int left, int right){
        int pivot = data.get(right);  // �� ������ ���� �Ǻ����� ����
        int i = left - 1;

        for(int j = left; j <= right - 1; j++){  // right-1�� �ǹ��� ������ ������ ���� ��ġ
            if(data.get(j) <= pivot) {  // �迭 ��ȸ�ϸ� �Ǻ��̶� ���ų� ���� �� Ž��
                i++;  // i �ε��� ��ġ�� ��ü
                Swap(data, i, j);
            }
        }
        // partition ���� ���� �� pivot�� ���� ���� ��ġ(i+1)���� ��ü
        Swap(data, i+1, right);
        return i + 1;
    }

    private static void Swap(ArrayList<Integer> data, int a, int b){
        int temp = data.get(a);
        data.set(a, data.get(b));
        data.set(b, temp);
    }


    // ��� ���� �˰���
    // queue: 0~9, �� 10��(�迭)�� queue(ArrayList)�� ������ ��ü ������
    private static void radixSort(ArrayList<Integer> data, int length) {
        int radix = 1; boolean flag = false;
        while (true) {
            for(int i=0; i < data.size(); i++) {
                if (radix < data.get(i)) flag=true;
                else flag=false;

            }
            if(flag) radix *= 10; // ó������
            else break;
            // ���̻� radix���� ū ���� ������ while�� ���� ����.
        }

        System.out.println("��radix ::"+radix);
        for(int i=1; i <= radix; i*=10) {
            for(int j=0; j< length; j++) {
                int k;
                if(data.get(j)<i) {
                    k=0;
                }else {
                    k = (data.get(j)/i) % 10;

                }
                queue[k].add(data.get(j));


            }
            for(ArrayList q : queue) {
                System.out.println("radix["+i+"]::"+q);
            }
            int idx=0;
            for(int j=0; j< 10; j++) {
                while (queue[j].size() != 0) { // ���ĺ�����.. (for-each������ ����)
                    data.set(idx, queue[j].remove(0));
                    idx++;

                }
            }


        }


    }

}

