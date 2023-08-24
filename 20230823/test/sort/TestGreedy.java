package test.sort;

import java.util.ArrayList;
import java.util.Collections;

public class TestGreedy{
    public static void main(String[] args){
        // Ȱ�� ������ List�� �����ϰ� �����Ѵ�.
        ArrayList<Action> list = new ArrayList<>();
        list.add(new Action("A", 7, 8));
        list.add(new Action("B", 5, 7));
        list.add(new Action("C", 3, 6));
        list.add(new Action("D", 1, 2));
        list.add(new Action("E", 6, 9));
        list.add(new Action("F", 10, 11));
        Collections.sort(list);

        // Greedy �˰��� ���� ��, ��� ���
        ArrayList<Action> ans = greedy(list);
        for(Action act : ans){
            System.out.print(act.name + ", ");
        }
    }

    // Greedy �˰����� ���� ���õ� Ȱ������ ��ȯ�Ѵ�.
    private static ArrayList<Action> greedy(ArrayList<Action> list){
        int time = 0;
        ArrayList<Action> ans = new ArrayList<>();

        for(Action act : list){
            if(time <= act.startTime){
                time = act.endTime;
                ans.add(act);
            }
        }
        return ans;
    }
}

// Ȱ�� ������ ���� Class�� Comparable�� �����Ͽ� ���� �ð� ���� ������������ ������.
class Action implements Comparable<Action>{
    String name;
    int startTime;
    int endTime;
    public Action(String name, int startTime, int endTime){
        this.name = name;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    @Override
    public int compareTo(Action a) {
        return this.endTime - a.endTime;
    }

    @Override
    public String toString() {
        return this.name;
    }
}

// ���
// D, C, A, F,