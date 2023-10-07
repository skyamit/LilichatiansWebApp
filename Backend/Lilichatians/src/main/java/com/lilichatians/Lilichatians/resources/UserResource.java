package com.lilichatians.Lilichatians.resources;

import com.lilichatians.Lilichatians.common.response.CustomResponse;
import com.lilichatians.Lilichatians.user.dto.UserSignupDto;
import com.lilichatians.Lilichatians.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Random;

@RestController("/user")
public class UserResource {

    @Autowired
    UserService userService;

    @GetMapping(path = "/")
    public ResponseEntity getMain(){
        return null;
    }

    @PostMapping("/signup")
    public ResponseEntity<CustomResponse> signupUser(@RequestBody UserSignupDto userSignupDto){
        Boolean isSuccessful = userService.registerUser(userSignupDto);
        CustomResponse customResponse = new CustomResponse("Registered successfully...", 200);
        if (isSuccessful) {
            return ResponseEntity.status(200).body(customResponse);
        }
        customResponse.setCode(400);
        customResponse.setMessage("Something went wrong");
        return ResponseEntity.status(400).body(customResponse);
    }

    @PostMapping("/verification")
    public ResponseEntity<CustomResponse> verificationOfUser(@RequestBody UserSignupDto userSignupDto){
        Boolean isVerified = userService.verificationOfUser(userSignupDto);
        CustomResponse customResponse = new CustomResponse("Verification is Successful", 200);
        if (isVerified) {
            return ResponseEntity.status(200).body(customResponse);
        }
        customResponse.setCode(400);
        customResponse.setMessage("Wrong Code.. Please try again..");
        return ResponseEntity.status(400).body(customResponse);
    }

    @PostMapping("/login")
    public ResponseEntity<CustomResponse> loginUser(@RequestBody UserSignupDto userSignupDto){
//        Boolean isVerified = userService.loginUser(userSignupDto);
        CustomResponse customResponse = new CustomResponse("Verification is Successful", 200);
//        if (isVerified) {
//            return ResponseEntity.status(200).body(customResponse);
//        }
        customResponse.setCode(400);
        customResponse.setMessage("Wrong Code.. Please try again..");
        return ResponseEntity.status(400).body(customResponse);
    }
}
