package Deposit;

import Valuables.Valuables;
import utility.collection.ArrayList;

import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class Deposit implements BlockingQueue<Valuables> {
    private final ArrayList<Valuables> elements;
    private final int capacity;
    public Deposit(int capacity){
        this.capacity = capacity;
        this.elements = new ArrayList<>();
    }

    @Override
    public synchronized boolean add(Valuables valuables) {
        if (size() >= capacity) throw new IllegalStateException();
        elements.add(valuables);
        return true;
    }

    @Override
    public synchronized boolean offer(Valuables valuables) {
        if (size() >= capacity) return false;
        elements.add(valuables);
        return true;
    }

    @Override
    public  synchronized void put(Valuables valuables) throws InterruptedException {
        while (size() >= capacity) {
            wait();
        }
        elements.add(valuables);
        notifyAll();
    }

    @Override
    public boolean offer(Valuables valuables, long timeout, TimeUnit unit) throws InterruptedException {
        return false; //nie
    }

    @Override
    public Valuables take() throws InterruptedException {
        return null; //idk
    }

    @Override
    public Valuables poll(long timeout, TimeUnit unit) throws InterruptedException {
        return null; // nie
    }

    @Override
    public synchronized int remainingCapacity() {
        return capacity - elements.size();
    }

    @Override
    public synchronized boolean remove(Object o) {
        if (isEmpty()) throw new IllegalStateException();
        elements.remove((Valuables)  o);
        return true;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false; //skip
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false; //skip
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false; //skip
    }

    @Override
    public void clear() {
        //skip
    }

    @Override
    public boolean addAll(Collection<? extends Valuables> c) {
        return false; //skip
    }

    @Override
    public synchronized int size() {
        return elements.size();
    }

    @Override
    public  synchronized boolean isEmpty() {
        return elements.isEmpty();
    }

    @Override
    public synchronized boolean contains(Object o) {
        return elements.contains((Valuables) o);
    }

    @Override
    public Iterator<Valuables> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public int drainTo(Collection<? super Valuables> c, int maxElements) {
        return 0;
    }

    @Override
    public int drainTo(Collection<? super Valuables> c) {
        return 0;
    }

    @Override
    public Valuables remove() {
        return null; //skip
    }

    @Override
    public Valuables poll() {
        return null; //idk ale chyba wazne
    }

    @Override
    public Valuables element() {
        return null; //skip
    }

    @Override
    public Valuables peek() {
        return null; //idk
    }
}
