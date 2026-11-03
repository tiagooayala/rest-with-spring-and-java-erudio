package br.com.erudio.controllers;

import br.com.erudio.services.MathService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/math")
public class MathController {

    private final MathService mathService;

    public MathController(MathService mathService) {
        this.mathService = mathService;
    }

    @RequestMapping("/sum/{numberOne}/{numberTwo}")
    public Double sum(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
        return mathService.sum(numberOne, numberTwo);
    }

    @RequestMapping("/subtraction/{numberOne}/{numberTwo}")
    public Double subtraction(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
        return mathService.subtraction(numberOne, numberTwo);
    }

    @RequestMapping("/multiplication/{numberOne}/{numberTwo}")
    public Double multiplication(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
        return mathService.multiplication(numberOne, numberTwo);
    }

    @RequestMapping("/division/{numberOne}/{numberTwo}")
    public Double division(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
        return mathService.division(numberOne, numberTwo);
    }

    @RequestMapping("/average/{numberOne}/{numberTwo}")
    public Double average(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
        return mathService.average(numberOne, numberTwo);
    }

    @RequestMapping("/sqrt/{number}")
    public Double sqrt(@PathVariable("number") String number) throws Exception {
        return mathService.squareRoot(number);
    }
}
