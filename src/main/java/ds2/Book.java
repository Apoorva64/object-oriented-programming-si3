package ds2;

import java.util.Objects;
import java.util.Optional;

public class Book implements Identifiable, Matchable {

    private String title;
    private String author;
    private final int year;
    private String isbn;


    public Book(String title, String author, int year, String isbn) {

        this.year = year;
        if (title == null || title.equals("undefined")) {
            this.title = null;
        } else {
            this.title = title;
        }
        if (author == null || author.equals("unknown")) {
            this.author = null;
        } else {
            this.author = author;
        }

        if (isbn == null || isbn.equals("unknown")) {
            this.isbn = null;
        } else {
            this.isbn = isbn;
        }
    }

    public Book(String title, String author, int year) {
        this(title, author, year, null);
    }

    public String getTitle() {
        if (title == null) {
            return "undefined";
        }
        return title;
    }

    public String getAuthor() {
        if (author == null) {
            return "unknown";
        }
        return author;
    }

    public int getYear() {
        return year;
    }

    @Override
    public String getId() {
        if (isbn == null) {
            return "unknown";
        }
        return isbn;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        if (isbn == null) {
            return Objects.equals(title, book.title) &&
                    Objects.equals(author, book.author);
        }
        return Objects.equals(isbn, book.isbn);
    }

    /* ---- METHODES QUI VOUS SONT DONNEES -- NE PAS MODIFIER -------- */
    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + this.getId().hashCode();
        result = 31 * result + this.getTitle().hashCode();
        result = 31 * result + this.getAuthor().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + getTitle() + '\'' +
                ", author='" + getAuthor() + '\'' +
                ", year=" + getYear() +
                ", isbn='" + getId() + '\'' +
                '}';
    }

    @Override
    public boolean match(String query) {
        return this.getTitle().contains(query) ||
                this.getAuthor().contains(query) ||
                this.getId().contains(query) || Integer.toString(this.getYear()).contains(query);
    }

    public void setTitle(String s) {
        this.title = s;
    }

    public Book(Book b) {
        this.title = b.title;
        this.author = b.author;
        this.year = b.year;
        this.isbn = b.isbn;
    }

    public Book copy() {
        return new Book(this);

    }

    public Optional<Book> merge(Book other) {
        if (!this.equals(other)) {
            return Optional.empty();
        }
        Book result = new Book(this);
        if (other.isbn != null) {
            result.isbn = other.isbn;
        }
        if (this.title == null && other.title != null) {
            result.title = other.title;
        }
        if (other.title != null && this.title != null) {
            if (this.title.contains(other.title)) {
                result.title = this.title;
            } else if (other.title.contains(this.title)) {
                result.title = other.title;
            } else {
                result.title = this.title + " or " + other.title;
            }
        }
        if (this.author == null && other.author != null) {
            result.author = other.author;
        }

        if (other.author != null && this.author != null) {
            if (this.author.contains(other.author)) {
                result.author = this.author;
            } else if (other.author.contains(this.author)) {
                result.author = other.author;
            } else {
                result.author = this.author + " or " + other.author;
            }
        }
        return Optional.of(result);

    }
}
