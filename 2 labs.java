// Создаем класс Queue
public class Queue<T> {
    private Node<T> head; // Голова очереди
    private Node<T> tail; // Хвост очереди
    
    // Внутренний класс Node для представления элементов очереди
    private static class Node<T> {
        private T data; // Данные элемента
        private Node<T> next; // Ссылка на следующий элемент

        // Конструктор для создания узла с заданными данными и ссылкой на следующий элемент
        public Node(T data, Node<T> next) {
            this.data = data;
            this.next = next;
        }
    }
    
    // Метод для добавления элемента в конец очереди
    public void enqueue(T item) {
        Node<T> newNode = new Node<>(item, null);
        
        if (isEmpty()) { // Если очередь пустая, новый элемент становится и головой, и хвостом
            head = newNode;
            tail = newNode;
        } else { // Если очередь не пустая, добавляем новый элемент в конец
            tail.next = newNode;
            tail = newNode;
        }
    }
    
    // Метод для удаления и возвращения элемента из начала очереди
    public T dequeue() {
        if (isEmpty()) { // Если очередь пустая, возвращаем null
            return null;
        } else {
            T item = head.data; // Запоминаем данные текущей головы
            head = head.next; // Смещаем голову на следующий элемент
            
            if (head == null) { // Если после удаления элемента очередь стала пустой, обновляем хвост
                tail = null;
            }
            
            return item; // Возвращаем запомненные данные
        }
    }
    
    // Метод для проверки, является ли очередь пустой
    public boolean isEmpty() {
        return head == null;
    }
}