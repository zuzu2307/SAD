package edu.parinya.softarchdesign.structural;

import java.util.HashSet;
import java.util.Set;

public class HealthcareWorkerTeam implements HealthcareServiceable {

    private Set<HealthcareServiceable> members;

    public HealthcareWorkerTeam(){
        members = new HashSet<>();
    }

    public void addMember(HealthcareServiceable member) {
        this.members.add(member);
    }

    public void removeMember(HealthcareServiceable member) {
        this.members.remove(member);
    }

    @Override
    public void service() {
        for(HealthcareServiceable member : members){
            member.service();
        }
    }

    @Override
    public double getPrice() {
        double totalPrice = 0;
        for(HealthcareServiceable member : members){
            totalPrice += member.getPrice();
        }
        return totalPrice;
    }
}