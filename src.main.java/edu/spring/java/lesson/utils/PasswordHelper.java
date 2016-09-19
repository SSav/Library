package edu.spring.java.lesson.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.inject.Named;

import org.springframework.security.crypto.password.PasswordEncoder;

@Named
public class PasswordHelper implements PasswordEncoder {

	private MessageDigest md;

	public PasswordHelper() throws NoSuchAlgorithmException {
		md = MessageDigest.getInstance("MD5");
	}

	@Override
	public String encode(CharSequence rawPassword) {
		if (md == null) {
			return rawPassword.toString();
		}

		md.update(rawPassword.toString().getBytes());

		byte byteData[] = md.digest();

		StringBuffer hexString = new StringBuffer();
		for (int i = 0; i < byteData.length; i++) {
			String hex = Integer.toHexString(0xff & byteData[i]);
			if (hex.length() == 1)
				hexString.append('0');
			hexString.append(hex);
		}
		return hexString.toString();
	}

	@Override
	public boolean matches(CharSequence rawPassword, String encodedPassword) {
		return encode(rawPassword).equals(encodedPassword);

		// admin 21232f297a57a5a743894a0e4a801fc3
		// user ee11cbb19052e40b07aac0ca060c23ee
	}
}
