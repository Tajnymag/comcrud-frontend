/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.fit.cvut.comcrud.frontend;

import com.vaadin.shared.ui.grid.HeightMode;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Grid;
import com.vaadin.ui.VerticalLayout;
import cz.fit.cvut.comcrud.entity.Narodnost;
import java.util.List;

/**
 *
 * @author marek
 */
public class NarodnostView extends VerticalLayout {
	Grid<Narodnost> narodnostGrid;
	NarodnostClient narodnostClient;
	NarodnostiForm narodnostForm;
	Button refreshBTN;
	List<Narodnost> remoteGottenNarodnosti;

	public NarodnostView() {
		narodnostForm = new NarodnostiForm();
		
		refreshBTN = new Button("Refresh");
		refreshBTN.addClickListener(e -> {
			remoteGottenNarodnosti = narodnostClient.findAllNarodnosti_JSON();
			narodnostGrid.setItems(remoteGottenNarodnosti);
			narodnostGrid.setHeightByRows(remoteGottenNarodnosti.size());
		});
		
		narodnostClient = new NarodnostClient();
		remoteGottenNarodnosti = narodnostClient.findAllNarodnosti_JSON();
		
		narodnostGrid = new Grid<>();
		narodnostGrid.setSizeFull();
		narodnostGrid.setHeightMode(HeightMode.ROW);
		narodnostGrid.setHeightByRows(remoteGottenNarodnosti.size());
		
		narodnostGrid.addColumn(Narodnost::getIdNarodnost).setCaption("ID Národnosti");
		narodnostGrid.addColumn(Narodnost::getNazev).setCaption("Název");
		
		narodnostGrid.setItems(remoteGottenNarodnosti);
		
		addComponent(refreshBTN);
		addComponent(narodnostGrid);
		addComponent(narodnostForm);
		setComponentAlignment(refreshBTN, Alignment.BOTTOM_RIGHT);
	}
	
}
