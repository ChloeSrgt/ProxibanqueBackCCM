package org.formation.controller;


import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.containsString;
//import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
//import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
//import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import java.util.List;

import org.formation.model.Client;
import org.formation.service.ClientServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(controllers = ClientController.class)
public class testClientController {
	
	@Autowired
	private MockMvc mvc;
	
	@MockBean
	private ClientServiceImpl serviceImpl;

	
	@Test
	public void GetAllClients_Should_Return_Client() throws Exception {
		
		Client client1 = new Client("Paul");
		Client client2 = new Client("Bob");
		
		
		BDDMockito.given(serviceImpl.getAll()).willReturn(
				List.of(
						client1,
						client2
						)
				);
		
		
		List<Client> clients = serviceImpl.getAll();
		
		assertThat(clients).hasSize(2);
		assertThat(clients.get(0).getLastName()).isEqualTo("Paul");
		assertThat(clients.get(1).getLastName()).isEqualTo("Bob");
		
	}
	

	

}
