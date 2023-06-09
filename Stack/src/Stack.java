class Stack {//создадили класс Stack
    private int maxSize;
    private int[] stackArray;
    private int top;
    public Stack(int size) {
        this.maxSize = size;
        this.stackArray = new int[maxSize];
        this.top = -1;
    }

    public void push(int element) {
        if (isFull()) {
            System.out.println("Stack is full");
        } else {
            top++;
            stackArray[top] = element;
        }
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty"); // возвращаем значение по умолчанию, если стек пустой
            return -1;

        } else { // если стек непустой, то выдаем верхний элемент, уменьшая top

            int temp = stackArray[top]; // temp - для хранения "выдаваемого" (удаляемого) элемента

            top--; // "удаляем" (просто "забываем") выдаваемый (удаляемый) элемент

            return temp; // "выдаём" temp
        }
    }
    public boolean isEmpty() {
        return (top == -1);
    }
    public boolean isFull() {
        return (top == maxSize - 1);

    }
}