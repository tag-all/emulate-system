package ru.tagall.emulatesystem.application.session.service.Impl;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import ru.tagall.emulatesystem.application.session.domain.CustomerRepository;
import ru.tagall.emulatesystem.application.session.domain.Session;
import ru.tagall.emulatesystem.application.session.domain.SessionRepository;
import ru.tagall.emulatesystem.application.session.model.SessionDto;
import ru.tagall.emulatesystem.application.session.model.SessionsDto;
import ru.tagall.emulatesystem.application.session.service.SessionService;
import ru.tagall.emulatesystem.config.model.SaveInfo;
import ru.tagall.emulatesystem.error.ErrorDescription;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Slf4j
public class SessionServiceImpl implements SessionService {

    /**
     * {@link SessionRepository}.
     */
    private final SessionRepository sessionRepository;

    private final CustomerRepository customerRepository;

    @Override
    public SessionsDto getSessionByType(String sessionType) {
        return SessionsDto.of(sessionRepository.getAllByStatus(sessionType).stream().map(this::convertToSessionsDto)
                .collect(Collectors.toList()));
    }

    @Override
    public SessionDto getSessionById(Long sessionId) {
        return convertToSessionsDto(sessionRepository.getById(sessionId));
    }

    @Override
    public void betToSession(Long sessionId) {
        SaveInfo saveInfo = (SaveInfo) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Session session = sessionRepository.getById(sessionId);
        boolean canNotBet = !ObjectUtils.isEmpty(session.getLastBetCustomer()) &&
                saveInfo.getCustomerId().equals(session.getLastBetCustomer().getId());
        ErrorDescription.CUSTOMER_BED_BET.throwIfTrue(canNotBet);
        if (Duration.between(session.getEndTime(), LocalDateTime.now()).compareTo(Duration.ofMinutes(5)) < 0) {
            session.getEndTime().plusMinutes(5);
        }
        session.setLastBetCustomer(customerRepository.getById(saveInfo.getCustomerId()));
        double val = session.getCurrentPrice() - session.getStartPrice() * session.getBet();
        log.info("update value: {}", val);
        session.setCurrentPrice(val);
        sessionRepository.save(session);
    }

    private SessionDto convertToSessionsDto(Session session) {
        SessionDto sessionDto = new SessionDto();
        sessionDto.setId(session.getId());
        sessionDto.setSessionName(session.getName());
        sessionDto.setCustomerName(session.getCustomer().getCompanyName());
        sessionDto.setCurrentPrice(session.getCurrentPrice());
        sessionDto.setStart(session.getStartTime());
        sessionDto.setEnd(session.getEndTime());
        sessionDto.setBet(session.getBet());
        sessionDto.setLocation(session.getLocation());
        String companyBet = ObjectUtils.isEmpty(session.getLastBetCustomer())
                ? ""
                : session.getLastBetCustomer().getCompanyName();
        sessionDto.setLastCustomerBet(companyBet);
        sessionDto.setStatus(session.getStatus());
        return sessionDto;
    }
}
