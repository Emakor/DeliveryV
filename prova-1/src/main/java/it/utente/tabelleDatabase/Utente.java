package it.utente.tabelleDatabase;

public class Utente {
private int id;	
private String nome;
private String cognome;
private String username;
private String cellulare;
private String indirizzo;
private int eta;



//public Utente(int id,String nome, String cognome, String username, String cellulare, String indirizzo, int eta) {
//	super();
//	this.id=id;
//	this.nome = nome;
//	this.cognome = cognome;
//	this.username = username;
//	this.cellulare = cellulare;
//	this.indirizzo = indirizzo;
//	this.eta = eta;
//}

public int getId() {
	return id;
}

public String getNome() {
	return nome;
}
public String getCognome() {
	return cognome;
}
public String getUsername() {
	return username;
}
public String getCellulare() {
	return cellulare;
}
public String getIndirizzo() {
	return indirizzo;
}
public int getEta() {
	return eta;
}

public void setId(int id) {
	this.id = id;
}

public void setNome(String nome) {
	this.nome = nome;
}

public void setCognome(String cognome) {
	this.cognome = cognome;
}

public void setUsername(String username) {
	this.username = username;
}

public void setCellulare(String cellulare) {
	this.cellulare = cellulare;
}

public void setIndirizzo(String indirizzo) {
	this.indirizzo = indirizzo;
}

public void setEta(int eta) {
	this.eta = eta;
}


}
