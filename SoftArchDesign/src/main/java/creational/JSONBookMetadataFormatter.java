package creational;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;

import java.io.IOException;
import java.io.StringWriter;

public class JSONBookMetadataFormatter implements BookMetadataFormatter {

    JSONObject bookObj;
    JSONArray bookArr;

    public JSONBookMetadataFormatter() {
        reset();
    }

    @Override
    public BookMetadataFormatter reset() {
        // Please implement this method. You may create additional methods as you see fit.
        bookObj = new JSONObject();
        bookArr = new JSONArray();
        bookObj.put(Book.class.getSimpleName()+"s", bookArr);
        return this;
    }

    @Override
    public BookMetadataFormatter append(Book b) {
        // Please implement this method. You may create additional methods as you see fit.
        JSONObject newBook = new JSONObject();
        JSONArray newAuthors = new JSONArray();
        for(String author : b.getAuthors()){
            newAuthors.add(author);
        }

        newBook.put(Book.Metadata.ISBN.value,b.getISBN());
        newBook.put(Book.Metadata.AUTHORS.value, newAuthors);
        newBook.put(Book.Metadata.TITLE.value,b.getTitle());
        newBook.put(Book.Metadata.PUBLISHER.value,b.getPublisher());

        bookArr.add(newBook);
        return this;
    }

    @Override
    public String getMetadataString() {
        // Please implement this method. You may create additional methods as you see fit.
        return bookObj.toString();
    }
}
