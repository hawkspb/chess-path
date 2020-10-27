package com.example.chesspath.controller;

import com.example.chesspath.service.PathCalculator;
import com.example.chesspath.utils.Code;
import com.example.chesspath.validation.ChessBoardCell;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Validated
public class ApiController {
    private final PathCalculator calculator;

    public ApiController(@Autowired PathCalculator calculator) {
        this.calculator = calculator;
    }

    @RequestMapping("/path")
    public String path(@RequestParam(value = "piece", required = false, defaultValue = "Kn") Code piece,
                       @RequestParam("start") @ChessBoardCell String start,
                       @RequestParam("end") @ChessBoardCell String end,
                       @RequestParam(value = "moves", required = false, defaultValue = "3") int movesThreshold) {
        return calculator.calculate(piece, start, end, movesThreshold).toString();
    }

}
