
package com.sharecircle.sharecircle.controller;

import com.sharecircle.sharecircle.repository.ItemRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class CategoryPageController {

    private final ItemRepository itemRepository;

    public CategoryPageController(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @GetMapping("/category/{category}")
    public String showCategory(
            @PathVariable String category,
            Model model) {

        if (category.equalsIgnoreCase("Others")
                || category.equalsIgnoreCase("Other")) {

            model.addAttribute("category", "Others");

            model.addAttribute(
                    "items",
                    itemRepository.findByCategoryIn(List.of(
                            "Clothing",
                            "Kitchen",
                            "Tools",
                            "Musical Instruments"
                    ))
            );

        } else {
            model.addAttribute("category", category);

            model.addAttribute(
                    "items",
                    itemRepository.findByCategoryIgnoreCase(category)
            );
        }

        return "category-products";
    }
}
