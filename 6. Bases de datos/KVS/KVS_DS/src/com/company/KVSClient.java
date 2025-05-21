package com.company;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

public class KVSClient {
    //Clase para registrar mensajes informativos, errores, etc
    private static final Logger logger = Logger.getLogger(KVSClient.class.getName());

    private static final int MAX_RETRIES = 2;
    private static final int RATE_LIMIT = 5;

    //Simulamos el KVS
    private Map<String, User> store = new HashMap<>();
    private int requestCount = 0;

    //Chequeamos cantidad de accione o solicitudes
    private void checkRateLimit() throws Exception{
        if(++requestCount > RATE_LIMIT){
            throw new RateLimitExceededException("Rate Limit Exceeded");
        }
    }

    //Metodos crud
    public void create(User user){
        executeWithRetry(()->store.put(user.getId(),user));
    }
    public User read(String id) {
        return executeWithRetry(() -> store.get(id));
    }

    public void update(User user) {
        executeWithRetry(() -> store.put(user.getId(), user));
    }

    public void delete(String id) {
        executeWithRetry(() -> store.remove(id));
    }

    private <T> T executeWithRetry(KVSOperation<T> operation) {
        int attempts = 0;
        while (attempts <= MAX_RETRIES) {
            try {
                checkRateLimit();
                return operation.execute();
            } catch (RateLimitExceededException e) {
                logger.warning("Rate limit reached: " + e.getMessage());
                return null;
            } catch (Exception e) {
                attempts++;
                if (attempts > MAX_RETRIES) {
                    logger.severe("Operation failed after " + attempts + " attempts: " + e.getMessage());
                }
            }
        }
        return null;
    }
    @FunctionalInterface
    interface KVSOperation<T> {
        T execute();
    }
    static class RateLimitExceededException extends RuntimeException {
        public RateLimitExceededException(String message) {
            super(message);
        }
    }
}
