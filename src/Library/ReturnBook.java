package Library;

import java.util.Scanner;

public class ReturnBook implements  IOOperation{
    @Override
    public void oper(Database database, User user) {
        System.out.println("Enter the book name");
        Scanner s = new Scanner(System.in);
        String bookname = s.next();
        if(!database.getBrws().isEmpty()){
            for(Borrowing b : database.getBrws()){
                if(b.getBook().getName().matches(bookname) && b.getUser().getName().matches(user.getName())){
                    Book book = b.getBook();
                    int i = database.getAllBooks().indexOf(book);
                    if(b.getDaysLeft()<0){
                        System.out.println("You are late\n" +"You have to pay " + Math.abs(b.getDaysLeft()*50)+ " as fine\n");
                    }
                    book.setBrwcopies(book.getBrwcopies()+1);
                    database.returnBook(b,book,i);
                    System.out.println("Book returned\n Thank you!\n");
                    break;
//                else{
//                    System.out.println("You dont have to pay fine");
//                }
                }else{
                    System.out.println("You didn't borrow this book!\n");

                }
            }

        }else{
            System.out.println("You didn't borrow this book!\n");

        }
        user.menu(database,user);
//    stops here
    }
}
