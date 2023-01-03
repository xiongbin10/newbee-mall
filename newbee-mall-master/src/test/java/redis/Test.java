package redis;

import org.junit.Before;
import org.junit.platform.engine.TestExecutionResult.Status;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import ltd.newbee.mall.NewBeeMallApplication;
import ltd.newbee.mall.controller.redis.TestCtl;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = NewBeeMallApplication.class)
@WebAppConfiguration
public class Test {
	
	private MockMvc mvc;

	@Before
	public void test() {
		mvc=MockMvcBuilders.standaloneSetup(new TestCtl()).build();
		
	}
	
	@org.junit.Test
	public void aaa() throws Exception {
		ResultActions result=mvc.perform(MockMvcRequestBuilders.get("/set").accept(MediaType.APPLICATION_JSON));
		System.out.println(result.andReturn().getResponse().getContentAsString());
	}

}
