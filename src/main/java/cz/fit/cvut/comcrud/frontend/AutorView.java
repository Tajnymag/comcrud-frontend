/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.fit.cvut.comcrud.frontend;

import com.vaadin.ui.Component;
import com.vaadin.ui.Grid;
import com.vaadin.ui.VerticalLayout;
import cz.fit.cvut.comcrud.entity.Autor;

/**
 *
 * @author marek
 */
public class AutorView extends VerticalLayout {
	Grid<Autor> autorView;
	AutorClient autorClient;

	public AutorView() {
		autorClient = new AutorClient();
		autorView = new Grid<>(Autor.class);
		
		autorView.setItems(autorClient.findAllAutors_JSON());
	}
	
}
