package com.twinkles.thumbprintvalidator.repository;

import com.twinkles.thumbprintvalidator.model.TrustedClient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrustedClientRepository extends JpaRepository<TrustedClient, Long> {
}
