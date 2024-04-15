package kr.co.lotteon.repository;

import kr.co.lotteon.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<User, String> {
    Page<User> findByRoleNot(String role, Pageable pageable);
}
