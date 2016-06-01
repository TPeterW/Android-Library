package com.peter.security.encryption.symmetric;
public class Driver {

	public static void main(String[] args) {
		
		/* DES */
//		DES des = new DES();
//		
//		String encoded = des.DESEncode("金小力全世界最美");
//		
//		System.out.println(des.DESDecode(encoded));
		
		/* DESede */
//		DESede desede = new DESede();
//		
//		String encoded = desede.DESedeEncode("金小力全世界最美");
//		
//		System.out.println(desede.DESedeDecode(encoded));
		
		/* AES */
//		AES aes = new AES();
//		
//		String encoded = aes.AESEncode("金小力全世界最美");
//		
//		System.out.println(aes.AESDecode(encoded));
		
		/* PBE */
		PBE pbe = new PBE();
		
		String encoded = pbe.PBEEncode("金小力全世界最美");
		
		System.out.println(pbe.PBEDecode(encoded));
	}

}
