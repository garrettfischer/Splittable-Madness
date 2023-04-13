package edu.psu.ist.model;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

public class UtilListImpl<E> implements ISplittableList<E> {
    // "propagating" this   ^ generic E up into the       ^ interface

    private List<E> left = new LinkedList<>();
    private List<E> right = new LinkedList<>();

    // HINT: update this map whenever additions and removals are made to this.left or this.right.
    //       Then, when someone calls countOf(x), you can just lookup x in the map below and return
    //       the int count that comes back.
    private Map<E, Integer> countingMap = new HashMap<>();

    // (no constructor needed... unless you do the optional challenge)

    @Override
    public void addToRightAtFront(E e) {
        right.add(0, e);
        countingMap.merge(e, 1, Integer::sum);
    }

    @Override
    public E removeFromRightAtFront() {
        if (right.isEmpty()) {
            throw new NoSuchElementException("right list is empty");
        }
        E removed = right.remove(0);
        int count = countingMap.computeIfPresent(removed, (k, v) -> v - 1);
        if (count == 0) {
            countingMap.remove(removed);
        }
        return removed;
    }

    @Override
    public void moveToVeryBeginning() {
        right.addAll(0, left);
        countingMap.clear();
        left.clear();
        for (E e : right) {
            countingMap.merge(e, 1, Integer::sum);
        }
    }

    @Override
    public int countOf(E e) {
        return countingMap.getOrDefault(e, 0);
    }

    @Override
    public void moveForward() {
        if (right.isEmpty()) {
            throw new IllegalStateException("right list is empty");
        }
        E moved = right.remove(0);
        left.add(moved);
        int count = countingMap.computeIfPresent(moved, (k, v) -> v - 1);
        if (count == 0) {
            countingMap.remove(moved);
        }
        for (E e : left) {
            countingMap.merge(e, 1, Integer::sum);
        }
    }

    @Override
    public int leftLength() {
        return left.size();
    }

    @Override
    public int rightLength() {
        return right.size();
    }

    @Override
    public void clear() {
        left.clear();
        right.clear();
        countingMap.clear();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("<");
        boolean first = true;
        for (E e : left) {
            if (first) {
                sb.append(e);
                first = false;
            } else {
                sb.append(", ").append(e);
            }
        }
        sb.append("><");
        first = true;
        for (E e : right) {
            if (first) {
                sb.append(e);
                first = false;
            } else {
                sb.append(", ").append(e);
            }
        }
        return sb.append(">").toString();
    }
}
