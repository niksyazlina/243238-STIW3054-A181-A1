package myAssignment;

public class assignment1 {

    public static void main(String args[]) {
        try {

            readData read = new readData();
            read.getData();

            writeExcel keep = new writeExcel();
            keep.keepData();

            Thread.sleep(3000);

            //System.out.println("Finished convert");
        } catch (Exception l) {
            l.printStackTrace();
        }
    }
}

    /*public static void main(String args[]){

        MyThread myThread = new MyThread();
        myThread.start();
    } */

/*    static class MyThread extends Thread{

        @Override
        public void run() {
            try{
                readData.ReadData();
                sleep(Common.sleep);
                writeExcel.writeExcel();
                sleep(Common.sleep);
                writeExcel.openExcel();
                sleep(Common.sleep);

            } catch (Exception e){
                e.printStackTrace();
            }
        }
        } */
