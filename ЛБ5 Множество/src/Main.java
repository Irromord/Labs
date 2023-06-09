/*Класс, представляющий множество на языке Java.*/
public class Set {

    // Массив элементов множества.
    private int[] elements;

    // Количество элементов в множестве.
    private int size;

    /* Конструктор множества.
      Создает пустое множество заданной ёмкости.
      capacity ёмкость множества.*/
    public Set(int capacity) {
        elements = new int[capacity];
        size = 0;
    }

    /* Добавляет элемент в множество.
     element элемент, который нужно добавить.*/
    public void add(int element) {
        if (!contains(element)) {
            if (size >= elements.length) {
                expandCapacity();
            }
            elements[size] = element;
            size++;
        }
    }
    /*Удаляет элемент из множества.
     element элемент, который нужно удалить.*/
    public void remove(int element) {
        int index = indexOf(element);
        if (index >= 0) {
            elements[index] = elements[size - 1];
            size--;
        }
    }

    /* Возвращает true, если множество содержит заданный элемент.
     element элемент, наличие которого нужно проверить.
     @return true, если множество содержит заданный элемент, false в противном случае.*/
    public boolean contains(int element) {
        return indexOf(element) >= 0;
    }

    /* Возвращает размер множества.
     return количество элементов в множестве.*/
    public int size() {
        return size;
    }

    public void print() {
        System.out.print("{ ");
        for (int i = 0; i < size; i++) {
            System.out.print(elements[i] + " ");
        }
        System.out.print("}");
    }

    /*Возвращает индекс заданного элемента в массиве элементов множества.
     Если элемент не найден, возвращает -1.
     element элемент, индекс которого нужно найти.
     return индекс элемента в массиве, -1 если элемент не найден. */
    private int indexOf(int element) {
        for (int i = 0; i < size; i++) {
            if (elements[i] == element) {
                return i;
            }
        }
        return -1;
    }

    /* Увеличивает ёмкость множества в два раза.
     Вызывается при добавлении элемента в заполненное множество.*/
    private void expandCapacity() {
        int[] newElements = new int[elements.length * 2];
        System.arraycopy(elements, 0, newElements, 0, elements.length);
        elements = newElements;
    }
}