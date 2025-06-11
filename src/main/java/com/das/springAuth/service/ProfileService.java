package com.das.springAuth.service;

import com.das.springAuth.io.ProfileRequest;
import com.das.springAuth.io.ProfileResponse;



public interface ProfileService {

    ProfileResponse createProfile(ProfileRequest request);

    ProfileResponse getProfile(String email);

    void sendResetOtp(String email);

    void resetPassword(String email,String otp,String newPassword);

    void sendOtp(String email);

    void verifyOtp(String email,String otp);

}
