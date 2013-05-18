package main;

import static org.junit.Assert.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import org.junit.Test;

public class palindromo 
{
	public static boolean Comprueba(String palindromo)
	{
		if(palindromo == null)
			return true;
		if(palindromo.isEmpty())
			return true;
		if(palindromo.charAt(0) == '0')
			palindromo = palindromo.substring(1);
		for(int i=0; i<palindromo.length()/2; i++)
		{
			if(palindromo.charAt(i)!=palindromo.charAt(palindromo.length()-i-1))
				return false;
		}
		return true;
	}
	
	public static boolean Comprueba(int palindromo)
	{
		if(palindromo<10&&palindromo>=0)
			return true;
		return Comprueba(""+palindromo);
	}
	
	public static void main(String[] args) throws IOException 
	{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in)); 
		PrintStream out = System.out; 
		String linea = in.readLine();
		while(linea!="--Exit")
		{
			if(Comprueba(Integer.parseInt(linea)))
				out.println(linea + " es palindromo");
			else
				out.println(linea + " no es palindromo");
			linea = in.readLine();
		}
	}
	
	@Test
	public void unNumero()
	{
		assertEquals(Comprueba(0), true);
	}
	
	@Test
	public void dosNumerosFalso()
	{
		assertEquals(Comprueba(10), false);
	}
	
	@Test
	public void dosNumerosCorrectos()
	{
		assertEquals(Comprueba(11), true);
	}
	
	@Test
	public void conVariosValoresFalso()
	{
		assertEquals(Comprueba(10035232), false);
	}
	
	@Test
	public void conCeroFalso()
	{
		assertEquals(Comprueba(Integer.parseInt("012")), false);
	}
	
	@Test
	public void conCeroCorrecto()
	{
		assertEquals(Comprueba(Integer.parseInt("022")), true);
	}
	
}
