
package com.liaqaty.liaqaty.repository;

import com.liaqaty.liaqaty.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
