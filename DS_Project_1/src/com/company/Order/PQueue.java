package com.company.Order;

public class PQueue {
    private Order[] heap = new Order[100];
    private int lastIndex;
    private static final int first = 1;

    /**
     * in PQueue constructor:
     * we initialize lastIndex to zero and it shows the last order in the array
     * we initialize an empty order at index zero
     * bigO(1)
     */
    public PQueue() {
        this.setLastIndex(0);
        Order empty = new Order();
        empty.setImmediacyLevel(10);
        heap[0] = empty;
    }

    /**
     * in addOrder method it will add an order to the end of the max heap and set a time for priority.
     * it checks this new order immediacy lvl with its parents immediacy lvl if its immediacy lvl was greater it will swap with its parent.
     * this action will happen till the new order immediacy lvl is not greater than its parent immediacy lvl.
     * we have a swap method in this , it swap two data in our array
     * addOrder method bigO(log(n))
     *
     * @param order this i the order we want to add it to our max heap
     */
    public void addOrder(Order order) {
        setLastIndex(getLastIndex() + 1);
        order.setTime(getLastIndex());
        heap[getLastIndex()] = order;
        int current = getLastIndex();
        while (heap[current].getImmediacyLevel() > heap[parent(current)].getImmediacyLevel()) {
            swap(current, parent(current));
            current = parent(current);
        }
    }

    /**
     * makeMaxHeap method will make a tree max heap again recursively.
     * if the node we took it as input doesn't had any child its a heap!
     * first we make an int and name it highestPriority and initialize it with first
     * if it had left child it checks parent with left child by its priority , if left child was higher in priority we initialize highestPriority with left child index.
     * if it had right child it will compare it with highestPriority and if right child was higher in priority we initialize highestPriority with right child index.
     * after these if it had left child and right child it checks if these two had equal priority with highestPriority it will choose the one which added sooner in the heap.
     * at the end if highestPriority was equal to first its a heap!
     * makeMaxHeap method bigO(log(n))
     *
     * @param first its the node node of the tree we want to make it max heap
     */
    private void makeMaxHeap(int first) {

        int highestPriority = first;
        if (leftChild(first) <= getLastIndex() && heap[leftChild(first)].getImmediacyLevel() > heap[first].getImmediacyLevel()) {
            highestPriority = leftChild(first);
        }
        if (rightChild(first) <= getLastIndex() && heap[rightChild(first)].getImmediacyLevel() > heap[highestPriority].getImmediacyLevel()) {
            highestPriority = rightChild(first);
        }
        if (leftChild(first) <= getLastIndex() && rightChild(first) <= getLastIndex()) {
            if (heap[leftChild(first)].getImmediacyLevel() == heap[rightChild(first)].getImmediacyLevel() && heap[rightChild(first)].getImmediacyLevel() == heap[highestPriority].getImmediacyLevel()) {
                if (heap[leftChild(first)].getTime() < heap[rightChild(first)].getTime()) {
                    highestPriority = leftChild(first);
                } else highestPriority = rightChild(first);
            }
        }
        if (highestPriority != first) {
            swap(first, highestPriority);
            makeMaxHeap(highestPriority);
        }
    }

    /**
     * printOrders method will print all orders in the array also delete them.
     * we have a makeMaxHeap method in this.
     * printOrder method bigO(n*log(n))
     */
    public void printOrders() {
        while (getLastIndex() != 0) {
            System.out.println(heap[getFirst()].getCustomerName());
            heap[getFirst()] = heap[getLastIndex()];
            setLastIndex(getLastIndex() - 1);
            makeMaxHeap(getFirst());
        }
    }

    /**
     * parent method
     * @param index its a node in our tree
     * @return its return the node's parent
     */
    private int parent(int index) {
        return (index / 2);
    }

    /**
     * leftChild method
     * @param index its a node in our tree
     * @return its return the node's left child
     */
    private int leftChild(int index) {
        return (2 * index);
    }

    /**
     * rightChild method
     * @param index its a node in our tree
     * @return its return the node's right child
     */
    private int rightChild(int index) {
        return (2 * index) + 1;
    }

    /**
     * swap method will swap two node in our tree
     * @param f1 first node
     * @param f2 second node
     */
    private void swap(int f1, int f2) {
        Order temp;
        temp = heap[f1];
        heap[f1] = heap[f2];
        heap[f2] = temp;
    }

    private int getLastIndex() {
        return lastIndex;
    }

    private void setLastIndex(int lastIndex) {
        this.lastIndex = lastIndex;
    }

    private static int getFirst() {
        return first;
    }
}
