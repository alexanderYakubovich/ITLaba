package com.qaprosoft.yakubovichAlexander.junit;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.gen5.api.Test;

import com.qaprosoft.yakubovichAlexander.linkedList.LinkList;

class LinkedListTest  {

	@Test
	void testMethods() {
		LinkList linkedList = mock(LinkList.class);
		linkedList.addFirst(10);
		verify(linkedList).addFirst(10);
	}
}
