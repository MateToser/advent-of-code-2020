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

	@PostMapping("/day-two/part-one")
	public Integer dayTwoPartOne(@RequestBody String input) {
		List<String> entries = Arrays.stream(input.split("\n")).collect(Collectors.toList());
		int counter = 0;
		for (String entry : entries) {
			List<String> parts = Arrays.stream(entry.split(" ")).collect(Collectors.toList());
			String[] length = parts.get(0).split("-");
			String character = parts.get(1).replace(":", "");
			String password = parts.get(2);
			int chars = password.length() - password.replaceAll(character, "").length();
			if (chars <= Integer.parseInt(length[1]) && chars >= Integer.parseInt(length[0])) {
				counter++;
			}
		}
		return counter;
	}

}