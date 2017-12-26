/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.fit.cvut.comcrud.frontend;

import com.vaadin.shared.ui.grid.HeightMode;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.Grid;
import com.vaadin.ui.VerticalLayout;
import cz.fit.cvut.comcrud.entity.Autor;
import java.util.List;

/**
 *
 * @author marek
 */
public class AutorView extends VerticalLayout {
	Grid<Autor> autorGrid;
	AutorClient autorClient;
	AutorForm autorForm;
	Button refreshBTN;
	List<Autor> remoteGottenAutors;

	public AutorView() {
		autorForm = new AutorForm();
		
		refreshBTN = new Button("Refresh");
		refreshBTN.addClickListener(e -> {
			remoteGottenAutors = autorClient.findAllAutors_JSON();
			autorGrid.setItems(remoteGottenAutors);
			autorGrid.setHeightByRows(remoteGottenAutors.size());
		});
		
		autorClient = new AutorClient();
		remoteGottenAutors = autorClient.findAllAutors_JSON();
		
		autorGrid = new Grid<>();
		autorGrid.setSizeFull();
		autorGrid.setHeightMode( HeightMode.ROW );
		autorGrid.setHeightByRows(remoteGottenAutors.size());
		
		autorGrid.addColumn(Autor::getIdAutor).setCaption("ID Autora");
		autorGrid.addColumn(Autor::getJmeno).setCaption("Jméno");
		autorGrid.addColumn(Autor::getPrijmeni).setCaption("Příjmení");
		autorGrid.addColumn(Autor::getPohlavi).setCaption("Pohlaví");
		autorGrid.addColumn(a -> a.getIdNarodnost().getNazev()).setCaption("Narodnost");
		autorGrid.addColumn(Autor::getInfo);
		
		autorGrid.setItems(remoteGottenAutors);
		
		addComponent(refreshBTN);
		addComponent(autorGrid);
		addComponent(autorForm);
		setComponentAlignment(refreshBTN, Alignment.BOTTOM_RIGHT);
	}
	
}
