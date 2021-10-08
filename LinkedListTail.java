import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class LinkedListTail {
        private Node head;
        private Node tail;
        private int size;

        public void addFirst(int element){
            Node temp = new Node(element);
            if(!isEmpty()){
                temp.next = head;
            }
            else{
                this.tail = temp;
            }
            this.head = temp;
            size++;
        }

        public void addLast(int element){
            if(isEmpty()){
                this.addFirst(element);
                return;
            }
            Node current = this.head;
            Node newNode = new Node(element);

            while(current.next != null){
                current = current.next;
            }
            current.next = newNode;
            this.tail = newNode;
            this.size++;
        }

        public int removeFirst(){
            if(isEmpty()){
                throw new IllegalStateException("Invalid operation! There may not be any elements in the lit!");
            }
            int result = this.head.value;
            this.head = this.head.next;
            this.size--;
            if(isEmpty()){
                this.head = this.tail = null;
            }
            return result;
        }

        public int removeLast(){
            if(this.size < 2){
                return this.removeFirst();
            }

            Node current = this.head;
            int result = 0;

            while(current.next.next != null){
                current = current.next;
            }
            result = current.next.value;
            current.next = null;
            this.tail = current;
            this.size--;
            return result;
        }

        public int get(int index){
            if(isEmpty() || !checkIndex(index)){
                throw new IllegalStateException("There is no such element on this position!");
            }
            if(index == 0){
                return this.head.value;
            }
            int result = 0;
            int currentIndex = 0;
            Node current = this.head;
            while(current != null){
                if(currentIndex == index){
                    result = current.value;
                    break;
                }
                currentIndex++;
                current = current.next;
            }
            return result;
        }

        private boolean checkIndex(int index){
            return index >= 0 && index < this.size;
        }

        public void forEach(Consumer<Integer> consumer){
            Node current = this.head;
            while(current != null){
                consumer.accept(current.value);
                current = current.next;
            }
        }

//    public int[] toArray(){
//        int[] array = new int[this.size];
//        int counter = 0;
//        Node current = this.head;
//
//        while(current != null){
//            array[counter] = current.value;
//            current = current.next;
//            counter++;
//        }
//        return array;
//    }

        public int[] toArray() {
            List<Integer> list = new ArrayList<>();
            forEach(list::add);
            return list.stream().mapToInt(e -> e).toArray();
        }

        public int size(){
            return this.size;
        }

        public boolean isEmpty(){
            return this.size() == 0;
        }
}
