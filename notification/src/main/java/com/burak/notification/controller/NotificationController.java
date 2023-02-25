package com.burak.notification.controller;

import com.burak.notification.model.EmailType;
import com.burak.notification.service.impl.NotificationServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * onepay
 * Created by Alexey Burak
 * Feb 2023
 */

@RestController
@RequestMapping("/api/notifications")
@RequiredArgsConstructor
public class NotificationController {
    private final NotificationServiceImpl notificationService;

    @PostMapping("/{userId}")
    public ResponseEntity<String> notificateUser(@PathVariable("userId") Long userId,
                                                 @RequestParam("type") EmailType type) {
        notificationService.sendNotification(userId, type);
        return ResponseEntity.ok("Send notification successfully");
    }

}
