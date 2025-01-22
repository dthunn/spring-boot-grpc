package com.trading.user.service;

import com.trading.user.UserInformation;
import com.trading.user.UserInformationRequest;
import com.trading.user.exceptions.UnknownUserException;
import com.trading.user.repository.PortfolioItemRepository;
import com.trading.user.repository.UserRepository;
import com.trading.user.util.EntityMessageMapper;
import org.springframework.stereotype.Service;

@Service
public class UserInformationRequestHandler {

    private final UserRepository userRepository;
    private final PortfolioItemRepository portfolioItemRepository;

    public UserInformationRequestHandler(UserRepository userRepository, PortfolioItemRepository portfolioItemRepository) {
        this.userRepository = userRepository;
        this.portfolioItemRepository = portfolioItemRepository;
    }

    public UserInformation getUserInformation(UserInformationRequest request) {
        var user = this.userRepository.findById(request.getUserId())
                .orElseThrow(() -> new UnknownUserException(request.getUserId()));
        var portfolioItems = this.portfolioItemRepository.findAllByUserId(request.getUserId());
        return EntityMessageMapper.toUserInformation(user, portfolioItems);
    }
}
