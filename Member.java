public class Member{
    private String name;
    private String memberId;
    private double fine = 0.0;
    private Book[] borrowed = new Book[5];
      private int totalBorrowed=0;
    public Member(String name, String memberId){
        this.name=name;
        this.memberId= memberId;
    }
    
public void borrowBook(Book b,Library lib){
    if (fine >0){
        System.out.println("Pay your pending fine of Rs. " + fine + "first.");
        return;
    }
    if (b.isAvailable()){
        if(totalBorrowed < 5 ){
            b.borrowCopy();
            borrowed[totalBorrowed] = b;
            totalBorrowed++;
            System.out.println(name + "borrowed" +b.getTitle());
        }
    }
}
        public void returnBook(Book b ,int lateDays){
            for (int i=0; i<totalBorrowed; i++) {
                if (borrowed[i] ==b){
                    b.returnCopy();
                    borrowed[i] = borrowed[totalBorrowed-1];
                    borrowed[totalBorrowed-1]=null;
                    totalBorrowed--;
                    if (lateDays>0) {
                        double addedFine= lateDays*50;
                        fine += addedFine;
                        System.out.println("Returned Late. Fine Added: Rs." + addedFine);}
                        else{
                    System.out.println("Returned on Time.");

                        }
                        return;}
                }
                System.out.println("Book not founf in borrowed list.");
            }
            public void payFine() {
                if (fine>0){
                    System.out.println("Fine of Rs. "+fine+ " paid.");
                    fine=0;
                }else{
                    System.out.println("No fine to pay.");
                }
            }
            public void displayMember(){
                System.out.println("Member: "+ name+ " | ID: "+ memberId+ " | Fine: "+ fine);
            }
            public String getName(){
                return name;
            }
            public double getFine(){
                return fine;
            }
            }


    