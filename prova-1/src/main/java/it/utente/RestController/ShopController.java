package it.utente.RestController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
// import org.springframework.web.bind.annotation.ResponseBody;

import it.utente.tabelleDatabase.Shop;

@Controller
public class ShopController {
	@Autowired
	 private JdbcTemplate jdbcTemplate;
	

     @GetMapping("/shops")
        public String shopList(Model model) {
	    List<Shop> shop = jdbcTemplate.query("SELECT * FROM shops", (rs, rowNum) -> {
           Shop s = new Shop();
           s.setId(rs.getInt("id"));
           s.setName(rs.getString("name"));
           s.setAddress(rs.getString("address"));
           return s;
        });
        model.addAttribute("shops", shop);
        return "shops"; // Questo deve corrispondere al nome del file HTML in src/main/resources/templates senza l'estensione
   }


@GetMapping("/shops/update/{id}")
public String shopsPerID(@PathVariable int id, Model model) {
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
    if (shop != null) {
        model.addAttribute("shop", shop); // Nota che sto usando "shop" invece di "shops" per un singolo shop
        return "form_edit_shops";  
    } else {
        // Gestisci il caso in cui lo shop non è stato trovato, ad esempio reindirizzando a una pagina di errore
        return "shop_not_found";
    }

}

@PostMapping("/shops/update/{id}/modifica")
public String processEditShopForm(@PathVariable int id, @RequestParam("name") String name,@RequestParam("address") String address) {
   jdbcTemplate.update(
         "UPDATE shops SET name = ?, address = ? WHERE id = ?", name, address, id);
   return "redirect:/shops";
}
}
