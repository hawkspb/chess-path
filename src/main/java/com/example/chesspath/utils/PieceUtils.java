package com.example.chesspath.utils;

import com.example.chesspath.model.Knight;
import com.example.chesspath.model.Pawn;
import com.example.chesspath.model.Piece;

public class PieceUtils {

    public static Piece get(Code code, String initPosition) {
        switch (code.name()) {
            case "Kn":
                return new Knight(initPosition);
            case "P":
                return new Pawn(initPosition);
            default:
                throw new RuntimeException(String.format("No piece with code = %s implemented!", code));
        }
    }

}
