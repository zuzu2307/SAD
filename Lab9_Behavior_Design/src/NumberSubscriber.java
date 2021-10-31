import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.Flow;

public class NumberSubscriber extends StringSubscriber{

    private String dir;

    NumberSubscriber(){
        this.dir = "src/output/number.txt";
    }

    @Override
    public void onSubscribe(Flow.Subscription subscription) {}

    @Override
    public void onNext(String message) {
        System.out.print("NumberSubscriber received : " + message);

        try {
            FileWriter writer = new FileWriter(this.dir, true);
            BufferedWriter buffer = new BufferedWriter(writer);
            buffer.write(message);
            buffer.newLine();
            buffer.close();
            System.out.println("\nSAVE NUMBER");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}