package com.foodapplication.helper;

public class NotificationPopup {
    private String title;
    private String description;
    private String imageUrl;
    private String category;
    private String type;
    private String notificationId;

    public NotificationPopup(String title, String description, String imageUrl, String category, String type, String notificationId) {
        this.title = title;
        this.description = description;
        this.imageUrl = imageUrl;
        this.category = category;
        this.type = type;
        this.notificationId = notificationId;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getCategory() {
        return category;
    }

    public String getType() {
        return type;
    }

    public String getNotificationId() {
        return notificationId;
    }
}
