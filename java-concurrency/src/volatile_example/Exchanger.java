package volatile_example;

public class Exchanger {

    private Object object = null;
    private volatile boolean hasNewObject = false;

    public void setObject(Object o){
        this.object = o;
        this.hasNewObject = true;
    }

    public Object getObject(){
        while(!this.hasNewObject) {
            // busy wait
        }

        Object returnValue = this.object;
        this.hasNewObject = false;
        return returnValue;
    }
}
