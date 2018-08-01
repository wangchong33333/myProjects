package com.mrwang.b_di;

public class BookServiceImpl implements BookService {
	private BookDao bookDao;

	public void setBookDao(BookDao bookDao) {
		this.bookDao = bookDao;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.mrwang.di.BookService#addBook()
	 */
	@Override
	public void addBook() {
		bookDao.addBook();
	}
}
