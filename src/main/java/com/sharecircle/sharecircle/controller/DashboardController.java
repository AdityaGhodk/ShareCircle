
package com.sharecircle.sharecircle.controller;

import com.sharecircle.sharecircle.entity.Item;
import com.sharecircle.sharecircle.repository.ItemRepository;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class DashboardController {

    private final ItemRepository itemRepository;

    public DashboardController(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @GetMapping("/dashboard")
    public String dashboard(Model model) {

        List<Item> items =
                itemRepository.findByStatusIgnoreCase("AVAILABLE");

        model.addAttribute("items", items);

        return "dashboard";
    }
}
