/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.fit.cvut.comcrud.frontend;

import cz.fit.cvut.comcrud.entity.Narodnost;
import cz.fit.cvut.comcrud.entity.NarodnostList;
import java.util.List;
import javax.ws.rs.ClientErrorException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;

/**
 * Jersey REST client generated for REST resource:NarodnostFacadeREST
 * [narodnost]<br>
 * USAGE:
 * <pre>
 *        NarodnostClient client = new NarodnostClient();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 * </pre>
 *
 * @author lukasma5
 */
public class NarodnostClient {

	private WebTarget webTarget;
	private Client client;
	private static final String BASE_URI = "http://localhost:8080/comcrud/rest";

	public NarodnostClient() {
		client = javax.ws.rs.client.ClientBuilder.newClient();
		webTarget = client.target(BASE_URI).path("narodnost");
	}

	public List<Narodnost> findAllNarodnosti_XML() throws ClientErrorException {
		WebTarget resource = webTarget;
		return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(NarodnostList.class).getNarodnosts();
	}

	public List<Narodnost> findAllNarodnosti_JSON() throws ClientErrorException {
		WebTarget resource = webTarget;
		return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(NarodnostList.class).getNarodnosts();
	}

	public String countREST() throws ClientErrorException {
		WebTarget resource = webTarget;
		resource = resource.path("count");
		return resource.request(javax.ws.rs.core.MediaType.TEXT_PLAIN).get(String.class);
	}

	public void edit_XML(Object requestEntity, String id) throws ClientErrorException {
		webTarget.path(java.text.MessageFormat.format("{0}", new Object[]{id})).request(javax.ws.rs.core.MediaType.APPLICATION_XML).put(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_XML));
	}

	public void edit_JSON(Object requestEntity, String id) throws ClientErrorException {
		webTarget.path(java.text.MessageFormat.format("{0}", new Object[]{id})).request(javax.ws.rs.core.MediaType.APPLICATION_JSON).put(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON));
	}

	public Narodnost find_XML(String id) throws ClientErrorException {
		WebTarget resource = webTarget;
		resource = resource.path(java.text.MessageFormat.format("{0}", new Object[]{id}));
		return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(Narodnost.class);
	}

	public Narodnost find_JSON(String id) throws ClientErrorException {
		WebTarget resource = webTarget;
		resource = resource.path(java.text.MessageFormat.format("{0}", new Object[]{id}));
		return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(Narodnost.class);
	}

	public void create_XML(Object requestEntity) throws ClientErrorException {
		webTarget.request(javax.ws.rs.core.MediaType.APPLICATION_XML).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_XML));
	}

	public void create_JSON(Object requestEntity) throws ClientErrorException {
		webTarget.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON));
	}

	public void remove(String id) throws ClientErrorException {
		webTarget.path(java.text.MessageFormat.format("{0}", new Object[]{id})).request().delete();
	}

	public void close() {
		client.close();
	}
	
}
