package com.example.VerteilteSystemeLogIn.registration.token;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ConfirmationTokenService {

    private final ConfirmationTokenRepository ConfirmationTokenRepository;

    public void saveConfirmationToken(ConfirmationToken token) {

        ConfirmationTokenRepository.save(token);
    }

    public Optional<ConfirmationToken> getToken(String token) {

        return ConfirmationTokenRepository.findByToken(token);
    }

    public int setConfirmedAt(String token) {

        return ConfirmationTokenRepository.updateConfirmedAt(token, LocalDateTime.now());
    }
}