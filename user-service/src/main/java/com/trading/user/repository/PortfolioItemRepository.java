package com.trading.user.repository;

import com.trading.common.Ticker;
import com.trading.user.entity.PortfolioItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PortfolioItemRepository extends JpaRepository<PortfolioItem, Integer> {

    List<PortfolioItem> findAllByUserId(Integer userId);
    Optional<PortfolioItem> findByUserIdAndTicker(Integer userId, Ticker ticker);
}
