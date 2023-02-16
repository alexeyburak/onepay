package com.burak.user.repository;

import com.burak.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * onepay
 * Created by Alexey Burak
 * Feb 2023
 */

public interface UserRepository extends JpaRepository<User, Long> {
}
