import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.Flow;

public class SymbolSubscriber extends StringSubscriber{

    private String dir;

    SymbolSubscriber(){
        this.dir = "src/output/symbol.txt";
    }

    @Override
    public void onSubscribe(Flow.Subscription subscription) {}

    @Override
    public void onNext(String message) {
        System.out.print("SymbolSubscriber received : " + message);

        try {
            FileWriter writer = new FileWriter(this.dir, true);
            BufferedWriter buffer = new BufferedWriter(writer);
            buffer.write(message);
            buffer.newLine();
            buffer.close();
            System.out.println("\nSAVE SYMBOL");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}