package com.company.analyzeprime.service;

import org.springframework.stereotype.Service;

import com.company.analyzeprime.model.dto.IsPrimeResultDTO;
import com.company.analyzeprime.model.dto.NextPrimeResultDTO;

import net.jcip.annotations.ThreadSafe;

/**
* Service that checks if a number is prime and also returns next prime.
*/
@ThreadSafe
@Service
public class PrimeNumberService {

	/**
	 * Checks if the number is prime.
	 * @param number - the number to be checked for prime.
	 * @return IsPrimeResult containing the inputed number and boolean telling if the number is prime or not.
	 */
	public IsPrimeResultDTO checkNumberForPrime(int number) {
		boolean isNumberPrime = isPrime(number);
		return new IsPrimeResultDTO(number, isNumberPrime);
	}
	
	/**
	 * Find the next prime or returns the same number if prime.
	 * @param number - the number to be used as base.
	 * @return NextPrimeResult containing the inputed number and next prime.
	 */
	public NextPrimeResultDTO nextPrime(int number) {
		long nextPrime = findNextPrime(number);
		return new NextPrimeResultDTO(number, nextPrime);
	}

	/**
	 * Checks if the number is prime.
	 * @param number - the number to be checked for prime.
	 * @return true if number is prime, false if it is not.
	 */
	private boolean isPrime(int number) {
	    if(number == 0 || number == 1) {
	    	return false;
	    }
	    if(number == 2 || number == 3) {
	    	return true;
	    }
	    if(number % 2 == 0 || number % 3 == 0) {
	    	return false;
	    }
	    for(long i = 5; i * i <= number; i += 6) {
	        if(number % i == 0 || number % (i + 2) == 0) {
	        	return false;
	        }
	    }
	    return true;
	}

	/**
	 * Find the prime after the specified number or return the same if input is prime.
	 * @param number - the number to be checked.
	 * @return the next prime or same number.
	 */
	private long findNextPrime(int number) {
		if(number == 0 || number == 1) {
			return 2;
		}
		if(isPrime(number)) {
			return number;
		}
		if(number % 2 == 0) {
			number++;
		} else {
			number += 2;
		}
		while(!isPrime(number)) {
			number += 2;
		}
		return number;
	}
}
