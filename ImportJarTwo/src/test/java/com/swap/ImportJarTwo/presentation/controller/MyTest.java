package com.swap.ImportJarTwo.presentation.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.text.SimpleDateFormat;
import java.util.List;

import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;


@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration("/testApplicationContextJpa.xml")
@ActiveProfiles("internal")
public class MyTest {

	@Autowired
	private WebApplicationContext wac;

	@Autowired

	private MockMvc mockMvc;

	private DateTime today;

	private SimpleDateFormat formatter;

	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
		today = new DateTime().withTimeAtStartOfDay();
		formatter = new SimpleDateFormat("yyyyMMdd");

	}

	@Test 
	@Ignore
	public void getCalendarCurrentAndPrevious() throws Exception {

	}

}
