import java.io.Console;
import java.io.IOException;
import java.security.*;
import java.io.ByteArrayOutputStream;
import java.util.*;

public class MD5 {
    public static void main(String[] args) {

	Console console = System.console();

	if( console == null ) {
	     System.out.print("Console unavailable");
	    return;
	}

	String password = console.readLine("Enter password:");

	try {
		SecureRandom salt = new SecureRandom();
		int salt_len = 16;
		byte salt_bytes[] = new byte[salt_len];
		salt.nextBytes(salt_bytes);

		ByteArrayOutputStream data_to_hash = new ByteArrayOutputStream();
		data_to_hash.write(salt_bytes,0,salt_len);
		data_to_hash.write(password.getBytes());

		MessageDigest md = MessageDigest.getInstance("MD5");
    md.update(data_to_hash.toByteArray());

		byte[] digest = md.digest();
		String hash_pwd = bytes2Hex(digest).toUpperCase();

		String salt_str = bytes2Hex(salt_bytes).toUpperCase();

		console.printf("Storing into db hash:" + hash_pwd);
		console.printf("\n");
		console.printf("Storing into db salt:" + salt_str);
		console.printf("\n");

	} catch (NoSuchAlgorithmException e) {
		System.out.print("MD5 not supported for some reason");
		return;
	} catch (IOException e) {
	  System.out.print("Could not prepare data for hashing");
	  return;

	}
   }
   private static String bytes2Hex(byte[] in) {
 	StringBuilder sb = new StringBuilder();

 	for (byte b : in) {
 		sb.append(String.format("%02x", b));
 	}

 	return sb.toString();
   }
}
