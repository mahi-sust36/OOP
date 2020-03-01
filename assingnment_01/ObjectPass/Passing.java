package ObjectPass;


public class Passing {
    
   int size=13;
   String Text="ABCD";
   public Passing(){
   System.out.println("Size= "+size+", Text = "+Text);
   }
   
   public Passing(int size,String Text){
       this.size=size;
       this.Text=Text;
       System.out.println("Size= "+this.size+", Text = "+this.Text);
   }
   
   
  public Passing(Passing Display){
      this.size=Display.size;
      this.Text=Display.Text;
      System.out.println("Size= "+this.size+", Text = "+this.Text);
  }
    
}
