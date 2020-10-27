package com.example.chesspath.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Route {
    private final List<String> cells = new ArrayList<>();

    public Route() {
    }

    public Route(Route route) {
        cells.addAll(route.cells);
    }

    public Route add(String cell) {
        cells.add(cell);
        return this;
    }

    public boolean contains(String cell) {
        return cells.contains(cell);
    }

    public int size() {
        return cells.size();
    }

    @Override
    public String toString() {
        return String.join(" -> ", cells);
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;

        Route route = (Route) other;
        return size() == route.size() && cells.containsAll(route.cells);
    }

}
