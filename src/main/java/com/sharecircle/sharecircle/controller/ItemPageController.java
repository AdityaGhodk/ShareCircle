package com.sharecircle.sharecircle.controller;

import com.sharecircle.sharecircle.entity.Item;
import com.sharecircle.sharecircle.repository.ItemRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ItemPageController {

    private final ItemRepository itemRepository;

    public ItemPageController(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @GetMapping("/items/{id}")
    public String viewItemDetails(@PathVariable Integer id, Model model) {

        Item item = itemRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Item not found"));

        model.addAttribute("item", item);

        return "item-details";
    }
}