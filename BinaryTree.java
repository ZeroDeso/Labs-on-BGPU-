public class BinaryTree<T extends Comparable<T>> {
    private Node root; // Корневой узел дерева

    // Класс, представляющий узел дерева
    private class Node {
        T data; // Данные узла
        Node left; // Левый потомок
        Node right; // Правый потомок

        Node(T data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    // Метод для добавления элемента в дерево
    public void add(T data) {
        root = addRecursive(root, data);
    }

    // Рекурсивный метод добавления элемента в дерево
    private Node addRecursive(Node current, T data) {
        if (current == null) {
            return new Node(data);
        }

        if (data.compareTo(current.data) < 0) {
            current.left = addRecursive(current.left, data);
        } else if (data.compareTo(current.data) > 0) {
            current.right = addRecursive(current.right, data);
        }

        return current;
    }

    // Метод для проверки наличия элемента в дереве
    public boolean contains(T data) {
        return containsRecursive(root, data);
    }

    // Рекурсивный метод для проверки наличия элемента в дереве
    private boolean containsRecursive(Node current, T data) {
        if (current == null) {
            return false;
        }

        if (data.compareTo(current.data) == 0) {
            return true;
        }

        if (data.compareTo(current.data) < 0) {
            return containsRecursive(current.left, data);
        } else {
            return containsRecursive(current.right, data);
        }
    }

    // Метод для удаления элемента из дерева
    public void remove(T data) {
        root = removeRecursive(root, data);
    }

    // Рекурсивный метод для удаления элемента из дерева
    private Node removeRecursive(Node current, T data) {
        if (current == null) {
            return null;
        }

        if (data.compareTo(current.data) == 0) {
            // Узел без потомков
            if (current.left == null && current.right == null) {
                return null;
            }

            // Узел с одним потомком
            if (current.left == null) {
                return current.right;
            }

            if (current.right == null) {
                return current.left;
            }

            // Узел с двумя потомками
            T smallestValue = findSmallestValue(current.right);
            current.data = smallestValue;
            current.right = removeRecursive(current.right, smallestValue);
            return current;
        }

        if (data.compareTo(current.data) < 0) {
            current.left = removeRecursive(current.left, data);
            return current;
        }

        current.right = removeRecursive(current.right, data);
        return current;
    }

    // Метод для поиска наименьшего значения в дереве
    private T findSmallestValue(Node root) {
        return root.left == null ? root.data : findSmallestValue(root.left);
    }
}