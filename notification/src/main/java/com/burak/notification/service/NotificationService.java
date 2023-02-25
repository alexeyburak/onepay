package com.burak.notification.service;

import com.burak.notification.model.EmailType;

/**
 * onepay
 * Created by Alexey Burak
 * Feb 2023
 */

@FunctionalInterface
public interface NotificationService {
    void sendNotification(long userId, EmailType type);
}
