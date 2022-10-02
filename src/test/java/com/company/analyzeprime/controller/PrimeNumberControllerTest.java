package com.company.analyzeprime.controller;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.company.analyzeprime.service.PrimeNumberService;

@RunWith(MockitoJUnitRunner.class)
public class PrimeNumberControllerTest {

	@Mock
	private PrimeNumberService primeNumberService;

	@InjectMocks
	private PrimeNumberController primeNumberController;

	private MockMvc mockMvc;

	@Before
	public void setUp() {
		mockMvc = MockMvcBuilders.standaloneSetup(primeNumberController).build();
	}

	@Test
	public void checkPrime_whenAllValidationsPasses_correctServiceIsCalledAndStatusIsOk() throws Exception {
		 mockMvc.perform(get("/prime-number/check/5")
				 .accept(MediaType.APPLICATION_JSON))
		 .andExpect(status().isOk());
		 verify(primeNumberService, times(1)).checkNumberForPrime(5);
	}

	@Test
	public void nextPrime_whenAllValidationsPasses_correctServiceIsCalledAndStatusIsOk() throws Exception {
		 mockMvc.perform(get("/prime-number/next/5")
				 .accept(MediaType.APPLICATION_JSON))
		 .andExpect(status().isOk());
		 verify(primeNumberService, times(1)).nextPrime(5);
	}
}