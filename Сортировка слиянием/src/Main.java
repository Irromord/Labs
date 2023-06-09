/*Класс, реализующий сортировку слиянием на Java.*/
public class MergeSort {

    /* Рекурсивно вызывает сортировку слиянием для двух половин массива, а затем объединяет их.
     array сортируемый массив.
     left граница левой половины массива.
     right граница правой половины массива. */
    public static void sort(int[] array, int left, int right) {
        if (left < right) {
            int middle = (left + right) / 2;
            sort(array, left, middle);
            sort(array, middle + 1, right);
            merge(array, left, middle, right);
        }
    }

    /* Объединяет две отсортированные половины массива в один.
     middle граница, разделяющая половины.*/
    private static void merge(int[] array, int left, int middle, int right) {
        int[] tempArray = new int[right - left + 1];

        int leftIndex = left;
        int rightIndex = middle + 1;
        int index = 0;

        while (leftIndex <= middle && rightIndex <= right) {
            if (array[leftIndex] < array[rightIndex]) {
                tempArray[index] = array[leftIndex];
                leftIndex++;
            } else {
                tempArray[index] = array[rightIndex];
                rightIndex++;
            }
            index++;
        }

        while (leftIndex <= middle) {
            tempArray[index] = array[leftIndex];
            leftIndex++;
            index++;
        }

        while (rightIndex <= right) {
            tempArray[index] = array[rightIndex];
            rightIndex++;
            index++;
        }

        for (int i = 0; i < tempArray.length; i++) {
            array[left + i] = tempArray[i];
        }
    }
}
/*Сортировка осуществляется путём сравнения наименьших элементов каждого подмассива. Первые элементы каждого подмассива сравниваются первыми.
Наименьший элемент перемещается в результирующий массив. Счётчики результирующего массива и подмассива, откуда был взят элемент, увеличиваются на один.