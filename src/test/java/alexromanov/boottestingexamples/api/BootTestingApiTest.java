package alexromanov.boottestingexamples.api;

import alexromanov.boottestingexamples.entity.ConversionRequest;
import com.google.gson.Gson;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class BootTestingApiTest {
	@Autowired
	private MockMvc mvc;

	private Gson gson;

	@Before
	public void beforeTest() {
		gson = new Gson();
	}

	@Test
	public void shouldReturnConvertedResult() throws Exception {
		ConversionRequest request = ConversionRequest.builder()
				.inputValue(1600)
				.build();

		String value = gson.toJson(request);

		mvc.perform(post("/convert")
				.contentType("application/json")
				.content(value))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.status").value("success"))
				.andExpect(jsonPath("$.initialValue").value("1600.0"))
				.andExpect(jsonPath("$.convertedValue").value("1 600.00"));
	}
}
