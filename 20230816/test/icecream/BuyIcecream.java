package test.icecream;

// 20230816 �ǽ�
/* <pre>
���������� ���̽�ũ�� �����ϴ� �˰��� ¥��
- Project: IcecreamProject
- package: test.icecream
- Main-class: BuyIcecream
- ����
    - ���̽�ũ�� �ɺθ��ϱ�
    - �⿬��: ��, �ڹ�, ������ ����
    - ������: 1000��, �������١�
    - �ɺθ� ������ 7~9�ٷ� �����ϱ�
1. �ڹپ� �޼� ��� �޼տ� 1000���� ��� �ش�.
2. �ڹپ� ���̽�ũ�� ���(�������١�)��� ����Ѵ�. (�ڹٴ� �������� ã�ư���.)
3. �ڹٰ� �������� ����.
4. �ڹٰ� ������ �������� ���̽�ũ��(�������١�) �ּ����� ���Ѵ�. (������ ������ ���̽�ũ�� �Ŵ뿡 ����.)
5. ������ ������ �������١��� ������ �ڹ� �����տ� ��� �ش�. (�ڹٴ� ������ ���ƿ´�.)
6. �ڹٴ� (������) �����տ� �ִ� ���� �ش�.
7. ���ְ� �Դ´�.

1. left �� 1000;
2. buyIcecream(left);
3. Cu cu;
4. cu.getIcecream(left);
5. this.right = �������١�;
6. return this.right;
7. right = 6��(4��) ������ return ���� �޴´�.
8. sout(right);
</pre>
 */

public class BuyIcecream {
    public static void main(String[] args) {
        int left = 1000;
        String right = buyIcecream(left);

        System.out.println(right);
    }

    private static String buyIcecream(int left) {
        CU cu = new CU();

        String right = cu.getIcecream(left);
        return right;
    }

}
