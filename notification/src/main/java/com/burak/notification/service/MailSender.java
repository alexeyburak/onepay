package com.burak.notification.service;

import com.burak.notification.model.EmailType;

/**
 * onepay
 * Created by Alexey Burak
 * Feb 2023
 */

public interface MailSender {
    void greetingEmail(long userId, EmailType type);
}
