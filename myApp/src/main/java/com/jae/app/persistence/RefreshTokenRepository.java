package com.jae.app.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import com.jae.app.domain.RefreshToken;
import java.util.Optional;

public interface RefreshTokenRepository extends JpaRepository<RefreshToken, Long> {
    Optional<RefreshToken> findByToken(String token);

    void deleteByToken(String token);
}
