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
import cz.fit.cvut.comcrud.entity.Narodnost;
import cz.fit.cvut.comcrud.entity.Zanr;
import static java.lang.Long.parseLong;
import java.math.BigDecimal;

/**
 *
 * @author Marek Lukáš <lukasma5@fit.cvut.cz>
 */
public class NarodnostiForm extends VerticalLayout {
	NarodnostClient narodnostClient;
	
	Label idText = new Label("ID Národnosti");
	Label nazevText = new Label("Název");
	
	TextField idField = new TextField();
	TextField nazevField = new TextField();
	
	Button createBTN = new Button("Přidat");
	Button updateBTN = new Button("Upravit");
	Button deleteBTN = new Button("Odstranit");
	
	public NarodnostiForm() {
		narodnostClient = new NarodnostClient();
		
		setDefaultComponentAlignment(Alignment.BOTTOM_CENTER);
		addComponents(new HorizontalLayout(idText, idField),
				new HorizontalLayout(nazevText, nazevField),
				new HorizontalLayout(createBTN, updateBTN, deleteBTN)
		);
		
		createBTN.addClickListener(e -> {
			narodnostClient.create_JSON(compileNarodnost());
		});
		
		updateBTN.addClickListener(e -> {
			narodnostClient.edit_JSON(compileNarodnost(), getNarodnostID().toString());
		});
		
		deleteBTN.addClickListener(e -> {
			narodnostClient.remove(getNarodnostID().toString());
		});
	}
	
	public Narodnost compileNarodnost() {
		Narodnost tmp = new Narodnost(getNarodnostID(), getNarodnostNazev());
		
		return tmp;
	}
	
	public BigDecimal getNarodnostID() {
		return new BigDecimal(idField.getValue());
	}
	
	public String getNarodnostNazev() {
		return nazevField.getValue();
	}
}
