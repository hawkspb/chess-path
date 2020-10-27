package com.example.chesspath.model;

import java.util.ArrayList;
import java.util.List;

public class Route {
    private final List<String> cells = new ArrayList<>();

    public Route() {
    }

    public Route(Route route) {
        cells.addAll(route.cells);
    }

    public void add(String cell) {
        cells.add(cell);
    }

    public boolean contains(String cell) {
        return cells.contains(cell);
    }

    public int size() {
        return cells.size();
    }

    public String toString() {
        return String.join(" -> ", cells);
    }
}
