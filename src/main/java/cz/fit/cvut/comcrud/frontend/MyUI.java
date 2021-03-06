package cz.fit.cvut.comcrud.frontend;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.TabSheet;
import com.vaadin.ui.UI;

/**
 * This UI is the application entry point. A UI may either represent a browser window 
 * (or tab) or some part of an HTML page where a Vaadin application is embedded.
 * <p>
 * The UI is initialized using {@link #init(VaadinRequest)}. This method is intended to be 
 * overridden to add component to the user interface and initialize non-component functionality.
 */
@Theme("mytheme")
public class MyUI extends UI {
	AutorView autorView;
	NarodnostView narodnostView;
	ZanrView zanrView;
	
    @Override
    protected void init(VaadinRequest vaadinRequest) {
		autorView = new AutorView();
		narodnostView = new NarodnostView();
		zanrView = new ZanrView();
		
		TabSheet mainView = new TabSheet();
		
		mainView.setSizeFull();
		
		mainView.addTab(autorView).setCaption("Autor");
		mainView.addTab(narodnostView).setCaption("Národnosti");
		mainView.addTab(zanrView).setCaption("Žánry");
		
        setContent(mainView);
    }

    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }
}
