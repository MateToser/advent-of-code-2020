package com.matetoser.adventofcode;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/challenges")
public class ChallengesController {

	@PostMapping("/day-one/part-one")
	public Integer dayOnePartOne(@RequestBody String input) {
		List<Integer> entries = Arrays.stream(input.split("\n")).map(Integer::new).collect(Collectors.toList());
		int curr;
		for (int i = 0; i < entries.size(); i++) {
			curr = entries.get(i);
			for (int j = 0; j < entries.size(); j++) {
				if (curr + entries.get(j) == 2020) {
					return curr * entries.get(j);
				}
			}
		}
		return null;
	}

	@PostMapping("/day-one/part-two")
	public Integer dayOnePartTwo(@RequestBody String input) {
		List<Integer> entries = Arrays.stream(input.split("\n")).map(Integer::new).collect(Collectors.toList());
		int currI;
		int currJ;
		for (int i = 0; i < entries.size(); i++) {
			currI = entries.get(i);
			for (int j = 0; j < entries.size(); j++) {
				currJ = entries.get(j);
				for (int k = 0; k < entries.size(); k++) {
					if (currI + currJ + entries.get(k) == 2020) {
						return currI * currJ * entries.get(k);
					}
				}
			}
		}
		return null;
	}

}