package pl.mzuchnik.springsecuritywork1.service;


public interface AuthenticationCounter {
    int getCounter(String username);
}
