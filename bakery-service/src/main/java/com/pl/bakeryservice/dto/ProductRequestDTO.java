package com.pl.bakeryservice.dto;

import java.math.BigInteger;

public record ProductRequestDTO (String name, BigInteger price) {
}
