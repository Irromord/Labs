class Node{
    private int data;
    private Node left;
    private Node right;

    public Node(int element){
        data = element;
        left = null;
        right = null;
    }

    public void setRightChild(Node n)
    {
        right = n;
    }

    public void setLeftChild(Node n){
        left = n;
    }

    public Node getRightChild(){
        return right;
    }

    public Node getLeftChild(){
        return left;
    }

    public int getData(){
        return data;
    }

    public void setData(int x){
        data = x;
    }
}

class Tree{
    // метод поиска элемента в дереве
    public static Node search(int x, Node n){
        if (n==null || n.getData()==x) //если данные корня равны x, то элемент найден
            return n;
        else if(n.getData()>x) // x больше, поэтому мы будем искать нужное поддерево
            return search(x, n.getLeftChild());
        else //x меньше, чем данные, поэтому мы будем искать в левом поддереве
            return search(x, n.getRightChild());
    }

    //способ нахождения минимального значения в дереве
    public static Node findMinimum(Node root){
        if(root==null)
            return null;
        else if(root.getLeftChild() != null) // узел с минимальным значением не будет иметь левого дочернего элемента
            return findMinimum(root.getLeftChild()); // самый левый элемент будет минимальным
        return root;
    }

    // способ вставки нового узла
    public static Node insert(Node root, int x){
        if (root == null)
            return new Node(x);
        else if(x>root.getData()) //x больше. Должно быть вставлено справа
            root.setRightChild(insert(root.getRightChild(),x));
        else // x меньше должно быть вставлено слева
            root.setLeftChild(insert(root.getLeftChild(),x));
        return root;
    }

    // метод удаления узла
    public static Node delete(Node root, int x){
        //поиск элемента, подлежащего удалению
        if(root==null)
            return null;
        if (x>root.getData())
            root.setRightChild(delete(root.getRightChild(), x));
        else if(x<root.getData())
            root.setLeftChild(delete(root.getLeftChild(), x));
        else
        {
            //Нет дочерних элементов
            if(root.getLeftChild()==null && root.getRightChild()==null)
            {
                root = null;
                return null;
            }

            //Один элемент
            else if(root.getLeftChild()==null || root.getRightChild()==null)
            {
                Node temp;
                if(root.getLeftChild()==null)
                    temp = root.getRightChild();
                else
                    temp = root.getLeftChild();
                root = null;
                return temp;
            }

            //Два элемента
            else
            {
                Node temp = findMinimum(root.getRightChild());
                root.setData(temp.getData());
                root.setRightChild(delete(root.getRightChild(), temp.getData()));
            }
        }
        return root;
    }

    //упорядочивание
    public static void inorder(Node root){
        if(root!=null){ // проверка, не равен ли корень нулю
            inorder(root.getLeftChild());
            System.out.print(" "+root.getData()+" "); // печать данных в корне
            inorder(root.getRightChild());
        }
    }

    public static void main(String[] args){
        Node root;
        root = new Node(20);
        insert(root,5);
        insert(root,1);
        insert(root,15);
        insert(root,9);
        insert(root,7);
        insert(root,12);
        insert(root,30);
        insert(root,25);
        insert(root,40);
        insert(root, 45);
        insert(root, 42);
        inorder(root);
        System.out.println("");

        //удаление узлов
        root = delete(root, 1);
        root = delete(root, 40);
        root = delete(root, 45);
        root = delete(root, 9);
        inorder(root);
        System.out.println("");
    }
}