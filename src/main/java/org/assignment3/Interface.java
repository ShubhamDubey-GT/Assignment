package org.assignment3;

interface Printable {
    void print();
    String getDetails();
    default void printHeader() {
        System.out.println("---");
    }
}

class Document implements Printable {
    private String content;
    private int pageNum;

    public Document(String content, int pageNum) {
        this.content = content;
        this.pageNum = pageNum;
    }
    public void print() { System.out.println("Printing: " + content); }
    public String getDetails() { return "Doc: " + content + ", Pages: " + pageNum; }
}

public class Interface {
    public static void main(String[] args) {
        Printable doc = new Document("Hello World", 2);
        doc.printHeader();
        doc.print();
        System.out.println(doc.getDetails());
        Printable doc2 = new Document("Test Doc", 1);
        doc2.print();
        System.out.println("Interface with default method usage.");
    }
}
