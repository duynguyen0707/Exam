package Entities;

public class Student {
    private String id;
    private String name;
    private String email;
    private double bonus;
    private double report;
    private double app;
    private double lt;
    private double tk;

    public Student(String id, String name, String email, double bonus, double report, double app, double lt) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.bonus = bonus;
        this.report = report;
        this.app = app;
        this.lt = lt;
    }

    public double tongket() {
        return 0.1 * bonus + 0.3 * report + 0.15 * app + 0.45 * lt;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public double getBonus() {
        return bonus;
    }

    public double getReport() {
        return report;
    }

    public double getApp() {
        return app;
    }

    public double getLt() {
        return lt;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Student{");
        sb.append("id='").append(id).append('\'');
        sb.append(", name='").append(name).append('\'');
        sb.append(", email='").append(email).append('\'');
        sb.append(", bonus=").append(bonus);
        sb.append(", report=").append(report);
        sb.append(", app=").append(app);
        sb.append(", lt=").append(lt);
        sb.append('}');
        return sb.toString();
    }
}
