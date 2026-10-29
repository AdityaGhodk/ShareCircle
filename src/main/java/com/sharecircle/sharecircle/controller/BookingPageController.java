
package com.sharecircle.sharecircle.controller;

import com.sharecircle.sharecircle.entity.Booking;
import com.sharecircle.sharecircle.entity.Item;
import com.sharecircle.sharecircle.repository.BookingRepository;
import com.sharecircle.sharecircle.repository.ItemRepository;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Controller
public class BookingPageController {

    private final ItemRepository itemRepository;
    private final BookingRepository bookingRepository;

    public BookingPageController(
            ItemRepository itemRepository,
            BookingRepository bookingRepository) {
        this.itemRepository = itemRepository;
        this.bookingRepository = bookingRepository;
    }

    // Show booking form
    @GetMapping("/bookings/new")
    public String showBookingForm(
            @RequestParam Integer itemId,
            Model model) {

        Item item = itemRepository.findById(itemId)
                .orElseThrow(() ->
                        new IllegalArgumentException("Item not found"));

        model.addAttribute("item", item);

        return "booking-form";
    }

    // Confirm booking and redirect to mock checkout
    @PostMapping("/bookings/confirm")
    public String confirmBooking(
            @RequestParam Integer itemId,
            @RequestParam LocalDate startDate,
            @RequestParam LocalDate endDate,
            RedirectAttributes redirectAttributes) {

        // Validate booking dates
        if (startDate.isBefore(LocalDate.now())
                || endDate.isBefore(startDate)) {

            redirectAttributes.addFlashAttribute(
                    "errorMessage",
                    "Please select valid booking dates.");

            return "redirect:/bookings/new?itemId=" + itemId;
        }

        // Find selected item
        Item item = itemRepository.findById(itemId)
                .orElseThrow(() ->
                        new IllegalArgumentException("Item not found"));

        // Calculate rental amount
        long days = ChronoUnit.DAYS.between(startDate, endDate) + 1;
        double totalPrice = days * item.getPrice();

        // Create booking
        Booking booking = new Booking();

        booking.setItemId(itemId);
        booking.setStartDate(startDate);
        booking.setEndDate(endDate);
        booking.setTotalPrice(totalPrice);
        booking.setSecurityDeposit(0);
        booking.setStatus("PENDING");

        // Temporary demo user ID
        booking.setUserId(1);

        // Save booking to database
        Booking savedBooking = bookingRepository.save(booking);

        // Open mock payment checkout
        return "redirect:/mock-checkout/" + savedBooking.getId();
    }

    // Show booking confirmation
    @GetMapping("/bookings/success")
    public String bookingSuccess(
            @RequestParam Integer id,
            Model model) {

        Booking booking = bookingRepository.findById(id)
                .orElseThrow(() ->
                        new IllegalArgumentException("Booking not found"));

        Item item = itemRepository.findById(booking.getItemId())
                .orElseThrow(() ->
                        new IllegalArgumentException("Item not found"));

        model.addAttribute("booking", booking);
        model.addAttribute("item", item);

        return "booking-success";
    }

    // Show My Bookings page
    @GetMapping("/my-bookings")
    public String showMyBookings(Model model) {

        model.addAttribute(
                "bookings",
                bookingRepository.findByUserId(1)
        );

        return "my-bookings";
    }
}
