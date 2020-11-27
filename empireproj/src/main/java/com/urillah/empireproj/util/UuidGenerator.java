package com.urillah.empireproj.util;

import java.util.UUID;

public class UuidGenerator {

	public String generateRandomUuid() {
		UUID randomUuidString = UUID.randomUUID();
		return randomUuidString.toString();
	}
	
}
