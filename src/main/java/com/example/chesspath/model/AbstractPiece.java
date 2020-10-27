package com.example.chesspath.model;

import com.example.chesspath.utils.BoardUtils;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public abstract class AbstractPiece implements Piece {
    protected String position;

    protected abstract List<Deltas> deltas();

    public AbstractPiece(String initPosition) {
        position = initPosition;
    }

    @Override
    public List<String> next() {
        return deltas().stream()
                .map(deltas -> BoardUtils.move(position, deltas.horizontal, deltas.vertical))
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }

}
