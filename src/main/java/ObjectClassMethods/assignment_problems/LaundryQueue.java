package ObjectClassMethods.assignment_problems;

interface WashType {
    int getDuration();
    double getCharge();
}

class QuickWash implements WashType {
    public int getDuration() {
        return 30;
    }

    public double getCharge() {
        return 20;
    }
}

class NormalWash implements WashType {
    public int getDuration() {
        return 45;
    }

    public double getCharge() {
        return 30;
    }
}

class HeavyWash implements WashType {
    public int getDuration() {
        return 60;
    }

    public double getCharge() {
        return 45;
    }
}

class HostelStudent {
    String name;

    public HostelStudent(String name) {
        this.name = name;
    }
}

class WashingMachine {
    String machineName;
    private boolean busy;

    public WashingMachine(String machineName) {
        this.machineName = machineName;
        busy = false;
    }

    public boolean isFree() {
        return !busy;
    }

    public void start() {
        busy = true;
    }

    public void complete() {
        busy = false;
    }
}

class WashCycle {
    HostelStudent student;
    WashingMachine machine;
    WashType wash;

    public WashCycle(HostelStudent student, WashingMachine machine,
                     WashType wash) {
        this.student = student;
        this.machine = machine;
        this.wash = wash;
    }

    public void startWash() {
        if (machine.isFree()) {
            machine.start();

            System.out.println(wash.getClass().getSimpleName()
                    + " started on " + machine.machineName
                    + " for " + student.name + " ("
                    + wash.getDuration() + " min).");

            System.out.printf("Charge: ₹%.2f%n", wash.getCharge());
        } else {
            System.out.println(machine.machineName
                    + " is currently busy.");
        }
    }

    public void completeWash() {
        machine.complete();
        System.out.println(machine.machineName + " cycle completed.");
        System.out.println(machine.machineName + " is now free.");
    }
}

public class LaundryQueue {
    public static void main(String[] args) {

        HostelStudent asha = new HostelStudent("Asha");
        HostelStudent ravi = new HostelStudent("Ravi");
        HostelStudent neha = new HostelStudent("Neha");

        WashingMachine m1 = new WashingMachine("M1");
        WashingMachine m2 = new WashingMachine("M2");

        WashCycle c1 = new WashCycle(asha, m1, new QuickWash());
        c1.startWash();

        WashCycle c2 = new WashCycle(ravi, m1, new HeavyWash());
        c2.startWash();

        WashCycle c3 = new WashCycle(ravi, m2, new HeavyWash());
        c3.startWash();

        c1.completeWash();

        WashCycle c4 = new WashCycle(neha, m1, new NormalWash());
        c4.startWash();
    }
}