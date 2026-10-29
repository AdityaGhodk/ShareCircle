
package com.sharecircle.sharecircle.controller;

import com.sharecircle.sharecircle.repository.ItemRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    private final ItemRepository itemRepository;

    public HomeController(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("items",
                itemRepository.findTop4ByOrderByIdAsc());
        return "home";
    }
}
