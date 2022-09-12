package com.example.fortlomisw.backend.security.jwt;

import com.example.fortlomisw.backend.security.service.UserDetailsImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
public class jwtTokenFilter extends OncePerRequestFilter{


    private static final Logger logger = LoggerFactory.getLogger(jwtTokenFilter.class);

    @Autowired
    private jwtProvider provider;

    @Autowired
    private UserDetailsImpl userDetails;


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        //System.out.println("Entro");
        try {

            String token = getToken(request);
            System.out.println(token);
            if (token != null && provider.validateToken(token)) {

                logger.info("Token: {}", token);
                String nombreUsuario = provider.getNombreUsuarioFromToken(token);
                UserDetails principal = userDetails.loadUserByUsername(nombreUsuario);
                UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
                        principal, null, principal.getAuthorities());

                SecurityContextHolder.getContext().setAuthentication(authentication);
                authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
            }




        }catch (Exception e){
            logger.error("User Authentication cannot be set: {}", e.getMessage());
        }
        filterChain.doFilter(request,response);
    }



    private String getToken(HttpServletRequest request) {
        String header = request.getHeader("Authorization");
        if(header != null && header.startsWith("Bearer"))
            return header.replace("Bearer ", "");
        return null;
    }








}
