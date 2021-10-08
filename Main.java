import javax.crypto.CipherInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);

        LinkedList linkedList = new LinkedList();

        linkedList.addLast(8);
        linkedList.addFirst(2);
        linkedList.addFirst(3);
        linkedList.addFirst(1);

//        System.out.println(linkedList.removeFirst());
//        System.out.println(linkedList.removeFirst());

        linkedList.addLast(5);
        System.out.println(linkedList.get(0));
        System.out.println(linkedList.get(2));
        linkedList.forEach(System.out::println);

        System.out.println(linkedList.removeLast());
        System.out.println(linkedList.removeLast());

        int[] array = linkedList.toArray();
        linkedList.forEach(System.out::println);

    }
}