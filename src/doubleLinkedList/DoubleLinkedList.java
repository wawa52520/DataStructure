package doubleLinkedList;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class DoubleLinkedList<E> implements MyList<E> {
    private Node<E> preNode;
    private Node<E> nextNode;


    @Override
    public void add(E e) {
        boolean haveFirst = judgeFirst();
        //判断首节点的next是否有值，没有值时则为首次add
        if (!haveFirst){
            preNode.setPre(null);
            preNode.setValue(e);
            preNode.setNext(null);
        }else{

            nextNode.setPre(preNode.getNext());
        }
    }

    @Override
    public void delete(E e) {

    }

    @Override
    public E get(int i) {
        return null;
    }

    //判断首节点是否有值，有则返回true，无则返回false
    boolean judgeFirst(){
        return preNode.getNext() == null? false : true;
    };
}

class Node<E> {
    private Node<E> pre;
    private E value;
    private Node<E> next;

    public Node<E> getPre() {
        return pre;
    }

    public void setPre(Node<E> pre) {
        this.pre = pre;
    }

    public E getValue() {
        return value;
    }

    public void setValue(E value) {
        this.value = value;
    }

    public Node<E> getNext() {
        return next;
    }

    public void setNext(Node<E> next) {
        this.next = next;
    }
}
