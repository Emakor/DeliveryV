// package it.utente.RestController;

// import java.sql.Connection;
// import java.sql.DriverManager;
// import java.sql.PreparedStatement;
// import java.sql.ResultSet;
// import java.sql.Statement;
// import java.util.ArrayList;
// import java.util.List;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.jdbc.core.JdbcTemplate;
// import org.springframework.ui.Model;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.ResponseBody;
// import org.springframework.web.bind.annotation.RestController;
// import it.utente.tabelleDatabase.*;
// import com.fasterxml.jackson.databind.ObjectMapper;
// import com.fasterxml.jackson.databind.ObjectWriter;

// import it.utente.database.*;
// import it.utente.tabelleDatabase.Utente;
// @RestController
// public class UtenteRestController {
// 	@Autowired
// 	 private JdbcTemplate jdbcTemplate;
	
	
	
// 	@GetMapping("/home")
// 	public String ciaoMondo() {
// 		return "Ciao Mondo";
// 	}
	
	
// //	@ResponseBody
// //	private List<Utente> listaUtenti(Model model) throws Exception{
// //	List<Utente> utenti;
// //	utenti=jdbcTemplate.query("select * from utenti", (rs,rowId)->{
// //		return new Utente(rs.getInt("id"),rs.getString("nome"),rs.getString("cognome"),rs.getString("username"),rs.getString("cellulare"),rs.getString("indirizzo"),rs.getInt("eta"));
// //	});
// //	return utenti;
// //	}
	
// 	 @GetMapping("/utente")
// 	 @ResponseBody
// 	 public List<Utente> listaUtenti(Model model) {
// 	   return jdbcTemplate.query("SELECT * FROM users", (rs, rowNum) -> {
//     Utente utente = new Utente();
//     utente.setId(rs.getInt("idutente"));
//     utente.setNome(rs.getString("nome"));
//     utente.setCognome(rs.getString("cognome"));
//     utente.setUsername(rs.getString("username"));
//     utente.setCellulare(rs.getString("cellulare"));
//     utente.setIndirizzo(rs.getString("indirizzo"));
//     utente.setEta(rs.getInt("eta"));
//     return utente;
// 	   });
// 	 }
	 
// 	@GetMapping("/utenti/edits/{id}")
//     @ResponseBody
//     public Utente UtentiperID(@PathVariable int id) {
//         @SuppressWarnings("deprecation")
//         Utente utente = jdbcTemplate.queryForObject(
//             "SELECT idutente, nome, cognome, username, cellulare, indirizzo, eta FROM users WHERE idutente = ?",
//             new Object[]{id},
//             (rs, rowNum) -> {
//                 Utente ut = new Utente();
//                 ut.setId(rs.getInt("idutente"));
//                 ut.setNome(rs.getString("nome"));
//                 ut.setCognome(rs.getString("cognome"));
//                 ut.setUsername(rs.getString("username"));
//                 ut.setCellulare(rs.getString("cellulare"));
//                 ut.setIndirizzo(rs.getString("indirizzo"));
//                 ut.setEta(rs.getInt("eta"));
//                 return ut;
//             }
//         );
//         return utente;
//     }
	
// }
		
// //	 String insertQuery = "INSERT INTO users (idUtente, nome, cognome, username, cellulare, indirizzo, eta) VALUES (null, ?, ?, ?, ?, ?, ?)";
// //	    jdbcTemplate.update(insertQuery, Utente.getId(), Utente.getNome(), Utente.getCognome(), Utente.getUsername(),Utente.getCellulare(), Utente.getIndirizzo(),Utente.getEta());
	 

