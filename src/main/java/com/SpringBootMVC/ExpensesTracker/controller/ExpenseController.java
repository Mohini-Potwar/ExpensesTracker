package com.SpringBootMVC.ExpensesTracker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.SpringBootMVC.ExpensesTracker.service.ExpenseService;
import com.SpringBootMVC.ExpensesTracker.entity.Expense;

import java.util.List;

@Controller
public class ExpenseController {

    @Autowired
    private ExpenseService expenseService;

    // Load the Track Expenses page
    @GetMapping("/track-expenses")
    public String trackExpenses(Model model) {
        return "track-expense";  // This points to the track-expense.html in templates
    }

    // Fetch expense data to send as JSON for chart rendering
    @GetMapping("/expenses-data")
    @ResponseBody
    public List<Expense> getExpensesData() {
        return expenseService.findAllExpenses();  // Use findAllExpenses() instead of getAllExpenses()
    }
}

