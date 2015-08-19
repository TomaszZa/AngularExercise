package pl.spring.demo.mapper;

import java.util.List;
import java.util.stream.Collectors;

import pl.spring.demo.entity.BookEntity;
import pl.spring.demo.to.BookTo;

public class BookMapper {

	public static BookTo map(BookEntity bookEntity) {
		if (bookEntity != null) {

			return new BookTo(bookEntity.getId(), bookEntity.getTitle(), changeListOfAuthorsToString(bookEntity));
		}
		return null;
	}

	public static BookEntity map(BookTo bookTo) {
		if (bookTo != null) {
			return new BookEntity(bookTo.getId(), bookTo.getTitle()); // brakuje
																		// authora
		}
		return null;
	}

	public static List<BookTo> map2To(List<BookEntity> bookEntities) {
		return bookEntities.stream().map(BookMapper::map).collect(Collectors.toList());
	}

	public static List<BookEntity> map2Entity(List<BookTo> bookEntities) {
		return bookEntities.stream().map(BookMapper::map).collect(Collectors.toList());
	}

	private static String changeListOfAuthorsToString(BookEntity bookEntity) {
		return bookEntity.getAuthors().get(0).getFirstName() + " " + bookEntity.getAuthors().get(0).getLastName();
	}
}
