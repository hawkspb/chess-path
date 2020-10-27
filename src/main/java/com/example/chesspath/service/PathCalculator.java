package com.example.chesspath.service;

import com.example.chesspath.model.Piece;
import com.example.chesspath.model.Route;
import com.example.chesspath.utils.Code;
import com.example.chesspath.utils.PieceUtils;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

@Service
public class PathCalculator {

    public String calculate(Code code, String start, String end, int movesThreshold) {
        Route route = new RouteTask(code, start, end, movesThreshold, new Route()).compute();

        if (route == null) throw new RuntimeException("No routes found!");
        return route.toString();
    }

    private static class RouteTask extends RecursiveTask<Route> {
        private final Code code;
        private final String position;
        private final String end;
        private final int movesRemaining;
        private final Route route;

        public RouteTask(Code code, String position, String end, int movesRemaining, Route route) {
            this.code = code;
            this.position = position;
            this.end = end;
            this.movesRemaining = movesRemaining;
            this.route = route;
        }

        @Override
        protected Route compute() {
            if (movesRemaining < 0 || route.contains(position)) return null;

            route.add(position);
            if (position.equals(end)) return route;

            Piece piece = PieceUtils.get(code, position);
            List<ForkJoinTask<Route>> tasks = new ArrayList<>();
            for (String next : piece.next()) {
                tasks.add(new RouteTask(code, next, end, movesRemaining - 1, new Route(route)).fork());
            }

            Route shortest = null;
            for (ForkJoinTask<Route> task : tasks) {
                Route route = task.join();
                if (route == null) continue;

                int size = route.size();
                if (shortest == null || size < shortest.size()) shortest = route;
            }

            return shortest;
        }

    }

}
