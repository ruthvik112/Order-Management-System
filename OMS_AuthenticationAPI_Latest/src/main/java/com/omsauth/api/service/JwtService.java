package com.omsauth.api.service;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

import org.springframework.boot.autoconfigure.security.oauth2.resource.OAuth2ResourceServerProperties.Jwt;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.Date;

@Service
public class JwtService {

	String SECRET_KEY=null;
	JwtService()
	{
		try {
			KeyGenerator keyGen=KeyGenerator.getInstance("HmacSHA256");
			SecretKey Sk=keyGen.generateKey();
			SECRET_KEY=Base64.getEncoder().encodeToString(Sk.getEncoded());
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public String generateToken(String userName) {
		// TODO Auto-generated method stub
		Map<String,Object> claims=new HashMap<>();
		return Jwts.builder()
                .setSubject(userName)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 60*60*30))
                .signWith(getKey())
                .compact();
	}
	private SecretKey getKey() {
		// TODO Auto-generated method stub
		byte[] keybytes=Decoders.BASE64.decode(SECRET_KEY);
		return Keys.hmacShaKeyFor(keybytes);
	}
	public String extractUserName(String token) {
		// TODO Auto-generated method stub
		return extractClaims(token,Claims::getSubject);
	}
	private <T> T extractClaims(String token, Function<Claims,T> claimResolver) {
		// TODO Auto-generated method stub
		final Claims claims= extractAllClaims(token);
		return claimResolver.apply(claims);
	}
	private Claims extractAllClaims(String token) {
		// TODO Auto-generated method stub
		return Jwts
				.parser()
				.verifyWith(getKey())
				.build()
				.parseSignedClaims(token)
	            .getPayload();
	}
	public boolean validateToken(String token, UserDetails userDetails) {
		// TODO Auto-generated method stub
		final String userName=extractUserName(token);
		
		return (userName.equals(userDetails.getUsername()) && !isTokenExpired(token) );
	}
	private boolean isTokenExpired(String token) {
		// TODO Auto-generated method stub
		return extractTokenExpiration(token).before(new Date());
	}
	private Date extractTokenExpiration(String token) {
		// TODO Auto-generated method stub
		return extractClaims(token,Claims::getExpiration);
	}
	

}
