
package com.sharecircle.sharecircle.dto;

import java.time.LocalDate;

public class BookingRequest {

    private Long userId;
    private Integer itemId;
    private LocalDate startDate;
    private LocalDate endDate;

    public BookingRequest() {
    }

    public BookingRequest(Long userId, Integer itemId,
                          LocalDate startDate, LocalDate endDate) {
        this.userId = userId;
        this.itemId = itemId;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }
}
