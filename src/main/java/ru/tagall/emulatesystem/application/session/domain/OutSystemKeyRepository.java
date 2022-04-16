package ru.tagall.emulatesystem.application.session.domain;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OutSystemKeyRepository extends JpaRepository<OutSystemKey, Long> {
    OutSystemKey getByKey(String key);
}
