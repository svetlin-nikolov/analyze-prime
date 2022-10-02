package com.company.analyzeprime.controller;

import javax.validation.constraints.Min;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.company.analyzeprime.controller.errorhandle.dto.SimpleFieldErrorDTO;
import com.company.analyzeprime.model.dto.IsPrimeResultDTO;
import com.company.analyzeprime.model.dto.NextPrimeResultDTO;
import com.company.analyzeprime.service.PrimeNumberService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import net.jcip.annotations.ThreadSafe;

/**
 * Rest controller for checking if a number is prime and providing next prime.
 */
@RestController
@RequestMapping("prime-number")
@Validated
@ThreadSafe
public class PrimeNumberController {

	private final PrimeNumberService primeNumberService;

	@Autowired
	public PrimeNumberController(PrimeNumberService primeNumberService) {
		this.primeNumberService = primeNumberService;
	}

	@ApiOperation(value = "Check if number is prime.")
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "Shows if the number is prime.", response = IsPrimeResultDTO.class),
		@ApiResponse(code = 400, message = "The inputed number is smaller than allowed", response = SimpleFieldErrorDTO.class)
	})
	@GetMapping("/check/{number}")
	public IsPrimeResultDTO checkNumberForPrime(@Min(0) @PathVariable("number") int inputNumber) {
		return primeNumberService.checkNumberForPrime(inputNumber);
	}

	@ApiOperation(value = "Returns next prime number or same if input is prime")
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "Returns prime number", response = NextPrimeResultDTO.class),
		@ApiResponse(code = 400, message = "The inputed number is smaller than allowed", response = SimpleFieldErrorDTO.class)
	})
	@GetMapping("/next/{number}")
	public NextPrimeResultDTO getNextPrime(@Min(0) @PathVariable("number") int inputNumber) {
		return primeNumberService.nextPrime(inputNumber);
	}
}