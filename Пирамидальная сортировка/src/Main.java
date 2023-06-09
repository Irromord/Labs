public class HeapSort {

    public static void sort(int[] array) {
        int n = array.length;

        // Построение пирамиды (перегруппировка массива).
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(array, n, i);
        }

        // Один за другим извлекаем элементы из кучи
        for (int i = n - 1; i >= 0; i--) {
            // Перемещаем текущий корень в конец
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;

            // Вызываем процедуру heapify на уменьшенной куче
            heapify(array, i, 0);
        }
    }

    /* Превращает переданный массив в кучу с корнем в заданном индексе.
     array массив, который нужно превратить в кучу.
     n размер кучи (часть массива, которая должна быть превращена в кучу).
     i индекс корня кучи.
     */
    private static void heapify(int[] array, int n, int i) {
        int largest = i;  // Инициализируем наибольший элемент как корень
        int leftChild = 2 * i + 1;  // Левый потомок
        int rightChild = 2 * i + 2;  // Правый потомок

        // Если левый потомок больше корня
        if (leftChild < n && array[leftChild] > array[largest]) {
            largest = leftChild;
        }

        // Если правый потомок больше, чем самый большой элемент на данный момент
        if (rightChild < n && array[rightChild] > array[largest]) {
            largest = rightChild;
        }

        // Если наибольший элемент больше не является корнем
        if (largest != i) {
            int temp = array[i];
            array[i] = array[largest];
            array[largest] = temp;

            // Рекурсивно приводим поддерево в кучу
            heapify(array, n, largest);
        }
    }
}