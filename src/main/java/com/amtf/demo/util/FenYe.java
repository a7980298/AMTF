package com.amtf.demo.util;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FenYe {

	private int count;
	private int current = 1;
	private int frequency;
	private int pages;
	private List<?> fenyeList;
}