package br.com.erudio.services;

import br.com.erudio.exception.UnsupportedMathOperationException;
import org.springframework.stereotype.Service;

@Service
public class MathService {

    public Double sum(String numberOne, String numberTwo) {
        doubleVerification(numberOne, numberTwo);
        return convertToDouble(numberOne) + convertToDouble(numberTwo);
    }

    public Double subtraction(String numberOne, String numberTwo) {
        doubleVerification(numberOne, numberTwo);
        return convertToDouble(numberOne) - convertToDouble(numberTwo);
    }

    public Double multiplication(String numberOne, String numberTwo) {
        doubleVerification(numberOne, numberTwo);
        return convertToDouble(numberOne) * convertToDouble(numberTwo);
    }

    public Double division(String numberOne, String numberTwo) {
        doubleVerification(numberOne, numberTwo);
        if (convertToDouble(numberTwo) == 0) {
            throw new UnsupportedMathOperationException("Division by zero!");
        }
        return convertToDouble(numberOne) / convertToDouble(numberTwo);
    }

    public Double average(String numberOne, String numberTwo) {
        doubleVerification(numberOne, numberTwo);
        return (convertToDouble(numberOne) + convertToDouble(numberTwo)) / 2;
    }

    public Double squareRoot(String number) {
        if(!isNumeric(number)) {
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        }
        if (convertToDouble(number) < 0) {
            throw new UnsupportedMathOperationException("Negative numbers are not allowed!");
        }
        return Math.sqrt(convertToDouble(number));
    }

    private void doubleVerification(String numberOne, String numberTwo) {
        if(!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        }
    }

    private Double convertToDouble(String strNumber) {
        if (strNumber == null) {
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        }
        String number = strNumber.replaceAll(",", ".");
        return Double.parseDouble(number);
    }

    private boolean isNumeric(String strNumber) {
        if (strNumber == null || strNumber.isEmpty()) {
            return false;
        }
        String number = strNumber.replaceAll(",", ".");
        return number.matches("[-+]?[0-9]*\\.?[0-9]+");
    }
}
