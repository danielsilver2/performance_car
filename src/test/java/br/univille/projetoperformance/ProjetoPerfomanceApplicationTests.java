package br.univille.projetoperformance;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.xpath;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import br.univille.projetoperformance.controller.ClientController;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ProjetoPerfomanceApplicationTests {

//	@Autowired
//	private ClientController clientController;
//	@Autowired
//	private MockMvc mockMvc;
//
//	
//	@Test
//	public void contextLoads() {
//		assertThat(clientController).isNotNull();
//
//	}
//	@Test
//	public void homeControllerTest() throws Exception {
//		//Teste do método index
//		this.mockMvc.perform(get("/")).andDo(print()).andExpect(status().isOk())
//		.andExpect(content().string(containsString("eu não acredito")));
//	}
//	
//    @Test
//    public void pacienteControllerTest() throws Exception {
//        //Teste do método index
//        this.mockMvc.perform(get("/clients")).andExpect(status().isOk())
//        .andExpect(xpath("/html/body/div/div/table").exists());
//    }
//    
//    @Test
//    public void pacienteControllerSaveTest() throws Exception {
//        this.mockMvc.perform(post("/clients")
//                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
//                .param("form", "")
//                .content("id=0&nome=zezinho&sexo=Masculino"))
//                .andDo(print())
//                .andExpect(status().isMovedTemporarily())
//                .andExpect(view().name("redirect:/paciente"));
//        
//        this.mockMvc.perform(get("/paciente")).andDo(print()).andExpect(status().isOk())
//        .andExpect(xpath("/html/body/div/div/table/tbody/tr/td[1]/text()").string("zezinho"))
//        .andExpect(xpath("/html/body/div/div/table/tbody/tr/td[2]/text()").string("Masculino"));
//            
//    }
}
