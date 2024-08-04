package com.blog.controller;



import com.blog.blogcontainer.auth.JwtUtil;
import com.blog.model.User;
import com.blog.model.request.LoginReq;
import com.blog.model.response.ErrorRes;
import com.blog.model.response.LoginRes;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Controller

public class AuthController {

    private final AuthenticationManager authenticationManager;


    private JwtUtil jwtUtil;
    public AuthController(AuthenticationManager authenticationManager, JwtUtil jwtUtil) {
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;

    }

    @CrossOrigin(origins = "http://localhost:3000")
    @ResponseBody
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public ResponseEntity login(@RequestBody LoginReq loginReq)  {
        System.out.println("in login name: "+loginReq.getName()+", password: "+ loginReq.getPassword()+", authenticationManager: "+authenticationManager);
        try {
            Authentication authentication =
                    authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginReq.getName(), loginReq.getPassword()));
            System.out.println("authentication: "+authentication.toString());
            String name = authentication.getName();
            Optional<String> role = authentication.getAuthorities().stream()
                    .map(r -> r.getAuthority()).collect(Collectors.toSet()).stream().findFirst();
            User user = new User(name,"");
            String token = jwtUtil.createToken(user);
            System.out.println("token:"+token);
            LoginRes loginRes = new LoginRes(loginReq.getName(),token, role.get());

            return ResponseEntity.ok(loginRes);

        }catch (BadCredentialsException e){
            e.printStackTrace();
            ErrorRes errorResponse = new ErrorRes(HttpStatus.BAD_REQUEST,"Invalid username or password");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
        }catch (Exception e){
            e.printStackTrace();
            ErrorRes errorResponse = new ErrorRes(HttpStatus.BAD_REQUEST, e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
        }
    }
}