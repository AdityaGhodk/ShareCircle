
package com.sharecircle.sharecircle.service;

import com.sharecircle.sharecircle.entity.Item;
import com.sharecircle.sharecircle.repository.ItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {

    private final ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    // Add new item
    public Item addItem(Item item) {
        return itemRepository.save(item);
    }

    // Get all items
    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }

    // Get item by ID
    public Item getItemById(Integer id) {
        return itemRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Item not found!"));
    }

    // Get items by category
    public List<Item> getItemsByCategory(String category) {
        return itemRepository.findByCategory(category);
    }

    // Get items by status
    public List<Item> getItemsByStatus(String status) {
        return itemRepository.findByStatus(status);
    }

    // Search items by name
    public List<Item> searchItems(String name) {
        return itemRepository.findByNameContainingIgnoreCase(name);
    }

    // Update item
    public Item updateItem(Integer id, Item updatedItem) {
        Item existingItem = getItemById(id);

        existingItem.setName(updatedItem.getName());
        existingItem.setDescription(updatedItem.getDescription());
        existingItem.setCategory(updatedItem.getCategory());
        existingItem.setPrice(updatedItem.getPrice());
        existingItem.setCondition(updatedItem.getCondition());
        existingItem.setLocation(updatedItem.getLocation());
        existingItem.setImageUrl(updatedItem.getImageUrl());
        existingItem.setStatus(updatedItem.getStatus());

        return itemRepository.save(existingItem);
    }

    // Delete item
    public void deleteItem(Integer id) {
        Item item = getItemById(id);
        itemRepository.delete(item);
    }
}
