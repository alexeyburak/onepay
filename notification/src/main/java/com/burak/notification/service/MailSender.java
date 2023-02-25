package com.burak.notification.service;

import com.burak.notification.dto.UserDTO;

/**
 * onepay
 * Created by Alexey Burak
 * Feb 2023
 */

public interface MailSender {
    void greetingEmail(UserDTO user);
    void changePasswordEmail(UserDTO user);
    void dailyEmail(UserDTO user);
}
