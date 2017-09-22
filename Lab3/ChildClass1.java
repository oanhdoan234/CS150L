
public class ChildClass1 extends BaseClass
{
    public int someotherdata1 = 0;
    
   public ChildClass1() {
        // Be sure the parent is initialized.
        super();
        someotherdata1 = 1;
   }
    
   public ChildClass1(ChildClass1 obj) {
        // Be sure the parent is initialized.
        super(obj);
        this.someotherdata1 = obj.someotherdata1;
   }

   public boolean equals(ChildClass1 obj) {
        return(super.equals(obj) && this.someotherdata1 == obj.someotherdata1);
   }
}
