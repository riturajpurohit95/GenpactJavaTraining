package com.ConsoleLibrary.MiniProject;

import java.util.List;

public class staffMember extends member{
	
	public staffMember(String memberId, String name, List<String> borrowedBooks) {
		super(memberId, name, borrowedBooks);
	}

	@Override
	public int getMaxBooksAllowed() {
		return 5;
	}

}
