import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.Flow;

public class AlphabetSubscriber extends StringSubscriber{

    private String dir;

    AlphabetSubscriber(){
        this.dir = "src/output/alphabet.txt";
    }

    @Override
    public void onSubscribe(Flow.Subscription subscription) {}

    @Override
    public void onNext(String message) {
        System.out.print("AlphabetSubscriber received : " + message);

        try {
            FileWriter writer = new FileWriter(this.dir, true);
            BufferedWriter buffer = new BufferedWriter(writer);
            buffer.write(message);
            buffer.newLine();
            buffer.close();
            System.out.println("\nSAVE ALPHABET");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}