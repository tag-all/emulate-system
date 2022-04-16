package ru.tagall.emulatesystem.config;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.web.filter.OncePerRequestFilter;
import ru.tagall.emulatesystem.application.session.domain.CustomerKey;
import ru.tagall.emulatesystem.application.session.domain.CustomerKeyRepository;
import ru.tagall.emulatesystem.application.session.domain.OutSystemKey;
import ru.tagall.emulatesystem.application.session.domain.OutSystemKeyRepository;
import ru.tagall.emulatesystem.config.model.SaveInfo;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static org.springframework.util.StringUtils.hasText;

@Component
@RequiredArgsConstructor
public class JwtFilter extends OncePerRequestFilter {
    public static final String CUSTOMER_KEY = "CustomerKey";

    public static final String SYSTEM_KEY = "SystemKey";

    private final OutSystemKeyRepository outSystemKeyRepository;

    private final CustomerKeyRepository customerKeyRepository;

    @Override
    public void doFilterInternal(@NonNull HttpServletRequest request, @NonNull HttpServletResponse response,
                                 @NonNull FilterChain filterChain)
            throws IOException, ServletException {
        OutSystemKey outSystemKey = outSystemKeyRepository.getByKey(getSystemKey(request));
        CustomerKey customerKey = customerKeyRepository.getByKey(getCustomerKey(request));
        if (!ObjectUtils.isEmpty(outSystemKey) && !ObjectUtils.isEmpty(customerKey)) {
            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
                    SaveInfo.of(customerKey.getCustomer().getId()), null, null);
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }
        filterChain.doFilter(request, response);
    }

    private String getCustomerKey(HttpServletRequest request) {
        String bearer = request.getHeader(CUSTOMER_KEY);
        if (hasText(bearer) && bearer.startsWith("Key: ")) {
            return bearer.substring(5);
        }
        return null;
    }

    private String getSystemKey(HttpServletRequest request) {
        String bearer = request.getHeader(SYSTEM_KEY);
        if (hasText(bearer) && bearer.startsWith("Key: ")) {
            return bearer.substring(5);
        }
        return null;
    }
}