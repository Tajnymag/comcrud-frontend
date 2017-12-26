/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.fit.cvut.comcrud.frontend;

import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import cz.fit.cvut.comcrud.entity.Autor;
import cz.fit.cvut.comcrud.entity.Narodnost;
import java.math.BigDecimal;

/**
 *
 * @author Marek Lukáš <lukasma5@fit.cvut.cz>
 */
public class AutorForm extends VerticalLayout {
	AutorClient autorClient;
	
	Label idText = new Label("ID Autora");
	Label jmenoText = new Label("Jméno");
	Label prijmeniText = new Label("Příjmení");
	Label pohlaviText = new Label("Pohlaví");
	Label narodnostIDText = new Label("ID Národnosti");
	Label infoText = new Label("Info");
	
	TextField idField = new TextField();
	TextField jmenoField = new TextField();
	TextField prijmeniField = new TextField();
	TextField pohlaviField = new TextField();
	TextField narodnostIDField = new TextField();
	TextField infoField = new TextField();
	
	Button createBTN = new Button("Přidat");
	Button updateBTN = new Button("Upravit");
	Button deleteBTN = new Button("Odstranit");
	
	public AutorForm() {
		autorClient = new AutorClient();
		
		setDefaultComponentAlignment(Alignment.BOTTOM_CENTER);
		addComponents(new HorizontalLayout(idText, idField),
				new HorizontalLayout(jmenoText, jmenoField),
				new HorizontalLayout(prijmeniText, prijmeniField),
				new HorizontalLayout(pohlaviText, pohlaviField),
				new HorizontalLayout(narodnostIDText, narodnostIDField),
				new HorizontalLayout(infoText, infoField),
				new HorizontalLayout(createBTN, updateBTN, deleteBTN));
		
		createBTN.addClickListener(e -> {
			autorClient.create_JSON(compileAutor());
		});
		
		updateBTN.addClickListener(e -> {
			autorClient.edit_JSON(compileAutor(), getAutorID().toString());
		});
		
		deleteBTN.addClickListener(e -> {
			autorClient.remove(getAutorID().toString());
		});
	}
	
	public Autor compileAutor() {
			Autor tmp = new Autor(getAutorID(), getAutorJmeno(), getAutorPrijmeni());
			
			if (getAutorPohlavi() == "NULL") {
				return null;
			} else {
				tmp.setPohlavi(getAutorPohlavi());
			}
			tmp.setIdNarodnost(getAutorNarodnost());
			tmp.setInfo(getAutorInfo());
			
			return tmp;
	}
	
	public BigDecimal getAutorID() {
		return new BigDecimal(idField.getValue());
	}
	
	public String getAutorJmeno() {
		return jmenoField.getValue();
	}
	
	public String getAutorPrijmeni() {
		return prijmeniField.getValue();
	}
	
	public String getAutorPohlavi() {
		switch(pohlaviField.getValue()) {
			case "m":
			case "male":
			case "muž":
			case "muz":
				return "male";
			case "f":
			case "female":
			case "žena":
			case "zena":
			case "z":
				return "female";
			default:
				return "NULL";
		}
	}
	
	public Narodnost getAutorNarodnost() {
		Narodnost tmp = new Narodnost(new BigDecimal(narodnostIDField.getValue()));
		
		return tmp;
	}
	
	public String getAutorInfo() {
		return infoField.getValue();
	}
}
