
package com.sharecircle.sharecircle.repository;

import com.sharecircle.sharecircle.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<Item, Integer> {

    List<Item> findByCategory(String category);

    List<Item> findByCategoryIn(List<String> categories);

    List<Item> findByCategoryIgnoreCase(String category);

    List<Item> findByStatus(String status);

    List<Item> findByNameContainingIgnoreCase(String name);

    List<Item> findTop4ByOrderByIdAsc();
}
