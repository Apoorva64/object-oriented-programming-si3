package ds2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Library extends ItemDictionnary<Book> {

    List<Book> addedBooks = new ArrayList<>();

    public Optional<Book> mergeBooks(Book book1) {
        if (book1 == null) {
            return Optional.empty();
        }
        if (this.containsKey(book1.getId())) {
            List<Book> bookList = this.get(book1.getId());
            Book mergedBook = book1.copy();
            for (Book book : bookList) {
                Optional<Book> mergedBook2 = mergedBook.merge(book);
                if (mergedBook2.isPresent()) {
                    mergedBook = mergedBook2.get();
                } else {
                    return Optional.of(book1);
                }
            }
            return Optional.of(mergedBook);
        }
        return Optional.of(book1);
    }

    @Override
    public void addItem(Book book) {
        if (book != null) {
            this.addedBooks.add(book);
            super.addItem(book);
        }
    }

    @Override
    public boolean removeItem(Book book) {
        if (book != null) {
            for (int i = 0; i < addedBooks.size(); i++) {
                if (addedBooks.get(i) == book) {
                    addedBooks.remove(i);
                    break;
                }
            }
            super.removeItem(book);
        }
        return false;
    }

    public List<Book> getAllBooks() {
        return new java.util.ArrayList<>(this.keySet().stream().map(this::get).flatMap(List::stream).collect(Collectors.toCollection(ArrayList::new)));
    }

    public List<Book> sortByTitle() {
        List<Book> bookList = getAllBooks();
        bookList.sort(Comparator.comparing(Book::getTitle));
        return bookList;
    }


    public List<Book> sortByAuthor() {
        List<Book> bookList = getAllBooks();
        bookList.sort(Comparator.comparing(Book::getAuthor));
        return bookList;
    }

    public List<Book> listAddedBooks() {
        return new ArrayList<>(addedBooks);
    }
}
