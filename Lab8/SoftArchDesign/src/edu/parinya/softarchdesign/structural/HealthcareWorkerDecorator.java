package edu.parinya.softarchdesign.structural;

public class HealthcareWorkerDecorator extends HealthcareWorker{
    protected HealthcareServiceable worker;

    public HealthcareWorkerDecorator (HealthcareWorker worker){
        super(worker);
        this.worker = worker;
    }

    @Override
    public void service() {
        this.worker.service();
    }

    public double getPrice() {
        return this.worker.getPrice();
    }
}
