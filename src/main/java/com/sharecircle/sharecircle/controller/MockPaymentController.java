
package com.sharecircle.sharecircle.controller;

import com.sharecircle.sharecircle.entity.Booking;
import com.sharecircle.sharecircle.entity.Item;
import com.sharecircle.sharecircle.repository.BookingRepository;
import com.sharecircle.sharecircle.repository.ItemRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class MockPaymentController {

    private final BookingRepository bookingRepository;
    private final ItemRepository itemRepository;

    public MockPaymentController(
            BookingRepository bookingRepository,
            ItemRepository itemRepository) {
        this.bookingRepository = bookingRepository;
        this.itemRepository = itemRepository;
    }

    // Open mock checkout page
    @GetMapping("/mock-checkout/{id}")
    public String checkout(@PathVariable Integer id, Model model) {

        Booking booking = bookingRepository.findById(id)
                .orElseThrow(() ->
                        new IllegalArgumentException("Booking not found"));

        Item item = itemRepository.findById(booking.getItemId())
                .orElseThrow(() ->
                        new IllegalArgumentException("Item not found"));

        model.addAttribute("booking", booking);
        model.addAttribute("item", item);

        return "mock-checkout";
    }

    // Simulate payment for college project
    @PostMapping("/mock-checkout/{id}/pay")
    public String makePayment(
            @PathVariable Integer id,
            @RequestParam String paymentMethod,
            @RequestParam String result,
            RedirectAttributes redirectAttributes) {

        Booking booking = bookingRepository.findById(id)
                .orElseThrow(() ->
                        new IllegalArgumentException("Booking not found"));

        if (!"SUCCESS".equals(result) && !"FAILED".equals(result)) {
            throw new IllegalArgumentException("Invalid payment result");
        }

        if ("SUCCESS".equals(result)) {
            booking.setPaymentStatus(
                    "COD".equals(paymentMethod) ? "COD" : "PAID");

            bookingRepository.save(booking);

            redirectAttributes.addFlashAttribute(
                    "successMessage",
                    "Demo payment successful! No real money was charged.");

        } else {
            booking.setPaymentStatus("FAILED");
            bookingRepository.save(booking);

            redirectAttributes.addFlashAttribute(
                    "errorMessage",
                    "Demo payment failed. No money was charged.");
        }

        return "redirect:/bookings/success?id=" + id;
    }
}
