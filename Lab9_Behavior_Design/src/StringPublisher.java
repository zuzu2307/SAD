import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Flow;

public class StringPublisher implements Flow.Publisher<String> {

    private Set<Flow.Subscriber> subs;

    StringPublisher(){
        subs = new HashSet<>();
    }

    @Override
    public void subscribe(Flow.Subscriber<? super String> sub) {
        subs.add(sub);
    }

    public void publish(String message){
        for(Flow.Subscriber sub: this.subs){

            boolean isAlphabet = message.matches(".*[a-zA-Z].*");
            boolean isNumber = message.matches(".*\\d.*");
            boolean isSymbol = !message.matches("[a-zA-Z0-9]+");

            if(isAlphabet && sub instanceof AlphabetSubscriber){
                sub.onNext(message);
            }

            if(isNumber && sub instanceof NumberSubscriber){
                sub.onNext(message);
            }

            if(isSymbol && sub instanceof SymbolSubscriber){
                sub.onNext(message);
            }


        }
    }
}