package com.hochschild.insumoQuimico.util;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CifrarUtil {

	static final Logger logger=LoggerFactory.getLogger(CifrarUtil.class);
	
	public static String cifrarClave(String clave){
		
		String claveSeguridad = Constantes.claveSeguridad;
		String claveCifrada = "";
		
		byte[] raw = claveSeguridad.getBytes();
		SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");

		Cipher ecipher = null;
		try {
			ecipher = Cipher.getInstance("AES");
			ecipher.init(Cipher.ENCRYPT_MODE, skeySpec);

			byte[] encrypted = ecipher.doFinal(clave.getBytes());
			claveCifrada = new String(CifrarUtil.bytesToHexadecimal(encrypted));
			
		} catch (NoSuchAlgorithmException e) {
			logger.error(e.getLocalizedMessage());
			claveCifrada = null;
		} catch (NoSuchPaddingException e) {
			logger.error(e.getLocalizedMessage());
			claveCifrada = null;
		} catch (InvalidKeyException e) {
			logger.error(e.getLocalizedMessage());
			claveCifrada = null;
		} catch (IllegalBlockSizeException e) {
			logger.error(e.getLocalizedMessage());
			claveCifrada = null;
		} catch (BadPaddingException e) {
			logger.error(e.getLocalizedMessage());
			claveCifrada = null;
		}

		return claveCifrada;
	}
	
	public static String descifrarClave(String claveCifrada){
		String claveSeguridad = Constantes.claveSeguridad;
		String claveDescifrada = "";
		
		byte[] raw = claveSeguridad.getBytes();
		SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");

		Cipher dcipher;
		try {
			dcipher = Cipher.getInstance("AES");
			dcipher.init(Cipher.DECRYPT_MODE, skeySpec);
			
			char[] hexa = claveCifrada.toCharArray();
			byte[] descifrado = dcipher.doFinal(CifrarUtil.hexadecimalToBytes(hexa));
			claveDescifrada = new String(descifrado);
		} catch (NoSuchAlgorithmException e) {
			logger.error(e.getLocalizedMessage());
			claveDescifrada = null;
		} catch (NoSuchPaddingException e) {
			logger.error(e.getLocalizedMessage());
			claveDescifrada = null;
		} catch (InvalidKeyException e) {
			logger.error(e.getLocalizedMessage());
			claveDescifrada = null;
		} catch (IllegalBlockSizeException e) {
			logger.error(e.getLocalizedMessage());
			claveDescifrada = null;
		} catch (BadPaddingException e) {
			logger.error(e.getLocalizedMessage());
			claveDescifrada = null;
		}
		
		return claveDescifrada;
	}

	public static String bytesToHexadecimal(byte[] buf){
		int tamanio = buf.length;
		StringBuilder strbuf = new StringBuilder(tamanio * 2);

		for (int i = 0; i < tamanio; i++) {
			if ((buf[i] & 0xFF) < 16) {
				strbuf.append("0");
			}
			strbuf.append(Long.toString(buf[i] & 0xFF, 16));
		}
		return strbuf.toString();
	}

	public static byte[] hexadecimalToBytes(char[] hex) {
		int length = hex.length / 2;
		byte[] raw = new byte[length];

		for (int i = 0; i < length; i++) {
			int high = Character.digit(hex[(i * 2)], 16);
			int low = Character.digit(hex[(i * 2 + 1)], 16);
			int value = high << 4 | low;
			if (value > 127) {
				value -= 256;
			}
			raw[i] = ((byte)value);
		}
		return raw;
	}
}
