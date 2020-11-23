public class Data extends Item {

 private int num;

 public Data(int a){
     num = a;
 }

    @Override
    public boolean isData() {
        return true;
    }

    @Override
    public int getValue() {
        return num;
    }
}
