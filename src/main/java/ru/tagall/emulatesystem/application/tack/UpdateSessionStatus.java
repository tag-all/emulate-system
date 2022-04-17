package ru.tagall.emulatesystem.application.tack;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import ru.tagall.emulatesystem.application.session.domain.SessionRepository;

import java.time.LocalDateTime;

@Service
@Slf4j
@RequiredArgsConstructor
@EnableScheduling
public class UpdateSessionStatus {

    private final SessionRepository sessionRepository;

    @Scheduled(cron = "0/1 * * * * *")
    public void closeSession() {
        sessionRepository.getAllByStatus("ACTIVE").forEach(it -> {
            if(it.getEndTime().isBefore(LocalDateTime.now())){
                sessionRepository.setNewStatus("CLOSE", it.getId());
            }
        });
    }
}
