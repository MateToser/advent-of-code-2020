package com.matetoser.adventofcode;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/challanges")
public class ChallangesController {

	@GetMapping("/dayone")
	public void dayOne() {
		// todo
	}

}