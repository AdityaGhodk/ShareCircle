
package com.sharecircle.sharecircle.controller;

import com.sharecircle.sharecircle.repository.ItemRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BrowseController {

    private final ItemRepository itemRepository;

    public BrowseController(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @GetMapping("/items")
    public String browseItems(
            @RequestParam(required = false) String search,
            Model model) {

        if (search != null && !search.trim().isEmpty()) {
            model.addAttribute("items",
                    itemRepository.findByNameContainingIgnoreCase(search.trim()));
        } else {
            model.addAttribute("items", itemRepository.findAll());
        }

        model.addAttribute("search", search);
        return "browse";
    }
}
