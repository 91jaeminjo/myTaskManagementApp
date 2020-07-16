package com.jae.app.service;

import java.time.Instant;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jae.app.domain.RefreshToken;
import com.jae.app.exception.SpringTaskappException;
import com.jae.app.persistence.RefreshTokenRepository;

@Service
@Transactional
public class RefreshTokenService {
	private final RefreshTokenRepository refreshTokenRepository;

	RefreshToken generateRefreshToken() {
		RefreshToken refreshToken = new RefreshToken();
		refreshToken.setToken(UUID.randomUUID().toString());
		refreshToken.setCreatedDate(Instant.now());
		return refreshTokenRepository.save(refreshToken);
	}

	void validateRefreshToken(String token) {
		refreshTokenRepository.findByToken(token).orElseThrow(() -> new SpringTaskappException("Invalid refresh Token"));
	}

	public void deleteRefreshToken(String token) {
		refreshTokenRepository.deleteByToken(token);
	}

	@Autowired
	public RefreshTokenService(RefreshTokenRepository refreshTokenRepository) {
		this.refreshTokenRepository = refreshTokenRepository;
	}
}