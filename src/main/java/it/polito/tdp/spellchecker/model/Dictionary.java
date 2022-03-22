package it.polito.tdp.spellchecker.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.*;

public class Dictionary {
	
	Set<String> dizionario;
	long start,tempo, end=0;

	public long getTempo() {
		return tempo;
	}


	public void loadDictionary(String language) {
		
		dizionario=new HashSet<String>();
		
		String l;
		if(language.compareTo("English")==0) {
			l="C:\\Users\\Gabriele\\git\\Lab03\\src\\main\\resources\\English.txt";
		}
			else {
				l="C:\\Users\\Gabriele\\git\\Lab03\\src\\main\\resources\\Italian.txt";
		}
			
		try {
			
			FileReader fr = new FileReader(l);//"C:\\Users\\Gabriele\\git\\Lab03\\src\\main\\resources\\"+language+".txt");//se è otaliano prende il file ita e viceversa
			BufferedReader br = new BufferedReader(fr);
			String word;
			
			while ((word = br.readLine()) != null) 
			{
			// Aggiungere parola alla struttura dati
				dizionario.add(word);
				
				
			}
			br.close();
			 } catch (IOException e){
			System.out.println("Errore nella lettura del file");
			}
		
	}
	
	
	public List<String> spellCheckTest(String testo){
		
		List<String>paroleErr=new LinkedList<String>();
		testo=testo.toLowerCase();//controlla in minuscolo
		
		testo.replaceAll("[.,\\/#!$%\\^&\\*;:{}=\\-_`~()\\[\\]\"]", "");
		String[] parole= testo.split(" ");//per controllare ogni parola, perchè separata sa spazio
		
		start=System.nanoTime();
		for (String s:parole) {
			if(!dizionario.contains(s)){
			paroleErr.add(s);
			}
		}
		end=System.nanoTime();
		tempo=end-start;
		return paroleErr;
	}
	
	
	
	
}
