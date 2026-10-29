
package com.sharecircle.sharecircle.controller;

import com.sharecircle.sharecircle.entity.Item;
import com.sharecircle.sharecircle.service.ItemService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/items")
public class ItemController {

    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    // Get all items
    @GetMapping
    public List<Item> getAllItems() {
        return itemService.getAllItems();
    }

    // Get item by ID
    @GetMapping("/{id}")
    public Item getItemById(@PathVariable Integer id) {
        return itemService.getItemById(id);
    }

    // Add new item
    @PostMapping
    public Item addItem(@RequestBody Item item) {
        return itemService.addItem(item);
    }

    // Update item
    @PutMapping("/{id}")
    public Item updateItem(
            @PathVariable Integer id,
            @RequestBody Item item) {
        return itemService.updateItem(id, item);
    }

    // Delete item
    @DeleteMapping("/{id}")
    public String deleteItem(@PathVariable Integer id) {
        itemService.deleteItem(id);
        return "Item deleted successfully!";
    }

    // Search items by category
    @GetMapping("/category/{category}")
    public List<Item> getItemsByCategory(
            @PathVariable String category) {
        return itemService.getItemsByCategory(category);
    }

    // Search items by status
    @GetMapping("/status/{status}")
    public List<Item> getItemsByStatus(
            @PathVariable String status) {
        return itemService.getItemsByStatus(status);
    }

    // Search items by name
    @GetMapping("/search")
    public List<Item> searchItems(@RequestParam String name) {
        return itemService.searchItems(name);
    }
}
