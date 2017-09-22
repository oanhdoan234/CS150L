
public class BaseClass
{
    protected int somedata = 0;
    
    public BaseClass(){
        somedata = 1;
    }
    
    public BaseClass(BaseClass obj){
        this.somedata = obj.somedata;
    }
    
    public boolean equals(BaseClass obj) {
        if (this.somedata == obj.somedata) {
            return true;
        } else {
            return false;
        }
    }
}
