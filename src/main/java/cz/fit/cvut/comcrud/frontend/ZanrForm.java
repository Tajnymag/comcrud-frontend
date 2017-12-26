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
import cz.fit.cvut.comcrud.entity.Zanr;
import static java.lang.Long.parseLong;
import java.math.BigDecimal;

/**
 *
 * @author lukasma5
 */
public class ZanrForm extends VerticalLayout {
	ZanrClient zanrClient;
	
	Label idText = new Label("ID Žánru");
	Label nazevText = new Label("Název");
	Label popisText = new Label("Popis");
	
	TextField idField = new TextField();
	TextField nazevField = new TextField();
	TextField popisField = new TextField();
	
	Button createBTN = new Button("Přidat");
	Button updateBTN = new Button("Upravit");
	Button deleteBTN = new Button("Odstranit");
	
	public ZanrForm() {
		zanrClient = new ZanrClient();
		
		setDefaultComponentAlignment(Alignment.BOTTOM_CENTER);
		addComponents(new HorizontalLayout(idText, idField),
				new HorizontalLayout(nazevText, nazevField),
				new HorizontalLayout(popisText, popisField),
				new HorizontalLayout(createBTN, updateBTN, deleteBTN)
		);
		
		createBTN.addClickListener(e -> {
			zanrClient.create_JSON(compileZanr());
		});
		
		updateBTN.addClickListener(e -> {
			zanrClient.edit_JSON(compileZanr(), getZanrID().toString());
		});
		
		deleteBTN.addClickListener(e -> {
			zanrClient.remove(getZanrID().toString());
		});
	}
	
	public Zanr compileZanr() {
		Zanr tmp = new Zanr(getZanrID(), getZanrNazev());
		tmp.setPopis(getZanrPopis());
		
		return tmp;
	}
	
	public BigDecimal getZanrID() {
		return new BigDecimal(idField.getValue());
	}
	
	public String getZanrNazev() {
		return nazevField.getValue();
	}
	
	public String getZanrPopis() {
		return popisField.getValue();
	}
}
