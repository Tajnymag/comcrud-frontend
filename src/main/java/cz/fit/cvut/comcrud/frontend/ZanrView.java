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
import cz.fit.cvut.comcrud.entity.Zanr;
import java.util.List;

/**
 *
 * @author lukasma5
 */
public class ZanrView extends VerticalLayout {
	Grid<Zanr> zanrGrid;
	ZanrClient zanrClient;
	ZanrForm zanrForm;
	Button refreshBTN;
	List<Zanr> remoteGottenZanry;
	
	public ZanrView() {
		zanrForm = new ZanrForm();
		
		refreshBTN = new Button("Refresh");
		refreshBTN.addClickListener(e -> {
			remoteGottenZanry = zanrClient.findAllZanrs_JSON();
			zanrGrid.setItems(remoteGottenZanry);
			zanrGrid.setHeightByRows(remoteGottenZanry.size());
		});
		
		zanrClient = new ZanrClient();
		remoteGottenZanry = zanrClient.findAllZanrs_JSON();
		
		zanrGrid = new Grid<>();
		zanrGrid.setSizeFull();
		zanrGrid.setHeightMode(HeightMode.ROW);
		zanrGrid.setHeightByRows(remoteGottenZanry.size());
		
		zanrGrid.addColumn(Zanr::getIdZanr).setCaption("ID Žánru");
		zanrGrid.addColumn(Zanr::getNazev).setCaption("Název");
		zanrGrid.addColumn(Zanr::getPopis).setCaption("Popis");
		
		zanrGrid.setItems(remoteGottenZanry);
		
		addComponent(refreshBTN);
		addComponent(zanrGrid);
		addComponent(zanrForm);
		setComponentAlignment(refreshBTN, Alignment.BOTTOM_RIGHT);
	}
}
