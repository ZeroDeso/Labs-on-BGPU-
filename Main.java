// Класс, представляющий узел стека
class Node {
    int data; // данные узла
    Node next; // ссылка на следующий узел

    // Конструктор
    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

// Класс, представляющий стек
class Stack {
    private Node top; // ссылка на вершину стека

    // Конструктор
    public Stack() {
        this.top = null;
    }

    // Проверка, пуст ли стек
    public boolean isEmpty() {
        return top == null;
    }

    // Добавление элемента в стек
    public void push(int data) {
        Node newNode = new Node(data); // Создаем новый узел

        if (isEmpty()) {
            top = newNode; // Если стек пуст, новый узел становится вершиной стека
        } else {
            newNode.next = top; // Устанавливаем ссылку на предыдущую вершину
            top = newNode; // Новый узел становится вершиной стека
        }
    }

    // Удаление элемента из стека
    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("Стек пуст");
        }

        int data = top.data; // Получаем данные вершины
        top = top.next; // Переходим к следующему узлу
        return data; // Возвращаем данные удаленного узла
    }

    // Получение вершины стека (без удаления)
    public int peek() {
        if (isEmpty()) {
            throw new RuntimeException("Стек пуст");
        }

        return top.data; // Возвращаем данные вершины
    }
}

// Пример использования
public class Main {
    public static void main(String[] args) {
        Stack stack = new Stack();

        stack.push(10); // Добавляем элементы в стек
        stack.push(20);
        stack.push(30);

        System.out.println(stack.peek()); // Выводим вершину стека (30)

        System.out.println(stack.pop()); // Удаляем вершину стека (30)
        System.out.println(stack.pop()); // Удаляем вершину стека (20)

        System.out.println(stack.peek()); // Выводим вершину стека (10)
    }
}