import java.util.ArrayList;

public class GenericStackDemo {
    public static class GenericStack<E> {
        private final ArrayList<E> items;

        public GenericStack() {
            this.items = new ArrayList<>();
        }

        public void push(E item) {
            items.add(item);
        }

        public E pop() {
            if (isEmpty()) {
                throw new ArrayStackException("Underflow Error");
            }
            return items.remove(items.size() - 1);
        }

        public boolean isEmpty() {
            return items.isEmpty();
        }

        public static class ArrayStackException extends RuntimeException {
            public ArrayStackException(String message) {
                super(message);
            }
        }
    }

    public static void main(String[] args) {
        GenericStack<Integer> integerStack = new GenericStack<>();
        integerStack.push(10);
        integerStack.push(20);
        integerStack.push(30);

        System.out.println("Pop dari GenericStack<Integer>:");
        while (!integerStack.isEmpty()) {
            System.out.println(integerStack.pop());
        }

        GenericStack<String> stringStack = new GenericStack<>();
        stringStack.push("Java");
        stringStack.push("PHP");
        stringStack.push("Stack");
        stringStack.push("Generics");
        stringStack.push("PBO");

        System.out.println("\nPop dari GenericStack<String>:");
        while (!stringStack.isEmpty()) {
            System.out.println(stringStack.pop());
        }
    }
}
