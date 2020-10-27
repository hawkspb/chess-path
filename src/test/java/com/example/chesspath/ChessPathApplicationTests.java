package com.example.chesspath;

import com.example.chesspath.model.Route;
import com.example.chesspath.service.PathCalculator;
import com.example.chesspath.utils.Code;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
class ChessPathApplicationTests {
    @Autowired
    private PathCalculator calculator;

    @Test
    void emptyRoute() {
        String position = "D3";

        Route expected = new Route().add(position);
        Route calculated = calculator.calculate(Code.Kn, position, position, 3);

        assertEquals(calculated, expected);
    }

    @Test
    void existingSizedRoute() {
        String start = "D3";
        String end = "G7";
        int moves = 3;

        Route expected = new Route().add(start).add("F4").add("H5").add(end);
        Route calculated = calculator.calculate(Code.Kn, start, end, moves);
        
        assertEquals(calculated, expected);
    }

    @Test
    void unexistingSizedRoute() {
        String start = "D3";
        String end = "G7";
        int moves = 2; // there is no route with two moves

        assertThrows(RuntimeException.class, () -> calculator.calculate(Code.Kn, start, end, moves));
    }

}
