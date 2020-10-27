package com.example.chesspath.model;

import java.util.Collections;
import java.util.List;

public class Pawn extends AbstractPiece {

    public Pawn(String initPosition) {
        super(initPosition);
    }

    @Override
    protected List<Deltas> deltas() {
        return Collections.singletonList(new Deltas(0, 1));
    }
}
