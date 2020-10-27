package com.example.chesspath.model;

import java.util.Arrays;
import java.util.List;

public class Knight extends AbstractPiece {

    public Knight(String initPosition) {
        super(initPosition);
    }

    @Override
    protected List<Deltas> deltas() {
        return Arrays.asList(
                new Deltas(2, 1),
                new Deltas(2, -1),
                new Deltas(-2, 1),
                new Deltas(-2, -1),
                new Deltas(1, 2),
                new Deltas(-1, 2),
                new Deltas(1, -2),
                new Deltas(-1, -2)
        );
    }

}
