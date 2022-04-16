package ru.tagall.emulatesystem.application.session.domain;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerKeyRepository extends JpaRepository<CustomerKey, Long> {
    CustomerKey getByKey(String key);
}
