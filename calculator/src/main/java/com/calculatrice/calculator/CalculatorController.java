package com.calculatrice.calculator;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {

    // Page d'accueil avec formulaire
    @GetMapping("/")
    public String index() {
        return "index";
    }

    // Calculer et afficher les résultats
    @PostMapping("/calculate")
    public String calculate(@RequestParam double firstNumber, 
                            @RequestParam double secondNumber, 
                            @RequestParam String operation, 
                            Model model) {

        double result = 0;

        switch (operation) {
            case "add":
                result = firstNumber + secondNumber;
                break;
            case "subtract":
                result = firstNumber - secondNumber;
                break;
            case "multiply":
                result = firstNumber * secondNumber;
                break;
            case "divide":
                if (secondNumber != 0) {
                    result = firstNumber / secondNumber;
                } else {
                    model.addAttribute("error", "Cannot divide by zero");
                    return "index";
                }
                break;
        }

        model.addAttribute("result", result);
        return "index";
    }
}

