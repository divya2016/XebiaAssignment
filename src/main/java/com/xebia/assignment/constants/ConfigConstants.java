package com.xebia.assignment.constants;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class ConfigConstants {
	@Value("${speed}")
	private Integer speed;

	public Integer getSpeed() {
		return speed;
	}

}
