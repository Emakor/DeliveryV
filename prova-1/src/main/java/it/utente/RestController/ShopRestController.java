package it.utente.RestController;

// import java.sql.Connection;
// import java.sql.DriverManager;
// import java.sql.PreparedStatement;
// import java.sql.ResultSet;
// import java.sql.Statement;
// import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import it.utente.tabelleDatabase.*;
// import com.fasterxml.jackson.databind.ObjectMapper;
// import com.fasterxml.jackson.databind.ObjectWriter;

// import it.utente.database.*;
// import it.utente.tabelleDatabase.Utente;
@RestController
public class ShopRestController {
	@Autowired
	 private JdbcTemplate jdbcTemplate;
	
	@GetMapping("/home")
	public String ciaoMondo() {
		return "Ciao Mondo";
	}
	
//	@ResponseBody
//	private List<Utente> listaUtenti(Model model) throws Exception{
//	List<Utente> utenti;
//	utenti=jdbcTemplate.query("select * from utenti", (rs,rowId)->{
//		return new Utente(rs.getInt("id"),rs.getString("nome"),rs.getString("cognome"),rs.getString("username"),rs.getString("cellulare"),rs.getString("indirizzo"),rs.getInt("eta"));
//	});
//	return utenti;
//	}
	
	 @GetMapping("/shop")
	 @ResponseBody
	public List<Shop> ShopList(Model model) {
        return jdbcTemplate.query("SELECT * FROM shops", (rs, rowNum) -> {
            Shop shop = new Shop();
            shop.setId(rs.getInt("id"));
            shop.setName(rs.getString("name"));
            shop.setAddress(rs.getString("address"));
            return shop;
	   });
	 }
	 
	@GetMapping("/shops/edit/{id}")
    @ResponseBody
    public Shop shopPerID(@PathVariable int id) {
        @SuppressWarnings("deprecation")
        Shop shop = jdbcTemplate.queryForObject(
            "SELECT id, name, address FROM shops WHERE id = ?",
            new Object[]{id},
            (rs, rowNum) -> {
                Shop s = new Shop();
                s.setId(rs.getInt("id"));
                s.setName(rs.getString("name"));
                s.setAddress(rs.getString("address")); 
                return s;
            }
        );
        return shop;
    }
	
}
		


//	 String insertQuery = "INSERT INTO users (idUtente, nome, cognome, username, cellulare, indirizzo, eta) VALUES (null, ?, ?, ?, ?, ?, ?)";
//	    jdbcTemplate.update(insertQuery, Utente.getId(), Utente.getNome(), Utente.getCognome(), Utente.getUsername(),Utente.getCellulare(), Utente.getIndirizzo(),Utente.getEta());
	 

