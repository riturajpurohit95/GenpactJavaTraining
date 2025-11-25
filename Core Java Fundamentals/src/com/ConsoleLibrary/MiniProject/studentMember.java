package com.ConsoleLibrary.MiniProject;

import java.util.List;

public class studentMember extends member{
	
	public studentMember(String memberId, String name, List<String> borrowedBooks) {
		super(memberId, name, borrowedBooks);
	}
	
	@Override
	public int getMaxBooksAllowed() {
		return 3;
	}

}
