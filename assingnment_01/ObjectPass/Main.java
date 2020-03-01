package ObjectPass;

public class Main {
    
    public static void main(String[] args){
           
            System.out.println("Type 1:");
            Passing pass_1=new Passing();
            
            System.out.println("Type 2:") ;
           
            Passing pass_2=new Passing(13,"ABCD");
            
            System.out.println("Type 3:");
            
            Passing pass_3=new Passing(pass_1) ;
    
}
