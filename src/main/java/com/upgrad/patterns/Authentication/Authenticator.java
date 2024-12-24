package com.upgrad.patterns.Authentication;

import com.upgrad.patterns.Middleware.AuthenticationProcessor;
import com.upgrad.patterns.Middleware.BasicAuthProcessor;
import com.upgrad.patterns.Middleware.JwtAuthProcessor;

import javax.servlet.http.HttpServletRequest;

public class Authenticator {
	
//create a public static method GetAuthProcessor of the return type AuthenticationProcessor
	// create an object of type JwtAuthProcessor
	// Chain Authentication processors, first JWT processor is to be used first and then basic auth processor
	// return the object
    public static AuthenticationProcessor GetAuthProcessor() {
        // Create an instance of JwtAuthProcessor, as it's the last in the chain
        JwtAuthProcessor jwtAuthProcessor = new JwtAuthProcessor(null);

        // Create an instance of BasicAuthProcessor, passing JwtAuthProcessor as the next processor
        BasicAuthProcessor basicAuthProcessor = new BasicAuthProcessor(jwtAuthProcessor);

        // Return the basicAuthProcessor, which starts the chain
        return basicAuthProcessor;
    }

    public static AuthenticationProvider GetAuthProvider(HttpServletRequest request)
    {
        if(request.getHeader("Authorization") != null)
            return new JwtAuthProvider(request.getHeader("Authorization"));
        return new BasicAuthProvider(request.getHeader("Username"), request.getHeader("Password"));
    }
}
