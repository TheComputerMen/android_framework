package com.jd.framework.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class JListKit {

	public static <E> List<E> newArrayList() {
		return new ArrayList<E>();
	}
	
	public static <E> List<E> newArrayList(E... elements) {
		ArrayList<E> list = new ArrayList<E>();
		Collections.addAll(list, elements);
		return list;
	}
	
	public static <E> List<E> newArrayListWithCapacity(int capacity) {
		return new ArrayList<E>(capacity);
	}

	public static <E> List<E> newLinkedList() {
		return new LinkedList<E>();
	}

	public static <E> boolean isNotEmpty(List<E> list) {
		if (list == null || list.size() == 0) {
			return false;
		} else {
			return true;
		}
	}
}
