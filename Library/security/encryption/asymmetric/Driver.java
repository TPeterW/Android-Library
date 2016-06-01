package com.peter.security.encryption.asymmetric;

public class Driver {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		String encoded = null;
		
		/* Diffie Hellman */
//		DHSender sender = new DHSender();
//		byte[] senderPublicKey = sender.getPublicKeyEncoded();
//		
//		DHReceiver receiver = new DHReceiver(senderPublicKey);
//		byte[] receiverPublicKey = receiver.getPublicKeyEncoded();
//		
//		sender.init(receiverPublicKey);		
//		
//		encoded = sender.DHEncode("金小力全世界第一美");		
//		System.out.println(receiver.DHDecode(encoded));
		
		
		/* RSA */
//		RSAPrivate privateKeyHolder = new RSAPrivate();
//		byte[] publicKey = privateKeyHolder.getPublicKeyEncoded();
//		
//		RSAPublic publicKeyHolder = new RSAPublic();
//		publicKeyHolder.init(publicKey);
//		
//		// private encode, public decode
//		encoded = privateKeyHolder.RSAEncode("金小力全世界第一美");
//		System.out.println(publicKeyHolder.RSADecode(encoded));
//		
//		// public encode, private decode
//		encoded = publicKeyHolder.RSAEncode("金小力全世界最美");
//		System.out.println(privateKeyHolder.RSADecode(encoded));
		
		
		/* ElGamal */
		/* Buggy */
//		ElGamalReceiver receiver = new ElGamalReceiver();
//		
//		ElGamalSender sender = new ElGamalSender(receiver.getPublicKeyEncoded());
//		
//		encoded = sender.ElGamalEncode("金小力全世界最美");
//		
//		System.out.println(receiver.ElGamalDecode(encoded));
		
	}

}
