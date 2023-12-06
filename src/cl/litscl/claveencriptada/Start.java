package cl.litscl.claveencriptada;

import java.security.MessageDigest;

public class Start {

	public static void main(String[] args) {
		
		String clave1 = "Clave123";
		System.out.println("Clave 1: " + clave1);
		
		String clave2 = "Clave123";
		System.out.println("Clave 2: " + clave2);
		
		String claveEncriptada1 = encriptarClave(clave1);
		System.out.println("Clave Encriptada 1: " + claveEncriptada1);
		
		String claveEncriptada2 = encriptarClave(clave2);
		System.out.println("Clave Encriptada 2: " + claveEncriptada2);
		
		if (claveEncriptada1.equals(claveEncriptada2)) {
			System.out.println("Las claves son iguales");
		}
		else {
			System.out.println("Las claves son distintas");
		}
	}
	
	public static String encriptarClave(String clave) {
		try {
			//1. Establecer el protocolo de encriptado.
			MessageDigest md = MessageDigest.getInstance("SHA");
			
			//2. Descomponer la clave en un Array de bytes.
			md.update(clave.getBytes());
			byte[] claveEnArrayDeBytes = md.digest();
		
			//3. Hashear la clave.
			StringBuilder sb = new StringBuilder();
			for (byte b : claveEnArrayDeBytes) {
				sb.append(String.format("%02x", b));
			}
			
			//4. Obtener la clave hasheada "sb.toString()".
			String claveEncriptada = sb.toString();
			
			return claveEncriptada;
		} catch (Exception ex) {
			return "";
		}
	}

}
