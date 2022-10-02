package com.company.analyzeprime.service;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import com.company.analyzeprime.model.dto.IsPrimeResultDTO;
import com.company.analyzeprime.model.dto.NextPrimeResultDTO;
import com.company.analyzeprime.service.PrimeNumberService;

@RunWith(MockitoJUnitRunner.class)
public class PrimeNumberServiceTest {

	@InjectMocks
	private PrimeNumberService primeNumberService;

	@Test
	public void checkPrime_whenNumberIsNotPrime_itReturnsObjectWithFalse() {
		int inputedNumber = 25;

		IsPrimeResultDTO result = primeNumberService.checkNumberForPrime(inputedNumber);

		assertEquals(inputedNumber, result.getInputedNumber());
		assertEquals(false, result.isPrime());
	}

	@Test
	public void checkPrime_whenNumberIsPrime_itReturnsObjectWithTrue() {
		int inputedNumber = 7;

		IsPrimeResultDTO result = primeNumberService.checkNumberForPrime(inputedNumber);

		assertEquals(inputedNumber, result.getInputedNumber());
		assertEquals(true, result.isPrime());
	}

	@Test
	public void checkPrime_whenNumberIsDivisibleByTwo_itReturnsObjectWithFalse() {
		int inputedNumber = 4;

		IsPrimeResultDTO result = primeNumberService.checkNumberForPrime(inputedNumber);

		assertEquals(inputedNumber, result.getInputedNumber());
		assertEquals(false, result.isPrime());
	}

	@Test
	public void checkPrime_whenNumberIsDivisibleByThree_itReturnsObjectWithFalse() {
		int inputedNumber = 9;

		IsPrimeResultDTO result = primeNumberService.checkNumberForPrime(inputedNumber);

		assertEquals(inputedNumber, result.getInputedNumber());
		assertEquals(false, result.isPrime());
	}
	
	@Test
	public void checkPrime_whenNumberIsNotPrimeAndFoundViaIPlusTwoCase_itReturnsObjectWithFalse() {
		int inputedNumber = 49;

		IsPrimeResultDTO result = primeNumberService.checkNumberForPrime(inputedNumber);

		assertEquals(inputedNumber, result.getInputedNumber());
		assertEquals(false, result.isPrime());
	}

	@Test
	public void checkPrime_whenNumberIsZero_itReturnsObjectWithFalse() {
		int inputedNumber = 0;

		IsPrimeResultDTO result = primeNumberService.checkNumberForPrime(inputedNumber);

		assertEquals(inputedNumber, result.getInputedNumber());
		assertEquals(false, result.isPrime());
	}

	@Test
	public void checkPrime_whenNumberIsOne_itReturnsObjectWithFalse() {
		int inputedNumber = 1;

		IsPrimeResultDTO result = primeNumberService.checkNumberForPrime(inputedNumber);

		assertEquals(inputedNumber, result.getInputedNumber());
		assertEquals(false, result.isPrime());
	}

	@Test
	public void checkPrime_whenNumberIsTwo_itReturnsObjectWithTrue() {
		int inputedNumber = 2;

		IsPrimeResultDTO result = primeNumberService.checkNumberForPrime(inputedNumber);

		assertEquals(inputedNumber, result.getInputedNumber());
		assertEquals(true, result.isPrime());
	}

	@Test
	public void checkPrime_whenNumberIsThree_itReturnsObjectWithTrue() {
		int inputedNumber = 3;

		IsPrimeResultDTO result = primeNumberService.checkNumberForPrime(inputedNumber);

		assertEquals(inputedNumber, result.getInputedNumber());
		assertEquals(true, result.isPrime());
	}

	@Test
	public void checkPrime_whenNumberIsIntegerMaxSize_itReturnsObjectWithTrue() {
		int inputedNumber = Integer.MAX_VALUE;

		IsPrimeResultDTO result = primeNumberService.checkNumberForPrime(inputedNumber);

		assertEquals(inputedNumber, result.getInputedNumber());
		assertEquals(true, result.isPrime());
	}

	@Test
	public void nextPrime_whenNumberIsZero_itReturnsObjectWithNextPrime() {
		int inputedNumber = 0;

		NextPrimeResultDTO result = primeNumberService.nextPrime(inputedNumber);

		assertEquals(inputedNumber, result.getInputedNumber());
		assertEquals(2l, result.getNextPrime());
	}

	@Test
	public void nextPrime_whenNumberIsOne_itReturnsObjectWithNextPrime() {
		int inputedNumber = 1;

		NextPrimeResultDTO result = primeNumberService.nextPrime(inputedNumber);

		assertEquals(inputedNumber, result.getInputedNumber());
		assertEquals(2l, result.getNextPrime());
	}

	@Test
	public void nextPrime_whenNumberIsPrime_itReturnsObjectWithSameNumber() {
		int inputedNumber = 2;

		NextPrimeResultDTO result = primeNumberService.nextPrime(inputedNumber);

		assertEquals(inputedNumber, result.getInputedNumber());
		assertEquals(inputedNumber, result.getNextPrime());
	}

	@Test
	public void nextPrime_whenNumberIsNotPrimeAndItIsEven_itReturnsObjectWithNextPrime() {
		int inputedNumber = 4;

		NextPrimeResultDTO result = primeNumberService.nextPrime(inputedNumber);

		assertEquals(inputedNumber, result.getInputedNumber());
		assertEquals(5l, result.getNextPrime());
	}

	@Test
	public void nextPrime_whenNumberIsNotPrimeAndItIsOdd_itReturnsObjectWithNextPrime() {
		int inputedNumber = 15;

		NextPrimeResultDTO result = primeNumberService.nextPrime(inputedNumber);

		assertEquals(inputedNumber, result.getInputedNumber());
		assertEquals(17l, result.getNextPrime());
	}

	@Test
	public void nextPrime_whenNumberIsNotPrime_itReturnsObjectWithNextPrime() {
		int inputedNumber = 25;

		NextPrimeResultDTO result = primeNumberService.nextPrime(inputedNumber);

		assertEquals(inputedNumber, result.getInputedNumber());
		assertEquals(29, result.getNextPrime());
	}

}
