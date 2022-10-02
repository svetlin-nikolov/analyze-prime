package com.company.analyzeprime.model.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import net.jcip.annotations.ThreadSafe;

/**
 * Result of the get next prime endpoint.
 */
@ThreadSafe
@JsonPropertyOrder({ "inputedNumber", "nextPrime" })
public class NextPrimeResultDTO {

	private final int inputedNumber;
	private final long nextPrime;

	public NextPrimeResultDTO(int inputedNumber, long nextPrime) {
		this.inputedNumber = inputedNumber;
		this.nextPrime = nextPrime;
	}

	public int getInputedNumber() {
		return inputedNumber;
	}

	public long getNextPrime() {
		return nextPrime;
	}
}
