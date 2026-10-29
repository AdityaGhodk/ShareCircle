
package com.sharecircle.sharecircle.dto;

public class ReviewRequest {

    private Long userId;
    private Integer itemId;
    private Integer rating;
    private String comment;

    public ReviewRequest() {
    }

    public ReviewRequest(Long userId, Integer itemId,
                         Integer rating, String comment) {
        this.userId = userId;
        this.itemId = itemId;
        this.rating = rating;
        this.comment = comment;
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

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
