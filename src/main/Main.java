package main;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {

		isPalindromo("otto");

		sep();

		int[] numeri = { 1, 2, 3, 11, 13, 16, 19, 22, 24 };
		getNumeriPrimi(numeri);

		sep();

		List<Integer> numbers = new ArrayList<Integer>();
		numbers.add(1);
		numbers.add(2);
		numbers.add(3);
		numbers.add(4);
		numbers.add(5);
		productArray(numbers);

		sep();

		String[] nomi = { "Gianni", "Giovanni", "Anna", "Paola" };
		productArray(nomi);

		sep();

		invertWord("Miasma");
		System.out.println();
		reverseString("Spasmo");

	}

	// separatore per gli esercizi
	public static void sep() {
		System.out
				.println("-------------------------------------------------------------------------------------------");
	}

// #ES.1
	public static boolean isPalindromo(String stringa) {

		// Pointers che indicano l'inizio e la fine delle due stringhe
		int i = 0, j = stringa.length() - 1;

		// Fino a quando non ci sono lettere da comparare
		while (i < j) {

			// Se le lettere non sono uguali
			if (stringa.charAt(i) != stringa.charAt(j)) {

				System.out.println("Non palindroma");
				return false;
			}

			// incrementa il primo indicatore
			// decrementa l'altro
			i++;
			j--;
		}

		// La stringa è palindroma
		System.out.println("Palindroma");
		return true;

	}

	// #ES.2

	// metodo semplice che verifica se un numero è primo o meno, funziona solo
	// utilizzando BigInteger e facendo il valueOf.
	public static boolean isPrime(int number) {
		BigInteger bigInt = BigInteger.valueOf(number);
		return bigInt.isProbablePrime(100);
	}

	public static List<Integer> getNumeriPrimi(int[] arrayOfPositiveNumbers) {
		// dichiaro una lista vuota che ci servirà da contenitore
		List<Integer> numeriPrimi = new ArrayList<Integer>();
		// foreach che per ogni numero dell'array controlla la condizione if
		for (int i : arrayOfPositiveNumbers) {
			// se richiesto invece di utilizzare isPrime() dovresti mettere tu le condizioni
			// per i quali un numero è primo nel'if statement
			if (isPrime(i)) {

				numeriPrimi.add(i);
			}

		}
		System.out.println(numeriPrimi.toString());
		return numeriPrimi;

	}

	// #ES.3
	// l'esercizio l'ho fatto con una lista di array perché è più corretto dato che
	// così i dati degli array sono modificabili
	public static List<Integer> productArray(List<Integer> numbers) {
		// due variabili una per fare da contenitore al prodotto e una per fare da
		// contenitore per il nuovo prodotto senza il numero in posizione i
		int product = 1;
		int arrayNumber = 1;

		// la nuova lista di array di prodotti
		List<Integer> productNumbers = new ArrayList<Integer>();
		// ciclo foreach per calcolare il prodotto
		for (Integer n : numbers) {
			product *= n;
		}
		// ciclo foreach per calcolare il prodotto senza il numero in posizione i
		for (Integer i : numbers) {
			arrayNumber = product / i;
			productNumbers.add(arrayNumber);
		}

		System.out.println(productNumbers);
		return productNumbers;
	}

	// #ES.4
	public static int productArray(String[] strings) {
		// conta quante parole hanno lunghezza pari
		int contatore = 0;
		// ogni volta che si restituisce resto zero da questa divisione il contatore
		// aumenta di uno
		for (String s : strings) {
			if (s.length() % 2 == 0) {
				contatore++;
			}
		}
		System.out.println("Stringhe con lunghezza pari : " + contatore);
		return contatore;
	}

	// ES.5
	public static String invertWord(String word) {
		String rev = "";
		// le stringhe sono array di caratteri quindi possiamo sfruttare questa funzione
		// per iterarci sopra
		// con toCharArray creo un nuovo array di caratteri
		char[] ch = word.toCharArray();
		for (int i = word.length() - 1; i >= 0; i--) {

			// viene costruita la nuova stringa al contrario
			rev += ch[i];
		}
		System.out.println(rev);
		return rev;
	}

	// metodo più semplice con string builder, funziona praticamente allo stesso
	// modo e dietro le quinte fa la stessa cosa del ciclo for fatto sopra ma è
	// molto più veloce
	public static String reverseString(String str) {
		StringBuilder sb = new StringBuilder(str);
		sb.reverse();
		System.out.print(sb);
		return sb.toString();
	}

}
