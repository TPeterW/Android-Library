package com.peter.security.signature;

import com.peter.security.signature.ecdsa.ECReader;
import com.peter.security.signature.ecdsa.ECSigner;

public class Driver {

	public static void main(String[] args) {
		
		String message = "金小力世界第一美";
		
		/* RSA */
//		RSASigner signer = new RSASigner();
//		byte[] publicKey = signer.getPublicKeyEncoded();
//		
//		RSAReader reader = new RSAReader(publicKey);
//		
//		String signed = signer.encodeSignature(message);
//		System.out.println(reader.verifySignature(message, signed));
		
		/* DSA */
//		DSASigner signer = new DSASigner();
//		byte[] publicKey = signer.getPublicKeyEncoded();
//		
//		DSAReader reader = new DSAReader(publicKey);
//		String signed = signer.encodeSignature(message);
//		System.out.println(reader.verifySignature(message, signed));
		
		/* ECDSA */
		ECSigner signer = new ECSigner();
		byte[] publicKey = signer.getPublicKeyEncoded();
		
		ECReader reader = new ECReader(publicKey);
		String signed = signer.encodeSignature(message);
		System.out.println(reader.verify(message, signed));
	}

}
