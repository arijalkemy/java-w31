package com.mercadolibre.kvs.demo.services;

import com.mercadolibre.kvs.demo.exceptions.NoSuchElementException;
import com.mercadolibre.kvs.demo.exceptions.RateLimitException;
import com.mercadolibre.kvs.demo.models.User;
import com.mercadolibre.kvs.demo.repository.UserRepositoryJdbc;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Slf4j
@Service
public class UserKVSService {
    private final Map<Long, User> kvsSimulado = new HashMap<>();
    private static final int MAX_RETRIES = 2;
    private final UserRepositoryJdbc userRepository;

    public UserKVSService(UserRepositoryJdbc userRepository) {
        this.userRepository = userRepository;
    }

    public void createUser(User user) {
        executeWithRetry(() -> {
            verificarRateLimit();
            kvsSimulado.put(user.getId(), user);
            return null;
        });
    }
    public User getUser(Long id) {
        return executeWithRetry(() -> {
            verificarRateLimit();
            User user = kvsSimulado.get(id);
            if (user == null) {
                throw new NoSuchElementException("Usuario no encontrado");
            }
            return user;
        });
    }

    public void updateUser(Long id, User user) {
        executeWithRetry(() -> {
            verificarRateLimit();
            if (!kvsSimulado.containsKey(id)) {
                throw new NoSuchElementException("Usuario no existe para actualizar");
            }
            user.setId(id);
            kvsSimulado.put(id, user);
            return null;
        });
    }

    public void deleteUser(Long id) {
        executeWithRetry(() -> {
            verificarRateLimit();
            kvsSimulado.remove(id);
            return null;
        });
    }

    private boolean isRateLimited() {
        return Math.random() < 0.1;
    }

    private void verificarRateLimit() {
        if (isRateLimited()) {
            throw new RateLimitException("Rate limit excedido al acceder al KVS.");
        }
    }

    private <T> T executeWithRetry(Retriable<T> op) {
        int attempt = 0;
        while (attempt <= MAX_RETRIES) {
            try {
                return op.execute();
            } catch (RateLimitException e) {
                log.warn("RateLimit alcanzado (intento {}): {}", attempt + 1, e.getMessage());
                if (attempt == MAX_RETRIES) {
                    throw e;
                }
                attempt++;
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ignored) {}
            }
        }
        return null;
    }

    public List<User> obtenerUsuariosPorPais(String pais) {
        return userRepository.findUsersByCountry(pais);
    }

    @FunctionalInterface
    public interface Retriable<T> {
        T execute();
    }
}
