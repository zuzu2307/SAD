import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StringPublisher publisher = new StringPublisher();

        AlphabetSubscriber alphabetSub = new AlphabetSubscriber();
        NumberSubscriber numberSub = new NumberSubscriber();
        SymbolSubscriber symbolSub = new SymbolSubscriber();

        publisher.subscribe(alphabetSub);
        publisher.subscribe(numberSub);
        publisher.subscribe(symbolSub);

        System.out.println("Input your message (Press q or Enter blank to exit).");
        while(true){
            Scanner scanner = new Scanner(System.in);
            System.out.print("Message: ");
            String input = scanner.nextLine();
            if(input.equals("q") || input.length()==0){
                break;
            }

            publisher.publish(input);
        }
        System.out.println("Program stopped");
    }
}