package com.trading.aggregator.service;

import com.trading.user.UserInformation;
import com.trading.user.UserInformationRequest;
import com.trading.user.UserServiceGrpc;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @GrpcClient("user-service")
    private UserServiceGrpc.UserServiceBlockingStub userClient;

    public UserInformation getUserInformation(int userId) {
        var request = UserInformationRequest.newBuilder()
                .setUserId(userId)
                .build();
        return this.userClient.getUserInformation(request);
    }
}
